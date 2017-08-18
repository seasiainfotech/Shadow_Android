package com.android.shadow.presenter;

import android.content.Intent;

import com.android.shadow.R;
import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.model.input.GetAvailableCompanyListInput;
import com.android.shadow.model.output.GetAvailableCompanyListResponse;
import com.android.shadow.utils.PreferenceKeys;
import com.android.shadow.utils.SharedPrefsHelper;
import com.android.shadow.views.auth.LoginActivity;
import com.android.shadow.views.core.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by singhgharjyot on 7/21/2017.
 */

public class CompanyListPresenter {
    public SharedPrefsHelper sharedPrefsHelper;
    private BaseActivity baseActivity;
    CompanyCallback companyCallback;

    public CompanyListPresenter(BaseActivity baseActivity, CompanyCallback companyCallback){
      this.baseActivity=baseActivity;
        this.companyCallback=companyCallback;
    }


    public interface CompanyCallback {

        void onCompanySuccess(GetAvailableCompanyListResponse response);
    }


    public void callCompanyAPi() {
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(baseActivity);
        String userId = sharedPrefsHelper.get(PreferenceKeys.PREF_USER_ID);
        GetAvailableCompanyListInput getAvailableCompanyListInput = new GetAvailableCompanyListInput();
        getAvailableCompanyListInput.setUserId(userId);
        getAvailableCompanyListInput.setSearchKeyword("");
        getCompanyList(getAvailableCompanyListInput);
    }

    private void getCompanyList(GetAvailableCompanyListInput getAvailableCompanyListInput) {
        Call<GetAvailableCompanyListResponse> editProfileResponseCall = GetRestAdapter.getRestAdapter(false).getAvailCompList(getAvailableCompanyListInput);
        editProfileResponseCall.enqueue(new Callback<GetAvailableCompanyListResponse>() {
            @Override
            public void onResponse(Call<GetAvailableCompanyListResponse> call, Response<GetAvailableCompanyListResponse> response) {

                if (response != null && response.body() != null) {
                    if (response.body().getStatus().equals("200")) {
                        companyCallback.onCompanySuccess(response.body());

                    } else if (response.body().getStatus().equals("401")) {
                        sharedPrefsHelper.clearAll();
                        Intent intent = new Intent(baseActivity, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        baseActivity.startActivity(intent);
                        baseActivity.finish();
                    } else {
                        baseActivity.showToast(response.body().getMessage());
                    }
                } else {
                    baseActivity.showToast(R.string.server_error_msg);
                }
            }

            @Override
            public void onFailure(Call<GetAvailableCompanyListResponse> call, Throwable t) {
                baseActivity.showToast(t.getMessage());
            }
        });
    }
}

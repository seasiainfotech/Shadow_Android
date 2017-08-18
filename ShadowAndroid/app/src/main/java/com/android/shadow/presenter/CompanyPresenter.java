package com.android.shadow.presenter;

import android.text.TextUtils;

import com.android.shadow.R;
import com.android.shadow.api.AddressApi;
import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.model.input.CheckCompanyInput;
import com.android.shadow.model.output.UsernameResponse;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.core.BaseActivity;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class is used to check  validations and check the location validation
 * using {@link AddressApi} and then call the school api
 *
 * @author jindaldipanshu
 * @version 1.0
 */


public class CompanyPresenter implements AddressApi.AddressValidator {
    private BaseActivity mBaseActivity;
    private CompanyCallback mCompanyCallback;

    public CompanyPresenter(BaseActivity baseActivity, CompanyCallback companyCallback) {
        mBaseActivity = baseActivity;
        mCompanyCallback = companyCallback;
    }

    public interface CompanyCallback {
        void onSuccess(String lat);
    }

    public void checkValidations(String name, String location) {
        if (TextUtils.isEmpty(name)) {
            return;
        } else if (name.length() < 4) {
            mBaseActivity.showToast("Please enter company name");
        } else if (TextUtils.isEmpty(location)) {
            return;
        } else {
            if (!Utilities.checkInternet(mBaseActivity)) {
                mBaseActivity.showToast(R.string.no_internet_msg);
            } else {
                CheckCompanyInput checkCompanyInput = new CheckCompanyInput();
                checkCompanyInput.setCompanyName(name);
                checkResponse(checkCompanyInput);
            }
        }
    }

    @Override
    public void onSuccess(JSONObject jsonObject) {
        mCompanyCallback.onSuccess("");
    }

    private void checkResponse(CheckCompanyInput checkCompanyInput) {

        mBaseActivity.showDialog();
        final Call<UsernameResponse> re = GetRestAdapter.getRestAdapter(false).checkAvailablityOfCompany(checkCompanyInput);

        re.enqueue(new Callback<UsernameResponse>() {
            @Override
            public void onResponse(Call<UsernameResponse> call, Response<UsernameResponse> response) {
                mBaseActivity.hideDialog();
                if (response != null && response.body() != null) {
                    if (response.body().getStatus().equals("404")) {
                        mCompanyCallback.onSuccess("");
                    } else {
                        mBaseActivity.showToast(response.body().getMessage());
                    }
                } else {
                    mBaseActivity.showToast("server error.Please try again");
                }
            }

            @Override
            public void onFailure(Call<UsernameResponse> call, Throwable t) {
                mBaseActivity.hideDialog();
                mBaseActivity.showToast(t.getMessage());
            }
        });
    }
}

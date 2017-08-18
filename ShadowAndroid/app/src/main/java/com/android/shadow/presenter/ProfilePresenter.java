package com.android.shadow.presenter;

import android.content.Intent;
import android.util.Log;

import com.android.shadow.R;
import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.model.input.EmailForgotPasswordInput;
import com.android.shadow.model.input.GetProfileInput;
import com.android.shadow.model.output.GetAvailableCompanyListResponse;
import com.android.shadow.model.output.GetProfileResponse;
import com.android.shadow.utils.ProgressUtility;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.auth.LoginActivity;
import com.android.shadow.views.core.BaseFragment;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by singhgharjyot on 6/6/2017.
 */

public class ProfilePresenter {

    private ProfileCallback mProfileCallBack;
    private BaseFragment baseFragment;

    public interface ProfileCallback {
        void onProfileSuccess(retrofit2.Response<GetProfileResponse> responseResponse);
    }



    public ProfilePresenter(BaseFragment baseFragment, ProfileCallback profileCallback) {
        this.mProfileCallBack = profileCallback;
        this.baseFragment = baseFragment;
    }

    public void checkValidations(String... params) {
        String userId = params[0];
        if (!Utilities.checkInternet(baseFragment.activity)) {
            baseFragment.showToast(R.string.no_internet_msg);
        } else {
            GetProfileInput getProfileInput = new GetProfileInput();
            getProfileInput.setUserId(userId);
            responseCheck(getProfileInput);
        }
    }

    public void otherUserProfile(String... params) {
        String userId = params[0];
        String otherUserId=params[1];
        if (!Utilities.checkInternet(baseFragment.activity)) {
            baseFragment.showToast(R.string.no_internet_msg);
        } else {
            GetProfileInput getProfileInput = new GetProfileInput();
            getProfileInput.setUserId(userId);
            getProfileInput.setOtherUserId(otherUserId);
            responseCheck(getProfileInput);
        }
    }


    private void responseCheck(GetProfileInput getProfileInput) {
        Gson gson = new Gson();
        String json = gson.toJson(getProfileInput, GetProfileInput.class);
        Log.e("GetProfileInput--", json);
        //baseFragment.showDialog();
        ProgressUtility.showProgress(baseFragment.getBaseActivity(),"Please wait....");
        Call<GetProfileResponse> response = GetRestAdapter.getRestAdapter(true).getProfile(getProfileInput);
        response.enqueue(new Callback<GetProfileResponse>() {
            @Override
            public void onResponse(Call<GetProfileResponse> call, retrofit2.Response<GetProfileResponse> response) {
                Gson gson = new Gson();
                String json = gson.toJson(response.body(), GetProfileResponse.class);
                Log.e("GetProfileResponse--", json);
                ProgressUtility.dismissProgress();
                baseFragment.hideDialog();
                mProfileCallBack.onProfileSuccess(response);
            }

            @Override
            public void onFailure(Call<GetProfileResponse> call, Throwable t) {
                //baseFragment.hideDialog();
                ProgressUtility.dismissProgress();
                baseFragment.showToast(t.getLocalizedMessage());
            }
        });
    }

}

package com.android.shadow.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.android.shadow.R;
import com.android.shadow.ShadowApp;
import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.model.input.SignupInput;
import com.android.shadow.model.output.SignupResponse;
import com.android.shadow.utils.PreferenceKeys;
import com.android.shadow.utils.SharedPrefsHelper;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.core.BaseActivity;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jindaldipanshu on 5/26/2017.
 */

public class SignUpPresenter {

    private final SignUpCallback mSIgnUpCallback;
    private final BaseActivity mBaseActivity;
    private SharedPrefsHelper sharedPrefsHelper;

    public interface SignUpCallback {
        void onSignUpSuccess(SignupInput signupInput, boolean isEmail);
    }

    public SignUpPresenter(BaseActivity baseActivity, SignUpCallback loginCallback) {
        this.mSIgnUpCallback = loginCallback;
        this.mBaseActivity = baseActivity;
    }


    public void checkEmailValidation(String email, Bundle bundle) {
        if (!TextUtils.isEmpty(email) && Utilities.isValidEmail(email)) {
            sharedPrefsHelper = new SharedPrefsHelper(mBaseActivity);
            SignupInput signupInput = new SignupInput();
            signupInput.setEmail(email);
            signupInput.setPhoneOtp("false");
            signupInput.setEmailOtp("true");
            setSignUpInput(signupInput, bundle, true);
        } else if (TextUtils.isEmpty(email) || !Utilities.isValidEmail(email)) {
            mBaseActivity.showToast("Please enter a valid email");
        }
    }

    public void checkPhoneValidation(String phoneNumber, String countryCode, Bundle bundle) {
        if (!TextUtils.isEmpty(phoneNumber) && phoneNumber.length() > 9) {
            sharedPrefsHelper = new SharedPrefsHelper(mBaseActivity);
            SignupInput signupInput = new SignupInput();
            signupInput.setMobileNumber(phoneNumber);
            signupInput.setPhoneOtp("true");
            signupInput.setEmailOtp("false");
            signupInput.setCountryCode(countryCode);
            setSignUpInput(signupInput, bundle, false);
        } else if (TextUtils.isEmpty(phoneNumber) || phoneNumber.length() < 10) {
            mBaseActivity.showToast("Please enter a valid phone number");
        }
    }


    private void setSignUpInput(SignupInput signupInput, Bundle mBundle, boolean isEmail) {
        String regist = sharedPrefsHelper.get(PreferenceKeys.PREF_REGIS);
        String username = mBundle.getString(PreferenceKeys.PREF_USER_NAME);
        String password = mBundle.getString(PreferenceKeys.PREF_PASSWORD);
        signupInput.setUserName(username);
        signupInput.setPassword(password);
        signupInput.setAppVersion(mBaseActivity.APP_NUMBER);
        signupInput.setAppBuildNumber(mBaseActivity.APP_BUILD_NUMBER);

        if (regist.contains("user")) {
            String firstName = mBundle.getString(PreferenceKeys.PREF_USER_FIRST_NAME);
            String lastName = mBundle.getString(PreferenceKeys.PREF_USER_LAST_NAME);
            String yesSelected = mBundle.getString(PreferenceKeys.PREF_YES_SELECTED);
            signupInput.setRole("USER");
            signupInput.setFirstName(firstName);
            signupInput.setLastName(lastName);
            signupInput.setLatitude("");//TODO add latlongs for user also
            signupInput.setLongitude("");
            signupInput.setSchoolName("");
            signupInput.setCompanyName("");
            signupInput.setLocation("");
            signupInput.setOtherUsersShadowYou(yesSelected);

        } else if (regist.contains("school")) {
            String schoolName = mBundle.getString(PreferenceKeys.PREF_USER_SCHOOL_NAME);
            signupInput.setRole("SCHOOL");
            signupInput.setFirstName("");
            signupInput.setLastName("");
            signupInput.setLatitude("");
            signupInput.setLongitude("");
            signupInput.setSchoolName(schoolName);
            signupInput.setCompanyName("");
            signupInput.setLocation("");
            signupInput.setOtherUsersShadowYou("");

        } else if (regist.contains("company")) {
            String companyName = mBundle.getString(PreferenceKeys.PREF_USER_COMPANYT_NAME);
            String location = mBundle.getString(PreferenceKeys.PREF_LOCATION);
            String latitude = mBundle.getString(PreferenceKeys.PREF_LAT);
            String longitude = mBundle.getString(PreferenceKeys.PREF_LONG);

            signupInput.setRole("COMPANY");
            signupInput.setFirstName("");
            signupInput.setLastName("");
            signupInput.setLatitude(latitude);
            signupInput.setLongitude(longitude);
            signupInput.setSchoolName("");
            signupInput.setCompanyName(companyName);
            signupInput.setOtherUsersShadowYou("");
            signupInput.setLocation(location);
        }
        if (Utilities.checkInternet(mBaseActivity)) {
            responseCheck(signupInput, isEmail);
        } else {
            mBaseActivity.showToast(R.string.no_internet_msg);
        }
    }

    private void responseCheck(final SignupInput loginInput, final boolean isEmail) {
        mBaseActivity.showDialog();
        Gson gson = new Gson();
        String jsonRes = gson.toJson(loginInput, SignupInput.class);
        Log.e("signupInput--", jsonRes);

        Call<SignupResponse> response = GetRestAdapter.getRestAdapter(false).signupUser(loginInput);
        response.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, retrofit2.Response<SignupResponse> response) {
                mBaseActivity.hideDialog();
                if (response != null && response.body() != null) {
                    if (response.body().getStatus() != null && response.body().getStatus().equals("200")) {
                        SignupResponse.Data data = response.body().getData();
                        String userId = data.getUser().getUserId();
                        sharedPrefsHelper.save(PreferenceKeys.PREF_SESSION_TOKEN, data.getUser().getSessionToken());
                        ShadowApp.sessionToken = data.getUser().getSessionToken();
                        sharedPrefsHelper.save(PreferenceKeys.PREF_USER_ID, userId);
                        mSIgnUpCallback.onSignUpSuccess(loginInput, isEmail);
                        if (isEmail)
                            Log.e("emailverification otp--", data.getUser().getEmailVerificationOtp());

                    } else {
                        mBaseActivity.showToast(response.body().getMessage());
                    }
                } else {
                    mBaseActivity.showToast(R.string.server_error_msg);
                }
            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                mBaseActivity.hideDialog();
                mBaseActivity.showToast(t.getLocalizedMessage());
            }
        });

    }

}

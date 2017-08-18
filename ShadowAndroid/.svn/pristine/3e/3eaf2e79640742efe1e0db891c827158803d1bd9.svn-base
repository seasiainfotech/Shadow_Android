package com.android.shadow.presenter;

import android.text.TextUtils;

import com.android.shadow.R;
import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.model.input.PhoneOtpInput;
import com.android.shadow.model.output.PhoneOtpResponse;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.core.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by singhgharjyot on 6/7/2017.
 */

public class PhoneOtpPresenter {

    private PhoneOtpCallback mPhoneForgotPasswordCallBack;
    private BaseActivity mBaseActivity;

    public PhoneOtpPresenter(BaseActivity phoneVerificationActivity, PhoneOtpCallback phoneForgotPasswordCallBack) {
        this.mBaseActivity = phoneVerificationActivity;
        this.mPhoneForgotPasswordCallBack = phoneForgotPasswordCallBack;
    }

    public interface PhoneOtpCallback {
        void onPhoneOtpSuccess(retrofit2.Response<PhoneOtpResponse> responseResponse);
    }

    public void checkValidations(String... params) {
        String phone = params[0];
        String phoneCode = params[1];
        if (TextUtils.isEmpty(phone)) {
            return;
        } else if (phone.length() <= 9) {
              mBaseActivity.showToast("Please enter a valid phone number");
        } else {
            if (!Utilities.checkInternet(mBaseActivity)) {
                mBaseActivity.showToast(R.string.no_internet_msg);
            } else {
                PhoneOtpInput phoneOtpInput = new PhoneOtpInput();
                phoneOtpInput.setMobileNumber(phone);
                phoneOtpInput.setCountryCode(phoneCode);
                responseCheck(phoneOtpInput);
            }
        }
    }

    private void responseCheck(PhoneOtpInput phoneForgotPasswordInput) {
        mBaseActivity.showDialog();
        Call<PhoneOtpResponse> response = GetRestAdapter.getRestAdapter(false).phoneForgotPassword(phoneForgotPasswordInput);
        response.enqueue(new Callback<PhoneOtpResponse>() {
            @Override
            public void onResponse(Call<PhoneOtpResponse> call, retrofit2.Response<PhoneOtpResponse> response) {
                mBaseActivity.hideDialog();
                mPhoneForgotPasswordCallBack.onPhoneOtpSuccess(response);
            }

            @Override
            public void onFailure(Call<PhoneOtpResponse> call, Throwable t) {
                mBaseActivity.hideDialog();
                mBaseActivity.showToast(t.getLocalizedMessage());
            }
        });
    }


}

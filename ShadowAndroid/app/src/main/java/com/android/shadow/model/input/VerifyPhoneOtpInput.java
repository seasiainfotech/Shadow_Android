package com.android.shadow.model.input;

/**
 * Created by singhgharjyot on 6/8/2017.
 */

public class VerifyPhoneOtpInput {

    private String userId;

    private String smsVerificationOtp;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSmsVerificationOtp() {
        return smsVerificationOtp;
    }

    public void setSmsVerificationOtp(String smsVerificationOtp) {
        this.smsVerificationOtp = smsVerificationOtp;
    }

    @Override
    public String toString() {
        return "ClassPojo [userId = " + userId + ", smsVerificationOtp = " + smsVerificationOtp + "]";
    }
}

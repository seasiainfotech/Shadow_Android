package com.android.shadow.model.input;

/**
 * Created by jindaldipanshu on 5/29/2017.
 */

public class VerifyEmailOtpInput {

    private String userId;
    private String emailVerificationOtp;


    public String getEmailVerificationOtp() {
        return emailVerificationOtp;
    }

    public void setEmailVerificationOtp(String emailVerificationOtp) {
        this.emailVerificationOtp = emailVerificationOtp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

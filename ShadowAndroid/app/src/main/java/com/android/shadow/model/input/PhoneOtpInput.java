package com.android.shadow.model.input;

/**
 * Created by singhgharjyot on 6/7/2017.
 */

public class PhoneOtpInput {

    private String countryCode;

    private String mobileNumber;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "ClassPojo [countryCode = " + countryCode + ", mobileNumber = " + mobileNumber + "]";
    }
}

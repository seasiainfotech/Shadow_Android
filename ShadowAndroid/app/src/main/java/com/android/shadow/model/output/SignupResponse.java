package com.android.shadow.model.output;

/**
 * Created by jindaldipanshu on 5/26/2017.
 */

public class SignupResponse {
    private String message;

    private String status;

    private Data data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class Data {
        private User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        @Override
        public String toString() {
            return "ClassPojo [user = " + user + "]";
        }
    }

    public class User {

        private String firstName;
        private String lastName;
        private String schoolName;
        private String occupation;
        private String companyName;
        private String location;
        private String countryCode;
        private String deleted;
        private String emailVerified;
        private String sessionToken;
        private String phoneOtp;
        private String appVersion;
        private String allowShadow;
        private String createdAt;
        private String userId;
        private String appBuildNumber;
        private String role;
        private String longitude;
        private String latitude;
        private String mobileNumber;
        private String smsVerified;
        private String blocked;
        private String emailVerificationOtp;


        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getEmailVerified() {
            return emailVerified;
        }

        public void setEmailVerified(String emailVerified) {
            this.emailVerified = emailVerified;
        }

        public String getSessionToken() {
            return sessionToken;
        }

        public void setSessionToken(String sessionToken) {
            this.sessionToken = sessionToken;
        }

        public String getPhoneOtp() {
            return phoneOtp;
        }

        public void setPhoneOtp(String phoneOtp) {
            this.phoneOtp = phoneOtp;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public String getAllowShadow() {
            return allowShadow;
        }

        public void setAllowShadow(String allowShadow) {
            this.allowShadow = allowShadow;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getAppBuildNumber() {
            return appBuildNumber;
        }

        public void setAppBuildNumber(String appBuildNumber) {
            this.appBuildNumber = appBuildNumber;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getBlocked() {
            return blocked;
        }

        public void setBlocked(String blocked) {
            this.blocked = blocked;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getSmsVerified() {
            return smsVerified;
        }

        public void setSmsVerified(String smsVerified) {
            this.smsVerified = smsVerified;
        }

        @Override
        public String toString() {
            return "ClassPojo [schoolName = " + schoolName + ", location = " + location + ", countryCode = " + countryCode + ", deleted = " + deleted + ", emailVerified = " + emailVerified + ", sessionToken = " + sessionToken + ", phoneOtp = " + phoneOtp + ", appVersion = " + appVersion + ", allowShadow = " + allowShadow + ", createdAt = " + createdAt + ", userId = " + userId + ", appBuildNumber = " + appBuildNumber + ", role = " + role + ", longitude = " + longitude + ", blocked = " + blocked + ", latitude = " + latitude + ", mobileNumber = " + mobileNumber + ", smsVerified = " + smsVerified + "]";
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getEmailVerificationOtp() {
            return emailVerificationOtp;
        }

        public void setEmailVerificationOtp(String emailVerificationOtp) {
            this.emailVerificationOtp = emailVerificationOtp;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }
    }
}

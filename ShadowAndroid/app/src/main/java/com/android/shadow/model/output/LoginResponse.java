package com.android.shadow.model.output;

/**
 * Created by jindaldipanshu on 5/26/2017.
 */

public class LoginResponse {
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

    @Override
    public String toString() {
        return "ClassPojo [message = " + message + ", status = " + status + ", data = " + data + "]";
    }

    public class Data {
        private String lastName;

        private String countryCode;

        private String state;

        private String profileImageUrl;

        private String deleted;

        private String city;

        private String id;

        private String sessionToken;

        private String email;

        private String appVersion;
        private String role;

        private String createdAt;

        private String verified;

        private String userId;

        private String appBuildNumber;

        private String userName;

        private String blocked;

        private String firstName;

        private String mobileNumber;

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getProfileImageUrl() {
            return profileImageUrl;
        }

        public void setProfileImageUrl(String profileImageUrl) {
            this.profileImageUrl = profileImageUrl;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSessionToken() {
            return sessionToken;
        }

        public void setSessionToken(String sessionToken) {
            this.sessionToken = sessionToken;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAppVersion() {
            return appVersion;
        }

        public void setAppVersion(String appVersion) {
            this.appVersion = appVersion;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getVerified() {
            return verified;
        }

        public void setVerified(String verified) {
            this.verified = verified;
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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getBlocked() {
            return blocked;
        }

        public void setBlocked(String blocked) {
            this.blocked = blocked;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        @Override
        public String toString() {
            return "ClassPojo [lastName = " + lastName + ", countryCode = " + countryCode + ", state = " + state + ", profileImageUrl = " + profileImageUrl + ", deleted = " + deleted + ", city = " + city + ", id = " + id + ", sessionToken = " + sessionToken + ", email = " + email + ", appVersion = " + appVersion + ", createdAt = " + createdAt + ", verified = " + verified + ", userId = " + userId + ", appBuildNumber = " + appBuildNumber + ", userName = " + userName + ", blocked = " + blocked + ", firstName = " + firstName + ", mobileNumber = " + mobileNumber + "]";
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}

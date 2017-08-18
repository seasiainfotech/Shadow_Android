package com.android.shadow.model.output;

import java.util.ArrayList;

/**
 * Created by singhgharjyot on 6/8/2017.
 */

public class EditProfileResponse {

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
        private  ArrayList<Skills> skills;

        private String schoolName;

        private String state;

        private String profileImageUrl;

        private String emailVerified;

        private String city;

        private ArrayList<Interest> interest;

        private String createdAt;

        private String appBuildNumber;

        private String userId;

        private String userName;

        private String role;

        private String blocked;

        private String firstName;

        private String smsVerified;

        private String lastName;

        private String occupation;

        private String videoUrl;

        private String countryCode;

        private String deleted;

        private String phoneOtp;

        private String appVersion;

        private String email;

        private String otherUsersShadowYou;

        private String allowShadow;

        private String mobileNumber;

        public ArrayList<Skills> getSkills() {
            return skills;
        }

        public void setSkills(ArrayList<Skills> skills) {
            this.skills = skills;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
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

        public String getEmailVerified() {
            return emailVerified;
        }

        public void setEmailVerified(String emailVerified) {
            this.emailVerified = emailVerified;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public ArrayList<Interest> getInterest() {
            return interest;
        }

        public void setInterest(ArrayList<Interest> interest) {
            this.interest = interest;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getAppBuildNumber() {
            return appBuildNumber;
        }

        public void setAppBuildNumber(String appBuildNumber) {
            this.appBuildNumber = appBuildNumber;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
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

        public String getSmsVerified() {
            return smsVerified;
        }

        public void setSmsVerified(String smsVerified) {
            this.smsVerified = smsVerified;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getOtherUsersShadowYou() {
            return otherUsersShadowYou;
        }

        public void setOtherUsersShadowYou(String otherUsersShadowYou) {
            this.otherUsersShadowYou = otherUsersShadowYou;
        }

        public String getAllowShadow() {
            return allowShadow;
        }

        public void setAllowShadow(String allowShadow) {
            this.allowShadow = allowShadow;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        @Override
        public String toString() {
            return "ClassPojo [skills = " + skills + ", schoolName = " + schoolName + ", state = " + state + ", profileImageUrl = " + profileImageUrl + ", emailVerified = " + emailVerified + ", city = " + city + ", interest = " + interest + ", createdAt = " + createdAt + ", appBuildNumber = " + appBuildNumber + ", userId = " + userId + ", userName = " + userName + ", role = " + role + ", blocked = " + blocked + ", firstName = " + firstName + ", smsVerified = " + smsVerified + ", lastName = " + lastName + ", occupation = " + occupation + ", videoUrl = " + videoUrl + ", countryCode = " + countryCode + ", deleted = " + deleted + ", phoneOtp = " + phoneOtp + ", appVersion = " + appVersion + ", email = " + email + ", otherUsersShadowYou = " + otherUsersShadowYou + ", allowShadow = " + allowShadow + ", mobileNumber = " + mobileNumber + "]";
        }
    }

    public class Interest {
        private String id;

        private String description;

        private String name;

        private String userId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "ClassPojo [id = " + id + ", description = " + description + ", name = " + name + ", userId = " + userId + "]";
        }
    }


    public class Skills {
        private String id;

        private String description;

        private String name;

        private String userId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "ClassPojo [id = " + id + ", description = " + description + ", name = " + name + ", userId = " + userId + "]";
        }
    }
}

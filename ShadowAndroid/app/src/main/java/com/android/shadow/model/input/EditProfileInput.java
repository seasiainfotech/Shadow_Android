package com.android.shadow.model.input;

import java.util.ArrayList;

/**
 * Created by singhgharjyot on 6/8/2017.
 */

public class EditProfileInput {

    private String schoolName;

    private String location;

    private String linkedInUrl;

    private String facebookUrl;

    private String companyUrl;

    private String userId;

    private String appBuildNumber;

    private String userName;

    private String longitude;

    private String twitterUrl;

    private String firstName;

    private String instagramUrl;

    private String schoolUrl;

    private ArrayList<Occupations> occupations;
    private ArrayList<Interest> interest;

    private String lastName;

    private String occupation;

    private String profileImage;

    private String companyName;

    private String bio;

    private String email;

    private String appVersion;

    private String otherUsersShadowYou;

    private String googlePlusUrl;

    private String gitHubUrl;

    private String latitude;

    private String mobileNumber;
    private String countryCode;

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

    public String getLinkedInUrl() {
        return linkedInUrl;
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.linkedInUrl = linkedInUrl;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public String getSchoolUrl() {
        return schoolUrl;
    }

    public void setSchoolUrl(String schoolUrl) {
        this.schoolUrl = schoolUrl;
    }

    public ArrayList<Occupations> getOccupations() {
        return occupations;
    }

    public void setOccupations(ArrayList<Occupations> occupations) {
        this.occupations = occupations;
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

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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

    public String getOtherUsersShadowYou() {
        return otherUsersShadowYou;
    }

    public void setOtherUsersShadowYou(String otherUsersShadowYou) {
        this.otherUsersShadowYou = otherUsersShadowYou;
    }

    public String getGooglePlusUrl() {
        return googlePlusUrl;
    }

    public void setGooglePlusUrl(String googlePlusUrl) {
        this.googlePlusUrl = googlePlusUrl;
    }

    public String getGitHubUrl() {
        return gitHubUrl;
    }

    public void setGitHubUrl(String gitHubUrl) {
        this.gitHubUrl = gitHubUrl;
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

    public ArrayList<Interest> getInterest() {
        return interest;
    }

    public void setInterest(ArrayList<Interest> interest) {
        this.interest = interest;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public static class Occupations {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class Interest {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "ClassPojo [name = " + name + "]";
        }
    }


}

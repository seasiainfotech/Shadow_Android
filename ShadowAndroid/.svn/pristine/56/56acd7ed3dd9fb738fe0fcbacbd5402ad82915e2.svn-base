package com.android.shadow.model.output;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by singhgharjyot on 6/26/2017.
 */

public class SearchLocationListResponse implements Parcelable {

    private String message;

    private String status;

    private ArrayList<Data> data;


    protected SearchLocationListResponse(Parcel in) {
        message = in.readString();
        status = in.readString();
        data = in.createTypedArrayList(Data.CREATOR);
    }

    public static final Creator<SearchLocationListResponse> CREATOR = new Creator<SearchLocationListResponse>() {
        @Override
        public SearchLocationListResponse createFromParcel(Parcel in) {
            return new SearchLocationListResponse(in);
        }

        @Override
        public SearchLocationListResponse[] newArray(int size) {
            return new SearchLocationListResponse[size];
        }
    };

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

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(message);
        parcel.writeString(status);
        parcel.writeTypedList(data);
    }

    public static class Data implements Parcelable {
        private String id;

        private String ratingCount;

        private String distance;

        private String address;

        private UserDTO userDTO;

        private String[] userRatings;

        private String zipCode;

        private String name;

        private String userId;

        private String state;

        private String avgRating;

        private String city;

        private ArrayList<Occupations> occupations;


        protected Data(Parcel in) {
            id = in.readString();
            distance = in.readString();
            ratingCount = in.readString();
            address = in.readString();
            userDTO = in.readParcelable(UserDTO.class.getClassLoader());
            userRatings = in.createStringArray();
            zipCode = in.readString();
            name = in.readString();
            userId = in.readString();
            state = in.readString();
            avgRating = in.readString();
            city = in.readString();
            occupations = in.createTypedArrayList(Occupations.CREATOR);
        }

        public static final Creator<Data> CREATOR = new Creator<Data>() {
            @Override
            public Data createFromParcel(Parcel in) {
                return new Data(in);
            }

            @Override
            public Data[] newArray(int size) {
                return new Data[size];
            }
        };

        public String getRatingCount() {
            return ratingCount;
        }

        public void setRatingCount(String ratingCount) {
            this.ratingCount = ratingCount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public UserDTO getUserDTO() {
            return userDTO;
        }

        public void setUserDTO(UserDTO userDTO) {
            this.userDTO = userDTO;
        }

        public String[] getUserRatings() {
            return userRatings;
        }

        public void setUserRatings(String[] userRatings) {
            this.userRatings = userRatings;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
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

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getAvgRating() {
            return avgRating;
        }

        public void setAvgRating(String avgRating) {
            this.avgRating = avgRating;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "ClassPojo [id = " + id + ", distance = " + distance + ", address = " + address + ", userDTO = " + userDTO + ", userRatings = " + userRatings + ", zipCode = " + zipCode + ", name = " + name + ", userId = " + userId + ", state = " + state + ", avgRating = " + avgRating + ", city = " + city + "]";
        }

        public ArrayList<Occupations> getOccupations() {
            return occupations;
        }

        public void setOccupations(ArrayList<Occupations> occupations) {
            this.occupations = occupations;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeString(distance);
            parcel.writeString(address);
            parcel.writeParcelable(userDTO, i);
            parcel.writeStringArray(userRatings);
            parcel.writeString(zipCode);
            parcel.writeString(name);
            parcel.writeString(userId);
            parcel.writeString(state);
            parcel.writeString(avgRating);
            parcel.writeString(city);
            parcel.writeTypedList(occupations);
        }
    }

    public static class UserDTO implements Parcelable {
        private ArrayList<Occupations> occupations;

        private SchoolOrCompanyWithTheseOccupations schoolOrCompanyWithTheseOccupations;
        private ShadowersVerified shadowersVerified;
        private ShadowedByShadowUser shadowedByShadowUser;
        private SchoolOrCompanyWithTheseUsers schoolOrCompanyWithTheseUsers;

        private String lastName;

        private String ratingCount;

        private String schoolName;

        private String location;

        private CompanyDTO companyDTO;

        private String profileImageUrl;

        private String videoUrl;

        private String linkedInUrl;

        private String facebookUrl;

        private String companyUrl;

        private String schoolUrl;

        private String bio;

        private String twitterUrl;

        private String googlePlusUrl;

        private String gitHubUrl;

        private String instagramUrl;

        private String countryCode;

        private String companyName;

        private String emailVerified;

        private String otherUsersShadowYou;

        private String email;

        private String appVersion;

        private String[] userRatings;

        private ArrayList<Interest> interest;

        private String allowShadow;

        private String createdAt;

        private String userId;

        private String appBuildNumber;

        private String role;

        private String userName;

        private String blocked;

        private String firstName;

        private String mobileNumber;

        private String smsVerified;

        private SchoolDTO schoolDTO;


        protected UserDTO(Parcel in) {
            occupations = in.createTypedArrayList(Occupations.CREATOR);
            schoolOrCompanyWithTheseOccupations = in.readParcelable(SchoolOrCompanyWithTheseOccupations.class.getClassLoader());
            shadowersVerified = in.readParcelable(ShadowersVerified.class.getClassLoader());
            shadowedByShadowUser = in.readParcelable(ShadowedByShadowUser.class.getClassLoader());
            schoolOrCompanyWithTheseUsers = in.readParcelable(SchoolOrCompanyWithTheseUsers.class.getClassLoader());
            lastName = in.readString();
            schoolName = in.readString();
            location = in.readString();
            ratingCount = in.readString();
            companyDTO = in.readParcelable(CompanyDTO.class.getClassLoader());
            profileImageUrl = in.readString();
            videoUrl = in.readString();
            linkedInUrl = in.readString();
            facebookUrl = in.readString();
            companyUrl = in.readString();
            schoolUrl = in.readString();
            bio = in.readString();
            twitterUrl = in.readString();
            googlePlusUrl = in.readString();
            gitHubUrl = in.readString();
            instagramUrl = in.readString();
            countryCode = in.readString();
            companyName = in.readString();
            emailVerified = in.readString();
            otherUsersShadowYou = in.readString();
            email = in.readString();
            appVersion = in.readString();
            userRatings = in.createStringArray();
            interest = in.createTypedArrayList(Interest.CREATOR);
            allowShadow = in.readString();
            createdAt = in.readString();
            userId = in.readString();
            appBuildNumber = in.readString();
            role = in.readString();
            userName = in.readString();
            blocked = in.readString();
            firstName = in.readString();
            mobileNumber = in.readString();
            smsVerified = in.readString();
            schoolDTO = in.readParcelable(SchoolDTO.class.getClassLoader());
        }

        public static final Creator<UserDTO> CREATOR = new Creator<UserDTO>() {
            @Override
            public UserDTO createFromParcel(Parcel in) {
                return new UserDTO(in);
            }

            @Override
            public UserDTO[] newArray(int size) {
                return new UserDTO[size];
            }
        };

        public ArrayList<Occupations> getOccupations() {
            return occupations;
        }

        public void setOccupations(ArrayList<Occupations> occupations) {
            this.occupations = occupations;
        }

        public SchoolOrCompanyWithTheseOccupations getSchoolOrCompanyWithTheseOccupations() {
            return schoolOrCompanyWithTheseOccupations;
        }

        public void setSchoolOrCompanyWithTheseOccupations(SchoolOrCompanyWithTheseOccupations schoolOrCompanyWithTheseOccupations) {
            this.schoolOrCompanyWithTheseOccupations = schoolOrCompanyWithTheseOccupations;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getRatingCount() {
            return ratingCount;
        }

        public void setRatingCount(String ratingCount) {
            this.ratingCount = ratingCount;
        }


        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public CompanyDTO getCompanyDTO() {
            return companyDTO;
        }

        public void setCompanyDTO(CompanyDTO companyDTO) {
            this.companyDTO = companyDTO;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getEmailVerified() {
            return emailVerified;
        }

        public void setEmailVerified(String emailVerified) {
            this.emailVerified = emailVerified;
        }

        public String getOtherUsersShadowYou() {
            return otherUsersShadowYou;
        }

        public void setOtherUsersShadowYou(String otherUsersShadowYou) {
            this.otherUsersShadowYou = otherUsersShadowYou;
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

        public String[] getUserRatings() {
            return userRatings;
        }

        public void setUserRatings(String[] userRatings) {
            this.userRatings = userRatings;
        }

        public ArrayList<Interest> getInterest() {
            return interest;
        }

        public void setInterest(ArrayList<Interest> interest) {
            this.interest = interest;
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

        public String getSmsVerified() {
            return smsVerified;
        }

        public void setSmsVerified(String smsVerified) {
            this.smsVerified = smsVerified;
        }

        @Override
        public String toString() {
            return "ClassPojo [occupations = " + occupations + ", schoolOrCompanyWithTheseOccupations = " + schoolOrCompanyWithTheseOccupations + ", lastName = " + lastName + ", schoolName = " + schoolName + ", companyDTO = " + companyDTO + ", countryCode = " + countryCode + ", companyName = " + companyName + ", emailVerified = " + emailVerified + ", otherUsersShadowYou = " + otherUsersShadowYou + ", email = " + email + ", appVersion = " + appVersion + ", userRatings = " + userRatings + ", interest = " + interest + ", allowShadow = " + allowShadow + ", createdAt = " + createdAt + ", userId = " + userId + ", appBuildNumber = " + appBuildNumber + ", role = " + role + ", userName = " + userName + ", blocked = " + blocked + ", firstName = " + firstName + ", mobileNumber = " + mobileNumber + ", smsVerified = " + smsVerified + "]";
        }


        public ShadowersVerified getShadowersVerified() {
            return shadowersVerified;
        }

        public void setShadowersVerified(ShadowersVerified shadowersVerified) {
            this.shadowersVerified = shadowersVerified;
        }

        public ShadowedByShadowUser getShadowedByShadowUser() {
            return shadowedByShadowUser;
        }

        public void setShadowedByShadowUser(ShadowedByShadowUser shadowedByShadowUser) {
            this.shadowedByShadowUser = shadowedByShadowUser;
        }

        public SchoolOrCompanyWithTheseUsers getSchoolOrCompanyWithTheseUsers() {
            return schoolOrCompanyWithTheseUsers;
        }

        public void setSchoolOrCompanyWithTheseUsers(SchoolOrCompanyWithTheseUsers schoolOrCompanyWithTheseUsers) {
            this.schoolOrCompanyWithTheseUsers = schoolOrCompanyWithTheseUsers;
        }

        public SchoolDTO getSchoolDTO() {
            return schoolDTO;
        }

        public void setSchoolDTO(SchoolDTO schoolDTO) {
            this.schoolDTO = schoolDTO;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getProfileImageUrl() {
            return profileImageUrl;
        }

        public void setProfileImageUrl(String profileImageUrl) {
            this.profileImageUrl = profileImageUrl;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
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

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getTwitterUrl() {
            return twitterUrl;
        }

        public void setTwitterUrl(String twitterUrl) {
            this.twitterUrl = twitterUrl;
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(occupations);
            parcel.writeParcelable(schoolOrCompanyWithTheseOccupations, i);
            parcel.writeParcelable(shadowersVerified, i);
            parcel.writeParcelable(shadowedByShadowUser, i);
            parcel.writeParcelable(schoolOrCompanyWithTheseUsers, i);
            parcel.writeString(ratingCount);
            parcel.writeString(lastName);
            parcel.writeString(schoolName);
            parcel.writeString(location);
            parcel.writeParcelable(companyDTO, i);
            parcel.writeString(profileImageUrl);
            parcel.writeString(videoUrl);
            parcel.writeString(linkedInUrl);
            parcel.writeString(facebookUrl);
            parcel.writeString(companyUrl);
            parcel.writeString(schoolUrl);
            parcel.writeString(bio);
            parcel.writeString(twitterUrl);
            parcel.writeString(googlePlusUrl);
            parcel.writeString(gitHubUrl);
            parcel.writeString(instagramUrl);
            parcel.writeString(countryCode);
            parcel.writeString(companyName);
            parcel.writeString(emailVerified);
            parcel.writeString(otherUsersShadowYou);
            parcel.writeString(email);
            parcel.writeString(appVersion);
            parcel.writeStringArray(userRatings);
            parcel.writeTypedList(interest);
            parcel.writeString(allowShadow);
            parcel.writeString(createdAt);
            parcel.writeString(userId);
            parcel.writeString(appBuildNumber);
            parcel.writeString(role);
            parcel.writeString(userName);
            parcel.writeString(blocked);
            parcel.writeString(firstName);
            parcel.writeString(mobileNumber);
            parcel.writeString(smsVerified);
            parcel.writeParcelable(schoolDTO, i);
        }
    }


    public static class SchoolOrCompanyWithTheseOccupations implements Parcelable {
        private ArrayList<CompanyList> companyList;
        private ArrayList<SchoolList> schoolList;

        private String count;

        protected SchoolOrCompanyWithTheseOccupations(Parcel in) {
            companyList = in.createTypedArrayList(CompanyList.CREATOR);
            schoolList = in.createTypedArrayList(SchoolList.CREATOR);
            count = in.readString();
        }

        public static final Creator<SchoolOrCompanyWithTheseOccupations> CREATOR = new Creator<SchoolOrCompanyWithTheseOccupations>() {
            @Override
            public SchoolOrCompanyWithTheseOccupations createFromParcel(Parcel in) {
                return new SchoolOrCompanyWithTheseOccupations(in);
            }

            @Override
            public SchoolOrCompanyWithTheseOccupations[] newArray(int size) {
                return new SchoolOrCompanyWithTheseOccupations[size];
            }
        };

        public ArrayList<CompanyList> getCompanyList() {
            return companyList;
        }

        public void setCompanyList(ArrayList<CompanyList> companyList) {
            this.companyList = companyList;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "ClassPojo [companyList = " + companyList + ", count = " + count + "]";
        }

        public ArrayList<SchoolList> getSchoolList() {
            return schoolList;
        }

        public void setSchoolList(ArrayList<SchoolList> schoolList) {
            this.schoolList = schoolList;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(companyList);
            parcel.writeTypedList(schoolList);
            parcel.writeString(count);
        }
    }

    public static class SchoolOrCompanyWithTheseUsers implements Parcelable {
        private String count;
        private ArrayList<UserList> userList;

        protected SchoolOrCompanyWithTheseUsers(Parcel in) {
            count = in.readString();
            userList = in.createTypedArrayList(UserList.CREATOR);
        }

        public static final Creator<SchoolOrCompanyWithTheseUsers> CREATOR = new Creator<SchoolOrCompanyWithTheseUsers>() {
            @Override
            public SchoolOrCompanyWithTheseUsers createFromParcel(Parcel in) {
                return new SchoolOrCompanyWithTheseUsers(in);
            }

            @Override
            public SchoolOrCompanyWithTheseUsers[] newArray(int size) {
                return new SchoolOrCompanyWithTheseUsers[size];
            }
        };

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "ClassPojo [count = " + count + "]";
        }

        public ArrayList<UserList> getUserList() {
            return userList;
        }

        public void setUserList(ArrayList<UserList> userList) {
            this.userList = userList;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(count);
            parcel.writeTypedList(userList);
        }
    }

    public static class SchoolList implements Parcelable {
        private String id;

        private String address;

        private String zipCode;

        private String name;

        private String state;

        private String[] schoolRatings;

        private String city;

        protected SchoolList(Parcel in) {
            id = in.readString();
            address = in.readString();
            zipCode = in.readString();
            name = in.readString();
            state = in.readString();
            schoolRatings = in.createStringArray();
            city = in.readString();
        }

        public static final Creator<SchoolList> CREATOR = new Creator<SchoolList>() {
            @Override
            public SchoolList createFromParcel(Parcel in) {
                return new SchoolList(in);
            }

            @Override
            public SchoolList[] newArray(int size) {
                return new SchoolList[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String[] getSchoolRatings() {
            return schoolRatings;
        }

        public void setSchoolRatings(String[] schoolRatings) {
            this.schoolRatings = schoolRatings;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "ClassPojo [id = " + id + ", address = " + address + ", zipCode = " + zipCode + ", name = " + name + ", state = " + state + ", schoolRatings = " + schoolRatings + ", city = " + city + "]";
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeString(address);
            parcel.writeString(zipCode);
            parcel.writeString(name);
            parcel.writeString(state);
            parcel.writeStringArray(schoolRatings);
            parcel.writeString(city);
        }
    }


    public static class CompanyList implements Parcelable {
        private String id;

        private String[] companyRatings;

        private String name;

        protected CompanyList(Parcel in) {
            id = in.readString();
            companyRatings = in.createStringArray();
            name = in.readString();
        }

        public static final Creator<CompanyList> CREATOR = new Creator<CompanyList>() {
            @Override
            public CompanyList createFromParcel(Parcel in) {
                return new CompanyList(in);
            }

            @Override
            public CompanyList[] newArray(int size) {
                return new CompanyList[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String[] getCompanyRatings() {
            return companyRatings;
        }

        public void setCompanyRatings(String[] companyRatings) {
            this.companyRatings = companyRatings;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "ClassPojo [id = " + id + ", companyRatings = " + companyRatings + ", name = " + name + "]";
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeStringArray(companyRatings);
            parcel.writeString(name);
        }
    }


    public static class ShadowersVerified implements Parcelable {
        private String count;

        protected ShadowersVerified(Parcel in) {
            count = in.readString();
        }

        public static final Creator<ShadowersVerified> CREATOR = new Creator<ShadowersVerified>() {
            @Override
            public ShadowersVerified createFromParcel(Parcel in) {
                return new ShadowersVerified(in);
            }

            @Override
            public ShadowersVerified[] newArray(int size) {
                return new ShadowersVerified[size];
            }
        };

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(count);
        }
    }

    public static class ShadowedByShadowUser implements Parcelable {
        private String count;

        protected ShadowedByShadowUser(Parcel in) {
            count = in.readString();
        }

        public static final Creator<ShadowedByShadowUser> CREATOR = new Creator<ShadowedByShadowUser>() {
            @Override
            public ShadowedByShadowUser createFromParcel(Parcel in) {
                return new ShadowedByShadowUser(in);
            }

            @Override
            public ShadowedByShadowUser[] newArray(int size) {
                return new ShadowedByShadowUser[size];
            }
        };

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(count);
        }
    }

    public static class CompanyDTO implements Parcelable {
        private String id;

        private String[] companyRatings;

        private String name;

        protected CompanyDTO(Parcel in) {
            id = in.readString();
            companyRatings = in.createStringArray();
            name = in.readString();
        }

        public static final Creator<CompanyDTO> CREATOR = new Creator<CompanyDTO>() {
            @Override
            public CompanyDTO createFromParcel(Parcel in) {
                return new CompanyDTO(in);
            }

            @Override
            public CompanyDTO[] newArray(int size) {
                return new CompanyDTO[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String[] getCompanyRatings() {
            return companyRatings;
        }

        public void setCompanyRatings(String[] companyRatings) {
            this.companyRatings = companyRatings;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "ClassPojo [id = " + id + ", companyRatings = " + companyRatings + ", name = " + name + "]";
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeStringArray(companyRatings);
            parcel.writeString(name);
        }
    }

    public static class SchoolDTO implements Parcelable {
        private String id;

        private String address;

        private String zipCode;

        private String name;

        private String state;

        private String[] schoolRatings;

        private String city;

        protected SchoolDTO(Parcel in) {
            id = in.readString();
            address = in.readString();
            zipCode = in.readString();
            name = in.readString();
            state = in.readString();
            schoolRatings = in.createStringArray();
            city = in.readString();
        }

        public static final Creator<SchoolDTO> CREATOR = new Creator<SchoolDTO>() {
            @Override
            public SchoolDTO createFromParcel(Parcel in) {
                return new SchoolDTO(in);
            }

            @Override
            public SchoolDTO[] newArray(int size) {
                return new SchoolDTO[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String[] getSchoolRatings() {
            return schoolRatings;
        }

        public void setSchoolRatings(String[] schoolRatings) {
            this.schoolRatings = schoolRatings;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "ClassPojo [id = " + id + ", address = " + address + ", zipCode = " + zipCode + ", name = " + name + ", state = " + state + ", schoolRatings = " + schoolRatings + ", city = " + city + "]";
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeString(address);
            parcel.writeString(zipCode);
            parcel.writeString(name);
            parcel.writeString(state);
            parcel.writeStringArray(schoolRatings);
            parcel.writeString(city);
        }
    }

    public static class UserList implements Parcelable {
        private ArrayList<Occupations> occupations;

        private String[] userRatings;

        private ArrayList<Interest> interest;

        private String userId;

        private String countryCode;

        private String mobileNumber;

        protected UserList(Parcel in) {
            occupations = in.createTypedArrayList(Occupations.CREATOR);
            userRatings = in.createStringArray();
            interest = in.createTypedArrayList(Interest.CREATOR);
            userId = in.readString();
            countryCode = in.readString();
            mobileNumber = in.readString();
        }

        public static final Creator<UserList> CREATOR = new Creator<UserList>() {
            @Override
            public UserList createFromParcel(Parcel in) {
                return new UserList(in);
            }

            @Override
            public UserList[] newArray(int size) {
                return new UserList[size];
            }
        };

        public ArrayList<Occupations> getOccupations() {
            return occupations;
        }

        public void setOccupations(ArrayList<Occupations> occupations) {
            this.occupations = occupations;
        }

        public String[] getUserRatings() {
            return userRatings;
        }

        public void setUserRatings(String[] userRatings) {
            this.userRatings = userRatings;
        }

        public ArrayList<Interest> getInterest() {
            return interest;
        }

        public void setInterest(ArrayList<Interest> interest) {
            this.interest = interest;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

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
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(occupations);
            parcel.writeStringArray(userRatings);
            parcel.writeTypedList(interest);
            parcel.writeString(userId);
            parcel.writeString(countryCode);
            parcel.writeString(mobileNumber);
        }
    }

    public static class Occupations implements Parcelable {
        private String id;

        private String name;

        private String occupationTypeId;

        protected Occupations(Parcel in) {
            id = in.readString();
            name = in.readString();
            occupationTypeId = in.readString();
        }

        public static final Creator<Occupations> CREATOR = new Creator<Occupations>() {
            @Override
            public Occupations createFromParcel(Parcel in) {
                return new Occupations(in);
            }

            @Override
            public Occupations[] newArray(int size) {
                return new Occupations[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOccupationTypeId() {
            return occupationTypeId;
        }

        public void setOccupationTypeId(String occupationTypeId) {
            this.occupationTypeId = occupationTypeId;
        }

        @Override
        public String toString() {
            return "ClassPojo [id = " + id + ", name = " + name + ", occupationTypeId = " + occupationTypeId + "]";
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeString(name);
            parcel.writeString(occupationTypeId);
        }
    }

    public static class Interest implements Parcelable {
        private String id;

        private String name;

        private String userId;

        protected Interest(Parcel in) {
            id = in.readString();
            name = in.readString();
            userId = in.readString();
        }

        public static final Creator<Interest> CREATOR = new Creator<Interest>() {
            @Override
            public Interest createFromParcel(Parcel in) {
                return new Interest(in);
            }

            @Override
            public Interest[] newArray(int size) {
                return new Interest[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
            return "ClassPojo [id = " + id + ", name = " + name + ", userId = " + userId + "]";
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeString(name);
            parcel.writeString(userId);
        }
    }


}

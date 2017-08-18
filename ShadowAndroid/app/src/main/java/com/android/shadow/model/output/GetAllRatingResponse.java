package com.android.shadow.model.output;

import java.util.ArrayList;

/**
 * Created by jindaldipanshu on 7/11/2017.
 */

public class GetAllRatingResponse {
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
        private String id;

        private String avgRating;

        private String ratingCount;

        private ArrayList<CompanyRatings> companyRatings;

        private ArrayList<OccupationRatings> occupationRatings;

        private ArrayList<UserRatings> userRatings;

        private String name;

        private ArrayList<SchoolRatings> schoolRatings;

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

        public ArrayList<CompanyRatings> getCompanyRatings() {
            return companyRatings;
        }

        public void setCompanyRatings(ArrayList<CompanyRatings> companyRatings) {
            this.companyRatings = companyRatings;
        }

        public ArrayList<OccupationRatings> getOccupationRatings() {
            return occupationRatings;
        }

        public void setOccupationRatings(ArrayList<OccupationRatings> occupationRatings) {
            this.occupationRatings = occupationRatings;
        }

        public ArrayList<UserRatings> getUserRatings() {
            return userRatings;
        }

        public void setUserRatings(ArrayList<UserRatings> userRatings) {
            this.userRatings = userRatings;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<SchoolRatings> getSchoolRatings() {
            return schoolRatings;
        }

        public void setSchoolRatings(ArrayList<SchoolRatings> schoolRatings) {
            this.schoolRatings = schoolRatings;
        }

        @Override
        public String toString() {
            return "ClassPojo [id = " + id + ", companyRatings = " + companyRatings + ", occupationRatings = " + occupationRatings + ", userRatings = " + userRatings + ", name = " + name + ", schoolRatings = " + schoolRatings + "]";
        }

        public String getAvgRating() {
            return avgRating;
        }

        public void setAvgRating(String avgRating) {
            this.avgRating = avgRating;
        }


        public class OccupationRatings {
            private String id;

            private UserDTO userDTO;

            private String rating;

            private String comment;

            private String timeAgo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public UserDTO getUserDTO() {
                return userDTO;
            }

            public void setUserDTO(UserDTO userDTO) {
                this.userDTO = userDTO;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            @Override
            public String toString() {
                return "ClassPojo [id = " + id + ", userDTO = " + userDTO + ", rating = " + rating + ", comment = " + comment + "]";
            }

            public String getTimeAgo() {
                return timeAgo;
            }

            public void setTimeAgo(String timeAgo) {
                this.timeAgo = timeAgo;
            }

            public class UserDTO {
                private String[] skills;

                private String lastName;

                private String email;

                private String[] userRatings;

                private String[] interest;

                private String userId;

                private String countryCode;

                private String userName;

                private String profileImageUrl;

                private String mobileNumber;

                private String firstName;

                public String[] getSkills() {
                    return skills;
                }

                public void setSkills(String[] skills) {
                    this.skills = skills;
                }

                public String getLastName() {
                    return lastName;
                }

                public void setLastName(String lastName) {
                    this.lastName = lastName;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public String[] getUserRatings() {
                    return userRatings;
                }

                public void setUserRatings(String[] userRatings) {
                    this.userRatings = userRatings;
                }

                public String[] getInterest() {
                    return interest;
                }

                public void setInterest(String[] interest) {
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

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public String getProfileImageUrl() {
                    return profileImageUrl;
                }

                public void setProfileImageUrl(String profileImageUrl) {
                    this.profileImageUrl = profileImageUrl;
                }

                public String getMobileNumber() {
                    return mobileNumber;
                }

                public void setMobileNumber(String mobileNumber) {
                    this.mobileNumber = mobileNumber;
                }

                public String getFirstName() {
                    return firstName;
                }

                public void setFirstName(String firstName) {
                    this.firstName = firstName;
                }

                @Override
                public String toString() {
                    return "ClassPojo [skills = " + skills + ", lastName = " + lastName + ", email = " + email + ", userRatings = " + userRatings + ", interest = " + interest + ", userId = " + userId + ", countryCode = " + countryCode + ", userName = " + userName + ", profileImageUrl = " + profileImageUrl + ", mobileNumber = " + mobileNumber + ", firstName = " + firstName + "]";
                }
            }
        }

        public class UserRatings {
            private String id;

            private UserDTO userDTO;

            private String rating;

            private String comment;
            private String timeAgo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public UserDTO getUserDTO() {
                return userDTO;
            }

            public void setUserDTO(UserDTO userDTO) {
                this.userDTO = userDTO;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            @Override
            public String toString() {
                return "ClassPojo [id = " + id + ", userDTO = " + userDTO + ", rating = " + rating + ", comment = " + comment + "]";
            }

            public String getTimeAgo() {
                return timeAgo;
            }

            public void setTimeAgo(String timeAgo) {
                this.timeAgo = timeAgo;
            }

            public class UserDTO {
                private String[] skills;

                private String lastName;

                private String email;

                private String[] userRatings;

                private String[] interest;

                private String userId;

                private String countryCode;

                private String userName;

                private String profileImageUrl;

                private String mobileNumber;

                private String firstName;

                public String[] getSkills() {
                    return skills;
                }

                public void setSkills(String[] skills) {
                    this.skills = skills;
                }

                public String getLastName() {
                    return lastName;
                }

                public void setLastName(String lastName) {
                    this.lastName = lastName;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public String[] getUserRatings() {
                    return userRatings;
                }

                public void setUserRatings(String[] userRatings) {
                    this.userRatings = userRatings;
                }

                public String[] getInterest() {
                    return interest;
                }

                public void setInterest(String[] interest) {
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

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public String getProfileImageUrl() {
                    return profileImageUrl;
                }

                public void setProfileImageUrl(String profileImageUrl) {
                    this.profileImageUrl = profileImageUrl;
                }

                public String getMobileNumber() {
                    return mobileNumber;
                }

                public void setMobileNumber(String mobileNumber) {
                    this.mobileNumber = mobileNumber;
                }

                public String getFirstName() {
                    return firstName;
                }

                public void setFirstName(String firstName) {
                    this.firstName = firstName;
                }

                @Override
                public String toString() {
                    return "ClassPojo [skills = " + skills + ", lastName = " + lastName + ", email = " + email + ", userRatings = " + userRatings + ", interest = " + interest + ", userId = " + userId + ", countryCode = " + countryCode + ", userName = " + userName + ", profileImageUrl = " + profileImageUrl + ", mobileNumber = " + mobileNumber + ", firstName = " + firstName + "]";
                }
            }
        }

        public class SchoolRatings {
            private String id;

            private UserDTO userDTO;

            private String rating;

            private String comment;

            private String timeAgo;
            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public UserDTO getUserDTO() {
                return userDTO;
            }

            public void setUserDTO(UserDTO userDTO) {
                this.userDTO = userDTO;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }

            @Override
            public String toString() {
                return "ClassPojo [id = " + id + ", userDTO = " + userDTO + ", rating = " + rating + "]";
            }


            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getTimeAgo() {
                return timeAgo;
            }

            public void setTimeAgo(String timeAgo) {
                this.timeAgo = timeAgo;
            }
        }

        public class CompanyRatings {
            private String id;

            private UserDTO userDTO;

            private String name;

            private String searchType;

            private String companyId;

            private String rating;

            private String comment;

            private String timeAgo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public UserDTO getUserDTO() {
                return userDTO;
            }

            public void setUserDTO(UserDTO userDTO) {
                this.userDTO = userDTO;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSearchType() {
                return searchType;
            }

            public void setSearchType(String searchType) {
                this.searchType = searchType;
            }

            public String getCompanyId() {
                return companyId;
            }

            public void setCompanyId(String companyId) {
                this.companyId = companyId;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }

            @Override
            public String toString() {
                return "ClassPojo [id = " + id + ", userDTO = " + userDTO + ", name = " + name + ", searchType = " + searchType + ", companyId = " + companyId + ", rating = " + rating + "]";
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getTimeAgo() {
                return timeAgo;
            }

            public void setTimeAgo(String timeAgo) {
                this.timeAgo = timeAgo;
            }
        }

        public class UserDTO {
            private String[] skills;

            private String lastName;

            private String email;

            private String[] userRatings;

            private String[] interest;

            private String userId;

            private String countryCode;

            private String userName;

            private String profileImageUrl;

            private String mobileNumber;

            private String firstName;

            public String[] getSkills() {
                return skills;
            }

            public void setSkills(String[] skills) {
                this.skills = skills;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String[] getUserRatings() {
                return userRatings;
            }

            public void setUserRatings(String[] userRatings) {
                this.userRatings = userRatings;
            }

            public String[] getInterest() {
                return interest;
            }

            public void setInterest(String[] interest) {
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

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getProfileImageUrl() {
                return profileImageUrl;
            }

            public void setProfileImageUrl(String profileImageUrl) {
                this.profileImageUrl = profileImageUrl;
            }

            public String getMobileNumber() {
                return mobileNumber;
            }

            public void setMobileNumber(String mobileNumber) {
                this.mobileNumber = mobileNumber;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            @Override
            public String toString() {
                return "ClassPojo [skills = " + skills + ", lastName = " + lastName + ", email = " + email + ", userRatings = " + userRatings + ", interest = " + interest + ", userId = " + userId + ", countryCode = " + countryCode + ", userName = " + userName + ", profileImageUrl = " + profileImageUrl + ", mobileNumber = " + mobileNumber + ", firstName = " + firstName + "]";
            }
        }

    }
}
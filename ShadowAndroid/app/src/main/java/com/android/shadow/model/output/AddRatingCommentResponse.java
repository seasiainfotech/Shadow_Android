package com.android.shadow.model.output;

/**
 * Created by singhgharjyot on 6/19/2017.
 */

public class AddRatingCommentResponse {

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

        private UserDTO userDTO;

        private String rating;

        private String comment;

        private RatedUserDTO ratedUserDTO;

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

        public RatedUserDTO getRatedUserDTO() {
            return ratedUserDTO;
        }

        public void setRatedUserDTO(RatedUserDTO ratedUserDTO) {
            this.ratedUserDTO = ratedUserDTO;
        }

        @Override
        public String toString() {
            return "ClassPojo [id = " + id + ", userDTO = " + userDTO + ", rating = " + rating + ", comment = " + comment + ", ratedUserDTO = " + ratedUserDTO + "]";
        }


        public class RatedUserDTO {
            private String[] skills;

            private String lastName;

            private String email;

            private String[] interest;

            private String userId;

            private String countryCode;

            private String userName;

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
                return "ClassPojo [skills = " + skills + ", lastName = " + lastName + ", email = " + email + ", interest = " + interest + ", userId = " + userId + ", countryCode = " + countryCode + ", userName = " + userName + ", mobileNumber = " + mobileNumber + ", firstName = " + firstName + "]";
            }
        }

        public class UserDTO {
            private String[] skills;

            private String lastName;

            private String email;

            private String[] interest;

            private String userId;

            private String countryCode;

            private String userName;

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
                return "ClassPojo [skills = " + skills + ", lastName = " + lastName + ", email = " + email + ", interest = " + interest + ", userId = " + userId + ", countryCode = " + countryCode + ", userName = " + userName + ", mobileNumber = " + mobileNumber + ", firstName = " + firstName + "]";
            }
        }

    }

}

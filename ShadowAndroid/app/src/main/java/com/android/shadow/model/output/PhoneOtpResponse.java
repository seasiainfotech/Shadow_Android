package com.android.shadow.model.output;

/**
 * Created by singhgharjyot on 6/7/2017.
 */

public class PhoneOtpResponse {

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

        private String phoneOtp;

        private String userId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPhoneOtp() {
            return phoneOtp;
        }

        public void setPhoneOtp(String phoneOtp) {
            this.phoneOtp = phoneOtp;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "ClassPojo [id = " + id + ", phoneOtp = " + phoneOtp + ", userId = " + userId + "]";
        }
    }
}

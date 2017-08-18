package com.android.shadow.model.output;

import java.util.ArrayList;

/**
 * Created by singhgharjyot on 7/21/2017.
 */

public class GetAvailableCompanyListResponse {
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
        private ArrayList<CompanyList> companyList;

        public ArrayList<CompanyList> getCompanyList() {
            return companyList;
        }

        public void setCompanyList(ArrayList<CompanyList> companyList) {
            this.companyList = companyList;
        }

        @Override
        public String toString() {
            return "ClassPojo [companyList = " + companyList + "]";
        }
    }


    public class CompanyList {
        private String id;

        private String name;

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

        @Override
        public String toString() {
            return "ClassPojo [id = " + id + ", name = " + name + "]";
        }
    }

}

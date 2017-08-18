package com.android.shadow.model.output;

import java.util.ArrayList;

/**
 * Created by singhgharjyot on 6/8/2017.
 */

public class GetAllSchoolResponse {

    private String message;

    private String status;

    private  Data data;

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
        private String[] companyList;

        private ArrayList<SchoolList> schoolList;

        public String[] getCompanyList ()
        {
            return companyList;
        }

        public void setCompanyList (String[] companyList)
        {
            this.companyList = companyList;
        }

        public ArrayList<SchoolList> getSchoolList ()
        {
            return schoolList;
        }

        public void setSchoolList (ArrayList<SchoolList> schoolList)
        {
            this.schoolList = schoolList;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [companyList = "+companyList+", schoolList = "+schoolList+"]";
        }
    }


    public class SchoolList
    {
        private String id;

        private String address;

        private String zipCode;

        private String name;

        private String state;

        private String[] schoolRatings;

        private String city;

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getAddress ()
        {
            return address;
        }

        public void setAddress (String address)
        {
            this.address = address;
        }

        public String getZipCode ()
        {
            return zipCode;
        }

        public void setZipCode (String zipCode)
        {
            this.zipCode = zipCode;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getState ()
        {
            return state;
        }

        public void setState (String state)
        {
            this.state = state;
        }

        public String[] getSchoolRatings ()
        {
            return schoolRatings;
        }

        public void setSchoolRatings (String[] schoolRatings)
        {
            this.schoolRatings = schoolRatings;
        }

        public String getCity ()
        {
            return city;
        }

        public void setCity (String city)
        {
            this.city = city;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [id = "+id+", address = "+address+", zipCode = "+zipCode+", name = "+name+", state = "+state+", schoolRatings = "+schoolRatings+", city = "+city+"]";
        }
    }
}

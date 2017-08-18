package com.android.shadow.model.output;

/**
 * Created by singhgharjyot on 6/20/2017.
 */

public class SearchTrendsListResponse {
    private String message;

    private String status;

    private SearchCompanyListResponse.Data[] data;

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

    public SearchCompanyListResponse.Data[] getData() {
        return data;
    }

    public void setData(SearchCompanyListResponse.Data[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ClassPojo [message = " + message + ", status = " + status + ", data = " + data + "]";
    }

    public class Data {
        private String id;

        private String name;

        private String avgRating;

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

        public String getAvgRating() {
            return avgRating;
        }

        public void setAvgRating(String avgRating) {
            this.avgRating = avgRating;
        }

        @Override
        public String toString() {
            return "ClassPojo [id = " + id + ", name = " + name + ", avgRating = " + avgRating + "]";
        }
    }

}

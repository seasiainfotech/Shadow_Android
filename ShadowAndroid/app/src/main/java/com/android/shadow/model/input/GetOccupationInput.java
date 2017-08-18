package com.android.shadow.model.input;

/**
 * Created by jindaldipanshu on 6/19/2017.
 */

public class GetOccupationInput {

    private String userId;
    private String pageIndex;
    private String pageSize;


    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

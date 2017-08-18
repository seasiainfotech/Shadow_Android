package com.android.shadow.model.input;

/**
 * Created by singhgharjyot on 6/20/2017.
 */

public class SearchUserListInput {
    private String searchKeyword;

    private String userId;

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ClassPojo [searchKeyword = " + searchKeyword + ", userId = " + userId + "]";
    }
}

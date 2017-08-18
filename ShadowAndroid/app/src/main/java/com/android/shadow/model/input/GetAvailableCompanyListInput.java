package com.android.shadow.model.input;

/**
 * Created by singhgharjyot on 7/21/2017.
 */

public class GetAvailableCompanyListInput {
    private String searchKeyword;

    private String userId;

    private String pageSize;

    private String pageIndex;

    public String getSearchKeyword ()
    {
        return searchKeyword;
    }

    public void setSearchKeyword (String searchKeyword)
    {
        this.searchKeyword = searchKeyword;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    public String getPageSize ()
    {
        return pageSize;
    }

    public void setPageSize (String pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getPageIndex ()
    {
        return pageIndex;
    }

    public void setPageIndex (String pageIndex)
    {
        this.pageIndex = pageIndex;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [searchKeyword = "+searchKeyword+", userId = "+userId+", pageSize = "+pageSize+", pageIndex = "+pageIndex+"]";
    }

}

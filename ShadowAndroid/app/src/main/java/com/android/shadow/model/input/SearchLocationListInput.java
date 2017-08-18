package com.android.shadow.model.input;

/**
 * Created by singhgharjyot on 6/26/2017.
 */

public class SearchLocationListInput {

    private String searchKeyword;

    private String userId;

    private String longitude;

    private int searchType;

    private String latitude;

    private String radiusInMiles;
    private String pageIndex;

    private String pageSize;

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

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public int getSearchType ()
    {
        return searchType;
    }

    public void setSearchType (int searchType)
    {
        this.searchType = searchType;
    }

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    public String getRadiusInMiles ()
    {
        return radiusInMiles;
    }

    public void setRadiusInMiles (String radiusInMiles)
    {
        this.radiusInMiles = radiusInMiles;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [searchKeyword = "+searchKeyword+", userId = "+userId+", longitude = "+longitude+", searchType = "+searchType+", latitude = "+latitude+", radiusInMiles = "+radiusInMiles+"]";
    }

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
}

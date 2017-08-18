package com.android.shadow.model.input;

/**
 * Created by jindaldipanshu on 5/26/2017.
 */

public class LoginInput {
    private String appVersion;

    private String appBuildNumber;

    private String userName;

    private String password;

    public String getAppVersion ()
    {
        return appVersion;
    }

    public void setAppVersion (String appVersion)
    {
        this.appVersion = appVersion;
    }

    public String getAppBuildNumber ()
    {
        return appBuildNumber;
    }

    public void setAppBuildNumber (String appBuildNumber)
    {
        this.appBuildNumber = appBuildNumber;
    }

    public String getUserName ()
    {
        return userName;
    }

    public void setUserName (String userName)
    {
        this.userName = userName;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [appVersion = "+appVersion+", appBuildNumber = "+appBuildNumber+", userName = "+userName+", password = "+password+"]";
    }
}

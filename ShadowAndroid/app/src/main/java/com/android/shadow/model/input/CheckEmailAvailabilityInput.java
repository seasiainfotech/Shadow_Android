package com.android.shadow.model.input;

/**
 * Created by singhgharjyot on 8/9/2017.
 */

public class CheckEmailAvailabilityInput {
    private String email;

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [email = "+email+"]";
    }
}

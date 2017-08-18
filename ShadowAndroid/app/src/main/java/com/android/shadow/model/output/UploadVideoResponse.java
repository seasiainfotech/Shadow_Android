package com.android.shadow.model.output;

/**
 * Created by jindaldipanshu on 7/11/2017.
 */

public class UploadVideoResponse {
    private String message;

    private String status;

    private Data data;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", status = "+status+", data = "+data+"]";
    }

    public class Data
    {
        private String userId;

        private String videoName;

        public String getUserId ()
        {
            return userId;
        }

        public void setUserId (String userId)
        {
            this.userId = userId;
        }

        public String getVideoName ()
        {
            return videoName;
        }

        public void setVideoName (String videoName)
        {
            this.videoName = videoName;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [userId = "+userId+", videoName = "+videoName+"]";
        }
    }


}

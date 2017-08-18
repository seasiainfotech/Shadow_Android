package com.android.shadow.model.output;

import java.util.ArrayList;

/**
 * Created by singhgharjyot on 6/9/2017.
 */

public class GetAllSkillResponse {

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



    public class Data
    {
        private String pageSize;

        private ArrayList<SkillTypes> skillTypes;

        private String pageIndex;

        public String getPageSize ()
        {
            return pageSize;
        }

        public void setPageSize (String pageSize)
        {
            this.pageSize = pageSize;
        }

        public ArrayList<SkillTypes> getSkillTypes ()
        {
            return skillTypes;
        }

        public void setSkillTypes (ArrayList<SkillTypes> skillTypes)
        {
            this.skillTypes = skillTypes;
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
            return "ClassPojo [pageSize = "+pageSize+", skillTypes = "+skillTypes+", pageIndex = "+pageIndex+"]";
        }
    }

    public class SkillTypes
    {
        private String id;

        private String description;

        private String name;

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public String getDescription ()
        {
            return description;
        }

        public void setDescription (String description)
        {
            this.description = description;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [id = "+id+", description = "+description+", name = "+name+"]";
        }
    }




}

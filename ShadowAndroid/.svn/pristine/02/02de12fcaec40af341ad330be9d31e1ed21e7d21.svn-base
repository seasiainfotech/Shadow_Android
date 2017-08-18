package com.android.shadow.adapter.search.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.shadow.model.output.SearchAllTypeListResponse;
import com.android.shadow.views.search.ScreenSlidePageFragment;

import java.util.ArrayList;

/**
 * Created by singhgharjyot on 7/27/2017.
 */

public class ScreenSlideAllTypePagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<SearchAllTypeListResponse.Data> dataList;
    private String mFilterSelected;
    private ScreenSlidePageFragment screenSliderFragment;

    public ScreenSlideAllTypePagerAdapter(FragmentManager fm, ArrayList<SearchAllTypeListResponse.Data> data, String filteredSelected) {
        super(fm);
        this.mFilterSelected = filteredSelected;
        this.dataList = data;
    }

    @Override
    public Fragment getItem(int position) {
        screenSliderFragment = new ScreenSlidePageFragment(dataList, position, mFilterSelected, "all_type");
        return screenSliderFragment;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    public void updateList(ArrayList<SearchAllTypeListResponse.Data> data) {
        this.dataList = data;
        notifyDataSetChanged();
    }
}

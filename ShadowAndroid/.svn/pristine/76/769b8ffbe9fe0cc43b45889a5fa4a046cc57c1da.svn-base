package com.android.shadow.adapter.search.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.shadow.model.output.SearchSimpleResponse;
import com.android.shadow.views.search.ScreenSlidePageFragment;

import java.util.ArrayList;

/**
 * Created by singhgharjyot on 7/27/2017.
 */

public class ScreenSlideSimpleListPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<SearchSimpleResponse.Data> dataList;
    private ScreenSlidePageFragment screenSliderFragment;
    private String mFilterSelected;

    public ScreenSlideSimpleListPagerAdapter(FragmentManager fm, ArrayList<SearchSimpleResponse.Data> data, String filterSelected) {
        super(fm);
        this.mFilterSelected = filterSelected;
        this.dataList = data;
    }

    @Override
    public Fragment getItem(int position) {
        screenSliderFragment = new ScreenSlidePageFragment(dataList, position, mFilterSelected, "simple", "");
        return screenSliderFragment;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    public void updateList(ArrayList<SearchSimpleResponse.Data> data) {
        this.dataList = data;
        notifyDataSetChanged();
    }
}

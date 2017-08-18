package com.android.shadow.adapter.search.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.shadow.model.output.SearchLocationListResponse;
import com.android.shadow.views.search.ScreenSlidePageFragment;

import java.util.ArrayList;

/**
 * This pager adapter is called when user selects location from {@link com.android.shadow.views.search.SearchFragment}
 * and then click on three horizontal dot menu
 *
 * @author singhgharjyot
 * @version 1.0
 */

public class ScreenSlideLocationPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<SearchLocationListResponse.Data> dataList;
    private ScreenSlidePageFragment screenSliderFragment;

    public ScreenSlideLocationPagerAdapter(FragmentManager fm, ArrayList<SearchLocationListResponse.Data> data) {
        super(fm);
        this.dataList = data;
    }

    @Override
    public Fragment getItem(int position) {
        screenSliderFragment = new ScreenSlidePageFragment(dataList, position, "location");
        return screenSliderFragment;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    public void updateList(ArrayList<SearchLocationListResponse.Data> data) {
        this.dataList = data;
        notifyDataSetChanged();
    }
}

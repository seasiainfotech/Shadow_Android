package com.android.shadow.views.search;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.model.output.SearchSimpleResponse;
import com.android.shadow.presenter.SearchPresenter;
import com.android.shadow.utils.BundleKeys;
import com.android.shadow.views.core.BaseFragment;

import java.util.ArrayList;

/**
 * Created by jindaldipanshu on 5/30/2017.
 */

public class SearchFragment extends BaseFragment implements View.OnClickListener, SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    private ImageView mBackBtn;
    private SearchView mSearchView;
    private ImageView mLocationFilter, mSchoolFilter, mTrendsFilter, mCompanyFilter;
    Bundle bundleIntentType;
    private ImageView mOccupationsFilter;
    private SearchPresenter searchPresenter;
    private ArrayList<SearchSimpleResponse.Data> mSimpleList;
    private ImageView mThreeLineBtn, mThreeDotBtn;

    @Override
    public void dispose() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    protected void initViews(View view) {
        //mBackBtn = (ImageView) view.findViewById(R.id.image_view_back);
        mSearchView = (SearchView) view.findViewById(R.id.search_view_search_fragment);
        // mOccupationFilter = (ImageView) view.findViewById(R.id.search_view_occupation);
//        mCompanyFilter = (ImageView) view.findViewById(R.id.search_view_company);
//        mLocationFilter = (ImageView) view.findViewById(R.id.search_view_location);
//        mSchoolFilter = (ImageView) view.findViewById(R.id.search_view_school);
//        mTrendsFilter = (ImageView) view.findViewById(R.id.search_view_trends);
//        mOccupationsFilter = (ImageView) view.findViewById(R.id.search_view_occupations);




        findViewById(R.id.search_view_company).setOnClickListener(this);
        findViewById(R.id.search_view_location).setOnClickListener(this);
        findViewById(R.id.search_view_school).setOnClickListener(this);
        findViewById(R.id.search_view_trends).setOnClickListener(this);
        findViewById(R.id.search_view_occupations).setOnClickListener(this);


        mThreeDotBtn = (ImageView) findViewById(R.id.Image_view_three_dot);
        mThreeLineBtn = (ImageView) findViewById(R.id.Image_view_menu);

        int id = mSearchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);
        TextView textView = (TextView) mSearchView.findViewById(id);
        textView.setTextColor(Color.WHITE);
        //mBackBtn.setOnClickListener(this);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setOnClickListener(this);
        mSearchView.setOnCloseListener(this);
        mSimpleList = new ArrayList<>();


        mSearchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundleIntentType = new Bundle();
                bundleIntentType.putString(BundleKeys.BUNDLE_FILTER_SELECTED, "simple");
                Intent intentAll = new Intent(getBaseActivity(), SearchResultActivity.class);
                intentAll.putExtras(bundleIntentType);
                startActivity(intentAll);
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_view_search_fragment:
                bundleIntentType = new Bundle();
                bundleIntentType.putString(BundleKeys.BUNDLE_FILTER_SELECTED, "simple");
                Intent intentAll = new Intent(getBaseActivity(), SearchResultActivity.class);
                intentAll.putExtras(bundleIntentType);
                startActivity(intentAll);
                break;

            case R.id.search_view_company:
                bundleIntentType = new Bundle();
                bundleIntentType.putString(BundleKeys.BUNDLE_FILTER_SELECTED, "company");
                Intent intentCompany = new Intent(getBaseActivity(), SearchResultActivity.class);
                intentCompany.putExtras(bundleIntentType);
                startActivity(intentCompany);
                break;

            case R.id.search_view_location:
                if (!gpsEnable()) {
                    return;
                }

                bundleIntentType = new Bundle();
                bundleIntentType.putString(BundleKeys.BUNDLE_FILTER_SELECTED, "location");
                Intent intentLocation = new Intent(getBaseActivity(), SearchResultActivity.class);
                intentLocation.putExtras(bundleIntentType);
                startActivity(intentLocation);
                break;

            case R.id.search_view_school:
                bundleIntentType = new Bundle();
                bundleIntentType.putString(BundleKeys.BUNDLE_FILTER_SELECTED, "school");
                Intent intentSchool = new Intent(getBaseActivity(), SearchResultActivity.class);
                intentSchool.putExtras(bundleIntentType);
                startActivity(intentSchool);
                break;

            case R.id.search_view_trends:
                bundleIntentType = new Bundle();
                bundleIntentType.putString(BundleKeys.BUNDLE_FILTER_SELECTED, "trend");
                Intent intentTrends = new Intent(getBaseActivity(), SearchResultActivity.class);
                intentTrends.putExtras(bundleIntentType);
                startActivity(intentTrends);
                break;

            case R.id.search_view_occupations:
                bundleIntentType = new Bundle();
                bundleIntentType.putString(BundleKeys.BUNDLE_FILTER_SELECTED, "occupation");
                Intent intentOccupations = new Intent(getBaseActivity(), SearchResultActivity.class);
                intentOccupations.putExtras(bundleIntentType);
                startActivity(intentOccupations);
                break;

        }
    }


    public boolean gpsEnable() {
        final LocationManager manager = (LocationManager) getBaseActivity().getSystemService(Context.LOCATION_SERVICE);
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
            return false;
        } else {

            return true;
        }
    }

    protected void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getBaseActivity());
        builder.setMessage("Your GPS seems to be disabled, you need to enable your gps")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        int length = s.length();
        if (length >= 3 || length == 0) {
            mSimpleList = new ArrayList<>();
            searchPresenter.checkValidationsSimpleSearchList(s, "0");
        }

        return false;
    }

    @Override
    public boolean onClose() {
        return false;
    }
}

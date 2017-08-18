package com.android.shadow.views.dashboard;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.shadow.R;
import com.android.shadow.model.output.GetProfileResponse;
import com.android.shadow.utils.BundleKeys;
import com.android.shadow.utils.PreferenceKeys;
import com.android.shadow.views.profile.ProfileBaseFragment;
import com.android.shadow.views.profile.editprofile.EditProfileCompanyActivity;
import com.android.shadow.views.profile.editprofile.EditProfileSchoolActivity;
import com.android.shadow.views.profile.editprofile.EditProfileUserActivity;
import com.android.shadow.views.ratingcomment.UserOwnRatingViewActivity;
import com.android.shadow.views.search.SearchFragment;
import com.android.shadow.views.search.SearchResultActivity;

public class DashboardActivity extends DasdboardBaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    private ImageView mShadowIcon;
    private LinearLayout mRatingLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initViews() {
        super.initViews();
        //mBlogImageView.setOnClickListener(this);

        //mRatingLayout = (LinearLayout) toolbar.findViewById(R.id.ll_rating);
        //mRatingLayout.setOnClickListener(this);

        navigationView.setNavigationItemSelectedListener(this);

        mProfileImageView.setOnClickListener(this);
        mSearchImageView.setOnClickListener(this);
        mProfileView.setOnClickListener(this);
        mSearchView.setOnClickListener(this);

        toolbar.findViewById(R.id.search_view_search_fragment).setOnClickListener(this);
        replaceProfileFragment();
        String userID = mSharedPrefsHelper.get(PreferenceKeys.PREF_USER_ID);

        navigationView.findViewById(R.id.text_view_edit_profile).setOnClickListener(this);
        navigationView.findViewById(R.id.text_view_log_out).setOnClickListener(this);

       // findViewById(R.id.image_view_notification).setOnClickListener(this);
        findViewById(R.id.text_view_help).setOnClickListener(this);
        findViewById(R.id.rl_shadow_me).setOnClickListener(this);
        findViewById(R.id.iv_message).setOnClickListener(this);
        findViewById(R.id.iv_request).setOnClickListener(this);
        //rl_shadow_me
        Log.e("userID-------", userID);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_message) {
            showToast("coming soon");
        } else if (id == R.id.iv_request) {
            showToast("coming soon");
        } else if (id == R.id.text_view_log_out) {
            showLogoutConfirmPopup();
        } else if (id == R.id.rl_shadow_me) {
            showToast("coming soon");
        } else if (id == R.id.text_view_help) {
            showToast("coming soon");
        } else if (id == R.id.text_view_edit_profile) {
            if (getCurrentFragment() instanceof ProfileBaseFragment) {
                GetProfileResponse profileResponse = ((ProfileBaseFragment) getCurrentFragment()).profileResponse;
                if (profileResponse != null && profileResponse.getData() != null) {
                    Intent intent = null;
                    if (mUserRole.contains("USER") || mUserRole.contains("user")) {
                        intent = new Intent(this, EditProfileUserActivity.class);
                    } else if (mUserRole.contains("SCHOOL") || mUserRole.contains("school")) {
                        intent = new Intent(this, EditProfileSchoolActivity.class);
                    } else if (mUserRole.contains("COMPANY") || mUserRole.contains("company")) {
                        intent = new Intent(this, EditProfileCompanyActivity.class);
                    }
                    intent.putExtra("profile_response", profileResponse);
                    startActivity(intent);
                }
            }
        } else if (id == R.id.search_view_search_fragment) {
            Bundle bundleIntentType = new Bundle();
            bundleIntentType.putString(BundleKeys.BUNDLE_FILTER_SELECTED, "simple");
            Intent intentAll = new Intent(this, SearchResultActivity.class);
            intentAll.putExtras(bundleIntentType);
            startActivity(intentAll);

        } /*else if (id == R.id.ll_rating) {
            Intent intent;
            if (getCurrentFragment() instanceof ProfileBaseFragment) {
                GetProfileResponse profileResponse = ((ProfileBaseFragment) getCurrentFragment()).profileResponse;

                if (profileResponse != null && profileResponse.getData() != null
                        && !TextUtils.isEmpty(profileResponse.getData().getAvgRating()) && !profileResponse.getData().getAvgRating().equals("0.0")
                        ) {
                    intent = new Intent(DashboardActivity.this, UserOwnRatingViewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("role", mUserRole);
                    bundle.putString("user_id", mUserId);
                    bundle.putString("name", profileResponse.getData().getUserName());
                    bundle.putString("profile_image", profileResponse.getData().getProfileImageUrl());
                    bundle.putString("avg_rating", profileResponse.getData().getAvgRating());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }

        } */else if (id == R.id.image_view_profile || id == R.id.view_profile) {
            mRatingRl.setVisibility(View.VISIBLE);
            mSearchRl.setVisibility(View.GONE);
            toolbar.setVisibility(View.VISIBLE);
            replaceProfileFragment();

            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            mProfileImageView.setBackground(ContextCompat.getDrawable(DashboardActivity.this, R.drawable.profile_purple));
            mSearchImageView.setBackground(ContextCompat.getDrawable(DashboardActivity.this, R.drawable.ic_search_gray));

        } else if (id == R.id.image_view_search || id == R.id.view_search) {
            mRatingRl.setVisibility(View.GONE);
            toolbar.setVisibility(View.GONE);
            mSearchRl.setVisibility(View.VISIBLE);
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

            replaceFragment(new SearchFragment(), null);
            mProfileImageView.setBackground(ContextCompat.getDrawable(DashboardActivity.this, R.drawable.profile_gray));
            mSearchImageView.setBackground(ContextCompat.getDrawable(DashboardActivity.this, R.drawable.ic_search_purple));
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_shadow_me) {
            // Handle the camera action
            showToast("Coming Soon");

        } else if (id == R.id.nav_edit_profile) {
            if (getCurrentFragment() instanceof ProfileBaseFragment) {
                GetProfileResponse profileResponse = ((ProfileBaseFragment) getCurrentFragment()).profileResponse;
                if (profileResponse != null && profileResponse.getData() != null) {
                    Intent intent = null;
                    if (mUserRole.contains("USER") || mUserRole.contains("user")) {
                        intent = new Intent(this, EditProfileUserActivity.class);
                    } else if (mUserRole.contains("SCHOOL") || mUserRole.contains("school")) {
                        intent = new Intent(this, EditProfileSchoolActivity.class);
                    } else if (mUserRole.contains("COMPANY") || mUserRole.contains("company")) {
                        intent = new Intent(this, EditProfileCompanyActivity.class);
                    }
                    intent.putExtra("profile_response", profileResponse);
                    startActivity(intent);
                }
            }
        } else if (id == R.id.nav_help) {
            showToast("Coming Soon");

        } else if (id == R.id.nav_logout) {
            showLogoutConfirmPopup();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
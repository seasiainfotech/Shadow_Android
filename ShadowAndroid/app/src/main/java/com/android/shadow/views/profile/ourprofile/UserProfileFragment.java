package com.android.shadow.views.profile.ourprofile;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.adapter.profile.ProfileInterestsAdapter;
import com.android.shadow.adapter.profile.ProfileOccupationsAdapter;
import com.android.shadow.model.output.GetProfileResponse;
import com.android.shadow.presenter.ProfilePresenter;
import com.android.shadow.views.ExpandableHeightGridView;
import com.android.shadow.views.auth.LoginActivity;
import com.android.shadow.views.dashboard.DashboardActivity;
import com.android.shadow.views.profile.AnotherUserProfileActivity;
import com.android.shadow.views.profile.FullImageActivity;
import com.android.shadow.views.profile.ProfileBaseFragment;
import com.android.shadow.views.profile.editprofile.EditProfileUserActivity;
import com.android.shadow.views.ratingcomment.UserOwnRatingViewActivity;
import com.android.shadow.views.videoRecording.VideoPlayActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import retrofit2.Response;

/**
 * Created by jindaldipanshu on 5/30/2017.
 */

public class UserProfileFragment extends ProfileBaseFragment implements View.OnClickListener,
        ProfilePresenter.ProfileCallback {

    private ProfileInterestsAdapter mInterestsAdapter;
    private ProfileOccupationsAdapter mOccupationsAdapter;
    private ExpandableHeightGridView mInterestsGridView;
    private ArrayList<GetProfileResponse.Interest> mInterestsList;
    private ScrollView parentScroll, childScroll;
    private TextView mAverageRatingTextView, mNoOfRatings, mNoOfRatingsText;
    private ImageView mSchoolNameImageView, mCompanyNameImageView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_profile;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initViews(final View view) {
        super.initViews(view);

        mInterestsGridView = (ExpandableHeightGridView) view.findViewById(R.id.grid_view_interests);
        mInterestsGridView.setExpanded(true);

        // mUserNameTextView = (TextView) view.findViewById(R.id.text_view_user_name);
        mSchoolNmTextView = (TextView) view.findViewById(R.id.text_view_school);
        mCompNmTextView = (TextView) view.findViewById(R.id.text_view_comp);
        registerListener();
        mInterestsList = new ArrayList<>();

        parentScroll = (ScrollView) view.findViewById(R.id.s1);
        //childScroll = (ScrollView) view.findViewById(R.id.s2);

        mAverageRatingTextView = (TextView) view.findViewById(R.id.text_view_average_rating);
        mSchoolNameImageView = (ImageView) view.findViewById(R.id.iv_school_name);
        mCompanyNameImageView = (ImageView) view.findViewById(R.id.iv_company);
        mNoOfRatings = (TextView) view.findViewById(R.id.tv_no_of_rating);
        mNoOfRatingsText = (TextView) view.findViewById(R.id.tv_No_of_rating_text);

        mNoOfRatings.setOnClickListener(this);
        mNoOfRatingsText.setOnClickListener(this);


//        parentScroll.setOnTouchListener(new View.OnTouchListener() {
//
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.v(TAG,"PARENT TOUCH");
//                view.findViewById(R.id.s2).getParent().requestDisallowInterceptTouchEvent(false);
//                return false;
//            }
//        });
//        childScroll.setOnTouchListener(new View.OnTouchListener() {
//
//            public boolean onTouch(View v, MotionEvent event)
//            {
//                Log.v(TAG,"CHILD TOUCH");
//                // Disallow the touch request for parent scroll on touch of child view
//                v.getParent().requestDisallowInterceptTouchEvent(true);
//                return false;
//            }
//        });

    }

    @Override
    public void onStart() {
        super.onStart();
        if (mProfilePresenter == null) {
            mProfilePresenter = new ProfilePresenter(this, this);
        }
        mProfilePresenter.checkValidations(mUserid);
    }

    @Override
    public void dispose() {
        if (mProfilePresenter != null) {
            mProfilePresenter = null;
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_edit:
                if (profileResponse != null && profileResponse.getData() != null) {
                    intent = new Intent(getActivity(), EditProfileUserActivity.class);
                    intent.putExtra("profile_response", profileResponse);
                    startActivity(intent);
                }
                break;
            case R.id.text_view_school:
                Intent intentSchoolProfie = new Intent(getActivity(), AnotherUserProfileActivity.class);
                Bundle bundleSchoolProfile = new Bundle();
                // TODO add shool userid here
                bundleSchoolProfile.putString("user_id", profileResponse.getData().getSchoolDTO().getId());
                bundleSchoolProfile.putString("user_role", "SCHOOL");
                intentSchoolProfie.putExtras(bundleSchoolProfile);
                startActivity(intentSchoolProfie);
                break;

            case R.id.text_view_comp:
                Intent intentCompProfie = new Intent(getActivity(), AnotherUserProfileActivity.class);
                Bundle bundleCompProfile = new Bundle();
                // TODO add the userid of company here
                bundleCompProfile.putString("user_id", profileResponse.getData().getCompanyDTO().getId());
                bundleCompProfile.putString("user_role", "COMPANY");
                intentCompProfie.putExtras(bundleCompProfile);
                startActivity(intentCompProfie);
                break;
            case R.id.iv_settings:
                //showToast(R.string.coming_soon);

                break;
            case R.id.iv_notification:
                showToast(R.string.coming_soon);
                break;
            case R.id.iv_request:
                showToast(R.string.coming_soon);
                break;
            case R.id.iv_message:
                showToast(R.string.coming_soon);
                break;
            case R.id.iv_video:
                if (profileResponse != null && profileResponse.getData() != null && !TextUtils.isEmpty(profileResponse.getData().getVideoUrl())) {
                    intent = new Intent(getBaseActivity(), VideoPlayActivity.class);
                    intent.putExtra("video_url", profileResponse.getData().getVideoUrl());
                    startActivity(intent);
                } else {
                    showToast("No video recorded");
                }
                break;
            case R.id.iv_user_profile:
                if (profileResponse != null && profileResponse.getData() != null) {
                    intent = new Intent(getBaseActivity(), FullImageActivity.class);
                    intent.putExtra("user_image", profileResponse.getData().getProfileImageUrl());
                    startActivity(intent);
                }
                break;

            case R.id.iv_url1:
                if (mSelectedMediaList != null && mSelectedMediaList.size() > 0) {
                    callWebIntent(mSelectedMediaList.get(0).getUrl());
                }
                break;

            case R.id.tv_url1:
                if (mSelectedMediaList != null && mSelectedMediaList.size() > 0) {
                    callWebIntent(mSelectedMediaList.get(0).getUrl());
                }
                break;

            case R.id.iv_url2:
                if (mSelectedMediaList != null && mSelectedMediaList.size() >= 2) {
                    callWebIntent(mSelectedMediaList.get(1).getUrl());
                }
                break;

            case R.id.tv_url2:
                if (mSelectedMediaList != null && mSelectedMediaList.size() >= 2) {
                    callWebIntent(mSelectedMediaList.get(1).getUrl());
                }
                break;

            case R.id.iv_url3:
                if (mSelectedMediaList != null && mSelectedMediaList.size() >= 3) {
                    callWebIntent(mSelectedMediaList.get(2).getUrl());
                }
                break;

            case R.id.tv_url3:
                if (mSelectedMediaList != null && mSelectedMediaList.size() >= 3) {
                    callWebIntent(mSelectedMediaList.get(2).getUrl());
                }
                break;

            case R.id.tv_no_of_rating:
                if (profileResponse != null && profileResponse.getData() != null
                        && !TextUtils.isEmpty(profileResponse.getData().getAvgRating()) && !profileResponse.getData().getAvgRating().equals("0.0")
                        ) {
                    intent = new Intent(getActivity(), UserOwnRatingViewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("role", "user");
                    bundle.putString("user_id", mUserid);
                    bundle.putString("name", profileResponse.getData().getUserName());
                    bundle.putString("profile_image", profileResponse.getData().getProfileImageUrl());
                    bundle.putString("avg_rating", profileResponse.getData().getAvgRating());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
            case R.id.tv_No_of_rating_text:
                if (profileResponse != null && profileResponse.getData() != null
                        && !TextUtils.isEmpty(profileResponse.getData().getAvgRating()) && !profileResponse.getData().getAvgRating().equals("0.0")
                        ) {
                    intent = new Intent(getActivity(), UserOwnRatingViewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("role", "user");
                    bundle.putString("user_id", mUserid);
                    bundle.putString("name", profileResponse.getData().getUserName());
                    bundle.putString("profile_image", profileResponse.getData().getProfileImageUrl());
                    bundle.putString("avg_rating", profileResponse.getData().getAvgRating());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
           /* case R.id.ll_rating:
                if (profileResponse != null && profileResponse.getData() != null
                        && !TextUtils.isEmpty(profileResponse.getData().getAvgRating()) && !profileResponse.getData().getAvgRating().equals("0.0")
                        ) {
                    intent = new Intent(getActivity(), UserOwnRatingViewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("role", "user");
                    bundle.putString("user_id", mUserid);
                    bundle.putString("name", profileResponse.getData().getUserName());
                    bundle.putString("profile_image", profileResponse.getData().getProfileImageUrl());
                    bundle.putString("avg_rating", profileResponse.getData().getAvgRating());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;*/
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onProfileSuccess(Response<GetProfileResponse> response) {
        if (response != null && response.body() != null) {
            if (response.body().getStatus().equals("200")) {
                Log.e("profile response -----", "successfull");
                setDataOnUi(response);
            } else if (response.body().getStatus().equals("401")) {
                sharedPrefsHelper.clearAll();
                Intent intent = new Intent(getBaseActivity(), LoginActivity.class);
                getBaseActivity().startActivity(intent);
                getBaseActivity().finish();
            } else {
                showToast(response.body().getMessage());
            }
        } else {
            showToast(R.string.server_error_msg);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setDataOnUi(Response<GetProfileResponse> response) {
        profileResponse = response.body();
        if (profileResponse != null) {
            if (profileResponse.getData().getUserName() != null) {
                ((DashboardActivity) getBaseActivity()).setName(profileResponse.getData().getUserName());
                // mUserNameTextView.setText(profileResponse.getData().getUserName());
            } else {
                ((DashboardActivity) getBaseActivity()).setName("");
                //mUserNameTextView.setText("N/A");
            }

            if (profileResponse.getData().getRatingCount() != null) {
                mNoOfRatings.setText(profileResponse.getData().getRatingCount());
            }

            if (profileResponse.getData().getProfileImageUrl() != null) {
                Glide.with(this).load(profileResponse.getData().getProfileImageUrl()).into(mUserImagView);
            }
            if (profileResponse.getData().getSchoolName() != null && !profileResponse.getData().getSchoolName().equals("")) {
                mSchoolNmTextView.setText(profileResponse.getData().getSchoolName());
                mSchoolNmTextView.setVisibility(View.VISIBLE);
                mSchoolNameImageView.setVisibility(View.VISIBLE);
            } else {
                mSchoolNmTextView.setVisibility(View.GONE);
                mSchoolNmTextView.setText("N/A");
                mSchoolNameImageView.setVisibility(View.GONE);
            }

            if (profileResponse.getData().getCompanyName() != null && !profileResponse.getData().getCompanyName().equals("")) {
                mCompNmTextView.setText(profileResponse.getData().getCompanyName());
                mCompNmTextView.setVisibility(View.VISIBLE);
                mCompanyNameImageView.setVisibility(View.VISIBLE);
            } else {
                mCompNmTextView.setVisibility(View.GONE);
                mCompNmTextView.setText("N/A");
                mCompanyNameImageView.setVisibility(View.GONE);
            }
            if (profileResponse.getData().getBio() != null && !profileResponse.getData().getBio().equals("")) {
                mBioTextView.setVisibility(View.VISIBLE);
                mBioTextView.setText(profileResponse.getData().getBio());
            } else {
                mBioTextView.setVisibility(View.GONE);
                mBioTextView.setText("N/A");
            }

            if (profileResponse.getData().getInterest() != null && profileResponse.getData().getInterest().size() > 0) {
                mInterestsList = response.body().getData().getInterest();
                setInterestsAdapter();
            }

            if (profileResponse.getData().getOccupations() != null && profileResponse.getData().getOccupations().size() > 0) {
                mOccupationsList = response.body().getData().getOccupations();
                setOccupationsAdapter();
            }

            String avgRating = profileResponse.getData().getAvgRating();
            double rating = 0;
            if (!TextUtils.isEmpty(avgRating)) {
                rating = Double.parseDouble(avgRating);
            }
            mAverageRatingTextView.setText(rating + "");
            //((DashboardActivity)getBaseActivity()).setRating((int) rating);
            addSocialData(response.body());
        }
    }

    protected void setOccupationsAdapter() {
        mOccupationsAdapter = new ProfileOccupationsAdapter(this, mOccupationsList);
        mOccupationsGridView.setAdapter(mOccupationsAdapter);
    }

    protected void setInterestsAdapter() {
        mInterestsAdapter = new ProfileInterestsAdapter(this, mInterestsList);
        mInterestsGridView.setAdapter(mInterestsAdapter);
    }

    private void registerListener() {
        mUserImagView.setOnClickListener(this);
        // mNotificationImageView.setOnClickListener(this);
        // mMessageImageView.setOnClickListener(this);
        // mRequestImageView.setOnClickListener(this);
        mVideoImageView.setOnClickListener(this);
        // findViewById(R.id.ll_rating).setOnClickListener(this);
        // mEditImageView.setOnClickListener(this);
        // mSettingsImageView.setOnClickListener(this);
        mUrl1ImageView.setOnClickListener(this);
        mUrl2ImageView.setOnClickListener(this);
        mUrl3ImageView.setOnClickListener(this);
        mUrl1TextView.setOnClickListener(this);
        mUrl2TextView.setOnClickListener(this);
        mUrl3TextView.setOnClickListener(this);
        mSchoolNmTextView.setOnClickListener(this);
        mCompNmTextView.setOnClickListener(this);
    }
}

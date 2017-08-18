package com.android.shadow.views.profile.anotheruserprofile;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.adapter.profile.ProfileOccupationsAdapter;
import com.android.shadow.model.output.GetProfileResponse;
import com.android.shadow.presenter.ProfilePresenter;
import com.android.shadow.views.auth.LoginActivity;
import com.android.shadow.views.profile.FullImageActivity;
import com.android.shadow.views.profile.ProfileBaseFragment;
import com.android.shadow.views.profile.editprofile.EditProfileCompanyActivity;
import com.android.shadow.views.ratingcomment.UserOwnRatingViewActivity;
import com.android.shadow.views.videoRecording.VideoPlayActivity;
import com.bumptech.glide.Glide;

import retrofit2.Response;

/**
 * Created by jindaldipanshu on 5/30/2017.
 */

public class AnotherCompanyProfileFragment extends ProfileBaseFragment implements View.OnClickListener, ProfilePresenter.ProfileCallback {

    private TextView mCompLocationTextView, mCompUrlTextView;
    private ProfileOccupationsAdapter mOccupationsAdapter;
    private String mOtherUserId;
    private TextView mCompOccupTextView, mUserAttendTextView;
    private TextView mAverageRatingTextView, mNoOfRatingsTextView, mNoOfRatingsTextTextView;
    private ImageView mCompUrlImageView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_another_company_profile;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initViews(View view) {
        super.initViews(view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mOtherUserId = bundle.getString("user_id");
        }
        mSettingsImageView.setVisibility(View.INVISIBLE);
        mEditImageView.setVisibility(View.INVISIBLE);
        mNotificationImageView.setVisibility(View.INVISIBLE);

        mAverageRatingTextView = (TextView) view.findViewById(R.id.text_view_average_rating);
        mNoOfRatingsTextView = (TextView) view.findViewById(R.id.tv_no_of_rating);
        mNoOfRatingsTextTextView = (TextView) view.findViewById(R.id.tv_No_of_rating_text);

        mCompOccupTextView = (TextView) view.findViewById(R.id.tv_company_occupation);
        mUserAttendTextView = (TextView) view.findViewById(R.id.tv_user_attended);


        //TODO change this variable to text_view_header
        // mCompNmTextView = (TextView) view.findViewById(R.id.text_view_company_name);

        mCompUrlTextView = (TextView) view.findViewById(R.id.text_view_company_url);
        mCompUrlImageView = (ImageView) view.findViewById(R.id.iv_company_url);
        mCompLocationTextView = (TextView) view.findViewById(R.id.text_view_company_location);
        mCompUrlImageView = (ImageView) view.findViewById(R.id.iv_company_location);
        mNoOfRatingsTextView.setOnClickListener(this);
        mNoOfRatingsTextTextView.setOnClickListener(this);
        mCompLocationTextView.setOnClickListener(this);
        registerListener();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mProfilePresenter == null) {
            mProfilePresenter = new ProfilePresenter(this, this);
        }
        mProfilePresenter.otherUserProfile(mUserid, mOtherUserId);
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

            case R.id.text_view_company_url:
                String url = mCompUrlTextView.getText().toString();
                if (!TextUtils.isEmpty(url)) {
                    callWebIntent(url);
                }
                break;

            case R.id.iv_edit:
                if (profileResponse != null && profileResponse.getData() != null) {
                    intent = new Intent(getActivity(), EditProfileCompanyActivity.class);
                    intent.putExtra("profile_response", profileResponse);
                    startActivity(intent);
                }
                break;
            case R.id.iv_settings:
                showToast(R.string.coming_soon);
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
            case R.id.iv_url2:
                if (mSelectedMediaList != null && mSelectedMediaList.size() >= 2) {
                    callWebIntent(mSelectedMediaList.get(1).getUrl());
                }

                break;
            case R.id.iv_url3:
                if (mSelectedMediaList != null && mSelectedMediaList.size() >= 3) {
                    callWebIntent(mSelectedMediaList.get(2).getUrl());
                }
                break;

            case R.id.tv_url1:
                if (mSelectedMediaList != null && mSelectedMediaList.size() > 0) {
                    callWebIntent(mSelectedMediaList.get(0).getUrl());
                }
                break;

            case R.id.tv_url2:
                if (mSelectedMediaList != null && mSelectedMediaList.size() >= 2) {
                    callWebIntent(mSelectedMediaList.get(1).getUrl());
                }
                break;

            case R.id.tv_url3:
                if (mSelectedMediaList != null && mSelectedMediaList.size() >= 3) {
                    callWebIntent(mSelectedMediaList.get(2).getUrl());
                }
                break;

            case R.id.tv_no_of_rating:
                if (profileResponse != null && profileResponse.getData() != null) {
                    if (mUserid.equals(mOtherUserId)) {
                        return;
                    }
                    intent = new Intent(getActivity(), UserOwnRatingViewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("role", "company");
                    bundle.putString("user_id", mUserid);
                    bundle.putString("other_user_id", mOtherUserId);
                    bundle.putString("name", profileResponse.getData().getCompanyName());
                    bundle.putString("profile_image", profileResponse.getData().getProfileImageUrl());
                    bundle.putString("avg_rating", profileResponse.getData().getAvgRating());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;

            case R.id.tv_No_of_rating_text:
                if (profileResponse != null && profileResponse.getData() != null) {
                    if (mUserid.equals(mOtherUserId)) {
                        return;
                    }
                    intent = new Intent(getActivity(), UserOwnRatingViewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("role", "company");
                    bundle.putString("user_id", mUserid);
                    bundle.putString("other_user_id", mOtherUserId);
                    bundle.putString("name", profileResponse.getData().getCompanyName());
                    bundle.putString("profile_image", profileResponse.getData().getProfileImageUrl());
                    bundle.putString("avg_rating", profileResponse.getData().getAvgRating());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;

            case R.id.ll_rating:
                if (profileResponse != null && profileResponse.getData() != null) {
                    if (mUserid.equals(mOtherUserId)) {
                        return;
                    }
                    intent = new Intent(getActivity(), UserOwnRatingViewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("role", "company");
                    bundle.putString("user_id", mUserid);
                    bundle.putString("other_user_id", mOtherUserId);
                    bundle.putString("name", profileResponse.getData().getCompanyName());
                    bundle.putString("profile_image", profileResponse.getData().getProfileImageUrl());
                    bundle.putString("avg_rating", profileResponse.getData().getAvgRating());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
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
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
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

            if (profileResponse.getData().getSchoolOrCompanyWithTheseOccupations().getCount() != null) {
                mCompOccupTextView.setText(profileResponse.getData().getSchoolOrCompanyWithTheseOccupations().getCount());
            } else {
                mCompOccupTextView.setText("0");
            }
            if (profileResponse.getData().getSchoolOrCompanyWithTheseUsers().getCount() != null) {
                mUserAttendTextView.setText(profileResponse.getData().getSchoolOrCompanyWithTheseUsers().getCount());
            } else {
                mUserAttendTextView.setText("0");
            }

            if (profileResponse.getData().getRatingCount() != null){
                mNoOfRatingsTextView.setText(profileResponse.getData().getRatingCount());
            }

            if (profileResponse.getData().getCompanyName() != null) {
                setName(profileResponse.getData().getCompanyName());
                // mCompNmTextView.setText(profileResponse.getData().getCompanyName());
            } else {
                setName("");
                // mCompNmTextView.setText(" ");
            }
            if (profileResponse.getData().getProfileImageUrl() != null) {
                Glide.with(this).load(profileResponse.getData().getProfileImageUrl())
                        .into(mUserImagView);
            }
            if (profileResponse.getData().getCompanyUrl() != null && !profileResponse.getData().getCompanyUrl().equals("")) {
                mCompUrlTextView.setText(profileResponse.getData().getCompanyUrl());
                mCompUrlImageView.setVisibility(View.VISIBLE);
                mCompUrlTextView.setVisibility(View.VISIBLE);
            } else {
                mCompUrlImageView.setVisibility(View.GONE);
                mCompUrlTextView.setText("");
                mCompUrlTextView.setVisibility(View.GONE);
            }

            if (profileResponse.getData().getLocation() != null) {
                mCompLocationTextView.setText(profileResponse.getData().getLocation());
            } else {
                mCompLocationTextView.setText("");
            }

            if (profileResponse.getData().getBio() != null && !profileResponse.getData().getBio().equals("")) {
                mBioTextView.setText(profileResponse.getData().getBio());
                mBioTextView.setVisibility(View.GONE);
            } else {
                mBioTextView.setText("");
                mBioTextView.setVisibility(View.GONE);
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
            //setRating((int) rating);
            addSocialData(response.body());
        }
    }

    protected void setOccupationsAdapter() {
        mOccupationsAdapter = new ProfileOccupationsAdapter(this, mOccupationsList);
        mOccupationsGridView.setAdapter(mOccupationsAdapter);
    }


    private void registerListener() {
        mUserImagView.setOnClickListener(this);
        mNotificationImageView.setOnClickListener(this);
        mMessageImageView.setOnClickListener(this);
        mRequestImageView.setOnClickListener(this);
        mVideoImageView.setOnClickListener(this);
        mUrl1ImageView.setOnClickListener(this);
        mUrl2ImageView.setOnClickListener(this);
        mUrl3ImageView.setOnClickListener(this);
        mUrl1TextView.setOnClickListener(this);
        mUrl2TextView.setOnClickListener(this);
        mUrl3TextView.setOnClickListener(this);
        findViewById(R.id.ll_rating).setOnClickListener(this);
        findViewById(R.id.iv_edit).setOnClickListener(this);
        findViewById(R.id.iv_settings).setOnClickListener(this);
    }
}

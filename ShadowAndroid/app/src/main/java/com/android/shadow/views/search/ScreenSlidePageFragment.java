package com.android.shadow.views.search;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.shadow.R;
import com.android.shadow.model.SocialMedia;
import com.android.shadow.model.output.SearchAllTypeListResponse;
import com.android.shadow.model.output.SearchLocationListResponse;
import com.android.shadow.model.output.SearchSimpleResponse;
import com.android.shadow.views.profile.AnotherUserProfileActivity;
import com.android.shadow.views.videoRecording.VideoPlayActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.FACEBOOK_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GITHUB_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GOOGLE_PLUS_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.INSTAGRAM_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.LINKEDIN_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.TWITTER_KEY;

/**
 * Created by singhgharjyot on 7/4/2017.
 */

public class ScreenSlidePageFragment extends Fragment implements View.OnClickListener {

    private int mPosition;
    private Button mbutton;
    private TextView mSchoolName, mSchoolLocation, mNumberFollowing, mNumberFollowers, mSchoolUrl, mNumberOfCompaniesWithOccu,
            mNumberUsersAttendThisSchool, mBioSchool, mNumberFollowingSchool, mNumberFollowersSchool, mCompanyName, mCompanyLocation, mCompanyUrl,
            mNoFollowingCompany, mNoFollowersCompany, mSchoolsWithTheseOccu, mNoUsersEmployed, mBioCompany, mUsername, mUserSchool, mUserCompany,
            mNoFollowingUser, mNoFollowersUser, mBioUser;
    private CircleImageView mSchoolImage, mCompanyImage, mUserImage;
    private String mFilterSelected;
    private ArrayList<SearchAllTypeListResponse.Data> mAllTypeList;
    private ArrayList<SearchLocationListResponse.Data> mLocationList;
    private ArrayList<SearchSimpleResponse.Data> mSimpleList;
    private ViewGroup rootView;
    private String mRoleType = "";
    private String mServiceType; // all_type for searchalltypelistbytype, location for searchalltypeusinglocation,simple for just normal search
    private TextView mNumberCompaniesWithOccuSchool, mNumberUsersAttendedThisSchool, mViewFullProfileSchool, mViewFullProfileCompany, mViewFullProfileUser;
    private ImageView mVideoImagView, mSchoolUrlImageView;
    private ArrayList<SocialMedia.Media> mSelectedMediaList;
    private ImageView mUrl1ImageView, mUrl2ImageView, mUrl3ImageView, mStar2ImgVw, mStar3ImgVw, mStar4ImgVw, mStar5ImgVw, mStar1ImgVw;
    private String linkedinUrl, facebookUrl, googlePlusUrl, githubUrl, instagramUrl, twitterUrl, videoUrl;
    private TextView mAverageRatingTextView, mNoOfRatings, mNoOfRatingsText, mUrl1TextView, mUrl2TextView, mUrl3TextView;
    private ImageView mCompUrlImageView;
    private ImageView mSchoolNameImageView;
    private ImageView mCompNameImageView;

    public ScreenSlidePageFragment(ArrayList<SearchAllTypeListResponse.Data> dataList, int position, String filterSelected, String serviceType) {
        mAllTypeList = dataList;
        mPosition = position;
        mFilterSelected = filterSelected;
        mServiceType = serviceType;
    }

    public ScreenSlidePageFragment(ArrayList<SearchLocationListResponse.Data> dataList, int position, String serviceType) {
        mLocationList = dataList;
        mPosition = position;
        mServiceType = serviceType;
    }

    public ScreenSlidePageFragment(ArrayList<SearchSimpleResponse.Data> dataList, int position, String mFilterSelected, String serviceType, String s) {
        mSimpleList = dataList;
        mPosition = position;
        mServiceType = serviceType;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (mServiceType.equals("location")) {
            if (mLocationList != null) {
                mRoleType = mLocationList.get(mPosition).getUserDTO().getRole();
            }
            linkedinUrl = mLocationList.get(mPosition).getUserDTO().getLinkedInUrl();
            facebookUrl = mLocationList.get(mPosition).getUserDTO().getFacebookUrl();
            githubUrl = mLocationList.get(mPosition).getUserDTO().getGitHubUrl();
            twitterUrl = mLocationList.get(mPosition).getUserDTO().getTwitterUrl();
            instagramUrl = mLocationList.get(mPosition).getUserDTO().getInstagramUrl();
            googlePlusUrl = mLocationList.get(mPosition).getUserDTO().getGooglePlusUrl();
            videoUrl = mLocationList.get(mPosition).getUserDTO().getVideoUrl();

            if (mRoleType.equals("SCHOOL")) {
                rootView = (ViewGroup) inflater.inflate(
                        R.layout.fragment_screen_slide_school_page, container, false);
                if (mLocationList != null) {
                   /* mStar1ImgVw =(ImageView)rootView.findViewById(R.id.iv_star1);
                    mStar2ImgVw =(ImageView)rootView.findViewById(R.id.iv_star2);
                    mStar3ImgVw =(ImageView)rootView.findViewById(R.id.iv_star3);
                    mStar4ImgVw =(ImageView)rootView.findViewById(R.id.iv_star4);
                    mStar5ImgVw =(ImageView)rootView.findViewById(R.id.iv_star5);*/
                    rootView.findViewById(R.id.iv_video).setOnClickListener(this);
                    mSchoolImage = (CircleImageView) rootView.findViewById(R.id.iv_user_profile);
                    mAverageRatingTextView = (TextView) rootView.findViewById(R.id.text_view_average_rating);
                    mNoOfRatings = (TextView) rootView.findViewById(R.id.tv_no_of_rating);
                    mNoOfRatingsText = (TextView) rootView.findViewById(R.id.tv_No_of_rating_text);
                    mSchoolUrlImageView = (ImageView) rootView.findViewById(R.id.iv_school_url);

                    mNoOfRatings.setOnClickListener(this);
                    mNoOfRatingsText.setOnClickListener(this);

                    // mSchoolName = (TextView) rootView.findViewById(R.id.text_view_user_name);
                    mSchoolLocation = (TextView) rootView.findViewById(R.id.text_view_school_location);
                    mSchoolUrl = (TextView) rootView.findViewById(R.id.text_view_school_url);
                    mSchoolUrl.setOnClickListener(this);
                    mNumberFollowingSchool = (TextView) rootView.findViewById(R.id.tv_following);
                    mNumberFollowersSchool = (TextView) rootView.findViewById(R.id.tv_followers);
                    mNumberCompaniesWithOccuSchool = (TextView) rootView.findViewById(R.id.tv_no_companies_with_occupations);
                    mNumberUsersAttendedThisSchool = (TextView) rootView.findViewById(R.id.tv_users_this_school);
                    mBioSchool = (TextView) rootView.findViewById(R.id.text_view_bio);
                    mViewFullProfileSchool = (TextView) rootView.findViewById(R.id.text_view_full_profile_school);
                    mViewFullProfileSchool.setOnClickListener(this);

                    Glide.with(this).load(mLocationList.get(mPosition).getUserDTO().getProfileImageUrl()).
                            error(getActivity().getResources().getDrawable(R.drawable.profile_gray)).
                            into(mSchoolImage);
                    mNoOfRatings.setText(mLocationList.get(mPosition).getRatingCount());
                    //((SearchResultBaseActivity)getActivity()).setName(mLocationList.get(mPosition).getName());
                    // mSchoolName.setText(mLocationList.get(mPosition).getName());
                    if (mLocationList.get(mPosition).getUserDTO().getSchoolUrl() != null && !mLocationList.get(mPosition).getUserDTO().getSchoolUrl().equals("")) {
                        mSchoolUrl.setText(mLocationList.get(mPosition).getUserDTO().getSchoolUrl());
                        mSchoolUrl.setVisibility(View.VISIBLE);
                        mSchoolUrlImageView.setVisibility(View.VISIBLE);
                    } else {
                        mSchoolUrl.setVisibility(View.GONE);
                        mSchoolUrlImageView.setVisibility(View.GONE);
                    }
                    mSchoolLocation.setText(mLocationList.get(mPosition).getAddress());
                    if (mLocationList.get(mPosition).getUserDTO().getBio() != null && mLocationList.get(mPosition).getUserDTO().getBio().equals("")) {
                        mBioSchool.setText(mLocationList.get(mPosition).getUserDTO().getBio());
                        mBioSchool.setVisibility(View.VISIBLE);
                    } else {
                        mBioSchool.setVisibility(View.GONE);
                    }


                    mNumberFollowingSchool.setText(mLocationList.get(mPosition).getUserDTO().getShadowedByShadowUser().getCount());
                    mNumberFollowersSchool.setText(mLocationList.get(mPosition).getUserDTO().getShadowersVerified().getCount());
                    mNumberCompaniesWithOccuSchool.setText(mLocationList.get(mPosition).getUserDTO().getSchoolOrCompanyWithTheseOccupations().getCount());
                    mNumberUsersAttendedThisSchool.setText(mLocationList.get(mPosition).getUserDTO().getSchoolOrCompanyWithTheseUsers().getCount());

                    mUrl1ImageView = (ImageView) rootView.findViewById(R.id.iv_url1);
                    mUrl2ImageView = (ImageView) rootView.findViewById(R.id.iv_url2);
                    mUrl3ImageView = (ImageView) rootView.findViewById(R.id.iv_url3);
                    mUrl1TextView = (TextView) rootView.findViewById(R.id.tv_url1);
                    mUrl2TextView = (TextView) rootView.findViewById(R.id.tv_url2);
                    mUrl3TextView = (TextView) rootView.findViewById(R.id.tv_url3);
                    registerUrlListsner();
                    addSocialData();
                    String avgRating = mLocationList.get(mPosition).getAvgRating();
                    double rating = 0;
                    if (!TextUtils.isEmpty(avgRating)) {
                        rating = Double.parseDouble(avgRating);
                    }
                    mAverageRatingTextView.setText(rating + "");
                    //  setRating((int) rating);
                }
            } else if (mRoleType.equals("COMPANY")) {
                rootView = (ViewGroup) inflater.inflate(
                        R.layout.fragment_screen_slide_company_page, container, false);
                if (mLocationList != null) {
                   /* mStar1ImgVw =(ImageView)rootView.findViewById(R.id.iv_star1);
                    mStar2ImgVw =(ImageView)rootView.findViewById(R.id.iv_star2);
                    mStar3ImgVw =(ImageView)rootView.findViewById(R.id.iv_star3);
                    mStar4ImgVw =(ImageView)rootView.findViewById(R.id.iv_star4);
                    mStar5ImgVw =(ImageView)rootView.findViewById(R.id.iv_star5);*/
                    rootView.findViewById(R.id.iv_video).setOnClickListener(this);
                    mCompanyImage = (CircleImageView) rootView.findViewById(R.id.iv_user_profile);
                    mAverageRatingTextView = (TextView) rootView.findViewById(R.id.text_view_average_rating);
                    mNoOfRatings = (TextView) rootView.findViewById(R.id.tv_no_of_rating);
                    mNoOfRatingsText = (TextView) rootView.findViewById(R.id.tv_No_of_rating_text);
                    mNoOfRatings.setOnClickListener(this);
                    mNoOfRatingsText.setOnClickListener(this);

                    mCompUrlImageView = (ImageView) rootView.findViewById(R.id.iv_company_url);
                    // mCompanyName = (TextView) rootView.findViewById(R.id.text_view_user_name);
                    mCompanyLocation = (TextView) rootView.findViewById(R.id.text_view_location);
                    mCompanyUrl = (TextView) rootView.findViewById(R.id.text_view_comp_url);
                    mCompanyUrl.setOnClickListener(this);
                    mNoFollowingCompany = (TextView) rootView.findViewById(R.id.tv_following);
                    mNoFollowersCompany = (TextView) rootView.findViewById(R.id.tv_followers);
                    mSchoolsWithTheseOccu = (TextView) rootView.findViewById(R.id.tv_school_with_occupatons);
                    mNoUsersEmployed = (TextView) rootView.findViewById(R.id.tv_users_employed);
                    mBioCompany = (TextView) rootView.findViewById(R.id.text_view_bio);
                    mViewFullProfileCompany = (TextView) rootView.findViewById(R.id.text_view_full_profile_company);
                    mViewFullProfileCompany.setOnClickListener(this);


                    Glide.with(this).load(mLocationList.get(mPosition).getUserDTO().getProfileImageUrl()).
                            error(getActivity().getResources().getDrawable(R.drawable.profile_gray)).
                            into(mCompanyImage);
                    mNoOfRatings.setText(mLocationList.get(mPosition).getRatingCount());

                    if (mLocationList.get(mPosition).getUserDTO().getBio() != null && !mLocationList.get(mPosition).getUserDTO().getBio().equals("")) {
                        mBioCompany.setText(mLocationList.get(mPosition).getUserDTO().getBio());
                        mBioCompany.setVisibility(View.VISIBLE);
                    } else {
                        mBioCompany.setVisibility(View.GONE);
                    }

                    mNoFollowingCompany.setText(mLocationList.get(mPosition).getUserDTO().getShadowersVerified().getCount());
                    mNoFollowersCompany.setText(mLocationList.get(mPosition).getUserDTO().getShadowedByShadowUser().getCount());
                    mSchoolsWithTheseOccu.setText(mLocationList.get(mPosition).getUserDTO().getSchoolOrCompanyWithTheseOccupations().getCount());
                    mNoUsersEmployed.setText(mLocationList.get(mPosition).getUserDTO().getSchoolOrCompanyWithTheseUsers().getCount());
                    if (mLocationList.get(mPosition).getUserDTO().getCompanyUrl() != null && !mLocationList.get(mPosition).getUserDTO().getCompanyUrl().equals("")) {
                        mCompanyUrl.setText(mLocationList.get(mPosition).getUserDTO().getCompanyUrl());
                        mCompanyUrl.setVisibility(View.VISIBLE);
                        mCompUrlImageView.setVisibility(View.VISIBLE);
                    } else {
                        mCompanyUrl.setVisibility(View.GONE);
                        mCompUrlImageView.setVisibility(View.GONE);
                    }
                    // ((SearchResultBaseActivity)getActivity()).setName(mLocationList.get(mPosition).getName());
                    // mCompanyName.setText(mLocationList.get(mPosition).getName());
                    mCompanyLocation.setText(mLocationList.get(mPosition).getUserDTO().getLocation());
                    mUrl1ImageView = (ImageView) rootView.findViewById(R.id.iv_url1);
                    mUrl2ImageView = (ImageView) rootView.findViewById(R.id.iv_url2);
                    mUrl3ImageView = (ImageView) rootView.findViewById(R.id.iv_url3);
                    mUrl1TextView = (TextView) rootView.findViewById(R.id.tv_url1);
                    mUrl2TextView = (TextView) rootView.findViewById(R.id.tv_url2);
                    mUrl3TextView = (TextView) rootView.findViewById(R.id.tv_url3);
                    registerUrlListsner();
                    addSocialData();
                    String avgRating = mLocationList.get(mPosition).getAvgRating();
                    double rating = 0;
                    if (!TextUtils.isEmpty(avgRating)) {
                        rating = Double.parseDouble(avgRating);
                    }
                    mAverageRatingTextView.setText(rating + "");
                    //setRating((int) rating);
                }
            } else if (mRoleType.equals("USER")) {
                rootView = (ViewGroup) inflater.inflate(
                        R.layout.fragment_screen_slide_user_page, container, false);
                if (mLocationList != null) {
                    /*mStar1ImgVw =(ImageView)rootView.findViewById(R.id.iv_star1);
                    mStar2ImgVw =(ImageView)rootView.findViewById(R.id.iv_star2);
                    mStar3ImgVw =(ImageView)rootView.findViewById(R.id.iv_star3);
                    mStar4ImgVw =(ImageView)rootView.findViewById(R.id.iv_star4);
                    mStar5ImgVw =(ImageView)rootView.findViewById(R.id.iv_star5);*/
                    rootView.findViewById(R.id.iv_video).setOnClickListener(this);
                    mUserImage = (CircleImageView) rootView.findViewById(R.id.iv_user_profile);
                    mAverageRatingTextView = (TextView) rootView.findViewById(R.id.text_view_average_rating);
                    mNoOfRatings = (TextView) rootView.findViewById(R.id.tv_no_of_rating);
                    mNoOfRatingsText = (TextView) rootView.findViewById(R.id.tv_No_of_rating_text);
                    mNoOfRatings.setOnClickListener(this);
                    mNoOfRatingsText.setOnClickListener(this);

                    mSchoolNameImageView = (ImageView) rootView.findViewById(R.id.iv_school_name);
                    mCompNameImageView = (ImageView) rootView.findViewById(R.id.iv_company);
                    // mUsername = (TextView) rootView.findViewById(R.id.text_view_user_name);
                    mUserSchool = (TextView) rootView.findViewById(R.id.text_view_user_school);
                    mUserCompany = (TextView) rootView.findViewById(R.id.text_view_user_company);
                    mNoFollowingUser = (TextView) rootView.findViewById(R.id.tv_following);
                    mNoFollowersUser = (TextView) rootView.findViewById(R.id.tv_followers);
                    mBioUser = (TextView) rootView.findViewById(R.id.text_view_bio);
                    mViewFullProfileUser = (TextView) rootView.findViewById(R.id.text_view_full_profile_user);
                    mViewFullProfileUser.setOnClickListener(this);

                    Glide.with(this).load(mLocationList.get(mPosition).getUserDTO().getProfileImageUrl()).
                            error(getActivity().getResources().getDrawable(R.drawable.profile_gray)).
                            into(mUserImage);
                    mNoOfRatings.setText(mLocationList.get(mPosition).getRatingCount());
                    //((SearchResultBaseActivity)getActivity()).setName(mLocationList.get(mPosition).getName());
                    // mUsername.setText(mLocationList.get(mPosition).getName());
                    if (mLocationList.get(mPosition).getUserDTO().getSchoolName() != null && !mLocationList.get(mPosition).getUserDTO().getSchoolName().equals("")) {
                        mUserSchool.setText(mLocationList.get(mPosition).getUserDTO().getSchoolName());
                        mUserSchool.setVisibility(View.VISIBLE);
                        mSchoolNameImageView.setVisibility(View.VISIBLE);
                    } else {
                        mUserSchool.setVisibility(View.GONE);
                        mSchoolNameImageView.setVisibility(View.GONE);
                    }
                    if (mLocationList.get(mPosition).getUserDTO().getCompanyName() != null && !mLocationList.get(mPosition).getUserDTO().getCompanyName().equals("")) {
                        mUserCompany.setVisibility(View.VISIBLE);
                        mUserCompany.setText(mLocationList.get(mPosition).getUserDTO().getCompanyName());
                        mCompNameImageView.setVisibility(View.VISIBLE);
                    } else {
                        mUserCompany.setVisibility(View.GONE);
                        mCompNameImageView.setVisibility(View.GONE);
                    }
                    mNoFollowingUser.setText(mLocationList.get(mPosition).getUserDTO().getShadowersVerified().getCount());
                    mNoFollowersUser.setText(mLocationList.get(mPosition).getUserDTO().getShadowersVerified().getCount());
                    if (mLocationList.get(mPosition).getUserDTO().getBio() != null && !mLocationList.get(mPosition).getUserDTO().getBio().equals("")) {
                        mBioUser.setText(mLocationList.get(mPosition).getUserDTO().getBio());
                        mBioUser.setVisibility(View.VISIBLE);
                    } else {
                        mBioUser.setVisibility(View.GONE);
                    }

                    // mBioUser.setText(mLocationList.get(mPosition).getUserDTO().getBio());
                    mUrl1ImageView = (ImageView) rootView.findViewById(R.id.iv_url1);
                    mUrl2ImageView = (ImageView) rootView.findViewById(R.id.iv_url2);
                    mUrl3ImageView = (ImageView) rootView.findViewById(R.id.iv_url3);
                    mUrl1TextView = (TextView) rootView.findViewById(R.id.tv_url1);
                    mUrl2TextView = (TextView) rootView.findViewById(R.id.tv_url2);
                    mUrl3TextView = (TextView) rootView.findViewById(R.id.tv_url3);
                    registerUrlListsner();
                    addSocialData();
                    String avgRating = mLocationList.get(mPosition).getAvgRating();
                    double rating = 0;
                    if (!TextUtils.isEmpty(avgRating)) {
                        rating = Double.parseDouble(avgRating);
                    }
                    mAverageRatingTextView.setText(rating + "");
                    // setRating((int) rating);
                }
            }

        } else if (mServiceType.equals("all_type")) {
            if (mAllTypeList != null) {
                mRoleType = mAllTypeList.get(mPosition).getUserDTO().getRole();
            }
            linkedinUrl = mAllTypeList.get(mPosition).getUserDTO().getLinkedInUrl();
            facebookUrl = mAllTypeList.get(mPosition).getUserDTO().getFacebookUrl();
            githubUrl = mAllTypeList.get(mPosition).getUserDTO().getGitHubUrl();
            twitterUrl = mAllTypeList.get(mPosition).getUserDTO().getTwitterUrl();
            instagramUrl = mAllTypeList.get(mPosition).getUserDTO().getInstagramUrl();
            googlePlusUrl = mAllTypeList.get(mPosition).getUserDTO().getGooglePlusUrl();
            videoUrl = mAllTypeList.get(mPosition).getUserDTO().getVideoUrl();


            if (mRoleType.equals("SCHOOL")) {
                rootView = (ViewGroup) inflater.inflate(
                        R.layout.fragment_screen_slide_school_page, container, false);
                if (mAllTypeList != null) {
                   /* mStar1ImgVw =(ImageView)rootView.findViewById(R.id.iv_star1);
                    mStar2ImgVw =(ImageView)rootView.findViewById(R.id.iv_star2);
                    mStar3ImgVw =(ImageView)rootView.findViewById(R.id.iv_star3);
                    mStar4ImgVw =(ImageView)rootView.findViewById(R.id.iv_star4);
                    mStar5ImgVw =(ImageView)rootView.findViewById(R.id.iv_star5);*/
                    rootView.findViewById(R.id.iv_video).setOnClickListener(this);
                    mSchoolImage = (CircleImageView) rootView.findViewById(R.id.iv_user_profile);
                    // mSchoolName = (TextView) rootView.findViewById(R.id.text_view_user_name);
                    mSchoolUrlImageView = (ImageView) rootView.findViewById(R.id.iv_school_url);
                    mSchoolLocation = (TextView) rootView.findViewById(R.id.text_view_school_location);
                    mSchoolUrl = (TextView) rootView.findViewById(R.id.text_view_school_url);
                    mSchoolUrl.setOnClickListener(this);
                    mNumberFollowingSchool = (TextView) rootView.findViewById(R.id.tv_following);
                    mNumberFollowersSchool = (TextView) rootView.findViewById(R.id.tv_followers);
                    mBioSchool = (TextView) rootView.findViewById(R.id.text_view_bio);
                    mNumberCompaniesWithOccuSchool = (TextView) rootView.findViewById(R.id.tv_no_companies_with_occupations);
                    mNumberUsersAttendedThisSchool = (TextView) rootView.findViewById(R.id.tv_users_this_school);
                    mViewFullProfileSchool = (TextView) rootView.findViewById(R.id.text_view_full_profile_school);
                    mViewFullProfileSchool.setOnClickListener(this);

                    mAverageRatingTextView = (TextView) rootView.findViewById(R.id.text_view_average_rating);
                    mNoOfRatings = (TextView) rootView.findViewById(R.id.tv_no_of_rating);
                    mNoOfRatingsText = (TextView) rootView.findViewById(R.id.tv_No_of_rating_text);
                    mNoOfRatings.setOnClickListener(this);
                    mNoOfRatingsText.setOnClickListener(this);


                    Glide.with(this).load(mAllTypeList.get(mPosition).getUserDTO().getProfileImageUrl()).
                            error(getActivity().getResources().getDrawable(R.drawable.profile_gray)).
                            into(mSchoolImage);
                    mNoOfRatings.setText(mAllTypeList.get(mPosition).getRatingCount());
                    //((SearchResultBaseActivity)getActivity()).setName(mAllTypeList.get(mPosition).getName());
                    // mSchoolName.setText(mAllTypeList.get(mPosition).getName());
                    mSchoolLocation.setText(mAllTypeList.get(mPosition).getAddress());

                    if (mAllTypeList.get(mPosition).getUserDTO().getSchoolUrl() != null && !mAllTypeList.get(mPosition).getUserDTO().getSchoolUrl().equals("")) {
                        mSchoolUrl.setText(mAllTypeList.get(mPosition).getUserDTO().getSchoolUrl());
                        mSchoolUrl.setVisibility(View.VISIBLE);
                        mSchoolUrlImageView.setVisibility(View.VISIBLE);
                    } else {
                        mSchoolUrl.setVisibility(View.GONE);
                        mSchoolUrlImageView.setVisibility(View.GONE);
                    }

                    //mSchoolUrl.setText(mAllTypeList.get(mPosition).getUserDTO().getSchoolUrl());

                    if (mAllTypeList.get(mPosition).getUserDTO().getBio() != null && mAllTypeList.get(mPosition).getUserDTO().getBio().equals("")) {
                        mBioSchool.setText(mAllTypeList.get(mPosition).getUserDTO().getBio());
                        mBioSchool.setVisibility(View.VISIBLE);
                    } else {
                        mBioSchool.setVisibility(View.GONE);
                    }
                    // mBioSchool.setText(mAllTypeList.get(mPosition).getUserDTO().getBio());
                    mNumberFollowingSchool.setText(mAllTypeList.get(mPosition).getUserDTO().getShadowedByShadowUser().getCount());
                    mNumberFollowersSchool.setText(mAllTypeList.get(mPosition).getUserDTO().getShadowersVerified().getCount());
                    mNumberCompaniesWithOccuSchool.setText(mAllTypeList.get(mPosition).getUserDTO().getSchoolOrCompanyWithTheseOccupations().getCount());
                    mNumberUsersAttendedThisSchool.setText(mAllTypeList.get(mPosition).getUserDTO().getSchoolOrCompanyWithTheseUsers().getCount());

                    mUrl1ImageView = (ImageView) rootView.findViewById(R.id.iv_url1);
                    mUrl2ImageView = (ImageView) rootView.findViewById(R.id.iv_url2);
                    mUrl3ImageView = (ImageView) rootView.findViewById(R.id.iv_url3);
                    mUrl1TextView = (TextView) rootView.findViewById(R.id.tv_url1);
                    mUrl2TextView = (TextView) rootView.findViewById(R.id.tv_url2);
                    mUrl3TextView = (TextView) rootView.findViewById(R.id.tv_url3);
                    registerUrlListsner();
                    addSocialData();
                    String avgRating = mAllTypeList.get(mPosition).getAvgRating();
                    double rating = 0;
                    if (!TextUtils.isEmpty(avgRating)) {
                        rating = Double.parseDouble(avgRating);
                    }
                    mAverageRatingTextView.setText(rating + "");
                    //setRating((int) rating);

                }
            } else if (mRoleType.equals("COMPANY")) {
                rootView = (ViewGroup) inflater.inflate(
                        R.layout.fragment_screen_slide_company_page, container, false);
                if (mAllTypeList != null) {
                    /*mStar1ImgVw =(ImageView)rootView.findViewById(R.id.iv_star1);
                    mStar2ImgVw =(ImageView)rootView.findViewById(R.id.iv_star2);
                    mStar3ImgVw =(ImageView)rootView.findViewById(R.id.iv_star3);
                    mStar4ImgVw =(ImageView)rootView.findViewById(R.id.iv_star4);
                    mStar5ImgVw =(ImageView)rootView.findViewById(R.id.iv_star5);*/
                    rootView.findViewById(R.id.iv_video).setOnClickListener(this);
                    mCompanyImage = (CircleImageView) rootView.findViewById(R.id.iv_user_profile);
                    // mCompanyName = (TextView) rootView.findViewById(R.id.text_view_user_name);
                    mAverageRatingTextView = (TextView) rootView.findViewById(R.id.text_view_average_rating);
                    mNoOfRatings = (TextView) rootView.findViewById(R.id.tv_no_of_rating);
                    mNoOfRatingsText = (TextView) rootView.findViewById(R.id.tv_No_of_rating_text);
                    mNoOfRatings.setOnClickListener(this);
                    mNoOfRatingsText.setOnClickListener(this);

                    mCompUrlImageView = (ImageView) rootView.findViewById(R.id.iv_company_url);
                    mCompanyLocation = (TextView) rootView.findViewById(R.id.text_view_location);
                    mCompanyUrl = (TextView) rootView.findViewById(R.id.text_view_comp_url);
                    mCompanyUrl.setOnClickListener(this);
                    mNoFollowingCompany = (TextView) rootView.findViewById(R.id.tv_following);
                    mNoFollowersCompany = (TextView) rootView.findViewById(R.id.tv_followers);
                    mSchoolsWithTheseOccu = (TextView) rootView.findViewById(R.id.tv_school_with_occupatons);
                    mNoUsersEmployed = (TextView) rootView.findViewById(R.id.tv_users_employed);
                    mBioCompany = (TextView) rootView.findViewById(R.id.text_view_bio);
                    mViewFullProfileCompany = (TextView) rootView.findViewById(R.id.text_view_full_profile_company);
                    mViewFullProfileCompany.setOnClickListener(this);

                    Glide.with(this).load(mAllTypeList.get(mPosition).getUserDTO().getProfileImageUrl()).
                            error(getActivity().getResources().getDrawable(R.drawable.profile_gray)).
                            into(mCompanyImage);
                    mNoOfRatings.setText(mAllTypeList.get(mPosition).getRatingCount());
                    if (mAllTypeList.get(mPosition).getUserDTO().getBio() != null && !mAllTypeList.get(mPosition).getUserDTO().getBio().equals("")) {
                        mBioCompany.setText(mAllTypeList.get(mPosition).getUserDTO().getBio());
                        mBioCompany.setVisibility(View.VISIBLE);
                    } else {
                        mBioCompany.setVisibility(View.GONE);
                    }

                    // mBioCompany.setText(mAllTypeList.get(mPosition).getUserDTO().getBio());
                    mNoFollowingCompany.setText(mAllTypeList.get(mPosition).getUserDTO().getShadowersVerified().getCount());
                    mNoFollowersCompany.setText(mAllTypeList.get(mPosition).getUserDTO().getShadowedByShadowUser().getCount());
                    mSchoolsWithTheseOccu.setText(mAllTypeList.get(mPosition).getUserDTO().getSchoolOrCompanyWithTheseOccupations().getCount());
                    mNoUsersEmployed.setText(mAllTypeList.get(mPosition).getUserDTO().getSchoolOrCompanyWithTheseUsers().getCount());

                    if (mAllTypeList.get(mPosition).getUserDTO().getCompanyUrl() != null && !mAllTypeList.get(mPosition).getUserDTO().getCompanyUrl().equals("")) {
                        mCompanyUrl.setText(mAllTypeList.get(mPosition).getUserDTO().getCompanyUrl());
                        mCompanyUrl.setVisibility(View.VISIBLE);
                        mCompUrlImageView.setVisibility(View.VISIBLE);
                    } else {
                        mCompanyUrl.setVisibility(View.GONE);
                        mCompUrlImageView.setVisibility(View.GONE);
                    }

                    //mCompanyUrl.setText(mAllTypeList.get(mPosition).getUserDTO().getCompanyUrl());
                    //((SearchResultBaseActivity)getActivity()).setName(mAllTypeList.get(mPosition).getName());
                    // mCompanyName.setText(mAllTypeList.get(mPosition).getName());
                    mCompanyLocation.setText(mAllTypeList.get(mPosition).getUserDTO().getLocation());

                    mUrl1ImageView = (ImageView) rootView.findViewById(R.id.iv_url1);
                    mUrl2ImageView = (ImageView) rootView.findViewById(R.id.iv_url2);
                    mUrl3ImageView = (ImageView) rootView.findViewById(R.id.iv_url3);
                    mUrl1TextView = (TextView) rootView.findViewById(R.id.tv_url1);
                    mUrl2TextView = (TextView) rootView.findViewById(R.id.tv_url2);
                    mUrl3TextView = (TextView) rootView.findViewById(R.id.tv_url3);
                    registerUrlListsner();
                    addSocialData();
                    String avgRating = mAllTypeList.get(mPosition).getAvgRating();
                    double rating = 0;
                    if (!TextUtils.isEmpty(avgRating)) {
                        rating = Double.parseDouble(avgRating);
                    }
                    mAverageRatingTextView.setText(rating + "");
                    // setRating((int) rating);
                }
            } else if (mRoleType.equals("USER")) {
                rootView = (ViewGroup) inflater.inflate(
                        R.layout.fragment_screen_slide_user_page, container, false);
                if (mAllTypeList != null) {
                    /*mStar1ImgVw =(ImageView)rootView.findViewById(R.id.iv_star1);
                    mStar2ImgVw =(ImageView)rootView.findViewById(R.id.iv_star2);
                    mStar3ImgVw =(ImageView)rootView.findViewById(R.id.iv_star3);
                    mStar4ImgVw =(ImageView)rootView.findViewById(R.id.iv_star4);
                    mStar5ImgVw =(ImageView)rootView.findViewById(R.id.iv_star5);*/
                    rootView.findViewById(R.id.iv_video).setOnClickListener(this);
                    mUserImage = (CircleImageView) rootView.findViewById(R.id.iv_user_profile);
                    // mUsername = (TextView) rootView.findViewById(R.id.text_view_user_name);
                    mAverageRatingTextView = (TextView) rootView.findViewById(R.id.text_view_average_rating);
                    mNoOfRatings = (TextView) rootView.findViewById(R.id.tv_no_of_rating);
                    mNoOfRatingsText = (TextView) rootView.findViewById(R.id.tv_No_of_rating_text);
                    mNoOfRatings.setOnClickListener(this);
                    mNoOfRatingsText.setOnClickListener(this);


                    mSchoolNameImageView = (ImageView) rootView.findViewById(R.id.iv_school_name);
                    mCompNameImageView = (ImageView) rootView.findViewById(R.id.iv_company);
                    mUserSchool = (TextView) rootView.findViewById(R.id.text_view_user_school);
                    mUserCompany = (TextView) rootView.findViewById(R.id.text_view_user_company);
                    mNoFollowingUser = (TextView) rootView.findViewById(R.id.tv_following);
                    mNoFollowersUser = (TextView) rootView.findViewById(R.id.tv_followers);
                    mBioUser = (TextView) rootView.findViewById(R.id.text_view_bio);
                    mViewFullProfileUser = (TextView) rootView.findViewById(R.id.text_view_full_profile_user);
                    mViewFullProfileUser.setOnClickListener(this);

                    Glide.with(this).load(mAllTypeList.get(mPosition).getUserDTO().getProfileImageUrl())
                            .error(getActivity().getResources().getDrawable(R.drawable.profile_gray))
                            .into(mUserImage);
                    mNoOfRatings.setText(mAllTypeList.get(mPosition).getRatingCount());
                    // mUsername.setText(mAllTypeList.get(mPosition).getName());
                    //((SearchResultBaseActivity)getActivity()).setName(mAllTypeList.get(mPosition).getName());

                    if (mAllTypeList.get(mPosition).getUserDTO().getSchoolName() != null && !mAllTypeList.get(mPosition).getUserDTO().getSchoolName().equals("")) {
                        mUserSchool.setText(mAllTypeList.get(mPosition).getUserDTO().getSchoolName());
                        mUserSchool.setVisibility(View.VISIBLE);
                        mSchoolNameImageView.setVisibility(View.VISIBLE);
                    } else {
                        mUserSchool.setVisibility(View.GONE);
                        mSchoolNameImageView.setVisibility(View.GONE);
                    }
                    if (mAllTypeList.get(mPosition).getUserDTO().getCompanyName() != null && !mAllTypeList.get(mPosition).getUserDTO().getCompanyName().equals("")) {
                        mUserCompany.setVisibility(View.VISIBLE);
                        mUserCompany.setText(mAllTypeList.get(mPosition).getUserDTO().getCompanyName());
                        mCompNameImageView.setVisibility(View.VISIBLE);
                    } else {
                        mUserCompany.setVisibility(View.GONE);
                        mCompNameImageView.setVisibility(View.GONE);
                    }

                    // mUserSchool.setText(mAllTypeList.get(mPosition).getUserDTO().getSchoolName());
                    // mUserCompany.setText(mAllTypeList.get(mPosition).getUserDTO().getCompanyName());
                    mNoFollowingUser.setText(mAllTypeList.get(mPosition).getUserDTO().getShadowersVerified().getCount());
                    mNoFollowersUser.setText(mAllTypeList.get(mPosition).getUserDTO().getShadowersVerified().getCount());
                    if (mAllTypeList.get(mPosition).getUserDTO().getBio() != null && !mAllTypeList.get(mPosition).getUserDTO().getBio().equals("")) {
                        mBioUser.setText(mAllTypeList.get(mPosition).getUserDTO().getBio());
                        mBioUser.setVisibility(View.VISIBLE);
                    } else {
                        mBioUser.setVisibility(View.GONE);
                    }

                    // mBioUser.setText(mAllTypeList.get(mPosition).getUserDTO().getBio());

                    mUrl1ImageView = (ImageView) rootView.findViewById(R.id.iv_url1);
                    mUrl2ImageView = (ImageView) rootView.findViewById(R.id.iv_url2);
                    mUrl3ImageView = (ImageView) rootView.findViewById(R.id.iv_url3);
                    mUrl1TextView = (TextView) rootView.findViewById(R.id.tv_url1);
                    mUrl2TextView = (TextView) rootView.findViewById(R.id.tv_url2);
                    mUrl3TextView = (TextView) rootView.findViewById(R.id.tv_url3);
                    registerUrlListsner();
                    addSocialData();
                    String avgRating = mAllTypeList.get(mPosition).getAvgRating();
                    double rating = 0;
                    if (!TextUtils.isEmpty(avgRating)) {
                        rating = Double.parseDouble(avgRating);
                    }
                    mAverageRatingTextView.setText(rating + "");
                    // setRating((int) rating);
                }
            }
        } else if (mServiceType.equals("simple")) {
            if (mSimpleList != null) {
                mRoleType = mSimpleList.get(mPosition).getUserDTO().getRole();
            }
            linkedinUrl = mSimpleList.get(mPosition).getUserDTO().getLinkedInUrl();
            facebookUrl = mSimpleList.get(mPosition).getUserDTO().getFacebookUrl();
            githubUrl = mSimpleList.get(mPosition).getUserDTO().getGitHubUrl();
            twitterUrl = mSimpleList.get(mPosition).getUserDTO().getTwitterUrl();
            instagramUrl = mSimpleList.get(mPosition).getUserDTO().getInstagramUrl();
            googlePlusUrl = mSimpleList.get(mPosition).getUserDTO().getGooglePlusUrl();
            videoUrl = mSimpleList.get(mPosition).getUserDTO().getVideoUrl();

            if (mRoleType.equals("SCHOOL")) {
                rootView = (ViewGroup) inflater.inflate(
                        R.layout.fragment_screen_slide_school_page, container, false);
                if (mSimpleList != null) {
                    /*mStar1ImgVw =(ImageView)rootView.findViewById(R.id.iv_star1);
                    mStar2ImgVw =(ImageView)rootView.findViewById(R.id.iv_star2);
                    mStar3ImgVw =(ImageView)rootView.findViewById(R.id.iv_star3);
                    mStar4ImgVw =(ImageView)rootView.findViewById(R.id.iv_star4);
                    mStar5ImgVw =(ImageView)rootView.findViewById(R.id.iv_star5);*/
                    rootView.findViewById(R.id.iv_video).setOnClickListener(this);
                    mSchoolImage = (CircleImageView) rootView.findViewById(R.id.iv_user_profile);
                    mSchoolUrlImageView = (ImageView) rootView.findViewById(R.id.iv_school_url);
                    //  mSchoolName = (TextView) rootView.findViewById(R.id.text_view_user_name);
                    mSchoolLocation = (TextView) rootView.findViewById(R.id.text_view_school_location);
                    mSchoolUrl = (TextView) rootView.findViewById(R.id.text_view_school_url);
                    mSchoolUrl.setOnClickListener(this);
                    mNumberFollowingSchool = (TextView) rootView.findViewById(R.id.tv_following);
                    mNumberFollowersSchool = (TextView) rootView.findViewById(R.id.tv_followers);
                    mBioSchool = (TextView) rootView.findViewById(R.id.text_view_bio);
                    mNumberCompaniesWithOccuSchool = (TextView) rootView.findViewById(R.id.tv_no_companies_with_occupations);
                    mNumberUsersAttendedThisSchool = (TextView) rootView.findViewById(R.id.tv_users_this_school);
                    mViewFullProfileSchool = (TextView) rootView.findViewById(R.id.text_view_full_profile_school);
                    mViewFullProfileSchool.setOnClickListener(this);

                    mAverageRatingTextView = (TextView) rootView.findViewById(R.id.text_view_average_rating);
                    mNoOfRatings = (TextView) rootView.findViewById(R.id.tv_no_of_rating);
                    mNoOfRatingsText = (TextView) rootView.findViewById(R.id.tv_No_of_rating_text);
                    mNoOfRatings.setOnClickListener(this);
                    mNoOfRatingsText.setOnClickListener(this);

                    Glide.with(this).load(mSimpleList.get(mPosition).getUserDTO().getProfileImageUrl())
                            .error(getActivity().getResources().getDrawable(R.drawable.profile_gray))
                            .into(mSchoolImage);
                    mNoOfRatings.setText(mSimpleList.get(mPosition).getRatingCount());
                    //((SearchResultBaseActivity)getActivity()).setName(mSimpleList.get(mPosition).getName());
                    // mSchoolName.setText(mSimpleList.get(mPosition).getName());
                    mSchoolLocation.setText(mSimpleList.get(mPosition).getAddress());

                    if (mSimpleList.get(mPosition).getUserDTO().getSchoolUrl() != null && !mSimpleList.get(mPosition).getUserDTO().getSchoolUrl().equals("")) {
                        mSchoolUrl.setText(mSimpleList.get(mPosition).getUserDTO().getSchoolUrl());
                        mSchoolUrl.setVisibility(View.VISIBLE);
                        mSchoolUrlImageView.setVisibility(View.VISIBLE);
                    } else {
                        mSchoolUrl.setVisibility(View.GONE);
                        mSchoolUrlImageView.setVisibility(View.GONE);
                    }

                    // mSchoolUrl.setText(mSimpleList.get(mPosition).getUserDTO().getSchoolUrl());
                    if (mSimpleList.get(mPosition).getUserDTO().getBio() != null && mSimpleList.get(mPosition).getUserDTO().getBio().equals("")) {
                        mBioSchool.setText(mSimpleList.get(mPosition).getUserDTO().getBio());
                        mBioSchool.setVisibility(View.VISIBLE);
                    } else {
                        mBioSchool.setVisibility(View.GONE);
                    }

                    // mBioSchool.setText(mSimpleList.get(mPosition).getUserDTO().getBio());
                    mNumberFollowingSchool.setText(mSimpleList.get(mPosition).getUserDTO().getShadowedByShadowUser().getCount());
                    mNumberFollowersSchool.setText(mSimpleList.get(mPosition).getUserDTO().getShadowersVerified().getCount());
                    mNumberCompaniesWithOccuSchool.setText(mSimpleList.get(mPosition).getUserDTO().getSchoolOrCompanyWithTheseOccupations().getCount());
                    mNumberUsersAttendedThisSchool.setText(mSimpleList.get(mPosition).getUserDTO().getSchoolOrCompanyWithTheseUsers().getCount());

                    mUrl1ImageView = (ImageView) rootView.findViewById(R.id.iv_url1);
                    mUrl2ImageView = (ImageView) rootView.findViewById(R.id.iv_url2);
                    mUrl3ImageView = (ImageView) rootView.findViewById(R.id.iv_url3);
                    mUrl1TextView = (TextView) rootView.findViewById(R.id.tv_url1);
                    mUrl2TextView = (TextView) rootView.findViewById(R.id.tv_url2);
                    mUrl3TextView = (TextView) rootView.findViewById(R.id.tv_url3);
                    registerUrlListsner();
                    addSocialData();
                    String avgRating = mSimpleList.get(mPosition).getAvgRating();
                    double rating = 0;
                    if (!TextUtils.isEmpty(avgRating)) {
                        rating = Double.parseDouble(avgRating);
                    }
                    mAverageRatingTextView.setText(rating + "");
                    //setRating((int) rating);
                }
            } else if (mRoleType.equals("COMPANY")) {
                rootView = (ViewGroup) inflater.inflate(
                        R.layout.fragment_screen_slide_company_page, container, false);
                if (mSimpleList != null) {
                   /* mStar1ImgVw =(ImageView)rootView.findViewById(R.id.iv_star1);
                    mStar2ImgVw =(ImageView)rootView.findViewById(R.id.iv_star2);
                    mStar3ImgVw =(ImageView)rootView.findViewById(R.id.iv_star3);
                    mStar4ImgVw =(ImageView)rootView.findViewById(R.id.iv_star4);
                    mStar5ImgVw =(ImageView)rootView.findViewById(R.id.iv_star5);*/
                    rootView.findViewById(R.id.iv_video).setOnClickListener(this);
                    mCompanyImage = (CircleImageView) rootView.findViewById(R.id.iv_user_profile);
                    // mCompanyName = (TextView) rootView.findViewById(R.id.text_view_user_name);
                    mAverageRatingTextView = (TextView) rootView.findViewById(R.id.text_view_average_rating);
                    mNoOfRatings = (TextView) rootView.findViewById(R.id.tv_no_of_rating);
                    mNoOfRatingsText = (TextView) rootView.findViewById(R.id.tv_No_of_rating_text);
                    mNoOfRatings.setOnClickListener(this);
                    mNoOfRatingsText.setOnClickListener(this);

                    mCompanyLocation = (TextView) rootView.findViewById(R.id.text_view_location);
                    mCompUrlImageView = (ImageView) rootView.findViewById(R.id.iv_company_url);
                    mCompanyUrl = (TextView) rootView.findViewById(R.id.text_view_comp_url);
                    mCompanyUrl.setOnClickListener(this);
                    mNoFollowingCompany = (TextView) rootView.findViewById(R.id.tv_following);
                    mNoFollowersCompany = (TextView) rootView.findViewById(R.id.tv_followers);
                    mSchoolsWithTheseOccu = (TextView) rootView.findViewById(R.id.tv_school_with_occupatons);
                    mNoUsersEmployed = (TextView) rootView.findViewById(R.id.tv_users_employed);
                    mBioCompany = (TextView) rootView.findViewById(R.id.text_view_bio);
                    mViewFullProfileCompany = (TextView) rootView.findViewById(R.id.text_view_full_profile_company);
                    mViewFullProfileCompany.setOnClickListener(this);

                    Glide.with(this).
                            load(mSimpleList.get(mPosition).getUserDTO().getProfileImageUrl()).
                            error(getActivity().getResources().getDrawable(R.drawable.profile_gray)).
                            into(mCompanyImage);
                    mNoOfRatings.setText(mSimpleList.get(mPosition).getRatingCount());
                    if (mSimpleList.get(mPosition).getUserDTO().getBio() != null && !mSimpleList.get(mPosition).getUserDTO().getBio().equals("")) {
                        mBioCompany.setText(mSimpleList.get(mPosition).getUserDTO().getBio());
                        mBioCompany.setVisibility(View.VISIBLE);
                    } else {
                        mBioCompany.setVisibility(View.GONE);
                    }

                    //((SearchResultBaseActivity)getActivity()).setName(mSimpleList.get(mPosition).getName());
                    // mBioCompany.setText(mSimpleList.get(mPosition).getUserDTO().getBio());
                    mNoFollowingCompany.setText(mSimpleList.get(mPosition).getUserDTO().getShadowersVerified().getCount());
                    mNoFollowersCompany.setText(mSimpleList.get(mPosition).getUserDTO().getShadowedByShadowUser().getCount());
                    mSchoolsWithTheseOccu.setText(mSimpleList.get(mPosition).getUserDTO().getSchoolOrCompanyWithTheseOccupations().getCount());
                    mNoUsersEmployed.setText(mSimpleList.get(mPosition).getUserDTO().getSchoolOrCompanyWithTheseUsers().getCount());

                    if (mSimpleList.get(mPosition).getUserDTO().getCompanyUrl() != null && !mSimpleList.get(mPosition).getUserDTO().getCompanyUrl().equals("")) {
                        mCompanyUrl.setText(mSimpleList.get(mPosition).getUserDTO().getCompanyUrl());
                        mCompanyUrl.setVisibility(View.VISIBLE);
                        mCompUrlImageView.setVisibility(View.VISIBLE);
                    } else {
                        mCompanyUrl.setVisibility(View.GONE);
                        mCompUrlImageView.setVisibility(View.GONE);
                    }

                    //mCompanyUrl.setText(mSimpleList.get(mPosition).getUserDTO().getCompanyUrl());
                    // mCompanyName.setText(mSimpleList.get(mPosition).getName());
                    mCompanyLocation.setText(mSimpleList.get(mPosition).getUserDTO().getLocation());
                    mUrl1ImageView = (ImageView) rootView.findViewById(R.id.iv_url1);
                    mUrl2ImageView = (ImageView) rootView.findViewById(R.id.iv_url2);
                    mUrl3ImageView = (ImageView) rootView.findViewById(R.id.iv_url3);
                    mUrl1TextView = (TextView) rootView.findViewById(R.id.tv_url1);
                    mUrl2TextView = (TextView) rootView.findViewById(R.id.tv_url2);
                    mUrl3TextView = (TextView) rootView.findViewById(R.id.tv_url3);
                    registerUrlListsner();
                    addSocialData();
                    String avgRating = mSimpleList.get(mPosition).getAvgRating();
                    double rating = 0;
                    if (!TextUtils.isEmpty(avgRating)) {
                        rating = Double.parseDouble(avgRating);
                    }
                    mAverageRatingTextView.setText(rating + "");
                    //setRating((int) rating);
                }
            } else if (mRoleType.equals("USER")) {
                rootView = (ViewGroup) inflater.inflate(
                        R.layout.fragment_screen_slide_user_page, container, false);
                if (mSimpleList != null) {
                    /*mStar1ImgVw =(ImageView)rootView.findViewById(R.id.iv_star1);
                    mStar2ImgVw =(ImageView)rootView.findViewById(R.id.iv_star2);
                    mStar3ImgVw =(ImageView)rootView.findViewById(R.id.iv_star3);
                    mStar4ImgVw =(ImageView)rootView.findViewById(R.id.iv_star4);
                    mStar5ImgVw =(ImageView)rootView.findViewById(R.id.iv_star5);*/
                    rootView.findViewById(R.id.iv_video).setOnClickListener(this);
                    mUserImage = (CircleImageView) rootView.findViewById(R.id.iv_user_profile);
                    mAverageRatingTextView = (TextView) rootView.findViewById(R.id.text_view_average_rating);
                    mNoOfRatings = (TextView) rootView.findViewById(R.id.tv_no_of_rating);
                    mNoOfRatingsText = (TextView) rootView.findViewById(R.id.tv_No_of_rating_text);
                    mNoOfRatings.setOnClickListener(this);
                    mNoOfRatingsText.setOnClickListener(this);

                    mSchoolNameImageView = (ImageView) rootView.findViewById(R.id.iv_school_name);
                    mCompNameImageView = (ImageView) rootView.findViewById(R.id.iv_company);
                    // mUsername = (TextView) rootView.findViewById(R.id.text_view_user_name);
                    mUserSchool = (TextView) rootView.findViewById(R.id.text_view_user_school);
                    mUserCompany = (TextView) rootView.findViewById(R.id.text_view_user_company);
                    mNoFollowingUser = (TextView) rootView.findViewById(R.id.tv_following);
                    mNoFollowersUser = (TextView) rootView.findViewById(R.id.tv_followers);
                    mBioUser = (TextView) rootView.findViewById(R.id.text_view_bio);
                    mViewFullProfileUser = (TextView) rootView.findViewById(R.id.text_view_full_profile_user);
                    mViewFullProfileUser.setOnClickListener(this);

                    Glide.with(this).load(mSimpleList.get(mPosition).getUserDTO().getProfileImageUrl()).
                            error(getActivity().getResources().getDrawable(R.drawable.profile_gray)).
                            into(mUserImage);
                    mNoOfRatings.setText(mSimpleList.get(mPosition).getRatingCount());
                    //((SearchResultBaseActivity)getActivity()).setName(mSimpleList.get(mPosition).getName());
                    //mUsername.setText(mSimpleList.get(mPosition).getName());

                    if (mSimpleList.get(mPosition).getUserDTO().getSchoolName() != null && !mSimpleList.get(mPosition).getUserDTO().getSchoolName().equals("")) {
                        mUserSchool.setText(mSimpleList.get(mPosition).getUserDTO().getSchoolName());
                        mUserSchool.setVisibility(View.VISIBLE);
                        mSchoolNameImageView.setVisibility(View.VISIBLE);
                    } else {
                        mUserSchool.setVisibility(View.GONE);
                        mSchoolNameImageView.setVisibility(View.GONE);
                    }
                    if (mSimpleList.get(mPosition).getUserDTO().getCompanyName() != null && !mSimpleList.get(mPosition).getUserDTO().getCompanyName().equals("")) {
                        mUserCompany.setVisibility(View.VISIBLE);
                        mUserCompany.setText(mSimpleList.get(mPosition).getUserDTO().getCompanyName());
                        mCompNameImageView.setVisibility(View.VISIBLE);
                    } else {
                        mUserCompany.setVisibility(View.GONE);
                        mCompNameImageView.setVisibility(View.GONE);
                    }

                    //mUserSchool.setText(mSimpleList.get(mPosition).getUserDTO().getSchoolName());
                    //mUserCompany.setText(mSimpleList.get(mPosition).getUserDTO().getCompanyName());
                    mNoFollowingUser.setText(mSimpleList.get(mPosition).getUserDTO().getShadowersVerified().getCount());
                    mNoFollowersUser.setText(mSimpleList.get(mPosition).getUserDTO().getShadowersVerified().getCount());
                    if (mSimpleList.get(mPosition).getUserDTO().getBio() != null && !mSimpleList.get(mPosition).getUserDTO().getBio().equals("")) {
                        mBioUser.setText(mSimpleList.get(mPosition).getUserDTO().getBio());
                        mBioUser.setVisibility(View.VISIBLE);
                    } else {
                        mBioUser.setVisibility(View.GONE);
                    }


                    mUrl1ImageView = (ImageView) rootView.findViewById(R.id.iv_url1);
                    mUrl2ImageView = (ImageView) rootView.findViewById(R.id.iv_url2);
                    mUrl3ImageView = (ImageView) rootView.findViewById(R.id.iv_url3);
                    mUrl1TextView = (TextView) rootView.findViewById(R.id.tv_url1);
                    mUrl2TextView = (TextView) rootView.findViewById(R.id.tv_url2);
                    mUrl3TextView = (TextView) rootView.findViewById(R.id.tv_url3);
                    registerUrlListsner();
                    addSocialData();
                    String avgRating = mSimpleList.get(mPosition).getAvgRating();
                    double rating = 0;
                    if (!TextUtils.isEmpty(avgRating)) {
                        rating = Double.parseDouble(avgRating);
                    }
                    mAverageRatingTextView.setText(rating + "");
                    //setRating((int) rating);
                }
            }
        }
        return rootView;
    }

    private void registerUrlListsner() {
        mUrl1ImageView.setOnClickListener(this);
        mUrl2ImageView.setOnClickListener(this);
        mUrl3ImageView.setOnClickListener(this);
        mUrl1TextView.setOnClickListener(this);
        mUrl2TextView.setOnClickListener(this);
        mUrl3TextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent1;
        switch (view.getId()) {
            case R.id.text_view_school_url:
                String schoolUrl = mSchoolUrl.getText().toString();
                if (!TextUtils.isEmpty(schoolUrl)) {
                    callWebIntent(schoolUrl);
                }

                break;

            case R.id.text_view_comp_url:
                String companyUrl = mCompanyUrl.getText().toString();
                if (!TextUtils.isEmpty(companyUrl)) {
                    callWebIntent(companyUrl);
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

            case R.id.iv_video:
                if (!TextUtils.isEmpty(videoUrl)) {
                    intent1 = new Intent(getActivity(), VideoPlayActivity.class);
                    intent1.putExtra("video_url", videoUrl);
                    startActivity(intent1);
                } else {
                    Toast.makeText(getActivity(), "No video recorded", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.text_view_full_profile_company:
                if (mServiceType.equals("location")) {
                    Intent intent = new Intent(getActivity(), AnotherUserProfileActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user_id", mLocationList.get(mPosition).getUserId());
                    bundle.putString("user_role", mLocationList.get(mPosition).getUserDTO().getRole());
                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                } else if (mServiceType.equals("all_type")) {
                    Intent intent = new Intent(getActivity(), AnotherUserProfileActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user_id", mAllTypeList.get(mPosition).getUserId());
                    bundle.putString("user_role", mAllTypeList.get(mPosition).getUserDTO().getRole());
                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                } else if (mServiceType.equals("simple")) {
                    Intent intent = new Intent(getActivity(), AnotherUserProfileActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user_id", mSimpleList.get(mPosition).getUserId());
                    bundle.putString("user_role", mSimpleList.get(mPosition).getUserDTO().getRole());
                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                }
                break;
            case R.id.text_view_full_profile_school:
                if (mServiceType.equals("location")) {
                    Intent intent = new Intent(getActivity(), AnotherUserProfileActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user_id", mLocationList.get(mPosition).getUserId());
                    bundle.putString("user_role", mLocationList.get(mPosition).getUserDTO().getRole());
                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                } else if (mServiceType.equals("all_type")) {
                    Intent intent = new Intent(getActivity(), AnotherUserProfileActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user_id", mAllTypeList.get(mPosition).getUserId());
                    bundle.putString("user_role", mAllTypeList.get(mPosition).getUserDTO().getRole());
                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                } else if (mServiceType.equals("simple")) {
                    Intent intent = new Intent(getActivity(), AnotherUserProfileActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user_id", mSimpleList.get(mPosition).getUserId());
                    bundle.putString("user_role", mSimpleList.get(mPosition).getUserDTO().getRole());
                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                }
                break;

            case R.id.text_view_full_profile_user:
                if (mServiceType.equals("location")) {
                    Intent intent = new Intent(getActivity(), AnotherUserProfileActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user_id", mLocationList.get(mPosition).getUserId());
                    bundle.putString("user_role", mLocationList.get(mPosition).getUserDTO().getRole());
                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                } else if (mServiceType.equals("all_type")) {
                    Intent intent = new Intent(getActivity(), AnotherUserProfileActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user_id", mAllTypeList.get(mPosition).getUserId());
                    bundle.putString("user_role", mAllTypeList.get(mPosition).getUserDTO().getRole());
                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                } else if (mServiceType.equals("simple")) {
                    Intent intent = new Intent(getActivity(), AnotherUserProfileActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user_id", mSimpleList.get(mPosition).getUserId());
                    bundle.putString("user_role", mSimpleList.get(mPosition).getUserDTO().getRole());
                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                }
                break;
        }
    }

    private void callWebIntent(String url) {
        try {
            Intent myIntent = new Intent(Intent.ACTION_VIEW);
            myIntent.setData(Uri.parse(url));
            startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getActivity(), "No application can handle this request.Please install a webbrowser", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

    protected void addSocialData() {
        mSelectedMediaList = new ArrayList<SocialMedia.Media>();
//                SearchLocationListResponse.UserDTO profileData = response;
//                String linkedinUrl = profileData.getLinkedInUrl();
//                String facebookUrl = profileData.getFacebookUrl();
//                String githubUrl = profileData.getGitHubUrl();
//                String twitterUrl = profileData.getTwitterUrl();
//                String instagramUrl = profileData.getInstagramUrl();
//                String googlePlusUrl = profileData.getGooglePlusUrl();

        if (!TextUtils.isEmpty(linkedinUrl)) {
            SocialMedia.Media media = new SocialMedia().new Media();
            media.setId(LINKEDIN_KEY);
            media.setName("Linkedin");
            media.setUrl(linkedinUrl);
            mSelectedMediaList.add(media);
        }
        if (!TextUtils.isEmpty(facebookUrl)) {
            SocialMedia.Media media = new SocialMedia().new Media();
            media.setId(FACEBOOK_KEY);
            media.setName("Facebook");
            media.setUrl(facebookUrl);
            mSelectedMediaList.add(media);
        }
        if (!TextUtils.isEmpty(githubUrl)) {
            SocialMedia.Media media = new SocialMedia().new Media();
            media.setId(GITHUB_KEY);
            media.setName("Github");
            media.setUrl(githubUrl);
            mSelectedMediaList.add(media);
        }
        if (!TextUtils.isEmpty(twitterUrl)) {
            SocialMedia.Media media = new SocialMedia().new Media();
            media.setId(TWITTER_KEY);
            media.setName("Twitter");
            media.setUrl(twitterUrl);
            mSelectedMediaList.add(media);
        }
        if (!TextUtils.isEmpty(instagramUrl)) {
            SocialMedia.Media media = new SocialMedia().new Media();
            media.setId(INSTAGRAM_KEY);
            media.setName("Instagram");
            media.setUrl(instagramUrl);
            mSelectedMediaList.add(media);

        }
        if (!TextUtils.isEmpty(googlePlusUrl)) {
            SocialMedia.Media media = new SocialMedia().new Media();
            media.setId(GOOGLE_PLUS_KEY);
            media.setName("Google+");
            media.setUrl(googlePlusUrl);
            mSelectedMediaList.add(media);
        }
        if (mSelectedMediaList != null && mSelectedMediaList.size() > 0) {
            setMediaListOnUi(mSelectedMediaList);
        } else {
            mUrl1ImageView.setVisibility(View.GONE);
            mUrl2ImageView.setVisibility(View.GONE);
            mUrl3ImageView.setVisibility(View.GONE);
            mUrl1TextView.setVisibility(View.GONE);
            mUrl2TextView.setVisibility(View.GONE);
            mUrl3TextView.setVisibility(View.GONE);
        }
    }


    protected void setMediaListOnUi(ArrayList<SocialMedia.Media> socialList) {
        int count = socialList.size();
        if (count == 1) {
            String urlId = socialList.get(0).getId();
            String url = socialList.get(0).getUrl();
            setProfileUrlData(mUrl1ImageView, urlId, url, mUrl1TextView);
            mUrl1ImageView.setVisibility(View.VISIBLE);
            mUrl2ImageView.setVisibility(View.GONE);
            mUrl3ImageView.setVisibility(View.GONE);
            mUrl1TextView.setVisibility(View.VISIBLE);
            mUrl2TextView.setVisibility(View.GONE);
            mUrl3TextView.setVisibility(View.GONE);

        } else if (count == 2) {
            String urlId = socialList.get(0).getId();
            String urlId1 = socialList.get(1).getId();
            String url = socialList.get(0).getUrl();
            String url1 = socialList.get(1).getUrl();
            setProfileUrlData(mUrl1ImageView, urlId, url, mUrl1TextView);
            setProfileUrlData(mUrl2ImageView, urlId1, url1, mUrl2TextView);
            mUrl1ImageView.setVisibility(View.VISIBLE);
            mUrl2ImageView.setVisibility(View.VISIBLE);
            mUrl3ImageView.setVisibility(View.GONE);
            mUrl1TextView.setVisibility(View.VISIBLE);
            mUrl2TextView.setVisibility(View.VISIBLE);
            mUrl3TextView.setVisibility(View.GONE);

        } else if (count == 3) {
            String urlId = socialList.get(0).getId();
            String urlId1 = socialList.get(1).getId();
            String urlId2 = socialList.get(2).getId();
            String url = socialList.get(0).getUrl();
            String url1 = socialList.get(1).getUrl();
            String url2 = socialList.get(2).getUrl();
            mUrl1ImageView.setVisibility(View.VISIBLE);
            mUrl2ImageView.setVisibility(View.VISIBLE);
            mUrl3ImageView.setVisibility(View.VISIBLE);
            mUrl1TextView.setVisibility(View.VISIBLE);
            mUrl2TextView.setVisibility(View.VISIBLE);
            mUrl3TextView.setVisibility(View.VISIBLE);

            setProfileUrlData(mUrl1ImageView, urlId, url, mUrl1TextView);
            setProfileUrlData(mUrl2ImageView, urlId1, url1, mUrl2TextView);
            setProfileUrlData(mUrl3ImageView, urlId2, url2, mUrl3TextView);
        }
    }


    /**
     * This method is used to set Profile Url icons on UI
     *
     * @param urlImagView:icon imageview
     * @param id
     */
    protected void setProfileUrlData(ImageView urlImagView, String id, String url, TextView urlTextView) {
        switch (id) {
            case TWITTER_KEY:
                urlImagView.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.twitter));
                if (url.length() >= 24) {
                    String urlt = url.substring(24, url.length());
                    urlTextView.setText(urlt);
                } else {
                    urlTextView.setText("");
                }
                break;
            case FACEBOOK_KEY:
                urlImagView.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.fb));
                if (url.length() >= 25) {
                    String urlt = url.substring(25, url.length());
                    urlTextView.setText(urlt);
                } else {
                    urlTextView.setText("");
                }
                break;
            case LINKEDIN_KEY:
                urlImagView.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.linkdin));
                if (url.length() >= 25) {
                    String urlt = url.substring(25, url.length());
                    urlTextView.setText(urlt);
                } else {
                    urlTextView.setText("");
                }
                break;
            case GOOGLE_PLUS_KEY:
                urlImagView.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_google_plus));
                if (url.length() >= 27) {
                    String urlt = url.substring(27, url.length());
                    urlTextView.setText(urlt);
                } else {
                    urlTextView.setText("");
                }
                break;
            case INSTAGRAM_KEY:
                urlImagView.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.instagram));
                if (url.length() >= 26) {
                    String urlt = url.substring(26, url.length());
                    urlTextView.setText(urlt);
                } else {
                    urlTextView.setText("");
                }
                break;
            case GITHUB_KEY:
                urlImagView.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_github));
                if (url.length() >= 23) {
                    String urlt = url.substring(23, url.length());
                    urlTextView.setText(urlt);
                } else {
                    urlTextView.setText("");
                }
                break;
        }
    }

    /*protected void setRating(int rating) {
        switch (rating) {
            case 1:
                mStar1ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_grey));
                mStar3ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_grey));
                mStar4ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_grey));
                mStar5ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_grey));
                break;
            case 2:
                mStar1ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar3ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_grey));
                mStar4ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_grey));
                mStar5ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_grey));
                break;
            case 3:
                mStar1ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar3ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar4ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_grey));
                mStar5ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_grey));
                break;
            case 4:
                mStar1ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar3ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar4ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar5ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_grey));
                break;
            case 5:
                mStar1ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar3ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar4ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar5ImgVw.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.ic_star_yellow));
                break;
        }
    }*/
}

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
 * Created by singhgharjyot on 7/25/2017.
 */

public class OccupationsScreenSlideFragment extends Fragment implements View.OnClickListener {

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
    private TextView mNumberCompaniesWithOccuSchool,mNumberUsersAttendedThisSchool,mViewFullProfileSchool,mViewFullProfileCompany,mViewFullProfileUser;
    private ImageView mVideoImagView;
    private ArrayList<SocialMedia.Media> mSelectedMediaList;
    private ImageView mUrl1ImageView, mUrl2ImageView, mUrl3ImageView,mStar2ImgVw,mStar3ImgVw,mStar4ImgVw,mStar5ImgVw,mStar1ImgVw;
    private String linkedinUrl, facebookUrl, googlePlusUrl, githubUrl, instagramUrl, twitterUrl, videoUrl;


    @Override
    public void onClick(View view) {

    }
}

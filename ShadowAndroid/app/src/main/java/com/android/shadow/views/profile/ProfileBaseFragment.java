package com.android.shadow.views.profile;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.shadow.R;
import com.android.shadow.model.SocialMedia;
import com.android.shadow.model.output.GetProfileResponse;
import com.android.shadow.presenter.ProfilePresenter;
import com.android.shadow.utils.PreferenceKeys;
import com.android.shadow.utils.SharedPrefsHelper;
import com.android.shadow.views.ExpandableHeightGridView;
import com.android.shadow.views.core.BaseFragment;

import java.text.BreakIterator;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.FACEBOOK_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GITHUB_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GOOGLE_PLUS_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.INSTAGRAM_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.LINKEDIN_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.TWITTER_KEY;

/**
 * Created by jindaldipanshu on 7/4/2017.
 */

public class ProfileBaseFragment extends BaseFragment {
    protected ExpandableHeightGridView mOccupationsGridView;
    protected ImageView mNotificationImageView, mMessageImageView, mRequestImageView, mVideoImageView, mSettingsImageView, mEditImageView;
    protected ImageView mStar1ImgVw, mStar2ImgVw, mStar3ImgVw, mStar4ImgVw, mStar5ImgVw, mUrl1ImageView, mUrl2ImageView, mUrl3ImageView;
    protected TextView mUrl1TextView, mUrl2TextView, mUrl3TextView;
    protected CircleImageView mUserImagView;
    protected TextView mFollowing, mFollowers, mBioTextView, mUserNameTextView, mSchoolNmTextView, mCompNmTextView;

    protected ProfilePresenter mProfilePresenter;
    protected SharedPrefsHelper sharedPrefsHelper;
    protected String mUserid;

    public GetProfileResponse profileResponse;
    protected ArrayList<SocialMedia.Media> mSelectedMediaList;

    protected ArrayList<GetProfileResponse.Occupations> mOccupationsList;
    private AlertDialog logoutDialog;
    private TextView mNameHeadorTextView;

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initViews(View view) {

        getBaseActivity().setCurrentFragment(this);

        mNameHeadorTextView = (TextView) view.findViewById(R.id.text_view_header_title) ;

        sharedPrefsHelper = new SharedPrefsHelper(getActivity());
        mUserid = sharedPrefsHelper.get(PreferenceKeys.PREF_USER_ID);

        mSettingsImageView = (ImageView) view.findViewById(R.id.iv_settings);
        mEditImageView = (ImageView) view.findViewById(R.id.iv_edit);

        mNotificationImageView = (ImageView) view.findViewById(R.id.iv_notification);
        mMessageImageView = (ImageView) view.findViewById(R.id.iv_message);
        mRequestImageView = (ImageView) view.findViewById(R.id.iv_request);
        mUserImagView = (CircleImageView) view.findViewById(R.id.iv_user_profile);
        mVideoImageView = (ImageView) view.findViewById(R.id.iv_video);

        mStar1ImgVw = (ImageView) view.findViewById(R.id.iv_star1);
        mStar2ImgVw = (ImageView) view.findViewById(R.id.iv_star2);
        mStar3ImgVw = (ImageView) view.findViewById(R.id.iv_star3);
        mStar4ImgVw = (ImageView) view.findViewById(R.id.iv_star4);
        mStar5ImgVw = (ImageView) findViewById(R.id.iv_star5);

        mFollowing = (TextView) view.findViewById(R.id.tv_following);
        mFollowers = (TextView) view.findViewById(R.id.tv_followers);
        mBioTextView = (TextView) view.findViewById(R.id.text_view_bio);
        mUrl1ImageView = (ImageView) view.findViewById(R.id.iv_url1);
        mUrl2ImageView = (ImageView) view.findViewById(R.id.iv_url2);
        mUrl3ImageView = (ImageView) view.findViewById(R.id.iv_url3);
        mUrl1TextView = (TextView) view.findViewById(R.id.tv_url1);
        mUrl2TextView = (TextView) view.findViewById(R.id.tv_url2);
        mUrl3TextView = (TextView) view.findViewById(R.id.tv_url3);

        mUrl1ImageView.setVisibility(View.GONE);
        mUrl2ImageView.setVisibility(View.GONE);
        mUrl3ImageView.setVisibility(View.GONE);
        mUrl1TextView.setVisibility(View.GONE);
        mUrl2TextView.setVisibility(View.GONE);
        mUrl3TextView.setVisibility(View.GONE);
        mOccupationsGridView = (ExpandableHeightGridView) view.findViewById(R.id.grid_view_occupations);
        mOccupationsGridView.setExpanded(true);

    }

    @Override
    public void dispose() {
    }


/*
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void setRating(int rating) {
        switch (rating) {
            case 1:
                mStar1ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_grey));
                mStar3ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_grey));
                mStar4ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_grey));
                mStar5ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_grey));
                break;

            case 2:
                mStar1ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar3ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_grey));
                mStar4ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_grey));
                mStar5ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_grey));
                break;

            case 3:
                mStar1ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar3ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar4ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_grey));
                mStar5ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_grey));
                break;

            case 4:
                mStar1ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar3ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar4ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar5ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_grey));
                break;

            case 5:
                mStar1ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar3ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar4ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar5ImgVw.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.ic_star_yellow));
                break;
        }
    }*/

    protected void addSocialData(GetProfileResponse response) {
        if (response != null) {
            mSelectedMediaList = new ArrayList<>();
            if (profileResponse != null && profileResponse.getData() != null) {
                GetProfileResponse.Data profileData = profileResponse.getData();
                String linkedinUrl = profileData.getLinkedInUrl();
                String facebookUrl = profileData.getFacebookUrl();
                String githubUrl = profileData.getGitHubUrl();
                String twitterUrl = profileData.getTwitterUrl();
                String instagramUrl = profileData.getInstagramUrl();
                String googlePlusUrl = profileData.getGooglePlusUrl();
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
                }
            }
        }
    }


    public void setName(String name){
        mNameHeadorTextView.setText(name);
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
                urlImagView.setBackgroundDrawable(getBaseActivity().getResources().getDrawable(R.drawable.twitter));
                if (url.length() >= 24) {
                    String urlt = url.substring(24, url.length());
                    urlTextView.setText(urlt);
                } else {
                    urlTextView.setText("");
                }
               // urlTextView.setText(url);
                break;
            case FACEBOOK_KEY:
                urlImagView.setBackgroundDrawable(getBaseActivity().getResources().getDrawable(R.drawable.fb));
                if (url.length() >= 25) {
                    String urlt = url.substring(25, url.length());
                    urlTextView.setText(urlt);
                } else {
                    urlTextView.setText("");
                }
                break;
            case LINKEDIN_KEY:
                urlImagView.setBackgroundDrawable(getBaseActivity().getResources().getDrawable(R.drawable.linkdin));
                if (url.length() >= 25) {
                    String urlt = url.substring(25, url.length());
                    urlTextView.setText(urlt);
                } else {
                    urlTextView.setText("");
                }
                break;
            case GOOGLE_PLUS_KEY:
                urlImagView.setBackgroundDrawable(getBaseActivity().getResources().getDrawable(R.drawable.ic_google_plus));
                if (url.length() >= 27) {
                    String urlt = url.substring(27, url.length());
                    urlTextView.setText(urlt);
                } else {
                    urlTextView.setText("");
                }
                break;
            case INSTAGRAM_KEY:
                urlImagView.setBackgroundDrawable(getBaseActivity().getResources().getDrawable(R.drawable.instagram));
                if (url.length() >= 26) {
                    String urlt = url.substring(26, url.length());
                    urlTextView.setText(urlt);
                } else {
                    urlTextView.setText("");
                }
                break;
            case GITHUB_KEY:
                urlImagView.setBackgroundDrawable(getBaseActivity().getResources().getDrawable(R.drawable.ic_github));
                if (url.length() >= 23) {
                    String urlt = url.substring(23, url.length());
                    urlTextView.setText(urlt);
                } else {
                    urlTextView.setText("");
                }
                break;
        }
    }

    protected void callWebIntent(String url) {
        try {
            Intent myIntent = new Intent(Intent.ACTION_VIEW);
            myIntent.setData(Uri.parse(url));
            startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getBaseActivity(), "No application can handle this request.Please install a webbrowser", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}

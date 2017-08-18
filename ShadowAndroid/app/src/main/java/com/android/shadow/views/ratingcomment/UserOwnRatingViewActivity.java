package com.android.shadow.views.ratingcomment;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.adapter.ratingcomment.CompanyRatingAndCommentAdapter;
import com.android.shadow.adapter.ratingcomment.SchoolRatingAndCommentAdapter;
import com.android.shadow.adapter.ratingcomment.UserRatingAndCommentAdapter;
import com.android.shadow.model.output.GetAllRatingResponse;
import com.android.shadow.model.output.GetProfileResponse;
import com.android.shadow.presenter.GetAllRatingPresenter;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.core.BaseActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Response;

public class UserOwnRatingViewActivity extends BaseActivity implements View.OnClickListener, GetAllRatingPresenter.RatingCallback {

    protected ImageView mBackBtn, mAddCommentBtn;
    protected ImageView mStar1ImgVw, mStar2ImgVw, mStar3ImgVw, mStar4ImgVw, mStar5ImgVw;
    protected CircleImageView mCircularProfile;
    protected TextView mNameTextView,mAverageRatingTextView, mSchoolTextView, mCompanyTextView, mOccupationTextView, mFollowingTextView, mFollowersTextView,
            mNoOfRatingTextView;
    protected RecyclerView mRatingCommentRecyclerView;
    protected ArrayList<String> mRatingCommentList;
    private GetProfileResponse mProfileResponse;
    private GetAllRatingPresenter mGetAllRatingPresenter;
    private String mOtherUserId, mUserId, mUserRole, mImageUrl, mName,mAvgRating,mMessage;
    private Bundle bundle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rating_view;
    }

    protected void getDataFromBundle() {
        bundle = getIntent().getExtras();
        if (bundle != null) {
            mUserRole = bundle.getString("role");
            mUserId = bundle.getString("user_id");
            mOtherUserId = bundle.getString("other_user_id");
            mImageUrl = bundle.getString("profile_image");
            mName = bundle.getString("name");
            mAvgRating=bundle.getString("avg_rating");
        }
    }

    @Override
    protected void initViews() {
        getDataFromBundle();
        mBackBtn = (ImageView) findViewById(R.id.image_view_back);
        mAddCommentBtn = (ImageView) findViewById(R.id.image_view_add);
        mCircularProfile = (CircleImageView) findViewById(R.id.iv_user_profile);
        mNameTextView = (TextView) findViewById(R.id.text_view_name);
        mRatingCommentRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_rating_comment);
        mAverageRatingTextView = (TextView) findViewById(R.id.text_view_average_rating);
        mNoOfRatingTextView = (TextView) findViewById(R.id.tv_no_of_rating);
        //mStar1ImgVw = (ImageView) findViewById(R.id.iv_star1);
       // mStar2ImgVw = (ImageView) findViewById(R.id.iv_star2);
       // mStar3ImgVw = (ImageView) findViewById(R.id.iv_star3);
       // mStar4ImgVw = (ImageView) findViewById(R.id.iv_star4);
       // mStar5ImgVw = (ImageView) findViewById(R.id.iv_star5);

        mBackBtn.setOnClickListener(this);
        mAddCommentBtn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!Utilities.checkInternet(this)) {
            showToast(R.string.no_internet_msg);
        } else {
            if (mGetAllRatingPresenter == null)
                mGetAllRatingPresenter = new GetAllRatingPresenter(this, this);
            if (!TextUtils.isEmpty(mOtherUserId)) {
                mAddCommentBtn.setVisibility(View.VISIBLE);
                mGetAllRatingPresenter.getAnotherUserRating(mUserId, mOtherUserId);
            } else {
                mAddCommentBtn.setVisibility(View.GONE);
                mGetAllRatingPresenter.getUserOwnRating(mUserId);
            }
        }
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_view_add:
                Intent intent = new Intent(this, AddRatingCommentActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.image_view_back:
                finish();
                break;
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onRatingSuccess(Response<GetAllRatingResponse> response) {
        if (response != null && response.body() != null) {
            if (response.body().getStatus().equals("200")) {
                setDataOnUi(response.body());
            }else {
                if (!TextUtils.isEmpty(mName)) {
                    mNameTextView.setText(mName);
                } else {
                    mNameTextView.setText("N/A");
                }
                Glide.with(this).load(mImageUrl).error(getDrawableRes(R.drawable.profile_gray)).into(mCircularProfile);

                //showToast(response.body().getMessage());
            }
        } else {
            showToast(R.string.no_data_found_msg);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void setDataOnUi(GetAllRatingResponse body) {
        if (body.getData() != null) {
            GetAllRatingResponse.Data ratingData = body.getData();
            String name = ratingData.getName();
            //String rating=ratingData.get
            if (!TextUtils.isEmpty(mName)) {
                mNameTextView.setText(mName);
            } else {
                mNameTextView.setText("N/A");
            }

            mAvgRating=ratingData.getAvgRating();
            mNoOfRatingTextView.setText(ratingData.getRatingCount());
            double rating=0;
            if (!TextUtils.isEmpty(ratingData.getAvgRating())) {
                rating = Double.parseDouble(mAvgRating);
            }
            mAverageRatingTextView.setText(rating+"");
            //setRating((int)rating);
            Glide.with(this).load(mImageUrl).error(getDrawableRes(R.drawable.profile_gray)).into(mCircularProfile);
            setAdapter(ratingData);
        }
    }

    private void setAdapter(GetAllRatingResponse.Data ratingData) {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRatingCommentRecyclerView.setLayoutManager(linearLayoutManager);

        if (mUserRole.contains("user") || mUserRole.contains("USER")) {
            UserRatingAndCommentAdapter userRatingAndCommentAdapter = new UserRatingAndCommentAdapter(this, ratingData.getUserRatings());
            mRatingCommentRecyclerView.setAdapter(userRatingAndCommentAdapter);
        } else if (mUserRole.contains("school") || mUserRole.contains("SCHOOL")) {
            SchoolRatingAndCommentAdapter schoolRatingAndCommentAdapter = new SchoolRatingAndCommentAdapter(this, ratingData.getSchoolRatings());
            mRatingCommentRecyclerView.setAdapter(schoolRatingAndCommentAdapter);
        } else if (mUserRole.contains("company") || mUserRole.contains("COMPANY")) {
            CompanyRatingAndCommentAdapter commentAdapter = new CompanyRatingAndCommentAdapter(this, ratingData.getCompanyRatings());
            mRatingCommentRecyclerView.setAdapter(commentAdapter);
        }
    }
/*
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void setRating(int rating) {
        switch (rating) {
            case 1:
                mStar1ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_grey));
                mStar3ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_grey));
                mStar4ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_grey));
                mStar5ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_grey));

                mStar1ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));


                break;
            case 2:
                mStar1ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar3ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_grey));
                mStar4ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_grey));
                mStar5ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_grey));

                mStar1ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));
                mStar2ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));



                break;
            case 3:
                mStar1ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar3ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar4ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_grey));
                mStar5ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_grey));

                mStar1ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));
                mStar2ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));
                mStar3ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));



                break;
            case 4:
                mStar1ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar3ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar4ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar5ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_grey));

                mStar1ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));
                mStar2ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));
                mStar3ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));
                mStar4ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));


                break;
            case 5:
                mStar1ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar2ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar3ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar4ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));
                mStar5ImgVw.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_star_yellow));

                mStar1ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));
                mStar2ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));
                mStar3ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));
                mStar4ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));
                mStar5ImgVw.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow_star)));


                break;
        }*/
    //}

}

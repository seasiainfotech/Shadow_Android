package com.android.shadow.views.ratingcomment;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.shadow.R;
import com.android.shadow.model.output.AddRatingCommentResponse;
import com.android.shadow.presenter.AddRatingCommentPresenter;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.core.BaseActivity;

import retrofit2.Response;

public class AddRatingCommentActivity extends BaseActivity implements View.OnClickListener, AddRatingCommentPresenter.AddRatingCommentCallback {

    private ImageView mBackImageView, mSendImageView, mStar1, mStar2, mStar3, mStar4, mStar5;
    private EditText mMessageEditText;
    private String mRating = "0";
    private Bundle bundle;
    private String mUserRole,mUserId,mOtherUserId;

    protected void getDataFromBundle() {
        bundle = getIntent().getExtras();
        if (bundle != null) {
            mUserRole = bundle.getString("role");
            mUserId = bundle.getString("user_id");
            mOtherUserId = bundle.getString("other_user_id");
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_rating_comment;
    }

    @Override
    protected void initViews() {
        getDataFromBundle();
        mBackImageView = (ImageView) findViewById(R.id.image_view_back);
        mSendImageView = (ImageView) findViewById(R.id.image_view_send);
        mMessageEditText = (EditText) findViewById(R.id.edit_text_message);
        mStar1 = (ImageView) findViewById(R.id.iv_star1);
        mStar2 = (ImageView) findViewById(R.id.iv_star2);
        mStar3 = (ImageView) findViewById(R.id.iv_star3);
        mStar4 = (ImageView) findViewById(R.id.iv_star4);
        mStar5 = (ImageView) findViewById(R.id.iv_star5);

        mBackImageView.setOnClickListener(this);
        mSendImageView.setOnClickListener(this);
        mStar1.setOnClickListener(this);
        mStar2.setOnClickListener(this);
        mStar3.setOnClickListener(this);
        mStar4.setOnClickListener(this);
        mStar5.setOnClickListener(this);

    }

    @Override
    public void dispose() {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        Utilities.hideKeypad(view);
        switch (view.getId()) {
            case R.id.image_view_back:
                finish();
                break;
            case R.id.image_view_send:
                AddRatingCommentPresenter addRatingCommentPresenter = new AddRatingCommentPresenter(this, this);
                addRatingCommentPresenter.checkValidations(mMessageEditText.getText().toString().trim(), mRating,
                        mUserRole,mUserId,mOtherUserId);
                break;
            case R.id.iv_star1:
                mStar1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ic_star_whte));
                mStar3.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ic_star_whte));
                mStar4.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ic_star_whte));
                mStar5.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ic_star_whte));
                mRating = "1";
                break;

            case R.id.iv_star2:
                mStar1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar3.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ic_star_whte));
                mStar4.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ic_star_whte));
                mStar5.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ic_star_whte));
                mRating = "2";
                break;

            case R.id.iv_star3:
                mStar1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar3.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar4.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ic_star_whte));
                mStar5.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ic_star_whte));
                mRating = "3";
                break;
            case R.id.iv_star4:
                mStar1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar3.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar4.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar5.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.ic_star_whte));
                mRating = "4";
                break;

            case R.id.iv_star5:
                mStar1.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar2.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar3.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar4.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mStar5.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.star_selected));
                mRating = "5";
                break;
        }


    }

    @Override
    public void onAddRatingCommentSuccess(Response<AddRatingCommentResponse> addRatingCommentResponse) {

    }
}
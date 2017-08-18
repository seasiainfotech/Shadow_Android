package com.android.shadow.adapter.ratingcomment;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.model.output.GetAllRatingResponse;
import com.android.shadow.views.core.BaseActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by singhgharjyot on 6/16/2017.
 */

public class UserRatingAndCommentAdapter extends RecyclerView.Adapter<UserRatingAndCommentAdapter.ViewHolder> {
    private ArrayList<GetAllRatingResponse.Data.UserRatings> mList;
    private BaseActivity mActivity;

    public UserRatingAndCommentAdapter(BaseActivity context, ArrayList<?> mList) {
        this.mList = (ArrayList<GetAllRatingResponse.Data.UserRatings>)mList;
        this.mActivity = context;
    }

    @Override
    public UserRatingAndCommentAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_rating_comment, null);
        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mNameTextView.setText(mList.get(position).getUserDTO().getUserName());
        String imageUrl = mList.get(position).getUserDTO().getProfileImageUrl();
        Glide.with(mActivity).load(imageUrl).
                error(mActivity.getResources().getDrawable(R.drawable.profile_gray)).
                into(viewHolder.mProfileImage);
        viewHolder.mCommentTextView.setText(mList.get(position).getComment());
        double rate = 0;
        String rating = mList.get(position).getRating();
        if (!TextUtils.isEmpty(rating)) {
            rate = Double.parseDouble(rating);
        }
        String days=mList.get(position).getTimeAgo();
        if (TextUtils.isEmpty(days)){
            viewHolder.mPostTimeTextView.setText("");
        }else {
            viewHolder.mPostTimeTextView.setText(days);
        }

        setRating(viewHolder, (int) rate);

    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final CircleImageView mProfileImage;
        private RelativeLayout mRatingCommentRl;
        private ImageView mRatingStar1, mRatingStar2, mRatingStar3, mRatingStar4, mRatingStar5;
        private TextView mNameTextView, mCommentTextView, mPostTimeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mProfileImage = (CircleImageView) itemView.findViewById(R.id.image_view_profile_row);
            mNameTextView = (TextView) itemView.findViewById(R.id.text_view_name_row);
            mCommentTextView = (TextView) itemView.findViewById(R.id.text_view_comment);
            mPostTimeTextView = (TextView) itemView.findViewById(R.id.text_view_days);
            mRatingStar1 = (ImageView) itemView.findViewById(R.id.iv_star1);
            mRatingStar2 = (ImageView) itemView.findViewById(R.id.iv_star2);
            mRatingStar3 = (ImageView) itemView.findViewById(R.id.iv_star3);
            mRatingStar4 = (ImageView) itemView.findViewById(R.id.iv_star4);
            mRatingStar5 = (ImageView) itemView.findViewById(R.id.iv_star5);
            mRatingCommentRl = (RelativeLayout) itemView.findViewById(R.id.rl_rating_comment);

            mRatingCommentRl.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            switch (view.getId()) {
                case R.id.rl_rating_comment:

                    break;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void setRating(ViewHolder viewHolder, int rating) {
        switch (rating) {
            case 1:
                viewHolder.mRatingStar1.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar2.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_unselected));
                viewHolder.mRatingStar3.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_unselected));
                viewHolder.mRatingStar4.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_unselected));
                viewHolder.mRatingStar5.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_unselected));
                break;
            case 2:
                viewHolder.mRatingStar1.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar2.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar3.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_unselected));
                viewHolder.mRatingStar4.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_unselected));
                viewHolder.mRatingStar5.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_unselected));
                break;
            case 3:
                viewHolder.mRatingStar1.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar2.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar3.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar4.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_unselected));
                viewHolder.mRatingStar5.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_unselected));
                break;
            case 4:
                viewHolder.mRatingStar1.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar2.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar3.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar4.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar5.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_unselected));
                break;
            case 5:
                viewHolder.mRatingStar1.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar2.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar3.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar4.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                viewHolder.mRatingStar5.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.star_selected));
                break;
        }
    }

}

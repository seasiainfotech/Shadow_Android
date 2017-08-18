package com.android.shadow.adapter.search;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.shadow.R;
import com.android.shadow.model.output.SearchAllTypeListResponse;
import com.android.shadow.views.core.BaseActivity;
import com.android.shadow.views.core.BaseFragment;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by singhgharjyot on 6/29/2017.
 */

public class SearchOccupationAdapter extends RecyclerView.Adapter<SearchOccupationAdapter.ViewHolder> {

    private ArrayList<SearchAllTypeListResponse.Data> mList;
    private BaseActivity mActivity;
    private BaseFragment mBaseFragment;

    public SearchOccupationAdapter(BaseActivity context, ArrayList<?> mList) {
        this.mList = (ArrayList<SearchAllTypeListResponse.Data>) mList;
        this.mActivity = context;
    }

    public SearchOccupationAdapter(BaseFragment context, ArrayList<?> mList) {
        this.mList = (ArrayList<SearchAllTypeListResponse.Data>) mList;
        this.mBaseFragment = context;
        this.mActivity = context.getBaseActivity();
    }


    @Override
    public SearchOccupationAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_search, null);
        // create ViewHolder
        SearchOccupationAdapter.ViewHolder viewHolder = new SearchOccupationAdapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SearchOccupationAdapter.ViewHolder viewHolder, int position) {
        viewHolder.mDistanceTextView.setVisibility(View.GONE);
        viewHolder.mNameTextView.setText(mList.get(position).getName());
        Glide.with(mActivity).
                load(R.drawable.occupation_filter).
               //error(mActivity.getResources().getDrawable(R.drawable.profile_gray)).
               into(viewHolder.mProfileImageView);
        String rating = mList.get(position).getAvgRating();
        double rate = 0;
        if (!TextUtils.isEmpty(rating)) {
            rate = Double.parseDouble(rating);
        }
        viewHolder.mAverageRatingTextView.setText(rate+"");
        //setRating(viewHolder, (int) rate);
             viewHolder.mTypeNameTextView.setVisibility(View.GONE);
           viewHolder.mTypeImageView.setVisibility(View.GONE);
    }


/*    private void setRating(SearchOccupationAdapter.ViewHolder viewHolder, int rate) {

        switch (rate) {
            case 0:
                viewHolder.mStar1.setImageResource(R.drawable.ic_star_grey);
                viewHolder.mStar2.setImageResource(R.drawable.ic_star_grey);
                viewHolder.mStar3.setImageResource(R.drawable.ic_star_grey);
                viewHolder.mStar4.setImageResource(R.drawable.ic_star_grey);
                viewHolder.mStar5.setImageResource(R.drawable.ic_star_grey);
                break;
            case 1:
                viewHolder.mStar1.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar2.setImageResource(R.drawable.ic_star_grey);
                viewHolder.mStar3.setImageResource(R.drawable.ic_star_grey);
                viewHolder.mStar4.setImageResource(R.drawable.ic_star_grey);
                viewHolder.mStar5.setImageResource(R.drawable.ic_star_grey);
                break;
            case 2:
                viewHolder.mStar1.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar2.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar3.setImageResource(R.drawable.ic_star_grey);
                viewHolder.mStar4.setImageResource(R.drawable.ic_star_grey);
                viewHolder.mStar5.setImageResource(R.drawable.ic_star_grey);
                break;
            case 3:
                viewHolder.mStar1.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar2.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar3.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar4.setImageResource(R.drawable.ic_star_grey);
                viewHolder.mStar5.setImageResource(R.drawable.ic_star_grey);
                break;
            case 4:
                viewHolder.mStar1.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar2.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar3.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar4.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar5.setImageResource(R.drawable.ic_star_grey);
                break;
            case 5:
                viewHolder.mStar1.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar2.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar3.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar4.setImageResource(R.drawable.ic_star_yellow);
                viewHolder.mStar5.setImageResource(R.drawable.ic_star_yellow);
                break;


        }

    }*/

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView mAverageRatingTextView;
        private final TextView mTypeNameTextView;
        private final ImageView mTypeImageView;
        // private final LinearLayout mRatingLl;
       // private final ImageView mStar1, mStar2, mStar3, mStar4, mStar5;
        private TextView mNameTextView, mDistanceTextView;
        private CircleImageView mProfileImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mNameTextView = (TextView) itemView.findViewById(R.id.text_view_name);
            mProfileImageView = (CircleImageView) itemView.findViewById(R.id.Circular_image_view_Profile_pic);
           // mRatingLl = (LinearLayout) itemView.findViewById(R.id.ll_rating);
            mTypeNameTextView = (TextView) itemView.findViewById(R.id.text_view_type_name);
            mTypeImageView = (ImageView) itemView.findViewById(R.id.iv_icon_type);
            mDistanceTextView = (TextView) itemView.findViewById(R.id.text_view_distance);
            mAverageRatingTextView = (TextView) itemView.findViewById(R.id.text_view_average_rating);
           /* mStar1 = (ImageView) itemView.findViewById(R.id.iv_star1);
            mStar2 = (ImageView) itemView.findViewById(R.id.iv_star2);
            mStar3 = (ImageView) itemView.findViewById(R.id.iv_star3);
            mStar4 = (ImageView) itemView.findViewById(R.id.iv_star4);
            mStar5 = (ImageView) itemView.findViewById(R.id.iv_star5);*/
            itemView.findViewById(R.id.rl_search).setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            switch (view.getId()) {
                case R.id.rl_search:

                    Toast.makeText(mActivity, "coming soon", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(mActivity, AnotherUserProfileActivity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("user_id", mList.get(position).getUserId());
//                    bundle.putString("user_role", mList.get(position).getUserDTO().getRole());
//                    intent.putExtras(bundle);
//                    mActivity.startActivity(intent);
                    break;
            }
        }
    }
}

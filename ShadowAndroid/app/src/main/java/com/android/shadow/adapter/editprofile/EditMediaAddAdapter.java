package com.android.shadow.adapter.editprofile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.interfaces.SocialListCallback;
import com.android.shadow.model.SocialMedia;
import com.android.shadow.views.core.BaseActivity;
import com.android.shadow.views.core.BaseFragment;

import java.util.ArrayList;

import static android.content.Context.POWER_SERVICE;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.FACEBOOK_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.FACEBOOK_URL;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GITHUB_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GITHUB_URL;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GOOGLE_PLUS_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GOOGLE_PLUS_URL;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.INSTAGRAM_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.INSTAGRAM_URL;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.LINKEDIN_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.LINKEDIN_URL;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.TWITTER_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.TWITTER_URL;

/**
 * Created by singhgharjyot on 6/8/2017.
 */

public class EditMediaAddAdapter extends RecyclerView.Adapter<EditMediaAddAdapter.ViewHolder> {

    private static final String TAG = "EditSkillsAddAdapter";
    public ArrayList<SocialMedia.Media> mList;
    private BaseActivity mActivity;
    private BaseFragment mBaseFragment;
    private SocialListCallback interestListCallback;

    public EditMediaAddAdapter(BaseActivity context, ArrayList<SocialMedia.Media> mList,
                               SocialListCallback interestListCallback) {
        this.mList = mList;
        this.mActivity = context;
        this.interestListCallback = interestListCallback;

    }


    @Override
    public EditMediaAddAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_social_media_add, null);
        // create ViewHolder
        EditMediaAddAdapter.ViewHolder viewHolder = new EditMediaAddAdapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EditMediaAddAdapter.ViewHolder viewHolder, int position) {
        viewHolder.mSkillsTextView.setText(mList.get(position).getName());
        String id=mList.get(position).getId();
        setIcon(viewHolder,id);

    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public void notifyAdapter(ArrayList<SocialMedia.Media> mServerList) {
        mList = mServerList;
        notifyDataSetChanged();
    }

    protected void setIcon(EditMediaAddAdapter.ViewHolder viewHolder, String id, int position) {
        switch (id) {
            case TWITTER_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.twitter));
                mList.get(position).setUrl(TWITTER_URL);
                break;
            case FACEBOOK_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.fb));
                mList.get(position).setUrl(FACEBOOK_URL);
                break;
            case LINKEDIN_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.linkedin_icon));
                mList.get(position).setUrl(LINKEDIN_URL);
                break;
            case GOOGLE_PLUS_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.ic_google_plus));
                mList.get(position).setUrl(GOOGLE_PLUS_URL);
                break;
            case INSTAGRAM_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.instagram));
                mList.get(position).setUrl(INSTAGRAM_URL);
                break;
            case GITHUB_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.ic_github));
                mList.get(position).setUrl(GITHUB_URL);
                break;
        }
    }


    protected void setIcon(EditMediaAddAdapter.ViewHolder viewHolder, String id) {
        switch (id) {
            case TWITTER_KEY:
               viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.twitter));
                break;
            case FACEBOOK_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.fb));
                break;
            case LINKEDIN_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.linkedin_icon));
                break;
            case GOOGLE_PLUS_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.ic_google_plus));
                break;
            case INSTAGRAM_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.instagram));
                break;
            case GITHUB_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.ic_github));
                break;
        }
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final RelativeLayout mRowId;
        private final ImageView mSocialImageView;
        private TextView mSkillsTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mSocialImageView=(ImageView)itemView.findViewById(R.id.image_view_social_icon) ;
            mSkillsTextView = (TextView) itemView.findViewById(R.id.text_view_skill_add);
            mRowId = (RelativeLayout) itemView.findViewById(R.id.rl_skills_subtract);
            mRowId.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            switch (view.getId()) {
                case R.id.rl_skills_subtract:
                    if (mList.size()>3){
                        String skills = mList.get(position).getName();
                        SocialMedia.Media editSkillsList = new SocialMedia().new Media();
                        editSkillsList.setName(skills);
                        editSkillsList.setUrl("");
                        editSkillsList.setId(mList.get(position).getId());
                        interestListCallback.onUpdate(editSkillsList, position);
                    }
                    break;
            }
        }
    }
}

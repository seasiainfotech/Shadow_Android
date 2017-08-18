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
 * This class is used to show ten users  adapter
 *
 * @author jindaldipanshu
 * @version 1.0
 */

public class EditMediaSubtractAdapter extends RecyclerView.Adapter<EditMediaSubtractAdapter.ViewHolder> {

    public ArrayList<SocialMedia.Media> mSkillsList;
    private SocialListCallback skillsListCallback;
    private BaseActivity mActivity;
    private BaseFragment mBaseFragment;

    public EditMediaSubtractAdapter(BaseActivity context, ArrayList<SocialMedia.Media> mSkillsList,
                                    SocialListCallback skillsListCallback) {
        this.mSkillsList = mSkillsList;
        this.mActivity = context;
        this.skillsListCallback = skillsListCallback;
    }

    public EditMediaSubtractAdapter(BaseFragment context, ArrayList<SocialMedia.Media> mSkillsList) {
        this.mSkillsList = mSkillsList;
        this.mBaseFragment = context;
        this.mActivity = context.getBaseActivity();
    }

    @Override
    public EditMediaSubtractAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_social_media_subtract, null);
        // create ViewHolder
        EditMediaSubtractAdapter.ViewHolder viewHolder = new EditMediaSubtractAdapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EditMediaSubtractAdapter.ViewHolder viewHolder, int position) {
         viewHolder.mSkillsTextView.setText(mSkillsList.get(position).getName());
        String id=mSkillsList.get(position).getId();
        setIcon(viewHolder,id);

//        if (mSkillsList.get(position).getStatus().equals("N")) {
//
//        } else {
//            viewHolder.mSkillRl.setVisibility(View.GONE);
//        }
    }


    protected void setIcon(EditMediaSubtractAdapter.ViewHolder viewHolder, String id) {
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



    protected void setIcon(ViewHolder viewHolder, String id, int position) {
        switch (id) {
            case TWITTER_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.twitter));
                mSkillsList.get(position).setUrl(TWITTER_URL);
                break;
            case FACEBOOK_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.fb));
                mSkillsList.get(position).setUrl(FACEBOOK_URL);
                break;
            case LINKEDIN_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.linkedin_icon));
                mSkillsList.get(position).setUrl(LINKEDIN_URL);
                break;
            case GOOGLE_PLUS_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.ic_google_plus));
                mSkillsList.get(position).setUrl(GOOGLE_PLUS_URL);
                break;
            case INSTAGRAM_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.instagram));
                mSkillsList.get(position).setUrl(INSTAGRAM_URL);
                break;
            case GITHUB_KEY:
                viewHolder.mSocialImageView.setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.ic_github));
                mSkillsList.get(position).setUrl(GITHUB_URL);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mSkillsList == null ? 0 : mSkillsList.size();
    }

    public void notifyAdapter(ArrayList<SocialMedia.Media> skillList) {
        mSkillsList = skillList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final RelativeLayout mSkillRl;
        private TextView mSkillsTextView;
        private ImageView mSocialImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            mSocialImageView=(ImageView)itemView.findViewById(R.id.image_view_social_icon) ;
            mSkillsTextView = (TextView) itemView.findViewById(R.id.text_view_skill_add);
            mSkillRl = (RelativeLayout) itemView.findViewById(R.id.rl_skills_subtract);
            mSkillRl.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            switch (view.getId()) {
                case R.id.rl_skills_subtract:
                    String skills = mSkillsList.get(position).getName();

                    SocialMedia.Media editSkillsList = new SocialMedia().new Media();
                   // editSkillsList.setSelected(false); // N for skill which is added and Y for skill which is not added
                    editSkillsList.setName(skills);
                    editSkillsList.setId(mSkillsList.get(position).getId());
                    editSkillsList.setUrl("");
                    editSkillsList.setMediaSelected(false);
                    mSkillsList.set(position, editSkillsList);
                    skillsListCallback.onUpdateSocial(editSkillsList, position);
                    break;
            }
        }
    }
}

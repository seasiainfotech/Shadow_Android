package com.android.shadow.adapter.editprofile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.interfaces.InterestListCallback;
import com.android.shadow.model.input.EditProfileInput;
import com.android.shadow.views.core.BaseActivity;
import com.android.shadow.views.core.BaseFragment;

import java.util.ArrayList;

/**
 * This class is used to show ten users  adapter
 *
 * @author jindaldipanshu
 * @version 1.0
 */

public class EditInterestsSubtractAdapter extends RecyclerView.Adapter<EditInterestsSubtractAdapter.ViewHolder> {

    public ArrayList<EditProfileInput.Interest> mSkillsList;
    private InterestListCallback skillsListCallback;
    private BaseActivity mActivity;
    private BaseFragment mBaseFragment;

    public EditInterestsSubtractAdapter(BaseActivity context, ArrayList<EditProfileInput.Interest> mSkillsList, InterestListCallback skillsListCallback) {
        this.mSkillsList = mSkillsList;
        this.mActivity = context;
        this.skillsListCallback = skillsListCallback;
    }

    public EditInterestsSubtractAdapter(BaseFragment context, ArrayList<EditProfileInput.Interest> mSkillsList) {
        this.mSkillsList = mSkillsList;
        this.mBaseFragment = context;
        this.mActivity = context.getBaseActivity();
    }

    @Override
    public EditInterestsSubtractAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_skill_subtract, null);
        // create ViewHolder
        EditInterestsSubtractAdapter.ViewHolder viewHolder = new EditInterestsSubtractAdapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EditInterestsSubtractAdapter.ViewHolder viewHolder, int position) {
        viewHolder.mSkillsTextView.setText(mSkillsList.get(position).getName());
//        if (mSkillsList.get(position).getStatus().equals("N")) {
//
//        } else {
//            viewHolder.mSkillRl.setVisibility(View.GONE);
//        }
    }

    @Override
    public int getItemCount() {
        return mSkillsList == null ? 0 : mSkillsList.size();
    }

    public void notifyAdapter(ArrayList<EditProfileInput.Interest> skillList) {
        mSkillsList = skillList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final RelativeLayout mSkillRl;
        private TextView mSkillsTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mSkillsTextView = (TextView) itemView.findViewById(R.id.text_view_skill_subtract);
            mSkillRl = (RelativeLayout) itemView.findViewById(R.id.rl_skills_subtract);
            mSkillRl.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            switch (view.getId()) {
                case R.id.rl_skills_subtract:
                    String skills = mSkillsList.get(position).getName();

                    EditProfileInput.Interest editSkillsList = new EditProfileInput.Interest();
                   // editSkillsList.setSelected(false); // N for skill which is added and Y for skill which is not added
                    editSkillsList.setName(skills);
                    mSkillsList.set(position, editSkillsList);
                    skillsListCallback.onUpdateInterest2(editSkillsList, position);
                    break;
            }
        }
    }
}

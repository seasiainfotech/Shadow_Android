package com.android.shadow.adapter.editprofile;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
 * Created by singhgharjyot on 6/8/2017.
 */

public class EditInterestsAddAdapter extends RecyclerView.Adapter<EditInterestsAddAdapter.ViewHolder> {

    private static final String TAG = "EditSkillsAddAdapter";
    public ArrayList<EditProfileInput.Interest> mSkillsList;
    private BaseActivity mActivity;
    private BaseFragment mBaseFragment;
    private InterestListCallback interestListCallback;

    public EditInterestsAddAdapter(BaseActivity context, ArrayList<EditProfileInput.Interest> mSkillsList,
                                   InterestListCallback interestListCallback) {
        this.mSkillsList = mSkillsList;
        this.mActivity = context;
        this.interestListCallback = interestListCallback;

    }


    @Override
    public EditInterestsAddAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_skill_add, null);
        // create ViewHolder
        EditInterestsAddAdapter.ViewHolder viewHolder = new EditInterestsAddAdapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EditInterestsAddAdapter.ViewHolder viewHolder, int position) {

        viewHolder.mSkillsTextView.setText(mSkillsList.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return mSkillsList == null ? 0 : mSkillsList.size();
    }

    public void notifyAdapter(ArrayList<EditProfileInput.Interest> mServerList) {
        mSkillsList=mServerList;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final RelativeLayout mRowId;
        private TextView mSkillsTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mSkillsTextView = (TextView) itemView.findViewById(R.id.text_view_skill_add);
            mRowId = (RelativeLayout) itemView.findViewById(R.id.rl_skills_add);
            mRowId.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            switch (view.getId()) {
                case R.id.rl_skills_add:
                    Log.i(TAG, "inside onclick ");
                    String skills = mSkillsList.get(position).getName();
                    EditProfileInput.Interest editSkillsList = new EditProfileInput . Interest();
                    editSkillsList.setName(skills);
                    interestListCallback.onUpdate(editSkillsList,position,mSkillsList);
                    break;
            }
        }
    }
}

package com.android.shadow.adapter.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.model.input.EditProfileInput;
import com.android.shadow.model.output.GetProfileResponse;
import com.android.shadow.views.core.BaseActivity;
import com.android.shadow.views.core.BaseFragment;

import java.util.ArrayList;

/**
 * This class is used to show ten users  adapter
 *
 * @author jindaldipanshu
 * @version 1.0
 */

public class ProfileInterestsAdapter extends BaseAdapter  {

    private ArrayList<GetProfileResponse.Interest> mList;
    private BaseActivity mActivity;
    private BaseFragment mBaseFragment;

    public ProfileInterestsAdapter(BaseActivity context, ArrayList<?> mList) {
        this.mList = (ArrayList<GetProfileResponse.Interest>) mList;
        this.mActivity = context;
    }

    public ProfileInterestsAdapter(BaseFragment context, ArrayList<?> mList) {
        this.mList = (ArrayList<GetProfileResponse.Interest>) mList;
        this.mBaseFragment = context;
        this.mActivity = context.getBaseActivity();
    }


    public void notifyAdapter(ArrayList<?> mList){
        this.mList = (ArrayList<GetProfileResponse.Interest>) mList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mActivity);
            convertView = inflater.inflate(R.layout.row_skills, parent, false);
            viewHolder.mSkillsTextView = (TextView) convertView.findViewById(R.id.text_view_skills);
            //result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            //result=convertView;
        }

         viewHolder.mSkillsTextView.setText(mList.get(i).getName());
        return convertView;
    }

    public static  class ViewHolder  {
        private TextView mSkillsTextView;
    }


}

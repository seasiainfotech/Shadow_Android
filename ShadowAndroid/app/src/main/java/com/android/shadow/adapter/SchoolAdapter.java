package com.android.shadow.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.model.output.GetAllSchoolResponse;
import com.android.shadow.views.core.BaseActivity;
import com.android.shadow.views.core.BaseFragment;

import java.util.ArrayList;

/**
 * This class is used to show ten users  adapter
 *
 * @author jindaldipanshu
 * @version 1.0
 */

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {

    private ArrayList<GetAllSchoolResponse.SchoolList> mList;
    private BaseActivity mActivity;
    private OnItemClick onItemClick;

    /**
     * This interface is used to get the selected school name
     */
    public interface OnItemClick {
        void onItemClick(String schoolName);
    }


    public SchoolAdapter(BaseActivity context, ArrayList<?> mList, OnItemClick onItemClick) {

        this.mList = (ArrayList<GetAllSchoolResponse.SchoolList>) mList;
        this.mActivity = context;
        this.onItemClick = onItemClick;
    }

    public void notifyAdapter(ArrayList<?> mList) {
        this.mList = (ArrayList<GetAllSchoolResponse.SchoolList>) mList;
        notifyDataSetChanged();
    }


    @Override
    public SchoolAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_schools, null);
        // create ViewHolder
        SchoolAdapter.ViewHolder viewHolder = new SchoolAdapter.ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SchoolAdapter.ViewHolder viewHolder, int position) {
        viewHolder.mSchoolNameTextView.setText(mList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mSchoolNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mSchoolNameTextView = (TextView) itemView.findViewById(R.id.text_view_school_name);
            itemView.findViewById(R.id.ll_Sch).setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            switch (view.getId()) {
                case R.id.ll_Sch:
                    onItemClick.onItemClick(mList.get(position).getName());
                    break;
            }
        }
    }
}

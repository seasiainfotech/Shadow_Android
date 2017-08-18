package com.android.shadow.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.model.output.GetAvailableCompanyListResponse;
import com.android.shadow.views.core.BaseActivity;

import java.util.ArrayList;

/**
 * Created by singhgharjyot on 7/21/2017.
 */

public class CompanyListAdapter extends RecyclerView.Adapter<CompanyListAdapter.ViewHolder> {

    private ArrayList<GetAvailableCompanyListResponse.CompanyList> mList;
    private BaseActivity mActivity;
    private OnItemClick onItemClick;

    /**
     * This interface is used to get the selected school name
     */
    public interface OnItemClick {
        void onItemClick(String schoolName);
    }

    public CompanyListAdapter(BaseActivity context, ArrayList<?> mList, OnItemClick onItemClick) {

        this.mList = (ArrayList<GetAvailableCompanyListResponse.CompanyList>) mList;
        this.mActivity = context;
        this.onItemClick = onItemClick;
    }

    public void notifyAdapter(ArrayList<?> mList) {
        this.mList = (ArrayList<GetAvailableCompanyListResponse.CompanyList>) mList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_schools, null);
        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
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

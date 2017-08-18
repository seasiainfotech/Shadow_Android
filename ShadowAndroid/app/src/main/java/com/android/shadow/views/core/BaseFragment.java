package com.android.shadow.views.core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.android.shadow.interfaces.Core;
import com.android.shadow.interfaces.Disposable;

import java.util.ArrayList;

/**
 * To initialize view,controls and replace Fragments
 * Created by jindaldipanshu on 7/2/2016.
 *
 * @version 1.0
 */
public abstract class BaseFragment extends Fragment implements Core, Disposable{
    public String TAG = "BaseFragment";
    public BaseActivity activity;
    public Context mContext;
    private View mView;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (BaseActivity) activity;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    protected View findViewById(int id) {
        return mView.findViewById(id);
    }

    public BaseActivity getBaseActivity() {
        return activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        getDataFromBundle(getArguments());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    protected void getDataFromBundle(Bundle bundle) {
        if (getArguments() != null) {
            //tab_position = getArguments().getInt("tab_position");
        }
    }


    protected abstract int getLayoutId();

    protected abstract void initViews(View view);


    @Override
    public void onDestroy() {
        super.onDestroy();
        dispose();
    }

    @Override
    public void showToast(int resId) {
        Toast.makeText(activity, "" + getString(resId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(activity, "" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog() {
        try {
            if (!getBaseActivity().isFinishing()) {
                //ProgressUtility.showProgress(getBaseActivity(), getString(R.string.please_wait_meassge));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hideDialog() {
        //ProgressUtility.dismissProgress();
    }

    public void setAdapter(RecyclerView recyclerView, ArrayList<?> mList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void notifyList(int position) {

    }

    /**
     * This method is used to replace Child Fragment
     *
     * @param frameLayout
     * @param childFragment
     * @param bundle
     */
    public void replaceChildFragment(int frameLayout, Fragment childFragment, Bundle bundle) {

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (bundle != null) {
            childFragment.setArguments(bundle);
        }
        transaction.addToBackStack(null);
        transaction.replace(frameLayout, childFragment).commit();//R.id.fragment_mainLayout
    }


    public void reLoadList() {}
}


package com.android.shadow.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.android.shadow.R;
import com.android.shadow.interfaces.Core;
import com.android.shadow.utils.ProgressUtility;

/**
 * Created by jindaldipanshu on 6/28/2017.
 */

public abstract class BaseDialog implements  Core  {

    protected Dialog mDialogName;

    protected  void showBaseDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(getLayoutId(), null);
        dialogBuilder.setView(dialogView);
        initViews(dialogView);
        mDialogName = dialogBuilder.create();
        mDialogName.show();
    }

    protected abstract AppCompatActivity getActivity();

    protected abstract int getLayoutId();

    protected abstract void initViews(View dialogView);

    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity(),message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(int resId) {
        Toast.makeText(getActivity(),getActivity().getString(resId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog() {
        ProgressUtility.showProgress(getActivity(), getActivity().getString(R.string.please_wait_meassge));
    }

    @Override
    public void hideDialog() {
        ProgressUtility.dismissProgress();
    }
}



package com.android.shadow.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;

import com.android.shadow.R;
import com.android.shadow.views.core.BaseActivity;

/**
 * Created by jindaldipanshu on 5/31/2017.
 */

public class AddSkillsDialog {

    private BaseActivity mActivity;
    private Dialog mSkillsDialog;

    public AddSkillsDialog(BaseActivity baseActivity) {
        mActivity = baseActivity;

    }

    public void showSkillsDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mActivity);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_skills, null);
        dialogBuilder.setView(dialogView);
        //initViews(dialogView);
        mSkillsDialog = dialogBuilder.create();
        mSkillsDialog.show();
    }

}

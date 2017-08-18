package com.android.shadow.dialog;


import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.views.core.BaseActivity;

/**
 * Created by jindaldipanshu on 5/31/2017.
 */

public class EmailNumberSelectionDialog implements View.OnClickListener {

    private final EmailSelectionCallback selectionCallback;
    private final BaseActivity baseActivity;
    private Dialog mSelectionDialog;

    public interface EmailSelectionCallback {
        void getSelection(boolean isEmailSelected);
    }

    public EmailNumberSelectionDialog(BaseActivity baseActivity, EmailSelectionCallback selectionCallback) {
        this.baseActivity = baseActivity;
        this.selectionCallback = selectionCallback;
    }

    public void showEmailNumberDialog(int id) {
        mSelectionDialog = new Dialog(baseActivity);
        mSelectionDialog.setContentView(R.layout.dialog_number_email_selection);
        Button dialogName = (Button) mSelectionDialog.findViewById(R.id.dialog_title_name);
        dialogName.setText(baseActivity.getString(id));
        mSelectionDialog.findViewById(R.id.txt_view_via_email).setOnClickListener(this);
        mSelectionDialog.findViewById(R.id.txt_view_via_number).setOnClickListener(this);
        mSelectionDialog.findViewById(R.id.cancel).setOnClickListener(this);
        mSelectionDialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                mSelectionDialog.dismiss();
                break;
            case R.id.txt_view_via_email:

                mSelectionDialog.dismiss();
                selectionCallback.getSelection(true);  // for email
                break;
            case R.id.txt_view_via_number:
                mSelectionDialog.dismiss();
                selectionCallback.getSelection(false);
                break;
        }
    }
}

package com.android.shadow.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.views.core.BaseActivity;

/**
 * Created by singhgharjyot on 7/6/2017.
 */

public class SelectFilterDialog implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private BaseActivity mActivity;
    private Dialog mSelectDistanceDialog;
    private SeekBar mDistanceSeekBar;
    private TextView mDistanceTextView, mDoneButton, mCancelButton;
    private DiistanceCallback mDistanceCallback;
    private View dialogView;


    public interface DiistanceCallback {
        void getDistanceSelected(String distance);
    }

    public SelectFilterDialog(BaseActivity baseActivity, DiistanceCallback distanceCallback) {
        mActivity = baseActivity;
        mDistanceCallback = distanceCallback;
    }

    public void ShowFilterDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mActivity);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_select_filter, null);
        dialogBuilder.setView(dialogView);
        mDistanceSeekBar = (SeekBar) dialogView.findViewById(R.id.seek_bar_distance);
        mDoneButton = (TextView) dialogView.findViewById(R.id.text_view_done_button);
        mCancelButton = (TextView) dialogView.findViewById(R.id.text_view_cancel_button);
        mDistanceTextView = (TextView) dialogView.findViewById(R.id.text_view_distance_selected);
        mDistanceSeekBar.setOnSeekBarChangeListener(this);
        mDistanceSeekBar.setMax(10000);

        //initViews(dialogView);
        mSelectDistanceDialog = dialogBuilder.create();
        mSelectDistanceDialog.show();
        mDoneButton.setOnClickListener(this);
        mCancelButton.setOnClickListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        mDistanceTextView.setText(i + "");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_view_done_button:
                mDistanceCallback.getDistanceSelected(mDistanceTextView.getText().toString().trim());
                mSelectDistanceDialog.dismiss();
                break;

            case R.id.text_view_cancel_button:
                mSelectDistanceDialog.dismiss();
                break;
        }
    }
}
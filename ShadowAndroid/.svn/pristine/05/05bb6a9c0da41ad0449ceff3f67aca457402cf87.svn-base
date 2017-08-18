package com.android.shadow.views.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;

import com.android.shadow.R;
import com.android.shadow.utils.PreferenceKeys;
import com.android.shadow.utils.SharedPrefsHelper;
import com.android.shadow.views.core.BaseActivity;

import it.sephiroth.android.library.tooltip.Tooltip;

public class RegistrationActivity extends BaseActivity implements View.OnClickListener {

    private SharedPrefsHelper mSharedPrefsHelper;
    private ImageView helpIV;
    private ImageView helpIVCompany,helpIVSchool;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_registration;
    }

    @Override
    protected void initViews() {
        findViewById(R.id.image_view_back).setOnClickListener(this);
        findViewById(R.id.rl_user).setOnClickListener(this);
        findViewById(R.id.rl_school).setOnClickListener(this);
        findViewById(R.id.rl_comp).setOnClickListener(this);

        helpIV = (ImageView) findViewById(R.id.iv_user_help);
        helpIVCompany =(ImageView) findViewById(R.id.iv_comp_help);
        helpIVSchool =(ImageView) findViewById(R.id.iv_school_help);
        helpIVCompany.setOnClickListener(this);
        helpIVSchool.setOnClickListener(this);
        helpIV.setOnClickListener(this);
        findViewById(R.id.iv_comp_help).setOnClickListener(this);
        findViewById(R.id.iv_school_help).setOnClickListener(this);

        mSharedPrefsHelper = new SharedPrefsHelper(this);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onClick(View view) {
        Intent userIntent;
        switch (view.getId()) {
            case R.id.iv_user_help:
                showToolTipMenu(getString(R.string.tooltip_user), "", helpIV);
                break;
            case R.id.iv_comp_help:
                showToolTipMenu(getString(R.string.tooltip_compnay), "", helpIVCompany);
                break;

            case R.id.iv_school_help:
                showToolTipMenu(getString(R.string.tooltip_school), "", helpIVSchool);

                break;
            case R.id.image_view_back:
                finish();
                break;
            case R.id.rl_user:
                userIntent = new Intent(RegistrationActivity.this, UsernameActivity.class);
                mSharedPrefsHelper.save(PreferenceKeys.PREF_REGIS, "user");
                startActivity(userIntent);
                break;

            case R.id.rl_school:
                userIntent = new Intent(RegistrationActivity.this, UsernameActivity.class);
                mSharedPrefsHelper.save(PreferenceKeys.PREF_REGIS, "school");
                startActivity(userIntent);
                break;

            case R.id.rl_comp:
                userIntent = new Intent(RegistrationActivity.this, UsernameActivity.class);
                mSharedPrefsHelper.save(PreferenceKeys.PREF_REGIS, "company");
                startActivity(userIntent);
                break;
        }
    }


    private void showToolTipMenu(String title, String data, ImageView imageView) {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        Tooltip.make(
                this,
                new Tooltip.Builder(101)
                        .anchor(imageView, Tooltip.Gravity.BOTTOM)
                        .closePolicy(Tooltip.ClosePolicy.TOUCH_ANYWHERE_NO_CONSUME, 3000)
                        .text(title)
//                        .fadeDuration(200)
                        .fitToScreen(true)
                        .maxWidth(metrics.widthPixels / 2)
                        .showDelay(400)
                        .withStyleId(R.style.ToolTipLayoutCustomStyle)
                        .toggleArrow(true)
                        .build()
        ).show();
    }
}

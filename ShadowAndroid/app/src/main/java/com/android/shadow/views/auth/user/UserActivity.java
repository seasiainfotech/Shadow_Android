package com.android.shadow.views.auth.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.utils.PreferenceKeys;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.auth.PasswordActivity;
import com.android.shadow.views.core.BaseActivity;

public class UserActivity extends BaseActivity implements View.OnClickListener {

    private TextView mNextTextView;
    private EditText mFirstNameEditText, mLastNameEditText;
    private Bundle mBundle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    protected void initViews() {
        mBundle = getIntent().getExtras();
        mFirstNameEditText = (EditText) findViewById(R.id.edit_text_first_name);
        mLastNameEditText = (EditText) findViewById(R.id.edit_text_last_name);
        mNextTextView = (TextView) findViewById(R.id.text_view_next);
        mNextTextView.setOnClickListener(this);
        findViewById(R.id.image_view_back).setOnClickListener(this);
        registerTextChangeListener();
    }


    @Override
    public void dispose() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_view_back:
                finish();
                break;
            case R.id.text_view_next:
                Utilities.hideKeypad(view);
                checkVaidations();
                break;
        }
    }

    private void checkVaidations() {
        String firstName = mFirstNameEditText.getText().toString().trim();
        String lastName = mLastNameEditText.getText().toString().trim();
        if (TextUtils.isEmpty(firstName)) {
            return;
        } else if (firstName.length() < 3) {
            showToast("Please enter first name");
        } else if (TextUtils.isEmpty(lastName)) {
            return;
        } else if (lastName.length() < 3) {
            showToast("Please enter last name");
        } else {
            mBundle.putString(PreferenceKeys.PREF_USER_FIRST_NAME, firstName);
            mBundle.putString(PreferenceKeys.PREF_USER_LAST_NAME, lastName);
            mBundle.putString(PreferenceKeys.PREF_USER_NAME,firstName+" "+lastName);
            Intent intent = new Intent(UserActivity.this, User1Activity.class);
            intent.putExtras(mBundle);
            startActivity(intent);
        }
    }

    private void registerTextChangeListener() {
        mFirstNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence firstName, int i, int i1, int i2) {
                String lastName = mLastNameEditText.getText().toString();
                if (firstName != null && firstName.length() >= 3 &&
                        !TextUtils.isEmpty(lastName) && lastName.length() >= 3) {
                    mNextTextView.setTextColor(getResources().getColor(android.R.color.white));
                    mNextTextView.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_filled_purple_border));
                } else {
                    mNextTextView.setTextColor(getResources().getColor(R.color.colorPrimary));
                    mNextTextView.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_purple_border));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mLastNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence lastName, int i, int i1, int i2) {
                String firstName = mFirstNameEditText.getText().toString();
                if (lastName != null && lastName.length() >= 3 &&
                        !TextUtils.isEmpty(firstName) && firstName.length() >= 3) {
                    mNextTextView.setTextColor(getResources().getColor(android.R.color.white));
                    mNextTextView.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_filled_purple_border));
                } else {
                    mNextTextView.setTextColor(getResources().getColor(R.color.colorPrimary));
                    mNextTextView.setBackgroundDrawable(getResources().getDrawable(R.drawable.round_purple_border));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


}

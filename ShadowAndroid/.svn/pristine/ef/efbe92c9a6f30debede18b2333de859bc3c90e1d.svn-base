package com.android.shadow.views.auth;

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
import com.android.shadow.addressvalidator.logger.Log;
import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.model.input.PasswordInput;
import com.android.shadow.model.input.UsernameInput;
import com.android.shadow.model.output.PasswordResponse;
import com.android.shadow.model.output.UsernameResponse;
import com.android.shadow.utils.PreferenceKeys;
import com.android.shadow.utils.SharedPrefsHelper;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.auth.company.CompanyActivity;
import com.android.shadow.views.auth.school.SchoolActivity;
import com.android.shadow.views.auth.user.UserActivity;
import com.android.shadow.views.core.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;

public class PasswordActivity extends BaseActivity implements View.OnClickListener {

    private TextView mNextTextView;
    private EditText mPasswordEditText, mConfirmPasswordEditText;
    private Bundle mBundle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_password;
    }

    @Override
    protected void initViews() {
        mBundle = getIntent().getExtras();
        findViewById(R.id.image_view_back).setOnClickListener(this);
        mPasswordEditText = (EditText) findViewById(R.id.edit_text_password);
        mConfirmPasswordEditText = (EditText) findViewById(R.id.edit_text_confirm_pass);
        mNextTextView = (TextView) findViewById(R.id.text_view_next_password);
        mNextTextView.setOnClickListener(this);
        registerTextChangeListener();

    }


    @Override
    public void dispose() {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Utilities.hideKeypad(view);
        switch (id) {
            case R.id.image_view_back:
                finish();
                break;

            case R.id.text_view_next_password:

                checkValidations();
                break;
        }
    }



    private void checkValidations() {
        String password = mPasswordEditText.getText().toString().trim();
        String confirmPassword = mConfirmPasswordEditText.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            return;
        } else if (password.length() < 6) {
            showToast("Password should be 6 characters long");
        } else if (TextUtils.isEmpty(confirmPassword)) {
            return;
        } else if (confirmPassword.length() < 6) {
            showToast("Confirm password should be 6 characters long");
        } else if (!password.equals(confirmPassword)) {
            showToast("Password  does not match with confirm password");
        } else {
            if (!Utilities.checkInternet(this)) {
                showToast(R.string.no_internet_msg);
            } else {
                SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(PasswordActivity.this);
                String selection = sharedPrefsHelper.get(PreferenceKeys.PREF_REGIS);
                mBundle.putString(PreferenceKeys.PREF_PASSWORD, password);
                Intent intent;
                if (selection.contains("user")) {
                    intent = new Intent(PasswordActivity.this, UserActivity.class);
                    intent.putExtras(mBundle);
                    startActivity(intent);
                } else if (selection.contains("school")) {
                    intent = new Intent(PasswordActivity.this, SchoolActivity.class);
                    intent.putExtras(mBundle);
                    startActivity(intent);
                } else if (selection.contains("company")) {
                    intent = new Intent(PasswordActivity.this, CompanyActivity.class);
                    intent.putExtras(mBundle);
                    startActivity(intent);
                }
            }
        }
    }
    private void registerTextChangeListener() {

        mPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence pass, int i, int i1, int i2) {

                String confirmPass = mConfirmPasswordEditText.getText().toString();
                if (pass != null && pass.length() >= 6 && !TextUtils.isEmpty(confirmPass) && confirmPass.equals(pass.toString())) {
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

        mConfirmPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence confirmPass, int i, int i1, int i2) {
                String pass = mPasswordEditText.getText().toString();
                Log.e("confirmpass--length", confirmPass.length() + "--pass--" + pass + "--confirm" + confirmPass);
                if (confirmPass != null && confirmPass.length() >= 6 && !TextUtils.isEmpty(pass) && pass.equals(confirmPass.toString())) {
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

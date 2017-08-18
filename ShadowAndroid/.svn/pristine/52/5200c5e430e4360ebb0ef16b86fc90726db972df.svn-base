package com.android.shadow.views.auth.forgotpassword;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.model.output.EmailOtpResponse;
import com.android.shadow.presenter.EmailOtpPresenter;
import com.android.shadow.utils.SharedPrefsHelper;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.core.BaseActivity;

import retrofit2.Response;

public class EmailForgotActivity extends BaseActivity implements View.OnClickListener, EmailOtpPresenter.EmailOtpCallback, TextWatcher {
    private TextView mNextTextView;
    private EditText mEmailEditText;
    private Bundle mBundle;
    private SharedPrefsHelper sharedPrefsHelper;
    private EmailOtpPresenter emailForgotPasswordPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_email_forgot;
    }

    @Override
    protected void initViews() {
        mNextTextView = (TextView) findViewById(R.id.text_view_next_email);
        mEmailEditText = (EditText) findViewById(R.id.edit_text_email);
        mNextTextView.setOnClickListener(this);
        findViewById(R.id.text_view_try_phone).setOnClickListener(this);
        findViewById(R.id.image_view_back).setOnClickListener(this);
        mEmailEditText.addTextChangedListener(this);
    }

    @Override
    public void dispose() {

    }


    @Override
    public void onClick(View view) {
        Utilities.hideKeypad(view);
        switch (view.getId()) {
            case R.id.image_view_back:
                finish();
                break;
            case R.id.text_view_next_email:
                if (emailForgotPasswordPresenter == null) {
                    emailForgotPasswordPresenter = new EmailOtpPresenter(this, this);
                }
                emailForgotPasswordPresenter.checkValidations(mEmailEditText.getText().toString().trim());
                break;

            case R.id.text_view_try_phone:
                Intent phoneForgotIntent = new Intent(this, PhoneForgotActivity.class);
                startActivity(phoneForgotIntent);
                finish();
                break;
        }

    }

    @Override
    public void onEmailOtpSuccess(Response<EmailOtpResponse> response) {
        if (response != null && response.body() != null) {
            if (response.body().getStatus().equals("200")) {
                Log.e("response successful", "--------------");
                Intent setNewPasswordIntent = new Intent(this, SetNewPasswordActivity.class);
                setNewPasswordIntent.putExtra("coming_from", 0); // 0 when setnewactivity called from emailforgot
                setNewPasswordIntent.putExtra("email_otp", response.body().getData().getEmailOtp().toString());
                Log.e("email otp ------", response.body().getData().getEmailOtp());
                setNewPasswordIntent.putExtra("user_id", response.body().getData().getUserId().toString());
                startActivity(setNewPasswordIntent);
            } else if (response.body().getStatus().equals("404")) {
                showToast(response.body().getMessage());
            }
        } else {
            showToast(R.string.server_error_msg);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence email, int i, int i1, int i2) {
        if (email != null && Utilities.isValidEmail(email.toString())) {
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
}

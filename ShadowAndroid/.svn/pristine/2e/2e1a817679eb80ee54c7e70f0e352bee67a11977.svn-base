package com.android.shadow.views.auth.forgotpassword;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.model.output.SetNewPasswordResponse;
import com.android.shadow.presenter.SetNewPasswordPresenter;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.auth.LoginActivity;
import com.android.shadow.views.core.BaseActivity;

import retrofit2.Response;

public class SetNewPasswordActivity extends BaseActivity implements View.OnClickListener, SetNewPasswordPresenter.SetNewPasswordCallback {

    private EditText mCodeEditText, mNewPassword, mConfirmPassword;
    private TextView mDoneButton;
    private String mUserId, mEmailOtp, mPhoneOtp;
    private int mComingFrom;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_new_password;
    }

    @Override
    protected void initViews() {
        getDataFromIntent();
        mCodeEditText = (EditText) findViewById(R.id.edit_text_code);
        mNewPassword = (EditText) findViewById(R.id.edit_text_new_password);
        mConfirmPassword = (EditText) findViewById(R.id.edit_text_confirm_new_password);
        mDoneButton = (TextView) findViewById(R.id.text_view_done);
        mDoneButton.setOnClickListener(this);
        findViewById(R.id.image_view_back).setOnClickListener(this);

    }

    private void getDataFromIntent() {
        mComingFrom = getIntent().getIntExtra("coming_from", 0); // 0 for emailforgotactivity, 1 for phoneforgotActivity
        mUserId = getIntent().getStringExtra("user_id");
        if (mComingFrom == 0) {
            mEmailOtp = getIntent().getStringExtra("email_otp");
        } else {
            mPhoneOtp = getIntent().getStringExtra("phone_otp");
        }
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

            case R.id.text_view_done:
                if (mComingFrom == 0) {
                    SetNewPasswordPresenter setNewPasswordPresenter = new SetNewPasswordPresenter(this, this);
                    setNewPasswordPresenter.checkValidations(mCodeEditText.getText().toString().trim(), mNewPassword.getText().toString().trim(),
                            mConfirmPassword.getText().toString().trim(), mUserId, mEmailOtp);
                } else {
                    SetNewPasswordPresenter setNewPasswordPresenter = new SetNewPasswordPresenter(this, this);
                    setNewPasswordPresenter.checkValidations(mCodeEditText.getText().toString().trim(), mNewPassword.getText().toString().trim(),
                            mConfirmPassword.getText().toString().trim(), mUserId, mPhoneOtp);
                }
                break;
        }
    }

    @Override
    public void setNewPasswordSuccess(Response<SetNewPasswordResponse> response) {
        if (response != null && response.body() != null) {
            if (response.body().getStatus().equals("200")) {
                showToast(response.body().getMessage());
                Log.e("password change", "succesfully --------");
                Intent loginIntent = new Intent(this, LoginActivity.class);
                loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(loginIntent);
                finish();
            }
        }
    }
}

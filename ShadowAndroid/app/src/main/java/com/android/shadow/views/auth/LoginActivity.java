package com.android.shadow.views.auth;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.android.shadow.R;
import com.android.shadow.ShadowApp;
import com.android.shadow.dialog.EmailNumberSelectionDialog;
import com.android.shadow.dialog.SchoolListDialog;
import com.android.shadow.model.output.LoginResponse;
import com.android.shadow.presenter.LoginPresenter;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.auth.forgotpassword.EmailForgotActivity;
import com.android.shadow.views.auth.forgotpassword.PhoneForgotActivity;
import com.android.shadow.views.core.BaseActivity;

import retrofit2.Response;

public class LoginActivity extends BaseActivity implements View.OnClickListener,
        LoginPresenter.LoginCallback, EmailNumberSelectionDialog.EmailSelectionCallback {
    private EditText mEmailEditText, mPasswordEditText;
    private LoginPresenter mLoginPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        ShadowApp.deviceid = getDeviceId();
        mEmailEditText = (EditText) findViewById(R.id.edt_txt_email);
        mPasswordEditText = (EditText) findViewById(R.id.edt_txt_password);
        findViewById(R.id.text_view_forgot_password).setOnClickListener(this);
        findViewById(R.id.text_view_login).setOnClickListener(this);
        findViewById(R.id.text_view_need_account).setOnClickListener(this);
        findViewById(R.id.ll_login).setOnClickListener(this);

    }


    @Override
    public void dispose() {
        if (mLoginPresenter != null) {
            mLoginPresenter = null;
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Utilities.hideKeypad(view);
        switch (id) {
            case R.id.text_view_login:
                if (mLoginPresenter == null)
                    mLoginPresenter = new LoginPresenter(LoginActivity.this, LoginActivity.this);
                mLoginPresenter.checkValidations(mEmailEditText.getText().toString().trim(),
                        mPasswordEditText.getText().toString().trim());
                break;

            case R.id.text_view_forgot_password:
               /* EmailNumberSelectionDialog emailNumberSelectionDialog = new EmailNumberSelectionDialog(this, this);
                emailNumberSelectionDialog.showEmailNumberDialog(R.string.dialog_verify_pass_title_name);*/
                Intent intent = new Intent(LoginActivity.this, EmailForgotActivity.class);
                intent.putExtra("forgot_pass", "email");
                startActivity(intent);
                break;

            case R.id.text_view_need_account:
                Intent i = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public void onLoginSuccess(Response<LoginResponse> loginResponse) {

    }

    @Override
    public void getSelection(boolean isEmailSelected) {
        Intent intent;
        if (isEmailSelected) {
            intent = new Intent(LoginActivity.this, EmailForgotActivity.class);
            intent.putExtra("forgot_pass", "email");
            startActivity(intent);
        } else {
            intent = new Intent(LoginActivity.this, PhoneForgotActivity.class);
            intent.putExtra("forgot_pass", "phone");
            startActivity(intent);
        }
    }
}

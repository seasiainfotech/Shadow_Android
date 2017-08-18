package com.android.shadow.views.auth.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.dialog.EmailNumberSelectionDialog;
import com.android.shadow.model.input.SignupInput;
import com.android.shadow.presenter.SignUpPresenter;
import com.android.shadow.utils.PreferenceKeys;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.auth.EmailPhoneOtpVerifiyActivity;
import com.android.shadow.views.auth.EmailVerificationActivity;
import com.android.shadow.views.auth.PhoneVerificationActivity;
import com.android.shadow.views.core.BaseActivity;

public class User1Activity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
        EmailNumberSelectionDialog.EmailSelectionCallback, SignUpPresenter.SignUpCallback {

    private TextView mNextTextView;
    private RadioButton mYesRb, mNoRb;
    private Bundle mBundle;
    private boolean isYesSelected;
    private SignUpPresenter mSignUpPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user1;
    }

    @Override
    protected void initViews() {
        isYesSelected = true;
        mBundle = getIntent().getExtras();
        mYesRb = (RadioButton) findViewById(R.id.rb_yes);
        mNoRb = (RadioButton) findViewById(R.id.rb_no);
        mYesRb.setOnCheckedChangeListener(this);
        mNoRb.setOnCheckedChangeListener(this);
        mNextTextView = (TextView) findViewById(R.id.text_view_next_user1);
        mNextTextView.setOnClickListener(this);
        findViewById(R.id.image_view_back).setOnClickListener(this);
        mBundle.putString(PreferenceKeys.PREF_YES_SELECTED, isYesSelected + "");
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
            case R.id.text_view_next_user1:
                Utilities.hideKeypad(view);
                if (mSignUpPresenter == null)
                    mSignUpPresenter = new SignUpPresenter(this, User1Activity.this);
                mSignUpPresenter.checkEmailValidation(mBundle.getString(PreferenceKeys.PREF_EMAIL_ID), mBundle);

                /*EmailNumberSelectionDialog emailNumberSelectionDialog = new EmailNumberSelectionDialog(this, this);
                emailNumberSelectionDialog.showEmailNumberDialog(R.string.dialog_verify_otp_title_name);*/
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int id = compoundButton.getId();
        switch (id) {
            case R.id.rb_yes:
                mBundle.putString(PreferenceKeys.PREF_YES_SELECTED, "true");
                break;
            case R.id.rb_no:
                mBundle.putString(PreferenceKeys.PREF_YES_SELECTED, "false");
                break;
        }
    }

    /**
     * This method is used to check selection
     * either for email or number
     * and call to selected activity
     *
     * @param isEmailSelected:true for email
     *                             false for number
     */
    @Override
    public void getSelection(boolean isEmailSelected) {

        if (isEmailSelected) {
            Intent intent = new Intent(User1Activity.this, EmailVerificationActivity.class);
            intent.putExtras(mBundle);
            intent.putExtra("sign_up_type","user");
            startActivity(intent);
        } else {
            Intent intent = new Intent(User1Activity.this, PhoneVerificationActivity.class);
            intent.putExtras(mBundle);
            startActivity(intent);
        }
    }

    @Override
    public void onSignUpSuccess(SignupInput signupInput, boolean isEmail) {
        Intent intent = new Intent(this, EmailPhoneOtpVerifiyActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        if (isEmail) {
            intent.putExtra("isEmail", isEmail);
            intent.putExtra("email", signupInput.getEmail());
        } else {
            intent.putExtra("isEmail", isEmail);
            intent.putExtra("phone", signupInput.getMobileNumber());
            intent.putExtra("country_code", signupInput.getCountryCode());
        }
        startActivity(intent);
        finish();
    }
}

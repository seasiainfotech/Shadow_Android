package com.android.shadow.views.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.model.input.CheckEmailAvailabilityInput;
import com.android.shadow.model.input.UsernameInput;
import com.android.shadow.model.output.CheckEmailAvailabilityResponse;
import com.android.shadow.utils.PreferenceKeys;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.core.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;

public class UsernameActivity extends BaseActivity implements View.OnClickListener, TextWatcher {

    private EditText mUseranmeEditText;
    private TextView mNextTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_username;
    }

    @Override
    protected void initViews() {
        findViewById(R.id.image_view_back).setOnClickListener(this);
        mUseranmeEditText = (EditText) findViewById(R.id.edit_text_username);
        mNextTextView = (TextView) findViewById(R.id.text_view_next_username);
        mNextTextView.setOnClickListener(this);
        mUseranmeEditText.addTextChangedListener(this);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.image_view_back) {
            finish();
        } else if (view.getId() == R.id.text_view_next_username) {
            String email = mUseranmeEditText.getText().toString().trim();
            if (!TextUtils.isEmpty(email)) {
                if (email.length() < 6) {
                    showToast(R.string.user_name_error);
                } else if (Utilities.isValidEmail(email)) {
                    Utilities.hideKeypad(view);
                    if (!Utilities.checkInternet(UsernameActivity.this)) {
                        showToast(R.string.no_internet_msg);
                    } else {
                        CheckEmailAvailabilityInput checkEmailAvailabilityInput = new CheckEmailAvailabilityInput();
                        checkEmailAvailabilityInput.setEmail(email);
                        checkResponse(checkEmailAvailabilityInput);
                    }
                }
            }
        }
    }

    private void checkResponse(final CheckEmailAvailabilityInput Input) {
        showDialog();
        Call<CheckEmailAvailabilityResponse> response = GetRestAdapter.getRestAdapter(false).checkEmailAvailability(Input);
        response.enqueue(new Callback<CheckEmailAvailabilityResponse>() {
            @Override
            public void onResponse(Call<CheckEmailAvailabilityResponse> call, retrofit2.Response<CheckEmailAvailabilityResponse> response) {
                hideDialog();
                if (response != null && response.body() != null) {
                    if (response.body().getStatus() != null) {
                        if (response.body().getStatus().equals("404")) {
                            Bundle bundle = new Bundle();
                            //bundle.putString(PreferenceKeys.PREF_USER_NAME, usernameInput.getUserName());
                            // using the name field as a email field.
                            bundle.putString(PreferenceKeys.PREF_EMAIL_ID, Input.getEmail());
                            Intent intent = new Intent(UsernameActivity.this, PasswordActivity.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } else if (response.body().getStatus().equals("226")) {
                            showToast("Email already registered");
                        } else {
                            showToast(response.body().getMessage());
                        }
                    }
                } else {
                    showToast(R.string.server_error_msg);
                }
            }

            @Override
            public void onFailure(Call<CheckEmailAvailabilityResponse> call, Throwable t) {
                hideDialog();
                showToast(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence text, int i, int i1, int i2) {

        if (text != null && Utilities.isValidEmail(text.toString())) {
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

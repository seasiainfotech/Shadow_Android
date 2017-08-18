package com.android.shadow.views.auth.forgotpassword;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.api.AuthenticationInterceptor;
import com.android.shadow.dialog.CountryDialog;
import com.android.shadow.model.output.CountryCodeOutput;
import com.android.shadow.model.output.PhoneOtpResponse;
import com.android.shadow.presenter.PhoneOtpPresenter;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.core.BaseActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneForgotActivity extends BaseActivity implements View.OnClickListener, CountryDialog.CountrySelect, PhoneOtpPresenter.PhoneOtpCallback, TextWatcher {

    private TextView mNextTextView;
    private CountryDialog countryDialog;
    private TextView mCountryCodeTextView;
    private String phonenoCode = "+1";
    private ArrayList<CountryCodeOutput.Country> mCountryList;
    private EditText mPhoneNumberEditText;
    private PhoneOtpPresenter phoneForgotPasswordPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_phone_forgot;
    }

    @Override
    protected void initViews() {
        mPhoneNumberEditText = (EditText) findViewById(R.id.edit_text_number);
        mNextTextView = (TextView) findViewById(R.id.text_view_next_number);
        mNextTextView.setOnClickListener(this);
        findViewById(R.id.image_view_back).setOnClickListener(this);
        findViewById(R.id.text_view_try_email).setOnClickListener(this);
        mCountryCodeTextView = (TextView) findViewById(R.id.tv_country_code);
        mCountryCodeTextView.setOnClickListener(this);
        mPhoneNumberEditText.addTextChangedListener(this);
    }

    @Override
    public void dispose() {

    }

    public void onClick(View view) {
        int id = view.getId();
        Utilities.hideKeypad(view);
        switch (id) {
            case R.id.tv_country_code:
                if (!Utilities.checkInternet(PhoneForgotActivity.this)) {
                    showToast(R.string.no_internet_msg);
                } else {
                    if (mCountryList == null || mCountryList.size() == 0) {
                        getPhoneCountry();
                    } else {
                        if (countryDialog == null)
                            countryDialog = new CountryDialog(this, this);
                        countryDialog.showCountryDialog(mCountryList);
                    }
                }
                break;
            case R.id.text_view_try_email:
                Intent phoneForgotIntent = new Intent(this, EmailForgotActivity.class);
                startActivity(phoneForgotIntent);
                finish();
                break;
            case R.id.image_view_back:
                finish();
                break;

            case R.id.text_view_next_number:
                if (phoneForgotPasswordPresenter == null) {
                    phoneForgotPasswordPresenter = new PhoneOtpPresenter(this, this);
                }
                phoneForgotPasswordPresenter.checkValidations(mPhoneNumberEditText.getText().toString().trim(),
                        mCountryCodeTextView.getText().toString().trim());
                break;
        }
    }

    private void getPhoneCountry() {
        showDialog();
        Call<CountryCodeOutput> response = AuthenticationInterceptor.getRestAdapter().getCountryCode();
        response.enqueue(new Callback<CountryCodeOutput>() {
            @Override
            public void onResponse(Call<CountryCodeOutput> call, Response<CountryCodeOutput> respone) {
                hideDialog();
                if (respone != null && respone.body() != null && respone.body().getResponse() != null &&
                        respone.body().getResponse().getCode() != null) {
                    if (respone.body().getResponse().getCode().equals("201")) {
                        if (respone.body().getResponse().getResult() != null) {
                            mCountryList = respone.body().getResponse().getResult().getCountry();
                            if (countryDialog == null)
                                countryDialog = new CountryDialog(PhoneForgotActivity.this, PhoneForgotActivity.this);
                            countryDialog.showCountryDialog(mCountryList);
                        } else {
                            showToast(getString(R.string.no_data_found_msg));
                        }

                    } else {
                        showToast(getString(R.string.no_data_found_msg));
                    }

                } else {
                    showToast(getString(R.string.server_error_msg));
                }
            }

            @Override
            public void onFailure(Call<CountryCodeOutput> call, Throwable t) {
                hideDialog();
                showToast(t.getMessage());
            }
        });
    }

    @Override
    public void getCountryCode(String country) {
        phonenoCode = country;
        mCountryCodeTextView.setText(country);
    }

    @Override
    public void onPhoneOtpSuccess(Response<PhoneOtpResponse> responePhoneForgot) {
        if (responePhoneForgot != null && responePhoneForgot.body() != null) {
            if (responePhoneForgot.body().getStatus().equals("200")) {
                Intent setNewPasswordIntent = new Intent(this, SetNewPasswordActivity.class);
                setNewPasswordIntent.putExtra("coming_from", 1);                                                                                                                                        // 1 for phoneforgotactivity, 0 for emailForgotActivity
                setNewPasswordIntent.putExtra("user_id", responePhoneForgot.body().getData().getUserId());
                setNewPasswordIntent.putExtra("phone_otp", responePhoneForgot.body().getData().getPhoneOtp());
                startActivity(setNewPasswordIntent);
            } else if (responePhoneForgot.body().getStatus().equals("404")) {
                showToast(responePhoneForgot.body().getMessage());
            }
        } else {
            showToast(getString(R.string.server_error_msg));
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence number, int i, int i1, int i2) {
        if (number != null && number.length() >= 10) {
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

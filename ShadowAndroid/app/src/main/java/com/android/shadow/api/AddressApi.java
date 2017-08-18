package com.android.shadow.api;

import com.android.shadow.R;
import com.android.shadow.utils.HttpUtils;
import com.android.shadow.views.core.BaseActivity;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * This class is used to check  address is valid  or not using google api
 *
 * @author jindaldipanshu
 * @version 1.0
 */

public class AddressApi {

    private BaseActivity mBaseActivity;
    private AddressValidator mAddressvalidator;

    public interface AddressValidator {
        void onSuccess(JSONObject jsonObject);
    }


    public AddressApi(BaseActivity vendorProfileActivity, AddressValidator addressvalidator) {
        this.mBaseActivity = vendorProfileActivity;
        this.mAddressvalidator = addressvalidator;
    }


    public void callAddressApi(String address) {
        HttpUtils.get(mBaseActivity, address, null, new JsonHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);

                mBaseActivity.hideDialog();
            }

            @Override
            public void onFinish() {
                super.onFinish();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString,
                                  Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                mBaseActivity.hideDialog();
                mBaseActivity.showToast(R.string.address_error_msg);
            }

            @Override
            public void onUserException(Throwable error) {
                super.onUserException(error);
                mBaseActivity.hideDialog();
                mBaseActivity.showToast(error.getMessage());
            }

            @Override
            public void onCancel() {
                super.onCancel();
                mBaseActivity.hideDialog();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                if (response != null) {
                    try {
                        String status = response.optString("status");
                        boolean partial_match;
                        if (status.equalsIgnoreCase("OK")) {
                            JSONArray jsonArray = response.getJSONArray("results");
                            if (jsonArray != null && jsonArray.length() > 0) {
                                partial_match = jsonArray.getJSONObject(0).optBoolean("partial_match");
                                JSONObject location = jsonArray.getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
                                mBaseActivity.hideDialog();
                                mAddressvalidator.onSuccess(response);


//                                if ((String.valueOf(partial_match).equals(false) || partial_match == false)) {
//                                    // mBaseActivity.showToast("Valid address");
//                                } else {
//                                    // mBaseActivity.hideDialog();
//                                    //mBaseActivity.showToast(R.string.address_error_msg);
//                                }


                            } else {
                                mBaseActivity.hideDialog();
                                mBaseActivity.showToast(R.string.address_error_msg);
                            }
                        } else {
                            mBaseActivity.hideDialog();
                            mBaseActivity.showToast(R.string.address_error_msg);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        mBaseActivity.hideDialog();
                        mBaseActivity.showToast(R.string.address_error_msg);
                    }
                } else {
                    mBaseActivity.hideDialog();
                    mBaseActivity.showToast(R.string.address_error_msg);
                }
            }
        });
    }
}
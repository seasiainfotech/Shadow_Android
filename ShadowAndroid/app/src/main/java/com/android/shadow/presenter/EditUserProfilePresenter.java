package com.android.shadow.presenter;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;

import com.android.shadow.R;
import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.model.SocialMedia;
import com.android.shadow.model.input.EditProfileInput;
import com.android.shadow.model.output.EditProfileResponse;
import com.android.shadow.utils.SharedPrefsHelper;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.auth.LoginActivity;
import com.android.shadow.views.profile.editprofile.EditProfileBaseActivity;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.FACEBOOK_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GITHUB_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GOOGLE_PLUS_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.INSTAGRAM_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.LINKEDIN_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.TWITTER_KEY;

/**
 * Created by jindaldipanshu on 7/6/2017.
 */

public class EditUserProfilePresenter {

    private EditProfileBaseActivity mEditProfileBaseActivity;
    private SharedPrefsHelper  sharedPrefsHelper;

    public EditUserProfilePresenter(EditProfileBaseActivity editProfileBaseActivity) {
        this.mEditProfileBaseActivity = editProfileBaseActivity;
    }


    public void checkValidations(ArrayList<EditProfileInput.Interest> interestsList,
                                 ArrayList<EditProfileInput.Occupations> occupationsList,
                                 ArrayList<SocialMedia.Media> selectedMediaList, String... params) {

        sharedPrefsHelper=new SharedPrefsHelper(mEditProfileBaseActivity);
        String userId = params[0];
        String schoolName = params[1];
        String companyName = params[2];
        String bio = params[3];
        String userImage = params[4];
        String url1 = mEditProfileBaseActivity.mUrl1EditText.getText().toString().trim();
        String url2 = mEditProfileBaseActivity.mUrl2EditText.getText().toString().trim();
        String url3 = mEditProfileBaseActivity.mUrl3EditText.getText().toString().trim();

        EditProfileInput editProfileInput = new EditProfileInput();
        editProfileInput.setGitHubUrl("");
        editProfileInput.setInstagramUrl("");
        editProfileInput.setGooglePlusUrl("");
        editProfileInput.setFacebookUrl("");
        editProfileInput.setTwitterUrl("");
        editProfileInput.setLinkedInUrl("");


        if (mEditProfileBaseActivity.mUrl1EditText.getVisibility() == View.VISIBLE) {
            if (TextUtils.isEmpty(url1)) {
                mEditProfileBaseActivity.showToast("Please enter url");
                return;
            } /*else if (!Patterns.WEB_URL.matcher(url1).matches()) {
                mEditProfileBaseActivity.showToast("Please enter valid url");
                return;
            }*/ else {
                setProfileUrl(editProfileInput, selectedMediaList.get(0).getId(), url1);
            }
        }
        if (mEditProfileBaseActivity.mUrl2EditText.getVisibility() == View.VISIBLE) {
            if (TextUtils.isEmpty(url2)) {
                mEditProfileBaseActivity.showToast("Please enter url");
                return;
            }
           /* else if (!Patterns.WEB_URL.matcher(url2).matches()) {
                mEditProfileBaseActivity.showToast("Please enter valid url");
                return;
            }*/
            else {
                setProfileUrl(editProfileInput, selectedMediaList.get(1).getId(), url2);
            }
        }
        if (mEditProfileBaseActivity.mUrl3EditText.getVisibility() == View.VISIBLE) {
            if (TextUtils.isEmpty(url3)) {
                mEditProfileBaseActivity.showToast("Please enter url");
                return;
            }
            /*else if (!Patterns.WEB_URL.matcher(url3).matches()) {
                mEditProfileBaseActivity.showToast("Please enter valid url");
                return;
            }*/

            else {
                setProfileUrl(editProfileInput, selectedMediaList.get(2).getId(), url3);
            }
        }

        editProfileInput.setAppVersion(mEditProfileBaseActivity.APP_NUMBER);
        editProfileInput.setAppBuildNumber(mEditProfileBaseActivity.APP_BUILD_NUMBER);
        editProfileInput.setSchoolName(schoolName);
        editProfileInput.setCompanyName(companyName);
        editProfileInput.setBio(bio);
        if (!TextUtils.isEmpty(userImage)) {
            editProfileInput.setProfileImage(userImage);
        }
        editProfileInput.setOccupations(occupationsList);
        editProfileInput.setInterest(interestsList);
        editProfileInput.setUserId(userId);

        Gson gson = new Gson();
        String json = gson.toJson(editProfileInput, EditProfileInput.class);
        Log.e("EditProfileInput--", json);

        if (!Utilities.checkInternet(mEditProfileBaseActivity)) {
            mEditProfileBaseActivity.showToast(R.string.no_internet_msg);
        } else {
            saveData(editProfileInput);
        }

    }

    private void saveData(EditProfileInput editProfileInput) {
        mEditProfileBaseActivity.showDialog();
        Call<EditProfileResponse> editProfileResponseCall = GetRestAdapter.getRestAdapter(false).editProfile(editProfileInput);
        editProfileResponseCall.enqueue(new Callback<EditProfileResponse>() {
            @Override
            public void onResponse(Call<EditProfileResponse> call, Response<EditProfileResponse> response) {
                mEditProfileBaseActivity.hideDialog();
                if (response != null && response.body() != null) {
                    if (response.body().getStatus().equals("200")) {
                        mEditProfileBaseActivity.showToast("Profile updated successfully");
                        mEditProfileBaseActivity.finish();
                    }
                    else if (response.body().getStatus().equals("401")) {
                        sharedPrefsHelper.clearAll();
                        Intent intent = new Intent(mEditProfileBaseActivity, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        mEditProfileBaseActivity.startActivity(intent);
                        mEditProfileBaseActivity.finish();
                    }

                    else {
                        mEditProfileBaseActivity.showToast(response.body().getMessage());
                    }
                } else {
                    mEditProfileBaseActivity.showToast(R.string.server_error_msg);
                }
            }

            @Override
            public void onFailure(Call<EditProfileResponse> call, Throwable t) {
                mEditProfileBaseActivity.hideDialog();
                mEditProfileBaseActivity.showToast(t.getMessage());
            }
        });

    }


    private void setProfileUrl(EditProfileInput editProfileInput, String id, String url1) {
        switch (id) {
            // typecast the link here.

            case TWITTER_KEY:
                editProfileInput.setTwitterUrl("https://www.twitter.com/"+url1);
                break;
            case FACEBOOK_KEY:
                editProfileInput.setFacebookUrl("https://www.facebook.com/"+url1);
                break;
            case LINKEDIN_KEY:
                editProfileInput.setLinkedInUrl("https://www.linkedin.com/"+url1);
                break;
            case GOOGLE_PLUS_KEY:
                editProfileInput.setGooglePlusUrl("https://www.GooglePlus.com/"+url1);
                break;
            case INSTAGRAM_KEY:
                editProfileInput.setInstagramUrl("https://www.Instagram.com/"+url1);
                break;
            case GITHUB_KEY:
                editProfileInput.setGitHubUrl("https://www.Github.com/"+url1);
                break;
        }
    }

}

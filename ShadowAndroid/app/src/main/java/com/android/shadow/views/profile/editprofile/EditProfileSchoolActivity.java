package com.android.shadow.views.profile.editprofile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.shadow.R;
import com.android.shadow.dialog.OccupationsDialog;
import com.android.shadow.dialog.SocialMediaDialog;
import com.android.shadow.imagechooser.api.ChooserType;
import com.android.shadow.model.output.GetAllInterestsResponse;
import com.android.shadow.model.output.GetAllOccupationResponse;
import com.android.shadow.model.output.GetProfileResponse;
import com.android.shadow.presenter.EditProfilePresenter;
import com.android.shadow.presenter.EditSchoolProfilePresenter;
import com.android.shadow.presenter.EditUserProfilePresenter;
import com.android.shadow.utils.Base64;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.videoRecording.CameraUploadActivity;
import com.bumptech.glide.Glide;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.model.LatLng;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import retrofit2.Response;

public class EditProfileSchoolActivity extends EditProfileBaseActivity implements View.OnClickListener,
        EditProfilePresenter.OccupationCallback {

    private static final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 2;
    private TextView mSchoolNameTextView, mSchoolLocationTextView,mSchoolNameEditText;
    private EditText mSchoolUrlEditText;
    private double mLongitude, mLatitude;
    private ImageView mVideoUploadImageView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_edit_profile_school;
    }

    @Override
    protected void initViews() {
        super.initViews();
        mSchoolNameTextView = (TextView) findViewById(R.id.text_view_school_name);
        mSchoolNameEditText = (TextView) findViewById(R.id.edit_text_school_name);
        mSchoolLocationTextView = (TextView) findViewById(R.id.text_view_school_location);
        mVideoUploadImageView = (ImageView) findViewById(R.id.iv_video_upload);
        mVideoUploadImageView.setOnClickListener(this);

        mSchoolUrlEditText = (EditText) findViewById(R.id.edit_text_school_url);
        mSchoolLocationTextView.setOnClickListener(this);

        findViewById(R.id.iv_plus_occupations).setOnClickListener(this);
        findViewById(R.id.iv_add_social_media).setOnClickListener(this);
        findViewById(R.id.image_view_save).setOnClickListener(this);
        findViewById(R.id.image_view_back).setOnClickListener(this);
        findViewById(R.id.rl_add_image).setOnClickListener(this);

        setDataOnUi();
        setOccupationsAdapter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (editProfilePresenter == null) {
            editProfilePresenter = new EditProfilePresenter(this, this);
        }
    }

    @Override
    public void onClick(View view) {
        Utilities.hideKeypad(view);
        switch (view.getId()) {
            case R.id.image_view_back:
                finish();
                break;
            case R.id.rl_add_image:
                editProfilePresenter.selectImage();
                break;

            case R.id.text_view_school_location:
                calLocation();
                break;

            case R.id.image_view_save:
                EditSchoolProfilePresenter userProfilePresenter = new EditSchoolProfilePresenter(this);
                userProfilePresenter.checkValidations(mLatitude, mLongitude, null, mOccupationsList, mSelectedMediaList,
                        mUserId, mSchoolUrlEditText.getText().toString(),
                        mSchoolLocationTextView.getText().toString(), mBioEditText.getText().toString(), userImage,mSchoolNameEditText.getText().toString());

                break;
            case R.id.iv_add_social_media:

                SocialMediaDialog socialMediaDialog = new SocialMediaDialog(this, this);
                socialMediaDialog.showMediaDialog(mSelectedMediaList, mAllSocialMediaList);
                break;
            case R.id.text_view_school_name:

                break;
            case R.id.iv_plus_occupations:
                if (!Utilities.checkInternet(this)){
                    showToast(R.string.no_internet_msg);
                }else {
                    OccupationsDialog occupationsDialog = new OccupationsDialog(this, this);
                    occupationsDialog.getAllOccupations(mOccupationsList, mUserId);
                }

                break;


            case R.id.iv_video_upload:
                Intent videoIntent = new Intent(this, CameraUploadActivity.class);
                startActivity(videoIntent);
                break;

        }
    }


    private void calLocation() {
        try {
            Intent intent =
                    new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .build(this);
            startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
        } catch (GooglePlayServicesRepairableException e) {
            // TODO: Handle the error.
        } catch (GooglePlayServicesNotAvailableException e) {
            // TODO: Handle the error.
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.e("AS", "Place: " + place.getName());

                LatLng latlong = place.getLatLng();
                mSchoolLocationTextView.setText(place.getName());
                mLongitude = latlong.longitude;
                mLatitude = latlong.latitude;
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        } else  if (resultCode == RESULT_OK &&
                (requestCode == ChooserType.REQUEST_PICK_PICTURE ||
                        requestCode == ChooserType.REQUEST_CAPTURE_PICTURE)) {

            if (data != null && data.getData() != null) {
                // To start a image picker, pass null as imageUri
                Uri uri = data.getData();
                Intent intent = CropImage.activity(uri)
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .getIntent(this);

                startActivityForResult(intent, CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE);

            } else {
                Uri uri = Uri.fromFile(new File(filePath));
                if (uri != null) {
                    Intent intent = CropImage.activity(uri)
                            .setGuidelines(CropImageView.Guidelines.ON)
                            .getIntent(this);

                    startActivityForResult(intent, CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE);
                } else {
                    if (editProfilePresenter.imageChooserManager == null) {
                        editProfilePresenter.reinitializeImageChooser();
                    }
                    editProfilePresenter.imageChooserManager.submit(requestCode, data);
                }
            }
        } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                Bitmap thumbnailBitmap =  null;
                try {
                    thumbnailBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),resultUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (thumbnailBitmap!=null) {

                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    thumbnailBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    // byte data[] = new byte[1024];
                    try {
                        String outputData = Base64.encodeBytes(byteArray, Base64.ENCODE);
                        userImage = outputData;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }else {

                }
                Glide.with(this).load(resultUri).into(mAddImageView);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                showToast(error.getMessage());
            }
        }


    }


    @Override
    public void onInterestsListSuccess(Response<GetAllInterestsResponse> response) {

    }

    @Override
    public void onOccupationListSuccess(Response<GetAllOccupationResponse> response) {

    }


    /**
     * This method is used to set data on ui
     */
    private void setDataOnUi() {
        if (profileResponse != null && profileResponse.getData() != null) {
            GetProfileResponse.Data profileData = profileResponse.getData();
            String schoolName = profileData.getSchoolName();
            String bio = profileData.getBio();
            String location = profileData.getLocation();
            String schoolUrl = profileData.getSchoolUrl();
            String imageUrl = profileData.getProfileImageUrl();
            if (!TextUtils.isEmpty(imageUrl)) {
                mIvPlusImageView.setVisibility(View.GONE);
                Glide.with(this).load(imageUrl).into(mAddImageView);
            }else {
                mIvPlusImageView.setVisibility(View.VISIBLE);
            }


            if (TextUtils.isEmpty(schoolName)) {
                mSchoolNameEditText.setText("");
                mSchoolNameTextView.setText("");
            } else {
                mSchoolNameEditText.setText(schoolName);
                mSchoolNameTextView.setText(schoolName);
            }

            if (TextUtils.isEmpty(location)) {
                mSchoolLocationTextView.setText("");
            } else {
                mSchoolLocationTextView.setText(location);
            }

            if (TextUtils.isEmpty(schoolUrl)) {
                mSchoolUrlEditText.setText("");
            } else {
                mSchoolUrlEditText.setText(schoolUrl);
            }

            if (TextUtils.isEmpty(bio)) {
                mBioEditText.setText("");
            } else {
                mBioEditText.setText(bio);
            }

        }
    }
}
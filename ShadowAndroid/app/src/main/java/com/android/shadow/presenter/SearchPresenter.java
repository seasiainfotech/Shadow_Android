package com.android.shadow.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;

import com.android.shadow.R;
import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.model.input.SearchAllTypeListInput;
import com.android.shadow.model.input.SearchLocationListInput;
import com.android.shadow.model.input.SearchSimpleFilterInput;
import com.android.shadow.model.output.SearchAllTypeListResponse;
import com.android.shadow.model.output.SearchLocationListResponse;
import com.android.shadow.model.output.SearchSimpleResponse;
import com.android.shadow.utils.PreferenceKeys;
import com.android.shadow.utils.ProgressUtility;
import com.android.shadow.utils.SharedPrefsHelper;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.auth.LoginActivity;
import com.android.shadow.views.core.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by singhgharjyot on 6/20/2017.
 */

public class SearchPresenter {

    private final SharedPrefsHelper mSharedPrefsHelper;
    private SearchPresenter.SearchCallback mSearchCallBack;
    private BaseActivity mBaseActivity;
    public double longitude, latitude;
    private CountDownTimer countDownTimer;
    private boolean isLatLongFound;


    public SearchPresenter(BaseActivity baseActivity, SearchPresenter.SearchCallback searchCallback) {
        this.mSearchCallBack = searchCallback;
        this.mBaseActivity = baseActivity;
        mSharedPrefsHelper = new SharedPrefsHelper(mBaseActivity);
    }

    public interface SearchCallback {
        void onSearchLocationListSuccess(retrofit2.Response<SearchLocationListResponse> response);

        void onSearchAllTypeListSuccess(retrofit2.Response<SearchAllTypeListResponse> response);

        void onSearchOccupationsListSuccess(retrofit2.Response<SearchAllTypeListResponse> response);

        void onSearchSimpleListSuccess(retrofit2.Response<SearchSimpleResponse> response);

        void onSearchNoData();
    }


    public void checkValidationsAllTypeList(String... params) {
        String keyword = params[0];
        String type = params[1];
        String index=params[2];

        if (!Utilities.checkInternet(mBaseActivity)) {
            mBaseActivity.showToast(R.string.no_internet_msg);
        } else {
            SearchAllTypeListInput searchAllTypeListInput = new SearchAllTypeListInput();
            String userId = mSharedPrefsHelper.get(PreferenceKeys.PREF_USER_ID);
            searchAllTypeListInput.setUserId(userId);
            searchAllTypeListInput.setRatingType(type);
            searchAllTypeListInput.setSearchKeyword(keyword);
            searchAllTypeListInput.setSearchType(0);
            searchAllTypeListInput.setPageSize("10");
            searchAllTypeListInput.setPageIndex(index);
            AllTypeListResponseCheck(searchAllTypeListInput);
        }
    }

    public void getOccupationsList(String... params) {
        String keyword = params[0];
        String type = params[1];
        String index=params[2];

        if (!Utilities.checkInternet(mBaseActivity)) {
            mBaseActivity.showToast(R.string.no_internet_msg);
        } else {
            SearchAllTypeListInput searchAllTypeListInput = new SearchAllTypeListInput();
            String userId = mSharedPrefsHelper.get(PreferenceKeys.PREF_USER_ID);
            searchAllTypeListInput.setUserId(userId);
            searchAllTypeListInput.setRatingType(type);
            searchAllTypeListInput.setSearchKeyword(keyword);
            searchAllTypeListInput.setSearchType(0);
            searchAllTypeListInput.setPageSize("10");
            searchAllTypeListInput.setPageIndex(index);
            getOccupationsListApi(searchAllTypeListInput);
        }
    }

    private  void  getOccupationsListApi(SearchAllTypeListInput searchAllTypeListInput){
        final  String keyword=searchAllTypeListInput.getSearchKeyword();
        if (TextUtils.isEmpty(keyword)){
            mBaseActivity.showDialog();
        }
        Call<SearchAllTypeListResponse> response = GetRestAdapter.getRestAdapter(true).getAllTypeList(searchAllTypeListInput);
        response.enqueue(new Callback<SearchAllTypeListResponse>() {
            @Override
            public void onResponse(Call<SearchAllTypeListResponse> call, retrofit2.Response<SearchAllTypeListResponse> response) {
                if (TextUtils.isEmpty(keyword)){
                    mBaseActivity.hideDialog();
                }
                if (response != null && response.body() != null) {
                    if (response.body().getStatus().equals("200")) {
                        if (response.body().getData() != null) {
                            Log.e("response AllTypelist", "--successfull--");
                            mSearchCallBack.onSearchOccupationsListSuccess(response);
                        }
                    } else if (response.body().getStatus().equals("401")) {
                        mSharedPrefsHelper.clearAll();
                        Intent intent = new Intent(mBaseActivity, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        mBaseActivity.startActivity(intent);
                        mBaseActivity.finish();
                    } else if (response.body().getStatus().equals("400")) {
                        //   mBaseActivity.showToast("no data found");
                        mSearchCallBack.onSearchNoData();
                    } else {
                        if (response.body().getMessage() != null) {
                            mBaseActivity.showToast(response.body().getMessage());
                        } else mBaseActivity.showToast(R.string.server_error_msg);
                    }
                } else {
                    mBaseActivity.showToast(R.string.server_error_msg);
                }
            }

            @Override
            public void onFailure(Call<SearchAllTypeListResponse> call, Throwable t) {
                if (TextUtils.isEmpty(keyword)){
                    mBaseActivity.hideDialog();
                }
                mBaseActivity.showToast(t.getLocalizedMessage());
            }
        });
    }


    private void AllTypeListResponseCheck(SearchAllTypeListInput searchAllTypeListInput) {

        final String keyword=searchAllTypeListInput.getSearchKeyword();
        if (TextUtils.isEmpty(keyword)){
            mBaseActivity.showDialog();
        }
        Call<SearchAllTypeListResponse> response = GetRestAdapter.getRestAdapter(true).getAllTypeList(searchAllTypeListInput);
        response.enqueue(new Callback<SearchAllTypeListResponse>() {
            @Override
            public void onResponse(Call<SearchAllTypeListResponse> call, retrofit2.Response<SearchAllTypeListResponse> response) {
                if (TextUtils.isEmpty(keyword)){
                    mBaseActivity.hideDialog();
                }
                if (response != null && response.body() != null) {
                    if (response.body().getStatus().equals("200")) {
                        if (response.body().getData() != null) {
                            Log.e("response AllTypelist", "--successfull--");
                            mSearchCallBack.onSearchAllTypeListSuccess(response);
                        }
                    } else if (response.body().getStatus().equals("401")) {
                        mSharedPrefsHelper.clearAll();
                        Intent intent = new Intent(mBaseActivity, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        mBaseActivity.startActivity(intent);
                        mBaseActivity.finish();
                    } else if (response.body().getStatus().equals("400")) {
                     //   mBaseActivity.showToast("no data found");
                        mSearchCallBack.onSearchNoData();
                    } else {
                        if (response.body().getMessage() != null) {
                            mBaseActivity.showToast(response.body().getMessage());
                        } else mBaseActivity.showToast(R.string.server_error_msg);
                    }
                } else {
                    mBaseActivity.showToast(R.string.server_error_msg);
                }
            }

            @Override
            public void onFailure(Call<SearchAllTypeListResponse> call, Throwable t) {
                if (TextUtils.isEmpty(keyword)){
                    mBaseActivity.hideDialog();
                }
                mBaseActivity.showToast(t.getLocalizedMessage());
            }
        });
    }

    public void checkValidationsSimpleSearchList(String... params) {
        String keyword = params[0];
        String pageIndex=params[1];
        if (!Utilities.checkInternet(mBaseActivity)) {
            mBaseActivity.showToast(R.string.no_internet_msg);
        } else {
            SearchSimpleFilterInput searchSimpleFilterInput = new SearchSimpleFilterInput();
            String userId = mSharedPrefsHelper.get(PreferenceKeys.PREF_USER_ID);
            searchSimpleFilterInput.setUserId(userId);
            searchSimpleFilterInput.setSearchKeyword(keyword);
            searchSimpleFilterInput.setPageIndex(pageIndex);
            searchSimpleFilterInput.setPageSize("10");
            SimpleSearchListResponseCheck(searchSimpleFilterInput);
        }
    }

    private void SimpleSearchListResponseCheck(SearchSimpleFilterInput searchSimpleFilterInput) {

        final String keyword=searchSimpleFilterInput.getSearchKeyword();
        if (TextUtils.isEmpty(keyword)){
            mBaseActivity.showDialog();
        }

        Call<SearchSimpleResponse> response = GetRestAdapter.getRestAdapter(true).getSearchSimpleList(searchSimpleFilterInput);
        response.enqueue(new Callback<SearchSimpleResponse>() {
            @Override
            public void onResponse(Call<SearchSimpleResponse> call, retrofit2.Response<SearchSimpleResponse> response) {
                if (TextUtils.isEmpty(keyword)){
                    mBaseActivity.hideDialog();
                }

                if (response != null && response.body() != null) {
                    if (response.body().getStatus().equals("200")) {
                        if (response.body().getData() != null) {
                            Log.e("response AllTypelist", "--successfull--");
                            mSearchCallBack.onSearchSimpleListSuccess(response);
                        }
                    } else if (response.body().getStatus().equals("401")) {
                        mSharedPrefsHelper.clearAll();
                        Intent intent = new Intent(mBaseActivity, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        mBaseActivity.startActivity(intent);
                        mBaseActivity.finish();
                    } else if (response.body().getStatus().equals("400")) {
                       // mBaseActivity.showToast("no data found");
                        mSearchCallBack.onSearchNoData();
                    } else {
                        if (response.body().getMessage() != null) {
                            mBaseActivity.showToast(response.body().getMessage());
                        } else mBaseActivity.showToast(R.string.server_error_msg);
                    }
                } else {
                    mBaseActivity.showToast(R.string.server_error_msg);
                }
            }

            @Override
            public void onFailure(Call<SearchSimpleResponse> call, Throwable t) {
                if (TextUtils.isEmpty(keyword)){
                    mBaseActivity.hideDialog();
                }
                mBaseActivity.showToast(t.getLocalizedMessage());
            }
        });
    }


    public void checkValidationsLocationList(final String... params) {
        if (!gpsEnable()) {
            return;
        }
        getCurrentLocation();
        if (latitude == 0.0d || longitude == 0.0d) {
            ProgressUtility.showProgress(mBaseActivity, "Please wait...\nFetching your location");
            countDownTimer = new CountDownTimer(15000, 1000) {
                @Override
                public void onTick(long l) {
                    if (latitude != 0.0d || longitude != 0.0d) {
                        ProgressUtility.dismissProgress();
                        countDownTimer.cancel();
                        countDownTimer = null;
                        isLatLongFound = true;
                        callLocationApi(params);
                    } else {
                        getCurrentLocation();
                    }
                }

                @Override
                public void onFinish() {
                    ProgressUtility.dismissProgress();
                    if (latitude != 0.0d || longitude != 0.0d) {
                        countDownTimer.cancel();
                        countDownTimer = null;
                        isLatLongFound = true;
                        callLocationApi(params);
                    }
                }
            };
            countDownTimer.start();
        } else {
            try {
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                    countDownTimer = null;
                    ProgressUtility.dismissProgress();
                }

            } catch (Exception e) {
                countDownTimer = null;
                ProgressUtility.dismissProgress();
            }
            callLocationApi(params);
        }
    }

    private void callLocationApi(String... params) {
        String keyword = params[0];
        String Ditance = params[1];
        String pageIndex=params[2];
        if (!Utilities.checkInternet(mBaseActivity)) {
            mBaseActivity.showToast(R.string.no_internet_msg);
        } else {
            SearchLocationListInput searchLocationListInput = new SearchLocationListInput();
            String CurrentLatitude = Double.toString(latitude);
            String currentLongitude = Double.toString(longitude);
            String userId = mSharedPrefsHelper.get(PreferenceKeys.PREF_USER_ID);
            searchLocationListInput.setUserId(userId);
            searchLocationListInput.setRadiusInMiles(Ditance);
            searchLocationListInput.setLatitude(CurrentLatitude);
            searchLocationListInput.setLongitude(currentLongitude);
            searchLocationListInput.setSearchKeyword(keyword);
            searchLocationListInput.setSearchType(1);
            searchLocationListInput.setPageIndex(pageIndex);
            searchLocationListInput.setPageSize("10");
            LocationListResponseCheck(searchLocationListInput);
        }
    }

    private void getCurrentLocation() {
        Location location = mBaseActivity.getLastBestStaleLocation();
        if (location != null) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }
    }

    private void LocationListResponseCheck(SearchLocationListInput searchLocationListInput) {
        final String keyword=searchLocationListInput.getSearchKeyword();
        if (TextUtils.isEmpty(keyword)){
            mBaseActivity.showDialog();
        }

        Call<SearchLocationListResponse> response = GetRestAdapter.getRestAdapter(true).getLocationList(searchLocationListInput);
        response.enqueue(new Callback<SearchLocationListResponse>() {
            @Override
            public void onResponse(Call<SearchLocationListResponse> call, retrofit2.Response<SearchLocationListResponse> response) {
                if (TextUtils.isEmpty(keyword)){
                    mBaseActivity.hideDialog();
                }

                if (response != null && response.body() != null) {
                    if (response.body().getStatus().equals("200")) {
                        if (response.body().getData() != null) {
                            Log.e("response Companylist", "--successfull--");
                            mSearchCallBack.onSearchLocationListSuccess(response);
                        }
                    } else if (response.body().getStatus().equals("401")) {
                        mSharedPrefsHelper.clearAll();
                        Intent intent = new Intent(mBaseActivity, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        mBaseActivity.startActivity(intent);
                        mBaseActivity.finish();
                    } else if (response.body().getStatus().equals("400")) {
                       // mBaseActivity.showToast("no data found");
                        mSearchCallBack.onSearchNoData();
                    } else {
                        if (response.body().getMessage() != null) {
                            mBaseActivity.showToast(response.body().getMessage());
                        } else mBaseActivity.showToast(R.string.server_error_msg);
                    }
                } else {
                    mBaseActivity.showToast(R.string.server_error_msg);
                }
            }

            @Override
            public void onFailure(Call<SearchLocationListResponse> call, Throwable t) {
                if (TextUtils.isEmpty(keyword)){
                    mBaseActivity.hideDialog();
                }
                mBaseActivity.showToast(t.getLocalizedMessage());
            }
        });
    }

    public boolean gpsEnable() {
        final LocationManager manager = (LocationManager) mBaseActivity.getSystemService(Context.LOCATION_SERVICE);
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
            return false;
        } else {
            return true;
        }
    }

    protected void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mBaseActivity);
        builder.setMessage("Your GPS seems to be disabled, you need to enable your gps")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        mBaseActivity.startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

}

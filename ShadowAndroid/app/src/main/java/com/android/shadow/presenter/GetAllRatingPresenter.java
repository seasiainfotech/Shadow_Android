package com.android.shadow.presenter;

import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.model.input.GetProfileInput;
import com.android.shadow.model.output.GetAllRatingResponse;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.core.BaseActivity;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * This class is used to get All Rating
 *
 * @author jindaldipanshu
 * @version 1.0
 */
public class GetAllRatingPresenter {

    public interface RatingCallback {
        void onRatingSuccess(Response<GetAllRatingResponse> response);
    }

    private BaseActivity mBaseActivity;
    private RatingCallback mRatingCallback;

    public GetAllRatingPresenter(BaseActivity baseActivity, RatingCallback ratingCallback) {
        this.mBaseActivity = baseActivity;
        this.mRatingCallback = ratingCallback;
    }

    public void getUserOwnRating(String... params) {
        String userId = params[0];
        GetProfileInput getProfileInput = new GetProfileInput();
        getProfileInput.setUserId(userId);
        getProfileInput.setOtherUserId(userId);
        getRatingAPi(getProfileInput);
    }


    public void getAnotherUserRating(String... params) {
        String userId = params[0];
        String otherUserId = params[1];
        GetProfileInput getProfileInput = new GetProfileInput();
        getProfileInput.setOtherUserId(otherUserId);
        getProfileInput.setUserId(userId);
        getRatingAPi(getProfileInput);
    }


    private void getRatingAPi(GetProfileInput getProfileInput) {
        mBaseActivity.showDialog();
        Call<GetAllRatingResponse> getAllRatingResponseCall = GetRestAdapter.getRestAdapter(false).getRatingListById(getProfileInput);
        getAllRatingResponseCall.enqueue(new Callback<GetAllRatingResponse>() {
            @Override
            public void onResponse(Call<GetAllRatingResponse> call, Response<GetAllRatingResponse> response) {
                mBaseActivity.hideDialog();
                 mRatingCallback.onRatingSuccess(response);

            }

            @Override
            public void onFailure(Call<GetAllRatingResponse> call, Throwable t) {

                mBaseActivity.hideDialog();

                mBaseActivity.showToast(t.getMessage());
            }

        });
    }

}

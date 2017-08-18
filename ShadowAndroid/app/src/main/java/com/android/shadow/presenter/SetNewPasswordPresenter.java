package com.android.shadow.presenter;

import android.text.TextUtils;

import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.model.input.SetNewPasswordInput;
import com.android.shadow.model.output.SetNewPasswordResponse;
import com.android.shadow.views.auth.forgotpassword.SetNewPasswordActivity;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by singhgharjyot on 6/7/2017.
 */

public class SetNewPasswordPresenter {

    private SetNewPasswordCallback mSetNewPasswordCallback;
    private SetNewPasswordActivity setNewPasswordActivity;

    public interface SetNewPasswordCallback {
        void setNewPasswordSuccess(retrofit2.Response<SetNewPasswordResponse> response);
    }

    public SetNewPasswordPresenter(SetNewPasswordActivity setNewPasswordActivity, SetNewPasswordCallback setNewPasswordCallback) {
        this.mSetNewPasswordCallback = setNewPasswordCallback;
        this.setNewPasswordActivity = setNewPasswordActivity;
    }

    public void checkValidations(String... params) {
        String codeUser = params[0];
        String newPassword = params[1];
        String confirmPassword = params[2];
        String userId = params[3];
        String codeServer = params[4];
        if (TextUtils.isEmpty(codeUser)) {
            return;

        } else if (codeUser.length() <= 4) {
            setNewPasswordActivity.showToast("Invalid code");
        } else if (!codeUser.equals(codeServer)) {
            setNewPasswordActivity.showToast("Invalid code");
        } else if (TextUtils.isEmpty(newPassword)) {
            setNewPasswordActivity.showToast("Please Enter new password");
        } else if (newPassword.length() < 6) {
            setNewPasswordActivity.showToast("Password should be 6 characters long");
        } else if (TextUtils.isEmpty(confirmPassword)) {
            return;
        } else if (!newPassword.equals(confirmPassword)) {
            setNewPasswordActivity.showToast("Password and confirm password does not match");
        } else {
            SetNewPasswordInput setNewPasswordInput = new SetNewPasswordInput();
            setNewPasswordInput.setUserId(userId);
            setNewPasswordInput.setPassword(newPassword);
            responseCheck(setNewPasswordInput);
        }
    }

    private void responseCheck(SetNewPasswordInput setNewPasswordInput) {
        setNewPasswordActivity.showDialog();
        Call<SetNewPasswordResponse> response = GetRestAdapter.getRestAdapter(true).setNewPassword(setNewPasswordInput);
        response.enqueue(new Callback<SetNewPasswordResponse>() {
            @Override
            public void onResponse(Call<SetNewPasswordResponse> call, retrofit2.Response<SetNewPasswordResponse> response) {
                setNewPasswordActivity.hideDialog();
                mSetNewPasswordCallback.setNewPasswordSuccess(response);
            }

            @Override
            public void onFailure(Call<SetNewPasswordResponse> call, Throwable t) {
                setNewPasswordActivity.hideDialog();
                setNewPasswordActivity.showToast(t.getLocalizedMessage());
            }
        });
    }
}

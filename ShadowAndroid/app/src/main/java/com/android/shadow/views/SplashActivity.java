package com.android.shadow.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.android.shadow.R;
import com.android.shadow.ShadowApp;
import com.android.shadow.utils.PreferenceKeys;
import com.android.shadow.utils.SharedPrefsHelper;
import com.android.shadow.views.auth.LoginActivity;
import com.android.shadow.views.dashboard.DashboardActivity;
import com.android.shadow.views.request.recievedRequest.RecievedRequest;
import com.android.shadow.views.request.sendRequest.SendRequestActivity;

public class SplashActivity extends AppCompatActivity {

    private Thread timerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(SplashActivity.this);
                    String mSessionToken = sharedPrefsHelper.get(PreferenceKeys.PREF_SESSION_TOKEN);
               /*     if (!TextUtils.isEmpty(mSessionToken))
                        ShadowApp.sessionToken = mSessionToken;

                    String userId = sharedPrefsHelper.get(PreferenceKeys.PREF_USER_ID);
                    if (TextUtils.isEmpty(userId)) {*/

                        Intent intent = new Intent(SplashActivity.this, RecievedRequest.class);
                        startActivity(intent);
                        finish();
                    /*} else {
                        Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);  //DashboardActivity
                        startActivity(intent);
                        finish();
                    }*/


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (timerThread != null && timerThread.isAlive()) {
            timerThread.interrupt();
            finish();
        }
    }
}

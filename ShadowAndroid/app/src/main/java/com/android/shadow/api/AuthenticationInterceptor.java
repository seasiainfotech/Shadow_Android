package com.android.shadow.api;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AuthenticationInterceptor {
    // private static final String QA = "http://dotnetstg2.seasiaconsulting.com/RconnectQA/";
    private static final String UAT = "http://tentheapp-qa.com/";

    public static final String HOST_URL = UAT;
    public static GitHubService retrofitInterface;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static GitHubService getRestAdapter() {

        if (retrofitInterface == null) {

            retrofitInterface = new Retrofit.Builder()
                    .baseUrl(HOST_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
                    .create(GitHubService.class);
        }
        return retrofitInterface;
    }
}
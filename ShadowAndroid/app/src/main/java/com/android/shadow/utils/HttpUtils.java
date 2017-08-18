package com.android.shadow.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.entity.StringEntity;


public class HttpUtils implements UrlListener {

    private static AsyncHttpClient client = new AsyncHttpClient();


    /**
     * Method for calling web service of type GET
     *
     * @param context         context of the current Activity
     * @param url             web service URL
     * @param params          request parameters
     * @param responseHandler response Handler
     */
    public static void get(Context context, String url, StringEntity params,
                           JsonHttpResponseHandler responseHandler) {
        client.setTimeout(60 * 1000);

        if (params == null) {
            client.get(getAbsoluteUrl(context, url), responseHandler);

            // CommonUtils.myLog("HttpUtils", "get:  " + getAbsoluteUrl(context, url).toString());
        } else {
            client.get(context, getAbsoluteUrl(context, url), params, "application/json", responseHandler);

            //CommonUtils.myLog("HttpUtils", "get:  " + getAbsoluteUrl(context, url).toString() + "\nParams:  " + params.toString());
        }

    }

    /**
     * Method for calling web service of type POST
     *
     * @param context         context of the current Activity
     * @param url             web service URL
     * @param params          request parameters
     * @param responseHandler response Handler
     */
    public static void post(Context context, String url,
                            StringEntity params, JsonHttpResponseHandler responseHandler) {
        client.setTimeout(60 * 1000);
        client.post(context, getAbsoluteUrl(context, url), params, "application/json", responseHandler);
        // CommonUtils.myLog("HttpUtils", "post:  " + getAbsoluteUrl(context, url).toString() + "\nParams:  " + params.toString());
    }

    /**
     * Method for calling web service of type POST
     *
     * @param context         context of the current Activity
     * @param url             web service URL
     * @param params          request parameters
     * @param responseHandler response Handler
     */
    public static void postApi(Context context, String url,
                            StringEntity params, JsonHttpResponseHandler responseHandler) {
        client.setTimeout(60 * 1000);
        client.post(context,  url, params, "application/json", responseHandler);
        // CommonUtils.myLog("HttpUtils", "post:  " + getAbsoluteUrl(context, url).toString() + "\nParams:  " + params.toString());
    }
    /**
     * Method for calling Multipart web service of type POST
     *
     * @param context         context of the current Activity
     * @param url             web service URL
     * @param params          request parameters
     * @param responseHandler response Handler
     */
    public static void MultipartPost(Context context, String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
        client.setTimeout(60 * 1000);
        client.post(context, getAbsoluteUrl(context, url), params, responseHandler);
        //  CommonUtils.myLog("HttpUtils", "post:  " + getAbsoluteUrl(context, url).toString() + "\nParams:  " + params.toString());
    }

    /**
     * Cancel on going request
     *
     * @param context
     */
    public static void cancelCurrentRequest(Context context) {
        client.cancelRequests(context, true);
        // CommonUtils.myLog("cancelCurrentRequest", "cancelCurrentRequest");
    }

    /**
     * @param context       context of the current Activity
     * @param serviceMethod webservice method name
     * @return webservice URL
     */
    public static String key = "&key=AIzaSyBjr_trUDgCqihIotpvqYTG9GQkugxwdDs";

    public static String getAbsoluteUrl(Context context, String address) {
        String url = LOCATION_URL+  address + key;
        return url;
    }

    /**
     * Method for converting input parameters to StringEntity
     *
     * @param inputParams Input Parameters
     * @return Input Parameters of StringEntity type
     */
    public static StringEntity getJsonInput(Object inputParams) {
        Gson gson = new Gson();
        String requestString = gson.toJson(inputParams);
        //CommonUtils.myLog("getJsonInput", "requestString: " + requestString);
        return new StringEntity(requestString, Consts.UTF_8);
    }
}
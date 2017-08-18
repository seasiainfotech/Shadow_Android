package com.android.shadow;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.testfairy.TestFairy;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

/**
 * Created by jindaldipanshu on 5/26/2017.
 */

@ReportsCrashes(formKey = "dGVacG0ydVHnaNHjRjVTUTEtb3FPWGc6MQ",
        mailTo = "rkumar4@seasiainfotech.com,jindaldipanshu@seasiainfotech.com,singhgharjyot@seasiainfotech.com",
        mode = ReportingInteractionMode.DIALOG,
        resToastText = R.string.crash_toast_text, // optional, displayed as soon as the crash occurs, before collecting Data which can take a few seconds
        resDialogText = R.string.crash_dialog_text,
        resDialogIcon = android.R.drawable.ic_dialog_info, //optional. default is a warning sign
        resDialogTitle = R.string.crash_dialog_title, // optional. default is your application name
        resDialogCommentPrompt = R.string.crash_dialog_comment_prompt, // optional. when defined, adds a user text field input with this text resource as a label
        resDialogOkToast = R.string.crash_dialog_ok_toast // optional. displays a Toast message when the user accepts to send a report.

)

public class ShadowApp extends MultiDexApplication {

    public static String recordedVideoPath;
    public static String deviceid;
    public static String sessionToken="";

    @Override
    public void onCreate() {
        super.onCreate();
       //ACRA.init(this);
        TestFairy.begin(this, "2813e5e8d4b5b274cbdebb5dfc2f013909665937");
    }


}

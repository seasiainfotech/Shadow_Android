package com.android.shadow.utils;/* Copyright 2012 Google Inc. Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License. *//*

package com.nvcomputers.ten.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.google.android.gcm.GCMRegistrar;

*/
/**
 * Helper class providing methods and constants common to other classes in the
 * app.
 *//*

public final class GCMUtilities {
	
	
	public static final String TAG = "GCMDemo";
	public static final String DISPLAY_MESSAGE_ACTION = "com.google.android.gcm.demo.app.DISPLAY_MESSAGE";
	public static final String EXTRA_MESSAGE = "message";

	*/
/**
	 * @param context
	 *            message
	 * @return void
	 * @description this method send message, that created when
	 *              applicat499956257150ion register, unregister with gcm to
	 *              broadcast receiver.
	 *//*

	public static void displayMessage(Context context, String message) {
		Intent intent = new Intent(DISPLAY_MESSAGE_ACTION);
		intent.putExtra(EXTRA_MESSAGE, message);
		context.sendBroadcast(intent);
	}

	*/
/**
	 * Method is used to get/check regId for Google cloud messaging.
	 * 
	 * @param context
	 *            - Context of the class from where it is called.
	 * 
	 * @return void
	 *//*

	public static String myRegistrationId(Context context) {
		GCMRegistrar.checkDevice(context);
		GCMRegistrar.checkManifest(context);
		context.registerReceiver(mHandleMessageReceiver, new IntentFilter(GCMUtilities.DISPLAY_MESSAGE_ACTION));
		// this line of code checks if there exists a valid regId for this
		// device otherwise it will return null value.
		String regId = GCMRegistrar.getRegistrationId(context);
		System.out.println("My registeration id is " + regId);
		// if null value is returned we will create a new regId
		if (regId.equals("")) {
			System.out.println("Registering app on start up");
			GCMRegistrar.register(context, Const.GCM_APP_KEY);
			System.out.println("Registering done");
			regId = GCMRegistrar.getRegistrationId(context);
			System.out.println("My registeration id is " + regId);
		} else { // returns a valid regId
			*/
/**
			 * Compare this regId against our existing RegId stored in
			 * preferences and in case of any change update it to our server as
			 * well as update preferences.
			 *//*

			// here goes the code to update preferences
			// and also update the new Id at the server
		}
		return regId;
	}

	*/
/**
	 * @category Broadcast Receiver
	 * @description this method called when broadcast is send from
	 *              "displayMessage" method and show perticuler message.
	 *//*

	private final static BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			String newMessage = intent.getExtras().getString(GCMUtilities.EXTRA_MESSAGE);
			Log.d("","==="+newMessage);
			//Utilities.showDLog("~~~~~~~onReceive~~~~~~~", "=====newMessage=====" + newMessage);
			// notificationMessage = newMessage;
		}
	};
}
*/

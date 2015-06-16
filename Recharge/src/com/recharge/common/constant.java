package com.recharge.common;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;

public class constant {

	// public static boolean flag = true;
	public static DrawerLayout NavDrawerLayout;
	public static ListView NavList;

	public static void Set_flag(String email, String password, Context context) {
		SharedPreferences pref = context.getSharedPreferences("MyPref", 0);
		Editor editor = pref.edit();
		editor.putString("email", email);
		editor.putString("password", password);
		editor.commit();
	}

	public static String get_emailid(Context context) {
		SharedPreferences pref = context.getSharedPreferences("MyPref", 0);
		String email = pref.getString("email", "");
		return email;
	}

}

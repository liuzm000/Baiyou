package org.library.utils;

import java.util.LinkedList;

import android.app.Activity;
import android.util.Log;

public class MyActivityManagerUtils {

	static LinkedList<Activity> activities;

	static {
		if (activities == null) {
			activities = new LinkedList<Activity>();
		}
	}

	public static void addActivity(Activity a) {
		activities.add(a);
	}

	public static void exit() {
		for (int i = (activities.size() - 1); i >= 0; i--) {
			if (activities.get(i) != null) {
				activities.get(i).finish();
			}
		}
		System.exit(0);
	}

	// 退出之前的Activity
	public static void exit2() {
		for (int i = (activities.size() - 1); i >= 0; i--) {
			if (activities.get(i) != null) {
				activities.get(i).finish();
			}
		}
	}

	// 退出之前的Activity
	public static void exitToIndex() {
		Log.e("exitToIndex", "activities.size():");
		for (int i = (activities.size() - 1); i >= 1; i--) {
			Log.e("exitToIndex", "activities.size():"+activities.size());
			if (activities.get(i) != null) {
				Log.e("exitToIndex", "activities.finish():"+i);
				activities.get(i).finish();
			}
		}
	}

}

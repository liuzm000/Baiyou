package com.baiyou.base;

import org.library.http.HttpAsyncTaskUtils;

import android.app.Application;
import android.content.Context;

import abc.AppBase;

public class App extends AppBase{

	@Override
	public void onCreate() {
		super.onCreate();
		HttpAsyncTaskUtils.debug = true ;
	}
	
	
}

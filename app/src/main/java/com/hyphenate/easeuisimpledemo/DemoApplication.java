package com.hyphenate.easeuisimpledemo;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.hyphenate.easeuisimpledemo.ui.DemoHelper;

public class DemoApplication extends Application{
	public static Context applicationContext;
	private static DemoApplication instance;
	// login user name
	public final String PREF_USERNAME = "username";
	
	/**
	 * 当前用户nickname,为了苹果推送不是userid而是昵称
	 */
	public static String currentUserNick = "";

	@Override
	public void onCreate() {
		MultiDex.install(this);
		super.onCreate();
        applicationContext = this;
        instance = this;
        
        //init demo helper
        DemoHelper.getInstance().init(applicationContext);
	}

	public static DemoApplication getInstance() {
		return instance;
	}

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);
	}
    
}

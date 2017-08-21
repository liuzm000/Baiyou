package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.SettingController.ControllerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * 设置界面
 * */
public class SettingActivity extends BaseActivity implements BaseView, ControllerView {
	
	{
		mBaseView = this;
	}
	
	
	private View root_modifyPassword;
	private View root_about;
	private View root_netCheck;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}
	
	private void initView() {
		mHelper.initTitleBar(true, R.string.title_activity_setting, false);
		
	}
	

	@Override
	public int layout() {
		return R.layout.activity_setting;
	}

	@Override
	public void findById() {
		root_modifyPassword = findViewById(R.id.fl_setting_modifyPassword);
		root_about = findViewById(R.id.fl_setting_about);
		root_netCheck = findViewById(R.id.fl_setting_checkNet);

	}

	@Override
	public void setListener() {
		root_modifyPassword.setOnClickListener(this);
		root_about.setOnClickListener(this);
		root_netCheck.setOnClickListener(this);

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAdapter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onclick(View v) {
		switch (v.getId()) {
		case R.id.fl_setting_modifyPassword:
			Intent i1 = new Intent(this,PasswordResetActivity.class);
			startActivity(i1);	
			break;
		case R.id.fl_setting_about:
			Intent i2 = new Intent(this,AboutActivity.class);
			startActivity(i2);
			break;
		case R.id.fl_setting_checkNet:
			Intent i3 = new Intent(this,NetCheckActivity.class);
			startActivity(i3);
			break;

		default:
			break;
		}

	}

}

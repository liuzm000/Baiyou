package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.PasswordResetController.ControllerView;

import android.os.Bundle;
import android.view.View;
/**
 * 重置密码界面
 * */
public class PasswordResetActivity extends BaseActivity implements BaseView, ControllerView {
	{
		mBaseView = this;
	}
	
	
	private void initView() {
		mHelper.initTitleBar(true, R.string.title_activity_reset_password, false);
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}

	@Override
	public int layout() {
		return R.layout.activity_reset_password;
	}

	@Override
	public void findById() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}

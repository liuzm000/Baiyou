package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.PhoneChangeController.ControllerView;

import android.os.Bundle;
import android.view.View;
/**
 * 修改手机号界面
 * */
public class PhoneChangeActivity extends BaseActivity implements BaseView, ControllerView {
	
	{
		mBaseView = this;
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}
	
	private void initView() {
		mHelper.initTitleBar(true, R.string.title_activity_change_phone, false);
		
	}
	

	@Override
	public int layout() {
		return R.layout.activity_change_phone;
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

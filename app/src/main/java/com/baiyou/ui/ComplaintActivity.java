package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;

import android.os.Bundle;
import android.view.View;


/**
 * 用户投诉界面
 * */
public class ComplaintActivity extends BaseActivity implements BaseView {
	
	{
		mBaseView = this;
	}
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}

	private void initView() {
		mHelper.initTitleBar(true, R.string.title_activity_complaint, false);		
	}

	@Override
	public int layout() {
		return R.layout.activity_complaint;
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

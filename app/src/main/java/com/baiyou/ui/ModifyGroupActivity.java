package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;

import android.os.Bundle;
import android.view.View;

/**
 * 修改我在群的昵称界面
 * */
public class ModifyGroupActivity extends BaseActivity implements BaseView {
	
	{
		mBaseView = this;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}

	private void initView() {
		mHelper.initTitleBar(true, R.string.title_activity_modify_group, true);
		
	}

	@Override
	public int layout() {
		return R.layout.activity_modify_group;
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

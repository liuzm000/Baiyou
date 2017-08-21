package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;

import android.view.View;


/**
 * 群资料界面
 * */
public class GroupInfomationActivity extends BaseActivity implements BaseView {
	
	{
		mBaseView = this;
	}

	@Override
	public int layout() {
		return R.layout.activity_group_infomation;
	}

	@Override
	public void findById() {
		initTitle();
		
	}
	
	@Override
	protected void initTitle() {
		super.initTitle();
		left.setText(" ");
		left.setOnClickListener(this);
		center.setText(getResources().getString(R.string.title_activity_group_infomation));
		right.setVisibility(View.GONE);
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
		switch (v.getId()) {
		case R.id.left:
			finish();
			break;

		default:
			break;
		}
		
	}

}

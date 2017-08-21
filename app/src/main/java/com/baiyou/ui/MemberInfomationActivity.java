package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;

import android.content.Intent;
import android.view.View;

/**
 * 成员资料界面
 * */
public class MemberInfomationActivity extends BaseActivity implements BaseView {
	{
		mBaseView = this;
	}

	private View root_complaint;

	@Override
	public int layout() {
		return R.layout.activity_member_infomation;
	}

	@Override
	public void findById() {
		initTitle();
		root_complaint = findViewById(R.id.root_member_infomation_complaint);

	}

	@Override
	protected void initTitle() {
		super.initTitle();
		left.setOnClickListener(this);
		center.setText(getResources().getString(R.string.title_activity_member_infomation));
		right.setVisibility(View.GONE);
	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub
		root_complaint.setOnClickListener(this);
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
		case R.id.root_member_infomation_complaint:
			Intent intent = new Intent(this,ComplaintActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}

	}

}

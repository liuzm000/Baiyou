package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.SeeMemberController;
import com.baiyou.controller.SeeMemberController.SeeMemberView;

import android.view.View;
/**
 * 查看成员界面
 * */
public class SeeMemberActivity extends BaseActivity implements BaseView,SeeMemberView {
	{
		mBaseView = this;
	}
	
	private SeeMemberController mController;

	@Override
	public int layout() {
		return R.layout.activity_see_member;
	}

	@Override
	public void findById() {
		initTitle();
	}
	
	@Override
	protected void initTitle() {
		super.initTitle();
		left.setBackgroundResource(R.drawable.back_nor);
		center.setText(getResources().getString(R.string.title_activity_see_member));
		right.setVisibility(View.GONE);
	}

	@Override
	public void setListener() {
		left.setOnClickListener(this);

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		mController = new SeeMemberController(this, mHelper);

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

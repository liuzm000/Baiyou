package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.TeamInfomationController;
import com.baiyou.controller.TeamInfomationController.TeamInfomationView;

import android.view.View;
/**
 * 队伍信息界面
 * */
public class TeamInfomationActivity extends BaseActivity implements BaseView,TeamInfomationView {
	{
		mBaseView = this;
	}
	
	private TeamInfomationController mController;
	

	@Override
	public int layout() {
		return R.layout.activity_team_infomation;
	}

	@Override
	public void findById() {
		initTitle();

	}
	
	@Override
	protected void initTitle() {
		super.initTitle();
		left.setOnClickListener(this);
		center.setText(getResources().getString(R.string.title_activity_team_infomation));
		right.setVisibility(View.GONE);
	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initData() {
		mController = new TeamInfomationController(this, mHelper);
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

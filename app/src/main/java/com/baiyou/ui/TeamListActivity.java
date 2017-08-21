package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.TeamListController;
import com.baiyou.controller.TeamListController.TeamListView;

import android.view.View;
/**
 * 队伍列表界面
 * */
public class TeamListActivity extends BaseActivity implements BaseView ,TeamListView{
	{
		mBaseView = this;
	}
	
	private TeamListController mController;

	@Override
	public int layout() {
		return R.layout.activity_team_list;
	}

	@Override
	public void findById() {
		initTitle();
	}
	
	@Override
	protected void initTitle() {
		super.initTitle();
		left.setBackgroundResource(R.drawable.back_nor);
		center.setText(getResources().getString(R.string.title_activity_team_list));
		right.setVisibility(View.GONE);
	}

	@Override
	public void setListener() {
		left.setOnClickListener(this);

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		mController = new TeamListController(this, mHelper);

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

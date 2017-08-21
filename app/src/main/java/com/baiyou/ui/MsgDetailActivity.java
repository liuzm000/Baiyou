package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;

import android.content.Intent;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.TextView;
/**
 * 消息详情界面
 * */
public class MsgDetailActivity extends BaseActivity implements BaseView {
	{
		mBaseView = this;
	}

	private TextView tv_createTeam;
	private TextView tv_teamInfomation;
	private TextView tv_instantGroup;
	private TextView tv_rule;

	@Override
	public int layout() {
		return R.layout.activity_msg_detail;
	}

	@Override
	public void findById() {
		initTitle();
		tv_createTeam = (TextView) findViewById(R.id.tv_msg_detail_createTeam);
		tv_teamInfomation = (TextView) findViewById(R.id.tv_msg_detail_teamInformation);
		tv_instantGroup = (TextView) findViewById(R.id.tv_msg_detail_instantGroup);
		tv_rule = (TextView) findViewById(R.id.tv_msg_detail_rule);
	}
	
	@Override
	protected void initTitle() {
		super.initTitle();
		right.setBackgroundResource(R.drawable.group);
		String title = getIntent().getExtras().getString("title");
		center.setEllipsize(TruncateAt.END);
		center.setText(title);
		right.setText("");
	}

	@Override
	public void setListener() {
		left.setOnClickListener(this);
		tv_createTeam.setOnClickListener(this);
		tv_teamInfomation.setOnClickListener(this);
		tv_instantGroup.setOnClickListener(this);
		tv_rule.setOnClickListener(this);

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
		case R.id.tv_msg_detail_createTeam:
			Intent i1 = new Intent(this, CreateTeamActivity.class);
			startActivity(i1);
			break;
		case R.id.tv_msg_detail_teamInformation:
			Intent i2 = new Intent(this, TeamInfomationActivity.class);
			startActivity(i2);
			break;
		case R.id.tv_msg_detail_instantGroup:
			//TODO
			break;
		case R.id.tv_msg_detail_rule:
			//TODO
			break;

		default:
			break;
		}

	}

}

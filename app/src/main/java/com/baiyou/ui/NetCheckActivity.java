package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.NetCheckController;
import com.baiyou.controller.NetCheckController.NetCheckView;

import android.view.View;
/**
 * 网络诊断界面
 * */
public class NetCheckActivity extends BaseActivity implements BaseView,NetCheckView{
	
	{
		mBaseView = this;
	}
	
	
	private NetCheckController mController;

	@Override
	public int layout() {
		return R.layout.activity_net_check;
	}

	@Override
	public void findById() {
		initTitle();

	}
	
	@Override
	protected void initTitle() {
		super.initTitle();
		left.setText("返回");
		center.setText(getResources().getString(R.string.net_check));
		right.setVisibility(View.GONE);
	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initData() {
		mController = new NetCheckController(this, mHelper);

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

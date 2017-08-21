package com.baiyou.ui;

import org.library.base.BaseView;

import android.os.Handler;
import android.view.View;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.LoginActivityController;

public class LoadinActivity extends BaseActivity implements BaseView,
		LoginActivityController.ControllerView {

	{
		mBaseView = this;
	}

	@Override
	public int layout() {
		return R.layout.activity_loadin;
	}

	@Override
	public void findById() {
		new Handler().postDelayed(new Runnable() {

			public void run() {
				mHelper.startActivity(LoginActivity.class);
				finish();
			}
		}, 2 * 1000);
	}

	@Override
	public void setListener() {

	}

	@Override
	public void initData() {

	}

	@Override
	public void initAdapter() {

	}

	@Override
	public void onclick(View v) {

	}

	@Override
	public void successLogin() {
		// TODO Auto-generated method stub
		
	}
}

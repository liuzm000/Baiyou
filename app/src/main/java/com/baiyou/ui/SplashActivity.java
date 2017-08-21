package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.SplashController.ControllerView;
import com.baiyou.utils.picassotransform.RoundedTransformation;
import com.squareup.picasso.Picasso;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * 导航启动页
 */
public class SplashActivity extends BaseActivity implements BaseView, ControllerView {

	{
		mBaseView = this;
	}

	private ImageView iv_picture;
	private TextView tv_slogan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}

	@Override
	public int layout() {
		return R.layout.activity_splash;
	}

	@Override
	public void findById() {
		iv_picture = (ImageView) findViewById(R.id.iv_splash_picture);
		tv_slogan = (TextView) findViewById(R.id.tv_splash_slogan);
	}

	private void initView() {
		Picasso.with(this).load(R.drawable.dog).transform(new RoundedTransformation()).into(iv_picture);
	}

	@Override
	protected void onResume() {
		super.onResume();
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
			}
		}, 2000);
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

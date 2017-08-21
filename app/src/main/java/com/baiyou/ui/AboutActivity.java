package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.baiyou.utils.picassotransform.RoundedTransformation;
import com.squareup.picasso.Picasso;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * 关于我们界面
 * */
public class AboutActivity extends BaseActivity implements BaseView {
	
	{
		mBaseView = this;
	}
	
	private ImageView iv_img;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mHelper.initTitleBar(true, R.string.title_activity_about, false);
		initView();
	}

	private void initView() {
		Picasso.with(this).load(R.drawable.dog).transform(new RoundedTransformation()).into(iv_img);	
	}

	@Override
	public int layout() {
		return R.layout.activity_about;
	}

	@Override
	public void findById() {
		iv_img = (ImageView) findViewById(R.id.iv_about_img);
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

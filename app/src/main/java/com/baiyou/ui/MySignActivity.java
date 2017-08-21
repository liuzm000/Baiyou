package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
/**
 * 修改个性签名界面
 * */
public class MySignActivity extends BaseActivity implements BaseView {

	{
		mBaseView = this;
	}
	
	private EditText et_sign;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}
	
	private void initView() {
		mHelper.initTitleBar(true, R.string.title_activity_mysign, true,new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String sign = et_sign.getText().toString();
				Intent data = new Intent();
				data.putExtra("sign", sign);
				setResult(RESULT_OK, data);
				finish();	
			}
		});
		
	}

	@Override
	public int layout() {
		return R.layout.activity_mysign;
	}

	@Override
	public void findById() {
		et_sign = (EditText) findViewById(R.id.et_mysign_sign);

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

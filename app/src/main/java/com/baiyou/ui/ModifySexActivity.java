package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
/**
 * 修改用户性别界面
 * */
public class ModifySexActivity extends BaseActivity implements BaseView {
	
	{
		mBaseView = this;
	}
	
	private RadioGroup rg_sex;
	private String rg_select = "男";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}

	private void initView() {
		mHelper.initTitleBar(true, R.string.title_activity_modify_sex, true,new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("sex", rg_select);
				setResult(RESULT_OK, data);
				finish();		
			}
		});
		
	}

	@Override
	public int layout() {
		return R.layout.activity_modify_sex;
	}

	@Override
	public void findById() {
		rg_sex = (RadioGroup) findViewById(R.id.rg_modify_sex);

	}

	@Override
	public void setListener() {
		rg_sex.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(checkedId == R.id.rgbtn_modify_sex_man){
					rg_select = "男";
				}else{
					rg_select = "女";
				}
				
			}
		});

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

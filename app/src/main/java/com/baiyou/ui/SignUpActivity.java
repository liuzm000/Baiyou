package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.SignUpController.ControllerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * 注册第一步界面
 * */
public class SignUpActivity extends BaseActivity implements BaseView,ControllerView{
	
	{
		mBaseView = this;
	}
	
	private ImageView iv_img;
	private EditText et_phone;
	private EditText et_code;
	private Button btn_next;
	private ImageView iv_sina,iv_alipay,iv_wechat;
	private TextView tv_getCode;
	private ImageView iv_delete;

	@Override
	public int layout() {
		return R.layout.activity_signup;
	}

	@Override
	public void findById() {
		iv_img = (ImageView) f(R.id.iv_signUp_img);
		et_phone = (EditText) f(R.id.et_signUp_phone);
		et_code = (EditText) f(R.id.et_signUp_code);
		btn_next = (Button) f(R.id.btn_signUp_next);
		iv_sina = (ImageView) f(R.id.iv_signUp_sina);
		iv_alipay = (ImageView) f(R.id.iv_signUp_alipay);
		iv_wechat = (ImageView) f(R.id.iv_signUp_wechat);
		tv_getCode = (TextView) f(R.id.tv_signUp_getCode);
		iv_delete = (ImageView) f(R.id.iv_signUp_delete);
		
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}
	
	private void initView() {
		
	}

	private View f(int id){
		return findViewById(id);
	}

	@Override
	public void setListener() {
		iv_delete.setOnClickListener(this);
		btn_next.setOnClickListener(this);
		
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
		case R.id.iv_signUp_delete:
			et_phone.setText("");
			break;
		case R.id.btn_signUp_next:
			next();
			break;

		default:
			break;
		}
		
	}

	@Override
	public void next() {
		if(!TextUtils.isEmpty(et_phone.getText().toString())){
			Intent intent = new Intent(this,SignUp2Activity.class);
			intent.putExtra("telphone",et_phone.getText().toString());
			startActivity(intent);
			finish();
		}else{
			mHelper.toast(getResources().getString(R.string.signUp_no_phone_tip));
		}
	}

}

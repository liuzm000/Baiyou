package com.baiyou.ui;

import org.library.base.BaseView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.LoginActivityController;
import com.baiyou.utils.picassotransform.CircleTransformation;
import com.baiyou.utils.picassotransform.RoundedTransformation;
import com.squareup.picasso.Picasso;

/**
 * 登录界面
 * */
public class LoginActivity extends BaseActivity implements BaseView, LoginActivityController.ControllerView {

	{
		mBaseView = this;
	}
	LoginActivityController mLoginActivityController = new LoginActivityController(this, mHelper);

	private ImageView iv_img;
	private EditText et_acount;
	private EditText et_password;
	private Button btn_login;
	private TextView tv_quickSignUp;
	private TextView tv_forgetPassword;

	@Override
	public int layout() {
		return R.layout.activity_login;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}

	private void initView() {
		Picasso.with(this).load(R.drawable.dog).transform(new CircleTransformation()).into(iv_img);

	}

	@Override
	public void findById() {
		iv_img = (ImageView) findViewById(R.id.iv_login_img);
		et_acount = (EditText) findViewById(R.id.et_login_phone);
		et_password = (EditText) findViewById(R.id.et_login_password);
		btn_login = (Button) findViewById(R.id.btn_login_next);
		tv_quickSignUp = (TextView) findViewById(R.id.tv_login_quickSignUp);
		tv_forgetPassword = (TextView) findViewById(R.id.tv_login_forget_password);
	}

	@Override
	public void setListener() {
		btn_login.setOnClickListener(this);
		tv_quickSignUp.setOnClickListener(this);
		tv_forgetPassword.setOnClickListener(this);
	}

	@Override
	public void initData() {

	}

	@Override
	public void initAdapter() {

	}

	@Override
	public void onclick(View v) {
		switch (v.getId()) {
		case R.id.btn_login_next:
//			mLoginActivityController.login(et_acount.getText().toString() + "", et_password.getText().toString());

			mLoginActivityController.loginChatSer(et_acount.getText().toString(),et_password.getText().toString());

			break;
		case R.id.tv_login_quickSignUp:
			Intent i2 = new Intent(this, SignUpActivity.class);
			startActivity(i2);

			break;
		case R.id.tv_login_forget_password:
			Intent i3 = new Intent(this, PasswordResetActivity.class);
			startActivity(i3);
			break;

		default:
			break;
		}
	}

	@Override
	public void successLogin() {
		Intent i1 = new Intent(this, MainActivity.class);
		startActivity(i1);
		finish();

	}

}

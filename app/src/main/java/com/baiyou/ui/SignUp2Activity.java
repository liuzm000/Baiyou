package com.baiyou.ui;

import org.library.base.BaseView;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.SignUp2Controller;
import com.baiyou.controller.SignUp2Controller.ControllerView;
import com.baiyou.utils.picassotransform.RoundedTransformation;
import com.squareup.picasso.Picasso;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
/**
 * 注册第二步界面
 * */
public class SignUp2Activity extends BaseActivity implements BaseView, ControllerView {
	{
		mBaseView = this;
	}

	private SignUp2Controller mController;

	private ImageView iv_img;
	private EditText et_nickName;
	private EditText et_password1;
	private EditText et_password2;
	private Button btn_complete;
	private CheckBox cb_agree;
	private ImageView iv_delete1, iv_delete2, iv_delete3;

	@Override
	public int layout() {
		return R.layout.activity_signup2;
	}

	@Override
	public void findById() {
		iv_img = (ImageView) findViewById(R.id.iv_signUp2_img);
		et_nickName = (EditText) findViewById(R.id.et_signUp2_nickName);
		et_password1 = (EditText) findViewById(R.id.et_signUp2_setPassword);
		et_password2 = (EditText) findViewById(R.id.et_signUp2_checkPassowrd);
		btn_complete = (Button) findViewById(R.id.btn_signUp2_complete);
		cb_agree = (CheckBox) findViewById(R.id.cb_signUp2_agree);
		iv_delete1 = (ImageView) findViewById(R.id.iv_signUp2_delete1);
		iv_delete2 = (ImageView) findViewById(R.id.iv_signUp2_delete2);
		iv_delete3 = (ImageView) findViewById(R.id.iv_signUp2_delete3);
	}

	private void initView() {
		Picasso.with(this).load(R.drawable.dog).transform(new RoundedTransformation()).into(iv_img);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
	}

	@Override
	public void setListener() {
		iv_delete1.setOnClickListener(this);
		iv_delete2.setOnClickListener(this);
		iv_delete3.setOnClickListener(this);
		btn_complete.setOnClickListener(this);

	}

	@Override
	public void initData() {
		mController = new SignUp2Controller(this, mHelper);

	}

	@Override
	public void initAdapter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onclick(View v) {
		switch (v.getId()) {
		case R.id.iv_signUp2_delete1:
			et_nickName.setText("");
			break;
		case R.id.iv_signUp2_delete2:
			et_password1.setText("");
			break;
		case R.id.iv_signUp2_delete3:
			et_password2.setText("");
			break;
		case R.id.btn_signUp2_complete:
			boolean b = checkForm();
			if(b){				
				String name = et_nickName.getText().toString();
				String password = et_password1.getText().toString();
				String password2 = et_password2.getText().toString();
				mController.register(getIntent().getStringExtra("telphone"), name, password, password2);
			}else{
				mHelper.toast(getResources().getString(R.string.signUp_infomation_tip));
			}
			break;

		default:
			break;
		}

	}

	private boolean checkForm() {
		if (TextUtils.isEmpty(et_nickName.getText().toString()) || TextUtils.isEmpty(et_nickName.getText().toString())
				|| TextUtils.isEmpty(et_nickName.getText().toString())) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void successRegister() {
		finish();
	}

}

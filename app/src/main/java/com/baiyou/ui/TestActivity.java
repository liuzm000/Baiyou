package com.baiyou.ui;

import com.baiyou.R;
import com.baiyou.base.BaseActivity;
import com.netease.nim.uikit.team.activity.TeamPropertySettingActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestActivity extends Activity implements OnClickListener {
	
	private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		findView();
		setListener();
	}

	private void setListener() {
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btn10.setOnClickListener(this);
	}

	private void findView() {
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn5 = (Button) findViewById(R.id.btn5);
		btn6 = (Button) findViewById(R.id.btn6);
		btn7 = (Button) findViewById(R.id.btn7);
		btn8 = (Button) findViewById(R.id.btn8);
		btn9 = (Button) findViewById(R.id.btn9);
		btn10 = (Button) findViewById(R.id.btn10);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			Intent intent = new Intent(this,TeamPropertySettingActivity.class);
			startActivity(intent);
			
			break;
		case R.id.btn2:
			Intent intent1 = new Intent(this,SignUpActivity.class);
			startActivity(intent1);
			
			break;
		case R.id.btn3:
			Intent intent2 = new Intent(this,SignUp2Activity.class);
			startActivity(intent2);
			
			break;
		case R.id.btn4:
			Intent intent3 = new Intent(this,PasswordResetActivity.class);
			startActivity(intent3);
			
			break;
		case R.id.btn5:
			Intent intent4 = new Intent(this,PhoneChangeActivity.class);
			startActivity(intent4);
			
			break;
		case R.id.btn6:
			Intent intent5 = new Intent(this,SettingActivity.class);
			startActivity(intent5);
			
			break;
		case R.id.btn7:
			Intent intent6 = new Intent(this,CreateTeamActivity.class);
			startActivity(intent6);
			
			break;
		case R.id.btn8:
			Intent intent7 = new Intent(this,SearchActivity.class);
			startActivity(intent7);
			
			break;
		case R.id.btn9:
			Intent intent8 = new Intent(this,AboutActivity.class);
			startActivity(intent8);
			
			break;
		case R.id.btn10:
			Intent intent9 = new Intent(this,ComplaintActivity.class);
			startActivity(intent9);
			
			break;
		default:
			break;
		}
		
	}

}

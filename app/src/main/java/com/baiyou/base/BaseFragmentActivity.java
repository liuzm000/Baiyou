package com.baiyou.base;

import android.view.View;
import android.widget.TextView;

import com.baiyou.R;
import com.baiyou.utils.Helper;


public class BaseFragmentActivity extends org.library.base.BaseFragmentActivity {
	
	
	protected int pageSize = 10, pageNumber = 1;
	protected Helper mHelper = new Helper(this,this);
	
	protected View title;
	protected TextView left;
	protected TextView center;
	protected TextView right;
	
	
	protected void initTitle() {
		title = findViewById(R.id.title);
		left = (TextView) findViewById(R.id.left);
		center = (TextView) findViewById(R.id.center);
		right = (TextView) findViewById(R.id.right);
	}
}

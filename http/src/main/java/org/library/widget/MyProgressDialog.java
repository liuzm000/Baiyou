package org.library.widget;


import org.library.http.R;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

public class MyProgressDialog extends Dialog {

	TextView title ;
	
	public MyProgressDialog(Context context) {
		super(context, R.style.org_MyDialog);
		setContentView(R.layout.org_layout_loading);
		getWindow().setBackgroundDrawableResource(android.R.color.transparent);
	}

	public MyProgressDialog(Context context, String title0) {
		super(context, R.style.org_MyDialog);
		setContentView(R.layout.org_layout_loading2);
		// this.title = title;
		title = (TextView) findViewById(R.id.progressTxt);
		getWindow().setBackgroundDrawableResource(android.R.color.transparent);
	}
	
	public void setProgress(String txt) {
		if (title != null) {
			title.setText(txt);
		}
	}
	
	@Override
	public void setTitle(CharSequence title) {
		super.setTitle(title);
	}
}

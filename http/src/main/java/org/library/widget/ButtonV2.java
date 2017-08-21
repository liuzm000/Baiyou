package org.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class ButtonV2 extends Button {

	public ButtonV2(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs, defStyle);
	}

	public ButtonV2(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs, 0);
	}

	public ButtonV2(Context context) {
		super(context);
		init(context, null, 0);
	}

	String formatString;

	void init(Context context, AttributeSet attrs, int defStyle) {
		formatString = this.getText().toString();
		Object[] args = { "\u3000", "\u3000", "\u3000", "\u3000", "\u3000",
				"\u3000", };
		String txt = String.format(formatString, args);
		this.setText(txt);
	}

	public void setFormatText(Object... args) {
		String txt = String.format(formatString, args);
		this.setText(txt);
	}

	public void setFormatTextColor(int colorId, Object... args) {
		String txt = String.format(formatString, args);
		this.setText(txt);
		this.setTextColor(getContext().getResources().getColor(colorId));
	}

	public void setFormatText(String string, Object... args) {
		String txt = String.format(string, args);
		this.setText(txt);
	}

	public void setFormatTextColor(int colorId, String string, Object... args) {
		String txt = String.format(string, args);
		this.setText(txt);
		this.setTextColor(getContext().getResources().getColor(colorId));
	}
}

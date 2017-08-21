package org.library.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewV2 extends TextView {

	public TextViewV2(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs, defStyle);
	}

	public TextViewV2(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs, 0);
	}

	public TextViewV2(Context context) {
		super(context);
		init(context, null, 0);
	}

	String formatString, formatString2;

	void init(Context context, AttributeSet attrs, int defStyle) {
//		String content = this.getText().toString();
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

	void SpannableStringTxt() {
		SpannableString spannableString = new SpannableString("默认颜色红颜色");
		spannableString.setSpan(
				new ForegroundColorSpan(Color.parseColor("#FF0000")), 4,
				spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		// Spanned.SPAN_INCLUSIVE_EXCLUSIVE 从起始下标到终了下标，包括起始下标
		// Spanned.SPAN_INCLUSIVE_INCLUSIVE 从起始下标到终了下标，同时包括起始下标和终了下标
		// Spanned.SPAN_EXCLUSIVE_EXCLUSIVE 从起始下标到终了下标，但都不包括起始下标和终了下标
		// Spanned.SPAN_EXCLUSIVE_INCLUSIVE 从起始下标到终了下标，包括终了下标

		// spannableString.setSpan(what, start, end, flags);

		// setFormatText(1,1,1);

		this.setText(spannableString);
	}
}

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
		SpannableString spannableString = new SpannableString("Ĭ����ɫ����ɫ");
		spannableString.setSpan(
				new ForegroundColorSpan(Color.parseColor("#FF0000")), 4,
				spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		// Spanned.SPAN_INCLUSIVE_EXCLUSIVE ����ʼ�±굽�����±꣬������ʼ�±�
		// Spanned.SPAN_INCLUSIVE_INCLUSIVE ����ʼ�±굽�����±꣬ͬʱ������ʼ�±�������±�
		// Spanned.SPAN_EXCLUSIVE_EXCLUSIVE ����ʼ�±굽�����±꣬������������ʼ�±�������±�
		// Spanned.SPAN_EXCLUSIVE_INCLUSIVE ����ʼ�±굽�����±꣬���������±�

		// spannableString.setSpan(what, start, end, flags);

		// setFormatText(1,1,1);

		this.setText(spannableString);
	}
}

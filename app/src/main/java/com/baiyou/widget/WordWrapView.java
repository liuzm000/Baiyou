package com.baiyou.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class WordWrapView extends RadioGroup /* ViewGroup */ {

	private static final int PADDING_HOR = 24;
	private static final int PADDING_VERTICAL = 5;
	private static final int SIDE_MARGIN = 20;
	private static final int TEXT_MARGIN = 20;

	/**
	 * @param context
	 */
	public WordWrapView(Context context) {
		super(context);
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	// public WordWrapView(Context context, AttributeSet attrs, int defStyle) {
	// super(context, attrs, defStyle);
	// }

	/**
	 * @param context
	 * @param attrs
	 */
	public WordWrapView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		int childCount = getChildCount();
		int autualWidth = r - l;
		int x = SIDE_MARGIN;// �����꿪ʼ
		int y = 0;// �����꿪ʼ
		int rows = 1;
		for (int i = 0; i < childCount; i++) {
			View view = getChildAt(i);
			// view.setBackgroundColor(Color.GREEN);
			int width = view.getMeasuredWidth();
			int height = view.getMeasuredHeight();
			x += width + TEXT_MARGIN;
			if (x > autualWidth) {
				x = width + SIDE_MARGIN;
				rows++;
			}
			y = rows * (height + TEXT_MARGIN);
			if (i == 0) {
				view.layout(x - width - TEXT_MARGIN, y - height, x, y);
			} else {
				view.layout(x - width, y - height, x, y);
			}
		}
	};

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int x = 0;// ������
		int y = 0;// ������
		int rows = 1;// ������
		int specWidth = MeasureSpec.getSize(widthMeasureSpec);
		int actualWidth = specWidth;// ʵ�ʿ��
		int childCount = getChildCount();
		for (int index = 0; index < childCount; index++) {
			View child = getChildAt(index);
			child.setPadding(PADDING_HOR, PADDING_VERTICAL, PADDING_HOR, PADDING_VERTICAL);
			child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
			int width = child.getMeasuredWidth();
			int height = child.getMeasuredHeight();
			x += width + TEXT_MARGIN;
			if (x > actualWidth) {// ����
				x = width;
				rows++;
			}
			y = rows * (height + TEXT_MARGIN);
		}
		setMeasuredDimension(actualWidth, y);
	}

}
package org.library.widget;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;
import android.widget.ImageView;


public class MyGallery extends Gallery {

	private Context context;
	private AttributeSet attrs;
	private int defStyle;
	private String tag = "MyGallery";

	private Camera mCamera;

	Map<String, Float> map;

	private int pCenter = -1;

	private float radius = -200f;

	protected boolean getChildStaticTransformation(View child, Transformation t) {
		t.clear();
		t.setTransformationType(Transformation.TYPE_MATRIX);
		if (Build.VERSION.SDK_INT >= 16) {
			// 4.1 以后 getChildStaticTransformation 渐变失效
			child.invalidate();
		}
		transformView(child, t);
		return true;
	}

	private int getCenter(View view) {
		int[] location = new int[2];
		if (view == null) {
			// 获取在当前窗口内的绝对坐标，和getLeft是一样的
			getLocationInWindow(location);
			// 获取在整个屏幕内的绝对坐标,包括了通知栏的高度。
			// getLocationOnScreen(location);
			return location[0] + getMeasuredWidth() / 2;
		}
		view.getLocationInWindow(location);
		return location[0] + view.getMeasuredWidth() / 2;
	}

	/**
	 * 
	 * 就这成了
	 * 
	 * 逐渐变化
	 * 
	 * @param view
	 * @param t
	 */
	private void transformView(View view, Transformation t) {

		final int cCenter = getCenter(view);

		float offset = (cCenter - pCenter) / (pCenter * 1.0f);

		final int halfWidth = (view.getMeasuredWidth() >> 1);
		final int halfHeight = view.getMeasuredHeight() >> 1;

		final Matrix mMatrix = t.getMatrix();

		mCamera.save();

		// ImageView im = (ImageView) view ;

		// 层叠效果必须放大
		float x = radius * offset, y = 0.0f, z = Math.abs(radius * offset);
		mCamera.translate(x, y, z);
		mCamera.getMatrix(mMatrix);
		mCamera.restore();
		mMatrix.preTranslate(-halfWidth, -halfHeight);
		mMatrix.postTranslate(halfWidth, halfHeight);
	}

	/*
	 * 右边层次次序 ，5、4、3、2、1,；左边层次次序 ，1、2、3、4、5； 产生层次感的时候可以用
	 */
	protected int getChildDrawingOrder(int childCount, int i) {

		// Current selected index.
		final int selectedIndex = getSelectedItemPosition()
				- getFirstVisiblePosition();

		if (selectedIndex < 0) {

			return i;

		}

		if (i < selectedIndex) { // 4,5 = 4

			return i;

		} else if (i >= selectedIndex) { // 5,4 =

			return childCount - 1 - i + selectedIndex;

		} else {

			return i;

		}
	}

	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		if (pCenter == -1) {
			pCenter = getCenter(null);
		}
		super.onSizeChanged(w, h, oldw, oldh);
	}

	private void init(Context context, AttributeSet attrs, int defStyle) {
		this.context = context;
		this.attrs = attrs;
		this.defStyle = defStyle;

		mCamera = new Camera();

		// Enable set transformation.
		this.setStaticTransformationsEnabled(true);
		// Enable set the children drawing order.
		this.setChildrenDrawingOrderEnabled(true);

		map = new HashMap<String, Float>();

		// map.put("0", 1.0f);
		// map.put("1", 0.9f);
		// map.put("2", 0.8f);
		// map.put("3", 0.7f);
		// map.put("4", 0.6f);
		// map.put("5", 0.5f);
		// map.put("6", 0.4f);
		// map.put("7", 0.3f);
		// map.put("8", 0.2f);
		// map.put("9", 0.1f);
		// map.put("10", 0.0f);

		for (int i = 0; i <= 10; i++) {
			float a = 1.0f - i * 0.1f;
			// float i = 1.0f - 1 * 0.1f ; == 0.9f
			map.put(i + "", a);
		}

	}

	public MyGallery(Context context) {
		super(context);
		init(context, null, 0);
	}

	public MyGallery(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs, 0);
	}

	public MyGallery(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs, defStyle);
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

}

package org.library.base;

import android.view.View;

public interface BaseView {

	int[] colors = { android.R.color.holo_blue_bright, android.R.color.holo_green_light,
			android.R.color.holo_orange_light, android.R.color.holo_red_light };

	int layout();

	void findById();

	void setListener();

	void initData();

	void initAdapter();

	void onclick(View v);
}

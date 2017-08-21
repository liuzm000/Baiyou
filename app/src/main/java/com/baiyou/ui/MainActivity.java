package com.baiyou.ui;

import java.util.ArrayList;
import java.util.List;

import org.library.base.BaseView;
import org.library.base.adapter.BaseFragmentPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.baiyou.R;
import com.baiyou.base.BaseFragmentActivity;
import com.baiyou.controller.MainActivityController;
import com.baiyou.fragment.MainFragment;
import com.baiyou.fragment.MeFragment;
import com.baiyou.fragment.MsgFragment;
import com.baiyou.fragment.TogetherFragment;
import com.netease.nim.uikit.recent.RecentContactsFragment;

/**
 * 主界面
 * */
public class MainActivity extends BaseFragmentActivity implements BaseView,
		MainActivityController.ControllerView {

	{
		mBaseView = this;
	}

	MainFragment mMainFragment;
	MeFragment mMeFragment;
	MsgFragment mMsgFragment;
	TogetherFragment mTogetherFragment;

	private ViewPager mViewPager;
	private List<Fragment> fragments;

	MainActivityController mMainActivityController = new MainActivityController(
			this, mHelper);

	private TextView msg;
	private TextView together;
	private TextView main;
	private TextView me;
	TextView[] mTextViews = new TextView[4];

	@Override
	public int layout() {
		return R.layout.activity_main;
	}

	@Override
	public void findById() {
		mViewPager = (ViewPager) findViewById(R.id.pager);

		msg = (TextView) findViewById(R.id.msg);
		together = (TextView) findViewById(R.id.together);
		main = (TextView) findViewById(R.id.main);
		me = (TextView) findViewById(R.id.me);

		mTextViews[0] = msg;
		mTextViews[1] = together;
		mTextViews[2] = main;
		mTextViews[3] = me;

	}

	@Override
	public void setListener() {
		
		msg.setOnClickListener(this);
		together.setOnClickListener(this);
		main.setOnClickListener(this);
		me.setOnClickListener(this);

		mViewPager.setOnPageChangeListener(onPageChangeListener);
	}

	@Override
	public void initData() {

		fragments = new ArrayList<Fragment>();

		mMainFragment = new MainFragment();
		mMeFragment = new MeFragment();
		mMsgFragment = new MsgFragment();
		mTogetherFragment = new TogetherFragment();

		fragments.add(mMsgFragment);
		fragments.add(mTogetherFragment);
		fragments.add(mMainFragment);
		fragments.add(mMeFragment);

		FragmentManager m = getSupportFragmentManager();
		this.mViewPager.setAdapter(new BaseFragmentPagerAdapter(m, fragments));

		mViewPager.setCurrentItem(0);

	}

	@Override
	public void initAdapter() {

	}

	void setBarItemStyle() {
		int current = mViewPager.getCurrentItem();
		for (int i = 0; i < mTextViews.length; i++) {
			TextView mTextView = mTextViews[i];
			int color = (current == i) ? R.color.blue_light : R.color.text;
			mTextView.setTextColor(mHelper.getResColor(color));
			mTextView.setSelected( (current == i) ) ;
		}
	}

	@Override
	public void onclick(View view) {
		
		Log.i("onclick", "=============onclick");
		
		int id = view.getId();
		if (id == R.id.msg) { //
			mViewPager.setCurrentItem(0);
		}

		if (id == R.id.together) { //
			mViewPager.setCurrentItem(1);
		}

		if (id == R.id.main) { //
			mViewPager.setCurrentItem(2);
		}

		if (id == R.id.me) { //
			mViewPager.setCurrentItem(3);
		}
	}

	OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {

		public void onPageSelected(int pos) {
			setBarItemStyle();
		}

		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		public void onPageScrollStateChanged(int arg0) {

		}
	};

}

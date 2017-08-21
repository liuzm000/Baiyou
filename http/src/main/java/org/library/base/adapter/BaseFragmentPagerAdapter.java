package org.library.base.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
	private List<Fragment> fragments;

	public BaseFragmentPagerAdapter(FragmentManager m) {
		super(m);
	}

	public BaseFragmentPagerAdapter(FragmentManager m, List<Fragment> fragments) {
		super(m);
		this.fragments = fragments;
	}

	public Fragment getItem(int index) {
		return fragments.get(index);
	}

	public int getCount() {
		return fragments.size();
	}

	public long getItemId(int position) {
		return super.getItemId(position);
	}

	public int getItemPosition(Object object) {
		return super.getItemPosition(object);
	}

	public CharSequence getPageTitle(int position) {
		return super.getPageTitle(position);
	}

	public float getPageWidth(int position) {
		return super.getPageWidth(position);
	}

	public Object instantiateItem(ViewGroup container, int position) {
		return super.instantiateItem(container, position);
	}

	public boolean isViewFromObject(View view, Object object) {
		return super.isViewFromObject(view, object);
	}
}

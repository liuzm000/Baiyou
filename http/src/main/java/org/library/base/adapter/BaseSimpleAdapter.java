package org.library.base.adapter;

import java.util.List;
import java.util.Map;

import org.library.utils.MapV2;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.SimpleAdapter;

public class BaseSimpleAdapter extends SimpleAdapter {

	protected LayoutInflater mInflater;
	protected List<MapV2> data;
	protected Context mContext;

	public BaseSimpleAdapter(Context context, List<MapV2> data, int resource, String[] from, int[] to) {
		super(context, data, resource, from, to);
	}

	public int getCount() {
		return data.size();
	}

	public MapV2 getItem(int position) {
		return data.get(position);
	}

	public List<MapV2> getData() {
		return data;
	}

	public void remove(int position) {
		getData().remove(position);
		super.notifyDataSetChanged();
	}

	public void remove(final Map<String, Object> map) {
		getData().remove(map);
		super.notifyDataSetChanged();
	}

	public void appendData(final MapV2 map) {
		getData().add(map);
		super.notifyDataSetChanged();
	}

	public void appendDataList(final List<MapV2> map) {
		getData().addAll(map);
		super.notifyDataSetChanged();
	}

	public void notifyDataSetChanged(final List<MapV2> data) {
		getData().clear();
		getData().addAll(data);
		super.notifyDataSetChanged();
	}

	public void notifyDataSetChanged(final MapV2 map) {
		getData().clear();
		getData().add(map);
		super.notifyDataSetChanged();
	}

}

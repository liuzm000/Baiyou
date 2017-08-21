package com.baiyou.adapter;

import java.util.List;

import org.library.base.adapter.BaseSimpleAdapter;
import org.library.utils.MapV2;

import com.baiyou.R;
import com.baiyou.ui.OutDetailActivity;
import com.baiyou.utils.picassotransform.RoundedTransformation;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TogetherAdapter extends BaseSimpleAdapter {

	private class ViewHolder {
		TextView tv_time;
		TextView tv_destination;
		TextView tv_state;
		TextView tv_group;
		View root;
	}
	
	private ViewHolder holder = null;
	

	private static int resource = R.layout.item_together;

	private static String[] from = { "textView1", "textView2","textView3","textView4" };

	private static int[] to = { R.id.tv_item_together_time, R.id.tv_item_together_destination, R.id.tv_item_together_state,
			R.id.tv_item_together_group,R.id.root_item_together };

	public TogetherAdapter(Context context, List<MapV2> data) {
		super(context, data, resource, from, to);
		this.data = data;
		this.mContext = context;
		this.mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MapV2 map = getItem(position);
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(resource, null);
			findViewById(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		initValue(map);
		setListener(map);
		return convertView;
	}

	private void setListener(final MapV2 map) {
		
	}

	private void initValue(MapV2 map) {
		holder.tv_time.setText(map.get("time")+"");
		holder.tv_destination.setText(map.get("destination")+"");
		holder.tv_state.setText(map.get("state")+"");
		holder.tv_group.setText(map.get("group")+"");
	}

	private void findViewById(View convertView) {
		holder.tv_time = (TextView) convertView.findViewById(R.id.tv_item_together_time);
		holder.tv_destination = (TextView) convertView.findViewById(R.id.tv_item_together_destination);
		holder.tv_state = (TextView) convertView.findViewById(R.id.tv_item_together_state);
		holder.tv_group = (TextView) convertView.findViewById(R.id.tv_item_together_group);
		holder.root = convertView.findViewById(R.id.root_item_together);
	}
	

}
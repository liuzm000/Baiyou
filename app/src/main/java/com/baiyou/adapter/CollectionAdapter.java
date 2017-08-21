package com.baiyou.adapter;

import java.util.List;

import org.library.base.adapter.BaseSimpleAdapter;
import org.library.utils.MapV2;

import com.baiyou.R;
import com.baiyou.utils.picassotransform.RoundedTransformation;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CollectionAdapter extends BaseSimpleAdapter {

	private class ViewHolder {
		ImageView iv_img;
		TextView tv_description;
		TextView tv_time;
	}
	
	private ViewHolder holder = null;
	

	private static int resource = R.layout.item_collection;

	private static String[] from = { "imageView1","textView2","textView3" };

	private static int[] to = { R.id.iv_item_collection_img, R.id.tv_collection_description, R.id.tv_collection_time, };

	public CollectionAdapter(Context context, List<MapV2> data) {
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

	private void setListener(MapV2 map) {
		
	}

	private void initValue(MapV2 map) {
		Picasso.with(mContext).load(map.get("img")).into(holder.iv_img);
		holder.tv_description.setText(map.get("description")+"");
		holder.tv_time.setText(map.get("time")+"");
	}

	private void findViewById(View convertView) {
		holder.iv_img = (ImageView) convertView.findViewById(R.id.iv_item_collection_img);
		holder.tv_description = (TextView) convertView.findViewById(R.id.tv_collection_description);
		holder.tv_time = (TextView) convertView.findViewById(R.id.tv_collection_time);
	}
	
}

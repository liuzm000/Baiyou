package com.baiyou.adapter;

import java.util.List;

import org.library.base.adapter.BaseSimpleAdapter;
import org.library.utils.MapV2;

import com.baiyou.R;
import com.baiyou.ui.MsgDetailActivity;
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

public class MessageAdapter extends BaseSimpleAdapter {

	private class ViewHolder {
		TextView tv_title;
		ImageView iv_img;
		TextView tv_content;
		TextView tv_time;
		View root;
	}
	
	private ViewHolder holder = null;
	

	private static int resource = R.layout.item_message;

	private static String[] from = { "textView1", "textView2","textView3","textView4" };

	private static int[] to = { R.id.iv_item_message, R.id.tv_item_message_title, R.id.tv_item_message_content,
			R.id.tv_item_message_time ,R.id.root};

	public MessageAdapter(Context context, List<MapV2> data) {
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
		holder.root.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mContext,MsgDetailActivity.class);
				intent.putExtra("title", map.get("title")+"");
				mContext.startActivity(intent);
			}
		});
	}

	private void initValue(MapV2 map) {
		Picasso.with(mContext).load(R.drawable.dog).transform(new RoundedTransformation()).into(holder.iv_img);
		holder.tv_title.setText(map.get("title")+"");
		holder.tv_content.setText(map.get("content")+"");
		holder.tv_time.setText(map.get("time")+"");
	}

	private void findViewById(View convertView) {
		holder.iv_img = (ImageView) convertView.findViewById(R.id.iv_item_message);
		holder.tv_title = (TextView) convertView.findViewById(R.id.tv_item_message_title);
		holder.tv_content = (TextView) convertView.findViewById(R.id.tv_item_message_content);
		holder.tv_time = (TextView) convertView.findViewById(R.id.tv_item_message_time);
		holder.root = convertView.findViewById(R.id.root);
	}
	

}

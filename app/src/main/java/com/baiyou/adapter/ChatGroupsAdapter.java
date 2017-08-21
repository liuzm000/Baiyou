package com.baiyou.adapter;

import java.util.List;

import org.library.base.adapter.BaseSimpleAdapter;
import org.library.utils.MapV2;

import com.baiyou.R;
import com.baiyou.ui.GroupInfomationActivity;
import com.baiyou.utils.picassotransform.RoundedTransformation;
import com.netease.nim.uikit.team.activity.AdvancedTeamInfoActivity;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatGroupsAdapter extends BaseSimpleAdapter {
	private class ViewHolder {
		TextView tv_name;
		View root;
	}

	private ViewHolder holder = null;

	private static int resource = R.layout.item_chat_group;

	private static String[] from = { "textView1" };

	private static int[] to = { R.id.tv_item_chat_group_name, R.id.root_item_chat_group };

	public ChatGroupsAdapter(Context context, List<MapV2> data) {
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
		holder.root.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
//				Intent intent = new Intent(mContext,GroupInfomationActivity.class);
				//TODO 添加传递数据
//				mContext.startActivity(intent);

				AdvancedTeamInfoActivity.start(mContext,"95050389");

			}
		});
	}

	private void initValue(MapV2 map) {
		holder.tv_name.setText(map.get("name") + "");

	}

	private void findViewById(View convertView) {
		holder.tv_name = (TextView) convertView.findViewById(R.id.tv_item_chat_group_name);
		holder.root = convertView.findViewById(R.id.root_item_chat_group);
	}

}

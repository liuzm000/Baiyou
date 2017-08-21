package org.library.utils;

import java.util.ArrayList;
import java.util.List;

import org.library.base.adapter.BaseSimpleAdapter;
import org.library.http.R;
import org.library.widget.TextViewV2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TestBaseListViewAdpter extends BaseSimpleAdapter {

	private class ViewHolder {
		TextViewV2 textView1;

		/** CheckedTextView */
		CheckedTextView checkedTextView1;

		ProgressBar progressBar1;

		EditText editText1;

		ImageView imageView1;

	}

	private void findViewById(final View convertView) {
		holder.textView1 = (TextViewV2) convertView.findViewById(R.id.textView1);
		/** CheckedTextView */
		holder.checkedTextView1 = (CheckedTextView) convertView
				.findViewById(R.id.checkedTextView1);
		holder.progressBar1 = (ProgressBar) convertView
				.findViewById(R.id.progressBar1);
		holder.editText1 = (EditText) convertView.findViewById(R.id.editText1);
		holder.imageView1 = (ImageView) convertView
				.findViewById(R.id.imageView1);
	}

	void temp() {
		List<MapV2> dataList = new ArrayList<MapV2>();
		for (int i = 0; i < 3; i++) {
			MapV2 map = new MapV2();
			map.put("_textView1", "_textView1");
			map.put("_checkedTextView1", "_checkedTextView1");
			map.put("_progressBar1", "_progressBar1");
			map.put("_editText1", "_editText1");
			map.put("_imageView1", "_imageView1");
			dataList.add(map);
		}
	}

	private void initValue(final MapV2 map) {
		holder.textView1.setText( map.getString("_textView1") );
		
		holder.textView1.setFormatText( map.getString("_textView1") ) ;
		
		holder.textView1.setFormatText( R.color.red ,  map.getString("_textView1") ) ;
		
		holder.checkedTextView1.setText( map.getString("_checkedTextView1") );
		// holder.imageView1.setImageResource( map.getInt( "_imageView1" ) );
		Picasso.with(mContext).load( map.getString("_imageView1") ).into(holder.imageView1);
	}

	private void setListener(final MapV2 map) {
	}

	private static int resource = R.layout.test;
	private static String[] from = { "textView1", "checkedTextView1",
			"progressBar1", "editText1", "imageView1" };
	private static int[] to = { R.id.textView1, R.id.checkedTextView1,
			R.id.progressBar1, R.id.editText1, R.id.imageView1 };

	private ViewHolder holder = null;

	public TestBaseListViewAdpter(Context context, List<MapV2> data) {
		super(context, data, resource, from, to);
		this.data = data;
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
	}

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

}

package com.baiyou.ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.library.base.BaseView;
import org.library.utils.MapV2;

import com.baiyou.R;
import com.baiyou.adapter.ChatGroupsAdapter;
import com.baiyou.base.BaseActivity;
import com.baiyou.controller.OutDetailController;
import com.baiyou.controller.OutDetailController.OutDetailView;
import com.baiyou.dialog.PayDialog;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
/**
 * 出行信息界面
 * */
public class OutDetailActivity extends BaseActivity implements BaseView,OutDetailView{
	
	{
		mBaseView = this;
	}
	
	private TextView tv_destination;
	private TextView tv_startTime;
	private TextView tv_endTime;
	private Button btn_commit;
	private ListView lv_chatGroups;
	private ChatGroupsAdapter mAdapter;
	private List<MapV2> datasList;
	private ImageView iv_calendar1,iv_calendar2;
	
	private OutDetailController mController;

	@Override
	public int layout() {
		return R.layout.activity_out_detail;
	}

	@Override
	public void findById() {
		tv_destination = (TextView) findViewById(R.id.tv_out_detail_destination);
		tv_startTime = (TextView) findViewById(R.id.tv_out_detail_start);
		tv_endTime = (TextView) findViewById(R.id.tv_out_detail_end);
		btn_commit = (Button) findViewById(R.id.btn_out_detail_commit);
		lv_chatGroups = (ListView) findViewById(R.id.lv_out_detail_chatGroups);
		iv_calendar1 = (ImageView) findViewById(R.id.iv_out_detail_calendar1);
		iv_calendar2 = (ImageView) findViewById(R.id.iv_out_detail_calendar2);
		
	}

	@Override
	public void setListener() {
		btn_commit.setOnClickListener(this);
		iv_calendar1.setOnClickListener(this);
		iv_calendar2.setOnClickListener(this);
	}

	@Override
	public void initData() {
		mController = new OutDetailController(this, mHelper);
		tv_destination.setText("目的地：浙江");
		tv_startTime.setText("出发日期：2017/7/18");
		tv_endTime.setText("结束时间：2017/7/18");
		
		//测试listView
	    mController.getData();
		
	}

	@Override
	public void initAdapter() {
		datasList = new ArrayList<MapV2>();
		mAdapter = new ChatGroupsAdapter(this, datasList);
		lv_chatGroups.setAdapter(mAdapter);
		
	}

	@Override
	public void onclick(View v) {
		switch (v.getId()) {
		case R.id.btn_out_detail_commit:
			Dialog dialog = new PayDialog(this);
			dialog.show();
			Window dialogWindow = dialog.getWindow();
			WindowManager m = getWindowManager();
			Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
			WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值 
			p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.65，根据实际情况调整
			dialogWindow.setAttributes(p);
			break;
		case R.id.iv_out_detail_calendar1:
			Calendar ca = Calendar.getInstance();
			int year = ca.get(Calendar.YEAR);
			int month = ca.get(Calendar.MONTH);
			int day = ca.get(Calendar.DAY_OF_MONTH);
			DatePickerDialog dateDialog = new DatePickerDialog(this, new OnDateSetListener() {
				
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
					String date;
					date = new StringBuffer().append(year).append("-").append(monthOfYear)
							.append("-").append(dayOfMonth).toString();
					tv_startTime.setText("出发时间："+date);
					
				}
			}, year, month, day);
			dateDialog.show();
			break;
		case R.id.iv_out_detail_calendar2:
			Calendar ca1 = Calendar.getInstance();
			int year1 = ca1.get(Calendar.YEAR);
			int month1 = ca1.get(Calendar.MONTH);
			int day1 = ca1.get(Calendar.DAY_OF_MONTH);
			DatePickerDialog dateDialog1 = new DatePickerDialog(this, new OnDateSetListener() {
				
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
					String date;
					date = new StringBuffer().append(year).append("-").append(monthOfYear)
							.append("-").append(dayOfMonth).toString();
					tv_endTime.setText("出发时间："+date);
					
				}
			}, year1, month1, day1);
			dateDialog1.show();
			break;

		default:
			break;
		}
		
	}
	
	

	@Override
	public void setData(List<MapV2> datas) {
		datasList.clear();
		datasList.addAll(datas);
		mAdapter.notifyDataSetChanged();
		
	}

}

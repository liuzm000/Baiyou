package com.baiyou.controller;

import java.util.ArrayList;
import java.util.List;

import org.library.utils.MapV2;

import com.baiyou.utils.Helper;

public class OutDetailController {
	
	OutDetailView view;
	Helper helper;
	
	public OutDetailController(OutDetailView view,Helper helper){
		this.helper = helper;
		this.view = view;
	}
	
	
	public void getData(){
		List<MapV2> datas = new ArrayList<MapV2>();
		MapV2 data1 = new MapV2();
		data1.put("name", "7.18~7.25浙江自由行群聊");
		MapV2 data2 = new MapV2();
		data2.put("name", "7.18~7.26浙江自由行群聊");
		MapV2 data3 = new MapV2();
		data3.put("name", "7.18~7.27浙江自由行群聊");
		MapV2 data4 = new MapV2();
		data4.put("name", "7.18~7.25浙江自由行群聊");
		MapV2 data5 = new MapV2();
		data5.put("name", "7.18~7.26浙江自由行群聊");
		MapV2 data6 = new MapV2();
		data6.put("name", "7.18~7.27浙江自由行群聊");
		datas.add(data1);
		datas.add(data2);
		datas.add(data3);
		datas.add(data4);
		datas.add(data5);
		datas.add(data6);
		view.setData(datas);
	}
	
	
	
	public interface OutDetailView{
		void setData(List<MapV2> datas);
	}

}

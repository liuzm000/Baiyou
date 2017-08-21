package com.baiyou.controller;

import java.util.ArrayList;
import java.util.List;

import org.library.base.BaseControllerView;
import org.library.utils.MapV2;

import com.baiyou.R;
import com.baiyou.utils.Helper;

public class CollectionController {
	
	CollectionView view;
	Helper helper;
	
	public CollectionController(CollectionView view,Helper helper){
		this.view = view;
		this.helper = helper;
	}
	
	
	
	public interface CollectionView extends BaseControllerView{
		void loadEnd();
	}



	public void getData(int pageNumber, int pageSize) {
		List<MapV2> datas = new ArrayList<MapV2>();
		MapV2 data1 = new MapV2();
		data1.put("img", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=741766299,289330067&fm=26&gp=0.jpg");
		data1.put("description", "这只狗，听说它喜欢……");
		data1.put("time", "2017-7-5");
		datas.add(data1);
		MapV2 data2 = new MapV2();
		data2.put("img", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=741766299,289330067&fm=26&gp=0.jpg");
		data2.put("description", "这只狗，听说它喜欢……");
		data2.put("time", "2017-7-5");
		datas.add(data2);
		view.updateList(1, datas);
		view.loadEnd();
	}

}

package com.baiyou.controller;

import com.baiyou.utils.Helper;
/**
 * 队伍列表
 * */
public class TeamListController {
	
	TeamListView view;
	Helper helper;
	
	public TeamListController(TeamListView view,Helper helper){
		this.view = view;
		this.helper = helper;
	}
	
	
	public interface TeamListView{
		
	}

}

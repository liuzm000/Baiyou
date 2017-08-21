package com.baiyou.controller;

import com.baiyou.utils.Helper;

public class TeamInfomationController {
	
	TeamInfomationView view;
	Helper helper;
	
	public TeamInfomationController(TeamInfomationView view,Helper helper){
		this.view = view;
		this.helper = helper;
	}

	
	public interface TeamInfomationView{
		
	}
}

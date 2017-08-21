package com.baiyou.controller;

import com.baiyou.utils.Helper;

public class SeeMemberController {
	
	SeeMemberView view;
	Helper helper;
	
	public SeeMemberController(SeeMemberView view,Helper helper){
		this.view = view;
		this.helper = helper;
	}
	
	
	public interface SeeMemberView{
		
	}

}

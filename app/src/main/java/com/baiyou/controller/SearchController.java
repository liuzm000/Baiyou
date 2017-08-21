package com.baiyou.controller;

import com.baiyou.utils.Helper;

public class SearchController {
	
	SearchView view;
	Helper helper;
	
	public SearchController(SearchView view,Helper helper){
		this.view = view;
		this.helper = helper;
	}
	
	
	
	public interface SearchView{
		
	}

}

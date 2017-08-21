package com.baiyou.controller;

import com.baiyou.utils.Helper;

public class MainFragmentController {

	ControllerView view;
	Helper helper;

	public MainFragmentController(ControllerView view, Helper helper) {
		this.view = view;
		this.helper = helper;
	}

	public interface ControllerView {
	}

}

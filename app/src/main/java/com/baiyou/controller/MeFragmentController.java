package com.baiyou.controller;

import com.baiyou.utils.Helper;

public class MeFragmentController {

	ControllerView view;
	Helper helper;

	public MeFragmentController(ControllerView view, Helper helper) {
		this.view = view;
		this.helper = helper;
	}

	public interface ControllerView {
	}

}

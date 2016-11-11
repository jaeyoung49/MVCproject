package org.kosta.mvcproject.controller;

import javax.annotation.Resource;

import org.kosta.mvcproject.model.AdminService;
import org.kosta.mvcproject.model.MVCService;

public abstract class AbstractController {
	
	@Resource
	protected MVCService mvcService;
	@Resource
	protected AdminService adminService;
}

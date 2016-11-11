package org.kosta.mvcproject.model;

import javax.annotation.Resource;

public abstract class AbstractService {
	
	@Resource
	protected BoardDAO boardDAO;
	@Resource
	protected MemberDAO memberDAO;
	@Resource
	protected AdminDAO adminDAO;
	
}
package org.kosta.mvcproject.model;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

public abstract class AbstractDAO {
	
	@Resource
	protected SqlSessionTemplate template;

}
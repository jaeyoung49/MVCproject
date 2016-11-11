package controller;

import java.util.HashMap;

/**
 * 컨트롤러 구현체에서 컨트롤러 업무 수행 후 반환할 때 사용하는 객체 이동할(응답할) ViewName과 Model과 연동한 결과를
 * request에 setAttribute() 할 정보를 함께 저장한다.
 */
public class ModelAndView {
	// 컨트롤러에서 이동할 View name
	private String viewName;
	// 컨트롤러에서 Model 연동 결과를
	// request에 저장하기 위한 용도
	private HashMap<String, Object> map = new HashMap<String, Object>();

	public ModelAndView() {
	}

	public ModelAndView(String viewName) {
		this.viewName = viewName;
	}

	public ModelAndView(String viewName, HashMap<String, Object> map) {
		super();
		this.viewName = viewName;
		this.map = map;
	}

	public ModelAndView(String viewName, String attributeName, Object attributeValue) {
		this.viewName = viewName;
		this.map.put(attributeName, attributeValue);
	}

	public void addObject(String attributeName, Object attributeValue) {
		this.map.put(attributeName, attributeValue);
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "ModelAndView [viewName=" + viewName + ", map=" + map + "]";
	}

}

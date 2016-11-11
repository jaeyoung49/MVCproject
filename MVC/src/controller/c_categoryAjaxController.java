package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import model.BoardDAO;
import model.C_Category;

public class c_categoryAjaxController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<C_Category> c = BoardDAO.getInstance().c_Category();
		JSONObject json = null;
		JSONArray ja = new JSONArray();
		if (c == null) {
			json = new JSONObject();
			json.put("flag", "fail");
		} else {
			json = new JSONObject();
			for (int i = 0; i < c.size(); i++) {
				json.put("c_c_no", c.get(i).getC_c_no());
				json.put("c_c_name", c.get(i).getC_c_name());
				ja.put(json.toString());
			}

		}
		return new ModelAndView("AjaxView", "json", ja);
	}
}

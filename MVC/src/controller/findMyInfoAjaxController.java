package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.MemberDAO;
import model.MemberDTO;

public class findMyInfoAjaxController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDTO dto = MemberDAO.getInstance().findMyInfo(request.getParameter("id"));
		System.out.println(dto);
		JSONObject json = null;
		if (dto == null) {
			json = new JSONObject();
			json.put("flag", "fail");
		} else {
			json = new JSONObject(dto);
		}
		return new ModelAndView("AjaxView", "json", json);
	}
}

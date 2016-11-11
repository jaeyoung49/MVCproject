package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.MemberDAO;
import model.MemberDTO;

public class DuplicateIdCheckController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		System.out.println("중복체크 : " + id);
		MemberDTO dto = MemberDAO.getInstance().findById(id);
		JSONObject json = null;
		if (dto == null) { // id에 해당하는 회원이 없을 경우
			json = new JSONObject();
			json.put("flag", "fail");
		} else { // id에 해당하는 회원이 있을 경우
			json = new JSONObject(dto);
		}
		return new ModelAndView("AjaxView", "json", json);
	}

}

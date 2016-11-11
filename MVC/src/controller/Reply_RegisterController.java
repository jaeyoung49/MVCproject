package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDTO;
import model.MvcService;
import model.ReplyDTO;

public class Reply_RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int a_no = Integer.parseInt(request.getParameter("a_no"));
		String id = request.getParameter("id");
		String r_content = request.getParameter("r_content");
		MemberDTO mdto = new MemberDTO();
		mdto.setId(id);
		ReplyDTO rdto = new ReplyDTO(-1, a_no, null, r_content, mdto);
		MvcService.getInstance().replyReg(rdto);
		return new ModelAndView("AjaxView");
	}

}

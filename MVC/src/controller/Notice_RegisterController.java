package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArticleDTO;
import model.MemberDTO;
import model.MvcService;
import model.NoticeDTO;

public class Notice_RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String temp = request.getParameter("priority");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		int priority = 0;
		if(temp!=null)
			priority = Integer.parseInt(temp);
		ArticleDTO adto = new ArticleDTO(title,id,content,2);
		MemberDTO mdto = new MemberDTO();
		mdto.setId(id);
		NoticeDTO dto = new NoticeDTO(mdto, adto, priority);
		MvcService.getInstance().noticeReg(dto);
		return new ModelAndView("redirect:AjaxView");
	}

}

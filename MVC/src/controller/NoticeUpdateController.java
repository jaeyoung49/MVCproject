package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArticleDTO;
import model.MemberDTO;
import model.MvcService;
import model.NoticeDTO;

public class NoticeUpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String temp = request.getParameter("a_no");
		String temp1 = request.getParameter("priority");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		int priority = 0;
		int a_no = 0;
		a_no = Integer.parseInt(temp);
		if(temp1!=null)
			priority = Integer.parseInt(temp1);
		ArticleDTO adto = new ArticleDTO(title,id,content,2);
		adto.setA_no(a_no);
		MemberDTO mdto = new MemberDTO();
		mdto.setId(id);
		NoticeDTO dto = new NoticeDTO(mdto, adto, priority);
		MvcService.getInstance().noticeUpdate(dto);
		return new ModelAndView("redirect:AjaxView");
	}

}

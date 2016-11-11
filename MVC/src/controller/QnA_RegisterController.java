package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArticleDTO;
import model.MemberDTO;
import model.MvcService;
import model.NoticeDTO;
import model.QnADTO;

public class QnA_RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		ArticleDTO adto = new ArticleDTO(title,id,content,3);
		MemberDTO mdto = new MemberDTO();
		mdto.setId(id);
		QnADTO dto = new QnADTO(mdto, adto);
		MvcService.getInstance().qnaReg(dto);
		return new ModelAndView("redirect:AjaxView");
	}

}

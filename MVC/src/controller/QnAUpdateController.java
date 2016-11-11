package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArticleDTO;
import model.MemberDTO;
import model.MvcService;
import model.QnADTO;
public class QnAUpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String temp = request.getParameter("a_no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		System.out.println(request.getParameter("a_no") + request.getParameter("title") + request.getParameter("content") + request.getParameter("id"));
		int a_no = 0;
		if(temp!=null)
			a_no = Integer.parseInt(temp);
		ArticleDTO adto = new ArticleDTO(title,id,content,3);
		adto.setA_no(a_no);
		MemberDTO mdto = new MemberDTO();
		mdto.setId(id);
		QnADTO qdto = new QnADTO(mdto, adto);
		MvcService.getInstance().qnaUpdate(qdto);
		return new ModelAndView("redirect:AjaxView");
	}

}

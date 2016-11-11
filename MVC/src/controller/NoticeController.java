package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDTO;
import model.MvcService;

public class NoticeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nowPage = request.getParameter("nowPage");
		String nowPageQnA = request.getParameter("nowPageQnA");
		ListDTO ldto = MvcService.getInstance().noticeList(nowPage);
		ListDTO qdto = MvcService.getInstance().qnaList(nowPageQnA);
		ModelAndView mv = new ModelAndView("index.jsp?page=NoticeList", "ldto", ldto);
		mv.getMap().put("qdto", qdto);
		return mv;
	}
}

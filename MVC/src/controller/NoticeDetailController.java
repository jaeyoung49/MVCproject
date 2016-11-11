package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MvcService;
import model.NoticeDTO;

public class NoticeDetailController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int a_no = Integer.parseInt(request.getParameter("a_no"));
		String nowPage = request.getParameter("nowPage");
		NoticeDTO nDto = MvcService.getInstance().noticeDetail(a_no);
		//return new ModelAndView("index.jsp?page=NoticeDetail", "nDto", nDto);
		ModelAndView mv = new ModelAndView("index.jsp?page=NoticeDetail", "nDto", nDto);
		mv.getMap().put("rdto", MvcService.getInstance().replyList(nowPage, a_no));
		return mv;
	}

}


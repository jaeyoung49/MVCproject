package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MvcService;
import model.NoticeDTO;

public class Notice_RegistertoDetailController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int a_no = Integer.parseInt(request.getParameter("a_no"));
		NoticeDTO nDto = MvcService.getInstance().noticeDetailNoHit(a_no);
		return new ModelAndView("index.jsp?page=NoticeDetail", "nDto", nDto);
	}

}

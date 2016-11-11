package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.sa_MvcService;

public class sa_NoticeDeleteAjaxController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int a_no = Integer.parseInt(request.getParameter("a_no"));
		sa_MvcService.getInstance().sa_noticeDelete(a_no);
		return new ModelAndView("redirect:sa/sa_index.jsp?page=sa_noticeList");
	}

}

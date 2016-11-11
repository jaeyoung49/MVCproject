package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.sa_MvcService;

public class sa_MemberDeleteAjaxController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		sa_MvcService.getInstance().sa_memberDelete(id);
		return new ModelAndView("redirect:sa/sa_index.jsp?page=sa_memberManagement");
	}

}

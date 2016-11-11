package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.sa_MvcService;

public class sa_memberGradeChangeAjaxController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int m_gradeno = Integer.parseInt(request.getParameter("m_gradeno"));
		String id = request.getParameter("id");
		sa_MvcService.getInstance().sa_memberGradeChange(m_gradeno, id);
		return new ModelAndView("redirect:sa/sa_index.jsp?page=sa_memberManagement");
	}

}

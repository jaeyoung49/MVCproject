package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MvcService;

public class sa_epilogueListByCategoryController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int c_c_no = Integer.parseInt(request.getParameter("c_c_no"));
		return new ModelAndView("sa/sa_index.jsp?page=sa_epilogueList", "eplist",
				MvcService.getInstance().epilogueListByCategory(c_c_no));
	}

}

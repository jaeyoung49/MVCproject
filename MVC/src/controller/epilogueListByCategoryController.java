package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MvcService;

public class epilogueListByCategoryController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int c_c_no = Integer.parseInt(request.getParameter("c_c_no"));
		return new ModelAndView("index.jsp?page=EpilogueList", "eplist",
				MvcService.getInstance().epilogueListByCategory(c_c_no));
	}

}

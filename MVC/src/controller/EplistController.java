package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MvcService;

public class EplistController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("index.jsp?page=EpilogueList", "eplist", MvcService.getInstance().EpilogueList());
	}
}

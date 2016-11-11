package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MvcService;

public class epilogueListByKeyWordController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String option = request.getParameter("option");
		String KeyWord = request.getParameter("KeyWord");
		return new ModelAndView("index.jsp?page=EpilogueList", "eplist",
				MvcService.getInstance().epilogueListByKeyWord(option, KeyWord));
	}
}

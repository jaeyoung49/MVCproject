package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDTO;
import model.MvcService;

public class sa_EpilogueListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("/sa/sa_index.jsp?page=sa_epilogueList", "eplist", MvcService.getInstance().EpilogueList());
	}

}

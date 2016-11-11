package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDTO;
import model.sa_MvcService;

public class sa_MemberListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nowPage = request.getParameter("nowPage");
		System.out.println("페이징 번호 : " + nowPage);
		ListDTO ldto = sa_MvcService.getInstance().sa_MemberList(nowPage);
		return new ModelAndView("/sa/sa_index.jsp?page=sa_memberManagement", "ldto", ldto);
	}

}

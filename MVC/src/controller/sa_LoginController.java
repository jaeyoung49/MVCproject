package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.sa_MvcService;

public class sa_LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = request.getSession(false);
		session.setAttribute("dto", sa_MvcService.getInstance().login(id, pw));
		System.out.println(session);
		return new ModelAndView("/sa/sa_index.jsp");
	}
}

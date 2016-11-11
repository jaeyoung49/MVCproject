package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDTO;
import model.MvcService;

public class JoinController implements Controller {

	// d,pw,m_name,sex,email,nickname,birthday
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String m_name = request.getParameter("m_name");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email") + request.getParameter("emailcompany");
		String nickname = request.getParameter("nickname");
		String birthday = request.getParameter("birthday");
		MvcService.getInstance().join(new MemberDTO(id, pw, m_name, sex, email, nickname, birthday));
		HttpSession session = request.getSession(false);
		session.setAttribute("dto", MvcService.getInstance().login(id, pw));
		return new ModelAndView("redirect:index.jsp");
	}

}

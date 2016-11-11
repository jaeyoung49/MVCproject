package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

public class changeMyInfoController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDTO dto = new MemberDTO();
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		dto.setId(id);
		dto.setNickname(nickname);
		dto.setEmail(email);
		dto.setBirthday(birthday);
		MemberDAO.getInstance().changeMyInfo(dto);
		return new ModelAndView("redirect:index.jsp?page=main");
	}

}

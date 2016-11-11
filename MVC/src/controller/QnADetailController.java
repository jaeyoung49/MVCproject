package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MvcService;
import model.QnADTO;

public class QnADetailController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int a_no = Integer.parseInt(request.getParameter("a_no"));
		String nowPage = request.getParameter("nowPage");
		QnADTO qDto = MvcService.getInstance().qnaDetail(a_no);
		ModelAndView mv = new ModelAndView("index.jsp?page=QnADetail", "qDto", qDto);
		mv.getMap().put("rdto", MvcService.getInstance().replyList(nowPage, a_no));
		return mv;
	}

}

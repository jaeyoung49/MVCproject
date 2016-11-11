package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MvcService;
import model.QnADTO;

public class QnAUpdateFormController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int a_no = Integer.parseInt(request.getParameter("a_no"));
		QnADTO qDto = MvcService.getInstance().qnaDetail(a_no);
		return new ModelAndView("index.jsp?page=QnA_update", "qDto", qDto);
	}

}

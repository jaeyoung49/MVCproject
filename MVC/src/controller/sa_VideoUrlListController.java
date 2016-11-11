package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.sa_MvcService;

public class sa_VideoUrlListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("/sa/sa_index.jsp?page=sa_VideoUrlList", "list",
				sa_MvcService.getInstance().sa_VideoUrlList());
	}

}

package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VideoDTO;
import model.sa_MvcService;

public class sa_VideoUrlUpLoadController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// no,title,url_link,regdate
		String title = request.getParameter("title");
		String url_info = request.getParameter("url_info");
		String url_link = request.getParameter("url_link");
		sa_MvcService.getInstance().sa_VideoUrlUpLoad(new VideoDTO(title, url_info, url_link));
		return new ModelAndView("redirect:sa/index.jsp?page=sa_VideoUrlList");
	}
}

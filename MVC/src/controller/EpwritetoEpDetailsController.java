package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EpilogueDTO;
import model.MvcService;

public class EpwritetoEpDetailsController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int a_no = Integer.parseInt(request.getParameter("a_no"));
		ArrayList<EpilogueDTO> EpDto = MvcService.getInstance().epilogueDetailNoHit(a_no);
		String name = MvcService.getInstance().findCategoryNameByA_no(a_no);
		ModelAndView mv = new ModelAndView("index.jsp?page=EpDetails");
		mv.getMap().put("EpDto", EpDto);
		mv.getMap().put("c_name", name);
		mv.getMap().put("a_no", a_no);
		return mv;
	}

}

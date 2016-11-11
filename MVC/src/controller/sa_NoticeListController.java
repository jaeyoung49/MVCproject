package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDTO;
import model.MvcService;

public class sa_NoticeListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nowPage = request.getParameter("nowPage");
		System.out.println("페이징 번호 : " + nowPage);
		ListDTO ldto = MvcService.getInstance().noticeList(nowPage);
		return new ModelAndView("/sa/sa_index.jsp?page=sa_noticeList", "ldto", ldto);
	}

}
/*
public ArrayList<EpilogueDTO> EpilogueList() throws SQLException {
	ArrayList<EpilogueDTO> arr = new ArrayList<EpilogueDTO>();
	arr = BoardDAO.getInstance().epilogueList();
	return arr;
}

public ListDTO epilogueList(String nowPage) throws SQLException{
	ListDTO ldto = new ListDTO();
	int page = 1;
	PagingBean pb = null;
	int totalContents = BoardDAO.getInstance().epilogueTotalContents();
	if(nowPage != null){
		page = Integer.parseInt(nowPage);
		pb = new PagingBean(totalContents, page);
	} else {
		pb = new PagingBean(totalContents);
	}
	ArrayList<ArrayList<EpilogueDTO>> elist = ArrayList<ArrayList<EpilogueDTO>>();
	elist.add(BoardDAO.getInstance().epilogueList(pb));
	elist.add(BoardDAO.getInstance().noticePriorityList());
	ldto.setElist(elist);
	ldto.setPagingBean(pb);
	return ldto;
}














*/
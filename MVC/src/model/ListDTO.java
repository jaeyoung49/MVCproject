package model;

import java.util.ArrayList;

public class ListDTO {
	private ArrayList<EpilogueDTO> elist;
	private ArrayList<ArrayList<NoticeDTO>> nlist;
	private PagingBean pagingBean;
	private ArrayList<ReplyDTO> rlist;
	private ArrayList<MemberDTO> mlist;
	private ArrayList<QnADTO> qlist;


	public ListDTO() {
		super();
	}

	public ListDTO(ArrayList<MemberDTO> mlist) {
		super();
		this.mlist = mlist;
	}
	public ArrayList<QnADTO> getQlist() {
		return qlist;
	}
	
	public void setQlist(ArrayList<QnADTO> qlist) {
		this.qlist = qlist;
	}
	public ArrayList<ReplyDTO> getRlist() {
		return rlist;
	}
	
	public void setRlist(ArrayList<ReplyDTO> rlist) {
		this.rlist = rlist;
	}

	public ArrayList<MemberDTO> getMlist() {
		return mlist;
	}

	public void setMlist(ArrayList<MemberDTO> mlist) {
		this.mlist = mlist;
	}

	public ListDTO(ArrayList<EpilogueDTO> elist, ArrayList<ArrayList<NoticeDTO>> nlist, PagingBean pagingBean) {
		super();
		this.elist = elist;
		this.nlist = nlist;
		this.pagingBean = pagingBean;
	}

	public ArrayList<EpilogueDTO> getElist() {
		return elist;
	}

	public void setElist(ArrayList<EpilogueDTO> elist) {
		this.elist = elist;
	}

	public ArrayList<ArrayList<NoticeDTO>> getNlist() {
		return nlist;
	}

	public void setNlist(ArrayList<ArrayList<NoticeDTO>> nlist) {
		this.nlist = nlist;
	}

	public PagingBean getPagingBean() {
		return pagingBean;
	}

	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}

}

package org.kosta.mvcproject.model;

import java.util.List;

public class ListVO {
	private List<EpilogueVO> epilogueList;
	private List<NoticeVO> priorityNoticeList;
	private List<NoticeVO> noticeList;
	private List<ReplyVO> replyList;
	private List<MemberVO> memberList;
	private List<ArticleVO> qnaList;
	private PagingBean pagingBean;
	
	public ListVO() {
		super();
	}

	public ListVO(List<EpilogueVO> epilogueList, List<NoticeVO> priorityNoticeList, List<NoticeVO> noticeList,
			List<ReplyVO> replyList, List<MemberVO> memberList, List<ArticleVO> qnaList, PagingBean pagingBean) {
		super();
		this.epilogueList = epilogueList;
		this.priorityNoticeList = priorityNoticeList;
		this.noticeList = noticeList;
		this.replyList = replyList;
		this.memberList = memberList;
		this.qnaList = qnaList;
		this.pagingBean = pagingBean;
	}

	public List<EpilogueVO> getEpilogueList() {
		return epilogueList;
	}

	public void setEpilogueList(List<EpilogueVO> epilogueList) {
		this.epilogueList = epilogueList;
	}

	public List<NoticeVO> getPriorityNoticeList() {
		return priorityNoticeList;
	}

	public void setPriorityNoticeList(List<NoticeVO> priorityNoticeList) {
		this.priorityNoticeList = priorityNoticeList;
	}

	public List<NoticeVO> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<NoticeVO> noticeList) {
		this.noticeList = noticeList;
	}

	public List<ReplyVO> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyVO> replyList) {
		this.replyList = replyList;
	}

	public List<MemberVO> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<MemberVO> memberList) {
		this.memberList = memberList;
	}

	public List<ArticleVO> getQnaList() {
		return qnaList;
	}

	public void setQnaList(List<ArticleVO> qnaList) {
		this.qnaList = qnaList;
	}

	public PagingBean getPagingBean() {
		return pagingBean;
	}

	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}

	@Override
	public String toString() {
		return "ListVO [epilogueList=" + epilogueList + ", priorityNoticeList=" + priorityNoticeList + ", noticeList="
				+ noticeList + ", replyList=" + replyList + ", memberList=" + memberList + ", qnaList=" + qnaList
				+ ", pagingBean=" + pagingBean + "]";
	}
	
	
}

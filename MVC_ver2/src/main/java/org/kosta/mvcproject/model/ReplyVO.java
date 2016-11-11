package org.kosta.mvcproject.model;

public class ReplyVO {
	private int replyNo;
	private MemberVO memberVO;
	private ArticleVO articleVO;
	private String replyContent;
	private String replyDate;
	private int replyResponseGroup;
	private int replyResponseOrder;
	private int replyResponseStep;
	
	public ReplyVO() {
		super();
	}

	public ReplyVO(int replyNo, MemberVO memberVO, ArticleVO articleVO, String replyContent, String replyDate,
			int replyResponseGroup, int replyResponseOrder, int replyResponseStep) {
		super();
		this.replyNo = replyNo;
		this.memberVO = memberVO;
		this.articleVO = articleVO;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.replyResponseGroup = replyResponseGroup;
		this.replyResponseOrder = replyResponseOrder;
		this.replyResponseStep = replyResponseStep;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public ArticleVO getArticleVO() {
		return articleVO;
	}

	public void setArticleVO(ArticleVO articleVO) {
		this.articleVO = articleVO;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public int getReplyResponseGroup() {
		return replyResponseGroup;
	}

	public void setReplyResponseGroup(int replyResponseGroup) {
		this.replyResponseGroup = replyResponseGroup;
	}

	public int getReplyResponseOrder() {
		return replyResponseOrder;
	}

	public void setReplyResponseOrder(int replyResponseOrder) {
		this.replyResponseOrder = replyResponseOrder;
	}

	public int getReplyResponseStep() {
		return replyResponseStep;
	}

	public void setReplyResponseStep(int replyResponseStep) {
		this.replyResponseStep = replyResponseStep;
	}

	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", memberVO=" + memberVO + ", articleVO=" + articleVO + ", replyContent="
				+ replyContent + ", replyDate=" + replyDate + ", replyResponseGroup=" + replyResponseGroup
				+ ", replyResponseOrder=" + replyResponseOrder + ", replyResponseStep=" + replyResponseStep + "]";
	}
	
}

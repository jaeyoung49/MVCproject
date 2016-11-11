package model;

public class NoticeDTO {
	private int priority; // 상위표시 여부 확인
	private MemberDTO memberDTO;
	private ArticleDTO articleDTO;

	public NoticeDTO() {
		super();
	}

	public NoticeDTO(ArticleDTO articleDTO, int priority) {
		super();
		this.priority = priority;
		this.articleDTO = articleDTO;
	}
	
	public NoticeDTO(MemberDTO memberDTO, ArticleDTO articleDTO, int priority) {
		super();
		this.priority = priority;
		this.articleDTO = articleDTO;
		this.memberDTO = memberDTO;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public MemberDTO getMemberDTO() {
		return memberDTO;
	}

	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	public ArticleDTO getArticleDTO() {
		return articleDTO;
	}

	public void setArticleDTO(ArticleDTO articleDTO) {
		this.articleDTO = articleDTO;
	}

}

package model;

public class QnADTO {
	private MemberDTO memberDTO;
	private ArticleDTO articleDTO;

	public QnADTO() {
		super();
	}

	public QnADTO(ArticleDTO articleDTO) {
		super();
		this.articleDTO = articleDTO;
	}
	
	public QnADTO(MemberDTO memberDTO, ArticleDTO articleDTO) {
		super();
		this.memberDTO = memberDTO;
		this.articleDTO = articleDTO;
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

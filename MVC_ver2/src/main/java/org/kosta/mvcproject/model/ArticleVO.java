package org.kosta.mvcproject.model;

public class ArticleVO {
	private int articleNo;
	private MemberVO memberVO;
	private ArticleCategoryVO articleCategoryVO;
	private String articleTitle;
	private String articleContent;
	private String articleDate;
	private int articleHit;
	private int responseGroup;
	private int responseOrder;
	private int responseStep;
	
	public ArticleVO() {
		super();
	}

	public ArticleVO(int articleNo, MemberVO memberVO, ArticleCategoryVO articleCategoryVO, String articleTitle,
			String articleContent, String articleDate, int articleHit, int responseGroup, int responseOrder,
			int responseStep) {
		super();
		this.articleNo = articleNo;
		this.memberVO = memberVO;
		this.articleCategoryVO = articleCategoryVO;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.articleDate = articleDate;
		this.articleHit = articleHit;
		this.responseGroup = responseGroup;
		this.responseOrder = responseOrder;
		this.responseStep = responseStep;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public ArticleCategoryVO getArticleCategoryVO() {
		return articleCategoryVO;
	}

	public void setArticleCategoryVO(ArticleCategoryVO articleCategoryVO) {
		this.articleCategoryVO = articleCategoryVO;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleDate() {
		return articleDate;
	}

	public void setArticleDate(String articleDate) {
		this.articleDate = articleDate;
	}

	public int getArticleHit() {
		return articleHit;
	}

	public void setArticleHit(int articleHit) {
		this.articleHit = articleHit;
	}

	public int getResponseGroup() {
		return responseGroup;
	}

	public void setResponseGroup(int responseGroup) {
		this.responseGroup = responseGroup;
	}

	public int getResponseOrder() {
		return responseOrder;
	}

	public void setResponseOrder(int responseOrder) {
		this.responseOrder = responseOrder;
	}

	public int getResponseStep() {
		return responseStep;
	}

	public void setResponseStep(int responseStep) {
		this.responseStep = responseStep;
	}

	@Override
	public String toString() {
		return "ArticleVO [articleNo=" + articleNo + ", memberVO=" + memberVO + ", articleCategoryVO="
				+ articleCategoryVO + ", articleTitle=" + articleTitle + ", articleContent=" + articleContent
				+ ", articleDate=" + articleDate + ", articleHit=" + articleHit + ", responseGroup=" + responseGroup
				+ ", responseOrder=" + responseOrder + ", responseStep=" + responseStep + "]";
	}
	
	
	
}

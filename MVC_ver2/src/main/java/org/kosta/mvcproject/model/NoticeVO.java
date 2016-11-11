package org.kosta.mvcproject.model;

public class NoticeVO {
	private ArticleVO articleVO;
	private int priority;
	
	public NoticeVO() {
		super();
	}

	public NoticeVO(ArticleVO articleVO, int priority) {
		super();
		this.articleVO = articleVO;
		this.priority = priority;
	}

	public ArticleVO getArticleVO() {
		return articleVO;
	}

	public void setArticleVO(ArticleVO articleVO) {
		this.articleVO = articleVO;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "NoticeVO [articleVO=" + articleVO + ", priority=" + priority + "]";
	}
	
}

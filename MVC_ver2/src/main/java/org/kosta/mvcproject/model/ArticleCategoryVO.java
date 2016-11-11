package org.kosta.mvcproject.model;

public class ArticleCategoryVO {
	private int articleCategoryNo;
	private int articleCategoryName;
	
	public ArticleCategoryVO() {
		super();
	}

	public ArticleCategoryVO(int articleCategoryNo, int articleCategoryName) {
		super();
		this.articleCategoryNo = articleCategoryNo;
		this.articleCategoryName = articleCategoryName;
	}

	public int getArticleCategoryNo() {
		return articleCategoryNo;
	}

	public void setArticleCategoryNo(int articleCategoryNo) {
		this.articleCategoryNo = articleCategoryNo;
	}

	public int getArticleCategoryName() {
		return articleCategoryName;
	}

	public void setArticleCategoryName(int articleCategoryName) {
		this.articleCategoryName = articleCategoryName;
	}

	@Override
	public String toString() {
		return "ArticleCategoryVO [articleCategoryNo=" + articleCategoryNo + ", articleCategoryName="
				+ articleCategoryName + "]";
	}

}

package org.kosta.mvcproject.model;

public class GradeVO {
	private int gradeNo;
	private String gradeName;
	private int articleCountLow;
	private int replyCountLow;
	
	public GradeVO() {
		super();
	}

	public GradeVO(int gradeNo, String gradeName, int articleCountLow, int replyCountLow) {
		super();
		this.gradeNo = gradeNo;
		this.gradeName = gradeName;
		this.articleCountLow = articleCountLow;
		this.replyCountLow = replyCountLow;
	}

	public int getGradeNo() {
		return gradeNo;
	}

	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public int getArticleCountLow() {
		return articleCountLow;
	}

	public void setArticleCountLow(int articleCountLow) {
		this.articleCountLow = articleCountLow;
	}

	public int getReplyCountLow() {
		return replyCountLow;
	}

	public void setReplyCountLow(int replyCountLow) {
		this.replyCountLow = replyCountLow;
	}

	@Override
	public String toString() {
		return "Grade [gradeNo=" + gradeNo + ", gradeName=" + gradeName + ", articleCountLow=" + articleCountLow
				+ ", replyCountLow=" + replyCountLow + "]";
	}
	
	
}

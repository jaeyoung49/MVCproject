package org.kosta.mvcproject.model;

public class PagingBean {

	// 현재 페이지/
	private int nowPage = 1;
	// 페이지당 게시물수/
	private int contentNumberPerPage = 10;
	// 페이지 그룹당 페이지수/
	private int pageNumberPerPageGroup = 4;
	// database에 저장된 총게시물수
	private int totalContents;
	// reply 리스트 조회시 해당게시글 번호
	private int articleNo;

	public PagingBean() {
	}

	public PagingBean(int totalContents) {
		this.totalContents = totalContents;
	}

	public PagingBean(int totalContents, int nowPage) {
		this.totalContents = totalContents;
		this.nowPage = nowPage;
	}
	
	
	
	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public int getTotalContents() {
		return totalContents;
	}

	public void setTotalContents(int totalContents) {
		this.totalContents = totalContents;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	
	
	
	public int getStartRowNumber() {
		return ((nowPage - 1) * contentNumberPerPage) + 1;
	}

	public int getEndRowNumber() {
		int endRowNumber = nowPage * contentNumberPerPage;
		if (totalContents < endRowNumber)
			endRowNumber = totalContents;
		return endRowNumber;
	}

	public int getTotalPage() {
		int num = this.totalContents % this.contentNumberPerPage;
		int totalPage = 0;
		if (num == 0) {
			totalPage = this.totalContents / this.contentNumberPerPage;
		} else {
			totalPage = this.totalContents / this.contentNumberPerPage + 1;
		}
		return totalPage;
	}

	public int getTotalPageGroup() {
		int num = this.getTotalPage() % this.pageNumberPerPageGroup;
		int totalPageGroup = 0;
		if (num == 0) {
			totalPageGroup = this.getTotalPage() / this.pageNumberPerPageGroup;
		} else {
			totalPageGroup = this.getTotalPage() / this.pageNumberPerPageGroup + 1;
		}
		return totalPageGroup;
	}

	public int getNowPageGroup() {
		int num = this.nowPage % this.pageNumberPerPageGroup;
		int nowPageGroup = 0;
		if (num == 0) {
			nowPageGroup = this.nowPage / this.pageNumberPerPageGroup;
		} else {
			nowPageGroup = this.nowPage / this.pageNumberPerPageGroup + 1;
		}
		return nowPageGroup;
	}

	public int getStartPageOfPageGroup() {
		int num = this.pageNumberPerPageGroup * (this.getNowPageGroup() - 1) + 1;
		return num;
	}

	public int getEndPageOfPageGroup() {
		int num = this.getNowPageGroup() * this.pageNumberPerPageGroup;
		if (this.getTotalPage() < num) {
			num = this.getTotalPage();
		}
		return num;
	}

	public boolean isPreviousPageGroup() {
		boolean flag = false;
		if (this.getNowPageGroup() > 1) {
			flag = true;
		}
		return flag;
	}

	public boolean isNextPageGroup() {
		boolean flag = false;
		if (this.getNowPageGroup() < this.getTotalPageGroup()) {
			flag = true;
		}
		return flag;
	}

	public static void main(String args[]) {
		PagingBean p = new PagingBean(47, 10);
		// 현페이지의 시작 row number 를 조회 46
		System.out.println("getBeginRowNumber:" + p.getStartRowNumber());
		// 현페이지의 마지막 row number 를 조회 47
		System.out.println("getEndRowNumber:" + p.getEndRowNumber());
		// 전체 페이지 수 : 10
		System.out.println("getTotalPage:" + p.getTotalPage());
		// 전체 페이지 그룹 수 : 3
		System.out.println("getTotalPageGroup:" + p.getTotalPageGroup());
		System.out.println("////////////////////////////");
		p = new PagingBean(31, 6);// 게시물수 31 현재 페이지 6
		// 현페이지의 시작 row number 를 조회 26
		System.out.println("getStartRowNumber:" + p.getStartRowNumber());
		// 현페이지의 마지막 row number 를 조회 30
		System.out.println("getEndRowNumber:" + p.getEndRowNumber());
		// 게시물수 31 -> 총페이지수 7 -> 총페이지그룹->2
		// 현재 페이지 그룹 : 2
		System.out.println("getNowPageGroup:" + p.getNowPageGroup());
		// 페이지 그룹의 시작 페이지 : 5
		System.out.println("getStartPageOfPageGroup:" + p.getStartPageOfPageGroup());
		// 페이지 그룹의 마지막 페이지 : 7
		System.out.println("getEndPageOfPageGroup:" + p.getEndPageOfPageGroup());
		// 이전 페이지 그룹이 있는 지 : true
		System.out.println("isPreviousPageGroup:" + p.isPreviousPageGroup());
		// 다음 페이지 그룹이 있는 지 : false
		System.out.println("isNextPageGroup:" + p.isNextPageGroup());
	}
}
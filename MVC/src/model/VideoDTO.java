package model;

public class VideoDTO {
	private int no; // 글번호
	private String title;// 제목
	private String url_info;
	private String url_link; // 링크 주소
	private String regdate;

	public VideoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoDTO(String title, String url_info, String url_link) {
		super();
		this.title = title;
		this.url_info = url_info;
		this.url_link = url_link;
	}

	public VideoDTO(int no, String title, String url_info, String url_link, String regdate) {
		super();
		this.no = no;
		this.title = title;
		this.url_info = url_info;
		this.url_link = url_link;
		this.regdate = regdate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl_info() {
		return url_info;
	}

	public void setUrl_info(String url_info) {
		this.url_info = url_info;
	}

	public String getUrl_link() {
		return url_link;
	}

	public void setUrl_link(String url_link) {
		this.url_link = url_link;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "VideoDTO [no=" + no + ", title=" + title + ", url_info=" + url_info + ", url_link=" + url_link
				+ ", regdate=" + regdate + "]";
	}

}
package model;

/*create table article(
a_no number primary key,
a_title varchar2(100) not null,
id varchar2(50) not null,
a_content clob not null,
a_regdate date not null,
hit number not null,
a_c_no number not null,
constraint fk_article foreign key(id) references member(id),
constraint fk_article2 foreign key(a_c_no) references a_category(a_c_no)
)*/
public class ArticleDTO {
	private int a_no; // 글 번호 (시퀀스)
	private String a_title; // 작성 제목
	private String id; // 작성자 ID
	private String a_content; // 작성내용
	private String a_regdate; // 작성일자
	private int hit; // 조회수
	private int a_c_no; // 카테고리 번호

	public ArticleDTO() {
		super();
	}

	// 후기 게시판 리스트 조회시
	public ArticleDTO(int a_no, String a_title, String a_regdate, int hit) {
		super();
		this.a_no = a_no;
		this.a_title = a_title;
		this.a_regdate = a_regdate;
		this.hit = hit;
	}

	public ArticleDTO(String a_title, String id, String a_content,int hit,String a_regdate){
			super();
			this.a_title = a_title;
			this.id = id;
			this.a_content = a_content;
			this.a_regdate = a_regdate;
			this.hit = hit; 
	 }

	// 글 작성시 기본 입력정보
	public ArticleDTO(String a_title, String id, String a_content, String a_regdate, int a_c_no) {
		super();
		this.a_title = a_title;
		this.id = id;
		this.a_content = a_content;
		this.a_regdate = a_regdate;
		this.a_c_no = a_c_no;
	}

	public ArticleDTO(String a_title, String id, String a_content, int a_c_no) {
		super();
		this.a_title = a_title;
		this.id = id;
		this.a_content = a_content;
		this.a_c_no = a_c_no;
	}

	public ArticleDTO(int a_no, String a_title, String a_content) {
		this.a_no = a_no;
		this.a_title = a_title;
		this.a_content = a_content;
	}

	public int getA_no() {
		return a_no;
	}

	public void setA_no(int a_no) {
		this.a_no = a_no;
	}

	public String getA_title() {
		return a_title;
	}

	public void setA_title(String a_title) {
		this.a_title = a_title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getA_content() {
		return a_content;
	}

	public void setA_content(String a_content) {
		this.a_content = a_content;
	}

	public String getA_regdate() {
		return a_regdate;
	}

	public void setA_regdate(String a_regdate) {
		this.a_regdate = a_regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getA_c_no() {
		return a_c_no;
	}

	public void setA_c_no(int a_c_no) {
		this.a_c_no = a_c_no;
	}

	@Override
	public String toString() {
		return "AricleDTO [a_no=" + a_no + ", a_title=" + a_title + ", id=" + id + ", a_content=" + a_content
				+ ", a_regdate=" + a_regdate + ", hit=" + hit + ", a_c_no=" + a_c_no + "]";
	}

}

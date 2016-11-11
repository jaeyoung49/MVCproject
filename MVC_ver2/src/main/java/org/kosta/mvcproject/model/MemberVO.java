package org.kosta.mvcproject.model;

public class MemberVO {
	private String id; // 아이디
	private String password; // 패스워드
	private String name; // 성명
	private String sex; // 성별
	private String email; // 이메일
	private String nick; // 닉네임
	private String birthday; // 생일
	private String regdate; // 가입일자
	private int articleCount; // 총 작성 게시글 갯수
	private int replyCount; // 총 댓글 게시글 갯수
	private GradeVO gradeVO; // 등급객체
	
	public MemberVO() {
		super();
	}

	public MemberVO(String id, String password, String name, String sex, String email, String nick, String birthday,
			String regdate, int articleCount, int replyCount, GradeVO gradeVO) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.email = email;
		this.nick = nick;
		this.birthday = birthday;
		this.regdate = regdate;
		this.articleCount = articleCount;
		this.replyCount = replyCount;
		this.gradeVO = gradeVO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public GradeVO getGradeVO() {
		return gradeVO;
	}

	public void setGradeVO(GradeVO gradeVO) {
		this.gradeVO = gradeVO;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", sex=" + sex + ", email=" + email
				+ ", nick=" + nick + ", birthday=" + birthday + ", regdate=" + regdate + ", articleCount="
				+ articleCount + ", replyCount=" + replyCount + ", gradeVO=" + gradeVO + "]";
	}

	
	
}

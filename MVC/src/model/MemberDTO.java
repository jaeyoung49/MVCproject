package model;

/*create table member(
id varchar2(50) primary key,
pw varchar2(50) not null,
m_name varchar2(50) not null,
sex varchar2(20) not null,
email varchar2(100) not null,
nickname varchar2(100) not null,
birthday varchar2(20) not null,
m_regdate date not null,
a_count number default 0,
r_count number default 0,
m_gradeno number default 1,
constraint fk_member foreign key(m_gradeno) references m_grade(m_gradeno)*/

public class MemberDTO {
	private String id; // 아이디
	private String pw; // 패스워드
	private String m_name; // 성명
	private String sex; // 성별
	private String email; // 이메일
	private String nickname; // 닉네임
	private String birthday;
	private String m_regdate; // 가입일자
	private int a_count; // 총 작성 게시글 갯수
	private int r_count; // 총 댓글 게시글 갯수
	private int m_gradeno; // 회원등급
	private String m_grade_name; // 회원등급명
	// 기본 생성자

	public MemberDTO() {
		super();
	}

	public MemberDTO(String id, String m_name, String sex, String email, String nickname, String m_regdate, int a_count,
			int r_count, int m_gradeno, String m_grade_name) {
		super();
		this.id = id;
		this.m_name = m_name;
		this.sex = sex;
		this.email = email;
		this.nickname = nickname;
		this.m_regdate = m_regdate;
		this.a_count = a_count;
		this.r_count = r_count;
		this.m_gradeno = m_gradeno;
		this.m_grade_name = m_grade_name;
	}

	// 로그인시 기본으로 가져오는 정보(id,m_name,nickname,m_gradeno)
	public MemberDTO(String id, String m_name, String nickname, String m_grade_name) {
		super();
		this.id = id;
		this.m_name = m_name;
		this.nickname = nickname;
		this.m_grade_name = m_grade_name;
	}

	// 회원가입 시 아이디 체크 사항
	public MemberDTO(String id, String nickname) {
		super();
		this.id = id;
		this.nickname = nickname;
	}

	// 회원가입 시 기본 입력 사항 (가입일자 sysdate/ 게시글 갯수는 default 0 / 회원등급은 default 1)
	public MemberDTO(String id, String pw, String m_name, String sex, String email, String nickname, String birthday) {
		super();
		this.id = id;
		this.pw = pw;
		this.m_name = m_name;
		this.sex = sex;
		this.email = email;
		this.nickname = nickname;
		this.birthday = birthday;
	}

	// 회원정보 조회 시 생성자
	public MemberDTO(String id, String pw, String m_name, String sex, String email, String nickname, String m_regdate,
			int a_count, int r_count, int m_gradeno, String m_grade_name) {
		super();
		this.id = id;
		this.pw = pw;
		this.m_name = m_name;
		this.sex = sex;
		this.email = email;
		this.nickname = nickname;
		this.m_regdate = m_regdate;
		this.a_count = a_count;
		this.r_count = r_count;
		this.m_gradeno = m_gradeno;
		this.m_grade_name = m_grade_name;
	}

	public MemberDTO(String nickname) {
		super();
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getM_regdate() {
		return m_regdate;
	}

	public void setM_regdate(String m_regdate) {
		this.m_regdate = m_regdate;
	}

	public int getA_count() {
		return a_count;
	}

	public void setA_count(int a_count) {
		this.a_count = a_count;
	}

	public int getR_count() {
		return r_count;
	}

	public void setR_count(int r_count) {
		this.r_count = r_count;
	}

	public int getM_gradeno() {
		return m_gradeno;
	}

	public void setM_gradeno(int m_gradeno) {
		this.m_gradeno = m_gradeno;
	}

	public String getM_grade_name() {
		return m_grade_name;
	}

	public void setM_grade_name(String m_grade_name) {
		this.m_grade_name = m_grade_name;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", m_name=" + m_name + ", sex=" + sex + ", email=" + email
				+ ", nickname=" + nickname + ", birthday=" + birthday + ", m_regdate=" + m_regdate + ", a_count="
				+ a_count + ", r_count=" + r_count + ", m_gradeno=" + m_gradeno + ", m_grade_name=" + m_grade_name
				+ "]";
	}
}

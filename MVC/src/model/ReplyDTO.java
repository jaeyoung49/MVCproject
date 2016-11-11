package model;

public class ReplyDTO {
	private int r_no;
	private int a_no;
	private String r_regdate;
	private String r_content;
	private MemberDTO memberDTO;
	
	public ReplyDTO() {
		super();
	}
	public ReplyDTO(int r_no, int a_no, String r_regdate, String r_content, MemberDTO memberDTO) {
		super();
		this.r_no = r_no;
		this.a_no = a_no;
		this.r_regdate = r_regdate;
		this.r_content = r_content;
		this.memberDTO = memberDTO;
	}

	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	public String getR_regdate() {
		return r_regdate;
	}
	public void setR_regdate(String r_regdate) {
		this.r_regdate = r_regdate;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	@Override
	public String toString() {
		return "ReplyDTO [r_no=" + r_no + ", a_no=" + a_no + ", r_regdate=" + r_regdate + ", r_content=" + r_content
				+ ", memberDTO=" + memberDTO + "]";
	}
	
	
	
}

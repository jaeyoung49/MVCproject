package model;

public class C_Category {
	private int c_c_no;
	private String c_c_name;

	public C_Category() {
		super();
	}

	public C_Category(int c_c_no, String c_c_name) {
		super();
		this.c_c_no = c_c_no;
		this.c_c_name = c_c_name;
	}

	public int getC_c_no() {
		return c_c_no;
	}

	public void setC_c_no(int c_c_no) {
		this.c_c_no = c_c_no;
	}

	public String getC_c_name() {
		return c_c_name;
	}

	public void setC_c_name(String c_c_name) {
		this.c_c_name = c_c_name;
	}

	@Override
	public String toString() {
		return "C_Category [c_c_no=" + c_c_no + ", c_c_name=" + c_c_name + "]";
	}

}

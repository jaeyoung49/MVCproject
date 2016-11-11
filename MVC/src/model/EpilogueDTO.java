package model;

/*a_no number not null, -- 게시글 번호
c_c_no number not null, -- 화장품 카테고리 번호
e_favorite number default 0, -- 추천수
image_path varchar2(100), -- 이미지 경로
file_name varchar2(100), -- 파일 이름
file_ext varchar2(100), -- 파일 확장자*/
public class EpilogueDTO {
	private int c_c_no;
	private String image_path;
	private String file_name;
	private String file_ext;
	private int e_favorite;
	private MemberDTO memberDTO;
	private ArticleDTO articleDTO;
	private C_Category c_category;

	public EpilogueDTO() {
		super();
	}

	public EpilogueDTO(C_Category c_category) {
		super();
		this.c_category = c_category;
	}

	public EpilogueDTO(MemberDTO memberDTO) {
		super();
		this.memberDTO = memberDTO;
	}

	public EpilogueDTO(MemberDTO memberDTO, ArticleDTO articleDTO) {
		super();
		this.memberDTO = memberDTO;
		this.articleDTO = articleDTO;
	}

	public EpilogueDTO(ArticleDTO articleDTO, int c_c_no, String file_name, String file_ext) {
		this.articleDTO = articleDTO;
		this.c_c_no = c_c_no;
		this.file_name = file_name;
		this.file_ext = file_ext;
	}

	public EpilogueDTO(MemberDTO memberDTO, ArticleDTO articleDTO, int c_c_no, String image_path, String file_name,
			String file_ext) {
		super();
		this.c_c_no = c_c_no;
		this.image_path = image_path;
		this.file_name = file_name;
		this.file_ext = file_ext;
		// this.e_favorite = e_favorite;
		this.memberDTO = memberDTO;
		this.articleDTO = articleDTO;
	}

	public int getC_c_no() {
		return c_c_no;
	}

	public void setC_c_no(int c_c_no) {
		this.c_c_no = c_c_no;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_ext() {
		return file_ext;
	}

	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}

	public int getE_favorite() {
		return e_favorite;
	}

	public void setE_favorite(int e_favorite) {
		this.e_favorite = e_favorite;
	}

	public MemberDTO getMemberDTO() {
		return memberDTO;
	}

	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	public ArticleDTO getArticleDTO() {
		return articleDTO;
	}

	public void setArticleDTO(ArticleDTO articleDTO) {
		this.articleDTO = articleDTO;
	}

	public C_Category getC_category() {
		return c_category;
	}

	public void setC_category(C_Category c_category) {
		this.c_category = c_category;
	}

}

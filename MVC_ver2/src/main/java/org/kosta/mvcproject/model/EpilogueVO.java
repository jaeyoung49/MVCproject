package org.kosta.mvcproject.model;

public class EpilogueVO {
	private ArticleVO articleVO;
	private CosmeticCategoryVO cosmeticCategoryVO;
	private String imagePath;
	private String fileName;
	private String fileExt;
	
	public EpilogueVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EpilogueVO(ArticleVO articleVO, CosmeticCategoryVO cosmeticCategoryVO, String imagePath, String fileName,
			String fileExt) {
		super();
		this.articleVO = articleVO;
		this.cosmeticCategoryVO = cosmeticCategoryVO;
		this.imagePath = imagePath;
		this.fileName = fileName;
		this.fileExt = fileExt;
	}

	public ArticleVO getArticleVO() {
		return articleVO;
	}

	public void setArticleVO(ArticleVO articleVO) {
		this.articleVO = articleVO;
	}

	public CosmeticCategoryVO getCosmeticCategoryVO() {
		return cosmeticCategoryVO;
	}

	public void setCosmeticCategoryVO(CosmeticCategoryVO cosmeticCategoryVO) {
		this.cosmeticCategoryVO = cosmeticCategoryVO;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	@Override
	public String toString() {
		return "EpilogueVO [articleVO=" + articleVO + ", cosmeticCategoryVO=" + cosmeticCategoryVO + ", imagePath="
				+ imagePath + ", fileName=" + fileName + ", fileExt=" + fileExt + "]";
	}
	
	
}

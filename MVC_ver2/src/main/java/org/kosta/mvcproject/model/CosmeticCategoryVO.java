package org.kosta.mvcproject.model;

public class CosmeticCategoryVO {
	private int cosmeticCategoryNo;
	private String cosmeticCategoryName;
	
	public CosmeticCategoryVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CosmeticCategoryVO(int cosmeticCategoryNo, String cosmeticCategoryName) {
		super();
		this.cosmeticCategoryNo = cosmeticCategoryNo;
		this.cosmeticCategoryName = cosmeticCategoryName;
	}

	public int getCosmeticCategoryNo() {
		return cosmeticCategoryNo;
	}

	public void setCosmeticCategoryNo(int cosmeticCategoryNo) {
		this.cosmeticCategoryNo = cosmeticCategoryNo;
	}

	public String getCosmeticCategoryName() {
		return cosmeticCategoryName;
	}

	public void setCosmeticCategoryName(String cosmeticCategoryName) {
		this.cosmeticCategoryName = cosmeticCategoryName;
	}

	@Override
	public String toString() {
		return "CosmeticCategoryVO [cosmeticCategoryNo=" + cosmeticCategoryNo + ", cosmeticCategoryName="
				+ cosmeticCategoryName + "]";
	}
	
	
	
}

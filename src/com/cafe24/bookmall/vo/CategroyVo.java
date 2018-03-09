package com.cafe24.bookmall.vo;

public class CategroyVo {
	private int no;
	private String category;

	public CategroyVo() {
	}

	public CategroyVo(int no, String category) {
		super();
		this.no = no;
		this.category = category;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CategroyVo [no=" + no + ", category=" + category + "]";
	}

}

package com.cafe24.bookmall.vo;

public class BookVo {
	private int no;
	private String tittle;
	private int price;
	private CategroyVo cvo;

	// private int categoryNo;
	// 카테고리 번호

	public BookVo() {
	}

	public CategroyVo getCvo() {
		return cvo;
	}

	public void setCvo(CategroyVo cvo) {
		this.cvo = cvo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", tittle=" + tittle + ", price=" + price + ", cvo=" + cvo + "]";
	}

}

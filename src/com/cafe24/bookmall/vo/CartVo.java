package com.cafe24.bookmall.vo;

public class CartVo {
	private int count;
	private int member_no;
	private BookVo vo;

	public BookVo getVo() {
		return vo;
	}

	public void setVo(BookVo vo) {
		this.vo = vo;
	}

	public CartVo() {
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	@Override
	public String toString() {
		return "CartVo [count=" + count + ", member_no=" + member_no + ", vo=" + vo + "]";
	}

}

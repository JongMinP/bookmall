package com.cafe24.bookmall.vo;

public class OrderBookVo {
	private int no;
	private int count;
	private int order_no;
	// private int book_no;
	private BookVo bvo;

	public OrderBookVo() {
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public BookVo getBvo() {
		return bvo;
	}

	public void setBvo(BookVo bvo) {
		this.bvo = bvo;
	}

	@Override
	public String toString() {
		return "OrderBookVo [no=" + no + ", count=" + count + ", order_no=" + order_no + ", bvo=" + bvo + "]";
	}

}

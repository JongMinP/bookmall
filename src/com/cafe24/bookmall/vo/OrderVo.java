package com.cafe24.bookmall.vo;

import java.util.List;

public class OrderVo {
	private int no;
	private int price;
	private String address;
	private int member_no;
	private List<OrderBookVo> list;

	public OrderVo() {
	}

	public List<OrderBookVo> getList() {
		return list;
	}

	public void setList(List<OrderBookVo> list) {
		this.list = list;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", price=" + price + ", address=" + address + ", member_no=" + member_no
				+ ", list=" + list + "]";
	}

}

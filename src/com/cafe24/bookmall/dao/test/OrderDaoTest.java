package com.cafe24.bookmall.dao.test;

import java.util.List;

import com.cafe24.bookmall.dao.BookDao;
import com.cafe24.bookmall.dao.OrderDao;
import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.OrderBookVo;
import com.cafe24.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {

		// insert(1);
//		insertOrderBook();
//		 getList(1);

	}

	public static void insertOrderBook() {
		OrderDao dao = new OrderDao();

		OrderBookVo obv = new OrderBookVo();
		BookDao bdao = new BookDao();

		obv.setCount(1);
		obv.setOrder_no(1);

		BookVo bvo = bdao.getBook(1);

		obv.setBvo(bvo);

		System.out.println(obv.toString());

		dao.orderBookinsert(obv);

	}

	public static void insert(int memberNo) {
		OrderDao dao = new OrderDao();
		OrderVo vo = new OrderVo();

		vo.setAddress("as");
		vo.setMember_no(memberNo);
		vo.setPrice(10000);
		dao.insert(vo);

	}

	public static void getList(int memberNo) {
		OrderDao dao = new OrderDao();

		List<OrderVo> list = dao.getList(memberNo);

		for (OrderVo vo : list) {
			System.out.println(vo);
		}

	}

}

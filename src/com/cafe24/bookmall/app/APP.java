package com.cafe24.bookmall.app;

import java.util.List;

import com.cafe24.bookmall.dao.BookDao;
import com.cafe24.bookmall.dao.CartDao;
import com.cafe24.bookmall.dao.CategoryDao;
import com.cafe24.bookmall.dao.MemberDao;
import com.cafe24.bookmall.dao.OrderDao;
import com.cafe24.bookmall.dao.test.BookDaoTest;
import com.cafe24.bookmall.dao.test.CartDaoTest;
import com.cafe24.bookmall.dao.test.CategoryDaoTest;
import com.cafe24.bookmall.dao.test.MemberDaoTest;
import com.cafe24.bookmall.dao.test.OrderDaoTest;
import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.CartVo;
import com.cafe24.bookmall.vo.CategroyVo;
import com.cafe24.bookmall.vo.MemberVo;
import com.cafe24.bookmall.vo.OrderBookVo;
import com.cafe24.bookmall.vo.OrderVo;

public class APP {

	public static void main(String[] args) {

		CategoryDaoTest.insert(); // 카테고리 삽입

		BookDaoTest.insert(); // 북 삽입

		MemberDaoTest.insert(); // 고객 데이터 삽입

		CartDaoTest.insert(); // 카트 데이터 삽입

		OrderDaoTest.insert(1); // 주문 데이터 삽입
		OrderDaoTest.insertOrderBook(); // 주문 북 데이터 삽입
		
		// 실행하면 바로됩니다.

		System.out.println("------------------------회원 리스트--------------------------");

		MemberDao mDao = new MemberDao();

		List<MemberVo> list = mDao.getList();

		for (MemberVo vo : list) {
			System.out.println(vo);
		}

		System.out.println(
				"----------------------------------------------------------------------------------------------------");

		System.out.println("------------------------카테고리 리스트--------------------------");

		CategoryDao cDao = new CategoryDao();
		List<CategroyVo> cList = cDao.getList();

		for (CategroyVo vo : cList) {
			System.out.println(vo);
		}

		System.out.println(
				"----------------------------------------------------------------------------------------------------");
		System.out.println("------------------------상품 리스트--------------------------");

		BookDao bDao = new BookDao();
		List<BookVo> bList = bDao.getBookList();

		for (BookVo vo : bList) {
			System.out.println(vo);
		}

		System.out.println(
				"----------------------------------------------------------------------------------------------------");

		System.out.println("------------------------카트 리스트--------------------------");
		CartDao caDao = new CartDao();
		for (MemberVo vo : list) {
			List<CartVo> caList = caDao.getList(vo.getNo());
			for (CartVo cvo : caList) {
				System.out.println(cvo);
			}

		}

		System.out.println(
				"----------------------------------------------------------------------------------------------------");

		System.out.println("------------------------주문 리스트--------------------------");

		OrderDao oDao = new OrderDao();
		for (MemberVo vo : list) {
			List<OrderVo> oList = oDao.getList(vo.getNo());
			for (OrderVo vv : oList) {
				System.out.println(vv);
			}
		}
		System.out.println(
				"----------------------------------------------------------------------------------------------------");
		System.out.println("------------------------주문 도서 리스트--------------------------");

		for (MemberVo vo : list) {
			List<OrderVo> oList = oDao.getList(vo.getNo());
			for (OrderVo oVo : oList) {
				List<OrderBookVo> oBvo = oDao.orderBookList(oVo.getNo());
				for (OrderBookVo ov : oBvo) {
					System.out.println(ov);
				}
			}
		}

	}

}

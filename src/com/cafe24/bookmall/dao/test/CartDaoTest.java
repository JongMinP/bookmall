package com.cafe24.bookmall.dao.test;

import java.util.List;

import com.cafe24.bookmall.dao.BookDao;
import com.cafe24.bookmall.dao.CartDao;
import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.CartVo;

public class CartDaoTest {
	
	
	public static void main(String[] args) {
		
//		insert();
		getList();
	}
	
	public static void getList() {
		CartDao dao = new CartDao();
		
		List<CartVo> list =  dao.getList(1);
		
		for(CartVo vo : list) {
			System.out.println(vo.toString());
		}
		
	}
	
	public static void insert() {
		CartDao dao = new CartDao();
		BookDao bDao = new  BookDao();
		
		CartVo vo = new CartVo();
		vo.setCount(1);
		vo.setMember_no(1);
		BookVo bvo = bDao.getBook(1);
//		
		vo.setVo(bvo);
//		
		dao.insert(vo);
		
		
		CartVo vvo = new CartVo();
		vvo.setCount(2);
		vvo.setMember_no(2);
		BookVo bbvo = bDao.getBook(2);
		
		vvo.setVo(bbvo);
		
		dao.insert(vvo);
		
		
	}

}

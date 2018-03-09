package com.cafe24.bookmall.dao.test;

import java.util.List;

import com.cafe24.bookmall.dao.BookDao;
import com.cafe24.bookmall.dao.CategoryDao;
import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.CategroyVo;

public class BookDaoTest {
	private static BookDao dao;

	public static void main(String[] args) {
		// insert();
		getList();
		// getBook(1);
	}

	public static void insert() {
		BookVo vo = new BookVo();

		dao = new BookDao();

		CategoryDao cDao = new CategoryDao();
		cDao.getCategory(1);

		vo.setPrice(10000);
		vo.setTittle("아프니까 청춘이다");
		vo.setCvo(cDao.getCategory(1));

		dao.insert(vo);

		vo.setPrice(20000);
		vo.setTittle("뉴문");
		vo.setCvo(cDao.getCategory(2));

		dao.insert(vo);

		vo.setPrice(30000);
		vo.setTittle("이것이 자바다");
		vo.setCvo(cDao.getCategory(3));

		dao.insert(vo);

	}

	public static void getList() {
		dao = new BookDao();

		List<BookVo> list = dao.getBookList();

		for (BookVo vo : list) {
			System.out.println(vo.toString());
		}

	}

	public static void getBook(int no) {
		dao = new BookDao();

		BookVo vo = dao.getBook(no);

		System.out.println(vo.toString());

	}

}

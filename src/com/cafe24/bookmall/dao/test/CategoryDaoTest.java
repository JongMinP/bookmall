package com.cafe24.bookmall.dao.test;

import java.util.List;

import com.cafe24.bookmall.dao.CategoryDao;
import com.cafe24.bookmall.vo.CategroyVo;

public class CategoryDaoTest {
	private static CategoryDao dao;

	public static void main(String[] args) {
//		insert();
		getList();
//		getCategory(1);

	}

	public static void insert() {
		CategroyVo vo = new CategroyVo();
		dao = new CategoryDao();

		 vo.setCategory("소설");
		 dao.insert(vo);
		 vo.setCategory("수필");
		 dao.insert(vo);
		 vo.setCategory("컴퓨터");
		 dao.insert(vo);


	}

	public static void getList() {

		dao = new CategoryDao();
		List<CategroyVo> list = dao.getList();

		for (CategroyVo vo : list) {
			System.out.println(vo.toString());
		}

	}

	public static void getCategory(int no) {
		dao = new CategoryDao();

		CategroyVo vo = dao.getCategory(no);

		System.out.println(vo.toString());

	}

}

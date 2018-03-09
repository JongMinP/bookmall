package com.cafe24.bookmall.dao.test;

import java.util.List;

import com.cafe24.bookmall.dao.MemberDao;
import com.cafe24.bookmall.vo.MemberVo;

public class MemberDaoTest {
	private static MemberDao dao;

	public static void main(String[] args) {

		// insert();
		getList();
		// getMember(1);
	}

	public static void insert() {
		MemberVo vo = new MemberVo();

		dao = new MemberDao();

		vo.setEmail("123@naver.com");
		vo.setName("둘리");
		vo.setPhone("010-2322-2133");
		vo.setPassword("asdf1232");

		dao.insert(vo);

		vo.setEmail("sadsaw@gmail.com");
		vo.setName("마이콜");
		vo.setPhone("010-3414-2132");
		vo.setPassword("akdlzhf123");

		dao.insert(vo);

		vo.setEmail("ehdnsjt@naver.com");
		vo.setName("도우넛");
		vo.setPhone("010-5345-7777");
		vo.setPassword("도우넛");

		dao.insert(vo);
	}

	public static void getList() {

		dao = new MemberDao();

		List<MemberVo> list = dao.getList();

		for (MemberVo vo : list) {
			System.out.println(vo.toString());
		}

	}

	public static void getMember(int no) {
		dao = new MemberDao();

		System.out.println(dao.getMember(no));

	}

}

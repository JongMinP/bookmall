package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.util.AutoClose;
import com.cafe24.bookmall.util.ConnectionFactroy;
import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.CategroyVo;

public class BookDao {

	public List<BookVo> getBookList() {
		List<BookVo> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();

			sql.append("select b.no,b.title,b.price,b.category_no,c.category ");
			sql.append("from book b , category c ");
			sql.append("where b.category_no = c.no ");

			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookVo vo = new BookVo();
				vo.setNo(rs.getInt(1));
				vo.setTittle(rs.getString(2));
				vo.setPrice(Integer.parseInt(rs.getString(3)));
				CategroyVo cvo = new CategroyVo(rs.getInt(4),rs.getString(5));
				vo.setCvo(cvo);
//				vo.setCategoryNo(Integer.parseInt(rs.getString(4)));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AutoClose.closeResource(rs, pstmt, conn);
		}

		return list;

	}

	public boolean insert(BookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		
		try {
			conn = ConnectionFactroy.getInstance().createConnection();
			sql.append("insert into book ");
			sql.append("values(null,?,?,?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, vo.getTittle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3,vo.getCvo().getNo());
			
			int count = pstmt.executeUpdate();
			
			result = (count == 1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public BookVo getBook(int no) {
		BookVo vo = new BookVo();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();

			sql.append("select b.no,b.title,b.price,b.category_no, c.category ");
			sql.append("from book b , category c ");
			sql.append("where b.no = ? ");
			sql.append("and b.category_no = c.no ");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				vo.setNo(rs.getInt(1));
				vo.setTittle(rs.getString(2));
				vo.setPrice(Integer.parseInt(rs.getString(3)));
				CategroyVo cvo = new CategroyVo(rs.getInt(4),rs.getString(5));
				vo.setCvo(cvo);
//				vo.setCategoryNo(Integer.parseInt(rs.getString(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AutoClose.closeResource(rs, pstmt, conn);
		}

		return vo;

	}

}

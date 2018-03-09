package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.util.ConnectionFactroy;
import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.CartVo;
import com.cafe24.bookmall.vo.CategroyVo;

public class CartDao {

	public List<CartVo> getList(int memberNo) {
		List<CartVo> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();
			sql.append("select c.count, c.member_no, c.book_no, b.title, b.price, b.category_no, ca.category ");
			sql.append("from cart c, book b, category ca ");
			sql.append("where c.book_no = b.no ");
			sql.append("and ca.no = b.category_no and c.member_no = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				CartVo vo = new CartVo();
				vo.setCount(rs.getInt(1));
				vo.setMember_no(rs.getInt(2));
				BookVo bvo = new BookVo();
				bvo.setNo(rs.getInt(3));
				bvo.setTittle(rs.getString(4));
				bvo.setPrice(rs.getInt(5));
				CategroyVo cavo = new CategroyVo();
				cavo.setNo(rs.getInt(6));
				cavo.setCategory(rs.getString(6));
				bvo.setCvo(cavo);
				vo.setVo(bvo);

				list.add(vo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean insert(CartVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();
			sql.append("insert into cart ");
			sql.append("values(?,?,?) ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, vo.getCount());
			pstmt.setInt(2, vo.getMember_no());
			pstmt.setInt(3, vo.getVo().getNo());

			int count = pstmt.executeUpdate();

			result = (count == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}

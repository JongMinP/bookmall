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
import com.cafe24.bookmall.vo.OrderBookVo;
import com.cafe24.bookmall.vo.OrderVo;

public class OrderDao {

	public List<OrderVo> getList(int memberNo) {
		List<OrderVo> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();

			sql.append("select o.no, o.price, o.address, o.member_no ");
			sql.append("from order_table o , order_book ob ");
			sql.append("where o.member_no = ? ");
			sql.append("and o.no = ob.order_no");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrderVo vo = new OrderVo();
				vo.setNo(rs.getInt(1));
				vo.setPrice(rs.getInt(2));
				vo.setAddress(rs.getString(3));
				vo.setMember_no(memberNo);
				vo.setList(orderBookList(rs.getInt(1)));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AutoClose.closeResource(rs, pstmt, conn);
		}

		return list;

	}

	public List<OrderBookVo> orderBookList(int order_no) {
		List<OrderBookVo> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();

			sql.append("select ob.no,ob.count,ob.book_no,b.title, b.price, c.no, c.category ");
			sql.append("from order_book ob, book b, category c ");
			sql.append("where order_no =? ");
			sql.append("and ob.book_no = b.no ");
			sql.append("and b.category_no = c.no ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, order_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrderBookVo obv = new OrderBookVo();
				obv.setNo(rs.getInt(1));
				obv.setCount(rs.getInt(2));
				obv.setOrder_no(order_no);

				BookVo bvo = new BookVo();
				bvo.setNo(rs.getInt(3));
				bvo.setTittle(rs.getString(4));
				bvo.setPrice(rs.getInt(5));

				CategroyVo cvo = new CategroyVo();
				cvo.setNo(rs.getInt(6));
				cvo.setCategory(rs.getString(7));

				bvo.setCvo(cvo);
				obv.setBvo(bvo);

				list.add(obv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AutoClose.closeResource(rs, pstmt, conn);
		}

		return list;

	}
	
	public boolean orderBookinsert(OrderBookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();
			sql.append("insert into order_book ");
			sql.append("values (null,?,?,?) ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, vo.getCount());
			pstmt.setInt(2, vo.getOrder_no());
			pstmt.setInt(3, vo.getBvo().getNo());
			
			int count = pstmt.executeUpdate();

			result = (count == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	

	public boolean insert(OrderVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();
			sql.append("insert into order_table ");
			sql.append("values (null,?,?,?) ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, vo.getPrice());
			pstmt.setString(2, vo.getAddress());
			pstmt.setInt(3, vo.getMember_no());
			int count = pstmt.executeUpdate();

			result = (count == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}

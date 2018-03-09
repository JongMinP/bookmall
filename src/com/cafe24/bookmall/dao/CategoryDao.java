package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.util.AutoClose;
import com.cafe24.bookmall.util.ConnectionFactroy;
import com.cafe24.bookmall.vo.CategroyVo;

public class CategoryDao {

	public boolean insert(CategroyVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();
			sql.append("insert into category ");
			sql.append("values(null,?) ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, vo.getCategory());

			int count = pstmt.executeUpdate();

			result = (count == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<CategroyVo> getList() {
		List<CategroyVo> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();

			sql.append("select no,category ");
			sql.append("from category ");

			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CategroyVo vo = new CategroyVo();

				vo.setNo(Integer.parseInt(rs.getString(1)));
				vo.setCategory(rs.getString(2));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AutoClose.closeResource(rs, pstmt, conn);
		}

		return list;

	}

	public CategroyVo getCategory(int no) {
		CategroyVo vo = new CategroyVo();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();

			sql.append("select no,category ");
			sql.append("from category ");
			sql.append("where no = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				vo.setNo(rs.getInt(1));
				vo.setCategory(rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AutoClose.closeResource(rs, pstmt, conn);
		}

		return vo;

	}

}

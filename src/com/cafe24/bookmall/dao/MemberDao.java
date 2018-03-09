package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.util.AutoClose;
import com.cafe24.bookmall.util.ConnectionFactroy;
import com.cafe24.bookmall.vo.MemberVo;

public class MemberDao {

	public List<MemberVo> getList() {
		List<MemberVo> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();

			sql.append("select no,email,phone,name ");
			sql.append("from member ");

			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVo vo = new MemberVo();

				vo.setNo(rs.getInt(1));
				vo.setEmail(rs.getString(2));
				vo.setPhone(rs.getString(3));
				vo.setName(rs.getString(4));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AutoClose.closeResource(rs, pstmt, conn);
		}

		return list;

	}

	public boolean insert(MemberVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();
			sql.append("insert into member ");
			sql.append("values(null,?,?,?,?)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPassword());

			int count = pstmt.executeUpdate();

			result = (count == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public MemberVo getMember(int no) {
		MemberVo vo = new MemberVo();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();

		try {
			conn = ConnectionFactroy.getInstance().createConnection();

			sql.append("select no,email,phone,name ");
			sql.append("from member ");
			sql.append("where no = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				vo.setNo(rs.getInt(1));
				vo.setEmail(rs.getString(2));
				vo.setPhone(rs.getString(3));
				vo.setName(rs.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AutoClose.closeResource(rs, pstmt, conn);
		}

		return vo;

	}

}

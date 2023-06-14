package com.yedam.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.Dao;

//입력, 수정, 삭제, 목록.
public class UserDao {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	public void close() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserVO search(String userId) {
		sql = "select * from tbl_users where user_id = ? ";
		conn = Dao.getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			if (rs.next()) { // 한 건 조회가 되면..
				UserVO user = new UserVO();
				user.setUserId(rs.getString("user_id"));
				user.setUserPw(rs.getString("user_pw"));
//				user.setUserName(rs.getString(""));
//				user.setUserBirth(rs.getString(""));
//				user.setUserPhone(rs.getString(""));
//				user.setUserAddr(rs.getString(""));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null; // 조회된 결과가 없으면 null반환.
	}

	public boolean add(UserVO user) {
		sql = "insert into tbl_users (user_id, user_pw, user_name)" + "values(?,?,?) ";
		conn = Dao.getConnect();
		try {
			psmt = conn.prepareStatement(sql); // == new UserDao(); 객체선언
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getUserPw());
			psmt.setString(3, user.getUserName());

			int r = psmt.executeUpdate(); // 쿼리실행
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	// 수정
	public boolean modify(UserVO user) {
		sql = "update tbl_users "//
				+ "set user_pw = nvl(?, user_pw),"//
				+ "	   user_name = nvl(?, user_name),"//
				+ "	   user_birth = nvl(?, user_birth),"//
				+ "    user_phone = nvl(?, user_phone),"//
				+ "	   user_addr = nvl(?, user_addr) " + "where user_id = ?"//
		;
		conn = Dao.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserPw());
			psmt.setString(2, user.getUserName());
			psmt.setString(3, user.getUserBirth());
			psmt.setString(4, user.getUserPhone());
			psmt.setString(5, user.getUserAddr());
			psmt.setString(6, user.getUserId());

			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	// 목록.
	public List<UserVO> list() {
		List<UserVO> list = new ArrayList<>();

		sql = "select * from tbl_users";
		conn = Dao.getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				UserVO user = new UserVO();
				user.setUserId(rs.getString("user_id"));
				user.setUserPw(rs.getString("user_pw"));
				user.setUserName(rs.getString("user_name"));
				user.setUserBirth(rs.getString("user_birth"));
				user.setUserAddr(rs.getString("user_addr"));
				user.setUserPhone(rs.getString("user_phone"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	// 삭제
	public boolean remove(UserVO user) {

		try {
//			conn.setAutoCommit(false);
			// A -> B송금 update A update B.
//			conn.commit();
			String sql = "delete tbl_users" + "	where 	user_id = ? ";
			conn = Dao.getConnect();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserId() );

			int r = psmt.executeUpdate();

			if (r > 0) {
				System.out.println("처리성공");
			} else {
				System.out.println("처리실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}


}
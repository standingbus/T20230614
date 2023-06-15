package com.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.Dao;



public class BoardDao {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//login check.  login_id == write
	
	
	
	
	
	public boolean add(BoardVO brd) {
		sql = "insert into tbl_board (brd_no, brd_title, brd_writer, brd_content )" + "values(board_seq.nextval,?,?,?) ";
		conn = Dao.getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, brd.getBrdTitle());
			psmt.setString(2, brd.getBrdWriter());
			psmt.setString(3, brd.getBrdContent());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	
	
	public boolean remove(BoardVO brd) {
		
		
		try {
			String sql = "delete tbl_board" + " where user_id = ?";
			conn = Dao.getConnect();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, brd.getBrdNo());
			
			int r = psmt.executeUpdate();
			
			if(r>0) {
				System.out.println("처리성공");
			} else {
				System.out.println("처리실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	public boolean modify(BoardVO brd) {
		sql = "update tbl_board "
				+"set brd_no = nvl(?, brd_no),"// 
				+"set brd_title = nvl(?, brd_title),"
				+"set brd_content = nvl(?, brd_content),"
				+"set brd_writer = nvl(?, brd_writer) " + "where user_id = ?"
				;
		conn = Dao.getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, brd.getBrdNo());
			psmt.setString(2, brd.getBrdTitle());
			psmt.setString(3, brd.getBrdContent());
			psmt.setString(4, brd.getBrdWriter());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	
	public List<BoardVO> list() {
		List<BoardVO> list = new ArrayList<>();

		sql = "select * from tbl_board";
		conn = Dao.getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardVO user = new BoardVO();
				user.setBrdNo(rs.getString("brd_no"));
				user.setBrdTitle(rs.getString("brd_title"));
				user.setBrdContent(rs.getString("brd_content"));
				user.setBrdWriter(rs.getString("brd_writer"));
				user.setDate(rs.getString("create_date"));
				user.setClick_cnt(rs.getInt("click_cnt"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	
	
	public BoardVO search(String brdNo) {
		sql = "select * from tbl_board where brd_no = ? ";
		String sql1 = 
				"update tbl_board "
				+ "set click_cnt = click_cnt +1 "
				+ "where brd_no = ? ";
		
		
		
		conn = Dao.getConnect();

		try {
			
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, brdNo);
			rs = psmt.executeQuery();
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, brdNo);
			rs = psmt.executeQuery();
			
			
			
			
			if (rs.next()) { // 한 건 조회가 되면..
				BoardVO user = new BoardVO();
				user.setBrdNo(rs.getString("brd_no"));
				user.setBrdTitle(rs.getString("brd_title"));
				user.setBrdContent(rs.getString("brd_content"));
				user.setBrdWriter(rs.getString("brd_writer"));
				user.setDate(rs.getString("create_date"));
				user.setClick_cnt(rs.getInt("click_cnt"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null; // 조회된 결과가 없으면 null반환.
	
	
	
	
	}	
	
	

}

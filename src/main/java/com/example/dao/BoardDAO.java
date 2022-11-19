package com.example.dao;

import com.example.bean.BoardVO;
import com.example.file.Fileupload;
import com.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BoardDAO {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	private final String BOARD_INSERT = "insert into custom (U_name, U_id, password, age, job, habit, photo, email) values (?,?,?,?,?,?,?,?)";
	private final String BOARD_UPDATE = "update custom set U_name=?, age=?, job=?, habit=?,photo=?,email=?  where seq=?";
	private final String BOARD_DELETE = "delete from custom where seq=?";
	private final String BOARD_GET = "select * from custom where seq=?";
	private final String BOARD_LIST = "select * from custom order by seq desc";

	private final String BOARD_UPFILE = "update custom set photo=? where seq=?";

	public int insertBoard(BoardVO vo ) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getName());
			stmt.setString(2,vo.getUserid());
			stmt.setString(3, vo.getPassword());
			stmt.setInt(4,vo.getAge());
			stmt.setString(5, vo.getJob());
			stmt.setString(6, vo.getHabit());
			stmt.setString(7, vo.getPhoto());

			stmt.setString(8,vo.getEmail());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			System.out.println(vo.getSeq());
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateBoard(BoardVO vo) {

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getName());
			stmt.setInt(2,vo.getAge());
			stmt.setString(3, vo.getJob());
			stmt.setString(4, vo.getHabit());
			stmt.setString(5, vo.getPhoto());
			stmt.setString(6,vo.getEmail());

			stmt.setInt(7, vo.getSeq());
			
			
			System.out.println(vo.getName() + "-" + vo.getAge() + "-" + vo.getJob() + "-"+vo.getHabit() + "-" + "-"+ vo.getSeq());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
	public BoardVO getBoard(int seq) {
		BoardVO one = new BoardVO();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSeq(rs.getInt("seq"));
				one.setName(rs.getString("U_name"));
				one.setUserid(rs.getString("U_id"));
				one.setPassword(rs.getString("password"));
				one.setAge(rs.getInt("age"));
				one.setJob(rs.getString("job"));
				one.setHabit(rs.getString("habit"));
				one.setPhoto(rs.getString("photo"));
				one.setEmail(rs.getString("email"));
				one.setCnt(rs.getInt("cnt"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}
	
	public List<BoardVO> getBoardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO one = new BoardVO();
				one.setSeq(rs.getInt("seq"));
				one.setName(rs.getString("U_name"));
				one.setAge(rs.getInt("age"));
				one.setJob(rs.getString("job"));
				one.setPhoto(rs.getString("photo"));
				one.setHabit(rs.getString("habit"));
				one.setRegdate(rs.getDate("regdate"));
				one.setCnt(rs.getInt("cnt"));
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	public String getPhotoFilename(int seq){

		String fileName = "";
		BoardVO one = new BoardVO();

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			fileName =rs.getString("photo");

			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileName;
	}

	public void uploadFile(BoardVO vo,String Realpath){

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPFILE);
			stmt.setString(1, Realpath);
			stmt.setInt(2 ,vo.getSeq());

			System.out.println(Realpath);
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

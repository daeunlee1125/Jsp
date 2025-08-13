package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.User1DTO;

// DAO(Data Access Object) : DB 처리를 수행하는 객체 
public class User1DAO {
	// 싱글톤
	private final static User1DAO INSTANCE = new User1DAO();
	public static User1DAO getInstance() {
		return INSTANCE;
	}
	private User1DAO() {}
	
	//기본 CRUD 메서드
	public void insertUser1(User1DTO dto) {
		try {
			//Connection conn = DriverManager.getConnection(null);
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/daeunlee1125");
			
			Connection conn = ds.getConnection();
			
			String sql = "INSERT INTO USER1 VALUES (?,?,?,?)";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setInt(4, dto.getAge());
			
			psmt.executeUpdate();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public User1DTO selectUser1(String user_id) {
		
		User1DTO dto = null;
		try {
			//Connection conn = DriverManager.getConnection(null);
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/daeunlee1125");
			
			Connection conn = ds.getConnection();
			
			
			String sql = "SELECT * FROM USER1 WHERE user_id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			ResultSet rs = psmt.executeQuery();
			
			
			
			if (rs.next()) {
				dto = new User1DTO();
				dto.setUser_id(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getString(4));
			}


			conn.close();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
		
	}
	public List<User1DTO> selectAllUser1() {
		
		List<User1DTO> dtoList = new ArrayList<User1DTO>();
		try {
			//Connection conn = DriverManager.getConnection(null);
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/daeunlee1125");
			
			Connection conn = ds.getConnection();
			
			
			
			java.sql.Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM USER1";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				User1DTO dto =new User1DTO();
				dto.setUser_id(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getString(4));
				
				dtoList.add(dto);
			}

			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
		
	}
	public void updateUser1(User1DTO dto) {
		try {
			//Connection conn = DriverManager.getConnection(null);
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/daeunlee1125");
			
			Connection conn = ds.getConnection();
			String sql = "UPDATE USER1 SET name=?, hp=?, age=? WHERE user_id=?";
			
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHp());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getUser_id());
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteUser1(String user_id) {
		try {
			//Connection conn = DriverManager.getConnection(null);
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/daeunlee1125");
			
			Connection conn = ds.getConnection();
			List<User1DTO> dtoList = new ArrayList<User1DTO>();
			
			
			java.sql.Statement stmt = conn.createStatement();
			
			String sql = "DELETE FROM USER1 WHERE user_id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

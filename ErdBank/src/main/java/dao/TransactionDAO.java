package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TransactionDTO;
import util.DBHelper;
import util.Sql;

public class TransactionDAO extends DBHelper{
	private static final TransactionDAO INSTANCE = new TransactionDAO();

	public static TransactionDAO getInstance() {
		return INSTANCE;
	}
	private TransactionDAO() {}
	
	
	public TransactionDTO select(String t_no) {
		return null;
	}
	
	
	public List<TransactionDTO> selectAll(){
		List<TransactionDTO> dtoList = new ArrayList<TransactionDTO>();
		
		try {
			conn = getConnection();
			String sql = "SELECT * from BANK_TRANSACTION";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				TransactionDTO trdto = new TransactionDTO();
				trdto.setT_no(rs.getInt(1));
				trdto.setT_a_no(rs.getString(2));
				trdto.setT__dist(rs.getInt(3));
				trdto.setT_amount(rs.getInt(4));
				trdto.setT_datetime(rs.getString(5));
				
				dtoList.add(trdto);
			}
			
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		
		}
		
		
		return dtoList;
	}
	
	public void insertAndUpdate(TransactionDTO dto) {
		try {
			conn = getConnection();
			conn.setAutoCommit(false); // 자동커밋 해제! 트랜잭션 시작
			
			psmt = conn.prepareStatement(Sql.INSERT_TRANSACTION);
			psmt.setString(1, dto.getT_a_no());
			psmt.setInt(2, dto.getT__dist());
			psmt.setInt(3, dto.getT_amount());
			psmt.executeUpdate();
			
			psmt1 = conn.prepareStatement(Sql.UPDATE_ACCOUNT_PLUS); //상대방 계좌
			psmt1.setInt(1, dto.getT_amount());
			psmt1.setString(2, dto.getT_a_no_to());
			psmt1.executeUpdate();
			
			psmt2 = conn.prepareStatement(Sql.UPDATE_ACCOUNT_MINUS); // 내 계좌
			psmt2.setInt(1, dto.getT_amount());
			psmt2.setString(2, dto.getT_a_no());
			psmt2.executeUpdate();
			
			conn.commit(); // psmt 세 개가 하나의 작업으로 처리된다!
			
			closeAll();
			
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void insert(TransactionDTO dto) {
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(Sql.INSERT_TRANSACTION);
			psmt.setString(1, dto.getT_a_no());
			psmt.setInt(2, dto.getT__dist());
			psmt.setInt(3, dto.getT_amount());
			psmt.executeUpdate();
			
			
			closeAll();
			
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void update(TransactionDTO dto) {}
	
	public void delete(String t_no) {}
}

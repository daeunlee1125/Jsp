
package dao;

import java.util.ArrayList;
import java.util.List;

import dto.AccountDTO;
import util.DBHelper;
import util.Sql;

public class AccountDAO extends DBHelper {
	private static final AccountDAO INSTANCE = new AccountDAO();

	public static AccountDAO getInstance() {
		return INSTANCE;
	}
	private AccountDAO() {}
	
	
	public AccountDTO select(String a_c_no) {
		AccountDTO dto = null;
		try {
			conn = getConnection();
			String sql = "SELECT * from BANK_ACCOUNT where a_c_no=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, a_c_no);
			
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setA_no(rs.getString(1));
				dto.setA_item_dist(rs.getString(2));
				dto.setA_item_name(rs.getString(3));
				dto.setA_c_no(rs.getString(4));
				dto.setA_balance(rs.getInt(5));
				dto.setA_open_date(rs.getString(6));
			}
			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public AccountDTO selectAcc(String a_no) {
		AccountDTO dto = null;
		try {
			conn = getConnection();
			String sql = "SELECT * from BANK_ACCOUNT where a_no=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, a_no);
			
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setA_no(rs.getString(1));
				dto.setA_item_dist(rs.getString(2));
				dto.setA_item_name(rs.getString(3));
				dto.setA_c_no(rs.getString(4));
				dto.setA_balance(rs.getInt(5));
				dto.setA_open_date(rs.getString(6));
			}
			
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public AccountDTO select(String c_no, String c_name) {
		
		AccountDTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_CUSTOMER_BY_NO_AND_NAME);
			psmt.setString(1, c_no);
			psmt.setString(2, c_name);
			
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setA_no(rs.getString(1));
				dto.setA_item_dist(rs.getString(2));
				dto.setA_item_name(rs.getString(3));
				dto.setA_c_no(rs.getString(4));
				dto.setA_balance(rs.getInt(5));
				dto.setA_open_date(rs.getString(6));
			}
			
			closeAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<AccountDTO> selectAll(){
		List<AccountDTO> dtoList = new ArrayList<>();
		
		try {
			conn = getConnection();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_ALL_ACCOUNT_WITH_NAME);
			
			while (rs.next()) {
				AccountDTO dto = new AccountDTO();
				dto.setA_no(rs.getString(1));
				dto.setA_item_dist(rs.getString(2));
				dto.setA_item_name(rs.getString(3));
				dto.setA_c_no(rs.getString(4));
				dto.setA_balance(rs.getInt(5));
				dto.setA_open_date(rs.getString(6));
				dto.setA_c_name(rs.getString(7));

				dtoList.add(dto);
			}
			
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		
		}
		
		
		return dtoList;
	}
	
	public void insert(AccountDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_ACCOUNT);
			psmt.setString(1, dto.getA_no());
			psmt.setString(2, dto.getA_item_dist());
			psmt.setString(3, dto.getA_item_name());
			psmt.setString(4, dto.getA_c_no());
			psmt.setInt(5, dto.getA_balance());
			psmt.executeUpdate();
			
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void plusBal(AccountDTO dto, int t_amount) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_ACCOUNT_PLUS);
			psmt.setInt(1, t_amount);
			psmt.setString(2, dto.getA_no());
			
			psmt.executeUpdate();
			
			closeAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void minusBal(AccountDTO dto, int t_amount) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_ACCOUNT_MINUS);
			psmt.setInt(1, t_amount);
			psmt.setString(2, dto.getA_no());
			
			psmt.executeUpdate();
			
			closeAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(String c_no) {}
}

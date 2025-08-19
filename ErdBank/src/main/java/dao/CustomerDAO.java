package dao;

import java.util.ArrayList;
import java.util.List;

import dto.CustomerDTO;
import util.DBHelper;
import util.Sql;

public class CustomerDAO extends DBHelper {
	private static final CustomerDAO INSTANCE = new CustomerDAO();

	public static CustomerDAO getInstance() {
		return INSTANCE;
	}
	private CustomerDAO() {}
	
	
	public CustomerDTO select(String c_no) {
		
		CustomerDTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_CUSTOMER_WITH_ACCOUNT_NO);
			psmt.setString(1, c_no);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new CustomerDTO();
				dto.setC_no(rs.getString(1));
				dto.setC_name(rs.getString(2));
				dto.setC_dist(rs.getInt(3));
				dto.setC_phone(rs.getString(4));
				dto.setC_addr(rs.getString(5));
				dto.setC_a_no(rs.getString(6));
			}
			
			closeAll();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return dto;
	}
	public CustomerDTO select(String c_no, String c_name) {
		
		CustomerDTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_CUSTOMER_BY_NO_AND_NAME);
			psmt.setString(1, c_no);
			psmt.setString(2, c_name);
			
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto = new CustomerDTO();
				dto.setC_no(rs.getString(1));
				dto.setC_name(rs.getString(2));
				dto.setC_dist(rs.getInt(3));
				dto.setC_phone(rs.getString(4));
				dto.setC_addr(rs.getString(5));
			}
			
			closeAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<CustomerDTO> selectAll(){
		List<CustomerDTO> dtoList = new ArrayList<CustomerDTO>();
		
		try {
			conn = getConnection();
			String sql = "SELECT * from BANK_CUSTOMER";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setC_no(rs.getString(1));
				dto.setC_name(rs.getString(2));
				dto.setC_dist(rs.getInt(3));
				dto.setC_phone(rs.getString(4));
				dto.setC_addr(rs.getString(5));
				
				dtoList.add(dto);
			}
			
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		
		}
		
		
		return dtoList;
	}
	
	public void insert(CustomerDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_CUSTOMER);
			psmt.setString(1, dto.getC_no());
			psmt.setString(2, dto.getC_name());
			psmt.setInt(3, dto.getC_dist());
			psmt.setString(4, dto.getC_phone());
			psmt.setString(5, dto.getC_addr());
			
			psmt.executeUpdate();
			
			closeAll();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(CustomerDTO dto) {}
	
	public void delete(String c_no) {}
}










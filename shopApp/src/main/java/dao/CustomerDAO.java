package dao;

import java.util.ArrayList;
import java.util.List;

import dto.CustomerDTO;
import util.DBHelper;

public class CustomerDAO extends DBHelper {
	private static final CustomerDAO INSTANCE = new CustomerDAO();
	
	public static CustomerDAO getInstance() {
		return INSTANCE;
	}
	private CustomerDAO() {}
	
	private final String DBCP = "jdbc/shopERD";
	
	public void insertCustomer(CustomerDTO dto) {
		try {
			
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO customer values (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getCustId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setString(4, dto.getAddr());
			psmt.setString(5, dto.getRdate());
			
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public CustomerDTO selectCustomer(String custId) {
		CustomerDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			String sql = "SELECT * from CUSTOMER where custid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, custId);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto = new CustomerDTO();
				dto.setCustId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAddr(rs.getString(4));
				dto.setRdate(rs.getString(5));
				
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	public List<CustomerDTO> selectAllCustomer(){
		List<CustomerDTO> CustomerList = new ArrayList<>();
		
		
		
		
		return CustomerList;
	}
	
	public void updateCustomer(CustomerDTO dto) {
		
		try {
			conn = getConnection(DBCP);
			String sql = "UPDATE user1 set name=?, hp=?, age=? where uid=?";
			psmt = conn.prepareStatement(sql);
			

			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteCustomer(String custid) {
		try {
			conn = getConnection(DBCP);

			
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

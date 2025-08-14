package dao;

import java.util.ArrayList;
import java.util.List;

import dto.RegisterDTO;
import util.DBHelper;

public class RegisterDAO extends DBHelper{
	private static final RegisterDAO INSTANCE = new RegisterDAO();

	public static RegisterDAO getInstance() {
		return INSTANCE;
	}
	private RegisterDAO() {}
	
	public RegisterDTO select(int regStdNo, int regLecNo) {
		return null;
	}
	public List<RegisterDTO> selectAll() {
		List<RegisterDTO> dtoList = new ArrayList<RegisterDTO>();
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM REGISTER";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				RegisterDTO dto = new RegisterDTO();
				dto.setRegStdNo(rs.getString(1));
				dto.setRegLecNo(rs.getInt(2));
				dto.setRegMidScore(rs.getInt(3));
				dto.setRegFinalScore(rs.getInt(4));
				dto.setRegTotalScore(rs.getInt(5));
				dto.setRegGrade(rs.getString(6));
				
				dtoList.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	public void insert(RegisterDTO dto) {
		
		try {
			conn = getConnection();
			
			String sql = "INSERT INTO REGISTER (regStdNo, regLecNo) values (?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getRegStdNo());
			psmt.setInt(2, dto.getRegLecNo());
			psmt.executeUpdate();
			
			closeAll();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void update(RegisterDTO dto) {
		
	}
	public void delete(int regStdNo, int regLecNo) {}
}

package service;

import java.util.List;

import dao.AccountDAO;
import dto.AccountDTO;

public enum AccountService {
	INSTANCE;
	
	private AccountDAO dao = AccountDAO.getInstance();
	
	public AccountDTO findById(String a_c_no) {
		return dao.select(a_c_no);
	}
	public AccountDTO findByIdAndName(String a_no, String a_c_name) {
		return dao.select(a_no, a_c_name);
	}
	
	public AccountDTO findByAcc(String a_no) {
		return dao.selectAcc(a_no);
	}
	public List<AccountDTO> findAll(){
		return dao.selectAll();
	}
	
	public void regist(AccountDTO dto) {
		dao.insert(dto);
	}
	
	public void deposit(AccountDTO dto, int t_amount) {
		dao.plusBal(dto, t_amount);
	}
	public void withdraw(AccountDTO dto, int t_amount) {
		dao.minusBal(dto, t_amount);
	}
	
	public void remove(String a_no) {
		dao.delete(a_no);
	}
	
}

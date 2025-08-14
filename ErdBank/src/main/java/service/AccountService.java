package service;

import java.util.List;

import dao.AccountDAO;
import dto.AccountDTO;

public enum AccountService {
	INSTANCE;
	
	private AccountDAO dao = AccountDAO.getInstance();
	
	public AccountDTO findById(String a_no) {
		return dao.select(a_no);
	}
	public AccountDTO findByIdAndName(String a_no, String a_c_name) {
		return dao.select(a_no, a_c_name);
	}
	
	public List<AccountDTO> findAll(){
		return dao.selectAll();
	}
	
	public void regist(AccountDTO dto) {
		dao.insert(dto);
	}
	
	public void modify(AccountDTO dto) {
		dao.update(dto);
	}
	
	public void remove(String a_no) {
		dao.delete(a_no);
	}
	
}

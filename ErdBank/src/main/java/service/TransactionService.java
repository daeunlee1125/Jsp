package service;

import java.util.List;

import dao.TransactionDAO;
import dto.TransactionDTO;

public enum TransactionService {
	INSTANCE;
	
	private TransactionDAO dao = TransactionDAO.getInstance();
	
	public TransactionDTO findById(String t_no) {
		return dao.select(t_no);
	}

	
	public List<TransactionDTO> findAll(){
		return dao.selectAll();
	}
	
	public void transfer(TransactionDTO dto) {
		dao.insertAndUpdate(dto);
	}
	
	public void addTrans(TransactionDTO dto) {
		dao.insert(dto);
	}
	
	public void remove(String t_no) {
		dao.delete(t_no);
	}
	
}

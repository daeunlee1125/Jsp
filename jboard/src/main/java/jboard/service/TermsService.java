package jboard.service;

import java.util.List;

import jboard.dao.TermsDAO;
import jboard.dto.TermsDTO;

public enum TermsService {
	INSTANCE;
	
	private TermsDAO dao = TermsDAO.getInstance();
	
	public void register(TermsDTO dto) {
		dao.insert(dto);
	}
	
	public TermsDTO findById(int ano) {
		return dao.select(ano);
	}
	
	public List<TermsDTO> findAll() {
		return dao.selectAll();
	}
	
	public void modify(TermsDTO dto) {
		dao.update(dto);
	}
	
	public void remove(int ano) {
		dao.delete(ano);
	}
}

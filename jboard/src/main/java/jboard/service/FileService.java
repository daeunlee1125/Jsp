package jboard.service;

import java.util.List;

import jboard.dao.FileDAO;
import jboard.dto.FileDTO;

public enum FileService {
	INSTANCE;
	
	private FileDAO dao = FileDAO.getInstance();
	
	public void register(FileDTO dto) {
		dao.insert(dto);
	}
	
	public FileDTO findById(int ano) {
		return dao.select(ano);
	}
	
	public List<FileDTO> findAll() {
		return dao.selectAll();
	}
	
	public void modify(FileDTO dto) {
		dao.update(dto);
	}
	
	public void remove(int ano) {
		dao.delete(ano);
	}
}

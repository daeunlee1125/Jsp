package jboard.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import jboard.dao.FileDAO;
import jboard.dto.FileDTO;

public enum FileService {
	INSTANCE;
	
	private FileDAO dao = FileDAO.getInstance();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<FileDTO> fileUpload(HttpServletRequest req) {
		
		List<FileDTO> files = new ArrayList<FileDTO>();
		
		//int count = 0;
		
		// 파일 업로드 디렉터리 경로 생성
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/files");
		File uploadedPath = new File(path);
		logger.debug("path : " + path);
		
		if (!uploadedPath.exists()) {
			uploadedPath.mkdir();
		}
		
		try {
			// 업로드 파일 Part(업로드된 파일) 첨부 파일에서 가져오기
			
			Collection<Part> parts = req.getParts();
			
			// 파일명 추출
			for (Part part : parts) {
				
				String partName = part.getName();
				
				if (partName.equals("file1") || partName.equals("file2")) {
					// 파일명 추출
					String oriName = part.getSubmittedFileName();
					logger.debug("oriName : " + oriName);
					
					// 중복되지 않는 파일명 생성
					String ext = oriName.substring(oriName.lastIndexOf("."));
					String savedName = UUID.randomUUID().toString() + ext;
					
					// 파일 저장(경로+구분자+중복x파일명)
					part.write(path + File.separator + savedName);
					//count++;
					
					// 반환 dto 생성, 리스트 저장
					FileDTO dto = new FileDTO();
					dto.setOname(oriName);
					dto.setSname(savedName);
					
					files.add(dto);
				}
			}
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return files;
	}
	
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

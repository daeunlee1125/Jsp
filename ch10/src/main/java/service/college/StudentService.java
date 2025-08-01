package service.college;

import java.util.List;

import dao.college.StudentDAO;
import dto.college.StudentDTO;

// enum(열거형)으로 객체 선언하면 싱글톤으로 간주댐
public enum StudentService { 
	
	INSTANCE; // 이게 객체
	
	private StudentDAO dao = StudentDAO.getInstance();
	
	public void register(StudentDTO dto) {
		dao.insertStudent(dto);
	}
	public StudentDTO findById(String cid) {
		return dao.selectStudent(cid);
	}
	public List<StudentDTO> findAll() {
		return dao.selectAllStudent();
	}
	public void modify(StudentDTO dto) {
		dao.updateStudent(dto);
	}
	public void delete(String stdno) {
		dao.deleteStudent(stdno);
	}
}

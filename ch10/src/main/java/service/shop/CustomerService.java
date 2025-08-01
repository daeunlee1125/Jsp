package service.shop;

import java.util.List;

import dao.shop.CustomerDAO;
import dto.shop.CustomerDTO;

// enum(열거형)으로 객체 선언하면 싱글톤으로 간주댐
public enum CustomerService { 
	
	INSTANCE; // 이게 객체
	
	private CustomerDAO dao = CustomerDAO.getInstance();
	
	public void register(CustomerDTO dto) {
		dao.insertCustomer(dto);
	}
	public CustomerDTO findById(String cid) {
		return dao.selectCustomer(cid);
	}
	public List<CustomerDTO> findAll() {
		return dao.selectAllCustomer();
	}
	public void modify(CustomerDTO dto) {
		dao.updateCustomer(dto);
	}
	public void delete(String cid) {
		dao.deleteCustomer(cid);
	}
}

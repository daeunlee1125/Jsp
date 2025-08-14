package service;

import java.util.List;

import dao.ProductDAO;
import dto.ProductDTO;



public enum ProductService {
	instance;
	
	private ProductDAO dao = ProductDAO.getInstance();
	
	// DAO 요청 메서드
	public void register(ProductDTO dto) {
		dao.insertProduct(dto);
	}
	
	public ProductDTO findById(int prodNo) {
		return dao.selectProduct(prodNo);
	}
	
	public List<ProductDTO> findAll(){
		return dao.selectAllProduct();
	}
	
	public void modify(ProductDTO dto) {
		dao.updateProduct(dto);
	}
	public void remove(int prodNo) {
		dao.deleteProduct(prodNo);
	}
}

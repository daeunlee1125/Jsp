package dao;

import java.util.ArrayList;
import java.util.List;

import dto.ProductDTO;
import service.ProductService;
import util.DBHelper;

public class ProductDAO extends DBHelper {
	ProductService service = ProductService.instance;
private static final ProductDAO INSTANCE = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return INSTANCE;
	}
	private ProductDAO() {}
	
	private final String DBCP = "jdbc/shopERD";
	
	public void insertProduct(ProductDTO dto) {

		
	}
	public ProductDTO selectProduct(int prodNo) {
		ProductDTO dto = null;
	
		
		return dto;
	}
	public List<ProductDTO> selectAllProduct(){
		List<ProductDTO> ProductList = new ArrayList<>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * from product");
			
			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setProdName(rs.getString(2));
				dto.setStock(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setCompany(rs.getString(5));
				ProductList.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ProductList;
	}
	
	public void updateProduct(ProductDTO dto) {
		
	}
	public void deleteProduct(int prodNo) {
		
	}
}

package dao;

import java.util.ArrayList;
import java.util.List;

import dto.OrderDTO;
import service.ProductService;
import util.DBHelper;

public class OrderDAO extends DBHelper {
	ProductService service = ProductService.instance;
	private static final OrderDAO INSTANCE = new OrderDAO();
		
	public static OrderDAO getInstance() {
		return INSTANCE;
	}
	private OrderDAO() {}
	
	private final String DBCP = "jdbc/shopERD";
	
	public void insertOrder(OrderDTO dto) {
		
		try {
			conn = getConnection(DBCP);
			String sql = "INSERT INTO \"Order\" (orderId, orderProduct, orderCount, orderDate) values (?, ?, ?, SYSDATE)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getOrderId());
			psmt.setInt(2, dto.getOrderProduct());
			psmt.setInt(3, dto.getOrderCount());
			
			psmt.executeUpdate();
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public OrderDTO selectOrder(int prodNo) {
		OrderDTO dto = null;
	
		
		return dto;
	}
	public List<OrderDTO> selectAllOrder(){
		List<OrderDTO> dtoList = new ArrayList<>();
		
		try {

			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	public void updateOrder(OrderDTO dto) {
		
	}
	public void deleteOrder(int orderNo) {
		
	}
}

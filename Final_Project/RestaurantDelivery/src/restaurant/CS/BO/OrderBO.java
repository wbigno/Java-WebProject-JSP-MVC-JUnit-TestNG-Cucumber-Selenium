package restaurant.CS.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.CS.DAO.OrderDAO;
import restaurant.CS.MODEL.ItemModel;
import restaurant.CS.MODEL.OrderModel;
import restaurant.CS.MODEL.PaymentModel;

public class OrderBO {

	public void newOrder(List<ItemModel> itemList, int orderID) throws ClassNotFoundException, IOException, SQLException {
		final OrderDAO orderDAO = new OrderDAO();
		final PaymentModel paymentObj = new PaymentModel();
		@SuppressWarnings("unused")
		Integer id = paymentObj.getOrderId(); 
		
		try
		{
			orderDAO.newOrder(itemList, id);
		}catch(SQLException e) {
			e.getMessage();
		}		
	}
	
	public List<PaymentModel> listAllOrders() throws SQLException, ClassNotFoundException, IOException {
		final OrderDAO orderDAO = new OrderDAO();
		 	List<PaymentModel> orderList = new ArrayList<PaymentModel>();
		try
		{
			orderList = orderDAO.listAllOrders();
		}catch(SQLException e) {
			e.getMessage();
		}
		return orderList;
	}
	
	public List<PaymentModel> userPriorOrders(int userid) throws ClassNotFoundException, IOException, SQLException {
		final OrderDAO orderDAO = new OrderDAO();
			List<PaymentModel> priorOrderList = null;
		try
		{
			orderDAO.userPriorOrders(userid);
		}catch(SQLException e) {
			e.getMessage();
		}
		return priorOrderList;
		
	}
	
	public void cancelOrder(OrderModel orderObj) throws ClassNotFoundException, IOException, SQLException {
		final OrderDAO orderDAO = new OrderDAO();
		
		try
		{
			orderDAO.cancelOrder(orderObj);
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
}

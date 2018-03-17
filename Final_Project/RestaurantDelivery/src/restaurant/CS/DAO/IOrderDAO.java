package restaurant.CS.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import restaurant.CS.MODEL.ItemModel;
import restaurant.CS.MODEL.OrderModel;
import restaurant.CS.MODEL.PaymentModel;

public interface IOrderDAO {
	
	public void newOrder(List<ItemModel> itemList, int orderID) throws ClassNotFoundException, IOException, SQLException;
	
	public List<PaymentModel> listAllOrders() throws SQLException, ClassNotFoundException, IOException; 
	
	public List<PaymentModel> userPriorOrders(int userId) throws ClassNotFoundException, IOException, SQLException; 
	
	public void cancelOrder(OrderModel orderObj) throws ClassNotFoundException, IOException, SQLException; 
}

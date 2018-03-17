package restaurant.CS.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.CS.MODEL.ItemModel;
import restaurant.CS.MODEL.OrderModel;
import restaurant.CS.MODEL.PaymentModel;
import restaurant.CS.Util.OracleSqlQueries;

public class OrderDAO implements IOrderDAO {

		public void newOrder(List<ItemModel> itemList, int orderID) throws ClassNotFoundException, IOException, SQLException {
			Connection conn = null;
			PreparedStatement stmt = null;
			OracleConnection oracle = new OracleConnection();
			
			try {
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.NEWORDER);
				for(ItemModel item : itemList) {	
					stmt.setInt(1,orderID);
					stmt.setInt(2, item.getId());
					stmt.executeUpdate();
				}
				
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				stmt.close();
				conn.close();
		}
	}

		public List<PaymentModel> listAllOrders() throws SQLException, ClassNotFoundException, IOException {
			Connection conn = null; 
			PreparedStatement stmt = null;
			ResultSet result = null;
			List<PaymentModel> orderList = null;
			PaymentModel paymentObj = null;
			OracleConnection oracle = new OracleConnection();
			try {
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.GETORDERS); 
				result = stmt.executeQuery();						
				orderList = new ArrayList<PaymentModel>();

						
				while(result.next()) {
					paymentObj = new PaymentModel();
					paymentObj.setOrderId(result.getInt(1));			
					paymentObj.setUserId(result.getInt(2));	
					paymentObj.setFirstName(result.getString(3));
					paymentObj.setLastName(result.getString(4));
					paymentObj.setOrderDate(result.getDate(5));
					paymentObj.setLocationId(result.getInt(6));
					paymentObj.setLocationName(result.getString(7));
					paymentObj.setItemId(result.getInt(8));
					paymentObj.setItemName(result.getString(9));
					paymentObj.setTotalPayment(result.getDouble(10));
					orderList.add(paymentObj);
					
					
				}
				
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				result.close();
				stmt.close();
				conn.close();
			}
			return orderList;
		}
		
		public List<PaymentModel> userPriorOrders(int userid) throws ClassNotFoundException, IOException, SQLException {
			
			Connection conn = null; 
			PreparedStatement stmt = null;
			ResultSet result = null;
			PaymentModel paymentObj = null;
			List<PaymentModel> priorOrderList = null;
			OracleConnection oracle = new OracleConnection();
			try {
				conn = oracle.getConnection();
				System.out.println("getting it");
				stmt = conn.prepareStatement(OracleSqlQueries.GETPRIORORDERS); // same query as ALL orders from above except added a WHERE filter or userId
				stmt.setInt(1, userid);
				result = stmt.executeQuery();
				priorOrderList = new ArrayList<PaymentModel>();
				while(result.next()) {
					paymentObj = new PaymentModel();
					paymentObj.setOrderId(result.getInt(1));			
					paymentObj.setUserId(result.getInt(2));	
					paymentObj.setFirstName(result.getString(3));
					paymentObj.setLastName(result.getString(4));
					paymentObj.setOrderDate(result.getDate(5));
					paymentObj.setLocationId(result.getInt(6));
					paymentObj.setLocationName(result.getString(7));
					paymentObj.setItemId(result.getInt(8));
					paymentObj.setItemName(result.getString(9));
					paymentObj.setTotalPayment(result.getDouble(10));
					priorOrderList.add(paymentObj);		
					System.out.println("got it");
					System.out.println(priorOrderList.size());
				}
				
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				result.close();
				stmt.close();
				conn.close();
			}
			return priorOrderList;
		}
		
		public void cancelOrder(OrderModel orderObj) throws ClassNotFoundException, IOException, SQLException {
			Connection conn = null; 
			PreparedStatement stmt = null;
			OracleConnection oracle = new OracleConnection();
			System.out.println(orderObj.getId());
			try {
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.CANCELORDER); 
				orderObj = new OrderModel();
				stmt.setInt(1, orderObj.getId());
				stmt.executeUpdate();
				
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				stmt.close();
				conn.close();
			}
		}
}

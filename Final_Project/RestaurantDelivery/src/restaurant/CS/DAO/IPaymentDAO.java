package restaurant.CS.DAO;

import java.io.IOException;
import java.sql.SQLException;

import restaurant.CS.MODEL.PaymentModel;


public interface IPaymentDAO {
	
	public int addPayment(PaymentModel paymentObj) throws SQLException, ClassNotFoundException, IOException; 
			
}

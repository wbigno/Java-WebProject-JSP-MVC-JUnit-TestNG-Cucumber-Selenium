package restaurant.CS.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.CS.DAO.PaymentDAO;
import restaurant.CS.MODEL.ItemModel;
import restaurant.CS.MODEL.PaymentModel;

public class PaymentBO {
	
		public int addPayment(PaymentModel paymentObj) throws SQLException, ClassNotFoundException, IOException {
			final PaymentDAO paymentDAO = new PaymentDAO();
			int id = 0;
			try
			{
				paymentDAO.addPayment(paymentObj);
				this.getTotal(null);
			}catch(SQLException e) {
				e.getMessage();
			}
			return id;
		}
		
	
		@SuppressWarnings("null")
		public List<PaymentModel> getTotal(List<ItemModel> itemlist){
			List<PaymentModel> fees = new ArrayList<PaymentModel>();
			
			Double totalPayment = 0.00;
			Double totalPurchase = 0.00;
			Double taxRate = 0.09;
			Double tax;
			PaymentModel paymentObj = new PaymentModel();
			    
			for(int i=0; i < itemlist.size(); i++) { 
				totalPayment = totalPayment + itemlist.get(i).getPrice();
			}
				tax = (totalPayment * taxRate);
				totalPurchase = (tax + totalPayment);
				
				paymentObj.setTotalPayment(totalPayment);
				paymentObj.setTax(tax);
				paymentObj.setTotalPurchase(totalPurchase);	
				fees.add(paymentObj);
				
				return fees;
		}
}

package restaurant.CS.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import restaurant.CS.MODEL.PaymentModel;
import restaurant.CS.Util.OracleSqlQueries;

public class PaymentDAO implements IPaymentDAO{

		public int addPayment(PaymentModel paymentObj) throws SQLException, ClassNotFoundException, IOException {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			int id = 0;
			String[] IDCOLUMN = {"id"};
			OracleConnection oracle = new OracleConnection();
		
		try {
		
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.ADDPAYMENTINFO, IDCOLUMN);
	    	stmt.setInt(1, paymentObj.getUserId());
	    	stmt.setInt(2, paymentObj.getCreditCard());
	    	stmt.setInt(3, paymentObj.getSecurityCode());
	    	stmt.setInt(4, paymentObj.getZipcode());
	    	stmt.setInt(5, paymentObj.getLocationId());
	    	stmt.setDouble(6, paymentObj.getTotalPayment()); // this is just the total Price of all items selected excluding tax for historical reporting purposes later
	    	stmt.executeUpdate();
		 
	    	result = stmt.getGeneratedKeys();
	    	if(result.next()) {
	    		id = result.getInt(1);
	    	}	
		}catch(SQLException e) {
	    		e.getMessage();
	  	
		}finally {
			result.close();
	  		stmt.close();
	  		conn.close();	
			
		}
		return id;	
	}
}


package restaurant.CS.HELPERS;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import restaurant.CS.DAO.OracleConnection;

public class UserDataDAOHelper {

	public void deleteItem(int id) throws ClassNotFoundException, IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		OracleConnection oracle = new OracleConnection();
		String DELETEITEM = "DELETE from USER_DATA where id = ?";
		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(DELETEITEM);
			stmt.setInt(1, id);	
			stmt.executeUpdate();
				
		}catch(SQLException e) {
			e.getMessage();
		}finally {
			stmt.close();
			conn.close();
		}	
	}
}

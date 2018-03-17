package restaurant.CS.HELPERS;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.CS.DAO.OracleConnection;
import restaurant.CS.MODEL.ItemModel;

public class ItemDAOHelper {

	public void deleteItem(int id) throws ClassNotFoundException, IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		OracleConnection oracle = new OracleConnection();
		String DELETEITEM = "DELETE from ITEMS where id = ?";
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
	
	public ItemModel listToString(Object obj) {
		ItemModel id = null;
		List<ItemModel> items = new ArrayList<ItemModel>();
		id = items.get(0);
		System.out.println(id);
		return id;
		
	}
}



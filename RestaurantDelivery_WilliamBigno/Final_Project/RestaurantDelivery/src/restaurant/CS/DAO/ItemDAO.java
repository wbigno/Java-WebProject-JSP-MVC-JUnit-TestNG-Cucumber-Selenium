package restaurant.CS.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.CS.MODEL.ItemModel;
import restaurant.CS.Util.OracleSqlQueries;

public class ItemDAO implements IItemDAO {
	
	public int addItem(ItemModel itemObj) throws ClassNotFoundException, IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;		
		ResultSet result = null;
		int id = 0;
		String[] IDCOLUMN = {"id"};
		OracleConnection oracle = new OracleConnection();
		System.out.println(itemObj.getItemName());
		try {
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.ADDITEM, IDCOLUMN);
			stmt.setString(1, itemObj.getItemName());
			stmt.setString(2, itemObj.getDescription());
			stmt.setDouble(3, itemObj.getPrice());
			stmt.setInt(4, 1);
			stmt.setString(5, itemObj.getCategory());
			stmt.setString(6, itemObj.getImages());	
			stmt.executeUpdate();
			
			result = stmt.getGeneratedKeys();
			if(result.next()) {
				id = result.getInt(1);
			}
				
		}catch(SQLException e) {
			e.getMessage();
		}finally {
			stmt.close();
			conn.close();
		}
		return id;
		}	

	public List<ItemModel> listOfItems() throws ClassNotFoundException, IOException, SQLException {
		Connection conn = null; 
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<ItemModel> itemList = null;
		ItemModel itemObj = null;
		OracleConnection oracle = new OracleConnection();
		try {
			
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.GETALLITEMS);
			result = stmt.executeQuery();
			itemList = new ArrayList<ItemModel>();
			
			while(result.next()) {
				itemObj = new ItemModel();
				itemObj.setId(result.getInt(1));
				itemObj.setItemName(result.getString(2));
				itemObj.setDescription(result.getString(3));
				itemObj.setPrice(result.getDouble(4));
				itemObj.setActive(result.getInt(5));
				itemObj.setCategory(result.getString(6));
				itemObj.setImages(result.getString(7));
				itemList.add(itemObj);
			}
			
		}catch(SQLException e) {
			e.getMessage();
		}finally {
			result.close();
			stmt.close();
			conn.close();
		}
		return itemList;
	}
	
	public void updateItem(ItemModel itemObj) throws ClassNotFoundException, IOException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;		
		OracleConnection oracle = new OracleConnection();
		try {
			
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.UPDATEITEM);
			stmt.setString(1, itemObj.getItemName());
			stmt.setString(2, itemObj.getDescription());
			stmt.setDouble(3, itemObj.getPrice());
			stmt.setInt(4, 1);
			stmt.setString(5, itemObj.getCategory());
			stmt.setString(6, itemObj.getImages());
			stmt.setInt(7, itemObj.getId());	
			stmt.executeUpdate();
				
		}catch(SQLException e) {
			e.getMessage();
		}finally {
			stmt.close();
			conn.close();
		}	
	}	
	
	public void disableItem(ItemModel itemObj) throws SQLException, ClassNotFoundException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		OracleConnection oracle = new OracleConnection();
		try {
			
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.DISABLEITEM);
			stmt.setInt(1, 0);
			stmt.setInt(2, itemObj.getId());	
			stmt.executeUpdate();
				
		}catch(SQLException e) {
			e.getMessage();
		}finally {
			stmt.close();
			conn.close();
		}	
	}
	
	public void enableItem(ItemModel itemObj) throws SQLException, ClassNotFoundException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		OracleConnection oracle = new OracleConnection();
		try {
			
			conn = oracle.getConnection();
			stmt = conn.prepareStatement(OracleSqlQueries.ENABLEITEM);
			stmt.setInt(1, 1);
			stmt.setInt(2, itemObj.getId());	
			stmt.executeUpdate();
				
		}catch(SQLException e) {
			e.getMessage();
		}finally {
			stmt.close();
			conn.close();
		}	
	}
	
}

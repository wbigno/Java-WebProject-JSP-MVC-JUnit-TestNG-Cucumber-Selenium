package restaurant.CS.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import restaurant.CS.DAO.ItemDAO;
import restaurant.CS.MODEL.ItemModel;

public class ItemBO {

	public List<ItemModel> listOfItems() throws ClassNotFoundException, IOException, SQLException {
		final ItemDAO itemDAO = new ItemDAO();
		List<ItemModel> itemList = null;
		try
		{
			itemList = itemDAO.listOfItems();
		}catch(SQLException e) {
			e.getMessage();
		}
		return itemList;
	}
	
	public List<ItemModel> listOfActiveItems() throws ClassNotFoundException, IOException, SQLException {
		final ItemDAO itemDAO = new ItemDAO();
		List<ItemModel> itemList = null;
		try
		{
			itemList = itemDAO.listOfActiveItems();
		}catch(SQLException e) {
			e.getMessage();
		}
		return itemList;
	}
	
	public void updateItem(ItemModel itemObj) throws ClassNotFoundException, IOException, SQLException {
		final ItemDAO itemDAO = new ItemDAO();
		
		try
		{
			itemDAO.updateItem(itemObj);
		}catch(SQLException e) {
			e.getMessage();
		}
		
	}
	
	public void disableItem(ItemModel itemObj) throws SQLException, ClassNotFoundException, IOException {
		final ItemDAO itemDAO = new ItemDAO();
		
		try
		{
			itemDAO.disableItem(itemObj);
		}catch(SQLException e) {
			e.getMessage();
		}
		
	}
	
	public void enableItem(ItemModel itemObj) throws SQLException, ClassNotFoundException, IOException {
		final ItemDAO itemDAO = new ItemDAO();
		
		try
		{
			itemDAO.enableItem(itemObj);
		}catch(SQLException e) {
			e.getMessage();
		}
		
	}
	
	@SuppressWarnings("null")
	public int addItem(ItemModel itemObj) throws ClassNotFoundException, IOException, SQLException {
		final ItemDAO itemDAO = new ItemDAO();
		Integer id = null;
		try
		{
			itemDAO.addItem(itemObj);
		}catch(SQLException e) {
			e.getMessage();
	}
		return id;
	}
}

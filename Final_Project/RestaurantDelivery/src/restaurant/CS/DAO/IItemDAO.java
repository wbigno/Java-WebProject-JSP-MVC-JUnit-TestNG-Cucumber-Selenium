package restaurant.CS.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import restaurant.CS.MODEL.ItemModel;

public interface IItemDAO {
	
	public List<ItemModel> listOfItems() throws ClassNotFoundException, IOException, SQLException;
	
	public void updateItem(ItemModel itemObj) throws ClassNotFoundException, IOException, SQLException;
	
	public void disableItem(ItemModel itemObj) throws SQLException, ClassNotFoundException, IOException; 
	
	public int addItem(ItemModel itemObj) throws ClassNotFoundException, IOException, SQLException;
	
	public void enableItem(ItemModel itemObj) throws SQLException, ClassNotFoundException, IOException;

	public List<ItemModel> listOfActiveItems() throws ClassNotFoundException, IOException, SQLException;

}
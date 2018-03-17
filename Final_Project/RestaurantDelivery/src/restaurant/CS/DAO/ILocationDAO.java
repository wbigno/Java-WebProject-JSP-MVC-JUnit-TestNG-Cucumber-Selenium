package restaurant.CS.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import restaurant.CS.MODEL.LocationModel;

public interface ILocationDAO {

	public int addLocation() throws SQLException, ClassNotFoundException, IOException;
	
	public void disableLocation(LocationModel locObj) throws SQLException, ClassNotFoundException, IOException;
	
	public List<LocationModel> listOfLocation() throws SQLException, ClassNotFoundException, IOException;
	
	public void enableLocation(LocationModel locObj) throws SQLException, ClassNotFoundException, IOException;
	
}

package restaurant.CS.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import restaurant.CS.DAO.LocationDAO;
import restaurant.CS.MODEL.LocationModel;

public class LocationBO {

	public int addLocation(LocationModel locationObj) throws SQLException, ClassNotFoundException, IOException {
		final LocationDAO locationDAO = new LocationDAO();
		Integer id = null;
		try
		{
			id = locationDAO.addLocation();
		}catch(SQLException e) {
			e.getMessage();
		}
		return id;
	}
	
	public void disableLocation(LocationModel locObj) throws SQLException, ClassNotFoundException, IOException {
		final LocationDAO locationDAO = new LocationDAO();
		
		try
		{
			locationDAO.disableLocation(locObj);
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	public void enableLocation(LocationModel locObj) throws SQLException, ClassNotFoundException, IOException {
		final LocationDAO locationDAO = new LocationDAO();
		
		try
		{
			locationDAO.enableLocation(locObj);
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	public List<LocationModel> listOfLocation() throws SQLException, ClassNotFoundException, IOException {
		final LocationDAO locationDAO = new LocationDAO();
		List<LocationModel> locationList = null;
		try
		{
			locationList = locationDAO.listOfLocation();
		}catch(SQLException e) {
			e.getMessage();
		}
		
		return locationList;
	}
	
	
}

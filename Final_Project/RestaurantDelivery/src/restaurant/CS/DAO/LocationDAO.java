package restaurant.CS.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.CS.MODEL.LocationModel;
import restaurant.CS.Util.OracleSqlQueries;

public class LocationDAO implements ILocationDAO {

		public int addLocation() throws SQLException, ClassNotFoundException, IOException {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			int id = 0;
			String[] IDCOLUMN = {"id"};
			OracleConnection oracle = new OracleConnection();
			LocationModel locationObj = null;
			try {
				
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.NEWLOCATION, IDCOLUMN);
				locationObj = new LocationModel();
				stmt.setString(1, locationObj.getLocationName());
				stmt.setString(2, locationObj.getAddress());
				stmt.setInt(3, locationObj.getZipcode());
				stmt.setInt(4, locationObj.getStaffCount());
				stmt.setString(5, locationObj.getCategory());
				stmt.setString(6, locationObj.getImage());
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
		
		public void disableLocation(LocationModel locObj) throws SQLException, ClassNotFoundException, IOException {
			Connection conn = null; 
			PreparedStatement stmt = null;
			OracleConnection oracle = new OracleConnection();
			try {
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.DISABLELOCATION);
				stmt.setInt(1, 0);
				stmt.setInt(2, locObj.getId());
				
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				stmt.close();
				conn.close();
			}
		}
		
		public void enableLocation(LocationModel locObj) throws SQLException, ClassNotFoundException, IOException {
			Connection conn = null; 
			PreparedStatement stmt = null;
			OracleConnection oracle = new OracleConnection();
			try {
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.ENABLELOCATION);
				stmt.setInt(1, 1);
				stmt.setInt(2, locObj.getId());
				
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				stmt.close();
				conn.close();
			}
		}
		
		public List<LocationModel> listOfLocation() throws SQLException, ClassNotFoundException, IOException {
			Connection conn = null; 
			PreparedStatement stmt = null;
			ResultSet result = null;
			List<LocationModel> locationList = null;
			OracleConnection oracle = new OracleConnection();
			try {
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.GETALLLOCATIONS);
				result = stmt.executeQuery();
				locationList = new ArrayList<LocationModel>();
				LocationModel locationObj = new LocationModel();
				
				while(result.next()) {
					locationObj = new LocationModel();
					locationObj.setId(result.getInt(1));
					locationObj.setLocationName(result.getString(2));
					locationObj.setAddress(result.getString(3));
					locationObj.setZipcode(result.getInt(4));
					locationObj.setStaffCount(result.getInt(5));
					locationObj.setCategory(result.getString(6));
					locationObj.setImage(result.getString(7));
					locationObj.setActive(result.getInt(8));
					locationList.add(locationObj);
				}
				
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				result.close();
				stmt.close();
				conn.close();
			}
			return locationList;
		
	}
}

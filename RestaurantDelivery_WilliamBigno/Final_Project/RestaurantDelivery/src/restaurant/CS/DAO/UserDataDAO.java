package restaurant.CS.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.CS.MODEL.UserDataModel;
import restaurant.CS.Util.OracleSqlQueries;

public class UserDataDAO implements IUserDAO 
{

		public int registerNewUser(UserDataModel userObj) throws ClassNotFoundException, IOException, SQLException {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			int id = 0;
			String[] IDCOLUMN = {"id"};
			OracleConnection oracle = new OracleConnection();
			try {
				
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.NEWUSER, IDCOLUMN);
				stmt.setString(1, userObj.getFirstName());
				stmt.setString(2, userObj.getLastName());
				stmt.setString(3, userObj.getGender());
				stmt.setString(4, userObj.getAddress());
				stmt.setInt(5, userObj.getZipcode());
				stmt.setString(6, userObj.getEmail());
				stmt.setInt(7, userObj.getPhone());
				stmt.setString(8, userObj.getPassword());
				stmt.setInt(9, 0); //user hard coded for '0', admin = 1
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
		
		public UserDataModel loginUser (String username) throws ClassNotFoundException, IOException, SQLException {
			
			Connection conn = null; 
			PreparedStatement stmt = null;
			ResultSet result = null;		
			UserDataModel userObj = null;
			OracleConnection oracle = new OracleConnection();
			try {
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.VALIDATE);
				stmt.setString(1, username); //username (is the actual email in the DB) passed from the form on JSP page to UserModel to pull query here for validation.
				result = stmt.executeQuery();
				userObj = new UserDataModel();
				if(result.next()) {
					userObj.setId(result.getInt(1));
					userObj.setFirstName(result.getString(2));
					userObj.setLastName(result.getString(3));
					userObj.setGender(result.getString(4));
					userObj.setAddress(result.getString(5));
					userObj.setZipcode(result.getInt(6));
					userObj.setPhone(result.getInt(7));
					userObj.setEmail(result.getString(8));
					userObj.setPassword(result.getString(9));
					userObj.setAdmin(result.getInt(10));		
				}
				
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				result.close();
				stmt.close();
				conn.close();
			}
			return userObj;
		}
		
		public List<UserDataModel> listOfUsers() throws ClassNotFoundException, IOException, SQLException {
			
			Connection conn = null; 
			PreparedStatement stmt = null;
			ResultSet result = null;
			List<UserDataModel> userList = null;
			OracleConnection oracle = new OracleConnection();
			UserDataModel userObj = null;
			
			try {
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.GETALL);
				result = stmt.executeQuery();
				userList = new ArrayList<UserDataModel>();
				while(result.next()) {
					userObj = new UserDataModel();
					userObj.setId(result.getInt(1));
					userObj.setFirstName(result.getString(2));
					userObj.setLastName(result.getString(3));
					userObj.setGender(result.getString(4));
					userObj.setAddress(result.getString(5));
					userObj.setZipcode(result.getInt(6));
					userObj.setPhone(result.getInt(7));
					userObj.setEmail(result.getString(8));
					userObj.setPassword(result.getString(9));
					userObj.setAdmin(result.getInt(10));
					userList.add(userObj);
				}
				
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				result.close();
				stmt.close();
				conn.close();
			}
			return userList;
		}
		
		public void updateUser (UserDataModel userObj) throws ClassNotFoundException, IOException, SQLException {
			Connection conn = null;
			PreparedStatement stmt = null;	
			OracleConnection oracle = new OracleConnection();
			try {
				
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.SAVEUSER);
				stmt.setString(1, userObj.getFirstName());
				stmt.setString(2, userObj.getLastName());
				stmt.setString(3, userObj.getAddress());
				stmt.setInt(4, userObj.getZipcode());
				stmt.setInt(5, userObj.getPhone());
				stmt.setString(6, userObj.getEmail());
				stmt.setLong(7, userObj.getAdmin());
				stmt.setInt(8, userObj.getId());
				stmt.executeUpdate();
					
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				stmt.close();
				conn.close();
		}		
	}
		
		public void updateFullUser (UserDataModel userObj) throws ClassNotFoundException, IOException, SQLException {
			Connection conn = null;
			PreparedStatement stmt = null;	
			OracleConnection oracle = new OracleConnection();
			try {
				
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.SAVEFULLUSER);
				stmt.setString(1, userObj.getFirstName());
				stmt.setString(2, userObj.getLastName());
				stmt.setString(3, userObj.getAddress());
				stmt.setInt(4, userObj.getZipcode());
				stmt.setInt(5, userObj.getPhone());
				stmt.setString(6, userObj.getEmail());
				stmt.setString(7, userObj.getPassword());
				stmt.setString(8, userObj.getEmail());
				stmt.executeUpdate();
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				stmt.close();
				conn.close();
		}		
	}
}

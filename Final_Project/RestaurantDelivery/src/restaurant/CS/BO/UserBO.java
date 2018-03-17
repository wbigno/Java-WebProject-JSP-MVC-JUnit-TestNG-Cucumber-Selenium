package restaurant.CS.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import restaurant.CS.DAO.UserDataDAO;
import restaurant.CS.MODEL.UserDataModel;

public class UserBO {
	
	@SuppressWarnings("null")
	public int registerNewUser(UserDataModel userObj) throws ClassNotFoundException, IOException, SQLException {
		final UserDataDAO userDAO = new UserDataDAO();
		Integer id = null;
		try
		{
			id = userDAO.registerNewUser(userObj);
		}catch(SQLException e) {
			e.getMessage();
		}
		return id;
	}
	
	public UserDataModel loginUser (String username) throws ClassNotFoundException, IOException, SQLException {
		final UserDataDAO userDAO = new UserDataDAO();
		UserDataModel userObj = new UserDataModel();
		try
		{
			userObj = userDAO.loginUser(username);
		}catch(SQLException e) {
			e.getMessage();
		}
		
		return userObj;
	}
	

	public String validateUser(UserDataModel userObj) {
		String usernameFromJsp = userObj.getUserName();
		String passwordFromJsp = userObj.getPasswordLogin();
		String usernameFromSql = userObj.getEmail();
		String passwordFromSql = userObj.getPassword();
		Integer admin = userObj.getAdmin();
		
		if(usernameFromJsp.equals(usernameFromSql) && passwordFromJsp.equals(passwordFromSql)  && "1".equals(admin.toString())) {
				String check = "admin";	
				return check;
		}else if(usernameFromJsp.equals(usernameFromSql) && passwordFromJsp.equals(passwordFromSql)) {				
				String check = "user";	
				return check;
		}else { String 
				check = "invalid";	
				return check;
		
		}
	}
	public List<UserDataModel> listOfUsers() throws ClassNotFoundException, IOException, SQLException {
		final UserDataDAO userDAO = new UserDataDAO();
		List<UserDataModel> userList = null;
		try
		{
			userList = userDAO.listOfUsers();
		}catch(SQLException e) {
			e.getMessage();
		}
		return userList;
	}
	
	public void updateUser (UserDataModel userObj) throws ClassNotFoundException, IOException, SQLException {
		final UserDataDAO userDAO = new UserDataDAO();
		try
		{
			userDAO.updateUser(userObj);
		}catch(SQLException e) {
			e.getMessage();
		}		
	}
	
	public void updateFullUser (UserDataModel userObj) throws ClassNotFoundException, IOException, SQLException {
		final UserDataDAO userDAO = new UserDataDAO();
		try
		{
			userDAO.updateFullUser(userObj);
		}catch(SQLException e) {
			e.getMessage();
		}		
	}
}

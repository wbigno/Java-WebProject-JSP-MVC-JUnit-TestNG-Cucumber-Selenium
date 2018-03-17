package restaurant.CS.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import restaurant.CS.MODEL.UserDataModel;

public interface IUserDAO {

	public int registerNewUser(UserDataModel userObj) throws ClassNotFoundException, IOException, SQLException; 
	
	public UserDataModel loginUser (String username) throws ClassNotFoundException, IOException, SQLException; 
	
	public List<UserDataModel> listOfUsers() throws ClassNotFoundException, IOException, SQLException; 
	
	public void updateUser (UserDataModel userObj) throws ClassNotFoundException, IOException, SQLException; 
		
	public void updateFullUser (UserDataModel userObj) throws ClassNotFoundException, IOException, SQLException;
}

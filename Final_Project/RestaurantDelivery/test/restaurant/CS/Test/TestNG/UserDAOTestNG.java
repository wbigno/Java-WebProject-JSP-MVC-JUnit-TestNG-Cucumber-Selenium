package restaurant.CS.Test.TestNG;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import restaurant.CS.DAO.UserDataDAO;
import restaurant.CS.MODEL.UserDataModel;

public class UserDAOTestNG {

	UserDataDAO dao = null;
	UserDataModel model = null;

	@BeforeMethod()
	public void preTest() {
		dao = new UserDataDAO();
	}

	@Test(dataProvider = "Register", dataProviderClass = DataProviderTestNG.class)
	public void registerNewUserTest(String firstname, String lastname, String gender, String address, Integer zipcode,
			String email, Integer phone, String password) throws ClassNotFoundException, IOException, SQLException {
		UserDataModel model = new UserDataModel();
		model.setFirstName(firstname);
		model.setLastName(lastname);
		model.setGender(gender);
		model.setAddress(address);
		model.setZipcode(zipcode);
		model.setEmail(email);
		model.setPassword(password);

		int actual = dao.registerNewUser(model);

		Assert.assertNotNull(actual);
	}

	@Test(dataProvider = "Login", dataProviderClass = DataProviderTestNG.class, dependsOnMethods = "registerNewUserTest")
	public void loginUserTest(String email) throws ClassNotFoundException, IOException, SQLException {
		UserDataModel user = dao.loginUser(email);
		String expected = user.getEmail();
		String actual = email;
		Assert.assertSame(actual, expected);
	}

	@Test
	public void listOfUserTest() throws ClassNotFoundException, IOException, SQLException {
		List<UserDataModel> actual = dao.listOfUsers();
		Assert.assertNotNull(actual);
	}

	@Test(dataProvider = "Update", dataProviderClass = DataProviderTestNG.class)
	public void updateUserTest(Integer id, String firstname, String lastname, String email, String address,
			Integer admin, String gender, Integer zipcode, Integer phone) {
		UserDataModel model = new UserDataModel();
		model.setId(id);
		model.setFirstName(firstname);
		model.setLastName(lastname);
		model.setGender(gender);
		model.setAddress(address);
		model.setZipcode(zipcode);
		model.setEmail(email);
		model.setAdmin(admin);
		try {
			dao.updateUser(model);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test(dataProvider = "UpdateFull", dataProviderClass = DataProviderTestNG.class)
	public void updateFullUser(String firstname, String lastname, String email, String address, String password,
			String gender, Integer zipcode, Integer phone) {
		UserDataModel model = new UserDataModel();
		model.setFirstName(firstname);
		model.setLastName(lastname);
		model.setGender(gender);
		model.setAddress(address);
		model.setZipcode(zipcode);
		model.setEmail(email);
		model.setPassword(password);
		try {
			dao.updateFullUser(model);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
}

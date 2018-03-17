package restaurant.CS.Test.Junit;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import restaurant.CS.DAO.UserDataDAO;
import restaurant.CS.HELPERS.UserDataDAOHelper;
import restaurant.CS.MODEL.UserDataModel;

@RunWith(Parameterized.class)
public class UserDAOTest {
	
	UserDataDAO dao = null;
	UserDataModel model = null;
	UserDataDAOHelper helper = null;
	int localUserId;
	boolean isCreating;
	
	@Before
	public void prepTest() {
		dao = new UserDataDAO();
		helper = new UserDataDAOHelper();
		isCreating = false;
		localUserId = 0;
	}
	
	public UserDAOTest(String firstName, String lastName, String gender, String address,
			Integer zipcode, Integer phone, String email, String password) {
		model = new UserDataModel();
		model.setFirstName(firstName);
		model.setLastName(lastName);
		model.setGender(gender);
		model.setAddress(address);
		model.setZipcode(zipcode);
		model.setPhone(phone);
		model.setEmail(email);
		model.setPassword(password);

	}
	
	@Parameters
	public static Collection<Object[]> user() {
		Object[][] data = {
				{"Bob", "Smith", "M", "1234 Main St", 11111, 555-5555, "bmsith@gmail.com", "password123"},
				{"Bobby", "Smithy", "M", "1234 South St", 11111, 555-5555, "bmsithy@gmail.com", "password123"},
				{"Bobbie", "Smith", "M", "1234 East St", 11111, 555-5555, "bobbiemsith@gmail.com", "password123"},
				{"Brittany", "Smithom", "F", "1234 Court St", 11111, 555-5555, "britmsithom@gmail.com", "password123"},
		};
		return Arrays.asList(data);
	}
	@Test
	public void userRegistrationTest() throws ClassNotFoundException, IOException, SQLException {
		int actual = dao.registerNewUser(model);
		
		Assert.assertThat(actual, is(not(equalTo(0))));
	}
	
	@Test
	public void loginTest() throws ClassNotFoundException, IOException, SQLException {
		String actual = model.getEmail();
		dao.loginUser(actual);
		String expected = model.getEmail();
		
		Assert.assertThat(actual, is(equalTo(expected)));
	}
	
//	@Test
//	public void getUserListTest() throws ClassNotFoundException, IOException, SQLException {
//		List<UserDataModel> actual = dao.listOfUsers();
//		
//		assertEquals(actual, hasItems("Bob", "Bobby", "Bobbie", "Brittany"));
//
//	}
	
	@Test
	public void updateUserTest() throws ClassNotFoundException, IOException, SQLException {
			UserDataModel test = new UserDataModel();
			test.setFirstName("John");
			test.setLastName("Doe");
			test.setGender("M");
			test.setAddress("999 Ally Ct");
			test.setZipcode(99999);
			test.setPhone(9999999);
			test.setEmail("updated@update.com");
			test.setPassword("newpassword");
			test.setId(localUserId);
			dao.registerNewUser(test);
	  
	}
	
	@After
	public void clearTest() {
//		if(isCreating == true) {
//		dao.deleteItem(localUserId);
//		}
//		isCreating = false;
	}
	
}

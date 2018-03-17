package restaurant.CS.Test.TestNG;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import restaurant.CS.DAO.LocationDAO;
import restaurant.CS.MODEL.LocationModel;

public class LocationDAOTestNG {

	LocationDAO dao = null;
	LocationModel model = null;

	@BeforeMethod()
	public void preTest() {
		dao = new LocationDAO();

	}

	@Test(dataProvider = "AddLocation")
	public void addLocationTest(String locationname, String address, Integer zipcode, Integer staffcount,
			String category, String image) throws ClassNotFoundException, SQLException, IOException {

		model.setLocationName(locationname);
		model.setAddress(address);
		model.setZipcode(zipcode);
		model.setStaffCount(staffcount);
		model.setCategory(category);
		model.setImage(image);
		try {
			dao.addLocation(model);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test(dataProvider = "LocID")
	public void disableLocationTest(Integer id) {
		model.setId(id);
		try {
			dao.disableLocation(model);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test(dataProvider = "LocID")
	public void enableLocationTest(Integer id) {
		model.setId(id);
		try {
			dao.enableLocation(model);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
}

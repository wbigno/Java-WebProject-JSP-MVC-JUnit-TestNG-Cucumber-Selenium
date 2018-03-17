package restaurant.CS.Test.Junit;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import restaurant.CS.DAO.LocationDAO;
import restaurant.CS.MODEL.LocationModel;

@RunWith(Parameterized.class)
public class LocationDAOTest {
	
	LocationDAO dao = null;
	LocationModel model = null;
	int idForDelete;
	boolean isCreating;
	
	@Before
	public void prepTest() {
		dao = new LocationDAO();
		isCreating = false;
		idForDelete = 0;
	}
	public LocationDAOTest(String locationName, String address, 
			Integer zipcode, Integer staffCount, String category, String image) {
		model = new LocationModel();
		model.setLocationName(locationName);
		model.setAddress(address);
		model.setZipcode(zipcode);
		model.setStaffCount(staffCount);
		model.setCategory(category);
		model.setImage(image);
		
	}
	
	@Parameters
	public static Collection<Object[]> location() {
		Object[][] data = {	
				{"EastSide", "123 East St", 11111, 10, "All", "?"},
				{"WestSide", "123 West St", 11111, 10, "All", "?"},
				{"NorthSide", "123 North St", 11111, 10, "All", "?"},
				{"SouthSide", "123 South St", 11111, 10, "All", "?"},
				};
		
			return Arrays.asList(data);			
		}
	
	@Test
	public void addNewLocationTest() throws ClassNotFoundException, SQLException, IOException {
		dao.addLocation();
		int actual = model.getId();
		
		assertThat(actual, is(not(equalTo(0))));
		
	}
	
	@Test
	public void getListOfLocationTest() throws ClassNotFoundException, SQLException, IOException {
		dao.addLocation();
		List<LocationModel> actual = dao.listOfLocation();
		
		Assert.assertEquals(actual, hasItems("EastSide", "WestSide", "NorthSide", "SouthSide"));
	}
	
}

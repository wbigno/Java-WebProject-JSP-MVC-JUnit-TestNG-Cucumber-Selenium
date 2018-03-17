package restaurant.CS.Test.Junit;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import restaurant.CS.DAO.ItemDAO;
import restaurant.CS.HELPERS.ItemDAOHelper;
import restaurant.CS.MODEL.ItemModel;

@RunWith(Parameterized.class)
public class ItemDAOTest {
	
	ItemDAO dao = null;
	ItemDAOHelper helper = null;
	ItemModel model = null;
	private int localItemId;
	boolean isCreating;
	
	@Before
	public void prepTest() {
		dao = new ItemDAO();
		helper = new ItemDAOHelper();
		isCreating = false;
		
	}
	
	public ItemDAOTest(String itemName, String description, Double price, Integer active,
						String category, String image) {
		model = new ItemModel();
		model.setItemName(itemName);
		model.setDescription(description);
		model.setPrice(price);
		model.setActive(active);
		model.setCategory(category);
		model.setImages(image);
		
	}
	
	@Parameters
	public static Collection<Object[]> item() {
		Object[][] data = {
				{"Pizza", "Hot and Yummy", 10.00, 0, "Best", " "},
				{"Hamburger", "Hot and Yummy", 10.00, 0, "Best", " "},
				{"Hoggie", "Hot and Yummy", 10.00, 0, "Best", " "},
		};	
		return Arrays.asList(data);
	}
	
	@Test
	public void getListOfItemsTest() throws ClassNotFoundException, IOException, SQLException {
		List<ItemModel> itemlist = dao.listOfItems(); 
		ItemModel actual = null;
		actual = helper.listToString(itemlist);
		System.out.println(actual);
		
		assertThat(actual, is(not(null)));
	}

	@Test
	public void addNewItemsTest() throws ClassNotFoundException, IOException, SQLException {
		try {
			localItemId = dao.addItem(model);
			isCreating = true;
	    } catch (SQLException e){
	        Assert.fail("SQLException occurred, method did not execute");
	    }
	}
	
	@Test
	public void updateItemsTest() throws ClassNotFoundException, IOException, SQLException {
		try {
			this.addNewItemsTest();
			model = new ItemModel();
			model.setItemName("Fish");
			model.setDescription("Cold");
			model.setPrice(10.00);
			model.setActive(0);
			model.setCategory("Cold");
			model.setImages("Updated");
			model.setId(localItemId);
			dao.updateItem(model);
	    } catch (SQLException e){
	        Assert.fail("SQLException occurred, method did not execute");
	    }	
	}
	
	@Test
	public void disableItemTest() throws ClassNotFoundException, SQLException, IOException {
		this.addNewItemsTest();
		model.setId(localItemId);
		try {
			dao.disableItem(model);
	 	} catch (SQLException e){
	        Assert.fail("SQLException occurred, method did not execute");
	    }	
	}
	
	@After
	public void clearTest() throws ClassNotFoundException, IOException, SQLException {
		if(isCreating == true) {
		helper.deleteItem(localItemId);
		}
		isCreating = false;
	}
}



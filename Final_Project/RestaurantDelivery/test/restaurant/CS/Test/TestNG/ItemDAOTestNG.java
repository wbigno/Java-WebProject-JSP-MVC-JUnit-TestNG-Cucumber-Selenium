package restaurant.CS.Test.TestNG;

import java.util.List;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import restaurant.CS.DAO.ItemDAO;
import restaurant.CS.MODEL.ItemModel;

public class ItemDAOTestNG {

	ItemDAO dao = null;
	ItemModel model = null;
	List<ItemModel> list = null;

	@BeforeMethod()
	public void preTest() {
		dao = new ItemDAO();
	}

	@Test
	public void addItemTest(String itemname, String description, Double price, Integer active, String category,
			String image) {
		model.setItemName(itemname);
		model.setDescription(description);
		model.setPrice(price);
		model.setActive(active);
		model.setCategory(category);
		model.setImages(image);
		int id;

		try {
			id = dao.addItem(model);
			Assert.assertNotNull(id);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void listOfItemsTest() {
		try {
			list = dao.listOfItems();
			Assert.assertNotNull(list);
		} catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	void listOfActiveItemsTest() {
		try {
			list = dao.listOfActiveItems();
			Assert.assertNotNull(list);
		} catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test(dataProvider = "UpdateItem")
	public void updateItemTest(Integer id, String itemname, String description, Double price, Integer active, String category,
			String image) { 
		
		model.setId(id);
		model.setItemName(itemname);
		model.setDescription(description);
		model.setPrice(price);
		model.setActive(active);
		model.setCategory(category);
		model.setImages(image);
		try {
			dao.updateItem(model);
			Assert.assertTrue(true);
		} catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void disableItemTest(Integer id) {
		model.setId(id);
		try {
			dao.disableItem(model);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void enableItemtest(Integer id) {
		model.setId(id);
		try {
			dao.enableItem(model);
			Assert.assertTrue(true);
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
}

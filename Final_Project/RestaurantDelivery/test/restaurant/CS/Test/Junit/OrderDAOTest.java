package restaurant.CS.Test.Junit;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import restaurant.CS.DAO.OrderDAO;
import restaurant.CS.MODEL.ItemModel;
import restaurant.CS.MODEL.OrderModel;

@RunWith(Parameterized.class)
public class OrderDAOTest {

	OrderDAO dao = null;
	OrderModel model = null;
	ItemModel item = null;
	int idForDelete;
	boolean isCreating;
	
	@Before
	public void prepTest() {
		dao = new OrderDAO();
		isCreating = false;
		idForDelete = 0;
		
	}
	
	public OrderDAOTest (Integer id, Integer itemId) {
		OrderModel model = new OrderModel();
		ItemModel item = new ItemModel();
		model.setId(id);
		item.setId(itemId);
	}
	
	@Parameters 
	public static Collection<Object[]> order() {
		Object[][] data = {
				{01, 01},
				{01, 02},
				{01, 04},
				{02, 02},
				{02, 03},
				{03, 01},
				{03, 02},
				{04, 04},
				{04, 02},
				{04, 03},
				
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void insertNewOrderTest() throws ClassNotFoundException, IOException, SQLException {
		try {
			dao.newOrder(null, model.getId());
	    } catch (SQLException e){
	        Assert.fail("SQLException occurred, method did not execute");
	    }
	}
	
	@Test
	public void getListOfAllOrdersTest() throws ClassNotFoundException, SQLException, IOException {
		try {
			dao.listAllOrders();
	    } catch (SQLException e){
	        Assert.fail("SQLException occurred, method did not execute");
	    }
	}
	
//	@Test
//	public void getUserPriorOrdersTest() throws ClassNotFoundException, IOException, SQLException {
//		PaymentDAOTest test = new PaymentDAOTest();
//		int id = 02;
//		List<OrderModel> expected = List(02, 1456789012, 789, 34567, 03, 20.0);
//		try {
//			assertEquals(expected, dao.userPriorOrders(id));
//	    } catch (SQLException e){
//	        Assert.fail("SQLException occurred, method did not execute");
//	    }
//	}
//
//	@Test
//	public void CancelOrderTest() throws ClassNotFoundException, IOException, SQLException {
//		try {
//			dao.cancelOrder();
//	    } catch (SQLException e){
//	        Assert.fail("SQLException occurred, method did not execute");
//	    }
//	}
	
}


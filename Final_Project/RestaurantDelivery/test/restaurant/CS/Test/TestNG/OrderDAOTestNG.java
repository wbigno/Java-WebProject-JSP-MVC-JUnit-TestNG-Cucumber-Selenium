package restaurant.CS.Test.TestNG;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import restaurant.CS.DAO.OrderDAO;
import restaurant.CS.MODEL.ItemModel;
import restaurant.CS.MODEL.OrderModel;
import restaurant.CS.MODEL.PaymentModel;

public class OrderDAOTestNG {

	OrderDAO dao = null;
	List<ItemModel> ilist = null;
	List<PaymentModel> plist = null;
	OrderModel model = null;
	ItemModel imodel = null;

	@BeforeMethod()
	public void preTest() {
		dao = new OrderDAO();

	}

	@Test(dataProvider = "NewOrder")
	public void newOrderTest(Integer itemid, Integer itemid2) throws ClassNotFoundException, IOException, SQLException {
		imodel.setId(itemid);
		imodel.setId(itemid2);
		ilist.add(imodel);
		int orderID = 5;
		++orderID;
		try {
			dao.newOrder(ilist, orderID);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void listAllOrders() throws ClassNotFoundException, SQLException, IOException {
		try {
			plist = dao.listAllOrders();
			Assert.assertNotNull(plist);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test(dataProvider = "PriorOrder")
	public void userPriorOrderTest(Integer userid) {
		try {
			plist = dao.userPriorOrders(userid);
			Assert.assertNotNull(plist);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

}

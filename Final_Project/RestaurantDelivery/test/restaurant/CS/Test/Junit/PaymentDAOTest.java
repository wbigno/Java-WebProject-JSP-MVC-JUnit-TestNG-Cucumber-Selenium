package restaurant.CS.Test.Junit;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import restaurant.CS.DAO.PaymentDAO;
import restaurant.CS.HELPERS.PaymentDAOHelper;
import restaurant.CS.MODEL.PaymentModel;

@RunWith(Parameterized.class)
public class PaymentDAOTest {
	
	PaymentDAO dao = null;
	PaymentModel model = null;
	PaymentDAOHelper helper = null;
	int localOrderId;
	boolean isCreating;
	
	@Before
	public void prepTest() {
		dao = new PaymentDAO();
		helper = new PaymentDAOHelper();
		isCreating = false;
		localOrderId = 0;
	}
	
	public PaymentDAOTest(Integer userId, Integer creditCard, Integer securityCode, Integer zipcode, Integer locationId,
							Double totalPayment) {
		model = new PaymentModel();
		model.setUserId(userId);
		model.setCreditCard(creditCard);
		model.setSecurityCode(securityCode);
		model.setZipcode(zipcode);
		model.setLocationId(locationId);
		model.setTotalPayment(totalPayment);
		
	}
	
	@Parameters
	public static Collection<Object[]> payment() {
		Object[][] data = {
				{1, 1234567890, 123, 12345, 01, 20.0},
				{1, 1345678901, 456, 23456, 02, 20.0},
				{2, 1456789012, 789, 34567, 03, 20.0},
				{3, 1567890123, 234, 45678, 04, 20.0},
		}; 
		return Arrays.asList(data);
	}
	
	@Test
	public void insertPaymentDetailsTest() throws ClassNotFoundException, SQLException, IOException {
		int actual = 0;
			actual = dao.addPayment(model);
		
		assertThat(actual, is(not(equalTo(0))));
	}
	
	@After
	public void clearTest() {
//		if(isCreating == true) {
//		helper.deleteItem(localOrderId);
//		}
//		isCreating = false;
	}

}

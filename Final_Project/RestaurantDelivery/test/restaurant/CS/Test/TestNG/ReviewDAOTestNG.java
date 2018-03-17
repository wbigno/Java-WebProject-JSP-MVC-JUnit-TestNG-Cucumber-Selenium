package restaurant.CS.Test.TestNG;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import restaurant.CS.DAO.ReviewDAO;
import restaurant.CS.MODEL.ReviewModel;

public class ReviewDAOTestNG {

	ReviewDAO dao = null;
	ReviewModel model = null;

	@BeforeMethod()
	public void preTest() {
		dao = new ReviewDAO();
	}

	@Test(dataProvider = "Review", dataProviderClass = DataProviderTestNG.class)
	public void addReviewTest(Integer userid, Integer itemid, String reviewdetails)
			throws ClassNotFoundException, IOException {
		ReviewModel model = new ReviewModel();
		model.setItemId(itemid);
		model.setUserId(userid);
		model.setReviewDetails(reviewdetails);

		try {
			dao.addReview(model);
			Assert.assertTrue(true);
		} catch (SQLException e) {
			Assert.assertTrue(false);
		}

	}

	@Test(dataProvider = "Delete", dataProviderClass = DataProviderTestNG.class)
	public void deleteReviewTest(Integer userid) {
		ReviewModel model = new ReviewModel();
		model.setUserId(userid);
		try {
			dao.deleteReview(model);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}

	}

	@Test(dataProvider = "Change", dataProviderClass = DataProviderTestNG.class)
	public void deleteReviewTest(Integer userid, String reviewdetails) {
		ReviewModel model = new ReviewModel();
		model.setUserId(userid);
		model.setReviewDetails(reviewdetails);
		try {
			dao.changeReview(model);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void getAllReviewTest() {
		List<ReviewModel> list;
		try {
			list = dao.getAllUserReviews();
			Assert.assertNotNull(list);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}
}

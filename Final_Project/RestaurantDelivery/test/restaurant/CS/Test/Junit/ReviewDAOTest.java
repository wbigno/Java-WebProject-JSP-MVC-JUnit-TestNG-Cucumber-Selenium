package restaurant.CS.Test.Junit;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import restaurant.CS.DAO.ReviewDAO;
import restaurant.CS.MODEL.ReviewModel;


@RunWith(Parameterized.class)
public class ReviewDAOTest {

	ReviewDAO dao = null;
	ReviewModel model = null;
	

	@Before
	public void prepTest() {
		dao = new ReviewDAO();

	}
	
	public ReviewDAOTest(Integer userId, Integer itemId, String reviewDetails) {
		model = new ReviewModel();
		model.setUserId(userId);
		model.setItemId(itemId);
		model.setReviewDetails(reviewDetails);
		
	}
	
	@Parameters
	public static Collection<Object[]> review() {
		Object[][] data = {
				{1, 01, "This is an amazing product"},
				{2, 03, "This is an amazing product"},
				{2, 02, "This is an amazing product"},
				{3, 02, "This is an amazing product"},
				{3, 01, "This is an amazing product"},
				{4, 02, "This is an amazing product"},
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void addReviewtest() throws ClassNotFoundException, SQLException, IOException {
		try {
			dao.addReview(model);
	    } catch (SQLException  e){
	        Assert.fail("SQLException occurred, method did not execute");
	    }
	}
	
	@Test
	public void deleteReviewTest() throws ClassNotFoundException, IOException, SQLException {
			dao.deleteReview(model);
		
		//assertThat(actual, (equals(null)));
		
	}
	
	@Test
	public void changeReviewTest() throws ClassNotFoundException, SQLException, IOException {
		model.setReviewDetails("this has been updated");
		dao.changeReview(model);
		String actual = model.getReviewDetails();
		
		assertThat(actual, (equals("this has been updated")));
		
	}
	
	@Test
	public void getAllReviewsByUserTest() throws ClassNotFoundException, SQLException, IOException {
		
		dao.getAllUserReviews();
	
		
			
	}
}

package restaurant.CS.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.CS.DAO.ReviewDAO;
import restaurant.CS.MODEL.ReviewModel;

public class ReviewBO {

	public void addReview(ReviewModel reviewObj) throws SQLException, ClassNotFoundException, IOException {
		final ReviewDAO reviewDAO = new ReviewDAO();
		try
		{
			reviewDAO.addReview(reviewObj);
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	public void deleteReview(ReviewModel reviewObj) throws ClassNotFoundException, IOException, SQLException {
		final ReviewDAO reviewDAO = new ReviewDAO();
		try
		{
			reviewDAO.deleteReview(reviewObj);
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	public void changeReview(ReviewModel reviewObj) throws SQLException, ClassNotFoundException, IOException {
		final ReviewDAO reviewDAO = new ReviewDAO();
		try
		{
			reviewDAO.changeReview(reviewObj);
		}catch(SQLException e) {
			e.getMessage();
		}
	}
	
	public List<ReviewModel> getAllUserReviews() throws SQLException, ClassNotFoundException, IOException {
		final ReviewDAO reviewDAO = new ReviewDAO();
		List<ReviewModel> reviewList = new ArrayList<ReviewModel>();
		try
		{
			reviewList = reviewDAO.getAllUserReviews();
		}catch(SQLException e) {
			e.getMessage();
		}
		
		return reviewList;
		
	}
}

package restaurant.CS.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import restaurant.CS.MODEL.ReviewModel;

public interface IReviewDAO {
	
	public void addReview(ReviewModel reviewObj) throws SQLException, ClassNotFoundException, IOException;
	
	public void deleteReview(ReviewModel reviewObj) throws ClassNotFoundException, IOException, SQLException; 
	
	public void changeReview(ReviewModel reviewObj) throws SQLException, ClassNotFoundException, IOException; 
	
	public List<ReviewModel> getAllUserReviews() throws SQLException, ClassNotFoundException, IOException;
	
		
}

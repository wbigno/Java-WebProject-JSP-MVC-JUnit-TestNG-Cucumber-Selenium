package restaurant.CS.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restaurant.CS.MODEL.ReviewModel;
import restaurant.CS.Util.OracleSqlQueries;

public class ReviewDAO implements IReviewDAO {

		public void addReview(ReviewModel reviewObj) throws SQLException, ClassNotFoundException, IOException {
			Connection conn = null;
			PreparedStatement stmt = null;
			OracleConnection oracle = new OracleConnection();	
			try {
				
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.NEWREVIEW);
				stmt.setInt(1, reviewObj.getUserId());
				stmt.setInt(2, reviewObj.getItemId());
				stmt.setString(3, reviewObj.getReviewDetails());
				stmt.executeUpdate();
				
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				stmt.close();
				conn.close();
			}
		}
		
		public void deleteReview(ReviewModel reviewObj) throws ClassNotFoundException, IOException, SQLException {
			Connection conn = null; 
			PreparedStatement stmt = null;
			OracleConnection oracle = new OracleConnection();
			try {
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.DELETEREVIEW);
				stmt.setInt(1, reviewObj.getUserId()); // this would be set by the JSP page request
				stmt.executeUpdate();
				
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				stmt.close();
				conn.close();
			}
			
		}
		
		public void changeReview(ReviewModel reviewObj) throws SQLException, ClassNotFoundException, IOException {
			Connection conn = null;
			PreparedStatement stmt = null;		
			OracleConnection oracle = new OracleConnection();
			try {
				
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.CHANGEREVIEW);
				stmt.setString(1, reviewObj.getReviewDetails());
				stmt.setInt(2, reviewObj.getUserId());
				stmt.executeUpdate();
					
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				stmt.close();
				conn.close();
			}	
		}
		
		public List<ReviewModel> getAllUserReviews() throws SQLException, ClassNotFoundException, IOException {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			OracleConnection oracle = new OracleConnection();
			List<ReviewModel> reviewList = null;
			ReviewModel reviewObj = null;
			try {
				
				conn = oracle.getConnection();
				stmt = conn.prepareStatement(OracleSqlQueries.GETREVIEWS);
				result = stmt.executeQuery();
				reviewList = new ArrayList<ReviewModel>();
				while(result.next()) {
					reviewObj = new ReviewModel();
					reviewObj.setUserId(result.getInt(1));
					reviewObj.setItemId(result.getInt(2));
					reviewObj.setReviewDetails(result.getString(3));
					reviewList.add(reviewObj);
					System.out.println(reviewList.size());
				}
				System.out.println(reviewList.size());
			}catch(SQLException e) {
				e.getMessage();
			}finally {
				result.close();
				stmt.close();
				conn.close();
			}
			return reviewList;
		} 
	}

package restaurant.CS.SERVLETS;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.CS.BO.ReviewBO;
import restaurant.CS.MODEL.ItemModel;
import restaurant.CS.MODEL.ReviewModel;
import restaurant.CS.Util.RestaurantConstants;

@WebServlet("/OrderItemReviewFlow")
public class OrderItemReviewFlow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = request.getSession().getServletContext();
		ReviewBO revBO = new ReviewBO();
		List<ItemModel> itemlist = null;
		List<ReviewModel> reviewList = new ArrayList<ReviewModel>();
		List<ItemModel> reviewItem = new ArrayList<ItemModel>();
		String action = request.getParameter("action");
		// action is coming from the MenuItemsPage.jsp
		if ("reviewItem".equals(action)) {
			Integer itemId = (Integer.parseInt(request.getParameter("reviewItem")));
			itemlist = (List<ItemModel>) context.getAttribute("list");
			for (int i = 0; i < itemlist.size(); i++) {
				if (itemId == itemlist.get(i).getId()) {
					reviewItem.add((ItemModel) itemlist.get(i));
					session.setAttribute("reviewItem", reviewItem);
					try {
						reviewList = revBO.getAllUserReviews();
						context.setAttribute("reviewList", reviewList);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					final RequestDispatcher dispatcherReview = request.getRequestDispatcher(RestaurantConstants.SINGLE);
					dispatcherReview.forward(request, response);
				}
			}
		}

		if ("submitReview".equals(action)) {
			ReviewModel reviewObj = new ReviewModel();
			Integer itemId = (Integer.parseInt((request.getParameter("itemId"))));
			String reviewDetails = (request.getParameter("reviewDetails"));
			Integer userId = (Integer.parseInt(session.getAttribute("userId").toString()));
			reviewObj.setItemId(itemId);
			reviewObj.setReviewDetails(reviewDetails);
			reviewObj.setUserId(userId);

			try {
				revBO.addReview(reviewObj);
				final RequestDispatcher dispatcherReview = request.getRequestDispatcher(RestaurantConstants.MENU);
				dispatcherReview.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

package restaurant.CS.SERVLETS;

import java.io.IOException;
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

import restaurant.CS.MODEL.LocationModel;
import restaurant.CS.Util.RestaurantConstants;

@WebServlet("/OrderReviewProcessFlow")
public class OrderReviewProcessFlow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = request.getSession().getServletContext();
		List<LocationModel> loclist = null;
		List<LocationModel> delLoc = new ArrayList<LocationModel>();
		String action = request.getParameter("action");

		if ("processOrder".equals(action)) {
			// cart in session validation, otherwise send back to login page
			if (session.getAttribute("Cart").equals(null)) {
				session.setAttribute("errorMessage", "Your cart is empty, please select your item(s)");
				final RequestDispatcher dispatcherLogin = request.getRequestDispatcher(RestaurantConstants.MENU);
				dispatcherLogin.forward(request, response);
			}// user in session validation, otherwise send back to login page
			if (session.getAttribute("userName") == null) {
				session.setAttribute("errorMessage", "An Error has occured, please login to continue");
				final RequestDispatcher dispatcher = request.getRequestDispatcher(RestaurantConstants.LOGIN);
				dispatcher.forward(request, response);
			} 
			else {
				loclist = (List<LocationModel>) context.getAttribute("loc");
				for (int i = 0; i < loclist.size(); i++) {
					if (( session.getAttribute("location") == (Integer) loclist.get(i).getId())) {
						delLoc.add((LocationModel) loclist.get(i));
						session.setAttribute("delLoc", delLoc);
						final RequestDispatcher dispatcherReceipt = request.getRequestDispatcher(RestaurantConstants.PAYMENT);
						dispatcherReceipt.forward(request, response);
					}
				}
			}
		}
		// action is coming from the ReviewOrderPage.jsp
		if ("cancelOrder".equals(action)) {
			// user in session to remove all cart items, redirect to Menu page
			session.removeAttribute("Cart");
			request.getRequestDispatcher(RestaurantConstants.MENU).forward(request, response);
		}
	}
}

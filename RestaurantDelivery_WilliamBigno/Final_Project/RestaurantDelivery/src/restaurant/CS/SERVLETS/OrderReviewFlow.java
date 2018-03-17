package restaurant.CS.SERVLETS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.CS.BO.PaymentBO;
import restaurant.CS.MODEL.ItemModel;
import restaurant.CS.MODEL.PaymentModel;
import restaurant.CS.Util.RestaurantConstants;

@WebServlet("/OrderReviewFlow")
public class OrderReviewFlow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = request.getSession().getServletContext();
		PaymentBO payBO = null;
		@SuppressWarnings("unused")
		String action = request.getParameter("action");
		Map<Integer, Integer> cart = new HashMap<Integer, Integer>();
		List<ItemModel> itemlist = null;
		List<PaymentModel> fees = null;
		List<ItemModel> cartlist = new ArrayList<ItemModel>();

		if (session.getAttribute("Cart") == null) {
			if (session.getAttribute("userName") == null) {
				session.setAttribute("errorMessage", "An Error has occured, please login to continue");
				final RequestDispatcher dispatcher = request.getRequestDispatcher(RestaurantConstants.LOGIN);
				dispatcher.forward(request, response);
			}
			if (session.getAttribute("Cart") == null) {
				session.setAttribute("errorMessage", "Your cart is empty, please select your item(s)");
				final RequestDispatcher dispatcherLogin = request.getRequestDispatcher(RestaurantConstants.MENU);
				dispatcherLogin.forward(request, response);
			}

		} else {
			itemlist = (List<ItemModel>) context.getAttribute("list");
			cart = (Map<Integer, Integer>) session.getAttribute("Cart");
			for (int i = 0; i < itemlist.size(); i++) {
				if (cart.containsKey(itemlist.get(i).getId())) {
					cartlist.add((ItemModel) itemlist.get(i));
				}
			}
			payBO = new PaymentBO();
			fees = payBO.getTotal(cartlist);
			session.setAttribute("fees", fees);
			session.setAttribute("cartlist", cartlist); // set Item cartlist to session
			// user dispatched to ReviewOrderPage.jsp once cart is loaded with complete
			// details for items selected
			final RequestDispatcher dispatcherReview = request.getRequestDispatcher(RestaurantConstants.REVIEW);
			dispatcherReview.forward(request, response);
		}
	}
}

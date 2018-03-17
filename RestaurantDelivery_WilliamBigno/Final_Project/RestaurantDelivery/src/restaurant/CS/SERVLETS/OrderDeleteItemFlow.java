package restaurant.CS.SERVLETS;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/OrderDeleteItemFlow")
public class OrderDeleteItemFlow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PaymentBO payBO = null;
		String action = request.getParameter("action");
		List<PaymentModel> fees = null;
		List<ItemModel> cartlist = null;
		Map<Integer, Integer> cart = new HashMap<Integer, Integer>();
		Integer itemId = (Integer.parseInt(request.getParameter("itemId")));
		cart = (Map<Integer, Integer>) session.getAttribute("Cart");
		// action is coming from the ReviewOrderPage.jsp
		if ("deleteItem".equals(action)) {
			if (cart.containsKey(itemId)) {
				int count = cart.get(itemId);
				if (count >= 2) {
					--count;
					cart.put(itemId, count);
					// user is sent back to ReviewOrderPage.jsp after each deletion so page will
					// reload with current items
					payBO = new PaymentBO();
					cartlist = (List<ItemModel>) session.getAttribute("cartlist");
					fees = payBO.getTotal(cartlist);
					session.setAttribute("fees", fees);
					final RequestDispatcher dispatcherUpdateReview = request
							.getRequestDispatcher(RestaurantConstants.REVIEW);
					dispatcherUpdateReview.forward(request, response);
				} else {
					cart.remove(itemId);
					// user is sent back to ReviewOrderPage.jsp after each deletion so page will
					// reload with current items
					payBO = new PaymentBO();
					cartlist = (List<ItemModel>) session.getAttribute("cartlist");
					fees = payBO.getTotal(cartlist);
					session.setAttribute("fees", fees);
					final RequestDispatcher dispatcherUpdateReview = request
							.getRequestDispatcher(RestaurantConstants.REVIEW);
					dispatcherUpdateReview.forward(request, response);
				}
			}
		}
	}
}

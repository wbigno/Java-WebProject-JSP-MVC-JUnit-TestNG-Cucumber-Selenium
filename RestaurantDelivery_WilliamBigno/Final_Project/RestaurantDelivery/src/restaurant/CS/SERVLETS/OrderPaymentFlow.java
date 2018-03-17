package restaurant.CS.SERVLETS;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.CS.BO.OrderBO;
import restaurant.CS.BO.PaymentBO;
import restaurant.CS.BO.UserBO;
import restaurant.CS.MODEL.ItemModel;
import restaurant.CS.MODEL.PaymentModel;
import restaurant.CS.MODEL.UserDataModel;
import restaurant.CS.Util.RestaurantConstants;

@WebServlet("/OrderPaymentFlow")
public class OrderPaymentFlow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@SuppressWarnings({ "null", "unchecked", "unused" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int orderId;
		PaymentBO payBO = null;
		OrderBO orderBO = null;
		UserBO userBO = null;
		PaymentModel paymentObj = null;
		UserDataModel userObj = null;
		List<ItemModel> itemlist = new ArrayList<ItemModel>();
		String action = request.getParameter("action");
		// action is coming from the LocationPage.jsp
		if ("processPayment".equals(action)) {
			// user in session validation, otherwise send back to login page
			if (session.getAttribute("userName") == null) {
				session.setAttribute("errorMessage", "Your Order Failed, please Login and try again");
				final RequestDispatcher dispatcher = request.getRequestDispatcher(RestaurantConstants.LOGIN);
				dispatcher.forward(request, response);
			} else {
				payBO = new PaymentBO();
				Double totalPayment = 0.00;
				List<PaymentModel> fees = new ArrayList<PaymentModel>();
				fees = (List<PaymentModel>) session.getAttribute("fees");
				for (PaymentModel model : fees) {
					totalPayment = model.getTotalPayment();
		
				}
				try {
					paymentObj = new PaymentModel();
					paymentObj.setUserId(Integer.parseInt(session.getAttribute("userId").toString()));
					paymentObj.setLocationId(Integer.parseInt(session.getAttribute("location").toString()));
					paymentObj.setCreditCard(Integer.parseInt(request.getParameter("creditCard")));
					paymentObj.setSecurityCode(Integer.parseInt(request.getParameter("securityCode")));
					paymentObj.setZipcode(Integer.parseInt(request.getParameter("zipcode")));
					paymentObj.setTotalPayment(totalPayment);
					payBO.addPayment(paymentObj);
					itemlist = (List<ItemModel>) session.getAttribute("Cart");
					orderId = 5;
					orderBO.newOrder(itemlist, orderId);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// user sent to ReceiptPage.jsp to review final receipt and view prior orders
				// and submit product reviews
				final RequestDispatcher dispatcherReview = request.getRequestDispatcher(RestaurantConstants.RECEIPT);
				dispatcherReview.forward(request, response);
			}
		}
	}
}

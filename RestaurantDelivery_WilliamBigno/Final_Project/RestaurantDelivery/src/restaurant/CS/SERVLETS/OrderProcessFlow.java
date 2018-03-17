package restaurant.CS.SERVLETS;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.CS.Util.RestaurantConstants;

@WebServlet("/OrderProcessFlow")
public class OrderProcessFlow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		 String action = request.getParameter("action");
			// action is coming from the MenuItemPage.jsp
			if ("processOrder".equals(action)) {
				// user in session validation, otherwise send back to login page
				if(session.getAttribute("userName").equals(null)) {
					session.setAttribute("errorMessage", "An Error has occured, please login to continue");
					final RequestDispatcher dispatcherLogin = request.getRequestDispatcher(RestaurantConstants.LOGIN);
					dispatcherLogin.forward(request, response);
				}
				if(session.getAttribute("Cart") == null) {
					session.setAttribute("errorMessage", "Your cart is empty, please select your item(s)");
					final RequestDispatcher dispatcherLogin = request.getRequestDispatcher(RestaurantConstants.MENU);
					dispatcherLogin.forward(request, response);
				}
				else {
					// user dispatched to LocationPage.jsp to select location
					session.removeAttribute("errorMessage");
					 final RequestDispatcher dispatcherLoc = request.getRequestDispatcher(RestaurantConstants.LOC);
					 dispatcherLoc.forward(request, response);
				}		 
		 	}
		}
	}


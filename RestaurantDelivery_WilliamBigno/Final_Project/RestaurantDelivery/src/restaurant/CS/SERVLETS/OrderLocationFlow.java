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


@WebServlet("/OrderLocationFlow")
public class OrderLocationFlow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		
		 String action = request.getParameter("action");
		 // action is coming from the LocationPage.jsp
		if("addLocation".equals(action)) {
				// user in session validation, otherwise send back to login page
				if(session.getAttribute("userName") == null){
					session.setAttribute("errorMessage", "An Error has occured, please login to continue");
					final RequestDispatcher dispatcher = request.getRequestDispatcher(RestaurantConstants.LOGIN);
					dispatcher.forward(request, response);
				}
				else {
				// user sent to ReviewOrderPage.jsp to review order
					int locID = Integer.parseInt(request.getParameter("locId"));
					session.setAttribute("location", locID);
					request.getRequestDispatcher("OrderReviewFlow").forward(request, response); //This line calls another servlet
			}
		}
		if ("cancelOrder".equals(action)) {
			session.removeAttribute("Cart");
			final RequestDispatcher dispatcherLoc = request.getRequestDispatcher(RestaurantConstants.MENU);
			 dispatcherLoc.forward(request, response);
		}
	}
}

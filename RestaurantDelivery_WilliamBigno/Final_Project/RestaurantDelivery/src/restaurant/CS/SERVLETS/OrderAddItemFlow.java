package restaurant.CS.SERVLETS;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.CS.Util.RestaurantConstants;

/**
 * Servlet implementation class OrderAddItemFLow
 */
@WebServlet("/OrderAddItemFlow")
public class OrderAddItemFlow extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		 String action = request.getParameter("action");
		 Map<Integer,Integer> cart = new HashMap<Integer,Integer>();
			// action is coming from the MenuItemsPage.jsp
			if ("addCart".equals(action)) {
				String itemId = (request.getParameter("itemId"));
			
				if(session.getAttribute("Cart") != null ) {
			        cart = (Map<Integer, Integer>) session.getAttribute("Cart");
			        
			        if(cart.containsKey(Integer.parseInt(itemId))) {
			            int current = cart.get(Integer.parseInt(itemId));
			            ++current;
			            cart.put(Integer.parseInt(itemId), current);
			        }else {
			            cart.put(Integer.parseInt(itemId), 1);
			        }
				}else {
			        cart.put(Integer.parseInt(itemId), 1);
			        session.setAttribute("Cart", cart);
				}
				// redirect back to MenuItemsPage.jsp to add more items
			
				session.removeAttribute("errorMessage");
				final RequestDispatcher dispatcherMenu = request.getRequestDispatcher(RestaurantConstants.MENU);
				dispatcherMenu.forward(request, response);
		}		
	}		
}

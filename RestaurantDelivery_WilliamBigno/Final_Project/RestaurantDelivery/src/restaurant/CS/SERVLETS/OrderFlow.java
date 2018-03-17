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

import restaurant.CS.BO.ItemBO;
import restaurant.CS.BO.LocationBO;
import restaurant.CS.MODEL.ItemModel;
import restaurant.CS.MODEL.LocationModel;
import restaurant.CS.Util.RestaurantConstants;


@WebServlet("/OrderFlow")
public class OrderFlow  extends HttpServlet  {
	private static final long serialVersionUID = 1L;

		ItemBO ibo = null;
		ItemModel imodel = null;
		LocationBO lbo = null;
		LocationModel lmodel = null;
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
		response.getWriter().append("Served at: ").append(request.getContextPath());}


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    ServletContext context = request.getSession().getServletContext();
		    HttpSession session = request.getSession();
		    List<ItemModel> itemlist = new ArrayList<ItemModel>();
		    List<LocationModel> loclist = new ArrayList<LocationModel>();
		    ibo = new ItemBO();
		    imodel = new ItemModel();
		    lbo = new LocationBO();
		    lmodel = new LocationModel();
		   
		    try { 
				itemlist = ibo.listOfItems();		// call to BO to request from DB Item List
				loclist = lbo.listOfLocation();		// call to BO to request from DB Loc List
				
				context.setAttribute("list", itemlist);	// set Item List to context
			    context.setAttribute("loc", loclist);	// set Item Loc to context
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			// user in session validation, otherwise send back to login page
		    if(session.getAttribute("userName").equals(null)){
		    	session.setAttribute("errorMessage", "An Error has occured, with setting userName please login to continue");
				final RequestDispatcher dispatcher = request.getRequestDispatcher(RestaurantConstants.LOGIN);
				dispatcher.forward(request, response);
			} // validation that context has item list loaded prior to allowing user to move to MenuItemsPage.jps
			if(context.getAttribute("list") != null) {
		    	//user dispatched to MenuItemsPage.jsp once calls to DB have been made to load context for Item list and Loc List
			    final RequestDispatcher dispatcherMenu = request.getRequestDispatcher(RestaurantConstants.MENU);
				dispatcherMenu.forward(request, response);	
			}
			else {
				try { // call to BO to request Item List from DB
					itemlist = ibo.listOfItems();
					context.setAttribute("list", itemlist);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			    	//user dispatched to MenuItemsPage.jsp once calls to DB have been made to load context for Item list and Loc List
				    final RequestDispatcher dispatcherMenu = request.getRequestDispatcher(RestaurantConstants.MENU);
					dispatcherMenu.forward(request, response);	
			}
		}
	}		



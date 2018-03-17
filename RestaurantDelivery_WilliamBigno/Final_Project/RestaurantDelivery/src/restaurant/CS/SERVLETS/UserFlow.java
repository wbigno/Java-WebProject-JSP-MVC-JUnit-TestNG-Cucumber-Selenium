package restaurant.CS.SERVLETS;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.CS.BO.UserBO;
import restaurant.CS.MODEL.UserDataModel;
import restaurant.CS.Util.RestaurantConstants;


@WebServlet("/UserFlow")

public class UserFlow extends HttpServlet  {
private static final long serialVersionUID = 1L;

	UserBO bo = null;
	UserDataModel loginuser = null;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
response.getWriter().append("Served at: ").append(request.getContextPath());}


@SuppressWarnings("unused")
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getParameter("action");
	    HttpSession session = request.getSession();
	    RequestDispatcher dispatcher = null;
	    Integer id = 0;
	    String userId = " ";
	    String userName = " ";
		String email = " ";
		String password = " ";
		String password2 = " ";
		 // action is coming from the LoginPage.jsp
	    if ("Login".equals(action)) {
	    	try {
	    		bo = new UserBO();
	    		loginuser = new UserDataModel();
	    		loginuser.setUserName(userName = request.getParameter("userName"));
				loginuser = bo.loginUser(loginuser.getUserName());
				loginuser.setPasswordLogin(password = request.getParameter("password"));
				loginuser.setUserName(userName = request.getParameter("userName"));
				String check = bo.validateUser(loginuser);
				// validate if admin
				if(loginuser != null && check == "admin") {
					session.setAttribute("userName", userName);
						if(session.getAttribute("errorMessage") != null){
						session.removeAttribute("errorMessage");
						}
						if(session.getAttribute("newUserMessage") != null){
						session.removeAttribute("newUserMessage");
						}
					// forward admin to AddminAccountPage
					final RequestDispatcher dispatchers = request.getRequestDispatcher(RestaurantConstants.ADMIN);
					dispatchers.forward(request, response);
				// validate if user has account	
				}else if (loginuser != null && check == "user") {
					session.setAttribute("userId", loginuser.getId());
					session.setAttribute("userName", userName);
						if(session.getAttribute("errorMessage") != null){
						session.removeAttribute("errorMessage");
						}
						if(session.getAttribute("newUserMessage") != null){
						session.removeAttribute("newUserMessage");
						}
					// forward to OrderFlow Servlet to perform backend preparation work for user
					request.getRequestDispatcher("OrderFlow").forward(request, response); //This line calls another servlet
				// validation returned potential invalid user
				}else if (check == "invalid") {
					// forward to LoginPage.jsp to attempt to login in again or register as new user
					session.setAttribute("errorMessage", "Your login Failed, please try again or Register as a new user");
					final RequestDispatcher dispatchers = request.getRequestDispatcher(RestaurantConstants.LOGIN);
					dispatchers.forward(request, response);
				}
					
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	    	 // action is coming from the RegistrationPage.jsp
	    }else if("Registration".equals(action)){
	    	
	    	try {
	    		// validation that registration form has matching passwords from new user
	    		if(password2.equals(password)) {
	    		// setting registration information from form to UserDataModel
	    		UserDataModel loginuser = new UserDataModel();
	    		loginuser.setFirstName(request.getParameter("firstName"));
	    		loginuser.setLastName(request.getParameter("lastName"));
	    		loginuser.setGender(request.getParameter("gender"));
	    		loginuser.setAddress(request.getParameter("address"));
	    		loginuser.setZipcode(Integer.parseInt(request.getParameter("zipCode")));
	    		loginuser.setPhone(Integer.parseInt(request.getParameter("phone")));
	    		loginuser.setEmail(request.getParameter("email"));
	    		loginuser.setPassword(request.getParameter("password"));
	    		password2 = request.getParameter("password2");
	    		email = request.getParameter("email");
		    		bo = new UserBO();
		    		id = bo.registerNewUser(loginuser);		// creating new user in DB
		    		
		    		// validating that a user Id was returned from DB to confirm new account was created
		    		if(id != 0) {	
			        		// new user forwarded to LoginPage.jsp to attempt first login to account
		    				session.setAttribute("newUserMessage", "Your account has been created, please login to place your order");
			        		final RequestDispatcher dispatchers = request.getRequestDispatcher(RestaurantConstants.LOGIN);
							dispatchers.forward(request, response);
			        }else 	{
			        		// error in creating new user account, error message displayed and request from user to attempt again to register
			        		session.setAttribute("errorMessage", "Your Registration Failed, please try again");
			        		final RequestDispatcher dispatchers = request.getRequestDispatcher(RestaurantConstants.REGISTER);
							dispatchers.forward(request, response);
			        		}	
		    		}
	    		
	    			}catch (ClassNotFoundException e) {
		    			
		    		e.printStackTrace();
		    		}catch (SQLException e) {
		    			
		    		e.printStackTrace();   		  	
		    		}
		    	
	    		} else {
	    			// validation failure that user entered the same password correctly when registering
	    			// forwarded back to RegistraionPage.jsp with error message displayed to inform user of error
	    			session.setAttribute("errorMessage", "The Passwords did not match, please try again");
	    			final RequestDispatcher dispatchers = request.getRequestDispatcher(RestaurantConstants.REGISTER);
					dispatchers.forward(request, response);
			}	  		
		}
    }


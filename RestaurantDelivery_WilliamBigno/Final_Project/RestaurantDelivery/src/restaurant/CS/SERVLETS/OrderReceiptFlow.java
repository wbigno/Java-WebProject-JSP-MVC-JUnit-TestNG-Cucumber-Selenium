package restaurant.CS.SERVLETS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant.CS.MODEL.LocationModel;


@WebServlet("/OrderReceiptFlow")
public class OrderReceiptFlow extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletContext context = request.getSession().getServletContext();
		    HttpSession session = request.getSession();
		    LocationModel locationObj = new LocationModel();
		    List<LocationModel> loclist = new ArrayList<LocationModel>();
		    List<LocationModel> delLoc = new ArrayList<LocationModel>();
		    int locID = (int) session.getAttribute("location");
		   
		    
		    if (context.getAttribute("loc") != null) {
		    	 loclist = (List<LocationModel>) context.getAttribute("loc");
		    	for(int i=0; i < loclist.size(); i++) {
		    		if(loclist.get(i).getId() == locID) {
		    			locationObj.setId(loclist.get(i).getId());
		    			locationObj.setLocationName(loclist.get(i).getLocationName());
		    			locationObj.setAddress(loclist.get(i).getAddress());
		    			locationObj.setStaffCount(loclist.get(i).getStaffCount());
		    			locationObj.setZipcode(loclist.get(i).getZipcode());
		    			locationObj.setImage(loclist.get(i).getImage());
		    			delLoc.add(locationObj);
		    			session.setAttribute("delLoc", delLoc);
		    		}
		    	}
		    }
		    
		    //need to carry over final cart items to be displayed
		    
		    //need to calculate final payment info to display total, tax, and total items
	}

}

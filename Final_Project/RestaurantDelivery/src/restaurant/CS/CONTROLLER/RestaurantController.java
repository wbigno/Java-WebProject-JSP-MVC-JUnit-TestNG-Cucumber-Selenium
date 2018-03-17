package restaurant.CS.CONTROLLER;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestaurantController {
	
//	@ModelAttribute("priorOrderByUser")
//	public void priorOrderByUser(Model modelOrder, HttpSession session) {
//	OrderBO orderBO = new OrderBO();
//	Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
//	List<PaymentModel> orderListByUser = new ArrayList<PaymentModel>();
//	try {
//		orderListByUser = orderBO.userPriorOrders(userId);
//	} catch (ClassNotFoundException | IOException | SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	modelOrder.addAttribute("orderListByUser", orderListByUser);
//	}
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView displayHomePage() {
		ModelAndView model = new ModelAndView("HomePage");

		return model;

	}

	@RequestMapping(value = "/HomePage", method = RequestMethod.GET)
	public ModelAndView redirectDisplayHomePage() {
		ModelAndView model = new ModelAndView("HomePage");

		return model;

	}

	@RequestMapping(value = "/LoginPage", method = RequestMethod.GET)
	public ModelAndView displayLoginPage(HttpSession session) {
		session.removeAttribute("errorMessage");
		ModelAndView model = new ModelAndView("LoginPage");

		return model;

	}

	@RequestMapping(value = "/RegistrationPage", method = RequestMethod.GET)
	public ModelAndView displayRegistrationPage(HttpSession session) {
		session.removeAttribute("errorMessage");
		ModelAndView model = new ModelAndView("RegistrationPage");

		return model;

	}

	@RequestMapping(value = "/SingleItemPage", method = RequestMethod.GET)
	public ModelAndView displaySingleItemPage() {
		ModelAndView model = new ModelAndView("SingleItemPage");

		return model;

	}

	@RequestMapping(value = "/MenuItemsPage", method = RequestMethod.GET)
	public ModelAndView displayMenuItemPage(HttpSession session) {
		if (session.getAttribute("userName") == null) {
			ModelAndView model1 = new ModelAndView("HomePage");
			session.setAttribute("errorMessage","An Error has occured, to access the Menu Page Please Login or Register");
			return model1;
		}

		ModelAndView model = new ModelAndView("MenuItemsPage");
		return model;

	}

	@RequestMapping(value = "/RegularUserPage", method = RequestMethod.GET)
	public ModelAndView displayRegularUserPage() {
		ModelAndView model = new ModelAndView("RegularUserPage");

		return model;

	}

	@RequestMapping(value = "/ReceiptPage", method = RequestMethod.GET)
	public ModelAndView displayReceiptPage() {
		ModelAndView model = new ModelAndView("ReceiptPage");

		return model;

	}

	@RequestMapping(value = "/PaymentInformationPage", method = RequestMethod.GET)
	public ModelAndView displayPaymentInformationPage() {
		ModelAndView model = new ModelAndView("PaymentInformationPage");

		return model;

	}

	@RequestMapping(value = "/LogOutPage", method = RequestMethod.GET)
	public ModelAndView displayLogOutPage(HttpSession session) {
		session.invalidate();
		ModelAndView model = new ModelAndView("LogOutPage");
		
		return model;

	}

	@RequestMapping(value = "/LocationPage", method = RequestMethod.GET)
	public ModelAndView displayLocationPage() {
		ModelAndView model = new ModelAndView("LocationPage");

		return model;

	}

	@RequestMapping(value = "/ListOfOrderPage", method = RequestMethod.GET)
	public ModelAndView displayListOfOrderPage() throws ClassNotFoundException, IOException, SQLException {
		
		ModelAndView model = new ModelAndView("ListOfOrderPage");

		return model;

	}

	@RequestMapping(value = "/ReviewOrderPage", method = RequestMethod.GET)
	public ModelAndView displayCartPage() {
		ModelAndView model = new ModelAndView("ReviewOrderPage");

		return model;

	}

}

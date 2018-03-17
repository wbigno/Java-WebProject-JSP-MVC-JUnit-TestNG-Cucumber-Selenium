package restaurant.CS.CONTROLLER;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import restaurant.CS.BO.ItemBO;
import restaurant.CS.BO.LocationBO;
import restaurant.CS.BO.OrderBO;
import restaurant.CS.BO.UserBO;
import restaurant.CS.MODEL.ItemModel;
import restaurant.CS.MODEL.LocationModel;
import restaurant.CS.MODEL.OrderModel;
import restaurant.CS.MODEL.PaymentModel;
import restaurant.CS.MODEL.UserDataModel;
@SessionAttributes("orderlist, userList, itemList, locationList")
@Controller
public class AdminContoller {
	
	
	@ModelAttribute("orderList")
	public void getOrderList (Model modelOrder) throws ClassNotFoundException, IOException, SQLException {
		OrderBO orderBO = new OrderBO();
		List<PaymentModel> orderList = new ArrayList<PaymentModel>();
		orderList = orderBO.listAllOrders();
		modelOrder.addAttribute("orderList", orderList);
	}
	
	@ModelAttribute("userList")
	public void getUserList (Model modelUser) throws ClassNotFoundException, IOException, SQLException {
		UserBO userBO = new UserBO();
		List<UserDataModel> userList = new ArrayList<UserDataModel>();
		userList = userBO.listOfUsers();
		modelUser.addAttribute("userlist", userList);
	}
	
	@ModelAttribute("itemList")
	public void getItemList (Model modelItem) throws ClassNotFoundException, IOException, SQLException {
		ItemBO itemBO = new ItemBO();
		List<ItemModel> itemList = new ArrayList<ItemModel>();
		itemList = itemBO.listOfItems();
		modelItem.addAttribute("itemlist", itemList);
	}
	
	@ModelAttribute("locationList")
	public void getLocationList (Model modelLoc) throws ClassNotFoundException, SQLException, IOException {
		LocationBO locBO = new LocationBO();
		List<LocationModel> locList = new ArrayList<LocationModel>();
		locList = locBO.listOfLocation();
		modelLoc.addAttribute("loclist", locList);
	}
	
	@RequestMapping(value ="updateUser", method = RequestMethod.POST)
	public ModelAndView updateFullUserDetails(Model modelUser, @ModelAttribute("user") UserDataModel user) throws ClassNotFoundException, IOException, SQLException {
		UserBO userBO = new UserBO();	
		userBO.updateUser(user);
		this.getUserList(modelUser);
		ModelAndView model = new ModelAndView("AdminUserListPage");
		
		return model;
	}
	
	@RequestMapping(value ="updateFullUser", method = RequestMethod.POST)
	public ModelAndView updateUserDetails(Model modelUser, @ModelAttribute("admin") UserDataModel admin) throws ClassNotFoundException, IOException, SQLException {
		UserBO userBO = new UserBO();	
		userBO.updateFullUser(admin);
		System.out.println(admin.getZipcode());
		ModelAndView model = new ModelAndView("AdminAccountPage");
		
		return model;
	}
	
	@RequestMapping(value ="disableLoc", method = RequestMethod.POST)
	public ModelAndView disableLocation(Model modelLoc, @ModelAttribute("loc") LocationModel loc) throws ClassNotFoundException, SQLException, IOException {
		LocationBO locBO = new LocationBO();
		locBO.disableLocation(loc);
		this.getLocationList(modelLoc);
		ModelAndView model = new ModelAndView("AdminLocationListPage");
				
		return model;
	}
	
	@RequestMapping(value ="enableLoc", method = RequestMethod.POST)
	public ModelAndView enableLocation(Model modelLoc, @ModelAttribute("loc") LocationModel loc) throws ClassNotFoundException, SQLException, IOException {
		LocationBO locBO = new LocationBO();
		locBO.enableLocation(loc);
		this.getLocationList(modelLoc);
		ModelAndView model = new ModelAndView("AdminLocationListPage");
				
		return model;
	}
	
	@RequestMapping(value ="addLoc", method = RequestMethod.POST)
	public ModelAndView addLocation(Model modelLoc, @ModelAttribute("loc") LocationModel loc ) throws ClassNotFoundException, SQLException, IOException {
		LocationBO locBO = new LocationBO();
		locBO.addLocation(loc);
		this.getItemList(modelLoc);
		ModelAndView model = new ModelAndView("AdminLocationListPage");
		
		return model;
	}
	
	@RequestMapping(value ="disableItem", method = RequestMethod.POST)
	public ModelAndView disableItem(Model modelItem, @ModelAttribute("item") ItemModel item) throws ClassNotFoundException, SQLException, IOException {
		ItemBO itemBO = new ItemBO();
		itemBO.disableItem(item);
		this.getItemList(modelItem);
		ModelAndView model = new ModelAndView("AdminSellItemsListPage");
		
		return model;
	}
	
	@RequestMapping(value ="enableItem", method = RequestMethod.POST)
	public ModelAndView enableItem(Model modelItem, @ModelAttribute("item") ItemModel item) throws ClassNotFoundException, SQLException, IOException {
		ItemBO itemBO = new ItemBO();
		itemBO.enableItem(item);
		this.getItemList(modelItem);
		ModelAndView model = new ModelAndView("AdminSellItemsListPage");
		
		return model;
	}
	
	@RequestMapping(value ="updateItem", method = RequestMethod.POST)
	public ModelAndView updateItem(Model modelItem, @ModelAttribute("item") ItemModel item) throws ClassNotFoundException, IOException, SQLException {
		ItemBO itemBO = new ItemBO();
		itemBO.updateItem(item);
		this.getItemList(modelItem);
		ModelAndView model = new ModelAndView("AdminSellItemsListPage");
		
		return model;
	}
	
	@RequestMapping(value ="addItem", method = RequestMethod.POST)
	public ModelAndView addItem(Model modelItem, @ModelAttribute("item") ItemModel item) throws ClassNotFoundException, IOException, SQLException {
		ItemBO itemBO = new ItemBO();
		itemBO.addItem(item);
		this.getItemList(modelItem);
		ModelAndView model = new ModelAndView("AdminSellItemsListPage");
		
		return model;
	}
	
	@RequestMapping(value="deleteOrder", method = RequestMethod.POST)
	public ModelAndView deleteOrder(Model modelOrder, @ModelAttribute("order")OrderModel order) throws ClassNotFoundException, IOException, SQLException {
		OrderBO orderBO = new OrderBO();
		orderBO.cancelOrder(order);
		this.getOrderList(modelOrder);
		ModelAndView model = new ModelAndView();
		return model;
	}
	
	@RequestMapping(value ="/AdminAccountPage", method = RequestMethod.GET)
	public ModelAndView displayAdminAccountPage( ) throws ClassNotFoundException, IOException, SQLException {
		ModelAndView model = new ModelAndView("AdminAccountPage");
	
		return model;
	}
	
	@RequestMapping(value ="/AdminLocationListPage", method = RequestMethod.GET)
	public ModelAndView displayAdminLocationListPage( ) {
		ModelAndView model = new ModelAndView("AdminLocationListPage");
		
		return model;
	}
	
	@RequestMapping(value ="/AdminOrderPage", method = RequestMethod.GET)
	public ModelAndView displayAdminOrderPage(Model modelOrder ) throws ClassNotFoundException, IOException, SQLException {
		//this.getOrderList(modelOrder);
		ModelAndView model = new ModelAndView("AdminOrderPage");
		
		return model;
		
	}
	
	@RequestMapping(value ="/AdminSellItemsListPage", method = RequestMethod.GET)
	public ModelAndView displayAdminSellItemsListPage(Model modelItem ) {
		ModelAndView model = new ModelAndView("AdminSellItemsListPage");
		
		return model;
	}
	
	@RequestMapping(value ="/AdminUserListPage", method = RequestMethod.GET)
	public ModelAndView displayAdminUserListPage() {	
		ModelAndView model = new ModelAndView("AdminUserListPage");
		
		return model;	
	}

}

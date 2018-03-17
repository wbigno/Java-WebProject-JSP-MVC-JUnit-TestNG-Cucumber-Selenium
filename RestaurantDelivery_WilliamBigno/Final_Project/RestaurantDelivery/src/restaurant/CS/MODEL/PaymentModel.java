package restaurant.CS.MODEL;

import java.util.Date;

public class PaymentModel {
	private int orderId; 				// will be returned from DAO addPayment to be used for the call to Order Table to update for items purchased
	private Integer userId;
	private Integer creditCard;
	private Integer securityCode;
	private Integer zipcode;
	private Integer locationId;
	private Double totalPayment; 	// This is calculated in the BO, and then set to the model for use by the response to client
	private Double tax; 			 //This is calculated in the BO, and then set to the model for use by the response to client
	private Double totalPurchase; 	// is TotalPaymnt and tax from BO to be set to payment table for report and for JSP to get for display
	private Double itemPrice; 		// used for logic only sent by JSP page in the request from the cart
	private Date orderDate;			//only used when getting data from DB
	private String firstName;		// used only for getting data from DB and for reference to orderlists
	private String lastName;		// used only for getting data from DB and for reference to orderlists
	private String locationName;		// used only for getting data from DB and for reference to orderlists
	private Integer itemId;			// used only for getting data from DB and for reference to orderlists
	private String itemName;		// used only for getting data from DB and for reference to orderlists
	
	
	
	public void userCart(Integer userId, Integer creditCard, Integer securityCode, Integer zipcode, Integer locationId, Double itemPrice, Integer itemId) {
		OrderModel orderObj = new OrderModel();
		orderObj.setItemId(itemId);
		this.userId = userId;
		this.creditCard = creditCard;
		this.securityCode = securityCode;
		this.zipcode = zipcode;
		this.locationId = locationId;
		this.itemPrice = itemPrice;
		
	}	
	
	public void orderList(String firstName, String lastName) {
		
		
	}

	public void setCreditCard(Integer creditCard) {
		this.creditCard = creditCard;
	}

	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public Integer getCreditCard() {
		return creditCard;
	}
	public Integer getSecurityCode() {
		return securityCode;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	
	public Integer getLocationId() {
		return locationId;
	}	
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Double getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(Double totalPayment) {
		this.totalPayment = totalPayment;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getTotalPurchase() {
		return totalPurchase;
	}
	public void setTotalPurchase(Double totalPurchase) {
		this.totalPurchase = totalPurchase;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	
	
}

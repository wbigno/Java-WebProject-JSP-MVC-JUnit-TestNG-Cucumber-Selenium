package restaurant.CS.MODEL;

public class OrderModel {
	private Integer id; // set from the PaymentModel(payment follows the cart order, PaymentDAO is the first call to DB)
	private Integer itemId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	
	
}

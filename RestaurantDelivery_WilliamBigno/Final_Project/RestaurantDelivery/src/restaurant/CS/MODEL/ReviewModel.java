package restaurant.CS.MODEL;

public class ReviewModel {
	private Integer userId;
	private Integer itemId;
	private String reviewDetails;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getReviewDetails() {
		return reviewDetails;
	}
	public void setReviewDetails(String reviewDetails) {
		this.reviewDetails = reviewDetails;
	}
	
	
}

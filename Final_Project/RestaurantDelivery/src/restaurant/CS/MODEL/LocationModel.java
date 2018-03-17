package restaurant.CS.MODEL;

public class LocationModel {
	private Integer id;
	private String locationName;
	private String address;
	private Integer zipcode;
	private Integer staffCount;
	private String category;
	private int active;
	private String image;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	public Integer getStaffCount() {
		return staffCount;
	}
	public void setStaffCount(Integer staffCount) {
		this.staffCount = staffCount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
}

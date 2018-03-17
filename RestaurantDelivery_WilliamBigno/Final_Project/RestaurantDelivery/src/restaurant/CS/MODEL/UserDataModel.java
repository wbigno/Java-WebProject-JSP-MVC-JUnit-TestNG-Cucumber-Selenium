package restaurant.CS.MODEL;

public class UserDataModel {
	private Integer id;
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private Integer zipcode;
	private Integer phone;
	private String email;
	private String password;
	private Integer admin;
	private String userName; // provided from jsp page upon login to validate, not in DB as email is the username declaration for login on
	private String passwordLogin; // provided from jsp page upon login to validate, not in DB as email is the username declaration for login on
	
	
	public String getPasswordLogin() {
		return passwordLogin;
	}
	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer i) {
		this.admin = i;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	
}


package restaurant.CS.Util;

public final class OracleSqlQueries {
	public static final String NEWUSER = "INSERT INTO USER_DATA (firstname, lastname, gender, address, zipcode, email, phone, password, admin) VALUES(? , ?, ?, ? , ?, ?, ?, ?, ?)";
	public static final String VALIDATE = "SELECT * FROM USER_DATA WHERE email = ?";
	public static final String GETALL = "SELECT * FROM USER_DATA";
	public static final String SAVEUSER = "UPDATE USER_DATA SET firstname = ?,  lastname = ?, address = ? , zipcode = ?, phone = ?, email = ?, admin = ? WHERE id = ?";	
	public static final String NEWREVIEW = "INSERT INTO REVIEW (userid, itemid, reviewdetails) VALUES(?, ?, ?)";
	public static final String DELETEREVIEW = "DELETE FROM REVIEW WHERE userid = ?"; 
	public static final String CHANGEREVIEW = "UPDATE REVIEW SET  reviewdetails = ? WHERE userid = ?";
	public static final String ADDPAYMENTINFO = "INSERT INTO PAYMENT (userid, creditcard, securitycode, zipcode, locationid, totalpayment) values (?, ?, ?, ?, ?, ?)";
	public static final String NEWORDER = "INSERT INTO ORDERS (id, itemid) VALUES(?, ?)";
	public static final String GETORDERS = "SELECT p.orderid, p.userid, u.firstname, u.lastname, p.orderdate , p.locationid, l.locationname, o.itemid, i.itemname, p.totalpayment FROM  PAYMENT p INNER JOIN user_data u ON p.userid = u.id INNER JOIN locations l ON p.locationid = l.id INNER JOIN orders o ON p.orderid = o.id INNER JOIN items i ON o.itemid = i.id";
	public static final String GETPRIORORDERS = "SELECT p.orderid, p.userid, u.firstname, u.lastname, p.orderdate, p.locationid, l.locationname, o.itemid, i.itemname, p.totalpayment FROM  PAYMENT p INNER JOIN user_data u ON p.userid = u.id INNER JOIN locations l ON p.locationid = l.id INNER JOIN orders o ON p.orderid = o.id INNER JOIN items i ON o.itemid = i.id WHERE p.userid = ?";
	public static final String CANCELORDER = "DELETE FROM ORDERS WHERE id = ?"; 
	public static final String NEWLOCATION = "INSERT INTO LOCATIONS (locationname, address, zipcode, staffcount, category, image) VALUES(?, ?, ?, ?, ?, ? )";
	public static final String DISABLELOCATION = "UPDATE LOCATIONS SET ACTIVE = ? WHERE ID = ?"; 
	public static final String ENABLELOCATION = "UPDATE LOCATIONS SET ACTIVE = ? WHERE ID = ?"; 
	public static final String GETALLLOCATIONS = "SELECT * FROM LOCATIONS";
	public static final String GETALLITEMS = "SELECT * FROM ITEMS";
	public static final String UPDATEITEM = "UPDATE ITEMS SET itemname = ?,  description = ?, price = ?, active = ? , category = ?, image = ? WHERE id = ?";
	public static final String ADDITEM = "INSERT INTO ITEMS (itemname, description, price, active, category, image) VALUES(?, ?, ?, ?, ?, ? )";
	public static final String DISABLEITEM = "UPDATE ITEMS SET  active = ? WHERE id = ?";	
	public static final String ENABLEITEM = "UPDATE ITEMS SET  active = ? WHERE id = ?";	
	public static final String GETREVIEWS = "SELECT * FROM REVIEW";		
	public static final String SAVEFULLUSER = "UPDATE USER_DATA SET firstname = ?,  lastname = ?, address = ? , zipcode = ?, phone = ?, email = ?, password = ? WHERE email = ?";	

}

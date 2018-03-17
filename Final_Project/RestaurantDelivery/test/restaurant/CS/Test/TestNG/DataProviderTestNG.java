package restaurant.CS.Test.TestNG;

import org.testng.annotations.DataProvider;

public class DataProviderTestNG {

	@DataProvider(name = "Register")
	public Object [][] getDataToRegisterUser() {
		return new Object [][] {
			{"Bob", "Smith", "bmisth@text.com", "123 Test Dr", "password", "M", 11222, 1232345},
			{"Bobbie", "Smithie", "bmisthie@text.com", "1234 Test Dr", "password", "M", 11222, 1232345},
			{"Bobby", "Smithson", "bmisthson@text.com", "12345 Test Dr", "password", "M", 11222, 1232345}
			};
	}

	@DataProvider(name = "Login")
	public Object [][] getDataToLogin() {
		return new Object [][] {
			{"bmisth@text.com"},
			{"bmisthie@text.com"},
			{"bmisthson@text.com"}
			};

	}

	@DataProvider(name = "Update")
	public Object [][] getDataToUpdateUser() {
		return new Object [][] {
			{4, "Bob", "Smith", "bmisth@text.com", "123 Test Dr", 0, "M", 11222, 1232345},
			{5, "Bobbie", "Smithie", "bmisthie@text.com", "1234 Test Dr", 0, "M", 11222, 1232345},
			{6, "Bobby", "Smithson", "bmisthson@text.com", "12345 Test Dr", 0, "M", 11222, 1232345}
			};
	}
	
	@DataProvider(name = "UpdateFull")
	public Object [][] getDataToUpdateFullUser() {
		return new Object [][] {
			{"Bob", "Smith", "bmisth@text.com", "123 Test Dr", "password", "M", 11222, 1232345},
			{"Bobbie", "Smithie", "bmisthie@text.com", "1234 Test Dr", "password", "M", 11222, 1232345},
			{"Bobby", "Smithson", "bmisthson@text.com", "12345 Test Dr", "password", "M", 11222, 1232345}
			};
	}
	
	@DataProvider(name = "Review")
	public Object [][] getDataToAddReview() {
		return new Object [][] {{01, 02, "Amazing food"}, {02, 03, "This Place isnt great"}, {03, 04, "I want my money back"}};
	}
	
	@DataProvider(name = "Delete")
	public Object [][] getDataToDeleteReview() {
		return new Object [][] {{01}, {02}, {03}};
	}
	
	@DataProvider(name = "Change")
	public Object [][] getDataToChangeReview() {
		return new Object [][] {{01, "Amazing food isnt here"}, {02, "This Place is great"}, {03, "I want my money back so I can give you a bigger tip"}};
	}
	
	@DataProvider(name = "NewOrder")
	public Object[][] getDataForNewOrder() {
		return new Object [][] {
			{01, 02},{02, 03},{01, 02},{03, 01}
		};
	}
	
	@DataProvider(name = "PriorOrder")
	public Object [][] getDataToListPriorOrder() {
		return new Object [][] {{01}, {02}, {03}};
	}
	
	@DataProvider(name = "AddLocation")
	public Object [][] getDataToAddLocation() {
		return new Object [][] {
			{"MidTown", "123 Mid ST", 11223, 10, "Hot", " "},
			{"SoutTown", "123 South ST", 11223, 10, "Hot", " "},
			{"MorthTown", "123 North ST", 11223, 10, "Hot", " "},
			{"WestTown", "123 West ST", 11223, 10, "Hot", " "}
		};
	}
	
	@DataProvider(name ="LocID")
	public Object [][] getDataToEnableAndDisableLocations() {
		return new Object [][] {
			{1},{2},{3},{4}
		};
	}
	
	@DataProvider(name = "NewItems")
	public Object [][] getDataToAddItems() {
		return new Object [][] {
			{"Burger", "Hot", 12.5, 1, "Hot", " "},
			{"Dog", "Hot", 12.5, 1, "Hot", " "},
			{"Dessert", "Hot", 12.5, 1, "Hot", " "},
			{"Steak", "Hot", 12.5, 1, "Hot", " "},
		};
	}
	
	@DataProvider(name = "UpdateItem")
	public Object [][] getDataToUpdateItem() {
		return new Object[][] {
			{1, "Burger", "Hot", 22.5, 0, "Hot", " "},
			{2, "Dog", "Hot", 22.5, 0, "Hot", " "},
			{3, "Dessert", "Hot", 22.5, 0, "Hot", " "},
			{4, "Steak", "Hot", 22.5, 0, "Hot", " "},
		};
	}
	
	@DataProvider(name = "EnableDisable")
	public Object [][] getDataToEnableDisableItems() {
		return new Object [][] {
			{1}, {2}, {3}, {4}
		};
	}
}

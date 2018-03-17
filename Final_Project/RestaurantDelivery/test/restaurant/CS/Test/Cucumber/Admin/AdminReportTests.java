package restaurant.CS.Test.Cucumber.Admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminReportTests {
	WebDriver driverchrome = null;
	WebElement el = null;
	Select sel = null;
	
	@Before
	public void prepTest() {
		System.setProperty("webdriver.gecko.driver", "\\\\Mac\\Home\\Desktop\\selenium executable\\geckodriver.exe");
		driverchrome = new ChromeDriver();
		driverchrome.manage().window().maximize();
		driverchrome.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}	

	@Given("^I am an admin user, and I am on the Admin page after logging in$")
	public void i_am_an_admin_user_and_I_am_on_the_Admin_page_after_logging_in() throws Throwable {
		driverchrome.get("http://localhost:8090/RestaurantDelivery/HomePage");
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("wbigno@icloud.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("pass");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
	    throw new PendingException();
	}
	
	@When("^I am on the admin page I will click on the \"([^\"]*)\" tab$")
	public void i_am_on_the_admin_page_I_will_click_on_the_tab() throws Throwable {
		driverchrome.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
	    throw new PendingException();
	}
	
	@When("^I will click on the \"([^\"]*)\" tab$")
	public void i_will_click_on_the_tab() throws Throwable {
		driverchrome.findElement(By.xpath("//a[@href='AdminUserListPage']")).click();
	    throw new PendingException();
	}
	
	@When("^I will enter the \"([^\"]*)\" and the \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_will_enter_the_and_the_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) throws Throwable {
		driverchrome.findElement(By.xpath("//input[@name='id']")).sendKeys(arg1);
		driverchrome.findElement(By.xpath("//input[@name='firstName']")).sendKeys(arg2);
		driverchrome.findElement(By.xpath("//input[@name='lastName']")).sendKeys(arg3);
		driverchrome.findElement(By.xpath("//input[@name='email']")).sendKeys(arg4);
		driverchrome.findElement(By.xpath("//input[@name='admin']")).sendKeys(arg5);
		driverchrome.findElement(By.xpath("//input[@name='address']")).sendKeys(arg6);
		driverchrome.findElement(By.xpath("//input[@name='zipcode']")).sendKeys(arg7);
		driverchrome.findElement(By.xpath("//input[@name='phone']")).sendKeys(arg8);
		driverchrome.findElement(By.xpath("//button[@id='update']")).click();
	    throw new PendingException();
	}

	@Then("^I will click the update button and see the results on the screen$")
	public void i_will_click_the_update_button_and_see_the_results_on_the_screen() throws Throwable {
		driverchrome.findElement(By.xpath("//button[@id='update']")).click();
	    throw new PendingException();
	}
	
	@When("^I am on the Admin Item page I want to be able to disable items so that they do not appear on the menu for users$")
	public void i_am_on_the_Admin_Item_page_I_want_to_be_able_to_disable_items_so_that_they_do_not_appear_on_the_menu_for_users() throws Throwable {
		driverchrome.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
		driverchrome.findElement(By.xpath("//a[@href='AdminSellItemsListPage']")).click();
	    throw new PendingException();
	}
	
	@When("^to do this I will click on the disable item field and enter the \"([^\"]*)\"$")
	public void to_do_this_I_will_click_on_the_disable_item_field_and_enter_the(String arg1) throws Throwable {
		driverchrome.findElement(By.xpath("//input[@id='id']")).sendKeys(arg1);
	    throw new PendingException();
	}
	
	@Then("^I wll click on the disable button to complete the process and will see the update on the screen$")
	public void i_wll_click_on_the_disable_button_to_complete_the_process_and_will_see_the_update_on_the_screen() throws Throwable {
		driverchrome.findElement(By.xpath("//button[@id='disableItem']")).click();
	    throw new PendingException();
	}
	
	@When("^I am on the Amdin Location Page$")
	public void i_am_on_the_Amdin_Location_Page() throws Throwable {
		driverchrome.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
		driverchrome.findElement(By.xpath("//a[@href='AdminLocationListPage']")).click();
	    throw new PendingException();
	}
	
	@When("^I want to add a new location I will need to scroll down the screen to the form$")
	public void i_want_to_add_a_new_location_I_will_need_to_scroll_down_the_screen_to_the_form() throws Throwable {
		JavascriptExecutor js = ((JavascriptExecutor) driverchrome); // scrolls screen
		js.executeScript("window.scrollBy(0,500)",""); // defines how much to scroll
	    throw new PendingException();
	}
	
	@When("^I will enter the \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_will_enter_the_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
		driverchrome.findElement(By.xpath("//input[@name='locationName']")).sendKeys(arg1);
		driverchrome.findElement(By.xpath("//input[@name='address']")).sendKeys(arg2);
		driverchrome.findElement(By.xpath("//input[@name='zipcode']")).sendKeys(arg3);
		driverchrome.findElement(By.xpath("//input[@name='staffCount']")).sendKeys(arg4);
		driverchrome.findElement(By.xpath("//input[@name='category']")).sendKeys(arg5);
		driverchrome.findElement(By.xpath("//input[@name='images']")).sendKeys(arg6);
		
	    throw new PendingException();
	}
	
	@Then("^I will click the update button to add the location$")
	public void i_will_click_the_update_button_to_add_the_location() throws Throwable {
		driverchrome.findElement(By.xpath("//button[@id='update']")).click();
	    throw new PendingException();
	}
	
	@After
	public void testClean() throws InterruptedException {
		Thread.sleep(3000); //sets time before browser is closed "3sec"
		driverchrome.close(); // closers chrome browser
		
	}
	
}

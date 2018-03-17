package restaurant.CS.Test.Cucumber.LoginRegistration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class LoginRegisterFunctionalityTest {
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
	
	@Given("^I am on the Websites Home page$")
	public void i_am_on_the_Websites_Home_page() throws Throwable {
		driverchrome.get("http://localhost:8090/RestaurantDelivery/HomePage");
	    throw new PendingException();
	}

	@When("^I I am a regular user, and select Login from Home page$")
	public void i_I_am_a_regular_user_and_select_Login_from_Home_page() throws Throwable {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
	    throw new PendingException();
	}

	@When("^I enter my <\"([^\"]*)\"> and <\"([^\"]*)\">$")
	public void i_enter_my_and(String arg1, String arg2) throws Throwable {
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys(arg1);
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys(arg2);
	    throw new PendingException();
	}

	@Then("^I will be sent to the menu page to select items$")
	public void i_will_be_sent_to_the_menu_page_to_select_items() throws Throwable {
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		assertThat("Menu", equalTo(driverchrome.getTitle()));
	    throw new PendingException();
	}

	@When("^I I need to register as a new user, and select Register form home page$")
	public void i_I_need_to_register_as_a_new_user_and_select_Register_form_home_page() throws Throwable {
		driverchrome.findElement(By.xpath("//a[@href='RegistrationPage']")).click();
	    throw new PendingException();
	}

	@When("^I enter my <\"([^\"]*)\"> and <\"([^\"]*)\"> and <\"([^\"]*)\"> and$")
	public void i_enter_my_and_and_and(String arg1, String arg2, String arg3) throws Throwable {
		driverchrome.findElement(By.xpath("//input[@id='firstName']")).sendKeys(arg1);
		driverchrome.findElement(By.xpath("//input[@id='lastName']")).sendKeys(arg2);
		driverchrome.findElement(By.xpath("//input[@id='email']")).sendKeys(arg3);
	    throw new PendingException();
	}

	@When("^<\"([^\"]*)\"> and <\"([^\"]*)\"> and <\"([^\"]*)\"> and <\"([^\"]*)\"> and my new <\"([^\"]*)\"> and <\"([^\"]*)\">$")
	public void and_and_and_and_my_new_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys(arg1);
		driverchrome.findElement(By.xpath("//input[@id='password2']")).sendKeys(arg2);
		driverchrome.findElement(By.xpath("//input[@id='mgender']")).click();
		driverchrome.findElement(By.xpath("//input[@id='address']")).sendKeys(arg4);
		driverchrome.findElement(By.xpath("//input[@id='zipCode']")).sendKeys(arg5);
		driverchrome.findElement(By.xpath("//input[@id='phone']")).sendKeys(arg6);
	    throw new PendingException();
	}

	@Then("^I will be registered as a new user, and sent to the login page for the first time to log in$")
	public void i_will_be_registered_as_a_new_user_and_sent_to_the_login_page_for_the_first_time_to_log_in() throws Throwable {
		driverchrome.findElement(By.xpath("//button[@id='Registration']")).click();
		assertThat("Login", equalTo(driverchrome.getTitle()));
	    throw new PendingException();
	}
	
	@After
	public void testClean() throws InterruptedException {
		Thread.sleep(3000); //sets time before browser is closed "3sec"
		driverchrome.close(); // closers chrome browser
		
	}
}

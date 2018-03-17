package restaurant.CS.Test.Selenium;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageSelenium {

	WebDriver driverchrome = null;
	WebElement el = null;
	Select sel = null;

	
	@BeforeTest
	public void propertySetter() {
		System.setProperty("webdriver.chrome.driver", "\\\\Mac\\Home\\Desktop\\selenium executable\\chromedriver.exe"); 
		
	}
	
	@BeforeMethod
	public void prepTest() {
		driverchrome = new ChromeDriver();
		driverchrome.get("http://localhost:8090/RestaurantDelivery/HomePage");
		driverchrome.manage().window().maximize();
		driverchrome.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void loginUserSuccessTest() {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("tsmith@gmail.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("test");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		assertThat("Menu", equalTo(driverchrome.getTitle()));
	}
	
	@Test
	public void LoginUserFailureTest() {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("fail@fail.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("fail");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		assertThat("Login", equalTo(driverchrome.getTitle()));
	}
	
	@Test
	public void LoginAdminSuccessTest() {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("wbigno@icloud.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("pass");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		assertThat("Admin Details", equalTo(driverchrome.getTitle()));
	}
	
	@Test
	public void loginAdminFailureTest() {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("wbigno@icloud.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("fail");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		assertThat("http://localhost:8090/RestaurantDelivery/UserFlow?action=Login", equalTo(driverchrome.getCurrentUrl()));
	}
	
	@Test
	public void LoginRegisterNewUserTest() {
		driverchrome.findElement(By.xpath("//a[@href='RegistrationPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
		driverchrome.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Smith");
		driverchrome.findElement(By.xpath("//input[@id='email']")).sendKeys("jsmith@icloud.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
		driverchrome.findElement(By.xpath("//input[@id='password2']")).sendKeys("password");
		driverchrome.findElement(By.xpath("//input[@id='mgender']")).click();
		driverchrome.findElement(By.xpath("//input[@id='address']")).sendKeys("1234 Main St");
		driverchrome.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("11222");
		driverchrome.findElement(By.xpath("//input[@id='phone']")).sendKeys("2345623");
		driverchrome.findElement(By.xpath("//button[@id='Registration']")).click();
		assertThat("Login", equalTo(driverchrome.getTitle()));
	}
	
	@AfterMethod
	public void testClean() throws InterruptedException {
		Thread.sleep(3000); //sets time before browser is closed "3sec"
		driverchrome.close(); // closers chrome browser
		
	}
}

package restaurant.CS.Test.Selenium;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminPagesSelenium {
	
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
	public void adminLoginTest() {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("wbigno@icloud.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("pass");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		assertThat("Admin Details", equalTo(driverchrome.getTitle()));
	}
	
	@Test
	public void userEditTest() {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("wbigno@icloud.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("pass");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		driverchrome.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
		driverchrome.findElement(By.xpath("//a[@href='AdminUserListPage']")).click();
		driverchrome.findElement(By.xpath("//input[@name='id']")).sendKeys("03");
		driverchrome.findElement(By.xpath("//input[@name='firstName']")).sendKeys("test");
		driverchrome.findElement(By.xpath("//input[@name='lastName']")).sendKeys("test");
		driverchrome.findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
		driverchrome.findElement(By.xpath("//input[@name='admin']")).sendKeys("0");
		driverchrome.findElement(By.xpath("//input[@name='address']")).sendKeys("1234 Test Dr");
		driverchrome.findElement(By.xpath("//input[@name='zipcode']")).sendKeys("12345");
		driverchrome.findElement(By.xpath("//input[@name='phone']")).sendKeys("1231234");
		driverchrome.findElement(By.xpath("//button[@id='update']")).click();
		assertThat("Admin User Update", equalTo(driverchrome.getTitle()));
	}
	
	@Test
	public void locationAddTest() {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("wbigno@icloud.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("pass");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		driverchrome.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
		driverchrome.findElement(By.xpath("//a[@href='AdminLocationListPage']")).click();
		JavascriptExecutor js = ((JavascriptExecutor) driverchrome); // scrolls screen
		js.executeScript("window.scrollBy(0,500)",""); // defines how much to scroll
		driverchrome.findElement(By.xpath("//input[@name='locationName']")).sendKeys("North Street");
		driverchrome.findElement(By.xpath("//input[@name='address']")).sendKeys("123 North St");
		driverchrome.findElement(By.xpath("//input[@name='zipcode']")).sendKeys("12345");
		driverchrome.findElement(By.xpath("//input[@name='staffCount']")).sendKeys("10");
		driverchrome.findElement(By.xpath("//input[@name='category']")).sendKeys("Full");
		driverchrome.findElement(By.xpath("//input[@name='images']")).sendKeys(" ");
		driverchrome.findElement(By.xpath("//button[@id='update']")).click();
		assertThat("Admin Location Page", equalTo(driverchrome.getTitle()));
	}
	
	@Test
	public void orderReportTest() {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("wbigno@icloud.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("pass");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		driverchrome.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
		driverchrome.findElement(By.xpath("//a[@href='AdminOrderPage']")).click();
		assertThat("Admin Order Page", equalTo(driverchrome.getTitle()));
	}
	
	@Test
	public void disableItemTest() {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("wbigno@icloud.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("pass");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		driverchrome.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();
		driverchrome.findElement(By.xpath("//a[@href='AdminSellItemsListPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='id']")).sendKeys("0");
		driverchrome.findElement(By.xpath("//button[@id='disableItem']")).click();
		assertThat("Admin Item List", equalTo(driverchrome.getTitle()));
	}
	
	@AfterMethod
	public void testClean() throws InterruptedException {
		Thread.sleep(1500); //sets time before browser is closed "3sec"
		driverchrome.close(); // closers chrome browser
		
	}
}


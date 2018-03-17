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

public class LocationPageSelenium {
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
	public void locationSelectTest() {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("tsmith@gmail.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("test");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		driverchrome.findElement(By.xpath("//button[@id='addCart']")).click();
		driverchrome.findElement(By.xpath("//button[@id='processOrder']")).click();
		driverchrome.findElement(By.xpath("//button[@id='locId']")).click();
		assertThat("Review Order", equalTo(driverchrome.getTitle()));
		
	}
	
	@Test
	public void cancelOrderTest() {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("tsmith@gmail.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("test");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		driverchrome.findElement(By.xpath("//button[@id='addCart']")).click();
		driverchrome.findElement(By.xpath("//button[@id='processOrder']")).click();
		driverchrome.findElement(By.xpath("//button[@id='cancelOrder']")).click();
		assertThat("Menu", equalTo(driverchrome.getTitle()));
	}
	
	
	@Test
	public void logoutClearCartTest() {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("tsmith@gmail.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("test");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		driverchrome.findElement(By.xpath("//button[@id='addCart']")).click();
		driverchrome.findElement(By.xpath("//button[@id='processOrder']")).click();
		driverchrome.findElement(By.xpath("//button[@id='cancelOrder']")).click();
		driverchrome.findElement(By.xpath("//button[@id='processOrder']")).click();
		assertThat("Menu", equalTo(driverchrome.getTitle()));
	}
	
	@Test
	public void updateUserTest() {
		driverchrome.findElement(By.xpath("//a[@href='LoginPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='user_name']")).sendKeys("tsmith@gmail.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("test");
		driverchrome.findElement(By.xpath("//button[@id='login']")).click();
		driverchrome.findElement(By.xpath("//a[@href='RegularUserPage']")).click();
		driverchrome.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Big T");
		driverchrome.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Smith");
		driverchrome.findElement(By.xpath("//input[@id='email']")).sendKeys("Tsmith@icloud.com");
		driverchrome.findElement(By.xpath("//input[@id='password']")).sendKeys("test");
		driverchrome.findElement(By.xpath("//input[@id='address']")).sendKeys("1234 Main St");
		driverchrome.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("11222");
		driverchrome.findElement(By.xpath("//input[@id='phone']")).sendKeys("2345623");
		driverchrome.findElement(By.xpath("//button[@id='update']")).click();
		assertThat("http://localhost:8090/RestaurantDelivery/RegularUserPage", equalTo(driverchrome.getCurrentUrl()));
	}
	
	@AfterMethod
	public void testClean() throws InterruptedException {
		Thread.sleep(1500); //sets time before browser is closed "3sec"
		driverchrome.close(); // closers chrome browser
		
	}
}

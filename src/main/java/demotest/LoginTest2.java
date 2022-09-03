package demotest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest2 {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		launchBrowser();
		loginTest();
		tearDown();

		launchBrowser();
		loginTestNegative();
		tearDown();

		
	}
	
	public static void loginTest() throws InterruptedException {
			
		//identify elements
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		
	}
	
	public static void loginTestNegative() throws InterruptedException {
		
		//identify elements
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc12345");
		driver.findElement(By.name("login")).click();
		
	}
	
	public static void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();	//no need WebDriver only driver
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing");
		
	}
	
	public static void tearDown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.close();	
		
	}
	

}

package demotest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//JUnit does not need main method. it need @BeforeClass, @Before, @Test, @After, @AfterClass	//@ contain main method inside.
public class LoginTest_JUnit {
	WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("This is before class.");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("This is after class.");
	}

	@Before
	public void launchBrowser() {
		System.out.println("@Before");

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver(); // no need WebDriver only driver

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing");

	}

	@After
	public void tearDown() throws InterruptedException {
		System.out.println("@After");

		Thread.sleep(3000);
		driver.close();

	}

	@Test
	public void loginTestNegative() throws InterruptedException {
		System.out.println("@Test_NegativeTest.");

		// identify elements
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password1")).sendKeys("abc12345");
		driver.findElement(By.name("login")).click();

	}

	@Test
	public void loginTest() throws InterruptedException {
		System.out.println("@Test");

		// identify elements
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

	}

}

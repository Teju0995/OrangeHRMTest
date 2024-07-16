package TestLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	
	protected static WebDriver driver;
	@Test(priority=1)
	public void setUp()
	{
		 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@Test(priority=2)
	public void LoginPageTest()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		
		
	}
	
	@Test(priority=3)
	public void HomepageTitle()
	{
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
		
		
	}
	
	@Test(priority=4)
	public void HomepageUrl()
	{
		String actualurl = driver.getCurrentUrl();
		Assert.assertEquals(actualurl.contains("orange"), true);
		
		
	}

}

package selenium;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OracleApexLoginTest {	
	
	WebDriver driver = null;
	
	public OracleApexLoginTest()
	{
		setUpDriver();
	}	

	//@Test
	public void login() {			
		driver.get("https://www.pdr.gla.ac.uk");
		driver.manage().window().setSize(new Dimension(1272, 727));
		driver.findElement(By.id("username")).sendKeys("dl121z");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("firhill1234");
		driver.findElement(By.xpath("//button[contains(.,\'Login\')]")).click();

		Assert.assertTrue(driver.getPageSource().contains("David Lang")); 
		
		driver.quit();	        
	}
	
	@Test
	public void login2() {			
		driver.get("https://kjwvivmv0n5reuj-apexkqor.adb.uk-london-1.oraclecloudapps.com/ords/r/test1/selenium-test-app/home");
		driver.findElement(By.id("P9999_USERNAME")).click();
	    driver.findElement(By.id("P9999_USERNAME")).sendKeys("SELENIUM_TEST");

	    //driver.findElement(By.cssSelector(".t-Login-header")).click();
	    driver.findElement(By.id("P9999_PASSWORD")).click();
	    driver.findElement(By.id("P9999_PASSWORD")).sendKeys("Abc12!abc@12");
	    
	    driver.findElement(By.xpath("//button[contains(.,\'Sign In\')]")).click();
		Assert.assertTrue(driver.getPageSource().contains("Selenium test app")); 
		
		driver.quit();	        
	}
	
	private void setUpDriver()
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");			
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-gpu");		
		driver = new ChromeDriver(chromeOptions);
	}
}	



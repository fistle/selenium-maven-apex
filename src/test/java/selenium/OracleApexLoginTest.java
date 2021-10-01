package selenium;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OracleApexLoginTest {	
	
	WebDriver driver = null;
	
	
	public OracleApexLoginTest()
	{
		setUpDriver();
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
WebDriverManager.chromedriver().setup();
 ChromeOptions options = new ChromeOptions();
 options.addArguments("--no-sandbox");
 options.addArguments("--disable-dev-shm-usage");
 options.addArguments("--headless");
 driver = new ChromeDriver(options);
	}
}	



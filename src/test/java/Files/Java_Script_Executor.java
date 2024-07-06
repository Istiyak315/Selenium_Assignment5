package Files;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Java_Script_Executor {
	
	WebDriver driver;
	

	@BeforeTest
	public void bt() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://snapdeal.com/");
		driver.manage().window().maximize();
		
		
	}
	
	@Test
	public void main() throws InterruptedException {
		// Use implicit to wait until the search box is visible
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("(//input[@name='keyword' and @type='text'])[1]")).sendKeys("shoes");
	
		// Use JavaScriptExecutor to enter text into the search box
		 JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement j=	 driver.findElement(By.cssSelector("[class='searchformButton col-xs-4 rippleGrey']"));
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
		// Use JavaScriptExecutor to click the search button
		js.executeScript("arguments[0].click()", j);
		
		

	}
	
	@AfterTest
	public void at() {
		// Close the WebDriver
		driver.quit();
		
	
	}
}

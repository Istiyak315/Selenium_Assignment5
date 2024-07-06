package Files;

import java.time.Duration;
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
	WebDriverWait wait;

	@BeforeTest
	public void bt() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://snapdeal.com/");
		driver.manage().window().maximize();
		
		// Initialize WebDriverWait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
	public void main() throws InterruptedException {
		// Use WebDriverWait to wait until the search box is visible
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("keyword")));
		
		// Use JavaScriptExecutor to enter text into the search box
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='books'", searchBox);
		
		// Wait until the search button is clickable
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']")));
		
		// Use JavaScriptExecutor to click the search button
		js.executeScript("arguments[0].click()", searchButton);
	}
	
	@AfterTest
	public void at() {
		// Close the WebDriver
		
	
	}
}

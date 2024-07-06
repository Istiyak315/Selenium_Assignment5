package Files;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scrolling {
	WebDriver driver;
	
	@BeforeTest
	public void bt() {
		
		//selecting driver to run tests
		driver=new ChromeDriver();
		
		//access the url
		driver.get("https://www.ebay.com/");
		
		//maximizing the window
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void main() throws InterruptedException {
		
		
		Thread.sleep(4000);
		
		//clicking on textfiled and enter shoes
		driver.findElement(By.id("gh-ac")).sendKeys("shoes");
		
		//clicking on search button
		driver.findElement(By.id("gh-btn")).click();
		
		//using js executor to scroll
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//scrolling till the end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//scrolling back to top 
		js.executeScript("window.scrollBy(0,0)");
		
		Thread.sleep(3000);
		
		//clear the textfilled
		driver.findElement(By.id("gh-ac")).clear();

	}
	
	@AfterTest
	public void at() {
		
		//close the browser
		driver.quit();
		
	}

}

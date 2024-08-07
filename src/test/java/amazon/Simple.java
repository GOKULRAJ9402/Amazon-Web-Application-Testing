package amazon;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Simple {
	public static void main(String[] args) throws InterruptedException, IOException {


		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		// website
		driver.get("https://www.amazon.in/");

		//
		driver.findElement(By.id("nav-link-accountList")).click();
		Thread.sleep(2000);
		
		//enter number
		driver.findElement(By.name("email")).sendKeys("xxxxx");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		
		//enter password
		driver.findElement(By.name("password")).sendKeys("yyyyy");
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(2000);
		
		//search
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
		
		//screenshot
		TakesScreenshot image=(TakesScreenshot)driver;
		File sourse=image.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Image/src.png");
		FileHandler.copy(sourse, dest);
		Thread.sleep(2000);
		
		
		//add to cart
		driver.findElement(By.id("a-autoid-1-announce")).click();
		Thread.sleep(3000);

		//Screenshot
		TakesScreenshot image1=(TakesScreenshot)driver;
		File sourse1=image1.getScreenshotAs(OutputType.FILE);
		File dest1=new File("./Image/src2.png");
		FileHandler.copy(sourse1, dest1);

		//go to cart
		driver.findElement(By.className("a-button-text")).click();
		Thread.sleep(3000);

		//process to buy
		driver.findElement(By.xpath("(//input[@class='a-button-input'])[1]")).click();
		Thread.sleep(2000);
		
		
		driver.navigate().back();
		
		
		
		//quit
		driver.quit();

	}

}

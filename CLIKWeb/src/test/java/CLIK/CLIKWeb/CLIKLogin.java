package CLIK.CLIKWeb;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v112.indexeddb.model.Key;
import org.testng.annotations.AfterTest;

public class CLIKLogin {

	WebDriver driver;

	@BeforeTest
	public void beforeTest() 

	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.s.clik.audio/login");
	}

	@AfterTest
	public void afterTest() 
	{
		driver.close();
	}


	@Test(priority=1)
	public void Login_failure() throws InterruptedException 
	{
		Thread.sleep(3000);
		
		System.out.println("Login Failure TC initiated...");

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/form/div[1]/div/div/div/input")).sendKeys("a@a.com");
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/form/div[2]/div/div/div/input")).sendKeys("sss");
		
		
		Thread.sleep(3000);

//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		JavascriptExecutor js = (JavascriptExecutor) driver; js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/form/button[2]/span")).click();
		
		Thread.sleep(3000);

		String Failure_msg= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[2]")).getText();

		System.out.println(Failure_msg);
		
		Thread.sleep(3000);
		
		
	}
	
	@Test(priority=2)
	public void Login_success() throws InterruptedException 
	{
		Thread.sleep(2000);
		
		System.out.println("Login Success TC initiated...");

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/form/div[1]/div/div/div/input")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/form/div[1]/div/div/div/input")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/form/div[1]/div/div/div/input")).sendKeys("ahmed.bilal+admin@fusiontech.global");
		
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/form/div[2]/div/div/div/input")).click();

		Thread.sleep(2000);
	    driver.findElement(By.name("password")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

		//driver.findElement(By.xpath("//*[@id=\\\"root\\\"]/div[2]/div/form/div[2]/div/div/div/input")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		
	    driver.findElement(By.name("password")).sendKeys("Liverpool1");

		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/form/button[2]/span")).click();
		
		Thread.sleep(3000);

		String Dashboard_title= driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div[1]/div/span")).getText();

		System.out.println(Dashboard_title);
		
		Thread.sleep(1000);
		
		
	}

	

}

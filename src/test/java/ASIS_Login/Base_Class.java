package ASIS_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utility.Xpath_Utlity;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
WebDriver driver;
	@BeforeClass
	public void browser() {
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
	}
	
	@AfterClass
	public void Teardown() throws InterruptedException {
		Xpath_Utlity obj1 = new Xpath_Utlity();
		obj1.xpath();
		driver.findElement(By.xpath(obj1.id)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(obj1.logout)).click();
		driver.close();
	}
	
}

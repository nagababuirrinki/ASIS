package ASIS_Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Utility.Xpath_Utlity;

public class Login extends Base_Class {

	@Test
	public void LoginTest() throws IOException, InterruptedException {

		driver.get("http://122.165.250.10:7500/");
		driver.manage().window().maximize();

		// Excel Sheet Read Data
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\naidu\\OneDrive\\Documents\\java_excel_asisdata\\ASIS_LoginData.xlsx");
		XSSFWorkbook Book = new XSSFWorkbook(fis);
		XSSFSheet sheet = Book.getSheet("Sheet1");
		int row_count = sheet.getLastRowNum();
		int col_count = sheet.getRow(1).getLastCellNum();

		System.out.println("rowcount :" + row_count + "colcount :" + col_count);

		// Get Title of the project
		String Title = "ASIS - Asset And Services Information System";
		String t1 = driver.getTitle();
		if (Title.equals(t1)) {
			System.out.println(t1);
		} else {
			System.out.println();
		}

		Xpath_Utlity obj1 = new Xpath_Utlity();
		obj1.xpath();

		// Loop for read the all excel data
		for (int i = 1; i <= row_count; i++) {
			
			XSSFRow CellData = sheet.getRow(i);
			String Username = CellData.getCell(0).getStringCellValue();
			String Password = CellData.getCell(1).getStringCellValue();

				driver.findElement(By.xpath(obj1.un)).clear();
				driver.findElement(By.xpath(obj1.un)).sendKeys(Username);
				driver.findElement(By.xpath(obj1.ps)).clear();
				driver.findElement(By.xpath(obj1.ps)).sendKeys(Password);
				driver.findElement(By.xpath(obj1.btn)).click();
				
				Thread.sleep(2000);
				WebElement cc = driver.findElement(By.xpath(obj1.com));
				cc.click();
				Select company = new Select(cc);
				company.selectByVisibleText("Radicare");
				Thread.sleep(2000);
				
				WebElement hh = driver.findElement(By.xpath(obj1.hos));
				Select hospital = new Select(hh);
				hospital.selectByVisibleText("Ampang");
				Thread.sleep(2000);
				
				
			
		}
	}
}

package Products;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_utility;
import obj_repository.CreateProductPage;
import obj_repository.HomePage;


public class CreateProductandDeletePrdTest extends BaseClass{

	
	@Test(groups = "integrationTest")
	public  void CreateProductandDeletePrdTest() throws Throwable {
		
		/* File_Utility flib = new File_Utility();
		 WebDriver_utility wlib = new WebDriver_utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		 
		WebDriver driver=new ChromeDriver();
	     String URL = flib.getKeyAndValueData("url");
		 String USERNAME = flib.getKeyAndValueData("username");
		 String PASSWORD = flib.getKeyAndValueData("password");
		
		 wlib.maximizeWindow(driver);
		 wlib.elementsToGetLoaded(driver);
		 driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
       driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
       driver.findElement(By.id("submitButton")).click();*/
	    
		HomePage home = new HomePage(driver);
		home.clickProductLink();
	    //driver.findElement(By.linkText("Products")).click();

		CreateProductPage prodPage = new CreateProductPage(driver);
		prodPage.clickOnPrdPlusSign();
	   // driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	   
	   int ranNumber = jlib.getRandomNumber();
	
 	  String productData = elib.readExcelDataUsingDataFormatter("Sheet1", 0, 0)+ranNumber;
 	  prodPage.enterPrdData(productData);
 	 //driver.findElement(By.name("productname")).sendKeys(productData);
 	  
 	  prodPage.clickOnSaveButton();
	 //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();    
	    
	 driver.findElement(By.linkText("Products")).click(); 
//	 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td//input[@type='checkbox']")).click();
	    
	 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+productData+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
	    
	 driver.findElement(By.xpath("//input[@value='Delete']")).click();
	    
	   wlib.alertAccept(driver);
	    
	  List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]")); 
	    	
	boolean flag = false;
	
	for (WebElement prdName : productList)
	{
		String actData = prdName.getText();
		if(actData.contains(productData))
		{
			flag=true;
		   break;
		}}
	if(flag)
	{
		System.out.println("product data is deleted");
	}
	else
	{
		System.out.println("product data is not deleted");
	}
		
	  
       //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
       //driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}

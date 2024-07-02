package Organization;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_utility;
import obj_repository.CreateOrganizationPage;
import obj_repository.HomePage;
import obj_repository.LoginPage;



public class CreateOrganizationTest extends BaseClass {
		
	@Test(groups="regressionTest")
	
		public void CreateOrganizationTest() throws Throwable {
		//here i optimized the organLink from pom class(obj repo)
            //driver.findElement(By.linkText("Organizations")).click();

		 HomePage home = new HomePage(driver);
		 home.clickOrganizationLink();
		 
		 CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
      // driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
		 orgPage.clickOrgPlusSign();
		 
     
         int ranNum = jlib.getRandomNumber();
    
  //   String organizationData = elib.getExcelData("Organization", 0, 0)+ranNum;
       String organizationData = elib.readExcelDataUsingDataFormatter("Sheet1", 0, 0)+ranNum;
       String phoneNum = elib.readExcelDataUsingDataFormatter("Sheet1", 0, 1)+ranNum;

      // driver.findElement(By.name("accountname")).sendKeys(organizationData);
       orgPage.enterOrgData(organizationData, phoneNum);
      //driver.findElement(By.id("phone")).sendKeys(phoneNum);
       
      
       //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       orgPage.clickOnSaveButton();
       
       Thread.sleep(2000);
       
      //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
      //driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

	
}

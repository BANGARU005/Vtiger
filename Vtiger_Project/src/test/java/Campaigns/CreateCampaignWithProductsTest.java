package Campaigns;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import obj_repository.CreateCampaignPage;
import obj_repository.CreateProductPage;
import obj_repository.HomePage;
import obj_repository.LoginPage;
import obj_repository.WinSwitchtoCampaigntoProductPage;


public class CreateCampaignWithProductsTest extends BaseClass {
			
	@Test		(groups = "integrationTest")
	public void CreateCampaignWithProductsTest() throws Throwable {
		/*File_Utility flib = new File_Utility();
		 WebDriver_utility wlib = new WebDriver_utility();
		 Java_Utility jlib = new Java_Utility();
		 Excel_Utility elib = new Excel_Utility();
		
		 WebDriver driver=new ChromeDriver();
         String URL = flib.getKeyAndValueData("url");
		 String USERNAME = flib.getKeyAndValueData("username");
		 String PASSWORD = flib.getKeyAndValueData("password");
		
		 wlib.maximizeWindow(driver);
		 wlib.waitForElementToLoad(driver);

       /* driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();
		 driver.get(URL);
       	 LoginPage login = new LoginPage(driver);
       	 login.loginToApp(USERNAME, PASSWORD);*/
       
        int ranNumber = jlib.getRandomNumber();
      
       // driver.findElement(By.linkText("Products")).click();
        HomePage home = new HomePage(driver);
        home.getMoreLink();
        home.clickProductLink();
        
        
       // driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPrdPlusSign();

	String productData = elib.getExcelData("Sheet1", 0, 0)+ranNumber;
	
	//driver.findElement(By.name("productname")).sendKeys(productData);
	prdPage.enterPrdData(productData);
 
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	prdPage.clickOnSaveButton();
        
       // driver.findElement(By.linkText("More")).click();
		home.clickMoreLink();
		
        //driver.findElement(By.linkText("Campaigns")).click();
		home.clickCampaignsLink();
		
        //driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		CreateCampaignPage CampPage = new CreateCampaignPage(driver);
        CampPage.clickOnCampPlusSign();
    
        String campaignData = elib.getExcelData("Sheet1", 0, 0)+ranNumber;
        
         //driver.findElement(By.name("campaignname")).sendKeys(campaignData);
        CampPage.enterCampData(campaignData);
        
        //driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
        CampPage.clickOnPlusSignToNavigateProductPage();
        
        wlib.switchingWindows(driver, "Products&action");
        
        //driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(productData);
        WinSwitchtoCampaigntoProductPage winSwitchToPrd = new WinSwitchtoCampaigntoProductPage(driver);
        winSwitchToPrd.enterPrdName(productData);
        
        //driver.findElement(By.xpath("//input[@name='search']")).click();
        winSwitchToPrd.clickOnSearch();
      
        //Dynamic Xpath
        //driver.findElement(By.xpath("//a[text()='"+productData+"']")).click(); 
        winSwitchToPrd.prdNamePresent(driver, productData);
        
        wlib.switchingWindows(driver, "Campaigns&action");
        
       //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        CampPage.clickOnSave();
        
        Thread.sleep(2000);
        
        //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
        //driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
        //home.logOutFromApp();
     }
}

package Campaigns;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_utility;
import obj_repository.CreateCampaignPage;
import obj_repository.HomePage;
import obj_repository.LoginPage;
import obj_repository.Validation_VerificationForCampaign;
public class CreateCampaignTest extends BaseClass {

	@Test(groups="smokeTest")
	public void CreateCampaignTest() throws Throwable {
		/*File_Utility flib = new File_Utility();
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
   		LoginPage login = new LoginPage(driver);
 		login.loginToApp(USERNAME, PASSWORD);*/
   
 		HomePage home = new HomePage(driver);
 		home.clickMoreLink();
 		home.clickCampaignsLink();
        
 		 
        CreateCampaignPage campPage = new CreateCampaignPage(driver);
        campPage.clickOnCampPlusSign();
        
        int ranNum = jlib.getRandomNumber();
        String campaginName = elib.readExcelDataUsingDataFormatter("Sheet1", 0, 0)+ranNum;
        campPage.enterCampData(campaginName);
        campPage.clickOnSave();
        
        //here validate the data through POM class
        //Validation_VerificationForCampaign valData = new Validation_VerificationForCampaign(driver);
        //valData.campData(driver, campaginName);
       
        Thread.sleep(2000);
        //home.logOutFromApp();
        
        //here validate the data through assert
        String actData= driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		
		//approach - 1
		//Assert.assertEquals(actData, campaginName);
        
		//approach - 2
		//Assert.assertTrue(actData.contains(campaginName));
		
		//approach - 3
		Assert.assertTrue(actData.contains(campaginName),campaginName+"campaign name is not verified");
	}
}
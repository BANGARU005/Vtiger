package obj_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Validation_VerificationForCampaign {
	
	public Validation_VerificationForCampaign(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
		public void campData(WebDriver driver, String campaignName) {
			
			String actData= driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
			if(campaignName.contains(actData)) {
				System.out.println("Data is Matched");
			}
			else {
				System.out.println("Data is not matched");
			}
				
		}
}

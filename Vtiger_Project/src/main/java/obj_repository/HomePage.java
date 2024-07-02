package obj_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_utility;

public class HomePage {
	
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(linkText="Organizations")
		private WebElement organizationLink;
		
		@FindBy(linkText="Products")
		private WebElement productLink;
		
		@FindBy(linkText="More")
		private WebElement moreLink;
		
		@FindBy(linkText="Campaigns")
		private WebElement campaignsLink;
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement logOutImg;
		
		@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement signOut;
		
		//gettermethods
		public WebElement getCampaignsLink() {
			return campaignsLink;
		}
		public WebElement getOrganizationLink() {
			
			return organizationLink;
			
		}
		public WebElement getProductLink() {
			
			return productLink;
			
		}
		public WebElement getMoreLink() {
			
			return moreLink;
		}
		
		public WebElement getLogOutImg() {
			return logOutImg;
		}
		public WebElement getSignOut() {
			return signOut;
		}
		
		
		//Business Logic
		public void clickOrganizationLink() {
			organizationLink.click();
		}
		public void clickProductLink() {
			productLink.click();
		}
		public void clickMoreLink() {
			moreLink.click();
		}
		public void clickCampaignsLink() {
			campaignsLink.click();
		}
		public void logOutFromApp() {
			logOutImg.click();
			signOut.click();
		}
		//Alternaitve Approach for logout
		/*public void logOut(WebDriver driver) {
			WebDriver_utility wlib = new WebDriver_utility();
			wlib.moveToElement(driver,logOutImg);
			signOut.click();
		}*/
		
}

			
			
			
package obj_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
		public CreateProductPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//img[@alt='Create Product...']")
		private WebElement productPlusSign;
		
		@FindBy(name = "productname")
		private WebElement prdNameTxtFeild;
		
		@FindBy(xpath ="//input[@title='Save [Alt+S]']")
		private WebElement saveButton;
		
		//gettermethods
		public WebElement getProductPlusSign() {
			return productPlusSign;
		}
		
		public WebElement getPrdNameTxtFeild() {
			return prdNameTxtFeild;
		}
		
		public WebElement getSaveButton() {
			return saveButton;
		}

		//business logic 
		public void clickOnPrdPlusSign() {
			
			productPlusSign.click();
		}
		public void enterPrdData(String prdName) {
			
			prdNameTxtFeild.sendKeys(prdName);
		}
		
		public void clickOnSaveButton() {
			
			saveButton.click();
		}
}

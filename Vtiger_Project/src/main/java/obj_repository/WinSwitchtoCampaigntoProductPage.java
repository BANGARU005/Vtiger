package obj_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WinSwitchtoCampaigntoProductPage {
	
	public WinSwitchtoCampaigntoProductPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement productName;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement productSearch;
	
	//gettermethods
	public WebElement getProductName() {
		return productName;
	}
	
	public WebElement getProductSearch() {
		return productSearch;
	}

	//business logic
	public void enterPrdName(String prdName) {
		
		productName.sendKeys(prdName);
	}
	
	public void clickOnSearch() {
		
		productSearch.click();
	}
	
	public void prdNamePresent(WebDriver driver,String productData) {
        
		driver.findElement(By.xpath("//a[text()='"+productData+"']")).click(); 
		
	}
}


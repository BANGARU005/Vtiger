package obj_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	public CreateCampaignPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCampPlusSign;

	@FindBy(name = "campaignname")
	private WebElement CampName;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement plusSignToNavigateProductPage;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	//getter methods
	public WebElement getCreateCampPlusSign() {
	return createCampPlusSign;
	
	}
	
	public WebElement getCampName() {
		return CampName;
	}

	public WebElement getPlusSignToNavigateProductPage() {
		return plusSignToNavigateProductPage;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}

	//Business Logic
	public void clickOnCampPlusSign() {
		createCampPlusSign.click();
	}
	
	public void enterCampData(String CamName) {
		CampName.sendKeys(CamName);
	}
	
	public void clickOnPlusSignToNavigateProductPage() {
		plusSignToNavigateProductPage.click();
	}
	
	public void clickOnSave() {
		saveButton.click();
	}
}
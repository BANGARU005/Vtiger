package obj_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Declaration
	
	@FindBy(css="[alt='Create Organization...']")
	private WebElement orgPlusSign;
	
	@FindBy(name="accountname")
	private WebElement organizationData;
	
	@FindBy(id="phone")
	private WebElement phoneNum;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	//getter methods
	public WebElement getOrgPlusSign() {
		return orgPlusSign;
	}

	public WebElement getOrgName() {
		return organizationData;
	}

	public WebElement getOrgPhone() {
		return phoneNum;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business logics
	
	public void clickOrgPlusSign() {
		orgPlusSign.click();
	}
	
	//entr org data can enter indivduall and also by using within one method as well
	public void enterOrgData(String orgName,String orgPhone ) {
		
		organizationData.sendKeys(orgName);
		phoneNum.sendKeys(orgPhone);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
}
	
	
	

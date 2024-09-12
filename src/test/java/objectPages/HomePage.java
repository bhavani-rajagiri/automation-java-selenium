package objectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath=("//a[@title=\"My Account\"]"))
	WebElement myAcctount_dropdown;	
	
	@FindBy(linkText=("Register"))
	WebElement regLink;
	
	@FindBy(linkText=("Login"))
	WebElement loginlink;
	
	//methods

	public void clickOnMyAcctountDropdown()
	{
		myAcctount_dropdown.click();
	}
	public void clickOnRegistrationLink()
	{
		regLink.click();
	}
	
	public void clickOnLoginLink()
	{
		loginlink.click();
	}
}

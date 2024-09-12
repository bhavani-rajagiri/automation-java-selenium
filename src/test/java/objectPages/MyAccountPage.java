package objectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath=("//h2[text()=\"My Account\"]"))
	WebElement txtMyAccount;
	
	@FindBy(linkText="Logout")
	WebElement btnLogout;
	
	public boolean isMyAccountTextPresent()
	{
		return txtMyAccount.isDisplayed();
	}

	public void clickLogoutBtn()
	{
		btnLogout.click();
	}
}

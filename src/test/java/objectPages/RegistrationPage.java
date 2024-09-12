package objectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(name="firstname")
	WebElement txtFirstname;
	@FindBy(name="lastname")
	WebElement txtLastname;
	@FindBy(name="email")
	WebElement txtEmail;
	@FindBy(name="telephone")
	WebElement txtTelephone;
	@FindBy(id="input-password")
	WebElement txtPassword;
	@FindBy(id="input-confirm")
	WebElement txtConfirmPassword;
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement btnContinue;
	@FindBy(name="agree")
	WebElement checkbox;
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement successMsg;
	
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}

	public void setLasename(String lname)
	{
		txtLastname.sendKeys(lname);
	}

	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String phno)
	{
		txtTelephone.sendKeys(phno);
	}

	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}

	public void setConfirmPassword(String cnfpws)
	{
		txtConfirmPassword.sendKeys(cnfpws);
	}

	public void setCheckbox()
	{
		checkbox.click();
	}

	public void clickOnbtnContinue()
	{
		btnContinue.click();
	}

	public String getConfirmationMessage()
	{
		return successMsg.getText();
		
	}
	
}

 package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import objectPages.HomePage;
import objectPages.RegistrationPage;
import testBase.BaseTest;

public class TC001_RegistrationPageTest extends BaseTest{
	//Test methods
	
	@Test(groups={"regression", "master"})
	public void registrationPageTest()
	{
		try {
		logger.info("*** TC001_RegistrationPageTest Test started ***");
		HomePage hp=new HomePage(driver);
		RegistrationPage rp=new RegistrationPage(driver);
		hp.clickOnMyAcctountDropdown();
		logger.info("*** Click on Myaccount link ***");
		hp.clickOnRegistrationLink();
		logger.info("*** Click on Register link ***");
		
		
		logger.info("*** Enter Customer Details***");
		rp.setFirstname(randomString());
		rp.setLasename(randomString());
		rp.setEmail(randomEmail());
		rp.setTelephone(randomNumber());
		
		String password = randomPassword();
		rp.setPassword(password);
		rp.setConfirmPassword(password);
		rp.setCheckbox();
		rp.clickOnbtnContinue();
		String newAccountCreatedMsg=rp.getConfirmationMessage();
		
		if(newAccountCreatedMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			System.out.println("New Account Created!! ");
		}
		else 
		{
			logger.error("*** Test failed ***");
			logger.debug("*** Debug started ***");
			Assert.assertTrue(false);
			
		}
		//Assert.assertEquals(newAccountCreatedMsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** TC001_RegistrationPageTest Test Completed ***");
	}
	
}

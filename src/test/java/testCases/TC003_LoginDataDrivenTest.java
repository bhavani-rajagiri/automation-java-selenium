package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import objectPages.HomePage;
import objectPages.LoginPage;
import objectPages.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseTest{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void loginTestDDT(String email, String password, String exp)
	{
	
		logger.info("*** TC003_LoginDataDrivenTest started ***");
		try {
	HomePage hp = new HomePage(driver);
	hp.clickOnMyAcctountDropdown();
	hp.clickOnLoginLink();
	
	
	LoginPage lp = new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(password);
	lp.clikOnLoginbtn();
	
	MyAccountPage mp =new MyAccountPage(driver);
	boolean status=mp.isMyAccountTextPresent();
	
	
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(status==true)
		{
			mp.clickLogoutBtn();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	if(exp.equalsIgnoreCase("Invalid")) {
		
		if(status==true)
		{
			mp.clickLogoutBtn();
			Assert.assertTrue(false);
		}
		
		else
		{
			Assert.assertTrue(true);
		}
	  }
		}
		catch(Exception e)
		{
			Assert.assertFalse(false);		
			}
		logger.info("*** TC003_LoginDataDrivenTest completed ***");
	}

}

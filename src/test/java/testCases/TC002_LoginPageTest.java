 package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import objectPages.HomePage;
import objectPages.LoginPage;
import objectPages.MyAccountPage;
import testBase.BaseTest;

public class TC002_LoginPageTest extends BaseTest{
	
	@Test(groups={"sanity", "master"})
	public void loginTest()
	{
		logger.info("*** TC002_LoginPageTest started ***");
		try {
		
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAcctountDropdown();
		hp.clickOnLoginLink();
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		lp.clikOnLoginbtn();
		
		MyAccountPage mp =new MyAccountPage(driver);
		boolean status=mp.isMyAccountTextPresent();
		Assert.assertTrue(status);
		}
		
		catch(Exception e) 
		{
			logger.error("Test Failed");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
			
		}
		
		logger.info("*** TC002_LoginPageTest completed ***");
	}

}

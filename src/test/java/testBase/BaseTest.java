package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	
public	static WebDriver driver;
public Logger logger;
public Properties prop;


    @SuppressWarnings("deprecation")
	@Parameters({"os", "browser"})
	@BeforeMethod(groups={"sanity","regression", "master"})
	public void setUp(String os, String br) throws IOException
	{
    	
    	FileReader filereader=new FileReader("C:\\Workspace\\Java Selenium\\seleniumpageObjectModel\\OpenCart\\src\\test\\resources\\config.properties");
		prop=new Properties();
    	prop.load(filereader);
    	
    	logger=LogManager.getLogger(this.getClass());
    	
    	//Remote execution -grid
    	if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) 
    	{
    		
    		
    		//Os
    		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    		
    		if(os.equalsIgnoreCase("windows"))
    		{
    			desiredCapabilities.setPlatform(Platform.WIN11);
    		}
    		else if(os.equalsIgnoreCase("mac"))
    		{
    			desiredCapabilities.setPlatform(Platform.MAC);
    		}
    		else {
    			System.out.println("No matching os found!!");
    			return;
    		}
    		//browser
    		switch(br.toLowerCase())
    		{
    			case "chrome" : desiredCapabilities.setBrowserName("chrome"); break;  
    			case "edge" : desiredCapabilities.setBrowserName("MicrosofEdge"); break;
    			//case "firefox" : desiredCapabilities.setBrowserName("firefox");break;
    			default : System.out.println("Invalid browser name .....");
    			return;	
    		}
    		
    		driver = new RemoteWebDriver(new URL(" http://192.168.1.130:4444/wd/hub"), desiredCapabilities);
    	}

    	// local execution
    	if(prop.getProperty("execution_env").equalsIgnoreCase("local")) 
    	{
    		switch(br.toLowerCase())
    		{
    			case "chrome" : driver=new ChromeDriver(); break;  
    			case "edge" : driver=new EdgeDriver(); break;
    			case "firefox" : driver=new FirefoxDriver();break;
    			default : System.out.println("Invalid browser name .....");
    		 }
    	}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get(prop.getProperty("appUrl"));
		driver.manage().window().maximize();
	}

	
	public String randomString()
	{
		String generatedRandomSting=RandomStringUtils.randomAlphabetic(6);
		return generatedRandomSting;
	}
	
	public String randomNumber()
	{
		String generatedRandomNumber=RandomStringUtils.randomNumeric(10);
		return generatedRandomNumber;
	}
	public String randomEmail()
	{
		String generatedRandomStingEmail=RandomStringUtils.randomAlphabetic(6);
		return generatedRandomStingEmail+"@gmail.com";
	}
	public String randomPassword()
	{
		String generatedRandomStingPassword=RandomStringUtils.randomAlphabetic(3);
		String generatedRandomNumber=RandomStringUtils.randomNumeric(3);
		return generatedRandomStingPassword+"@"+generatedRandomNumber;
	}
	
	@AfterMethod(groups={"sanity", "regression", "master"})
	public void tearDown()
	{
		driver.quit();
	}


	public String captureScreen(String tname) throws IOException{
		
	
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takeScreenshot =(TakesScreenshot) driver;
		File sourceFile=takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + tname + "-"+ timeStamp + ".png";
		File  targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
	
		return targetFilePath;
	} 
}

package pageTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageMethods.GmailLogin;
import pageMethods.SLAccountCreation;

public class SLMailVerification {
	@BeforeMethod
	  public static void initialise() throws IOException, InterruptedException
	  {
		  GmailLogin.propFile();
		  if(GmailLogin.data.getProperty("browsername").contains("firefox"))
		  {
			  System.out.println("Opening firefox and connecting to Sharklasers site for verifying mail");
			  GmailLogin.driver = new FirefoxDriver();
			  GmailLogin.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			  
		  }
		  else if(GmailLogin.data.getProperty("browsername").contains("chrome"))
		  {
			  System.out.println("Opening chrome and connecting to Sharklasers site for verifying mail");
			  GmailLogin.driver = new ChromeDriver();
			  GmailLogin.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			  
		  }
		  else
		  {
			  System.out.println("driver is not mentioned");
		  }
	  }

	  @AfterMethod
	  public void close()
	  {
		  System.out.println("Closing the Sharklasers site");
		  GmailLogin.driver.close();
	  }
	  @Test
	  public void mailVerification() throws IOException
	  {
		  GmailLogin.driver.get(GmailLogin.data.getProperty("emailurl"));
		  System.out.println("Sharklasers website is opened");
		  SLAccountCreation.emailCreation();
		  SLAccountCreation.emailVerification();
	  }
	
}

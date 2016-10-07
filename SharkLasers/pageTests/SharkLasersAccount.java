package pageTests;

import org.testng.annotations.Test;

import pageMethods.GmailLogin;
import pageMethods.SLAccountCreation;

import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class SharkLasersAccount extends SLAccountCreation {
  @Test
  public void creationEmailSL() throws IOException {
	  SLAccountCreation.emailCreation();
  }
  @BeforeMethod
  public static void initialise() throws IOException, InterruptedException
  {
	  GmailLogin.propFile();
	  if(GmailLogin.data.getProperty("browsername").contains("firefox"))
	  {
		  System.out.println("Opening firefox and connecting to Sharklasers site");
		  GmailLogin.driver = new FirefoxDriver();
		  GmailLogin.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
	  }
	  else if(GmailLogin.data.getProperty("browsername").contains("chrome"))
	  {
		  System.out.println("Opening chrome and connecting to Sharklasers site");
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
	  System.out.println("Closing the sharklasers website");
	  GmailLogin.driver.close();
  }

}

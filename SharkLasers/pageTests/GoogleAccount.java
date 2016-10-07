package pageTests;

import org.testng.annotations.Test;
import pageMethods.GmailLogin;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class GoogleAccount extends GmailLogin {
	
  @Test
  public void composeEmail() throws IOException 
  {
	 GmailLogin.login();
	 GmailLogin.createMail();
	 GmailLogin.logOut();
  }
  
   
  @BeforeMethod
  public static void initialise() throws IOException, InterruptedException
  {
	  GmailLogin.propFile();
	  if(data.getProperty("browsername").contains("firefox"))
	  {
		  System.out.println("Opening firefox Browser and connecting to gmail site");
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
	  }
	  else if(data.getProperty("browsername").contains("chrome"))
	  {
		  System.out.println("Opening Chrome Browser and connecting to gmail site");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
	  }
	  else
	  {
		  System.out.println("driver is not mentioned");
	  }
  }

  @AfterMethod
  public void close()
  {
	  System.out.println("Closing the gmail site");
	  driver.close();
  }

}

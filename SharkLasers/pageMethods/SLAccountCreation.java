package pageMethods;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import pageObjects.SharkLasersObjects;
import pageMethods.GmailLogin;


public class SLAccountCreation extends SharkLasersObjects {
	
	public static void emailCreation() throws IOException
	{
		
		
		GmailLogin.driver.get(GmailLogin.data.getProperty("emailurl"));
		System.out.println("Opened sharklasers website and Creating account/Opening if its already created");
		WebElement inputField = GmailLogin.driver.findElement(sl_id);
		inputField.click();
		WebElement inputText = GmailLogin.driver.findElement(sl_text);
		inputText.sendKeys(GmailLogin.data.getProperty("emailname"));
		WebElement set = GmailLogin.driver.findElement(sl_select);
		set.click();	
		System.out.println("email account has been created");
	}
	
	public static void emailVerification()
	{
		System.out.println("Verifying whether email had come");
		WebElement getMailID = GmailLogin.driver.findElement(sl_emailid);
		if(getMailID.isDisplayed())
		{
			String mailID = getMailID.getText();
			if(GmailLogin.data.getProperty("username").contains(mailID))
			{
				System.out.println("we got mail from the ID:"+mailID);
			}
			else
			{
				System.out.println("we didnt get mail from the ID");
			}
		}
		else
		{
			System.out.println("element is not displayed");
		}
		
	}

}

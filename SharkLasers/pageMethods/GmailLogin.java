package pageMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.GoogleObjects;

public class GmailLogin extends GoogleObjects {
	
	public static WebDriver driver;
	public static Properties data;
	static FileInputStream file;
	static String path = "/Users/raghavendravanam/Documents/workspace/Project01/src/pageUtils/utils.properties";
	
	public static void propFile() throws IOException
	{
		
		data = new Properties();
		file = new FileInputStream(path);
		data.load(file);
		
		
	}
	
	public static void login() throws IOException
	{
		System.out.println("Opening Gmail Site");
		driver.get(data.getProperty("googlesite"));
		WebElement userName = driver.findElement(gmail_id);
		userName.sendKeys(data.getProperty("username"));
		WebElement clickNext = driver.findElement(next);
		clickNext.click();
		WebElement pwd = driver.findElement(gmail_pwd);
		pwd.sendKeys(data.getProperty("password"));
		WebElement signIn = driver.findElement(gmail_signIn);
		signIn.click();		
		System.out.println("Logged in Successfully");
	}
	
	public static void createMail()
	{
		System.out.println("Composing the Mail");
		WebElement compose = driver.findElement(gmail_compose);
		compose.click();
		WebElement toID = driver.findElement(gmail_toMail);
		toID.sendKeys(data.getProperty("tomailID"));
		WebElement subject = driver.findElement(gmail_subject);
		subject.sendKeys(data.getProperty("subject"));
		WebElement send = driver.findElement(gmail_send);
		send.click();
		System.out.println("Mail is Composed and sent");
	}
	
	public static void logOut()
	{
		System.out.println("Logging out from the Account");
		WebElement account = driver.findElement(gmail_account);
		account.click();
		WebElement signout = driver.findElement(gmail_signout);
		signout.click();
		System.out.println("Successfully signed off from google account");
	}

}


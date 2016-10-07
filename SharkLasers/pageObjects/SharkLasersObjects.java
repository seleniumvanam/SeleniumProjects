package pageObjects;

import org.openqa.selenium.By;

public class SharkLasersObjects {
	
	/*
	 * Shark lasers Locators
	*/
	
	public static By sl_id = By.xpath(".//*[@id='inbox-id']");
	public static By sl_text = By.xpath(".//*[@id='inbox-id']/input");
	public static By sl_select = By.xpath(".//*[@id='inbox-id']/button[1]");
	public static By sl_emailid= By.xpath(".//tbody[@id='email_list']//child::tr[1]//child::td[text()='seleniumtest66@gmail.com ']");
	
}

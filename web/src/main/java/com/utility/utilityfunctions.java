package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilityfunctions {

	public static WebElement waitForElementVisible(WebDriver driver, WebElement element)
	{
		try
		{
		WebDriverWait wait = new WebDriverWait(driver, 20);
	//	log.debug("Inside the waitforelementvisible  method");
		wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e)
		{
			element=null;
			return element;
		}
		
		return element;
	}
}

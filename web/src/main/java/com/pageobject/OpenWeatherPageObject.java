package com.pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utility.utilityfunctions;

import java.util.Iterator;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class OpenWeatherPageObject {
	protected WebDriver driver;
    static Logger log = Logger.getLogger(OpenWeatherPageObject.class);
   
	
	public OpenWeatherPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']//li[contains(@class,'nav__item')]")
	private List<WebElement> navigationItems;
	
	@FindBy(xpath="//input[@placeholder='Your city name']")
	private WebElement cityNameField;

	@FindBy(xpath="//button[text()=' Search']")
	private WebElement searchBtn;

	@FindBy(xpath="//button[text()='  Current location']")
	private WebElement currentLocationlk;
	
	@FindBy(xpath="//a[text()=' Sign In']")
	private WebElement signinBtn;
	
	@FindBy(xpath="//a[text()=' Sign Up']")
	private WebElement signupBtn;
	
	@FindBy(xpath="//div[@class='alert alert-warning']")
	private WebElement alertmsg;
	
	@FindBy(xpath="(//div[@class='tab-pane active']//following-sibling::p)[1]")
	private WebElement tempDetailsField;
	


	public void navigateToWeatherMap() throws InterruptedException {
		Thread.sleep(2000);
	    driver.get("https://openweathermap.org/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Current Url is:" +driver.getCurrentUrl());
		
	}

	public void validateWeatherFields(List<List<String>> data) {
		//getting navigation items from UI
		List<WebElement> totalItems=driver.findElements(By.xpath("//ul[@class='nav navbar-nav navbar-right']//li[contains(@class,'nav__item')]"));
		System.out.println("Toal navigation item is:"+totalItems.size());
		//check all navigation fields
		if (totalItems.size() > 0)
		{
			int i=0;
			for(WebElement element: totalItems)
			{ 	
				while(i<totalItems.size())
				{
			//  Validating UI items from Datatable items
				String itemFromUI=element.getText();
				String itemFromDT=data.get(1).get(i);
				if(itemFromUI.equalsIgnoreCase(itemFromDT));
				{	
					System.out.println("Item From UI are:"+itemFromUI);
					System.out.println("Item From Datatable"+itemFromDT);
					break;
			    }
				}
				i++;
		    }
			
		}
		
	}

	public void validateUIFields() {
		//check for page title
		try
		{
		String title=driver.getTitle();
		if(title!=null)
		{
		System.out.println("Title of page is:"+title);
		}
		//check for city name input field 
		if(cityNameField!=null)
		{
		System.out.println("cityNameField is present");
		}
		//check for search button
		if(searchBtn!=null)
		{
		System.out.println("SearchBtn is present");
		}
		//check for current location link
		if(currentLocationlk!=null)
		{
		System.out.println("current location link is present");
		}
		//check for signIn Button
		if(signinBtn!=null)
		{
		System.out.println("signinBtn is present");
		}
		//check for signUp Button
		if(signupBtn!=null)
		{
		System.out.println("signupBtn is present");
		}
		}
		catch(Exception e)
		{
		Assert.fail();
		}
	}

	
	public void enterCityName(String city) {
		try
		{
		//enter city name 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		utilityfunctions.waitForElementVisible(driver, cityNameField);
		System.out.println("city is:"+city);
		cityNameField.sendKeys(city);
		}
		catch(Exception e)
		{
		Assert.fail();
		}
		
	}
	
	

	public void clkSearchWeather() {
		try
		{
		utilityfunctions.waitForElementVisible(driver, searchBtn);
		searchBtn.click();
		}
		catch(Exception e)
		{
		Assert.fail();	
		}
		
	}
	

	public void checkSearchResult(String result) {
		try
		{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		String Result=alertmsg.getText();
		if(Result.contains(result))
		{
		System.out.println("City details:"+Result);
		}
		}
		catch(Exception e)
		{
		Assert.fail();		
		}
		
	}
	
	
	public void checkCityTemp() {
		try
		{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		utilityfunctions.waitForElementVisible(driver, tempDetailsField);
		if(tempDetailsField!=null)
		{
		System.out.println("Temp details are:"+tempDetailsField.getText());
		}
		}
		catch(Exception e)
		{
		Assert.fail();
		}
		
	}

	
	public void connectWeatherAPI() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//connect to EndPoint 
		RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae23";
		//create request object
		RestAssured.useRelaxedHTTPSValidation();
		RequestSpecification request = RestAssured.given();
		//create response object;
		Response response = request.get();
		//check response status
		System.out.println(response.getStatusCode());	
		System.out.println(response.getBody().asString());
		
	}
	
	
	//dynmic wait function
	/*public void waitForElementVisible(WebElement element)
		{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		log.debug("Inside the waitforelementvisible  method");
		wait.until(ExpectedConditions.visibilityOf(element));
		}*/
		
		
}

package com.stepdefn;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pageobject.OpenWeatherPageObject;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class OpenWeatherStepdefinition
{
	private Logger log = Logger.getLogger(OpenWeatherStepdefinition.class.getName());
	protected WebDriver driver;
	private OpenWeatherPageObject pageObject;

	
	// Initialize browser
	@Before
	public void setDriver()
	{
		
		try
		{
			System.setProperty("webdriver.chrome.driver","webdriver/chromedriver_win.exe");
			driver=new ChromeDriver();
		}
		catch(Exception e)
		{
			Assert.fail("unable to launch webdriver");
		}

	}


	@Given("^Navigate to openweathermap$")
	public void navigat_to_openweathermap()
	{
		try
		{
			pageObject = new OpenWeatherPageObject(driver);
			pageObject.navigateToWeatherMap();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}


	@And("^Validate below details$")
	public void validate_below_details(DataTable table) throws Throwable
	{
		try
		{
			Thread.sleep(2000);
			List<List<String>> data = table.asLists(String.class);
			Thread.sleep(3000);
			pageObject = new OpenWeatherPageObject(driver);
			pageObject.validateWeatherFields(data);
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}

	}


	@And("^Validate UI Fields$")
	public void validate_UI_Fields()
	{
		try
		{
			pageObject = new OpenWeatherPageObject(driver);
			pageObject.validateUIFields();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}


	@And("^Enter_City_name as \"([^\"]*)\"$")
	public void enterCityName(String City)
	{
		try
		{
			pageObject = new OpenWeatherPageObject(driver);
			pageObject.enterCityName(City);
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}


	@And("^Click_Search_Weather_Btn$")
	public void searchWeather()
	{
		try
		{
			pageObject = new OpenWeatherPageObject(driver);
			pageObject.clkSearchWeather();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}


	@And("^Validate_Website_Suggestion as \"([^\"]*)\"$")
	public void checkSearchResult(String result)
	{
		try
		{
			pageObject = new OpenWeatherPageObject(driver);
			pageObject.checkSearchResult(result);
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}


	@And("^Check_City_temp$")
	public void checkCityTemp()
	{
		try
		{
			pageObject = new OpenWeatherPageObject(driver);
			pageObject.checkCityTemp();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}


	@And("^Connect to WeatherAPI$")
	public void connectWeatherAPI()
	{
		try
		{
			pageObject = new OpenWeatherPageObject(driver);
			pageObject.connectWeatherAPI();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}
	
	//closing all browser instances 
	@After
	public void closebrowser()
	{	
		try
		{
			driver.quit();
			System.out.println("browser closed successfully");
		}
		catch(Exception e)
		{
			Assert.fail("unable to close browser");
		}

	}



}








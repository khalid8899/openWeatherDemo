@smokeTest
Feature: Ability to create a new record producer and verify assess state
  Sign off - (Pending)
  @TC_001
  Scenario: Validate whether all information is present on UI
    Given Navigate to openweathermap
    And Validate below details
		| NavItem1 | NavItem2 | NavItem3| NavItem4| NavItem5| NavItem6 | NavItem7 | NavItem8 | NavItem9 |
    | Weather  | Maps     | Guide   | API     | Price   | Partners | Station  | Widgets  | Blog     |
    And Validate UI Fields
    
  @TC_002
  Scenario: Validate your city name field with invalid city
    Given Navigate to openweathermap
    And Enter_City_name as "Mumbai12"
    And Click_Search_Weather_Btn
    And Validate_Website_Suggestion as "Not found"
    
   @TC_003
  Scenario: Validate your city name field with valid city 
    Given Navigate to openweathermap
    And Enter_City_name as "Mumbai"
    And Click_Search_Weather_Btn
    And Check_City_temp
    
    @TC_004
  Scenario: validate the response through OpenWeather API
  Given Connect to WeatherAPI
  #And Validate Response
  
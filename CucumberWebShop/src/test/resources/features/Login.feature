Feature: Login into the DemoWebShop WebSite

Background:
Given the User is on the HomePage "https://demowebshop.tricentis.com/"
When the User clicks the login button in the page

 
@ValidLoginCredentials
Scenario: Login with valid credentials

And the User provides email and password
And the User clicks the Login button
Then the User should be logged in to the website

@InValidLoginCredentials
Scenario Outline: Login with invalid credentials
When the User provides email "<email>" and password "<password>"
Then the User is able to visible the error "<errorMsg>"

Examples:
|email							|password			|errorMsg																													|
|chandru234@gamil.com	|Chandru133			|Login was unsuccessful. Please correct the errors and try again.	|
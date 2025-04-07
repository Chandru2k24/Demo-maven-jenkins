
package com.StepDefinitions;


import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Actions.AddressPageActions;
import com.Actions.DashboardPageActions;
import com.Actions.LoginPageActions;
import com.Utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageDefinition {
	
	LoginPageActions objLoginPageActions = new LoginPageActions();
	DashboardPageActions objDashboardPageActions = new DashboardPageActions();
	AddressPageActions objAddressPageActions = new AddressPageActions();
	
	
	@Given("the User is on the HomePage {string}")
	public void the_user_is_on_the_home_page(String url) {
		HelperClass.openWebPage(url);
		
	}

	@When("the User clicks the login button in the page")
	public void the_user_clicks_the_login_button_in_the_page() {
		objLoginPageActions.ClickLoginBtnHomePage();
	}

	@When("the User provides email and password")
	public void the_user_provides_email_and_password() {
		objLoginPageActions.loginCredentials();
	}

	@When("the User clicks the Login button")
	public void the_user_clicks_the_login_button() throws InterruptedException {
//		Thread.sleep(3000);
		objLoginPageActions.ClickLoginBtnLoginPage();
	}

	@Then("the User should be logged in to the website")
	public void the_user_should_be_logged_in_to_the_website() {
		Assert.assertTrue(objLoginPageActions.getLoginPageText().equals("Welcome to our store"));
	}

	@When("the User is able to visible the error")
	public void the_user_is_able_to_visible_the_error(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		WebDriver driver = null ;
		List<Map<String , String>> form = dataTable.asMaps(String.class , String.class);
		Thread.sleep(3000);
		for(Map<String ,String> form1:form) {
			String Username = form1.get("username");
			objLoginPageActions.setEmail(Username);
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(Username);
			String Password = form1.get("password");
			objLoginPageActions.setPassword(Password);
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Password);
			
			String ErrorForMail = form1.get("errorMsg");
			if(ErrorForMail.contains("Please enter a valid email address.")) {
				Assert.assertTrue(objLoginPageActions.errorMailTxt().contains(ErrorForMail));
			}
			else {
				Assert.assertTrue(objLoginPageActions.errorTxt().contains(ErrorForMail));
			}
		}
	}
	@When("the User provides email {string} and password {string}")
	public void the_user_provides_email_and_password(String email, String password) {
		objLoginPageActions.setEmail(email);
		objLoginPageActions.setPassword(password);
		objLoginPageActions.ClickLoginBtnLoginPage();
	}
	
	@Then("the User is able to visible the error {string}")
	public void the_user_is_able_to_visible_the_error(String errormsg) {
		Assert.assertTrue(objLoginPageActions.errorTxt().contains(errormsg));
	}
	
	@When("the User clicks the computer category")
	public void the_user_clicks_the_computer_category() {
		objDashboardPageActions.ClickComputer();
		System.out.println(objDashboardPageActions.getVerifyTxt());
		Assert.assertTrue(objDashboardPageActions.getVerifyTxt().contains("Computers"));
	}

	@When("the User Desktops category")
	public void the_user_desktops_category() {
		objDashboardPageActions.ClickDesktops();
		System.out.println(objDashboardPageActions.getVerifyTxt());
		Assert.assertTrue(objDashboardPageActions.getVerifyTxt().contains("Desktops"));
	}

	@When("the User clicks the simple computer")
	public void the_user_clicks_the_simple_computer() {
		objDashboardPageActions.ClickSimpleComputer();
	}

	@When("the User should click the processor as slow")
	public void the_user_should_click_the_processor_as_slow() {
		objDashboardPageActions.ClickProcessor();
	}

	@Then("the User clicks the add to cart button")
	public void the_user_clicks_the_add_to_cart_button() {
		objDashboardPageActions.ClickAddtocart();
	}
	
	@Given("the User has added a computer to the shopping cart")
	public void the_user_has_added_a_computer_to_the_shopping_cart() {
		Assert.assertTrue(objAddressPageActions.GetShoppingCartTxt().contains("Shopping cart"));
	}

	@Then("Click shopping cart")
	public void click_shopping_cart() {
		objDashboardPageActions.ClickShoppingCart();
		Assert.assertTrue(objDashboardPageActions.getSimpleComputerTxt().contains("Simple Computer"));
	}

	@Then("agree terms and conditions and click checkOut")
	public void agree_terms_and_conditions_and_click_check_out() {
		objDashboardPageActions.ClickAgree();
		objDashboardPageActions.ClickCheckout();
	}
	
	@Then("the User gives the address for shipping")
	public void the_user_gives_the_address_for_shipping() throws InterruptedException {
//		Thread.sleep(3000);
		objAddressPageActions.setAddressDetails();
	}
	
	@Then("click continue button for billing address")
	public void click_continue_button_for_billing_address() {
		objAddressPageActions.ClickContinueBillingAddress();
	}

	@Then("click continue button for Shipping address")
	public void click_continue_button_for_shipping_address() {
		objAddressPageActions.ClickContinueShippingAddress();
	}

	@Then("click continue button for Shipping Method")
	public void click_continue_button_for_shipping_method() {
		objAddressPageActions.ClickContinueShippingMethod();
	}

	@Then("click continue button for Payment Method")
	public void click_continue_button_for_payment_method() {
		objAddressPageActions.ClickContinuePaymentMethod();
	}

	@Then("click continue button for Payment Information")
	public void click_continue_button_for_payment_information() {
		objAddressPageActions.ClickContinuePaymentInformation();
	}

	@Then("click continue button for confirm order")
	public void click_continue_button_for_confirm_order() {
		objAddressPageActions.ClickContinueConfirmOrder();
	}
	
	@Then("Verify the order")
	public void verify_the_order() {
		
		Assert.assertTrue(objAddressPageActions.GetOrderConfirmationMessage().contains("Your order has been successfully processed!"));
		System.out.println(objAddressPageActions.GetOrderConfirmationMessage());
	}

	@Then("the User is able to see the order number")
	public void the_user_is_able_to_see_the_order_number() {
		System.out.println("---------------"+objAddressPageActions.GetOrderNumber()+"---------------");
	}

}

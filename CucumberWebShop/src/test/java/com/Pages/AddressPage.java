
package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.HelperClass;

public class AddressPage  {
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[1]/h1")
	public WebElement shoppingcartText ;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Company']")
	public WebElement company ;
	
	@FindBy(xpath="//*[@id=\"BillingNewAddress_CountryId\"]")
	public WebElement country ;
	
	@FindBy(xpath="//*[@id=\"BillingNewAddress_StateProvinceId\"]")
	public WebElement state ;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_City']")
	public WebElement city ;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_Address1']")
	public WebElement address1 ;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_ZipPostalCode']")
	public WebElement postalCode ;
	
	@FindBy(xpath="//input[@id='BillingNewAddress_PhoneNumber']")
	public WebElement phoneNumber ;
	
	public AddressPage(WebDriver driver) {
		PageFactory.initElements(HelperClass.getDriver(), driver);
	}

	public AddressPage() {
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//select[@id='billing-address-select']")
	public WebElement newAddressDropdown ;
	
	@FindBy(xpath="//*[@id=\"billing-address-select\"]/option[contains(text(),'New Address')]")
	public WebElement newAddress ;
	
	@FindBy(xpath="//input[@title='Continue']")
	public WebElement continueBillingAddress ;
	
	@FindBy(xpath="//*[@id=\"shipping-buttons-container\"]/input")
	public WebElement continueShippingAddress;
	
	@FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/input")
	public WebElement continueShippingMethod ;
	
	@FindBy(xpath="//*[@id=\"payment-method-buttons-container\"]/input")
	public WebElement continuePaymentMethod ;
	
	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/input")
	public WebElement continuePaymentInformation ;
	
	@FindBy(xpath="//*[@id=\"confirm-order-buttons-container\"]/input")
	public WebElement continueConfirmOrder ;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]")
	public WebElement ordernumber ;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")
	public WebElement orderconfirmation ;
}

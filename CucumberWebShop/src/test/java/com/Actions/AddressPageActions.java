package com.Actions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Pages.AddressPage;
import com.Utilities.ExcelData;
import com.Utilities.HelperClass;

public class AddressPageActions {
	
	AddressPage objAddressPage = null ;
    WebDriver driver = null;
    WebDriverWait wait = null;
    
    public AddressPageActions() {
        objAddressPage = new AddressPage();
        driver = HelperClass.getDriver();
        PageFactory.initElements(driver, objAddressPage);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
    }
	
	public void setAddressDetails() {
//		objAddressPage.country.click();
		wait.until(ExpectedConditions.elementToBeClickable(objAddressPage.newAddressDropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(objAddressPage.newAddress)).click();
		wait.until(ExpectedConditions.elementToBeClickable(objAddressPage.country));
	    Select SelectCountry = new Select(objAddressPage.country);
	    List<WebElement> countryname = SelectCountry.getOptions();
	    for (WebElement name : countryname) {
	        if (name.getText().contains("United States")) {
	            name.click();
	            break;
	        }
	    }
	    wait.until(ExpectedConditions.elementToBeClickable(objAddressPage.state));
	    Select SelectState = new Select(objAddressPage.state);
	    List<WebElement> statename = SelectState.getOptions();
	    for (WebElement name : statename) {
	    	wait.until(ExpectedConditions.visibilityOf(name));
	        if (name.getText().contains("Maryland")) {
	            name.click();
	            break;
	        }
	    }
	    String FilePath = "C:\\Users\\drcha\\git\\CucumberMavenPOM\\CucumberWebShop\\src\\test\\resources\\TestData.xlsx";
	    String sheetName = "Sheet1";
	    
	    Map<String, String> addrData = ExcelData.getAddressDetails(FilePath, sheetName);
	    //Thread.sleep(3000);
	    wait.until(ExpectedConditions.visibilityOf(objAddressPage.city));
	    if (addrData.get("City") != null) {
	        objAddressPage.city.sendKeys(addrData.get("City"));
	    }
	    wait.until(ExpectedConditions.visibilityOf(objAddressPage.address1));
	    if (addrData.get("Address") != null) {
	        objAddressPage.address1.sendKeys(addrData.get("Address"));
	    }
	    wait.until(ExpectedConditions.visibilityOf(objAddressPage.postalCode));
	    if (addrData.get("PostalCode") != null) {
	        objAddressPage.postalCode.sendKeys(addrData.get("PostalCode"));
	    }
	    wait.until(ExpectedConditions.visibilityOf(objAddressPage.phoneNumber));
	    if (addrData.get("Phoneno") != null) {
	        objAddressPage.phoneNumber.sendKeys(addrData.get("Phoneno"));
	    }
	}

	public void ClickContinueBillingAddress() {
		
		wait.until(ExpectedConditions.elementToBeClickable(objAddressPage.continueBillingAddress)).click();
//	    objAddressPage.continueBillingAddress.click();
	}

	public void ClickContinueShippingAddress() {
	    wait.until(ExpectedConditions.elementToBeClickable(objAddressPage.continueShippingAddress)).click();
	}


	public void ClickContinueShippingMethod() {
		wait.until(ExpectedConditions.elementToBeClickable(objAddressPage.continueShippingMethod)).click();
//	    objAddressPage.continueShippingMethod.click();
	}

	public void ClickContinuePaymentMethod() {
		wait.until(ExpectedConditions.elementToBeClickable(objAddressPage.continuePaymentMethod)).click();
//	    objAddressPage.continuePaymentMethod.click();
	}

	public void ClickContinuePaymentInformation() {
		wait.until(ExpectedConditions.elementToBeClickable(objAddressPage.continuePaymentInformation)).click();
//	    objAddressPage.continuePaymentInformation.click();
	}

	public void ClickContinueConfirmOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(objAddressPage.continueConfirmOrder)).click();
//	    objAddressPage.continueConfirmOrder.click();
	}

	public void ClickOrderConfirmation() {
		wait.until(ExpectedConditions.elementToBeClickable(objAddressPage.orderconfirmation)).click();
//	    objAddressPage.orderconfirmation.click(); 
	}

	public String GetOrderNumber() {
	    return objAddressPage.ordernumber.getText();
	}

	public String GetOrderConfirmationMessage() {
	    return objAddressPage.orderconfirmation.getText();
	}
	
	public String GetShoppingCartTxt() {
		return objAddressPage.shoppingcartText.getText();
	}

}
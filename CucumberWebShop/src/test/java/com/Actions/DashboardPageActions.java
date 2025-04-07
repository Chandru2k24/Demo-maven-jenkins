package com.Actions;

import org.openqa.selenium.support.PageFactory;

import com.Pages.DashboardPage;
import com.Utilities.HelperClass;

public class DashboardPageActions extends LoginPageActions{
	
	DashboardPage objDashboardPage = null ;
	
	public DashboardPageActions() {
		objDashboardPage = new DashboardPage();
		PageFactory.initElements(HelperClass.getDriver(), objDashboardPage);
	}
	
	public void ClickComputer() {
		objDashboardPage.computer.click();
	}
	
	public void ClickDesktops() {
		objDashboardPage.desktops.click();
	}
	
	public void ClickSimpleComputer() {
		objDashboardPage.simpleComputer.click();
	}
	
	public void ClickProcessor() {
		objDashboardPage.processor.click();
	}
	
	public void ClickAddtocart() {
		objDashboardPage.addtocart.click();
	}
	
	public void ClickAgree() {
		objDashboardPage.termsAndServise.click();
	}
	
	public void ClickShoppingCart() {
		objDashboardPage.shoppingCart.click();
	}
	
	public void ClickCheckout() {
		objDashboardPage.checkout.click();
	}
	
	public String getSimpleComputerTxt() {
		return objDashboardPage.verifySimpleComputr.getText();
	}
	
	public String getVerifyTxt() {
		return objDashboardPage.verify.getText();
	}
	
	
}
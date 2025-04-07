package com.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.Pages.LoginPage;
import com.Utilities.HelperClass;

public class LoginPageActions {
	
	LoginPage objLoginPage = null;
	
	String strEmail , strPassword ;
	
	public LoginPageActions() {
		objLoginPage = new LoginPage();
		PageFactory.initElements(HelperClass.getDriver(), objLoginPage);
	}
	
	
	
	public void setEmail(String strEmail) {
		objLoginPage.email.sendKeys(strEmail);
	}
	
	public void setPassword(String strPassword) {
		objLoginPage.password.sendKeys(strPassword);
	}
	
	public void ClickLoginBtnHomePage() {
		objLoginPage.loginBtnHomePage.click();
	}
	
	public void ClickLoginBtnLoginPage(){
		
		objLoginPage.loginBtnLoginPage.click();
	}
	
	public String errorMailTxt() {
		return objLoginPage.validEmailError.getText();
	}
	
	public String errorTxt() {
		return objLoginPage.error.getText();
	}
	public String getLoginPageText() {

		 return objLoginPage.welcomeText.getText();
	}
	public void loginCredentials() {
		File fileIn = new File("C:\\Users\\drcha\\Desktop\\Cucumber\\CucumberWebShop\\src\\test\\resources\\Data.properties");
		
		FileInputStream fileInput = null ;
		
		try {
			fileInput = new FileInputStream(fileIn);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		strEmail = prop.getProperty("email");
		strPassword = prop.getProperty("password");
		
		this.setEmail(strEmail);
		this.setPassword(strPassword);
	}
	
	public void DataTableLoginCredentials(String username , String password) {
		this.setEmail(username);
		this.setPassword(password);
	}
}
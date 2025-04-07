
package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	@FindBy(xpath="//a[@class='ico-login']")
	public WebElement loginBtnHomePage ;
	
	@FindBy(xpath="//input[@id='Email']")
	public WebElement email ;
	
	@FindBy(xpath="//input[@id='Password']")
	public WebElement password ;
	
	@FindBy(xpath="//input[@class='button-1 login-button']")
	public WebElement loginBtnLoginPage ;
	
	@FindBy(xpath="//div[@class='center-3']/div/div/div[2]/div/h2")
	public WebElement welcomeText ;
	
	@FindBy(xpath="//div[@class='form-fields']/form/div[2]/span/span")
	public WebElement validEmailError;
	
	@FindBy(xpath="//div[@class='message-error']/div/span")
	public WebElement error ;
}

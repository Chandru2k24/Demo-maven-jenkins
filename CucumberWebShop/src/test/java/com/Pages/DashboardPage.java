package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage{
	
	@FindBy(xpath="//div[@class='master-wrapper-content']/div[4]/div[1]/div[1]/div[2]/ul/li[2]/a")
	public WebElement computer ;
	
	@FindBy(xpath="//div[@class='center-2']/div[2]/div[2]/div[1]/div[1]/div/div/a/img")
	public WebElement desktops ;
	
	@FindBy(xpath="//div[@class='product-grid']/div[6]/div/div/a/img")
	public WebElement simpleComputer;
	
	@FindBy(xpath="//input[@id='product_attribute_75_5_31_96']")
	public WebElement processor ;
	
	@FindBy(xpath="//input[@id='add-to-cart-button-75']")
	public WebElement addtocart ;
	
	@FindBy(xpath="//div[@class='header-links']/ul/li[3]/a/span[1]")
	public WebElement shoppingCart ;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr/td[3]/a")
	public WebElement verifySimpleComputr ;
	
	@FindBy(xpath="//input[@id='termsofservice']")
	public WebElement termsAndServise ;
	
	@FindBy(xpath="//button[@id='checkout']")
	public WebElement checkout ;
	
	@FindBy(xpath="//div[@class='center-2']/div[2]/div/h1")
	public WebElement verify ;
	
}
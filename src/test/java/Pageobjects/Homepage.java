package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

	public Homepage(WebDriver driver) {
		super(driver);
		
	}
	
	
	// elements
	
	@FindBy(xpath="//a[@class='login']")  WebElement link_signup;
 	
	@FindBy(xpath="//img[@class='logo img-responsive']")  WebElement img_logo;
	
	@FindBy(name="search_query")  WebElement txt_search;
	
	@FindBy(name="submit_search")  WebElement link_search;
	
	//actions
	
	
	public void Clicksignup()
	{
		link_signup.click();
	}
	
	
	public boolean logotest()
	{
		return (img_logo.isDisplayed());
	}
	
	public String hp_title()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public void serachproduct(String pname)
	{
		txt_search.sendKeys(pname);
	}

	public void Clickserachbutton()
	{
		link_search.click();
	}
	
	
}

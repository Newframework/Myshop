package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends Basepage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	
	//webelements
	@FindBy(xpath="//h1[@class='page-heading']") WebElement text_Myaccount;
	
	@FindBy(xpath="//a[@class='logout']") WebElement btn_signout;
	
	public boolean verifymyaccountpresent()
	{
		try
		{
			return(text_Myaccount.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
	
	public void clicksignout()
	{
		btn_signout.click();
	}
	
	
}

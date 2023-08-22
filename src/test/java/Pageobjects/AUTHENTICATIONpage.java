package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AUTHENTICATIONpage extends Basepage {

	public AUTHENTICATIONpage(WebDriver driver) {
		super(driver);
		
	}

	
	//elements
	
	@FindBy(xpath="//input[@name='email_create']") WebElement txt_emailaddrss;
	
	@FindBy(xpath="//button[@name='SubmitCreate']") WebElement btn_createaccount;
	
	@FindBy(name="email") WebElement txt_email;
	
	@FindBy(name="passwd") WebElement txt_password;
	
	@FindBy(name="SubmitLogin") WebElement btn_submit;
	
	
	//actions
	
	public void setemailadders(String emailid)
	{
		txt_emailaddrss.sendKeys(emailid);
	}
	
	public void Clickcraetebutton()
	{
		btn_createaccount.click();
	}
	
	public void setusername(String username)
	{
		txt_email.sendKeys(username);
	}
	
	public void setpassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		btn_submit.click();
	}
	
	
	
	
	
}

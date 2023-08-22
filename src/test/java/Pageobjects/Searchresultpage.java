package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searchresultpage extends Basepage {

	public Searchresultpage(WebDriver driver) {
		super(driver);
		
	}

	//webelements
	@FindBy(xpath="//a[@class='product-name']") WebElement btn_pname;
	
	
	
	
	//actions
	public boolean productPresent()
	{
		return (btn_pname.isDisplayed());
	}
	
	
	
	
	
	
	
	
	
	
	
}

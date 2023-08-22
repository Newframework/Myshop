package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Createaccountpage extends Basepage{

	public Createaccountpage(WebDriver driver) {
		super(driver);
		
	}

	
	//elements
	
	@FindBy(id="uniform-id_gender1") WebElement rd_Mr;
	
	@FindBy(id="customer_firstname") WebElement txt_fname;
	@FindBy(id="customer_lastname") WebElement txt_lname;
	@FindBy(id="email") WebElement txt_email;
	
	@FindBy(id="passwd") WebElement txt_password;
	
	
	@FindBy(id="days") WebElement drp_days;
	
	@FindBy(id="months") WebElement drp_month;
	
	@FindBy(id="years") WebElement drp_years;
	
	
	@FindBy(name="newsletter") WebElement chk_box;
	 
	@FindBy(name="submitAccount") WebElement btn_Register;
	
	@FindBy(xpath="//p[@class='alert alert-success']") WebElement sucess_msg;
	
	
	// actions
	public void click_radio_button()
	
	{
		rd_Mr.click();
	}
	
   public void setfirstname(String fname)
	
	 {
	  txt_fname.sendKeys(fname);
	  }
	
   public void setlastname(String lname)
	
	 {
	   txt_lname.sendKeys(lname);
	  }
   
   
   public void setpassword(String pwd)
	
	 {
	   txt_password.sendKeys(pwd);
	  }
   
   
   public void select_days_fm_drp(String text)
	
	 {
	   Select sel=new Select(drp_days);
	    
	   sel.selectByValue(text);
	   //sel.selectByVisibleText(text);
	  }
	
   
   public void select_months_fm_drp(String text)
	
	 {
	   Select sel=new Select(drp_month);
	    
	   sel.selectByValue(text);
	   //sel.selectByVisibleText(text);
	  }
   
   public void select_year_fm_drp(String text)
	
	 {
	   Select sel=new Select(drp_years);
	    
	   sel.selectByValue(text);
	   //sel.selectByVisibleText(text);
	  }
   
   public void sign_Chk_button()
	
	{
	   chk_box.click();
	}
   
   public void register_button()
	
	{
	   btn_Register.click();
	}
   
   
   public String comfirm_msg()
   {
	   try {
		   String msg= sucess_msg.getText();
			  
			  return msg;
	   }
	  
	   catch(Exception e) {
		  return e.getMessage();
	   }
	   
   }
   
   
   
}

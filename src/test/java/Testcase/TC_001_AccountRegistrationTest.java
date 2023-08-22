package Testcase;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.AUTHENTICATIONpage;
import Pageobjects.Createaccountpage;
import Pageobjects.Homepage;
import Testbase.Baseclass;

public class TC_001_AccountRegistrationTest extends Baseclass {

	
	Homepage hp;
	AUTHENTICATIONpage ap;
	Createaccountpage cp;
	
	@Test(groups= {"sanity","regression"})
	public void Test_Account_Registration() throws InterruptedException
	{
		
		logger.info("****Accont registartion started******");
		hp= new Homepage(driver);
		ap= new AUTHENTICATIONpage(driver);
		cp=new Createaccountpage(driver);
		
		
		hp.Clicksignup();
		
		
		logger.info("****Accont craetion page started******");
		
		ap.setemailadders(RandomString()+"@gamil.com");
		
		ap.Clickcraetebutton();
		
		cp.click_radio_button();
		
		cp.setfirstname(RandomString());
		cp.setlastname(RandomString());
		
		cp.setpassword(Randomalphanumber());
		
		logger.info("****dropdown list selected******");
		
		cp.select_days_fm_drp("1");
		
		cp.select_months_fm_drp("12");
		
		cp.select_year_fm_drp("2022");
		
		cp.sign_Chk_button();
		
		logger.info("****craet button clicked******");
		cp.register_button();
		
		logger.info("****comparizion started******");
		Assert.assertEquals(cp.comfirm_msg(),"Your account has been created.");
		
		logger.info("****Account creation is done******");
		
	}
	
	
	
	
}

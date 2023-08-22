package Testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.AUTHENTICATIONpage;
import Pageobjects.Homepage;
import Pageobjects.MyAccountPage;
import Testbase.Baseclass;

public class TC_003_LoginTest extends Baseclass {

	AUTHENTICATIONpage ap;
	Homepage hp;
	MyAccountPage mp;
	
	@Test(priority=1,groups= {"sanity"})
	public void logintest()
	{
		hp=new Homepage(driver);
		ap=new AUTHENTICATIONpage(driver);
		mp=new MyAccountPage(driver);
		
		hp.Clicksignup();
		
		ap.setusername(rb.getString("email"));
		ap.setpassword(rb.getString("password"));
		ap.clickSubmit();
		
		System.out.println(mp.verifymyaccountpresent());
		Assert.assertEquals(mp.verifymyaccountpresent(),true);
	}
	
	
	
	
	
}

package Testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.AUTHENTICATIONpage;
import Pageobjects.Homepage;
import Pageobjects.MyAccountPage;
import Testbase.Baseclass;
import Utilities.DataProviders;

public class TC_005_LoginDDTTest extends Baseclass{
	AUTHENTICATIONpage ap;
	Homepage hp;
	MyAccountPage mp;
	
	@Test(dataProvider="loginData", dataProviderClass=DataProviders.class)
	public void test_loginddt(String email, String password, String exp)
	{
		
		
		try {
		hp=new Homepage(driver);
		ap=new AUTHENTICATIONpage(driver);
		mp=new MyAccountPage(driver);
		
		hp.Clicksignup();
		
		ap.setusername(email);
		ap.setpassword(password);
		ap.clickSubmit();
		
		
		//System.out.println(mp.verifymyaccountpresent());
		boolean target=mp.verifymyaccountpresent();
		
		
		
		if(exp.equals("valid"))
		{
			if(target==true)
			{
				mp.clicksignout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		
		if(exp.equals("invalid"))
		{
			if(target==false)
			{
				mp.clicksignout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		
		
		
	}
}

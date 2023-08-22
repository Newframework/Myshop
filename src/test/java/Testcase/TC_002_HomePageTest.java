package Testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.Homepage;
import Testbase.Baseclass;

public class TC_002_HomePageTest extends Baseclass {
Homepage hp;

	@Test(priority=1,groups= {"sanity"})
	public void test_logo()
	{
		hp=new Homepage(driver);
		
		Assert.assertEquals(hp.logotest(),true);
		
	}
	
	@Test(priority=2,groups= {"regression"})
	public void test_title()
	{
		
		System.out.println(hp.hp_title());
		Assert.assertEquals(hp.hp_title(),"My Shop");
		
	}
	
	
}

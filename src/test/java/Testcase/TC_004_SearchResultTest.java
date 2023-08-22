package Testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.Homepage;
import Pageobjects.Searchresultpage;
import Testbase.Baseclass;

public class TC_004_SearchResultTest extends Baseclass{

	Homepage hp;
	Searchresultpage sp;
	
	
	@Test(priority=1,groups= {"regression"})
	public void test_productpresent()
	{
		hp=new Homepage(driver);
		sp=new Searchresultpage(driver);
		
		hp.serachproduct(rb.getString("productname"));
		hp.Clickserachbutton();
		
		
		Assert.assertEquals(sp.productPresent(),true);
		
		
		
		
		
	}
	
}

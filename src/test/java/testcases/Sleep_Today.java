package testcases;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.TodayScreen;

public class Sleep_Today extends TestBase {
	
	TodayScreen today;
	
	@BeforeTest
	public void init() {
		today = new TodayScreen(driver);
		
	}
	
	@Test(priority=1)
	public void validateHeroCardTitle() {
		
		System.out.println("Hello");
		
		String exp_Title = today.verify_HeroTitle();
		String act_Title = "Good Morning,";
		
		System.out.println("Title is "+exp_Title);
		
		Assert.assertEquals(act_Title, exp_Title);
		System.out.println("Title "+act_Title+" is matched");
		
	}
}

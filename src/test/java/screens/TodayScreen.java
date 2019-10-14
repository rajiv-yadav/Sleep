package screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class TodayScreen extends ScreenBase {
	
	@AndroidFindBy(xpath="//*[@text='Good Morning,']")
	public WebElement heroCard_Title;
	
	public TodayScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver,15,TimeUnit.SECONDS), this);
		
	}

	public String verify_HeroTitle()
	{
		return heroCard_Title.getText();
		
	}
}

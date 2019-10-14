package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ScreenBase {
	// A base/parent/super class for all the screens to store all the common things(methods) for the screens
	
	
	public AppiumDriver<MobileElement> driver;
	
	public ScreenBase (AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	
	public void hideKeyboard()
	{
		driver.hideKeyboard();
	}
}

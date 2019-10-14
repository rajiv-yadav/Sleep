package base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utility.AppiumServer;
import utility.CommonUtils;
import utility.ExcelReader;

public class TestBase {
		// A base/parent/super class for all the test cases
	
	public static AppiumDriver<MobileElement> driver;
	
	public static String loadPropertyFile = "Android_sleep.properties";
//	public static String loadPropertyFile = "iOS_sleep.properties";
	
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
	
	public static Logger log = Logger.getLogger("devpinoyLogger");

	
	@BeforeSuite
	public void setUp() throws IOException, InterruptedException {

		if (driver == null) {
			AppiumServer.start();
			log.debug("Appium server started");

			if (loadPropertyFile.startsWith("iOS")) {

				log.debug("Starting on IOS");
				/*
				 * CommonUtils.loadIOSConfigProp(loadPropertyFile);
				 * CommonUtils.setIOSCapabilities(); 
				 * driver = CommonUtils.getIOSDriver();
				 */

			} else if (loadPropertyFile.startsWith("Android")) {

				log.debug("Starting on Android");
				CommonUtils.loadAndroidConfigProp(loadPropertyFile);
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();
			}

		}

	}

	@AfterSuite
	public void tearDown() throws IOException, InterruptedException {

		Thread.sleep(10000);
		driver.quit();
		AppiumServer.stop();
		log.debug("Appium server stoped");

	}

	
	
	
}

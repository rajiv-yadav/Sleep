package rough;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestSleep {

	public static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AppiumDriverLocalService service = AppiumDriverLocalService
	            .buildService(new AppiumServiceBuilder()
	                    .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
	                    .withAppiumJS(new File("C:\\Users\\320074350\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")));
	    service.start(); 

	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("deviceName", "Android");
	    capabilities.setCapability("appPackage", "com.hp.sleep");
	    capabilities.setCapability("appActivity", "com.hp.sleep.MainActivity");
		//cap.setCapability("default", "true");
	    capabilities.setCapability("noReset", "true" );
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			//driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		String str = driver.findElement(By.xpath("//*[@text='Good Morning,']")).getText();
		System.out.println(str);
		
		
		
		
		Thread.sleep(5000);
	    driver.quit();
	   service.stop();
	}

}

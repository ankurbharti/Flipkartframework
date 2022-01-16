package appium.flipkartframework;





import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;
	import io.appium.java_client.remote.AndroidMobileCapabilityType;
	import io.appium.java_client.remote.AutomationName;
	import io.appium.java_client.remote.MobileCapabilityType;

	public class capabilities {
		public static String appPackage;
		public static String appActivity;
		public static String platformName;
		public static String deviceName;
		
		/* public static void StartEmulator() throws IOException, InterruptedException {
			//Runtime.getRuntime().exec("C:\\Users\\user\\eclipse-workspace\\FlipkartFramework\\src\\main\\resources\\emulator.bat");
			//Thread.sleep(15000);
			 * }
			 */
		
		
		public static AndroidDriver<AndroidElement> capability() throws IOException, InterruptedException {
			
		FileReader fis = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\appium\\flipkartframework\\Global.properties");
		Properties pro = new Properties();
		pro.load(fis);
		deviceName = pro.getProperty("deviceName");
		platformName = pro.getProperty("platformName");
		appPackage = pro.getProperty("appPackage");
		appActivity = pro.getProperty("appActivity");
		
        if(deviceName.contains("Redmi Note_5_Pro")) {
	    	
	    	//StartEmulator();
	    	Thread.sleep(2000);
	    	
	    }

		
		
			
			
			
			
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,  appPackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
		
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\user\\Desktop\\chromedriver.exe");
		
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		return driver;
		}
	}
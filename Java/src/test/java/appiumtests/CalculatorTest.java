package appiumtests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {

	
	static AppiumDriver<MobileElement> driver; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			openCalculator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void openCalculator() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "Emulator");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		cap.setCapability("app", "C:\\Users\\Amir\\Downloads\\Calculator_ExactCalculator.apk");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Application Started");
		
		MobileElement one = driver.findElement(By.id("com.android.calculator2:id/digit_1"));
		MobileElement plus = driver.findElement(By.id("com.android.calculator2:id/op_add"));
		MobileElement two = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
		MobileElement equals = driver.findElement(By.id("com.android.calculator2:id/eq"));
		
		one.click();
		plus.click();
		two.click();
		equals.click();
		
		MobileElement results = driver.findElement(By.id("com.android.calculator2:id/result"));		

		System.out.println(results);
		
	}
}

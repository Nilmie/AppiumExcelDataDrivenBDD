package MobileTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import Utility.ReadExcel;

public class Mobile {
	
	static public AndroidDriver<MobileElement> driver, tempDrv;
    static public AndroidDriver<MobileElement> driver2;
//    WebDriver driver;
    
    
    @Test (priority = 0)
    public void test1()throws InterruptedException, NumberFormatException, IOException{
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        capabilities.setCapability("deviceName","HYMFM7QSTGSWZ5SC");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage", "com.android.bbkcalculator");
        capabilities.setCapability("appActivity", "com.android.bbkcalculator.Calculator"); 
        // This is Launcher activity of your app
                                                   // (you can get it from apk info app)
        
      
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        
        String number1=ReadExcel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1");
        String number2=ReadExcel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1");
        String answer=ReadExcel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1");
               
    

            // locate the Text on the calculator by using By.name()
           driver.findElementById("com.android.bbkcalculator:id/digit"+number1).click();
           
           driver.findElementById("com.android.bbkcalculator:id/plus").click();
        
           driver.findElementById("com.android.bbkcalculator:id/digit"+number2).click();
            
            WebElement equalTo = driver.findElementById("com.android.bbkcalculator:id/equal");
            equalTo.click();
            WebElement results = driver.findElementById("com.android.bbkcalculator:id/input_edit");

 

            if(results.getText().equals(answer))
            {
                System.out.println("Test Passed...");
            }
            else
            {
                System.out.println("Test Failed...");
            }
    }

}

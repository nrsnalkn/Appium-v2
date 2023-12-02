package homework;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class HesapMakinasi {
    @Test
    public void hesapMakinasi() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("appPackage","");
        capabilities.setCapability("appActivity","");
        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url,capabilities);
        


    }
}

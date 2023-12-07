package techproed.day02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C01_Capabilities {
    @Test
    public void testUiAutomator2Options() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
               // .setUdid("emulator-5554")//zorunlu değil eğer birden fazla cihazla çalısılıyorsa yazılır
                .setApp("C:\\Users\\Administrator\\IdeaProjects\\Appium_Upskills\\src\\test\\resources\\ApiDemos-debug.apk")
//                .setAppPackage("io.appium.android.apis")
//                .setAppActivity("io.appium.android.apis.ApiDemos")
                .setAvd("Pixel_q_img") //kapalı emilatörleri açar
                .setAvdLaunchTimeout(Duration.ofMinutes(5))
                ;

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, options);

    }

}

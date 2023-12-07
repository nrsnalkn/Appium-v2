package techproed.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;


public class C07_ClickGesture extends ApiDemosBaseTest {
    @Test
    public void testClikGestureElement() {
        // driver.manage().window().getSize();//cihazın çözünürlüğünü verir

        WebElement os = driver.findElement(AppiumBy.accessibilityId("OS"));
        clickGesture(driver, os);
        //click işlemi (os.click();)
//        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) os).getId()
//        ));


    }

    @Test
    public void testClickGestureCoordinate() {//farklı çözünürlüğe sahip olan cihazlarda hata alınır
        clickGesture(driver,495,1241);
//        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
//                "x", 495,
//                "y", 1241
//        ));

    }

}

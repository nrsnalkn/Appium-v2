package techproed.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

public class C09_LongClickGesture extends ApiDemosBaseTest {
    @Test
    public void testLongClickGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Long press me"));
//         driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId(),"duration",1000
//        ));
        longClickGesture(driver,element);
         Thread.sleep(5000);

    }
    @Test
    public void testLongClickGestureCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Long press me"));
//        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
//                "x", 710,"y",543,"duration",1000
//        ));
        longClickGesture(driver,710,543);
        Thread.sleep(5000);

    }
}

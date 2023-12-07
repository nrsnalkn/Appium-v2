package techproed.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

public class C13_FlingGesture extends ApiDemosBaseTest {
    @Test
    public void testFlingeGestureElement() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        WebElement element = driver.findElement(AppiumBy.accessibilityId("ImageButton"));
        driver.executeScript("mobile: flingGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "speed",2000
        ));
    }
    @Test
    public void testFlingGestureCoordinate() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();



        driver.executeScript("mobile: flingGesture", ImmutableMap.of(
                "left", 100, "top", 300, "width", 0, "height", 1000,
                "direction", "down",
                "speed",1000
        ));
    }
}

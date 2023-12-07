package techproed.day06;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.CalculatorBaseTest;
public class C08_DoubleClickGesture extends CalculatorBaseTest {
    @Test
    public void testDoubleClickGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("2")).click();
       WebElement element = driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula"));
//        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) element).getId()
//        ));

        doubleClickGesture(driver,element);
        Thread.sleep(3000);
    }
    @Test
    public void testDoubleClickGestureCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("2")).click();
//        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
//                "x", 1086,
//                "y", 453
//        ));
        doubleClickGesture(driver,1086,453);
        Thread.sleep(10000);
    }
}

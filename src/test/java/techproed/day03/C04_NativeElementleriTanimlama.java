package techproed.day03;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C04_NativeElementleriTanimlama extends ApiDemosBaseTest {
    @Test
    public void testWebElement() throws MalformedURLException, InterruptedException {
        WebElement app = driver.findElement(AppiumBy.accessibilityId("App"));
        app.click();
        WebElement alarm = driver.findElement(AppiumBy.accessibilityId("Alarm"));
        alarm.click();

        WebElement alarmController = driver.findElement(AppiumBy.accessibilityId("Alarm Controller"));
        alarmController.click();
    }

    @Test
    public void testBy() throws MalformedURLException, InterruptedException {
        By app = AppiumBy.accessibilityId("App");
        By alarm = AppiumBy.accessibilityId("Alarm");
        By alarmController = AppiumBy.accessibilityId("Alarm Controller");

        driver.findElement(app).click();

        driver.findElement(alarm).click();

        driver.findElement(alarmController).click();

    }
}
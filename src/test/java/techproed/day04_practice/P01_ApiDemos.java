package techproed.day04_practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

public class P01_ApiDemos extends ApiDemosBaseTest {
    /*
    Uygulama: ApiDemos
    API Demos uygulamasına gir
    Preference seçeneğine tıkla
    3. Preference dependencies seçeneğine tıkla
    WiFi kontrol kutusunu seç
    WiFi settings seçeneğine tıkla
    Açılan ekrandaki başlığın WiFi settings olduğunu doğrula
    Metin kutusuna adını yaz
    Tamam butonuna tıkla
     */

    @Test
    public void testApiDemos() {
        By preference = AppiumBy.accessibilityId("Preference");
        By ucuncuPreferenceDependencies = AppiumBy.accessibilityId("3. Preference dependencies");
        By wifiKontrol = By.id("android:id/checkbox");
        By wifiSetting = AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")");
        By title = By.id("android:id/alertTitle");
        By textBox = By.id("android:id/edit");
        By okButton = By.id("android:id/button1");

        driver.findElement(preference).click();
        driver.findElement(ucuncuPreferenceDependencies).click();
        driver.findElement(wifiKontrol).click();
        driver.findElement(wifiSetting).click();
        Assert.assertEquals(driver.findElement(title).getText(),"WiFi settings");
        driver.findElement(textBox).sendKeys("Esat");
        driver.findElement(okButton).click();


    }
}

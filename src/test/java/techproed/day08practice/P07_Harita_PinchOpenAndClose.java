package techproed.day08practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.HaritalarBaseTest;

public class P07_Harita_PinchOpenAndClose extends HaritalarBaseTest {
    /*
    Uygulama: Haritalar
        Haritalar uygulamasına gir
        Harita türü olarak Uydu seçeneğini seç
        Arama motorunda Taj Mahal kelimelerini arat
        Haritada Taj Mahal bölgesine zoom in ve zoom out işlemlerini yap
    */
    @Test
    public void testPinchOpenAndClose() {
        WebElement katmanlar = driver.findElement(AppiumBy.accessibilityId("Katmanlar"));
        clickGesture(driver, katmanlar);

        WebElement uydu = driver.findElement(AppiumBy.accessibilityId("Uydu"));
        clickGesture(driver, uydu);

        WebElement menuyuKapat = driver.findElement(AppiumBy.accessibilityId("Menüyü kapat"));
        clickGesture(driver, menuyuKapat);

        WebElement aramaMotoru = driver.findElement(AppiumBy.accessibilityId("Burada arayın"));
        aramaMotoru.sendKeys("Taj Mahal");


    }
}


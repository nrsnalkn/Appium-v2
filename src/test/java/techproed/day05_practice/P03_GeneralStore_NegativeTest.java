package techproed.day05_practice;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.GeneralStoreBaseTest;

public class P03_GeneralStore_NegativeTest extends GeneralStoreBaseTest {
    /*
    Uygulama: GeneralStore
    GeneralStore uygulamasına gir
    Menüden Angola seçeneğini seç
    Your Name kutusunu boş bırak
    Let’s Shop butonuna tıkla
    Hata mesajını doğrula (Toast Message)
     */
    @Test
    public void generalStoreNegativeTest() {
        //tost mesajı handle etme
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String tostMesaj = driver.findElement(AppiumBy.xpath("//android.widget.Toast")).getAttribute("name");

        Assert.assertEquals(tostMesaj,"Please enter your name");
    }
}

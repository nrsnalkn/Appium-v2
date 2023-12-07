package techproed.day08practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.KitapYurduBaseTest;

import java.util.List;

public class P06_KitapYurdu_ScrollSwipeGestures extends KitapYurduBaseTest {
    /*
    Uygulama: Kitap Yurdu
        Kitap Yurdu uygulamasına gir
        İlgi Görenler bölümündeki 5. kitaba tıkla
        Kitap adı, Yazar adı ve Yayınevi adı bilgilerini yazdır
        Künye başlıklarını ve bilgilerini yazdır
    */
    @Test
    public void testKitapYurdu() throws InterruptedException {
        WebElement swipeElement = driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/recyclerViewList"));
        swipeGesture(driver, swipeElement, "left", 1.0, 1000);

        WebElement besinciKitap = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.mobisoft.kitapyurdu:id/imageViewProduct\"])[2]"));
        clickGesture(driver, besinciKitap);

        List<WebElement> kitapBilgileri = driver.findElements(AppiumBy.xpath("//android.widget.ScrollView[@resource-id=\"com.mobisoft.kitapyurdu:id/productDetailScrollView\"]/android.view.ViewGroup/android.widget.TextView"));
        System.out.println("Kitap Adı:" + kitapBilgileri.get(0).getText());
        System.out.println("Yazar Adı:" + kitapBilgileri.get(1).getText());
        System.out.println("Yayınevi Adı:" + kitapBilgileri.get(2).getText());
        System.out.println("________________________________");

        WebElement scrollElement = driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/productDetailScrollView"));
        scrollGesture(driver, scrollElement, "down", 2.3, 1000);

        List<WebElement> kunyeBasliklari = driver.findElements(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewAttributeTitle"));
        List<WebElement> kunyeBilgileri = driver.findElements(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewAttributeName"));
        for (int i = 0; i < kunyeBasliklari.size(); i++) {
            System.out.print(kunyeBasliklari.get(i).getText() + "\t");
            System.out.println(kunyeBilgileri.get(i).getText());
        }

    }
}
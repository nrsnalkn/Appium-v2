package techproed.day13_practice;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.GeneralStoreBaseTest;

import java.util.List;

public class P08_HibritUygulama_GeneralStore extends GeneralStoreBaseTest {
    @Test
    public void testGeneralStore() throws InterruptedException {
        //menü click
        WebElement menu = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
        menu.click();
        //ülke seçimi
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Barbados\"))"));
        WebElement barbados = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Barbados\"]"));
        barbados.click();
        //isim
        WebElement nameBox = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
        nameBox.sendKeys("Safinaz");
        //cinsiyet
        WebElement female = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
        female.click();
        //Button tıklama
        WebElement button = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
        button.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LeBron Soldier 12 \"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).click();

        WebElement cart = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
        cart.click();
        bekle(3);
        System.out.println(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText());

        List<WebElement> products = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
        Assert.assertEquals(products.size(), 2);

        Thread.sleep(5000);
        double total = 0;
        for (WebElement w:products) {
            String priceText = w.getText();
            Thread.sleep(5000);
            double price = Double.parseDouble(priceText.substring(1));
            total += price;
        }
//        for (int i = 0; i < products.size(); i++) {
//
//            String priceText = products.get(i).getText(); // $160.97 --> $120.0
//            double price = Double.parseDouble(priceText.substring(1)); // 160.97  --> 120.0
//            total += price;
//        }

        double totalAmount = Double.parseDouble(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));

        Assert.assertEquals(total, totalAmount);
        //checkbox tıklar
        WebElement checkBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        checkBox.click();
        //visit buttonu tıklar
        WebElement visitButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
        visitButton.click();
        bekle(5);
        //Hibrit Uygulama

        driver.context("WEBVIEW_com.androidsample.generalstore");

        //arama motoru
        driver.findElement(By.name("q")).sendKeys("Temel Reis", Keys.ENTER);

        //native uygulamaya geçme
        driver.pressKey(new KeyEvent(AndroidKey.BACK)); //sayfayı geri alma
        driver.context("NATIVE_APP");
        bekle(5);
        // Başlık Doğrulaması
        String baslik = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals(baslik, "General Store");
    }
}

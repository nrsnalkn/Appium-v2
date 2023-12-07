package techproed.day05_practice;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.MyDemoAppBaseTest;

import java.util.List;

public class P04_MyDemoApp_ColorTest extends MyDemoAppBaseTest {
    /*
    MyDemoApp uygulamasına gir
    Menüyü aç
    Login ol (bob@example.com, 10203040)
    Login butonuna tıkla
    İlk ürünü seç
    Renk olarak mavi seç
    Add To Cart butonuna tıkla
    Renk olarak kırmızı seç
    Add To Cart butonuna tıkla
    Sepete git
    Listede iki ürün olduğunu doğrla
    Listedeki ürünlerin mavi ve kırmızı olduğunu doğrula
     */

    @Test
    public void myDemmoAppColorTest() {
        WebElement menu = driver.findElement(AppiumBy.accessibilityId("open menu"));
        menu.click();
        WebElement logIn = driver.findElement(AppiumBy.accessibilityId("menu item log in"));
        logIn.click();
        WebElement userName = driver.findElement(AppiumBy.accessibilityId("Username input field"));
        userName.sendKeys("bob@example.com");
        WebElement password = driver.findElement(AppiumBy.accessibilityId("Password input field"));
        password.sendKeys("10203040");

        WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("Login button"));
        loginButton.click();

        WebElement prodactTitle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")"));
        prodactTitle.click();

//         WebElement buleColor = driver.findElement(AppiumBy.accessibilityId("blue circle"));
//          buleColor.click();
        By blueCircle = AppiumBy.accessibilityId("blue circle");// Sayfa değiştiğinde aynı elementi kullanmak istiyorum. SataleElement almamak için By ile tanımladım.
        driver.findElement(blueCircle).click();

        WebElement addToCart = driver.findElement(AppiumBy.accessibilityId("Add To Cart button"));
        addToCart.click();

//     WebElement red = driver.findElement(AppiumBy.accessibilityId("red circle"));
//     red.click();
        By redCircle = AppiumBy.accessibilityId("red circle");
        driver.findElement(redCircle).click();

        addToCart.click();

        WebElement cart = driver.findElement(AppiumBy.accessibilityId("cart badge"));
        cart.click();

        List<WebElement> totalItmes = driver.findElements(AppiumBy.accessibilityId("product row"));
        Assert.assertEquals(totalItmes.size(), 2);

        Assert.assertTrue(driver.findElement(blueCircle).isDisplayed());
        Assert.assertTrue(driver.findElement(redCircle).isDisplayed());


    }
}

package techproed.day13_practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.ChromeBrowserBaseTest;

public class P09_MobilWebUygulama_KitapYurdu extends ChromeBrowserBaseTest {
    @Test
    public void testRegister() {
        driver.get("https://www.kitapyurdu.com/");
        bekle(10);
        //cookie
        driver.findElement(By.id("cookiescript_accept")).click();
        //giriş
        driver.findElement(By.xpath("//a[@href=\"index.php?route=account/account\"]")).click();

        driver.findElement(By.partialLinkText("Ücretsiz Üye Ol")).click();
        //ad
        driver.findElement(By.id("firstname")).sendKeys("Ayse");
        //soyad
        driver.findElement(By.id("lastname")).sendKeys("ekinci");
        //mail
        driver.findElement(By.id("email")).sendKeys("abcde1245@gmail.com");
        //sifre
        driver.findElement(By.id("password")).sendKeys("12345678");
        //confirim
        driver.findElement(By.id("confirm")).sendKeys("12345678");
        driver.hideKeyboard();
        //checkout
        driver.findElement(By.id("form-check-input")).click();
        driver.findElement(By.id("newsletter")).click();
        //üye ol butonu
        driver.findElement(By.id("register-button")).click();
        //doğrulama
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Hesabınız Oluşturuldu!']")).getText(),"Hesabınız Oluşturuldu!");
    }
}

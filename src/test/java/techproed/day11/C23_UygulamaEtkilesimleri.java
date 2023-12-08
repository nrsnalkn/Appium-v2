package techproed.day11;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

import java.io.File;
import java.time.Duration;
public class C23_UygulamaEtkilesimleri extends ApiDemosBaseTest {
    @Test
    public void testTerminateApp() {//uygulama kapatma
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        bekle(2);
        driver.terminateApp("io.appium.android.apis");
        bekle(5);
    }
    @Test
    public void testActivateApp() {//kapalı uygulamayı açma
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        bekle(2);
        driver.terminateApp("io.appium.android.apis");
        bekle(2);
        driver.activateApp("com.google.android.calculator");
        bekle(3);
        driver.activateApp("io.appium.android.apis");
        bekle(3);
    }
    @Test
    public void testRunAppInBackground() {//arka planda uygulama açma
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        bekle(2);
        driver.runAppInBackground(Duration.ofSeconds(5));
        bekle(3);
    }
    @Test
    public void testInstallApp() {//uygulama yükleme
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";

        driver.installApp(appUrl);
        bekle(5);

    }
    @Test
    public void isAppInstalled() {
        System.out.println(driver.isAppInstalled("com.saucelabs.mydemoapp.rn"));
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";

        driver.installApp(appUrl);
        System.out.println(driver.isAppInstalled("com.saucelabs.mydemoapp.rn"));
        bekle(5);


    }

    @Test
    public void testQueryAppState() {//uygulamanın durumunu verir bize
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        bekle(3);

        driver.terminateApp("io.appium.android.apis");
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        bekle(3);

        driver.activateApp("io.appium.android.apis");
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        bekle(3);
        driver.activateApp("com.google.android.calculator");
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        bekle(3);
    }
}
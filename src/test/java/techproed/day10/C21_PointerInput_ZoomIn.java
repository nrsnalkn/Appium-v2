package techproed.day10;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import techproed.basetest.VodQABaseTest;

import java.time.Duration;
import java.util.Arrays;

public class C21_PointerInput_ZoomIn extends VodQABaseTest {
    @Test
    public void testZoomIn() {
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();
        PointerInput finger1= new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        PointerInput finger2= new PointerInput(PointerInput.Kind.TOUCH,"finger2");

        Sequence sequence1=new Sequence(finger1,0);
        Sequence sequence2=new Sequence(finger2,1);

        sequence1
                .addAction(finger1.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),230,1519))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(),696,1542))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        bekle(2);
        sequence2
                .addAction(finger2.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),1200,1541))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2,Duration.ofMillis(500)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(),783,1541))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        bekle(5);
        driver.perform(Arrays.asList(sequence1,sequence2));
    }
}

package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Sprint extends BaseTest {

    @Test
    public void sprint() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Key Presses']")).click();
        Actions act = new Actions(driver);
        WebElement textBox = driver.findElement(By.id("target"));
        act.keyDown(Keys.SHIFT).sendKeys(textBox,"vani").keyUp(Keys.SHIFT).sendKeys("vani").build().perform();

    }
}

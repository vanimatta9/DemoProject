import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestClass extends BaseTest {

    @Test
    public void dragAndDrop(){
        driver.findElement(By.xpath("//a[text()='Drag and Drop']")).click();
        WebElement srcElement = driver.findElement(By.id("column-a"));
        WebElement destElement = driver.findElement(By.id("column-b"));
        Actions act = new Actions(driver);
        act.dragAndDrop(srcElement,destElement);
    }
    @Test
    public void test2(){
        driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select s = new Select(dropdown);
        s.selectByValue("1");
    }

}

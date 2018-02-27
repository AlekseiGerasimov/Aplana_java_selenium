package task2;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

//        Проверить, что footer содержит значки социальных сетей

//WebElement draggable = driver.findElement(By.id("element"));
//        WebElement target = driver.findElement(By.id("container"));
//        new Actions(driver).dragAndDrop(draggable, target).perform();
public class TestClass {
    private static WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.get("http://www.sberbank.ru/ru/person");
    }

    @Test
    public void userLogin() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='kit-hidden kit-hidden_screenreader']//span[@class='region-list__name']//ancestor::span")).click();
        TimeUnit.MILLISECONDS.sleep(1000);
        driver.findElement(By.xpath("//*[@data-id='52']")).click();
        assertEquals("Нижегородская область",driver.findElement(By.xpath("//*[text()='Нижегородская область']")).getText());
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, document.body.scrollHeight);");
        assertEquals(6,driver.findElements(By.xpath("//li[@class='social__item']")).size());
    }
    //*[@placeholder='Введите название региона']
    @After
    public void tearDown() {

    }
}
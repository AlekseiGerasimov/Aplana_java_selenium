package testid;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestClass {
    private static WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.get("http://www.rgs.ru");
    }

    @Test
    public void userLogin() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Страхование') and @data-toggle ='dropdown']")).click();
        driver.findElement(By.xpath("//div[@class = 'grid rgs-main-menu-links'] // a[contains(text(),'ДМС')]")).click();
        Assert.assertEquals("H1 error","ДМС — добровольное медицинское страхование",driver.findElement(By.xpath("//h1")).getText());
        WebElement element = driver.findElement(By.xpath("//div[@class='rgs-context-bar-content-call-to-action-buttons']//a[contains(text(),'Отправить заявку')]"));
        TimeUnit.MILLISECONDS.sleep(1000);
        element.click();
        TimeUnit.MILLISECONDS.sleep(1000);
        Assert.assertEquals("Заявка на добровольное медицинское страхование",driver.findElement(By.xpath("//h4/b")).getText());
        driver.findElement(By.xpath("//input[@name = 'LastName']")).sendKeys("Герасимов");
        driver.findElement(By.xpath("//input[@name = 'FirstName']")).sendKeys("Алексей");
        driver.findElement(By.xpath("//input[@name = 'MiddleName']")).sendKeys("Алексеевич");
        Select select = new Select(driver.findElement(By.xpath("//select[@name = 'Region']")));
        select.selectByVisibleText("Вологодская область");
        driver.findElement(By.xpath("//label[contains(text(),'Телефон')]/following-sibling::input")).sendKeys("9152208910");
        driver.findElement(By.xpath("//label[contains(text(),'Эл. почта')]/following-sibling::input")).sendKeys("qwertyqwerty");
        driver.findElement(By.xpath("//label[contains(text(),'Комментарии')]/following-sibling::textarea")).sendKeys("Прост тестовый набор данных");
        driver.findElement(By.xpath("//*[@class='checkbox']")).click();
        driver.findElement(By.xpath("//*[@id='button-m']")).click();
        TimeUnit.MILLISECONDS.sleep(1000);
        Assert.assertEquals("Введите адрес электронной почты",driver.findElement(By.xpath("//*[text()='Введите адрес электронной почты']")).getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

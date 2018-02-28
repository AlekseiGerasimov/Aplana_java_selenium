package tod;

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
    private RGS page;

    @Before
    public void setUp(){
        page = new RGS("http://www.rgs.ru");
    }

    @Test
    public void userLogin() throws InterruptedException {
        page.findAndClick("//a[contains(text(),'Страхование') and @data-toggle ='dropdown']");
        page.findAndClick("//div[@class = 'grid rgs-main-menu-links'] // a[contains(text(),'ДМС')]");
        page.asserted("ДМС — добровольное медицинское страхование","//h1");
        page.waitingForVisibleAndClick("//div[@class='rgs-context-bar-content-call-to-action-buttons']//a[contains(text(),'Отправить заявку')]");
        page.waitingForVisible("//h4/b");
        page.asserted("Заявка на добровольное медицинское страхование","//h4/b");
        page.fillFields("//input[@name = 'LastName']","Герасимов");
        page.fillFields("//input[@name = 'FirstName']","Алексей");
        page.fillFields("//input[@name = 'MiddleName']","Алексеевич");
        page.fillSelect("//select[@name = 'Region']","Вологодская область");
        page.fillFields("//label[contains(text(),'Телефон')]/following-sibling::input","9152208910");
        page.fillFields("//label[contains(text(),'Эл. почта')]/following-sibling::input","qwertyqwerty");
        page.fillFields("//label[contains(text(),'Комментарии')]/following-sibling::textarea","Прост тестовый набор данных");
        page.findAndClick("//*[@class='checkbox']");
        page.assertFinalPage("Герасимов","Алексей","Алексеевич","Вологодская область","qwertyqwerty","+7 (915) 220-89-10","Прост тестовый набор данных");
        page.findAndClick("//*[@id='button-m']");
        page.waitingForVisible("//*[text()='Введите адрес электронной почты']");
        page.asserted("Введите адрес электронной почты","//*[text()='Введите адрес электронной почты']");
    }

    @After
    public void tearDown() throws InterruptedException {
        page.quit();
    }



}
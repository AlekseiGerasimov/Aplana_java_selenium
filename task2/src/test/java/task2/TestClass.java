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



public class TestClass {
    SberClassPage page;

    @Before
    public void setUp(){
        page = new SberClassPage("http://www.sberbank.ru/ru/person");
    }

    @Test
    public void userLogin() throws InterruptedException {
        page.findAndClick("//div[@class='kit-hidden kit-hidden_screenreader']//span[@class='region-list__name']//ancestor::span");
        page.waited("//*[@data-id='52']");
        page.findAndClick("//*[@data-id='52']");
        page.asserted("Нижегородская область", "//*[text()='Нижегородская область']");
        page.scrollToFooter();
        page.asserted_social();
    }

    @After
    public void tearDown() {
        page.quit();
    }
}
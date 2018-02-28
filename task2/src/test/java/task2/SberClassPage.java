package task2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SberClassPage {
    private static WebDriver driver;

    SberClassPage(String adr){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.get(adr);
    }

    public void findAndClick(String xpath_field){
        driver.findElement(By.xpath(xpath_field)).click();
    }

    public void waited(String xpath_field){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath_field))));
    }

    public void asserted(String expected,String xpath_filed){
        String str = driver.findElement(By.xpath(xpath_filed)).getText();
        if(str.length() == 0)
            str = driver.findElement(By.xpath(xpath_filed)).getAttribute("value");
        Assert.assertEquals(expected,str);
    }

    public void asserted_social(){
        Assert.assertEquals("https://www.facebook.com/bankdruzey",driver.findElement(By.xpath("//div[@class='social__wrapper']//a[@href='https://www.facebook.com/bankdruzey']")).getAttribute("href"));
        Assert.assertEquals("http://twitter.com/sberbank/",driver.findElement(By.xpath("//div[@class='social__wrapper']//a[@href='http://twitter.com/sberbank/']")).getAttribute("href"));
        Assert.assertEquals("http://www.youtube.com/sberbank",driver.findElement(By.xpath("//div[@class='social__wrapper']//a[@href='http://www.youtube.com/sberbank']")).getAttribute("href"));
        Assert.assertEquals("http://instagram.com/sberbank",driver.findElement(By.xpath("//div[@class='social__wrapper']//a[@href='http://instagram.com/sberbank']")).getAttribute("href"));
        Assert.assertEquals("http://vk.com/sberbank",driver.findElement(By.xpath("//div[@class='social__wrapper']//a[@href='http://vk.com/sberbank']")).getAttribute("href"));
        Assert.assertEquals("https://ok.ru/sberbank",driver.findElement(By.xpath("//div[@class='social__wrapper']//a[@href='https://ok.ru/sberbank']")).getAttribute("href"));
    }

    public void scrollToFooter(){
        WebElement element = driver.findElement(By.xpath("//*[@class='sbrf-div-list-inner --area bp-area footer-container']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);",element);
    }
    public void quit(){
        driver.quit();
    }
}

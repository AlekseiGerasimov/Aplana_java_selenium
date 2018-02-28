package task3;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class YandexPage {
    private static WebDriver driver;
    YandexPage(String str){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(str);
    }
    public void findAndClick(String xpath_field){
        driver.findElement(By.xpath(xpath_field)).click();
    }
    public void findAndSetValue(String xpath_field,String value){
        driver.findElement(By.xpath(xpath_field)).sendKeys(value);
    }
    public void assertNumberOfElements(String expected,String xpath_field){
        Assert.assertEquals(expected, String.valueOf(driver.findElements(By.xpath(xpath_field)).size()));
    }
    public void asserted(String expected,String xpath_field){
        String str = driver.findElement(By.xpath(xpath_field)).getText();
        if(str.length() == 0)
            str = driver.findElement(By.xpath(xpath_field)).getAttribute("alt");
        Assert.assertEquals(expected,str);
    }
    public void findFirstElementAndCheck(String xpath_field){
        WebElement element = driver.findElement(By.xpath(xpath_field));
        String str = element.getAttribute("title");
        findAndSetValue("//input[@id='header-search']",str);
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ENTER).perform();
    }

    public void chooceCategory(String xpath_field){
        try{
            driver.findElement(By.xpath(xpath_field)).click();
        }
        catch(WebDriverException e){
            findAndSetValue("//input[@id='header-search']","Электроника");
            Actions builder = new Actions(driver);
            builder.sendKeys(Keys.ENTER).perform();
        }
    }
    public void quit(){
        driver.quit();
    }
}

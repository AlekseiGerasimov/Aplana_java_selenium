package tod;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RGS {

    private static WebDriver driver;

    RGS(String str){
        driver = new ChromeDriver();
        driver.get(str);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    }

    public void fillFields(String xpath_field,String value){
        WebElement element = driver.findElement(By.xpath(xpath_field));
        element.click();
        element.clear();
        element.sendKeys(value);
    }
    public void fillSelect(String xpath_field,String value){
        Select select = new Select(driver.findElement(By.xpath(xpath_field)));
        select.selectByVisibleText(value);
    }

    public void findAndClick(String xpath_field){
        driver.findElement(By.xpath(xpath_field)).click();
    }

    public void asserted(String expected,String xpath_actual){
        String str = driver.findElement(By.xpath(xpath_actual)).getText();
        if(str.length() == 0)
            str = driver.findElement(By.xpath(xpath_actual)).getAttribute("value");
        Assert.assertEquals(expected,str);
    }
    public void asserted(String expected,Select select){
        Assert.assertEquals(expected,select.getFirstSelectedOption().getText());
    }

    public void waitingForVisibleAndClick(String xpath_field){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.pollingEvery(1,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath_field))));
        try {
            driver.findElement(By.xpath(xpath_field)).click();
        }
        catch(WebDriverException e){
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath_field))));
            driver.findElement(By.xpath(xpath_field)).click();
        }
    }
    public void waitingForVisible(String xpath_field){
        WebDriverWait wait = new WebDriverWait(driver,5,1500);
        wait.pollingEvery(100,TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath_field))));
    }

    public void assertFinalPage(String LastName,String FirstName,String MiddleName,String region,String mail,String phone,String comments){
        asserted(LastName,"//input[@name = 'LastName']");
        asserted(FirstName,"//input[@name = 'FirstName']");
        asserted(MiddleName,"//input[@name = 'MiddleName']");
        asserted(phone,"//label[contains(text(),'Телефон')]/following-sibling::input");
        asserted(mail,"//label[contains(text(),'Эл. почта')]/following-sibling::input");
        asserted(comments,"//label[contains(text(),'Комментарии')]/following-sibling::textarea");
        asserted(region,new Select(driver.findElement(By.xpath("//select[@name = 'Region']"))));
    }

    public void quit(){

    }
}

package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.HashMap;
import java.util.List;



public class BasePage {
    public WebDriver driver = BaseSteps.getDriver();
    BasePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[@class='bHeaderCategoryLinks ']/a")
    List<WebElement> categories;

    @FindBy(xpath="//div[@class='eMyOzon_Item_Bottom']")
    WebElement basket;

    @FindBy(xpath="//div[@class='bDYbanner_subscription']")
    WebElement banner;

    @FindBy(xpath="//div[@class='close-icon eDYbanner_close jsCloseBanner']")
    WebElement closebanner;

    public void clickToCategory(String category){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            wait.until(ExpectedConditions.visibilityOf(banner));
            closebanner.click();
        }
        catch(WebDriverException ex) {

        }
        for(WebElement element : categories){
            if(element.getText().equalsIgnoreCase(category)){
                element.click();
                return;
            }
        }
        Assert.fail("Не найдена такая категория: " + category);
    }

    public void clickToBasket(){
        basket.click();
    }

    public HashMap<String,String> product = new HashMap<>();
}

package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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



    public void clickToCategory(String category){
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

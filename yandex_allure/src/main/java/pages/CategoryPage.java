package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class CategoryPage extends BaseYandexPage {
    public CategoryPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[@class='layout-grid__col layout-grid__col_width_2']")
    WebElement goods;

    @FindBy(xpath="//input[@id='header-search']")
    WebElement insertfield;

    public ProductPage productSearch(String product_name){
        String str = (".//a[contains(text(),'").concat(product_name).concat("')]");
        try {
            goods.findElement(By.xpath(str)).click();
        }
        catch(WebDriverException e){
            insertfield.clear();
            insertfield.click();
            insertfield.sendKeys(product_name);
            Actions builder = new Actions(driver);
            builder.sendKeys(Keys.ENTER).perform();
        }
        return new ProductPage();
    }
}

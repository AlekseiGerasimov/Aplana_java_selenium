package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class BasketPage extends BasePage {
    public BasketPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[@class='eCartItem_nameValue']")
    WebElement name;

    @FindBy(xpath="//span[@class='eCartItem_price]")
    WebElement price;

    @FindBy(xpath="//div[@class='eCartControls_buttons']")
    WebElement removeAll;

    @FindBy(xpath="//span[contains(text(),'Корзина') and contains(text(),'пуста')]")
    WebElement header;

    @FindBy(xpath="//div[contains(text(),'Доставим')]")
    WebElement visibilityconditions;

    public void checkBasket(){
        for(Map.Entry<String,String> entry : product.entrySet()) {
            Assert.assertEquals(entry.getKey(), name.getText());
            Assert.assertEquals(entry.getValue(), price.getText());
        }
    }

    public void clearBasket(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(visibilityconditions));
        wait.until(ExpectedConditions.elementToBeClickable(removeAll));
        removeAll.click();
    }

    public void checkContentBasket(){
        try {
            Assert.assertEquals("Корзина пуста", header.getText());
        }
        catch(WebDriverException ex){
            removeAll.click();
            Assert.assertEquals("Корзина пуста", header.getText());
        }
    }
}

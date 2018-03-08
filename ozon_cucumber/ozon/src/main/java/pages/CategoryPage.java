package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class CategoryPage extends BasePage {
    public CategoryPage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    @FindBy(xpath="//div[@class='bLeftMainMenu no-mobile']//a")
    private List<WebElement> menu;

    public void clickToType(String type){
        for(WebElement element : menu){
            if(element.getText().equalsIgnoreCase(type)){
                element.click();
                return;
            }
        }
        Assert.fail("Не найдена такая категория: " + type);
    }
}

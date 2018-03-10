package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class BaseYandexPage {
    public WebDriver driver = BaseSteps.getDriver();
    public BaseYandexPage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    @FindBy(xpath = "//a[@data-id='market']")
    private WebElement marketButton;

    public MarketPage clickToMarket(){
        try {
            marketButton.click();
        }
        catch (WebDriverException ex){
            driver.get("https://www.yandex.ru/");
            marketButton.click();
        }
        return new MarketPage();
    }

    public void quit(){
        driver.quit();
    }
}

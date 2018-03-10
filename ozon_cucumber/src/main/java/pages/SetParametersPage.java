package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;
import java.util.StringTokenizer;

public class SetParametersPage extends BasePage {
    public SetParametersPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[@class='eBottomRoll_Link']")
    private WebElement buttontoview;

    @FindBy(xpath="//input[@class='eFromToInput_InputField mFrom']")
    private WebElement minprice;

    @FindBy(xpath="//input[@class='eFilterList_SearchInput']")
    private WebElement enter;

    @FindBy(xpath="//div[@class='eFacetTopControl_Filters']//div[@class='bFlatButton mMicro mWhite']")
    private WebElement buttontouse;

    @FindBy(xpath="//div[@class='bTilesModeShow clear_group']//div[@class='bOneTile inline jsUpdateLink mRuble ']")
    private WebElement resultproduct;

    @FindBy(xpath="//div[@class='bSaleBlockButton jsButton']")
    private WebElement basket;

    @FindBy(xpath="//div[@id='facetControl_brand']")
    private WebElement menu;

    @FindBy(xpath="//div[@class='bDYbanner_subscription']")
    private WebElement banner;

    @FindBy(xpath="//div[@class='close-icon eDYbanner_close jsCloseBanner']")
    private WebElement bannerclose;

    @FindBy(xpath="//div[@class='close-icon eDYbanner_close jsCloseBanner']")
    private WebElement sideelement;

    public void setMakers(String... name) {
        for (int i = 0; i < name.length; ++i) {
            try{
                buttontoview.click();
                driver.findElement(By.xpath("//span[contains(text(),'".concat(name[i]).concat("')]"))).click();
            }
            catch(NoSuchElementException ex){
                try {
                    menu.findElement(By.xpath(".//a[contains(text(),'".concat(name[i]).concat("')]"))).click();
                }
                catch (WebDriverException ex1){
                    sideelement.click();
                    menu.findElement(By.xpath(".//a[contains(text(),'".concat(name[i]).concat("')]"))).click();
                }
            }
            }
    }


    public void setPrice(String price){
        minprice.click();
        minprice.clear();
        minprice.sendKeys(price);
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ENTER).perform();
        buttontouse.click();
    }

    public void moveToBasket(){
        product.put(resultproduct.findElement(By.xpath(".//div[@itemprop='name']")).getText(),resultproduct.findElement(By.xpath(".//span[@class='eOzonPrice_main']")).getText());
        resultproduct.click();
        basket.click();
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePage{

    public MainPage(){
        PageFactory.initElements(driver,this);
    }

}

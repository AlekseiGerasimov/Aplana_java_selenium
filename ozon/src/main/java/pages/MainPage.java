package pages;

import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage(){
        PageFactory.initElements(driver,this);
    }

}

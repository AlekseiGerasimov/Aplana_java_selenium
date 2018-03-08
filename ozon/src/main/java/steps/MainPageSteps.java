package steps;

import io.qameta.allure.Step;
import pages.MainPage;


public class MainPageSteps {
    @Step("Выбираем категрию {0}")
    public void clickToCategory(String categoryName){
        new MainPage().clickToCategory(categoryName);
    }
}

package steps;

import ru.yandex.qatools.allure.annotations.Step;
import pages.MainPage;


public class MainPageSteps {
    @Step("Выбираем категрию {0}")
    public void clickToCategory(String categoryName){
        new MainPage().clickToCategory(categoryName);
    }
}

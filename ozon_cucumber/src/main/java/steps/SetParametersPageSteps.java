package steps;


import pages.SetParametersPage;
import ru.yandex.qatools.allure.annotations.Step;

public class SetParametersPageSteps {
    @Step("Выбираем всех нужных производителей")
    public void setMakers(String... makers){
        new SetParametersPage().setMakers(makers);
    }
    @Step("Устанавливаем минимальную цену равную {0}")
    public void setPrice(String price){
        new SetParametersPage().setPrice(price);
    }
    @Step("Запоминаем название и цену первого товара и перемещаем его в корзину")
    public void clickToBasket(){
        new SetParametersPage().moveToBasket();
    }

    @Step("Переходим в корзину")
    public void moveToBasket(){
        new SetParametersPage().clickToBasket();
    }
}

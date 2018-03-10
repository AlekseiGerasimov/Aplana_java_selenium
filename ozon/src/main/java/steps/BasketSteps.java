package steps;

import io.qameta.allure.Step;
import pages.BasketPage;

public class BasketSteps {
    @Step("Проверяем, что в корзине есть выбранный нами товар")
    public void checkBasket(){
        new BasketPage().checkBasket();
    }

    @Step("Очищаем корзину")
    public void clearBasket(){
        new BasketPage().clearBasket();
    }

    @Step("Проверяем, что корзина пуста")
    public void checkContentBasket(){
        new BasketPage().checkContentBasket();
    }

}

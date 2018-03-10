package steps;

import io.qameta.allure.Step;
import pages.*;

public class BasketSteps {
    @Step("Переходим в яндекс маркет")
    public MarketPage clickToMarket(){
        return new BaseYandexPage().clickToMarket();
    }

    @Step("Выбираем категорию {0}")
    public CategoryPage selectCategory(String category){
        return new MarketPage().selectCategory(category);
    }

    @Step("Выбираем продукт {0}")
    public ProductPage productSearch(String product){
        return new CategoryPage().productSearch(product);
    }

    @Step("Выбираем продукт {0}")
    public ProductPage setMinPrice(String price){
        return new ProductPage().setMinPrice(price);
    }

    @Step("Выбираем продукт производителей")
    public ProductPage setModels(String... makers){
        return new ProductPage().setModels(makers);
    }

    @Step("Нажимаем кнопку применить")
    public ProductPage clickButtonToBeginSearch(){
        return new ProductPage().clickButtonToBeginSearch();
    }

    @Step("Устаналиваем количество элементов на странице")
    public ProductPage setNumberOfElementsEquals12(){
        return new ProductPage().setNumberOfElementsEquals12();
    }

    @Step("Проверяем, что элементов на странице {0}")
    public ProductPage checkNumbersOfElements(String number){
        return new ProductPage().checkNumbersOfElements(number);
    }

    @Step("Запоминаем элемент под номером {0}, вводим элемент в строку поиска и делаем провевку")
    public void selectNumberOfElementAndFillTheFieldOfSearch(String number){
        new ProductPage().selectNumberOfElementAndFillTheFieldOfSearch(number).asserted();
    }




}

// 12. В поисковую строку ввести запомненное значение.  13. Найти и проверить, что наименование товара соответствует запомненному значению.
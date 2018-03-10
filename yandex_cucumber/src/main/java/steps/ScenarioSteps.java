package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BaseYandexPage;


public class ScenarioSteps {



    @When("^произведен переход на яндекс маркет$")
    public void clickToMarket(){
        new BaseYandexPage().clickToMarket();
    }

    @When("^выбран пункт меню – (.*)$")
    public void selectCategory(String category){
        new BasketSteps().selectCategory("Электроника");
    }

    @When("^выбран раздел – (.*)$")
    public void productSearch(String product){
        new BasketSteps().productSearch(product);
    }

    @When("^заполнена цена от – (.*)$")
    public void setMinPrice(String price){
        new BasketSteps().setMinPrice(price);
    }

    @When("^выбран производитель – Samsung и LG$")
    public void setModelsTele(){
        new BasketSteps().setModels("LG", "Samsung");
    }

    @When("^выбран производитель – Beats$")
    public void setModelsPhone(){
        new BasketSteps().setModels("Beats");
    }

    @When("^нажата кнопка применить$")
    public void clickButtonToBeginSearch(){
        new BasketSteps().clickButtonToBeginSearch();
    }

    @When("^проверено, что элементов 12$")
    public void checkElements(){
        new BasketSteps().setNumberOfElementsEquals12();
        new BasketSteps().checkNumbersOfElements("12");
    }

    @Then("^запоминается первый элемент в списке и проверяется значение$")
    public void save(){
        new BasketSteps().selectNumberOfElementAndFillTheFieldOfSearch("1");
    }

}

package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class ScenarioSteps {

    MainPageSteps mainpage = new MainPageSteps();
    CategoryPageSteps catpage = new CategoryPageSteps();
    SetParametersPageSteps parpage = new SetParametersPageSteps();
    BasketSteps basketpage = new BasketSteps();


    @When("^выбран пункт меню – Электроника$")
    public void выбран_пункт_меню_Электроника(){
        mainpage.clickToCategory("Электроника");
    }

    @When("^выбрана категория – (.*)")
    public void clickToTypeCategoryPhone(String category){
        catpage.clickToTypeCategory(category);
    }

    @When("^выбран производитель – Apple$")
    public void setMakers(){
        parpage.setMakers("Apple");
    }

    @When("^выбран производитель – Nikon, Canon$")
    public void setMakersPhoto(){
        parpage.setMakers("Nikon","Canon");
    }

    @When("^заполнена цена от – (.*)")
    public void setPrice(String price){
        parpage.setPrice(price);
    }

    @Then("^появляются товары и добавляется первый товар в корзину, причем запоминается цена$")
    public void clickToBasket(){
        parpage.clickToBasket();
    }

    @When("^произведен переход в корзину$")
    public void moveToBasket(){
        parpage.moveToBasket();
    }

    @When("^проверено, что в корзине есть добавленный товар$")
    public void checkBasket(){
        basketpage.checkBasket();
    }

    @Then("^нажимается на удалить всё$")
    public void clearBaskett(){
        basketpage.clearBasket();
    }

    @Then("^корзина пуста.$")
    public void checkContentBasket(){
        basketpage.checkContentBasket();
    }


}

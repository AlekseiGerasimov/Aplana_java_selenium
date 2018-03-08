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

    @When("^выбрана категория – Телефоны$")
    public void clickToTypeCategoryPhone(){
        catpage.clickToTypeCategory("Телефоны");
    }

    @When("^выбрана категория – Зеркальные фотоаппараты$")
    public void clickToTypeCategoryPhoto(){
        catpage.clickToTypeCategory("Зеркальные фотоаппараты");
    }

    @When("^выбран производитель – Apple$")
    public void setMakers(){
        parpage.setMakers("Apple");
    }

    @When("^выбран производитель – Nikon, Canon$")
    public void setMakersPhoto(){
        parpage.setMakers("Nikon","Canon");
    }

    @When("^заполнена цена от – 50000$")
    public void setPrice(){
        parpage.setPrice("50000");
    }

    @When("^заполнена цена от – 80000$")
    public void setPricePhoto(){
        parpage.setPrice("80000");
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

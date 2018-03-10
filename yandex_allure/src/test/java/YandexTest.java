import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CategoryPage;
import steps.*;

public class YandexTest extends BaseSteps{


    @DisplayName("Тест по телевизорам")
    @Test
    public void test_tv(){
        BasketSteps steps = new BasketSteps();
//        steps.clickToMarket().selectCategory("Электроника").productSearch("Телевизоры").setMinPrice("20000").
//                setModels("LG", "Samsung").clickButtonToBeginSearch().setNumberOfElementsEquals12().checkNumbersOfElements("12").selectNumberOfElementAndFillTheFieldOfSearch("1").asserted();
          steps.clickToMarket();
          steps.selectCategory("Электроника");
          steps.productSearch("Телевизоры");
          steps.setMinPrice("20000");
          steps.setModels("LG", "Samsung");
          steps.clickButtonToBeginSearch();
          steps.setNumberOfElementsEquals12();
          steps.checkNumbersOfElements("12");
          steps.selectNumberOfElementAndFillTheFieldOfSearch("1");

    }

    @DisplayName("Тест по телефонам")
    @Test
    public void test_phone(){
        BasketSteps steps = new BasketSteps();
//        steps.clickToMarket().selectCategory("Электроника").productSearch("Наушники и Bluetooth-гарнитуры").setMinPrice("5000").
//                setModels("Beats").clickButtonToBeginSearch().setNumberOfElementsEquals12().checkNumbersOfElements("12").selectNumberOfElementAndFillTheFieldOfSearch("1").asserted();
        steps.clickToMarket();
        steps.selectCategory("Электроника");
        steps.productSearch("Наушники и Bluetooth-гарнитуры");
        steps.setMinPrice("5000");
        steps.setModels("Beats");
        steps.clickButtonToBeginSearch();
        steps.checkNumbersOfElements("12");
        steps.selectNumberOfElementAndFillTheFieldOfSearch("1");
    }


}

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CategoryPage;
import steps.*;

public class OzonTest extends BaseSteps{

    @DisplayName("Тест по телефонам")
    @Test
    public void phoneTest(){
        MainPageSteps mainpage = new MainPageSteps();
        CategoryPageSteps catpage = new CategoryPageSteps();
        SetParametersPageSteps parpage = new SetParametersPageSteps();
        BasketSteps basketpage = new BasketSteps();
        mainpage.clickToCategory("Электроника");
        catpage.clickToTypeCategory("Телефоны");
        parpage.setMakers("Apple");
        parpage.setPrice("50000");
        parpage.clickToBasket();
        parpage.moveToBasket();
        basketpage.checkBasket();
        basketpage.clearBasket();
        basketpage.checkContentBasket();
    }

    @DisplayName("Тест по фотоаппаратам")
    @Test
    public void photoTest(){
        MainPageSteps mainpage = new MainPageSteps();
        CategoryPageSteps catpage = new CategoryPageSteps();
        SetParametersPageSteps parpage = new SetParametersPageSteps();
        BasketSteps basketpage = new BasketSteps();
        mainpage.clickToCategory("Электроника");
        catpage.clickToTypeCategory("Зеркальные фотоаппараты");
        parpage.setMakers("Nikon");
        parpage.setPrice("80000");
        parpage.clickToBasket();
        parpage.moveToBasket();
        basketpage.checkBasket();
        basketpage.clearBasket();
        basketpage.checkContentBasket();
    }
}

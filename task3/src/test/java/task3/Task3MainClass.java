package task3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Task3MainClass {
    YandexPage page;

    @Before
    public void setUp(){
        page = new YandexPage("https://www.yandex.ru/");
    }

    @Test
    public void test_tv(){
        page.findAndClick("//a[@data-id='market']");
        page.chooceCategory("//a[contains(text(),'Электроника')]");
        page.findAndClick("//a[@href='/catalog/59601/list?hid=90639&track=fr_ctlg']");
        page.findAndSetValue("//input[@name='glf-pricefrom-var']","20000");
        page.findAndClick("//label[@for='glf-7893318-153061']");
        page.findAndClick("//label[@for='glf-7893318-153074']");
        page.findAndClick("//button[@class='button button_action_n-filter-apply button_size_s button_pseudo_yes button_theme_pseudo i-bem button_js_inited']");
        page.assertNumberOfElements("12","//div[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/div[@data-id]");
        page.findFirstElementAndCheck("//div[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/div[@data-id][1]//a[@title='LG 43UJ639V']");
        page.asserted("LG 43UJ639V","//h1[@class='title title_size_28 title_bold_yes']");
    }

    @Test
    public void test_headset(){
        page.findAndClick("//a[@data-id='market']");
        page.chooceCategory("//a[contains(text(),'Электроника')]");
        page.findAndClick("//a[@href='/catalog/56179/list?hid=90555&track=fr_ctlg']");
        page.findAndSetValue("//input[@name='glf-pricefrom-var']","5000");
        page.findAndClick("//label[@for='glf-7893318-8455647']");
        page.findAndClick("//button[@class='button button_action_n-filter-apply button_size_s button_pseudo_yes button_theme_pseudo i-bem button_js_inited']");
        page.assertNumberOfElements("12","//div[@class='n-snippet-list n-snippet-list_type_grid snippet-list_size_3 metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/div[@data-id]");
        page.findFirstElementAndCheck("//div[@class='n-snippet-list n-snippet-list_type_grid snippet-list_size_3 metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/div[@data-id][1]//a[@title='Наушники Apple AirPods']");
        page.asserted("Наушники Apple AirPods","//img[@src='//avatars.mds.yandex.net/get-mpic/175985/img_id6526000481435545741/6hq']");
    }


    @After
    public void tearDown() {
//        page.quit();
    }
}

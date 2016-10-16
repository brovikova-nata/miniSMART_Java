package test.search;

import test.search.forms.FilterForm;
import test.search.forms.FirstForm;
import webdriver.BaseRealTest;


public class Test extends BaseRealTest {
    @Override
    public void runRealTest() throws Throwable {

        logger.step(1);
        FirstForm sf = new FirstForm();
        sf.assertLogo();

        logger.step(2);
        sf.ClickCatalog();

        logger.step(3);
        sf.ClickTV();

        //logger.step(4);
        //sf.assertHeader();

        logger.step(5);
        FilterForm ff = new FilterForm();
        ff.ClickCheckboxproducer(producer);

        logger.step(6);
        ff.SendPricefrom(pricefrom);

        logger.step(7);
        ff.SendPriceto(priceto);

        logger.step(8);
        ff.SendPriceYear(priceyear);

        logger.step(9);
        ff.Selectdiagfrom(valuediagfrom);

        logger.step(10);
        ff.Selectdiagto(valuediagto);


        logger.step(11);
        ff.checkParameters_the_first_page_title(producer);

        logger.step(12);
        ff.checkParameters_the_first_page_price(priceto);

        logger.step(13);
        ff.checkParameters_the_second_page(priceyear,valuediagto,valuediagfrom);

    }


}
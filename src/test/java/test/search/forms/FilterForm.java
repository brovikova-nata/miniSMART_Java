package test.search.forms;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.BaseForm;
import webdriver.elements.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by milovanova-np on 15.10.2016.
 */
public class FilterForm extends BaseForm {


    private TextBox txbPricefrom = new TextBox(By.xpath("//input[contains(@class, 'schema-filter__number-input_price')][contains(@data-bind, 'placeholder.from')]"), "button price from");
    private TextBox txbPriceto = new TextBox(By.xpath("//input[contains(@class, 'schema-filter__number-input_price')][contains(@data-bind, 'placeholder.to')]"), "button price to");
    private TextBox txbYear = new TextBox(By.xpath("//div[@id='schema-filter']/div[1]/div[3]/div[3]/div/div[1]/input"), "button price to");

    public Select btnSelectfrom = new Select(By.xpath("//div[@class='schema-filter-control schema-filter-control_select'][1]/select"), "select from");
    public Select btnSelectto= new Select(By.xpath("//div[@class='schema-filter-control schema-filter-control_select'][2]/select"), "select to");


    public ArrayList url;
    String[] url1;

    public FilterForm() {
        super(By.id("fast-search"), "Onliner");
    }


    public void ClickCheckboxproducer(String producer) {
        browser.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        CheckBox chProducer = new CheckBox(By.xpath("//ul[@class='schema-filter__list']//input[@type='checkbox'][@value='" + producer + "']/.."), "Checkbox Producer");
        chProducer.click();
        browser.waitForPageToLoad();
    }

    public void SendPricefrom(String pricefrom) {
        txbPricefrom.sendKeys(pricefrom);
        browser.waitForPageToLoad();
    }

    public void SendPriceto(String priceto) {
        txbPriceto.sendKeys(priceto);
        browser.waitForPageToLoad();
    }

    public void SendPriceYear(String priceyear) {
        txbYear.sendKeys(priceyear);
        browser.waitForPageToLoad();
        btnSelectfrom.sendKeys("15.6");
        btnSelectfrom.click();
        browser.waitForPageToLoad();
    }

    public void Selectdiagfrom(String valuediagfrom) {
        btnSelectfrom.sendKeys(valuediagfrom);
        btnSelectfrom.click();
        browser.waitForPageToLoad();
    }


    public void Selectdiagto(String valuediagto) {
        btnSelectto.sendKeys(valuediagto);
        btnSelectto.click();
        browser.waitForPageToLoad();
    }

    public void assertHeader() {
        Text textHeader = new Text(By.xpath("//div[@id='container']//h1[contains(., 'Телевизоры')]"), "Text Header TV");
        assert (textHeader.isPresent());
    }

    public void checkParameters_the_first_page_title(String producer) throws Throwable {
        TextBox filter = new TextBox(By.xpath(".//*[@id='schema-tags']/div[4]/span"), "filter appear");
        filter.waitForIsElementPresent();
        browser.getDriver().manage().timeouts().setScriptTimeout(10000, TimeUnit.SECONDS);
        List<WebElement> list_title = browser.getDriver().findElements(By.xpath("//div[@class='schema-product__title']/a"));
        url1 = new String[list_title.size()];
        for (int i = 0; i < list_title.size(); i++) {
            if (!(list_title.get(i).getText().toLowerCase().contains(producer))) {
                throw new Exception("List contains others producer, than" + producer);
            }else url1[i] = list_title.get(i).getAttribute("href");
        }
    }

    public void checkParameters_the_first_page_price(String priceto ) throws Throwable{
        List<WebElement> list_price = browser.getDriver().findElements(By.xpath("//div[@class='schema-product__price']//span[contains(@data-bind, 'BYN')]"));
        for (int i = 0; i < list_price.size(); i++) {
            if (!((Float.parseFloat(list_price.get(i).getText().replaceAll("р.","").replaceAll(",","."))) <= (Float.parseFloat(priceto)))) {
                throw new Exception("List contains others price, than " + priceto);
            }
        }
    }


    public void checkParameters_the_second_page(String priceyear, String valuediagto, String valuediagfrom ) throws Throwable {
        for (int i = 0; i < url1.length; i++) {
            browser.navigate(url1[i]);
            browser.waitForPageToLoad();
            Text checkyear = new Text(By.xpath("//div[@class='product-specs__main-group product-specs__group--full js-specs-full is-visible']//span[@class='value__text'][contains(., 'г.')]"));
            Text checkdiag= new Text (By.xpath("//div[@class='product-specs__main-group product-specs__group--full js-specs-full is-visible']//span[@class='value__text'][contains(., '\"')]"));
            if (!((Float.parseFloat(checkyear.getText().replaceAll("г.","")) >=  Float.parseFloat(priceyear)) && ((Float.parseFloat(checkdiag.getText().replaceAll("\"",""))<= Float.parseFloat(valuediagto)) || (Float.parseFloat(checkdiag.getText().replaceAll("\"",""))>= Float.parseFloat(valuediagfrom))))) {
                throw new Exception("List contains others year or diagonal, than " + priceyear +valuediagfrom +valuediagto);
            }

        }

        }
}

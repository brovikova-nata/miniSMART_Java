package test.search.forms;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.BaseForm;
import test.search.Test;
import webdriver.Browser;
import webdriver.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstForm extends BaseForm  {


    private Label lbLogo = new Label(By.xpath("//div[@id='container']//a/img"), "logo");
    private Button btnSubmitCatalog = new Button(By.xpath(" //div[@id='container']//a/span[contains(., 'Каталог')]"), "Catalog");
    private Button btnSubmitTV = new Button(By.xpath(" //div[@class='catalog-bar']//a[contains(., 'Телевизоры')]"), "TV");


    public FirstForm() {
        super(By.id("fast-search"), "Onliner");
    }



    public void assertLogo() {
        assert (lbLogo.isPresent());
    }


    public void ClickCatalog() {
        btnSubmitCatalog.click();
        browser.waitForPageToLoad();

    }

    public void ClickTV() {
        btnSubmitTV.click();
        browser.waitForPageToLoad();

    }



}
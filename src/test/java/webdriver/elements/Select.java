package webdriver.elements;

import org.openqa.selenium.By;

public class Select extends BaseElement {

    public Select(final By locator, final String name) {
        super(locator, name);
    }

    public Select(String string, String name) {
        super(string, name);
    }


    public Select(By locator) {
        super(locator);
    }



    protected String getElementType() {
        return getLoc("loc.label");
    }

}
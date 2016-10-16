package webdriver.elements;

import org.openqa.selenium.By;

public class Text extends BaseElement {

    public Text(final By locator, final String name) {
        super(locator, name);
    }

    public Text(String string, String name) {
        super(string, name);
    }



    public Text(By locator) {
        super(locator);
    }

    protected String getElementType() {
        return getLoc("loc.text");
    }

}
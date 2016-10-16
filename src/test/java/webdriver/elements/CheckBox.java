package webdriver.elements;

import org.openqa.selenium.By;

/**
 * Created by milovanova-np on 11.10.2016.
 */
public class CheckBox extends BaseElement{

    public CheckBox(final By locator, final String name) {
        super(locator, name);
    }

    public CheckBox(String string, String name) {
        super(string, name);
    }

    public CheckBox(By locator) {
        super(locator);
    }

    public void check() {
        //if(!this.element.isSelected()) {
            this.element.click();
        //}

    }

    public void uncheck() {
        if(this.element.isSelected()) {
            this.element.click();
        }

    }


    protected String getElementType() {
        return getLoc("loc.label");
    }


}

package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicClass {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasicClass(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
}

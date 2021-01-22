package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailIndexPage extends BasicClass{


    protected MailIndexPage(WebDriver driver) {
        super(driver);
    }

    public MailIndexPage enterLogin() {
        wait
                .until(ExpectedConditions.elementToBeClickable(
                        By.name("login")
                )).sendKeys(System.getProperty("login"),Keys.RETURN);
        return this;
    }

    public MailIndexPage enterPassword() {
       wait
                .until(ExpectedConditions.elementToBeClickable(
                        By.name("password")
                )).sendKeys(System.getProperty("password"),Keys.RETURN);
        return this;
    }

    public String getUserName() {
        return wait
                .until(ExpectedConditions.elementToBeClickable(
                        By.id("PH_user-email")
                )).getText();
    }

    public void selectFolder(String folderName) {
        wait
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(String.format("//a[contains(@title,'%s')]", folderName))
                )).click();
    }


}

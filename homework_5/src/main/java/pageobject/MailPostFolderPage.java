package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPostFolderPage {
    private WebDriver driver;

    public MailPostFolderPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getResiverName() {
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[@class=\"ll-crpt\"]")
                )).getText();
    }
    public String getLetterTheme() {
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[@class=\"ll-sj__normal\"]")
                )).getText();
    }
    public String getLetterBody() {
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[@class=\"ll-sp__normal\"]")
                )).getText();
    }
    public WebElement getFolderField() {
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".dataset__empty")
                ));
    }

    public WebElement getLetter() {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector(".llc__item.llc__item_correspondent")));
    }

    public void deleteLetter() {
        getLetter().click();
        new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(
                            By.cssSelector("[title=\"Удалить\"]")
                    )).click();
    }
}

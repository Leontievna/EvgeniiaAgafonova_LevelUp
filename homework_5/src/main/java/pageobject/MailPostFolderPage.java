package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPostFolderPage extends BasicClass{


    protected MailPostFolderPage(WebDriver driver) {
        super(driver);
    }

    public String getResiverName() {
        return wait
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[@class=\"ll-crpt\"]")
                )).getText();
    }
    public String getLetterTheme() {
        return wait
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[@class=\"ll-sj__normal\"]")
                )).getText();
    }
    public String getLetterBody() {
        return wait
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[@class=\"ll-sp__normal\"]")
                )).getText();
    }
    public WebElement getFolderField() {
        return wait
                .until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".dataset__empty")
                ));
    }

    public WebElement getLetter() {
        return wait
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector(".llc__item.llc__item_correspondent")));
    }

    public void deleteLetter() {
        getLetter().click();
        wait
                    .until(ExpectedConditions.elementToBeClickable(
                            By.cssSelector("[title=\"Удалить\"]")
                    )).click();
    }
}

package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailLetterPage {
    private WebDriver driver;

    public MailLetterPage(WebDriver driver) {
            this.driver = driver;
        }

    public MailLetterPage createNewLetter(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.partialLinkText("Написать письмо")
                )).click();
        return this;
    }

    public MailLetterPage enterResiverName(String resiver) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".head_container--3W05z .container--H9L5q.size_s--3_M-_")
                )).sendKeys(resiver);
        return this;
    }

    public MailLetterPage enterThemeLetter() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".subject__container--HWnat .container--H9L5q.size_s--3_M-_")
                )).sendKeys("test");
        return this;
    }

    public MailLetterPage enterBodyLetter() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@role=\"textbox\"]//div")
                )).sendKeys("test");
        return this;
    }

    public MailLetterPage save() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[@title='Сохранить']//span[@class=\"button2__txt\"]")
                )).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button[title=\"Закрыть\"]")
                )).click();
        return this;
    }

    public MailLetterPage send() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='Отправить']")
                )).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[@class=\"button2 button2_has-ico button2_close button2_pure button2_clean button2_short button2_hover-support\"]")
                )).click();
        return this;
    }


}

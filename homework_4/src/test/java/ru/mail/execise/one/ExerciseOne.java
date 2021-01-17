package ru.mail.execise.one;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * ExerciseOne - класс выполняет вход в аккаунт,
 * создание черновика письма, его отправку и выход из аккаунта.
 *
 * @version 1.03 14 Jan 2021
 * @author Агафонова Евгения
 */
public class ExerciseOne {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
    }

    @AfterClass
    public void singOut(){
        WebElement exitAccountButton = driver.findElement(By.cssSelector("[xname=\"clb14767676\"]"));
        exitAccountButton.click();
        driver.quit();
    }

    @Test
    public void sendDraft() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement loginInput = driver.findElement(By.name("login"));
        loginInput.sendKeys("test_2020_levelup");

        WebElement accountInputButton = driver.findElement(By.cssSelector("button.button.svelte-no02r"));
        accountInputButton.click();

        WebElement passInput = driver.findElement(By.name("password"));
        passInput.sendKeys("levelup2020");

        WebElement passInputButton = driver.findElement(By.cssSelector("button.second-button.svelte-no02r"));
        passInputButton.click();

        assertEquals(driver.getCurrentUrl(),
                "https://mail.ru/");

        WebElement userName = wait
                .until(ExpectedConditions.elementToBeClickable(By.id("PH_user-email")));
        assertEquals(userName.getText(),"test_2020_levelup@mail.ru");

        WebElement folderDraftLetter = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Черновики")));
        folderDraftLetter.click();

        WebElement createLetter = driver.findElement(By.partialLinkText("Написать письмо"));
        createLetter.click();

        WebElement receiverName = wait
                .until(ExpectedConditions
                        .elementToBeClickable(By
                                .cssSelector(".head_container--3W05z .container--H9L5q.size_s--3_M-_")));
        receiverName.sendKeys("jane-utest@ya.ru");
        receiverName.sendKeys(Keys.RETURN);

        WebElement themeLetter = wait
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector(".subject__container--HWnat .container--H9L5q.size_s--3_M-_")));
        themeLetter.sendKeys("test");

        WebElement bodyLetter = driver.findElement(By.xpath("//div[@role=\"textbox\"]//div"));
        bodyLetter.sendKeys("test");

        WebElement buttonSaveLetter = driver.findElement(By
                .xpath("//span[@title='Сохранить']//span[@class=\"button2__txt\"]"));
        buttonSaveLetter.click();

        WebElement closePopupNewLetter = driver.findElement(By
                .cssSelector(("button[title=\"Закрыть\"]")));
        closePopupNewLetter.click();

        WebElement senderIcon = driver
                .findElement(By.className("stop-animate"));
        senderIcon.isDisplayed();

        WebElement receiverNameCheck = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"ll-crpt\"]")));
        assertEquals(receiverNameCheck.getAttribute("title"), "jane-utest@ya.ru");

        WebElement themeDraftLetter = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"ll-sj__normal\"]")));
        assertEquals(themeDraftLetter.getText(), "test");

        WebElement bodyDraftLetter = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"ll-sp__normal\"]")));
        assertEquals(bodyDraftLetter.getText(), "test -- Evgeniia Test");

        WebElement lastDraft = driver.findElement(By.cssSelector(".ll-crpt"));
        lastDraft.click();

        WebElement buttonSendLetter = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Отправить']")));
        buttonSendLetter.click();

        WebElement closePopupLetterSended = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//span[@class=\"button2 button2_has-ico " +
                                "button2_close button2_pure button2_clean button2_short button2_hover-support\"]")));
        closePopupLetterSended.click();

        WebElement messageEmptyFolder = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector(".dataset__empty")));
        assertTrue(messageEmptyFolder.isDisplayed());

        WebElement folderSendedLetters = wait
                .until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Отправленные")));
        folderSendedLetters.click();

        WebElement receiverNameSendedLetter = wait
                .until(ExpectedConditions.elementToBeClickable(By.className("ll-crpt")));
        assertEquals(receiverNameSendedLetter.getText(), "jane-utest@ya.ru");

        WebElement themeSentLetter = driver.findElement(By.xpath("//span[@class=\"ll-sj__normal\"]"));
        assertEquals(themeSentLetter.getText(), "test");

        WebElement bodySentLetter = driver.findElement(By.xpath("//span[@class=\"ll-sp__normal\"]"));
        assertEquals(bodySentLetter.getText(), "test -- Evgeniia Test");
    }
}
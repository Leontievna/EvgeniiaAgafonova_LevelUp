package ru.mail.execise.one;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Sleep;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * ExerciseOne - класс выполняет вход в аккаунт,
 * создание черновика письма, его отправку и выход из аккаунта.
 *
 * @version 1.00 11 Jan 2021
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
    public void signInToAccount() {
        WebElement loginInput = driver.findElement(By.xpath("//*[@name='login']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", loginInput);
        loginInput.sendKeys("test_2020_levelup");

        WebElement accountInputButton = driver.findElement(By.cssSelector("button.button.svelte-no02r"));
        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
        executor2.executeScript("arguments[0].click();", accountInputButton);
        accountInputButton.click();

        Sleep.sleep(1500);

        WebElement passInput = driver.findElement(By.xpath("//*[@name='password']"));
        JavascriptExecutor executor3 = (JavascriptExecutor)driver;
        executor3.executeScript("arguments[0].click();", passInput);
        passInput.sendKeys("levelup2020");

        WebElement passInputButton = driver.findElement(By.cssSelector("button.second-button.svelte-no02r"));
        JavascriptExecutor executor4 = (JavascriptExecutor)driver;
        executor4.executeScript("arguments[0].click();", passInputButton);
        passInputButton.click();

        Sleep.sleep(3000);

        assertEquals(driver.getCurrentUrl(),
                "https://e.mail.ru/messages/inbox/?back=1&afterReload=1");

        WebElement userName = driver.findElement(By.id("PH_user-email"));
        assertEquals(userName.getText(),"test_2020_levelup@mail.ru");
    }
    @Test(dependsOnMethods="signInToAccount")
    public void createDraftLetter() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement folderDraftLetter = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Черновики")));
        folderDraftLetter.click();

        WebElement createLetter = driver.findElement(By.partialLinkText("Написать письмо"));
        createLetter.click();

        Sleep.sleep(1500);

        WebElement receiverName =driver.findElement(By.xpath("//input[@tabindex='100']"));
        receiverName.sendKeys("jane-utest@ya.ru");
        receiverName.sendKeys(Keys.RETURN);

        WebElement themeLetter = wait
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//input[@tabindex='400']")));
        themeLetter.sendKeys("test");

        WebElement bodyLetter = driver.findElement(By.xpath("//div[@role=\"textbox\"]//div"));
        bodyLetter.sendKeys("test");

        WebElement buttonSaveLetter = driver.findElement(By
                .xpath("//span[@title='Сохранить']//span[@class=\"button2__txt\"]"));
        buttonSaveLetter.click();

        WebElement closePopupNewLetter = driver.findElement(By
                .cssSelector(("button[title=\"Закрыть\"]")));
        closePopupNewLetter.click();

        Sleep.sleep(1200);

        assertEquals(folderDraftLetter.getAttribute("title"), "Черновики, 1 письмо");

        WebElement receiverNameCheck = driver.findElement(By.xpath("//span[@class=\"ll-crpt\"]"));
        assertEquals(receiverNameCheck.getAttribute("title"), "jane-utest@ya.ru");

        WebElement themeDraftLetter = driver.findElement(By.xpath("//span[@class=\"ll-sj__normal\"]"));
        assertEquals(themeDraftLetter.getText(), "test");

        WebElement bodyDraftLetter = driver.findElement(By.xpath("//span[@class=\"ll-sp__normal\"]"));
        assertEquals(bodyDraftLetter.getText(), "test -- Evgeniia Test");
    }

    @Test(dependsOnMethods="createDraftLetter")
    public void sendDraftLetter() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement lastDraft = driver.findElement(By.cssSelector(".ll-crpt"));
        lastDraft.click();

        Sleep.sleep(1500);

        WebElement buttonSendLetter = driver.findElement(By.xpath("//span[text()='Отправить']"));
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

        WebElement folderSendedLetters = driver.findElement(By.partialLinkText("Отправленные"));
        folderSendedLetters.click();

        WebElement receiverName = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("ll-crpt")));
        assertEquals(receiverName.getText(), "jane-utest@ya.ru");

        WebElement themeSentLetter = driver.findElement(By.xpath("//span[@class=\"ll-sj__normal\"]"));
        assertEquals(themeSentLetter.getText(), "test");

        WebElement bodySentLetter = driver.findElement(By.xpath("//span[@class=\"ll-sp__normal\"]"));
        assertEquals(bodySentLetter.getText(), "test -- Evgeniia Test");
    }
}
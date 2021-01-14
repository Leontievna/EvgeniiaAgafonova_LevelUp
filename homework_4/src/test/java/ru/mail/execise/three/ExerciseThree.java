package ru.mail.execise.three;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * ExerciseThree - класс выполняет вход в аккаунт,
 * создание письма, его отправку себе и выход из аккаунта.
 *
 * @version 1.03 14 Jan 2021
 * @author Агафонова Евгения
 */
public class ExerciseThree {

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
    public void sendLetterToMyself() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement loginInput = driver.findElement(By.xpath("//*[@name='login']"));
        loginInput.sendKeys("test_2020_levelup");

        WebElement accountInputButton = driver.findElement(By.cssSelector("button.button.svelte-no02r"));
        accountInputButton.click();

        WebElement passInput = driver.findElement(By.xpath("//*[@name='password']"));
        passInput.sendKeys("levelup2020");

        WebElement passInputButton = driver.findElement(By.cssSelector("button.second-button.svelte-no02r"));
        passInputButton.click();

        assertEquals(driver.getCurrentUrl(),
                "https://mail.ru/");

        WebElement userName = wait
                .until(ExpectedConditions.elementToBeClickable(By.id("PH_user-email")));
        assertEquals(userName.getText(),"test_2020_levelup@mail.ru");

        WebElement createLetter = wait
                .until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Написать письмо")));
        createLetter.click();

        WebElement receiverName = wait
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("(//*[@class=\"container--H9L5q size_s--3_M-_\"])[1]")));
        receiverName.sendKeys("test_2020_levelup@mail.ru");
        receiverName.sendKeys(Keys.RETURN);

        WebElement themeLetter = wait
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("(//*[@class=\"container--H9L5q size_s--3_M-_\"])[2]")));
        themeLetter.sendKeys("test");

        WebElement bodyLetter = driver.findElement(By.xpath("//div[@role=\"textbox\"]//div"));
        bodyLetter.sendKeys("test");

        WebElement buttonSendLetter = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Отправить']")));
        buttonSendLetter.click();

        WebElement closePopupLetterSended = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//span[@class=\"button2 button2_has-ico " +
                                "button2_close button2_pure button2_clean button2_short button2_hover-support\"]")));
        closePopupLetterSended.click();

        WebElement folderSendedLetters = driver.findElement(By.partialLinkText("Входящие"));
        folderSendedLetters.click();

        WebElement folderLettersToMyself = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Письма себе")));
        folderLettersToMyself.click();

        assertTrue(wait.until(ExpectedConditions
                .textToBe(By.xpath("(//div[@class=\"llc__content\"]//span[@class=\"ll-crpt\"])[1]"),
                        "Evgeniia Test")));

        WebElement themeDraftLetter = wait
                .until(ExpectedConditions.elementToBeClickable(By.className("ll-sj__normal")));
        assertEquals(themeDraftLetter.getText(), "test");

        WebElement bodyDraftLetter = wait
                .until(ExpectedConditions.elementToBeClickable(By.className("ll-sp__normal")));
        assertEquals(bodyDraftLetter.getText(), "test -- Evgeniia Test");
    }
}



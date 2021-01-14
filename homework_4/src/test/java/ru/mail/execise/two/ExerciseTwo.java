package ru.mail.execise.two;

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

/**
 * ExerciseTwo - класс выполняет вход в аккаунт,
 * создание письма, его отправку и выход из аккаунта.
 *
 * @version 1.02 14 Jan 2021
 * @author Агафонова Евгения
 */
public class ExerciseTwo {

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
    public void sendLetter() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement loginInput = driver.findElement(By.name("login"));
        loginInput.sendKeys("test_2020_levelup");

        WebElement accountInputButton = driver.findElement(By.cssSelector("button.button.svelte-no02r"));
        accountInputButton.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement passInput = driver.findElement(By.name("password"));
        passInput.sendKeys("levelup2020");

        WebElement passInputButton = driver.findElement(By.cssSelector("button.second-button.svelte-no02r"));
        passInputButton.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertEquals(driver.getCurrentUrl(),
                "https://mail.ru/");

        WebElement userName = wait
                .until(ExpectedConditions.elementToBeClickable(By.id("PH_user-email")));
        assertEquals(userName.getText(),"test_2020_levelup@mail.ru");

        WebElement createLetter = wait
                .until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Написать письмо")));
        createLetter.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement receiverName = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class=\"container--H9L5q size_s--3_M-_\"])[1]")));
        receiverName.sendKeys("test_2020_levelup@mail.ru");
        receiverName.sendKeys(Keys.RETURN);

        WebElement themeLetter = wait
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("(//*[@class=\"container--H9L5q size_s--3_M-_\"])[2]")));
        themeLetter.sendKeys("test");

        WebElement bodyLetter = driver.findElement(By.xpath("//div[@role=\"textbox\"]//div"));
        bodyLetter.sendKeys("test");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement buttonSendLetter = driver.findElement(By.xpath("//span[text()='Отправить']"));
        buttonSendLetter.click();

        WebElement closePopupLetterSended = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//span[@class=\"button2 button2_has-ico " +
                                "button2_close button2_pure button2_clean button2_short button2_hover-support\"]")));
        closePopupLetterSended.click();

        WebElement folderSendedLetters = driver.findElement(By.partialLinkText("Отправленные"));
        folderSendedLetters.click();

        WebElement receiverNameCheck = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ll-crpt")));
        assertEquals(receiverNameCheck.getText(), "test_2020_levelup@mail.ru");

        WebElement themeDraftLetter = driver.findElement(By.cssSelector(".ll-sj__normal"));
        assertEquals(themeDraftLetter.getText(), "Self: test");

        WebElement bodyDraftLetter = driver.findElement(By.cssSelector(".ll-sp__normal"));
        assertEquals(bodyDraftLetter.getText(), "test -- Evgeniia Test");

        WebElement folderSendedTestLetters = driver.findElement(By.partialLinkText("Тест"));
        folderSendedTestLetters.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        assertEquals(receiverNameCheck.getAttribute("title"), "test_2020_levelup@mail.ru");
        assertEquals(themeDraftLetter.getText(), "Self: test");
        assertEquals(bodyDraftLetter.getText(), "test -- Evgeniia Test");
    }
}



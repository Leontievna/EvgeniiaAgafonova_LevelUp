package ru.mail.execise.three;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Sleep;

import static org.testng.Assert.assertEquals;

/**
 * ExerciseThree - класс выполняет вход в аккаунт,
 * создание письма, его отправку себе и выход из аккаунта.
 *
 * @version 1.00 11 Jan 2021
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
                "https://e.mail.ru/inbox/?back=1&afterReload=1");

        WebElement userName = driver.findElement(By.id("PH_user-email"));
        assertEquals(userName.getText(),"test_2020_levelup@mail.ru");
    }

    @Test(dependsOnMethods="signInToAccount")
    public void sendLetter() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement createLetter = driver.findElement(By.partialLinkText("Написать письмо"));
        createLetter.click();

        Sleep.sleep(1500);

        WebElement receiverName = driver.findElement(By.xpath("//input[@tabindex='100']"));
        receiverName.sendKeys("test_2020_levelup@mail.ru");
        receiverName.sendKeys(Keys.RETURN);

        WebElement themeLetter = wait
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//input[@tabindex='400']")));
        themeLetter.sendKeys("test");

        WebElement bodyLetter = driver.findElement(By.xpath("//div[@role=\"textbox\"]//div"));
        bodyLetter.sendKeys("test");

        Sleep.sleep(1200);

        WebElement buttonSendLetter = driver.findElement(By.xpath("//span[text()='Отправить']"));
        buttonSendLetter.click();

        WebElement closePopupLetterSended = wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//span[@class=\"button2 button2_has-ico " +
                                "button2_close button2_pure button2_clean button2_short button2_hover-support\"]")));
        closePopupLetterSended.click();
    }

    @Test(dependsOnMethods="sendLetter")
    public void checkingSentLetterToMyself() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement folderSendedLetters = driver.findElement(By.partialLinkText("Входящие"));
        folderSendedLetters.click();

        WebElement folderLettersToMyself = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Письма себе")));
        folderLettersToMyself.click();

        WebElement receiverNameCheck = wait
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ll-crpt")));
        assertEquals(receiverNameCheck.getText(), "Evgeniia Test");

        WebElement themeDraftLetter = driver.findElement(By.cssSelector(".ll-sj__normal"));
        assertEquals(themeDraftLetter.getText(), "test");

        WebElement bodyDraftLetter = driver.findElement(By.cssSelector(".ll-sp__normal"));
        assertEquals(bodyDraftLetter.getText(), "test -- Evgeniia Test");
    }
}



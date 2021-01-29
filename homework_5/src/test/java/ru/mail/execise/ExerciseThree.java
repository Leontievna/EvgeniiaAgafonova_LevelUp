package ru.mail.execise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.MailIndexPage;
import pageobject.MailLetterPage;
import pageobject.MailPostFolderPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * ExerciseThree - класс выполняет вход в аккаунт,
 * создание письма, его отправку себе и выход из аккаунта.
 *
 * @version 1.20 17 Jan 2021
 * @author Агафонова Евгения
 */
public class ExerciseThree extends AbstractSeleniumBaseTest{

    MailIndexPage mailIndexPage;
    MailPostFolderPage mailPostFolderPage;
    MailLetterPage mailLetterPage;

    @Test
    public void sendLetterToMyself() {

        mailIndexPage = new MailIndexPage(driver);
        mailLetterPage = new MailLetterPage(driver);
        mailPostFolderPage = new MailPostFolderPage(driver);

        //Войти в почту
        mailIndexPage.enterLogin()
                .enterPassword();

        //Assert, что вход выполнен успешно
        assertEquals(mailIndexPage.getUserName(),System.getProperty("username"));

        //Создать новое письмо (заполнить адресата, тему письма и тело)
        mailLetterPage.createNewLetter()
                .enterResiverName("test_2020_levelup@mail.ru")
                .enterThemeLetter()
                .enterBodyLetter()
                //Отправить письмо
                .send();
        //Verify, что письмо появилось в папке Входящие
        mailIndexPage.selectFolder("Письма себе");
        assertTrue(mailPostFolderPage.getLetter().isDisplayed());

        //Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        assertTrue(mailPostFolderPage.getResiverName().equals("Evgeniia Test"));
        assertTrue(mailPostFolderPage.getLetterTheme().equals("test"));
        assertTrue(mailPostFolderPage.getLetterBody().equals("test -- Evgeniia Test"));

        //Удалить письмо
        mailPostFolderPage.deleteLetter();

        //Verify что письмо появилось в папке Корзина
        mailIndexPage.selectFolder("Корзина");
        assertTrue(mailPostFolderPage.getLetter().isDisplayed());
        //Выйти из учётной записи
    }
}



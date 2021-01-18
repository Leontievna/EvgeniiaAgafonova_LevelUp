package ru.mail.execise;

import org.testng.annotations.Test;
import pageobject.MailIndexPage;
import pageobject.MailLetterPage;
import pageobject.MailPostFolderPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * ExerciseOne - класс выполняет вход в аккаунт,
 * создание черновика письма, его отправку и выход из аккаунта.
 *
 * @version 1.20 17 Jan 2021
 * @author Агафонова Евгения
 */
public class ExerciseOne extends AbstractSeleniumBaseTest {

    MailIndexPage mailIndexPage;
    MailPostFolderPage mailPostFolderPage;
    MailLetterPage mailLetterPage;

    @Test
    public void sendDraft() {

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
                .enterResiverName("jane-utest@ya.ru")
                .enterThemeLetter()
                .enterBodyLetter()
                //Сохранить его как черновик
                .save();
        //Verify, что письмо сохранено в черновиках
        mailIndexPage.selectFolder("Черновики");
        assertTrue(mailPostFolderPage.getLetter().isDisplayed());

        //Verify контент, адресата и тему письма (должно совпадать с пунктом 3)
        assertTrue(mailPostFolderPage.getResiverName().equals(System.getProperty("resivername")));
        assertTrue(mailPostFolderPage.getLetterTheme().equals("test"));
        assertTrue(mailPostFolderPage.getLetterBody().equals("test -- Evgeniia Test"));

        //Отправить письмо
        mailPostFolderPage.getLetter().click();
        mailLetterPage.send();

        //Verify, что письмо исчезло из черновиков
        assertTrue(mailPostFolderPage.getFolderField().isDisplayed());

        //Verify, что письмо появилось в папке отправленные
        mailIndexPage.selectFolder("Отправленные");
        assertTrue(mailPostFolderPage.getResiverName().equals(System.getProperty("resivername")));
        assertTrue(mailPostFolderPage.getLetterTheme().equals("test"));
        assertTrue(mailPostFolderPage.getLetterBody().equals("test -- Evgeniia Test"));
        // Выйти из учётной записи
    }
}
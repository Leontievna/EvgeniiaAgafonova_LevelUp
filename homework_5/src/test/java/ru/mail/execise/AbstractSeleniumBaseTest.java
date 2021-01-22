package ru.mail.execise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class AbstractSeleniumBaseTest {

//    protected static WebDriver driver;
    protected WebDriver driver;
    private WebDriverWait wait;



    @BeforeClass
    public void setUp() {
        setupProperty();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(System.getProperty("url"));
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void tearDown(){
        WebElement exitAccountButton = driver.findElement(By.cssSelector("[xname=\"clb14767676\"]"));
        exitAccountButton.click();
        driver.quit();
    }

    public void setupProperty(){
        Properties property = new Properties(System.getProperties());
        try {
            property.load(new FileInputStream("src/test/resources/pageobject.properties"));
            System.setProperties(property);
        } catch (IOException e) {
            System.out.println("Отсутствует файл properties");
            e.printStackTrace();
        }
    }
}

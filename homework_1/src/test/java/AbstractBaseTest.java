import org.testng.annotations.*;
import ru.levelup.qa.at.calculator.Calculator;

/**
 * AbstractBaseTest - описание precondition и postcondition методов.
 *
 * @version 1.00 13 Dec 2020
 * @author Агафонова Евгения
 */
public abstract class AbstractBaseTest {
    protected Calculator calculator = new Calculator();

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before Suite method");
    }

//    @BeforeTest
//    public void beforeTest() {
//        System.out.println("before Test method");
//    }

    @BeforeMethod
    public void setUp() {
        System.out.println(this.getClass().getName() + " set up method");
        calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(this.getClass().getName() + " tear down method");
        calculator = null;
    }

//    @AfterTest
//    public void afterTest() {
//        System.out.println("after Test method");
//    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after Suite method");
    }
}

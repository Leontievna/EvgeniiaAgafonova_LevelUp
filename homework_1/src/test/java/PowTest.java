import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * PowTest - проверки для возведения числа в степень.
 *
 * @version 1.00 13 Dec 2020
 * @author Агафонова Евгения
 */
public class PowTest extends AbstractBaseTest{

    @Test
    public void testPow() {
        System.out.println("testPow method");
        double actual = calculator.pow(2, 2);
        assertEquals(actual, 4);
    }

    @Test
    public void testPowZero() {
        System.out.println("testPow method");
        double actual = calculator.pow(0, 0);
        assertEquals(actual, 1);
    }
}

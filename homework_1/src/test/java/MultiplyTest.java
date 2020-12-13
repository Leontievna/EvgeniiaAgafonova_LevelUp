import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * MultiplyTest - проверки для умножения.
 *
 * @version 1.00 13 Dec 2020
 * @author Агафонова Евгения
 */
public class MultiplyTest extends AbstractBaseTest{

    @Test
    public void testMultiply() {
        System.out.println("testMultiply method");
        double actual = calculator.mult(4, 4);
        assertEquals(actual, 16);
    }

    @Test
    public void testZeroMultiply() {
        System.out.println("testMultiply method");
        double actual = calculator.mult(0, 4);
        assertEquals(actual, 0);
    }
}

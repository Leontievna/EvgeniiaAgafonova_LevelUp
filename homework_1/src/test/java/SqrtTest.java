import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * SqrtTest - проверки для квадратного корня.
 *
 * @version 1.00 13 Dec 2020
 * @author Агафонова Евгения
 */
public class SqrtTest extends AbstractBaseTest{

    @Test
    public void testSqrt() {
        System.out.println("testSqrt method");
        double actual = calculator.sqrt(7);
        assertEquals(actual, 2.6457513110645907);
    }

    @Test
    public void testZeroSqrt() {
        System.out.println("testSqrt method");
        double actual = calculator.sqrt(0);
        assertEquals(actual, 0);
    }
}

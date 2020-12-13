import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * SineTest - проверки для Sin.
 *
 * @version 1.00 13 Dec 2020
 * @author Агафонова Евгения
 */
public class SineTest extends AbstractBaseTest{

    @Test
    public void testSine() {
        System.out.println("testSine method");
        double actual = calculator.sin(0);
        assertEquals(actual, 0);
    }

    @Test
    public void testSineNegative() {
        System.out.println("testSineNegative method");
        double actual = calculator.sin(2);
        assertEquals(actual, 0.9092974268256817);
    }
}

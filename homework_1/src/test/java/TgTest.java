import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * TgTest - проверки для Tg.
 *
 * @version 1.00 13 Dec 2020
 * @author Агафонова Евгения
 */
public class TgTest extends AbstractBaseTest{

    @Test
    public void testTan() {
        System.out.println("testTgmethod");
        double actual = calculator.tg(-1);
        assertEquals(actual, 1);
    }

    @Test
    public void testTanNegative() {
        System.out.println("testTgNegative method");
        double actual = calculator.tg(0);
        assertEquals(actual, Double.NaN);
    }
}

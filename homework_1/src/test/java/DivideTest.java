import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * DivideTest - проверки для деления.
 *
 * @version 1.00 13 Dec 2020
 * @author Агафонова Евгения
 */
public class DivideTest extends AbstractBaseTest{
    @Test
    public void testDivide() {
        System.out.println("testDivide method");
        double actual = calculator.div(4, 4);
        assertEquals(actual, 1);
    }

    @Test
    public void testDivideNegative() {
        System.out.println("testDivideNegative method");
        double actual = calculator.div(4, 0.0);
        assertEquals(actual, Double.POSITIVE_INFINITY);
    }

    @Test
    public void testDivideNegative1() {
        System.out.println("testDivideNegative1 method");
        String actual = String.valueOf(calculator.div(4, 0.0));
        assertEquals(actual, "Infinity");
    }
}

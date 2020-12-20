import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * CosTest - проверки для cos.
 *
 * @version 1.00 13 Dec 2020
 * @author Агафонова Евгения
 */
public class CosTest extends AbstractBaseTest{

    @Test
    public void testCos() {
        System.out.println("testCos method");
        double actual = calculator.cos(-1);
        assertEquals(actual, -0.8414709848078965);
    }

    @Test
    public void testCosNegative() {
        System.out.println("testCosNegative method");
        double actual = calculator.cos(-600);
        assertEquals(actual, -0.044182448331873195);
    }
}

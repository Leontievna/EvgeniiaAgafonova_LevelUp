import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * CosTest - проверка для Ctg.
 *
 * @version 1.00 13 Dec 2020
 * @author Агафонова Евгения
 */
public class CtgTest extends AbstractBaseTest{

    @Test
    public void testCtg() {
        System.out.println("testCtg method");
        double actual = calculator.ctg(Double.POSITIVE_INFINITY);
        assertEquals(actual, 1);
    }
}

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * SubstractTest - проверки для вычетания.
 *
 * @version 1.00 13 Dec 2020
 * @author Агафонова Евгения
 */
public class SubstractTest extends AbstractBaseTest{
    @Test
    public void testSubstract() {
        System.out.println("testSubstract method");
        double actual = calculator.sub(4, 4);
        assertEquals(actual, 0);
    }

    @Test
    public void testSubstractNegativeNumbers() {
        System.out.println("testSubstractNegativeNumbers method");
        double actual = calculator.sub(-4, -3);
        assertEquals(actual, -1);
    }
}

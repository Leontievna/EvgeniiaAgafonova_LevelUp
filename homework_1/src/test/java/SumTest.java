import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * SumTest - проверка для сложения.
 *
 * @version 1.00 13 Dec 2020
 * @author Агафонова Евгения
 */
public class SumTest extends AbstractBaseTest {

    @Test
    public void testSum() {
        System.out.println("testSum method");
        double actual = calculator.sum(4, 4);
        assertEquals(actual, 8);
    }
}


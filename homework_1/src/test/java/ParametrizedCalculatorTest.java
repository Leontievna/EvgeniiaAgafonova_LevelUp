import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * ParametrizedCalculatorTest - описание параметризованных тестов.
 *
 * @version 1.00 13 Dec 2020
 * @author Агафонова Евгения
 */
public class ParametrizedCalculatorTest extends AbstractBaseTest{
    @Test
    @Parameters({"a", "b", "expected"})
    public void parametrizedSumTest(double a, double b, double expected) {
        double sum = calculator.sum(a, b);
        assertEquals(sum, expected);
    }

    @Test
    @Parameters({"a", "b", "expected"})
    public void parametrizedMultiplyTest(@Optional("3.0") double a, double b, double expected) {
        double multiply = calculator.mult(a, b);
        assertEquals(multiply, expected);
    }

    @Test
    @Parameters({"a", "b", "expected"})
    public void parametrizedDivideTest(double a, double b, double expected) {
        double div = calculator.div(a, b);
        assertEquals(div, expected);
    }

    @Test
    @Parameters({"a", "b", "expected"})
    public void parametrizedSubTest(@Optional("10.0") double a, double b, double expected) {
        double substraction = calculator.sub(a, b);
        assertEquals(substraction, expected);
    }
}

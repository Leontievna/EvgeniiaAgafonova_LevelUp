import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class SimpleListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult tr) {
        System.out.println(tr.getName() + " is success");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println(tr.getName() + " is failure");
    }

    @Override
    public void onStart(ITestContext testContext) {
        System.out.println(testContext.getName() + " starts");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        System.out.println(testContext.getName() + " finished");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getTestName() != null
                ? result.getTestName()
                : result.getName() + " test started");
    }
}

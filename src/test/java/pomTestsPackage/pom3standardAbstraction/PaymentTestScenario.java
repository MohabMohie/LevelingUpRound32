package pomTestsPackage.pom3standardAbstraction;

import org.testng.annotations.BeforeClass;

public abstract class PaymentTestScenario extends TestScenarioClass {
    @BeforeClass
    public void beforePaymentClass() {
        System.out.println("PaymentTestScenario");
    }
}

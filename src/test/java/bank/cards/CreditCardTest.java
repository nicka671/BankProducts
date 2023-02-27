package bank.cards;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreditCardTest {
    private CreditCard creditCard = new CreditCard();

    private double testTotalDebt = 987.12;

    private double assertDelta = 0.01;

    @Before
    public void setUp() {
        creditCard.setTotalDebt(testTotalDebt);
    }

    @Test
    public void checkTotalDebt() {
        double actualTotalDebt = creditCard.getTotalDebt();
        double expectedTotalDebt = testTotalDebt;
        assertEquals(expectedTotalDebt, actualTotalDebt, assertDelta);

    }
}

package bank.deposits;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepositTest {
    private Deposit deposit = new Deposit();

    private double assertDelta = 0.01;

    @Before
    public void setUp() {
        deposit.setBalance(20.0);
    }

    @Test
    public void checkCloseDeposit() {
        deposit.closeDeposit();
        double actualBalanceAfterWithdraw = deposit.getBalance();
        double expectedBalanceAfterWithdraw = 0.0;
        assertEquals(expectedBalanceAfterWithdraw, actualBalanceAfterWithdraw, assertDelta);
    }
}

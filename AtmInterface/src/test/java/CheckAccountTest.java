import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheckAccountTest {
    private CheckAccount checkAccount;

    @BeforeEach
    void setUp() {

        checkAccount = new CheckAccount(1000.0, 500.0);
    }

    @Test
    void testWithdrawWithinBalanceAndOverdraftLimit() {

        double initialBalance = checkAccount.getBalance();
        checkAccount.withdraw(1500.0);

        double expectedBalance = initialBalance - 1500.0;
        assertEquals(expectedBalance, checkAccount.getBalance());
    }

    @Test
    void testWithdrawExceedingOverdraftLimit() {

        double initialBalance = checkAccount.getBalance();
        checkAccount.withdraw(2000.0);
        assertEquals(initialBalance, checkAccount.getBalance());
    }

    @Test
    void testWithdrawNegativeAmount() {

        double initialBalance = checkAccount.getBalance();
        checkAccount.withdraw(-100.0);
        assertEquals(initialBalance, checkAccount.getBalance());
    }

    @Test
    void testInitialBalanceAndOverdraftLimit() {

        assertEquals(1000.0, checkAccount.getBalance());
    }
}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ATMTest {
    private BankAccount account;
    private ATM atm;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000);
        atm = new ATM(account);
    }

    @Test
    void testWithdrawWithSufficientBalance() {
        account.deposit(1000);
        atm.withdraw(500);
    }

    @Test
    void testWithdrawWithInsufficientBalance() {
        account.deposit(500);
        atm.withdraw(1000);
        assertEquals(500, account.getBalance());
    }

    @Test
    void testWithdrawWithNegativeAmount() {
        account.deposit(1000);
        atm.withdraw(-100);
    }

    @Test
    void testDepositWithPositiveAmount() {
        atm.deposit(500);
    }

    @Test
    void testDepositWithNegativeAmount() {
        atm.deposit(-100);
    }

    @Test
    void testCheckBalance() {
        account.deposit(1000);
        atm.checkBalance();
    }
}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000);
    }

    @Test
    void testInitialBalance() {
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testDepositValidAmount() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testDepositNegativeAmount() {
        account.deposit(-100);
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testWithdrawValidAmount() {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        account.withdraw(1200);
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testWithdrawNegativeAmount() {
        account.withdraw(-200);
        assertEquals(1000, account.getBalance());
    }
}

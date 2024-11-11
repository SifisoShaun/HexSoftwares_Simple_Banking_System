import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @BeforeEach
    void setUp() {

        savingsAccount = new SavingsAccount(1000.0, 0.05);
    }

    @Test
    void testAddInterest() {

        double initialBalance = savingsAccount.getBalance();
        savingsAccount.addInterest();

        double expectedBalance = initialBalance * (1 + 0.05);
        assertEquals(expectedBalance, savingsAccount.getBalance());
    }

    @Test
    void testInitialBalance() {

        assertEquals(1000.0, savingsAccount.getBalance());
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private Client client;
    private BankAccount account;

    @BeforeEach
    void setUp() {

        account = new SavingsAccount(1000.0, 0.05);
        client = new Client("John Doe", account);
    }

    @Test
    void testGetName() {

        assertEquals("John Doe", client.getName());
    }

    @Test
    void testGetAccount() {

        assertNotNull(client.getAccount());
        assertEquals(1000.0, client.getAccount().getBalance());
    }

    @Test
    void testAccountType() {

        assertTrue(client.getAccount() instanceof SavingsAccount);
    }
}

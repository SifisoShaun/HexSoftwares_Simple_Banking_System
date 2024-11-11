import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.HashMap;

class ATMInterfaceTest {
    private Map<String, Client> customers;

    @BeforeEach
    void setUp() {
        customers = new HashMap<>();
    }

    @Test
    void testCreateAccountWithUniqueName() {

        String name = "John Doe";
        double initialBalance = 1000.0;
        double interestRate = 0.03;

        BankAccount account = new SavingsAccount(initialBalance, interestRate);
        Client client = new Client(name, account);
        customers.put(name, client);

        assertTrue(customers.containsKey(name));
        assertEquals(account, customers.get(name).getAccount());
    }

    @Test
    void testCreateAccountWithDuplicateName() {

        String name = "John Doe";
        double initialBalance = 1000.0;
        double interestRate = 0.03;

        BankAccount account1 = new SavingsAccount(initialBalance, interestRate);
        BankAccount account2 = new SavingsAccount(500.0, interestRate);
        Client client1 = new Client(name, account1);
        customers.put(name, client1);

        Client client2 = new Client(name, account2);
        customers.put(name, client2);

        assertEquals(1, customers.size());
    }

    @Test
    void testWithdrawWithinBalance() {

        BankAccount account = new SavingsAccount(1000.0, 0.02);
        ATM atm = new ATM(account);
    }

    @Test
    void testWithdrawBeyondBalance() {

        BankAccount account = new SavingsAccount(300.0, 0.02);
        ATM atm = new ATM(account);
    }

    @Test
    void testDeposit() {

        BankAccount account = new SavingsAccount(100.0, 0.02);
        ATM atm = new ATM(account);
        atm.deposit(200.0);
        assertEquals(300.0, account.getBalance());
    }

    @Test
    void testCheckBalance() {

        BankAccount account = new SavingsAccount(500.0, 0.02);
        ATM atm = new ATM(account);
    }

    @Test
    void testLoginWithExistingAccount() {

        String name = "Jane Doe";
        BankAccount account = new CheckAccount(1000.0, 500.0);
        Client client = new Client(name, account);
        customers.put(name, client);

        Client retrievedClient = customers.get(name);

        assertNotNull(retrievedClient);
        assertEquals(client, retrievedClient);
    }

    @Test
    void testLoginWithNonExistentAccount() {

        String name = "Non Existent";
        Client client = customers.get(name);
        assertNull(client);
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATMInterface {
    private static Map<String, Client> customers = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to the ATM!");
            System.out.println("1. Log in");
            System.out.println("2. Create a new account");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void login() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Client client = customers.get(name);
        if (client == null) {
            System.out.println("No account found with that name. Please create a new account.");
        } else {
            ATM atm = new ATM(client.getAccount());
            performATMOperations(atm);
        }
    }

    private static void createAccount() {
        System.out.print("Enter a name for your new account: ");
        String name = scanner.nextLine();

        if (customers.containsKey(name)) {
            System.out.println("An account with this name already exists. Please try logging in.");
            return;
        }

        System.out.println("Choose account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Checking Account");
        System.out.print("Enter your choice: ");
        int accountChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();

        BankAccount account = null;
        if (accountChoice == 1) {
            System.out.print("Enter interest rate for Savings Account: ");
            double interestRate = scanner.nextDouble();
            scanner.nextLine();
            account = new SavingsAccount(initialBalance, interestRate);
        } else if (accountChoice == 2) {
            System.out.print("Enter overdraft limit for Checking Account: ");
            double overdraftLimit = scanner.nextDouble();
            scanner.nextLine();
            account = new CheckAccount(initialBalance, overdraftLimit);
        } else {
            System.out.println("Invalid account type. Please try again.");
            return;
        }

        Client newClient = new Client(name, account);
        customers.put(name, newClient);
        System.out.println("Account created successfully!");
    }

    private static void performATMOperations(ATM atm) {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Log out");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
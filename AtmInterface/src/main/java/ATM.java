public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient balance. Available balance: " + account.getBalance());
        } else {
            account.withdraw(amount);
            System.out.println("Successfully withdrawn: " + amount);
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
        } else {
            account.deposit(amount);
            System.out.println("Successfully deposited: " + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }
}

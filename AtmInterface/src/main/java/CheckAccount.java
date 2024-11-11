public class CheckAccount extends BankAccount {
    private double overdraftLimit;

    public CheckAccount(double initialBalance, double overdraftLimit) {
        super(initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance + overdraftLimit) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal amount exceeds overdraft limit. Available balance: " + balance);
        }
    }
}

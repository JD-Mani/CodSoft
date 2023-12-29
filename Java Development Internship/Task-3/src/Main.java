import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
            return true;
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
        return false;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option, Scanner scanner) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit(scanner);
                break;
            case 3:
                withdraw(scanner);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void checkBalance() {
        double balance = bankAccount.getBalance();
        System.out.println("Your balance is: $" + balance);
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter the deposit amount: $");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter the withdrawal amount: $");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial account balance: $");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();

            atm.processOption(option, scanner);
        }
    }
}

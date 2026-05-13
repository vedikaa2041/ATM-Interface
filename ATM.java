import java.util.Scanner;

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {

        balance += amount;

        System.out.println("₹" + amount + " Deposited Successfully.");
    }

    public void withdraw(double amount) {

        if (amount <= balance) {

            balance -= amount;

            System.out.println("₹" + amount + " Withdrawn Successfully.");

        } else {

            System.out.println("Insufficient Balance.");
        }
    }

    public void transfer(BankAccount receiver, double amount) {

        if (amount <= balance) {

            balance -= amount;

            receiver.balance += amount;

            System.out.println("₹" + amount + " Transferred Successfully.");

        } else {

            System.out.println("Insufficient Balance.");
        }
    }

    public void transactionHistory() {

        System.out.println("Current Balance: ₹" + balance);
    }
}

public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int userPin = 2041;

        BankAccount userAccount = new BankAccount(10000);

        BankAccount receiverAccount = new BankAccount(5000);

        System.out.println("===== ATM INTERFACE =====");

        System.out.print("Enter ATM PIN : ");

        int pin = sc.nextInt();

        if (pin != userPin) {

            System.out.println("Incorrect PIN. Access Denied.");

            return;
        }

        System.out.println("Login Successful!");

        while (true) {

            System.out.println("\n===== MENU =====");

            System.out.println("1. Transaction History");

            System.out.println("2. Withdraw");

            System.out.println("3. Deposit");

            System.out.println("4. Transfer");

            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    userAccount.transactionHistory();

                    break;

                case 2:

                    System.out.print("Enter amount to withdraw: ");

                    double withdrawAmount = sc.nextDouble();

                    userAccount.withdraw(withdrawAmount);

                    break;

                case 3:

                    System.out.print("Enter amount to deposit: ");

                    double depositAmount = sc.nextDouble();

                    userAccount.deposit(depositAmount);

                    break;

                case 4:

                    System.out.print("Enter amount to transfer: ");

                    double transferAmount = sc.nextDouble();

                    userAccount.transfer(receiverAccount, transferAmount);

                    break;

                case 5:

                    System.out.println("Thank You for Using ATM.");

                    sc.close();

                    return;

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}

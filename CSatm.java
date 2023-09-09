import java.util.Scanner;

class BankAccount {
    double balance;

    //Initializing a default balance value in the user's bank account
    BankAccount(double initialBalance) {
        balance = initialBalance;
    }
    
    //Returning the amount in user's bank account
    double getBalance() {
        return balance;
    }

    //Deposit method for user deposit in there bank account
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    
    //Prompting user with message at the time of withdraw
    boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
            return true;
        } else {
            System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
            return false;
        }
    }
}

public class CSatm {
    //Private access specifier for security
    private BankAccount account;

    CSatm(BankAccount bankAccount) {
        account = bankAccount;
    }

    //Method the the Atm menu
    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processTransaction() {
        
        //Scanner class for user input
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            //Calling the displayMenu method
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            
            //switch statement for giving user the choices to choose from the menu
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    double balance = account.getBalance();
                    System.out.println("Account balance: " + balance);
                    break;

                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        //Creating a object named codsoft for the BankAccount class and put 1000 as initial balance
        BankAccount codsoft = new BankAccount(1000.0);
        
        CSatm atmMachine = new CSatm(codsoft);
        
        //Calling the method
        atmMachine.processTransaction();
    }
}

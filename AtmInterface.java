import java.util.Scanner;

class BankAccount 
{
    private double balance;
    public BankAccount(double balance)
    {
        this.balance = balance;
    }
    public double getBalance()
    {
        return balance;
    }
    public void deposit(double amount) 
    {
        balance += amount;
        System.out.println("Deposited " + amount + "\nNew balance: " + balance);
    }
    public void withdraw(double amount)
    {
        if (amount <= balance)
        {
            balance -= amount;
            System.out.println("Withdrew " + amount + "\nNew balance:" + balance);
        } 
	else 
            System.out.println(" Withdrawal failed.");
        
    }
}

class ATM 
{
    private BankAccount Account;
    public ATM(BankAccount Account)
    {
        this.Account = Account;
    }
    public void displayOptions()
    {
        System.out.println("1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
    }
    public void performTransaction(int option, double amount)
    {
        switch (option)
        {
            case 1:
                Account.withdraw(amount);
                break;
            case 2:
                Account.deposit(amount);
                break;
            case 3:
                System.out.println("Current balance: $" + Account.getBalance());
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.exit(0);
        }
    }
}

public class AtmInterface
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial account balance: ");
        double initialBalance = scanner.nextDouble();
        BankAccount Account = new BankAccount(initialBalance);
        ATM atmMachine = new ATM(Account);
        while (true) 
        {
            atmMachine.displayOptions();
            System.out.print("Choose an option:");
            int userOption = scanner.nextInt();
            if (userOption == 4)
            {
                break;
            }
            if (userOption == 3)
            {
                atmMachine.performTransaction(userOption, 0);
            } 
            else 
            {
                System.out.print("Enter amount: ");
                double transactionAmount = scanner.nextDouble();
                atmMachine.performTransaction(userOption, transactionAmount);
            }
        }

        scanner.close();
    }
}


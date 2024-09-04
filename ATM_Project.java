import java.util.*;

class Transaction {
    private Date date;
    private String description;
    private double amount;

    public Transaction(Date date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Date " + date + ", Description: " + description + ", Amount: " + amount;
    }
}

class Account {
    private String userId;
    private String pin;
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance = balance + amount;
        transactions.add(new Transaction(new Date(), "Deposit", amount));
        System.out.println("Deposit Succesfully. Current Balance: Rs" + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance..");
        } else {
            balance = balance - amount;
            transactions.add(new Transaction(new Date(), "Withdrawal", -amount));
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            balance = balance - amount;
            recipient.balance = recipient.balance + amount;
            transactions.add(new Transaction(new Date(), "Transfer to" + recipient.userId, -amount));
            recipient.transactions.add(new Transaction(new Date(), "Transfer from" + userId, amount));
            System.out.println("Transfer Successful. Current Balance: Rs" + balance);
        }
    }

    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

public class ATM_Project {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter User Id :");               // Default UserId is - admin 
        String userId = scan.nextLine();
        System.out.println("Enter PIN: ");                  // Default password is  - 1234
        String pin = scan.nextLine();

        Account account = new Account(userId, pin);

        boolean loggedIn = false;
        if (userId.equals("admin") && pin.equals("1234")) {
            loggedIn = true;
        }

        if (!loggedIn) {
            System.err.println("Invalid User ID or PIN.");
        } else {
            System.out.println("Welcome..\n" + userId);
            System.out.println("");

            while (true) {
                System.out.println("Select an option:");
                System.out.println("1. Transactions History.");
                System.out.println("2. Withdraw.");
                System.out.println("3. Deposit.");
                System.out.println("4. Transfer.");
                System.out.println("5. Exit.");
                System.out.println("--------------------------------------------------------------------------------------");

                int choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Transaction History:\n");
                        account.printTransactions();
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    case 2:
                        System.out.println("Enter Amount To Withdraw: Rs");
                        double withdrawAmount = scan.nextDouble();
                        account.deposit(withdrawAmount);
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    case 3:
                        System.out.println("Enter amount to deposit: Rs");
                        double depositAmount = scan.nextDouble();
                        account.deposit(depositAmount);
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    case 4:
                        System.out.println("Enter Recipient User ID:");
                        String recipientId = scan.next();
                        System.out.println("Enter Amount To Transfer : Rs");
                        double transferAmount = scan.nextDouble();
                        Account recipient = new Account(recipientId, "");
                        account.transfer(recipient, transferAmount);
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM ..");
                        System.out.println("--------------------------------------------------------------------------------------");
                        scan.close();

                    default:
                        System.out.println("Invalid Choice .");
                }

            }
        }
    }

}

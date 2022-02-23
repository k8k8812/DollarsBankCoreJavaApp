package dollarsbankModel;

import java.util.Queue;

public class Customer {

    // Customer Properties
    private final String name;
    private final String address;
    private final String contactNumber;
    private final String id;
    private final String password;
    private final double initial_balance;

    private final SavingsAccount customerSavings;

    // Constructor
    public Customer(String name, String address, String contactNumber,
                    String id, String password, double initial_balance, Queue<String> queue){
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.id = id;
        this.password = password;
        this.initial_balance = initial_balance; // added initial balance; (customer will be required to enter an initial balance at account create.
        double balance = this.initial_balance; // set a local variable balance for initial balance to pass to;
        customerSavings = new SavingsAccount(balance, queue);
    }

    // Method to print customer information and balance
    public void ToString(){
        System.out.printf("""
                        Name: %s
                        Address: %s
                        Contact: %s
                        ID: %s
                        Password: %s
                        Initial Balance: $%s
                        %n""",
                name, address, contactNumber, id, password,initial_balance );    //instead of customerSavings.getBalance(), I had 'initial_balance';
    }

    // accepts an amount and a customer object to transfer funds
    // between this account and additional customer
    public void transfer(double amount, Customer customer){
        if(amount < this.customerSavings.balance){
            this.withdraw(amount);
            customer.deposit(amount);
        }
    }

    public void deposit(double amount){
        customerSavings.deposit(amount);
    }

    public void withdraw(double amount){
        customerSavings.withdraw(amount);
    }

    public void balanceHistory(){ customerSavings.transactionHistory();}


}

package chapter11.exercise;
import java.util.ArrayList;

public class Exercise11_8 {
    public static void main(String[] args) {
        NewAccount person1 = new NewAccount("George", 1122, 1000);
        person1.setAnnualInterestRate(1.5);
        person1.withdraw(30);
        person1.withdraw(40);
        person1.withdraw(50);
        person1.deposit(5);
        person1.deposit(4);
        person1.deposit(2);

        ArrayList<Transaction> person1Record = person1.getRecord();

        System.out.println("Name: " + person1.getName() + "\nAnnual Interest Rate: " 
            + person1.getAnnualInterestRate() + "\nBalance: " + person1.getBalance());
        System.out.println("\n交易记录：");
        for (Transaction description : person1Record) {
            System.out.println(description.getDescription());
        }
    }
}

class Transaction {
    private char type;;
    private double amount;
    private double balance;
    private String description;

    public Transaction(char type, double amount,
        double balance, String description) {
        new java.util.Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public double getBalance() {
        return balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


class NewAccount {
    private int id;
    private double balance;
    private double annualInterestRate;
    private String name;
    private java.util.ArrayList<Transaction> record = new java.util.ArrayList<>();

    public NewAccount() {
        new java.util.Date();
    }

    public NewAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public NewAccount(String name, int id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getMontylyInterestRate() {
        return annualInterestRate / 12;
    }

    public java.util.ArrayList<Transaction> getRecord() {
        return record;
    }

    public void withdraw(double amount) {
        balance = balance - amount;
        String description = "取款: " + amount + "\t剩余：" + balance;
        record.add(new Transaction('W', amount, balance, description));
    }

    public void deposit(double amount) {
        balance = balance + amount;
        String description = "存款：" + amount + "\t剩余：" + balance;
        record.add(new Transaction('D', amount, balance, description));
    }
}

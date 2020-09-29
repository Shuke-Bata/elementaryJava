package chapter10.exercise;

import java.util.Scanner;

public class Exercise10_7 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account account = new Account();
        int number = 0;

        while (true) {
            System.out.print("Enter an id: ");
            String id = input.next();
            while (account.checkId(id)) {
                showMenu();
                number = input.nextInt();
                if (number == 1)
                    System.out.println("The balance is: " + account.getBalance() + "\n");
                else if (number == 2) {
                    System.out.print("Enter an amount to withdraw: ");
                    if (!account.withdraw(input.nextInt()))
                        System.out.println("Don't have enough monney in your account.\n");
                    else
                        System.out.println();
                }
                else if (number == 3) {
                    System.out.print("Enter an amount to deposit: ");
                    account.deposit(input.nextInt());
                }
                else if (number == 4)
                    break;
            }
            if (number != 4)
                System.out.println("Invalid value.\n");
        }
    }

    public static void showMenu() {
        System.out.print("Main menu\n1: check balance\n2: withdraw\n3: deposit\n4: exit\nEnter a choice: ");
    }
}
class Account {
    private String id;
    private double balance;
    @SuppressWarnings("unused")
	private double withdraw;
    @SuppressWarnings("unused")
	private double deposit;

    public Account() {
        id = "978332";
        balance = 100;
    }

    public boolean checkId(String id) {
        if (this.id.equals(id))
            return true;
        else
            return false;
    }

    public boolean withdraw(int amount) {
        if (balance < amount)
            return false;
        else {
            balance -= amount;
            return true;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}


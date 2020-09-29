package chapter09.exercise;

import java.util.Date;

public class Exercise9_7 {
	public static void main(String[] args){

		Account account1 = new Account(1122, 20000);

		account1.setAnnualInterestRate(4.5);

		account1.withDraw(2500);

		account1.deposit(3000);

		System.out.println(account1.getBalance() + "\n" +

				account1.getMonthlyInterestRate() + "\n" + 

				account1.getDateCreated());

	}

}
class Account {
    
    private int id = 0;

    /**
     * 余额
     */
    private double balance = 0;

    /**
     * 利率
     */
    private double annualInterestRate = 0;

    /**
     * 开户时间
     */
    private Date dateCreated;

    public Account() {

    }

    /**
     * @param id 
     * @param balance
     */
    public Account(int id, double balance) {
    	this.id = id;
    	this.balance = balance;
    }

    /**
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id 
     * @return
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance 
     * @return
     */
    public void setBalance(double balance) {
    	this.balance =balance;
    }

    /**
     * @return
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * @param annualInterestRate 
     * @return
     */
    public void setAnnualInterestRate(double annualInterestRate) {
    	this.annualInterestRate = annualInterestRate;
    }

    /**
     * @return
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * @return
     */
    public double getMonthlyInterestRate() {
    	return balance * annualInterestRate / 100 / 12;
    }

    /**
     * @param money 
     * @return
     */
    public void withDraw(double money) {
    	 balance -=money;
    }

    /**
     * @param money 
     * @return
     */
    public void deposit(double money) {
       balance +=money;
    }
}

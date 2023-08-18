package componts;

import java.util.Scanner;

public class Deposit extends BankManger {
    private double amt;
    double depositBalance;

    public void deposit() {
        System.out.println("your Total balance : RS " + depositBalance);
        Scanner V = new Scanner(System.in);
        System.out.println("Enter the amount you want to deposit: ");
        amt = V.nextLong();
        System.out.println("---------------------------------------------");
        depositBalance += amt;
        
    }

    public void display() {
        System.out.println("Total amount after deposit is RS " + depositBalance);
        System.out.println("---------------------------------------------");

    }
}

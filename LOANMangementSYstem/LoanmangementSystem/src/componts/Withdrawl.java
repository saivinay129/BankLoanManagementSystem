package componts;

import java.util.Scanner;

public class Withdrawl  {
    private double amt;
    double withdrawBalance;

    public void withDrawl() {

        System.out.println("your Total balance : RS " + withdrawBalance);
        Scanner A = new Scanner(System.in);
        System.out.print("Enter the amount you want to withdraw: ");
        amt = A.nextLong();
        System.out.println("---------------------------------------------");
        if (withdrawBalance >= amt) {
            withdrawBalance -= amt;
            System.out.println("Balance after withdrawal : RS " + withdrawBalance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
        }
        
    }

    public void display() {
        System.out.println("---------------------------------------------");
        System.out.println("Total amount after withdrawl is RS " + withdrawBalance);

    }
}

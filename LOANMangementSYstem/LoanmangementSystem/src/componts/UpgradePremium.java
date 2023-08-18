package componts;

import java.util.Scanner;

public class UpgradePremium  extends BankManger {
    
    String F;
    double loanBalance;
    Boolean upgradedtopremium;
    Boolean Takenloan;

    public void upgradePremium() {
        System.out.println("your Total balance : RS " + loanBalance);
        Scanner U = new Scanner(System.in);
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
        System.out.println(
                "NOTE::By upgrade your account to premium,Premium users can get a loan upto total 25000.AND further there many programs and loans will be given to premium users");
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
        if (visted == 0) {
            System.out.println("Do you want to upgrade your account to premium: (type yes/no)");
            F = U.nextLine();

            if (F.equals(R)) {
                System.out.println("---------------------------------------------");
                System.out.println("Congratulations for  upgrade your account to premium");
                visted = 1;
                upgradedtopremium=true;

            } else {
                System.out.println("---------------------------------------------");
                System.out.println("Thank you for visting");
                upgradedtopremium=false;
            }
        } else {
            System.out.println("You already upgrade to premium");
            upgradedtopremium=true;
        }
        
    }

    public void loan() {
        Scanner Y = new Scanner(System.in);
        String L;
        
        if (vistedloan == 0) {
            System.out.println("---------------------------------------------");
            System.out.println("Do you want take loan : (type yes/no) ");
            L = Y.nextLine();
            System.out.println("---------------------------------------------");
            if (L.equals(R) && (visted==1 && vistedloan==0)) {
                System.out.println("the loanWithPremium amount is " + Z);
                loanBalance += Z;
                System.out.println("Total balance after adding loan with premium amount :: RS " + loanBalance);
                System.out.println("---------------------------------------------");
                vistedloan = 1;
                Takenloan=true;

            } else if (L.equals(R) && (visted==0 && vistedloan==0)) {
                System.out.println("the loanWithOutPremium amount is Rs." + K);
                loanBalance += K;
                System.out.println("Total balance after adding loan without premium amount :: RS " + loanBalance);
                System.out.println("---------------------------------------------");
                vistedloan = 1;
                Takenloan=true;
            } else {
                System.out.println("---------------------------------------------");
                System.out.println("Thank you for visting");
                Takenloan=false;
            }
        } else {
            System.out.println("You already taken loan");
            Takenloan=true;
        }
        
    }

}

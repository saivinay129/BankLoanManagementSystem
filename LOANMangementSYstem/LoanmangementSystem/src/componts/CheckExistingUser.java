package componts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CheckExistingUser {
    long accountNumber;
    long accno2;
    String name2;
    long phoneNo2;
    double balance2;
    boolean loanTaken2;
    boolean upgradeToPremium2;
    public void checkexistinguser() {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Account Number: ");
            accountNumber = scanner.nextLong();
            Connection con = JDBC.connect();
            String query = Query.selectOldUSER;
            PreparedStatement preparedStatement = con.prepareStatement(query);
            UserExists  it = new UserExists();
            if (it.userExists(accountNumber)) {
                System.out.println("--------------------**-------------------------");
                System.out.println("      --------------**-------------            ");
                System.out.println("User with Account Number " + accountNumber + " already exists.");
                System.out.println("      --------------**-------------            ");
                System.out.println("--------------------**-------------------------");
                RetrieveUserDetails it1 = new RetrieveUserDetails();
                it1.retrieveuSERdETAILS(accountNumber);
                accno2=it1.accno1;
                name2=it1.name1;
                phoneNo2=it1.phoneNo1;
                balance2=it1.balance1;
                loanTaken2=it1.loanTaken1;
                upgradeToPremium2=it1.upgradeToPremium1;
            } else {
                System.out.println("--------------------*-------------------------");
                System.out.println("invaild user and your exited out for unkown account");
                System.out.println("        ------------***------------             ");
                System.out.println("--------------------***-------------------------");
                System.exit(0);
            }
            //preparedStatement.executeQuery();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

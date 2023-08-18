package componts;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class CreateAccount {
    public void createaccountToUser(long accno, String name, long phoneNo, double balance, boolean LoanTaken,
            boolean UpgradeToPremium) {
        try {
            Connection con = JDBC.connect();
            String query = Query.insert;
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setLong(1, accno);
            preparedStatement.setString(2, name);
            preparedStatement.setLong(3, phoneNo);
            preparedStatement.setDouble(4, balance);
            preparedStatement.setBoolean(5, LoanTaken);
            preparedStatement.setBoolean(6, UpgradeToPremium);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

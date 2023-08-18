package componts;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class UpdateloanToUser {

    public void updateloanToUser(long accno, double balance, Boolean LoanTaken, Boolean UpgradeToPremium) {

        try {
            Connection con = JDBC.connect();
            String query = Query.updateLoan;
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setDouble(1, balance);
            preparedStatement.setBoolean(2, LoanTaken);
            preparedStatement.setBoolean(3, UpgradeToPremium);
            preparedStatement.setLong(4, accno);
            
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

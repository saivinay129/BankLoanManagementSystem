package componts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetrieveUserDetails extends BankManger {
    
    long accno1;
    String name1;
    long phoneNo1;
    double balance1;
    boolean loanTaken1;
    boolean upgradeToPremium1;

    public void retrieveuSERdETAILS(long accountNumber) {
        
        accno1=accountNumber;
        try {

            Connection con = JDBC.connect();
            String query = Query.select;

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setLong(1, accountNumber);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        name1 = resultSet.getString("Name");
                        phoneNo1 = resultSet.getLong("PhoneNumber");
                        balance1 = resultSet.getDouble("Balace");
                        loanTaken1 = resultSet.getBoolean("LoanTaken");
                        upgradeToPremium1 = resultSet.getBoolean("UpgradeToPremium");

                    }
                }
                // preparedStatement.executeQuery();
                preparedStatement.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

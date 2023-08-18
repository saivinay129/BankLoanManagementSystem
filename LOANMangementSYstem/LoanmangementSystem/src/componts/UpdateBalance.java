package componts;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateBalance {
    public void updatBalanceToUser(long accno, double balance) {
        try {
            Connection con = JDBC.connect();
            String query = Query.update;
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setDouble(1, balance);
            preparedStatement.setLong(2, accno);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

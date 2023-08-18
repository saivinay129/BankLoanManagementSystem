package componts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserExists {
    
    public boolean userExists(long accountNumber) {
        
        try {

            Connection con = JDBC.connect();
            String query = Query.selectOldUSER;

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setLong(1, accountNumber);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                        
                    }
                }
                //preparedStatement.executeQuery();
                preparedStatement.close();
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}

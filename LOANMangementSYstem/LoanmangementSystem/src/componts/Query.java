package componts;

public class Query {
    static String insert ="INSERT INTO bankloansystem (AccountNumber, Name, PhoneNumber, Balace, LoanTaken, UpgradeToPremium)  VALUES (?,?,?,?,?,?)";
    static String update ="UPDATE bankloansystem SET Balace = ? WHERE AccountNumber = ? ";
    static String updateLoan ="UPDATE bankloansystem SET Balace = ?, LoanTaken = ?, UpgradeToPremium = ? WHERE AccountNumber = ? ";
    static String delete ="DELETE FROM bankloansystem WHERE  AccountNumber = ?";
    static String select ="SELECT * FROM bankloansystem WHERE AccountNumber = ?";
    static String selectOldUSER = "SELECT COUNT(*) FROM bankloansystem WHERE AccountNumber = ?";
}

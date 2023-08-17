package jdbcproject.CaseStudy;

import java.sql.*;

public class CallQuality {
    public static final String URL = "jdbc:mysql://localhost:3306/test";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";
    Connection con;
    Statement stat;

    public void dbConnect() {
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection established");
            System.out.println("Database product name: " + con.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void executeStatements() {
        String query = "CREATE TABLE CallQuality (" +
                "callid INT PRIMARY KEY, " +
                "phoneNo VARCHAR(20), " +
                "callfeedback VARCHAR(50), " +
                "callrating INT, " +
                "customername VARCHAR(30), " +
                "calldroprate VARCHAR(10))";

        try {
            stat = con.createStatement();
            stat.executeUpdate(query); 
            System.out.println("Table created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertRecords() {
        String insertCommand = "INSERT INTO CallQuality VALUES " +
                "(1, '9934223221', 'getting frequent call drops', 2, 'Erric Jones', '35%'), " +
                "(2, '8873433421', 'call drops happening', 3, 'Mathew Mandis', '32%')";

        try {
            int recordsAffected = stat.executeUpdate(insertCommand);
            System.out.println("Records inserted: " + recordsAffected);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getRecords() {
        String query = "SELECT * FROM CallQuality";

        try {
            ResultSet result = stat.executeQuery(query);
            while (result.next()) {
                int callid = result.getInt("callid");
                String phoneNo = result.getString("phoneNo");
                String callfeedback = result.getString("callfeedback");
                int callrating = result.getInt("callrating");
                String customername = result.getString("customername");
                String calldroprate = result.getString("calldroprate");

                System.out.println("Call ID: " + callid);
                System.out.println("Phone No: " + phoneNo);
                System.out.println("Call Feedback: " + callfeedback);
                System.out.println("Call Rating: " + callrating);
                System.out.println("Customer Name: " + customername);
                System.out.println("Call Drop Rate: " + calldroprate);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateRecords() {
        String query = "UPDATE CallQuality SET calldroprate = '25%' WHERE callid = 2";
        try {
            int recordsAffected = stat.executeUpdate(query);
            System.out.println("Records updated: " + recordsAffected);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void getRecordsWithConditions() {
        String query = "SELECT * FROM CallQuality " +
                       "WHERE calldroprate < '30%' AND callrating < 4 AND LENGTH(phoneNo) < 10";

        try {
            ResultSet result = stat.executeQuery(query);
            while (result.next()) {
                int callid = result.getInt("callid");
                String phoneNo = result.getString("phoneNo");
                String callfeedback = result.getString("callfeedback");
                int callrating = result.getInt("callrating");
                String customername = result.getString("customername");
                String calldroprate = result.getString("calldroprate");

                System.out.println("Call ID: " + callid);
                System.out.println("Phone No: " + phoneNo);
                System.out.println("Call Feedback: " + callfeedback);
                System.out.println("Call Rating: " + callrating);
                System.out.println("Customer Name: " + customername);
                System.out.println("Call Drop Rate: " + calldroprate);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteRecord(int callId) {
        String query = "DELETE FROM CallQuality WHERE callid = " + callId;

        try {
            int recordsAffected = stat.executeUpdate(query);
            System.out.println("Record deleted: " + recordsAffected);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void insertRecordWithParameters(int callid, String phoneNo, String callfeedback, int callrating, String customername, String calldroprate) {
        String insertCommand = "INSERT INTO CallQuality VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(insertCommand);
            preparedStatement.setInt(1, callid);
            preparedStatement.setString(2, phoneNo);
            preparedStatement.setString(3, callfeedback);
            preparedStatement.setInt(4, callrating);
            preparedStatement.setString(5, customername);
            preparedStatement.setString(6, calldroprate);

            int recordsAffected = preparedStatement.executeUpdate();
            System.out.println("Record inserted: " + recordsAffected);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateRecordWithParameter(int callId, String newCalldroprate) {
        String query = "UPDATE CallQuality SET calldroprate = ? WHERE callid = ?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, newCalldroprate);
            preparedStatement.setInt(2, callId);

            int recordsAffected = preparedStatement.executeUpdate();
            System.out.println("Record updated: " + recordsAffected);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        CallQuality callQuality = new CallQuality();
        callQuality.dbConnect();
        callQuality.executeStatements();
        callQuality.insertRecords();
        callQuality.getRecords();
        callQuality.updateRecords();
    }

    }
package jdbcproject.CaseStudy2;

public class App 
{
    public static void main( String[] args )
    {
    	MySqlConnector obj = new MySqlConnector();
    	 obj.dbConnect();
//         obj.executeStatements();
//         obj.insertQuery();
//         obj.getPackageRecords();
//         obj.getCustomerRecords();
         obj.showRecords(500);
    }
}

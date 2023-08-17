package jdbcproject.CaseStudy2;

import java.sql.*;

public class MySqlConnector {
	public static final String URL ="jdbc:mysql://localhost:3306/mysql";
	public static final String USERNAME="root";
	public static final String PASSWORD="1234";
	Connection con;
	Statement stat;
	
	public void dbConnect() {
		
		try {
			
			 con =DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			System.out.println("Connection established");
			System.out.println(con.getMetaData().getDatabaseProductName());
			System.out.println(con.getClientInfo());
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void executeStatements() {
		
		String query="CREATE TABLE customer (customerid int PRIMARY KEY,  firstName VARCHAR(255),  lastName VARCHAR(255),phoneNumber VARCHAR(20), bill_amount int, bill_due_date DATE, customer_address VARCHAR(255),packageid INT,FOREIGN KEY (packageid) REFERENCES package(packageid))"; 
					
		
		try {
			
			stat=con.createStatement();
			boolean result=stat.execute(query);
			if(result)
			{
				System.out.println("table not created");
			}
			else
			{
				System.out.println("table created");
			}
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	
	public void getPackageRecords(){
		String query="Select * from package";
		try {
			 ResultSet result=stat.executeQuery(query);
			 
			 while(result.next()) {
				 int packageid=result.getInt(1);
				 String packagename=result.getString(2);
				 int package_rate=result.getInt(3);				
				 int total_days=result.getInt(4);
				 
				 System.out.println("Package Id "+packageid);
				 System.out.println("Package Name "+packagename);
				 System.out.println("Package Rate "+ package_rate);
				 System.out.println("Total Days "+ total_days);

			
			 }
			
			}
			catch(Exception e) {
				System.out.println(e);
			}	
	}
	

	public void getCustomerRecords(){
		String query="Select * from customer";
		try {
			 ResultSet result=stat.executeQuery(query);
			 
			 while(result.next()) {
				 int customerid=result.getInt(1);
				 String firstName=result.getString(2);
				 String lastName=result.getString(3);
				 String phoneNumber=result.getString(4);
				 int bill_amount=result.getInt(5);
				 String bill_due_date=result.getString(6);
				 String customer_address=result.getString(7);
				 int packageid=result.getInt(8);
				 
				 System.out.println("Customer Id "+customerid);
				 System.out.println("First Name "+firstName);
				 System.out.println("Last Name "+ lastName);
				 System.out.println("Phone Number "+ phoneNumber);
				 System.out.println("Total Bill Amount "+ bill_amount);
				 System.out.println("Bill Due Date "+bill_due_date);
				 System.out.println("Customer Address "+ customer_address);
				 System.out.println("Pakage id "+ packageid);
			
			 }
			
			}
			catch(Exception e) {
				System.out.println(e);
			}	
	}
	
	

	public void insertQuery()
	{
	try {
		
		con.setAutoCommit(false);
		
		stat.addBatch("insert into package values (1, 'Basic', 50, 30)");
		stat.addBatch("insert into package values (2, 'Standard', 75, 30)");
		stat.addBatch("insert into package values  (3, 'Premium', 100, 30)");
		
		stat.addBatch("insert into customer values(1, 'John', 'Doe', '123-456-7890', 200, '2023-09-01', '123 Main St', 1)");
		stat.addBatch("insert into customer values(2, 'Jane', 'Smith', '987-654-3210', 550, '2023-09-05', '456 Elm St', 2)");
		stat.addBatch("insert into customer values(3, 'Michael', 'Johnson', '555-123-4567', 120, '2023-09-03', '789 Oak St', 1)");

		
		int[] results=stat.executeBatch();
		con.commit();
		for(int i:results)
		{
			System.out.println(i);
		}
		
	}
	catch(Exception e) {
		System.out.println(e);
		try {
			con.rollback();
		}
		catch(Exception e1) {
			System.out.println(e1);
		
		}
	
	}
	}
	
	public void showRecords(int bill_amount)
	{
		String query="select * from customer WHERE bill_amount>?";
		
		try {
			PreparedStatement stat= con.prepareStatement(query);
			stat.setInt(1, bill_amount);
			ResultSet result=stat.executeQuery();
			
			 while(result.next()) {
				 int customerid=result.getInt(1);
				 String firstName=result.getString(2);
				 String lastName=result.getString(3);
				 String phoneNumber=result.getString(4);
				 int bill_amount1=result.getInt(5);
				 String bill_due_date=result.getString(6);
				 String customer_address=result.getString(7);
				 int packageid=result.getInt(8);
				 
				 System.out.println("Customer Id "+customerid);
				 System.out.println("First Name "+firstName);
				 System.out.println("Last Name "+ lastName);
				 System.out.println("Phone Number "+ phoneNumber);
				 System.out.println("Total Bill Amount "+ bill_amount1);
				 System.out.println("Bill Due Date "+bill_due_date);
				 System.out.println("Customer Address "+ customer_address);
				 System.out.println("Pakage id "+ packageid);
			
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
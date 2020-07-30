package online_banking;

import java.sql.*;
public class Transfer  {
public static void main(String[] args) throws SQLException {
Connection myConn = null;
Statement myStmt, myStmt0, myStmt1 = null;
ResultSet  myRs0, myRs1 = null;
        
        String dburl = "jdbc:mysql://127.0.0.1:3306/online_banking";
        String user = "student";
        String pass = "student";
        try {
  			// 1. Get a connection to database
        	myConn = DriverManager.getConnection(dburl, user, pass);
  			System.out.println("connection established");
  		// 2. Create a statement
  			myStmt = myConn.createStatement();
  			myStmt0= myConn.createStatement();
 			myStmt1 = myConn.createStatement();
 			
 			//Creation of table
  			//System.out.println("creating table ...");
  			String s2 =    " create table  accounts " + "( serial_number int,"+" dates varchar(15),"+" account_name varchar(15),"+"account_number int,"+" money int, "+"status_check varchar(15),"+" balance int)"; 
  			myStmt.executeUpdate(s2);
  			
  			//System.out.println("table created");
  			
  			//System.out.println("Inserting data into table ");
  			int  r1= myStmt.executeUpdate(
  			" insert into accounts " +"values"+"(11,'24-7-2020', 'harsha', '123451', 1000, 'debit', 26200)");   
  			int r2 = myStmt.executeUpdate(
  			" insert into accounts "+"values"+"(10,'24-7-2020', 'ram', '123453', 3500, 'credit', 15350)");
  			int  r3= myStmt.executeUpdate(
  		   	" insert into accounts "+"values"+"(9,'18-7-2020', 'harsha', '123451', 3000, 'debit', 27200)");
  			int r4 = myStmt.executeUpdate(
  		   	" insert into accounts "+ "values"+"(8,'18-7-2020', 'ram', '123453', 2500, 'debit', 11850)");
  			int r5 = myStmt.executeUpdate(
  		   	"insert into accounts " +"values"+"(7,'12-7-2020', 'harsha', '123451', 1700, 'credit', 30200)");
  			int r6 = myStmt.executeUpdate(
  		   	" insert into accounts "+ "values"+"(6,'01-7-2020', 'harsha', '123451', 5000, 'credit', 28500)");
  			int r7= myStmt.executeUpdate(
  		   	" insert into accounts "+ "values"+"(5,'01-7-2020', 'ram', '123453', 4350, 'credit', 14350)");
  			int r8 = myStmt.executeUpdate(
  		   	" insert into accounts "+"values"+"(4,'30-6-2020', 'harsha', '123451', 10000, 'debit', 23500)");
  			int r9 = myStmt.executeUpdate(
  		   	" insert into accounts "+"values"+"(3,'27-6-2020', 'harsha', '123451', 1500, 'credit', 33500)");
  			int r10 = myStmt.executeUpdate(
  		   	" insert into accounts "+"values"+"(2,'23-6-2020', 'sita', '123452', 3500, 'debit', 50000)");
  			int r11 = myStmt.executeUpdate(
  		   	" insert into accounts "+"values"+"(1,'23-6-2020', 'harsha', '123451', 2000, 'credit', 32000)");
  			
  			//myRs = myStmt.executeQuery("select * from accounts ");
  			myRs0= myStmt0.executeQuery("select account_number, money, status_check,balance, dates from accounts where account_number = '123451' limit 5");
 			myRs1 = myStmt1.executeQuery("select account_name,account_number,balance,balance-1000 as current_bal from accounts where account_number = '123451' limit 1");
 			
  			//while (myRs.next()) {
 			//	System.out.println(myRs.getString("state") + "," + myRs.getString("district") + "," + myRs.getInt("male") + "," + myRs.getInt("female"));
 			//}
 			System.out.println("five transcations of account number 123451");
  			while (myRs0.next()) {
 				System.out.println(myRs0.getInt("account_number") + ", " + myRs0.getInt("money") + ", " + myRs0.getString("status_check") + ", "+ myRs0.getInt("balance")+", "+ myRs0.getString("dates"));
 			}
  			System.out.println("before fund transfer of account number 123451");
 			while (myRs1.next()) {
 				System.out.println(myRs1.getString("account_name") + ", " + myRs1.getString("account_number")+", "+myRs1.getInt("balance") );
 				System.out.println("after fund transfer of account number 123451");
 				System.out.println(myRs1.getInt("current_bal"));
 			}
 			
         }
        catch (Exception exc) {
  			exc.printStackTrace();
  		}          
	}
}






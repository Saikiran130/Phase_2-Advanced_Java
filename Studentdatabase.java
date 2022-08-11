package com.JDBC.Programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Studentdatabase {
	private static final String url = "jdbc:mysql://localhost:3306/db_world";
    private static final String user = "root";
    private static final String password = "root";
    
    Connection con;
    PreparedStatement prSt;
    Statement stmt;
    ResultSet rs;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Studentdatabase s1 = new Studentdatabase();
    	
        Scanner input = new Scanner(System.in);
    	
        System.out.println("=============PREPARED STATEMENT MENU=================");
        System.out.println("1. Insert the new Student Record"); 
        System.out.println("2. Update the student Record");
        System.out.println("3. Delete the student Record");
        System.out.println("4. Retrive all the student Record");
        System.out.println("====================================================");
    	System.out.println("Enter your choice from (1-4): ");
    	
    	int number = input.nextInt();
    	System.out.println("You entered option" + number);
    	
    	switch(number)
    	{
    	case 1: s1.insertRecord();
    	        break;
    	
    	case 2: s1.updateRecord();
    	        break;
    	        
    	case 3: s1.deleteRecord();
    	        break;
    	        
    	case 4: s1.retrieveData();
    			break;
    	}	
        	
	}
	
	public void insertRecord()
	{
		String query = "insert into student(studid,name,age) values(?,?,?)";
		
	      try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);
	           
	            prSt = con.prepareStatement(query);
	            
	            // Take user input for insertion
	            Scanner input = new Scanner(System.in);	
	            
	            System.out.println("\nEnter the no of rows u want:");
	            int rows=input.nextInt();
	            int rowno=1;
	            while(rows!=0){
	            
	            System.out.println("Row Number: "+ rowno);
	            System.out.print("Enter the studentid:  ");
	            int eid = input.nextInt();
	            System.out.println();
	            
	            System.out.print("Enter the Student age:  ");
	            int esal = input.nextInt();
	            System.out.println();
	            
	            System.out.print("Enter the Student name:  ");
	            String ename = input.next();
	            System.out.println();
	            
	            prSt.setInt(1, eid);
	            prSt.setString(2, ename);
	            prSt.setInt(3, esal);
	            
	            int count = prSt.executeUpdate();
	            rows--;
	            rowno++;
	            }
	            
	            System.out.println("\nAll the records are inserted");
	           
	            
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally{
	            try{
	                if(prSt != null) prSt.close();
	                if(con != null) con.close();
	            } catch(Exception ex){}
	        }
	

	}
	
	public void updateRecord()
	{
		String query="Update student set age=? where studid=?";
		try {
            try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            prSt = con.prepareStatement(query);
            
            // Take user input for insertion
            Scanner input = new Scanner(System.in);	
            
            System.out.print("Enter the studid you want to update:  ");
            int studid = input.nextInt();
            System.out.println();
            
            System.out.print("Enter the age you want to set:  ");
            int age = input.nextInt();
            System.out.println();
            
            prSt.setInt(1, age);
            prSt.setInt(2, studid);
 
            int rowAffected = prSt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            System.out.println("\nRecords are updated");
 
            // update another record -reuse the prepared statement
            
 
		}
		catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }		
		
	}
	
	public void deleteRecord()
	{

		String query="Delete from student where studid=3";
		try {
            try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            stmt = con.createStatement();
            
            stmt.executeUpdate(query);
            
            // Take user input for insertion
           
 
            //System.out.println(String.format("Row affected %d", rowAffected));
            System.out.println("\nRecord are deleted");
 
            // update another record -reuse the prepared statement
            
 
		}
		catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }		
	}
	
	 public void retrieveData()
	    {
	    	String query1= "select studid, name, age from student";
	    	
	    	try {     	
	        	try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}  	
	            // opening database connection to MySQL server
	            con = DriverManager.getConnection(url, user, password);

	            // getting Statement object to execute query
	            stmt = con.createStatement();
	    	
	    	rs = stmt.executeQuery(query1); 
	    	
	    	while (rs.next()) 
	    	{ 
	    	   int studid = rs.getInt(1); 
	    	   String name = rs.getString(2); 
	    	   int age = rs.getInt(3); 
	    	   System.out.printf("studid : %d, name: %s, age : %s %n", studid, name, age); 
	    	}
	       }
	    	catch (SQLException sqlEx) {
	            sqlEx.printStackTrace();
	        } finally {
	            //close connection ,stmt and resultset here
	            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
	            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
	            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
	        }
	   }

}

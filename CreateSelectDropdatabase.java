package com.JDBC.Programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class CreateSelectDropdatabase {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/";
	   static final String MDB_URL = "jdbc:mysql://localhost:3306/db_world";  
	   
	   Connection conn;
	    PreparedStatement prSt;
	    Statement stmt;
	    ResultSet rs;

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	   public void createDatabase()
	   {
		
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating database...");
		      stmt = conn.createStatement();
		      
		      String sql = "CREATE DATABASE Owner";
		      stmt.executeUpdate(sql);
		      
		      System.out.println("Database created successfully...");
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   
		}
	   
	   public void selecttable(){ 
		  
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(MDB_URL, USER, PASS);
		      
		      stmt=conn.createStatement();
		      
		      String query="select * from product";
		      rs=stmt.executeQuery(query);
		      
		      System.out.println("\nTable Displayed Successfully");
		      while(rs.next())
		      {
		    	  int prodid = rs.getInt(1); 
		    	   String prodname = rs.getString(2); 
		    	   int price = rs.getInt(3);
		    	   int modelyear=rs.getInt(4);
		    	   System.out.printf("prodid : %d, prodname: %s, price : %d, modelyear: %s %n", prodid, prodname, price, modelyear); 
		      }
		   }
		      
		      catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }
		      
		      
	   }
	   
	   
	   public void dropDatabase()
	   {
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating database...");
		      stmt = conn.createStatement();
		      
		      String sql = "DROP DATABASE Owner";
		      stmt.executeUpdate(sql);
		      
		      System.out.println("Database created successfully...");
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   
		}//end main
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateSelectDropdatabase c1=new CreateSelectDropdatabase();
		Scanner s=new Scanner(System.in);
		boolean flag=true;
		while(flag){
		System.out.println("\n1.Create Database   \n2.Drop Database  \n3.Show table   \n4.exit");
		System.out.println("\nEnter your choice: ");
		int choice=s.nextInt();
		switch(choice){
		case 1:
			c1.createDatabase();
			break;
		
		case 2:
			c1.dropDatabase();
			break;
		
		case 3:	
			c1.selecttable();
			
			break;
			
		case 4:
			System.out.println("\nYou choosed to Exit");
			flag=false;
			break;
		}

	}
	}
}



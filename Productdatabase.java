package com.JDBC.Programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Productdatabase {
	
	private static final String url = "jdbc:mysql://localhost:3306/db_world";
    private static final String user = "root";
    private static final String password = "root";
    
    Connection con;
    PreparedStatement prSt;
    Statement stmt;
    ResultSet rs;
    
	public void retrievedate()
	{
		String query1= "select prodid, prodname, price, modelyear from product";
    	
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
    	   int prodid = rs.getInt(1); 
    	   String prodname = rs.getString(2); 
    	   int price = rs.getInt(3);
    	   int modelyear=rs.getInt(4);
    	   System.out.printf("prodid : %d, prodname: %s, price : %d, modelyear: %s %n", prodid, prodname, price, modelyear); 
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
	
	public void retrieve2()
	{
		String query="Select * from product where prodid=2";
		
		  	
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);
	           
	            
	            
	            // Take user input for insertion
	            Scanner input = new Scanner(System.in);	
	         
	            stmt = con.createStatement();
	            rs=stmt.executeQuery(query);
	            System.out.println("\nRetrieving only 2nd product from the product table");
	            System.out.println();
	            
	            while (rs.next()) {
	               int prodid = rs.getInt("prodid");
	               String prodname = rs.getString("prodname");
	               int price = rs.getInt("price");
	               int modelyear=rs.getInt("modelyear");
	               System.out.println("ProductId: "+prodid + "  "+"ProductName: " + prodname+"  "+"Price: "+price+"  "+" Modelyear: "+modelyear);
	            }    
	            
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Productdatabase p1=new Productdatabase();
		System.out.println("\nRetrieving Product table items");
		System.out.println();
		p1.retrievedate();
		System.out.println();
		p1.retrieve2();

	}

}

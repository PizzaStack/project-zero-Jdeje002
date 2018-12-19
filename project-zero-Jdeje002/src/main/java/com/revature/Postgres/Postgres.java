package com.revature.Postgres;

import java.sql.*;

public class Postgres {
 
	public void start(){
		
		
	 try {
         Class.forName("org.postgresql.Driver");
     }
     catch (java.lang.ClassNotFoundException e) {
         System.out.println(e.getMessage());
     }

     String url = "jdbc:postgresql://baasu.db.elephantsql.com:5432/nxdkszrk";
     String username = "nxdkszrk";
     String password = "gLuT7i1-smGK4dqU-yUcwdZXeHxgarKC";

     try {
         Connection db = DriverManager.getConnection(url, username, password);
         Statement st = db.createStatement();
         ResultSet rs = st.executeQuery("INSERT INTO customer (name, balance, approved) values ('john',100,true)");
         System.out.print("Connected to DB");
         while (rs.next()) {
             System.out.print("Connected to DB");
//             System.out.println(rs.getString(2));
//             System.out.print("Column 2 returned ");
//             System.out.println(rs.getString(3));
         }
         rs.close();
         st.close();
         // needed
         db.close();
         }
     catch (java.sql.SQLException e) {
         System.out.println(e.getMessage());
     }

 }
}

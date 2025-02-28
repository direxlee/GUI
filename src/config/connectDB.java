/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class connectDB {
    
      private Connection connect;
      public connectDB() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdocuments", "root", "");
            
        } catch (SQLException ex) {
        System.out.println("Can't connect to database: "+ex.getMessage());
          
        }
        
    }
       public Connection getConnection() {
        return connect;
    }
       
       
         public int insertData(String sql){
            int result;
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("Inserted Successfully!");
                pst.close();
                result =1;
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
                result =0;
            }
            return result;
        }
         
         
          public ResultSet getData(String sql) {
        ResultSet rst = null;
        try {
            Statement stmt = connect.createStatement();
            rst = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Data Retrieval Error: " + ex.getMessage());
        }
        return rst;
    }
}

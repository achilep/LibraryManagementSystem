/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagementsystem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sagar
 */
public class dbConnectivity {
    static Connection con;

    /**
     * @return 
     * @throws java.io.FileNotFoundException 
     */
    
    public static Connection Connect(){
    String server=null;
    String userName=null;
    String password=null;
    String database=null;
    String port=null;
    File file=new File("dbConnect.txt");
    
        try {//Retrieves The values From Text File And Add Them To these Variables
            Scanner scan = new Scanner(file);
            server=scan.nextLine();
            database=scan.nextLine();
            userName=scan.nextLine();
            password=scan.nextLine();
            port=scan.nextLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(dbConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
        try {
            //Driver Url
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Database Connection Url
            String url="jdbc:sqlserver://"+server+":"+port+";database="+database+";";
            con=DriverManager.getConnection(url, "sa","sa9");
            System.out.println("Connected");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;
    }
    
    
}

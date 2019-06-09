/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcdemmo;

import java.sql.*;
import org.json.JSONObject;

/**
 *
 * @author Alex
 */
public class Jdbcdemmo {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
                
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        
        String user = "igor_auth";
        String pass = "RoGi#@1983";
        /**/
        
        //Connect to my own MySQL DB (empty)
        /*
        String user = "root";
        String pass = "123MySQL!"; /**/

        //[root on Default schema]        
        //jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull
        
        try {  
            
            System.out.println("I'm here");
            //Connect to SkillRankV01 [in Other Sources => default package => application.properties]
            //spring.datasource.url=jdbc:mysql://80.78.255.167:3306/skillrank_auth?useTimezone=true&serverTimezone=UTC&characterEncoding=UTF-8&useUnicode=yes
            //1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://80.78.255.167:3306/skillrank_auth?useTimezone=true&serverTimezone=UTC&characterEncoding=UTF-8&useUnicode=yes", user, pass);
            //MSQL:
                //myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull", user, pass);
            System.out.println("Connection 1: " + myConn.toString());
                //MSQL:returns Connection 1: com.mysql.cj.jdbc.ConnectionImpl@3d1cfad4
            System.out.println(myConn.getClientInfo(pass) + "Connection 2: ");
                //MSQL:returns nullConnection 2:
            System.out.println("Connection 3: " + myConn.getSchema());
                //MSQL:returns Connection 3: null
            
            //2. Create a statement
            myStmt = myConn.createStatement();
            
            //3. Execute SQL query
            myRs = myStmt.executeQuery("select * from jobDescription;");
            //MSQL:
                //myRs = myStmt.executeQuery("select User from mysql.user;");
                //myRs = myStmt.executeQuery("select * from app_jobPosting;");
            
            //4. Process the result set
            Integer i = 0;
            while (myRs.next()) {
                System.out.println(i+=1);
                System.out.println(myRs.getString("id") + " " + myRs.getString("field") + " " + myRs.getString("value"));
                //MSQL:
                    //System.out.println(myRs.getString("User"));
                    //System.out.println(myRs.getString("username") + " " + myRs.getString("field") + " " + myRs.getString("value"));
            }
            
        } catch (SQLException exc) {
        } 
        finally {
            if (myRs != null) {
                myRs.close();
            }
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        }
                
    }
    
    public void jsonConverter() {
        
        JSONObject jo = new JSONObject();
        
    }
    
}

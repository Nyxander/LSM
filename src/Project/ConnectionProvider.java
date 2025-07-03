package Project;
import java.sql.*;
/**
 *
 * @author User
 */
public class ConnectionProvider {
     public static Connection getCon(){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "");
             return con;
                     
             }
         catch(Exception e){
             e.printStackTrace(); 
             return null;
         }
     }
     
     public static void main(String[] args) {
         Connection con = ConnectionProvider.getCon();
         if(con != null){
             System.out.println("Connection established successfully.");
         } else {
             System.out.println("Failed to establish connection.");
         }
     }
}
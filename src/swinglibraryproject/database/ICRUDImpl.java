/*
 * AUTHOR:Odain Bown
 * DATE:11/03/2016
 * THEME:SWING Library SYSTEM
 */
package swinglibraryproject.database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import swinglibraryproject.User;

/**
 *
 * @author Odain
 */
public class ICRUDImpl implements InterfaceCRUD
{

    private Connection connnection;
    
    
    @Override
    public boolean insert(User user)
    {       
        try 
        {
            String Query = "INSERT INTO users values('"+user.getFName()+"','"+user.getLName()+"','"+user.getUsername()+"','"+user.getPassword()+"')";
            Statement statement = this.connnection.createStatement();           
            statement.executeUpdate(Query);
            statement.close();
            
            return true;
            
        }//END OF TRY  
        
        catch (SQLException ex)
        {
           return false;
        }//END OF CATCH
         
    }

    @Override
    public User getUser(String UserName, String Password) 
    {

        try 
        {
            String Query = "SELECT * FROM users where Username ='"+UserName+"' and Password ='"+Password+"'";
            PreparedStatement preparedstatement = this.connnection.prepareStatement(Query);
            ResultSet resultSet = preparedstatement.executeQuery();
            
            User user  = null;
            if(resultSet.next())
            {
                user = new User();
                user.setFName(resultSet.getString("Fname"));
                user.setLName(resultSet.getString("Lname"));
                user.setUsername(resultSet.getString("Username"));
                user.setUsername(resultSet.getString("Password"));
                
            }//END OF IF
            preparedstatement.close();
            resultSet.close();
            
           return user;
            
        }//END OF TRY  
        
        catch (SQLException ex)
        {
          return null;
        }//END OF CATCH        
        
        
    }
    
    
    public void openConnection()
    {
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");//CONNECTS TO THE DRIVER IN THE LIBRARY PACKAGE
            this.connnection =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bt library","root","");
            System.out.println("Connection Established with the Database");     
        }//END OF TRY
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, "ERROR CONNECTNG TO THE DATABASE", "Database Error",JOptionPane.ERROR_MESSAGE );
        }//END OF CATCH
    
    
   }//END OF OPEN CONNECTION METHOD
    
    
}

/*
 * AUTHOR:Odain Bown
 * DATE:08/02/2016
 * THEME:SWING Library SYSTEM
 */
package swinglibraryproject;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import swinglibraryproject.UI.Login;

public class LibraryRun 
{   

 public static void main(String[] args) 
 {   
    
   try
    {
     for(LookAndFeelInfo info:UIManager.getInstalledLookAndFeels())

     if("Nimbus".equals(info.getName()))
      {
        UIManager.setLookAndFeel(info.getClassName());
        break;
      }
    }

    catch(Exception ex)
     {

     } 
     
     try{
          Thread.sleep(6000);
      }
     catch (Exception ex)
       {
                   
        }

      Login login =new Login();
 
      

      /*login.dispose();
      login.setUndecorated(true);
      login.setBackground(new Color(0,255,0,0));*/
      login.setSize(1366,740);
      login.setResizable(false);
      login.setVisible(true);
      login.getContentPane().setBackground(Color.DARK_GRAY);
      //new LibraryMainMenu();//CALL LIBRARYMAIN MENU METHOD
       
    }
    
}

/*
 * AUTHOR:Odain Bown
 * DATE:11/03/2016
 * THEME:SWING Library SYSTEM
 */
package swinglibraryproject.Helper;

import swinglibraryproject.User;
import swinglibraryproject.database.ICRUDImpl;

/**
 *
 * @author Odain
 */
public class Controller 
{//BEGINNING OF CONTROLLER CLASS
    
    
    private static Controller controller;
    private ICRUDImpl iCRUDImpl;
    
    
    private Controller ()
    {
     this.iCRUDImpl = new ICRUDImpl();
     this.iCRUDImpl.openConnection();
    }
    
    public static Controller getController()
    {
        if (controller==null)
        {
            controller = new Controller();
        }
        
        return controller;
    }

    public boolean signup(User user) {
       return this.iCRUDImpl.insert(user);
    }

    public User login(String username, String password)   
    {
      return this.iCRUDImpl.getUser(username, password);
        
    }
    
}//END OF CONTROLLER CLASS

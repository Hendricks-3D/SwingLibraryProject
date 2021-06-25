/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swinglibraryproject.database;

import swinglibraryproject.User;

/**
 *
 * @author Odain
 */
public interface InterfaceCRUD 
{
    boolean insert(User user);
    
    User getUser(String UserName, String Password);
    
}//END OF INTERFACE CRUD 

/*
 * AUTHOR:Odain Bown
 * DATE:11/03/2016
 * THEME:SWING Library SYSTEM
 */
package swinglibraryproject;

/**
 *
 * @author Odain
 */
public class User 
{
    private String FName;
    private String LName;
    public String username;
    private String password;

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString()
    {
        return this.username+", "+this.password;
    }
                    
}//END OF USER CLASS

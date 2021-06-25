 /*
 * AUTHOR:Odain Bown
 * DATE:18/02/2015
 * THEME:Library System
 */

package swinglibraryproject;

/**
 *
 * @author Odain
 */
public class Members 
{ 
  private static String FName, LName, MName;  
  private static String Address,IDNumber;
  private static String Sex;
  private static String Email;
  private static String DOB;
  private static String PFName, PLName, PMName;
  private static String Contact;
  private static String Age;
  private static String memberImage;
  private static String Gender;
  
  public static void setIDNumber(String NewValue)
  {
     IDNumber=NewValue;
  }
  
  public static String getIDNumber()
  {
    return IDNumber;
  }       
  
  public static void setFName(String NewValue)
  {
    FName=NewValue;
  }
  
  public static String getFName()
  {
    return FName;
  }
  
   public static void setLName(String NewValue)
  {
    LName=NewValue;
  }
  
  public static String getLName()
  {
    return LName;
  } 
  
  public static void setMName(String NewValue)
  {
    MName=NewValue;
  }
  
  public static String getMName()
  {
    return MName;
  }
  
  public static void setPFName(String NewValue)
  {
    PFName=NewValue;
  }
  
  public static String getPFName()
  {
    return PFName;
  }

  public static void setPLName(String NewValue)
  {
    PLName=NewValue;
  }
  
  public static String getPLName()
  {
    return PLName;
  }
  
  public static void setPMName(String NewValue)
  {
    PMName=NewValue;
  }
  
  public static String getPMName()
  {
    return PMName;  
  }
  
  public static void setAddress(String NewValue)
  {
    Address=NewValue;
  }
  
  public static String getAddress()
  {
    return Address;  
  }
 
  public static void setDOB(String NewValue)
  {
    DOB=NewValue;
  }
  
  public static String getDOB()
  {
    return DOB;  
  }
    
 public static void setSex(String NewValue)
 {
   Sex=NewValue;
 }

 public static String getSex()
 {
   return Sex;  
 }
 
 public static void setContact(String NewValue)
 {
  Contact=NewValue;
 }
 
 public static String getContact()
 {
   return Contact;
 }       
    
 public static void setAge(String NewValue)
 {
   Age=NewValue;
 }
  
 public static String getAge()
 {
   return Age;
 }       
  
  public static void setEmail(String NewValue)
 {
   Email=NewValue;
 }
  
 public static String getEmail()
 {
   return Email;
 }       
  
  public static void setmemberImage(String NewValue)
 {
   memberImage=NewValue;
 }
  
 public static String getmemberImage()
 {
   return memberImage;
 }    


   public static void setGender(String NewValue)
 {
   Gender=NewValue;
 }
  
 public static String getGender()
 {
   return Gender;
 } 
 
 
 
}//END OF MEMBER CLASS
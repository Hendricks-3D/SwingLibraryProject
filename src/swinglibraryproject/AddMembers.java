 /*
 * AUTHOR:Odain Bown
 * DATE:18/02/2016
 * THEME:Library System
 */
package swinglibraryproject;

import com.mysql.jdbc.Connection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Odain
 */
public class AddMembers extends JFrame
{//BEGINNING OF ADD BOOK CLASS
   JFrame WinFrame;
   JTextField txtFName, txtLName, txtMName;
   JTextField txtAddress;
   JTextField txtIDNumber;
   JTextField txtSex,txtAge;
   JTextField txtDOB;
   JTextField txtEmail;
   JTextField txtPFName, txtPMName, txtPLName;
   JTextField txtContact1, txtcontact2;
   JLabel lbl_FName,lbl_MName, lbl_LName;
   JLabel lbl_Address;
   JLabel lbl_IDNumber;
   JLabel lbl_Sex,lbl_Age;
   JLabel lbl_DOB,head;
   JLabel lbl_Email,label;
   JLabel lbl_PFName,lbl_PMName,lbl_PLName;
   JLabel lbl_Contact1, lbl_Contact2;
   JComboBox Cmb_sex;
   JButton Browse;
   String s;
   String  memberImage;
   JButton btnSave,btnClose,btnClear,btnNew;
   Border border;
   
   Font font;
   FlowLayout layout;
   String [] sex={"","MALE","FEMALE"}; 
   
   Members member = new Members();
   
  public AddMembers()
  {//BEGINNING OF ADDMEMBERS METHOD
//=======================JFRAME PROPERTIES======================================      
   WinFrame= new JFrame("ADD-MEMBERS");
   WinFrame.setLayout(layout);
   WinFrame.setLocation(200,50);  
   WinFrame.setSize(1000,700);
   WinFrame.setResizable(false);
   WinFrame.setVisible(true);
   WinFrame.getContentPane().setBackground(Color.DARK_GRAY);

//FONT
font = new Font("Times New Roman",Font.BOLD,12);
//BORDER
border = BorderFactory.createLineBorder(Color.BLACK, 1,true);

//=======================ADDIND THE HEADING TEXT================================ 
    head=new JLabel("ADD A NEW MEMBER");
    head.setForeground(Color.WHITE);//SET TEXT COLOR
    head.setFont(new Font("BatmanForeverAlternate",Font.BOLD,25));
    head.setBounds(270,25,370,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
    WinFrame.add(head);   
   
    
//============================ADDING JLABELS====================================
   lbl_IDNumber=new JLabel("IDENTIFICATION NO.");
   lbl_IDNumber.setFont(font);
   lbl_IDNumber.setForeground(Color.WHITE);
   lbl_IDNumber.setBounds(30,120,190,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)      
   WinFrame.add(lbl_IDNumber);  
   
   lbl_FName=new JLabel("FIRST NAME");
   lbl_FName.setFont(font);
   lbl_FName.setForeground(Color.WHITE);
   lbl_FName.setBounds(30,170,100,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(lbl_FName);
   
   lbl_MName=new JLabel("MIDDLE NAME");
   lbl_MName.setFont(font);
   lbl_MName.setForeground(Color.WHITE);
   lbl_MName.setBounds(30,220,100,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(lbl_MName);

   lbl_LName=new JLabel("LAST NAME");
   lbl_LName.setFont(font);
   lbl_LName.setForeground(Color.WHITE);
   lbl_LName.setBounds(30,270,100,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(lbl_LName);   
   
   
   lbl_Contact1=new JLabel("CONTACT NO.");
   lbl_Contact1.setFont(font);
   lbl_Contact1.setForeground(Color.WHITE);
   lbl_Contact1.setBounds(30,320,100,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(lbl_Contact1); 
   
   lbl_Address=new JLabel("ADDRESS.");
   lbl_Address.setFont(font);
   lbl_Address.setForeground(Color.WHITE);
   lbl_Address.setBounds(30,370,100,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(lbl_Address);   
   
   
   lbl_Age=new JLabel("AGE.");
   lbl_Age.setFont(font);
   lbl_Age.setForeground(Color.WHITE);
   lbl_Age.setBounds(30,420,100,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(lbl_Age);      
   
   lbl_DOB=new JLabel("DOB DOB [YYYY-MM-DD]");
   lbl_DOB.setFont(font);
   lbl_DOB.setForeground(Color.WHITE);
   lbl_DOB.setBounds(30,470,150,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(lbl_DOB);
   
   lbl_Email=new JLabel("EMAIL.");
   lbl_Email.setFont(font);
   lbl_Email.setForeground(Color.WHITE);
   lbl_Email.setBounds(30,520,100,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(lbl_Email);     
 
   lbl_Sex=new JLabel("GENDER");
   lbl_Sex.setFont(font);
   lbl_Sex.setForeground(Color.WHITE);
   lbl_Sex.setBounds(30,570,100,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(lbl_Sex); 
   
   lbl_PFName=new JLabel("PARENT FIRST NAME ");
   lbl_PFName.setFont(font);
   lbl_PFName.setForeground(Color.WHITE);
   lbl_PFName.setBounds(370,120,150,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(lbl_PFName);              
           
   lbl_PMName=new JLabel("PARENT MIDDLE NAME ");
   lbl_PMName.setFont(font);
   lbl_PMName.setForeground(Color.WHITE);
   lbl_PMName.setBounds(370,170,150,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(lbl_PMName);  
   
   lbl_PLName=new JLabel("PARENT LAST NAME ");
   lbl_PLName.setFont(font);
   lbl_PLName.setForeground(Color.WHITE);
   lbl_PLName.setBounds(370,220,150,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(lbl_PLName); 
   
   
   
   
   //LABEL THAT CONTROLS THE MEMBER'S IMAGE
    label = new JLabel();
    label.setBorder(border);
    label.setBounds(560,290,200,150);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
     WinFrame.add(label); 
     
     
     
//==========================ADDING JTEXTFIELDS==================================

   txtIDNumber=new JTextField();
   txtIDNumber.setToolTipText("Enter ID Number");
   txtIDNumber.setBounds(170,120,70,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(txtIDNumber);
   
   txtFName=new JTextField();
   txtFName.setToolTipText("Enter member's first name");
   txtFName.setBounds(170,170,150,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(txtFName);
   
   txtMName=new JTextField();
   txtMName.setToolTipText("Enter member's middle name");
   txtMName.setBounds(170,220,150,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(txtMName);  
   
   txtLName=new JTextField();
   txtLName.setToolTipText("Enter member's last name");
   txtLName.setBounds(170,270,150,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(txtLName); 
   
   txtContact1=new JTextField();
   txtContact1.setToolTipText("Enter member's contact no.");
   txtContact1.setBounds(170,320,150,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(txtContact1); 

   txtAddress=new JTextField();
   txtAddress.setToolTipText("Enter member's address");
   txtAddress.setBounds(170,370,200,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(txtAddress); 

   txtAge=new JTextField();
   txtAge.setToolTipText("Enter member's age");
   txtAge.setBounds(170,420,50,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(txtAge);  
   
   txtDOB=new JTextField();
   txtDOB.setToolTipText("Enter member'D.O.B");
   txtDOB.setBounds(170,470,150,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(txtDOB); 
   
   txtEmail=new JTextField();
   txtEmail.setToolTipText("Enter member's email");
   txtEmail.setBounds(170,520,300,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(txtEmail);
   
   txtPFName=new JTextField();
   txtPFName.setToolTipText("Enter member's parent first name");
   txtPFName.setBounds(550,120,150,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(txtPFName);
   
   txtPMName=new JTextField();
   txtPMName.setToolTipText("Enter member's parent middle name");
   txtPMName.setBounds(550,170,150,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(txtPMName);
   
   txtPLName=new JTextField();
   txtPLName.setToolTipText("Enter member's parent last name");
   txtPLName.setBounds(550,220,150,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(txtPLName);
   
   Cmb_sex = new JComboBox(sex);
   Cmb_sex .setBounds(170,570,90,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
   WinFrame.add(Cmb_sex);
   
//======================ADDING JBUTTONS===================================
    Browse=new JButton("BROWSE");
    Browse.setBounds(600,450,90,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
    Browse.setForeground(Color.WHITE);
    Browse.setBackground(Color.DARK_GRAY);
    WinFrame.add(Browse);

    btnSave=new JButton("SAVE",new ImageIcon("images\\Save-Icon.png"));
    btnSave.setBounds(800,400,90,30);
    btnSave.setForeground(Color.WHITE);
    btnSave.setBackground(Color.DARK_GRAY);
    WinFrame.add(btnSave);

    
    btnClear=new JButton("CLEAR",new ImageIcon("images\\Clear-icon.png"));
    btnClear.setBounds(800,440,90,30);
    btnClear.setForeground(Color.WHITE);
    btnClear.setBackground(Color.DARK_GRAY);
    WinFrame.add(btnClear);  
    
    btnClose=new JButton("CLOSE",new ImageIcon("images\\Close-Icon.png"));
    btnClose.setBounds(800,480,90,30);
    btnClose.setBackground(Color.DARK_GRAY);
    btnClose.setForeground(Color.WHITE);
    WinFrame.add(btnClose); 
    
    
   //==============================BROWSE BUTTON=============================== 
    Browse.addActionListener(new ActionListener(){
        @Override public void actionPerformed(ActionEvent e)
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
            fileChooser.addChoosableFileFilter(filter); int result = fileChooser.showSaveDialog(null);
            if(result == JFileChooser.APPROVE_OPTION)
            {
             File selectedFile = fileChooser.getSelectedFile(); 
             String path = selectedFile.getAbsolutePath(); 
             label.setIcon(ResizeImage(path)); 
             s = path; 
            }
            else if(result == JFileChooser.CANCEL_OPTION)
            {
                JOptionPane.showMessageDialog(null,"YOU DID'NT CHOOSE AN IMAGE","CHOOSE IMAGE",JOptionPane.WARNING_MESSAGE);
            } 
        } 
        }); //END OF BROWSE ACTION LISTENER 

 //===============================SAVE BUTTON====================================    
     btnSave.addActionListener ( new ActionListener()
      { 
        private Connection connnection;
        public void actionPerformed(ActionEvent e)
         {  
          if(signIsValid()==true)
           {
            member.setIDNumber(txtIDNumber.getText());
            member.setFName(txtFName.getText());
            member.setMName(txtMName.getText());
            member.setLName(txtLName.getText());
            member.setAddress(txtAddress.getText());
            member.setEmail(txtEmail.getText());
            member.setDOB(txtDOB.getText());
            member.setContact(txtContact1.getText());
            member.setPFName(txtPFName.getText());
            member.setPLName(txtPFName.getText());
            member.setPMName(txtPFName.getText());
            member.setAge(txtAge.getText());
            member.setGender((String)Cmb_sex.getSelectedItem());
           //member.setSex((String)Cmb_sex.getSelectedItem());
           
            
            
            JOptionPane.showMessageDialog(null,"NEW MEMBER ADDED.", "SAVING",JOptionPane.INFORMATION_MESSAGE);
            
        try{ 
             
           //=========ADDING THE DATA TO THE DATA BASE===========
           
            
            Class.forName("com.mysql.jdbc.Driver");//CONNECTS TO THE DRIVER IN THE LIBRARY PACKAGE
            this.connnection =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bt library","root","");
             
           String query = "INSERT INTO member values('"+member.getIDNumber()+"','"+member.getFName()+"','"+member.getMName()+"','"+member.getLName()+"','"+member.getContact()+"','"+member.getAddress()+"','"+member.getAge()+"','"+member.getDOB()+"','"+member.getEmail()+"','"+member.getPFName()+"','"+member.getPMName()+"','"+member.getPLName()+"','"+s+"','"+member.getGender()+"')";
           Statement statement = this.connnection.createStatement();
           statement.executeUpdate(query);
           statement.close();
           
            InputStream is = new FileInputStream(new File(s));
           PreparedStatement ps = connnection.prepareStatement(query);
           
           
            }//END OF TRY           
            catch(Exception ex){ ex.printStackTrace(); } 
           }// END OF IF 
       else
        {
          JOptionPane.showMessageDialog(null,"ALL FIELDS MUST BE FILLED!","Check the form again.",JOptionPane.WARNING_MESSAGE);
        }        
         }//END OF ACTION PERFORMED//END OF ACTION PERFORMED//END OF ACTION PERFORMED//END OF ACTION PERFORMED
          
      }//END OF ACTION LISTENER
     );//END OF ADD ACTION LISTENER
     
  
  
  //================================CLOSE BUTTON================================
    btnClose.addActionListener ( new ActionListener()
      {  
        public void actionPerformed(ActionEvent e)
         { 
           WinFrame.dispose();//REMOVE THE WINFRAME ON CLICK
         }

       }
    );//END OF ACTIONLISTNER
    
    
    
  //================================CLOSE BUTTON================================
    btnClear.addActionListener ( new ActionListener()
      {  
        public void actionPerformed(ActionEvent e)
         { 
            txtIDNumber.setText("");
            txtFName.setText("");
            txtLName.setText("");
            txtMName.setText("");
            txtAddress.setText("");
            txtIDNumber.setText("");
            txtAge.setText("");
            txtDOB.setText("");
            txtEmail.setText("");
            txtPFName.setText(""); txtPMName.setText("");
            txtPLName.setText("");
            txtContact1.setText("");
            Cmb_sex.setSelectedItem("");         
         }

       }
    );//END OF ACTIONLISTNER    
    
    
   }//END OF ADDMEMBERS METHOD 
    
  //METHOD THAT ENSURES THAT EACH FIELD IS NOT EMPTY
        private boolean signIsValid() {
           
        if (!this.txtFName.getText().isEmpty()==true||!this.txtMName.getText().isEmpty()==true||!this.txtMName.getText().isEmpty()==true||!this.txtPFName.getText().isEmpty()==true
            ||!this.txtPMName.getText().isEmpty()==true ||!this.txtIDNumber.getText().isEmpty()||!this.txtDOB.getText().isEmpty()==true||!this.txtEmail.getText().isEmpty()==true
            ||!this.txtPLName.getText().isEmpty()==true||!this.txtAddress.getText().isEmpty()==true)
        {
          return true;
        }
        else 
         {
          return false;
        }
     }//END OF SIGNISVALID METHOD  

  //======================METHOD TO RESIZE  IMAGEICON=================
  public ImageIcon ResizeImage(String imgPath)
  { 
      ImageIcon MyImage = new ImageIcon(imgPath); 
      Image img = MyImage.getImage();
      Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
      ImageIcon image = new ImageIcon(newImage);
      return image; 
  } 
   
}//END OF ADDMEMBERS CLASS

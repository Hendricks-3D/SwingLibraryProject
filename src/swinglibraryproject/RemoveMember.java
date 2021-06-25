 /*
 * AUTHOR:Odain Bown
 * DATE:03/03/2015
 * THEME:Library System
 */
package swinglibraryproject;

import com.mysql.jdbc.Connection;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.DriverManager;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;



public class RemoveMember 
{//BEGINNINH OF REMOVE MEMBER CLASS
    
    JFrame WinFrame;
    JLabel lbl_FName,lbl_MName,lbl_LName,lbl_IDNumber,head, lbl_Sex;
    JButton btnDelete,btnClose,btnSearch;
    JTextField txtFName,txtMName,txtLName,txtIDNumber,txtSex;
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet resultSet;
    FlowLayout FL;
    JLabel label;
    Font font;
    DefaultTableModel model = new DefaultTableModel();
    JTable table;
    JScrollPane scrlPane;
    int r = 0;
    int foundbook =0;   
    Border border;
    
    
    Members member = new Members();
    
    public RemoveMember()
    {//BEGINNING OF REMOVE METHOD
        
     WinFrame = new JFrame("REMOVE MEMBER");
     WinFrame.setLayout(FL);
     WinFrame.setSize(1000,650);
     WinFrame.setLocation(150,50);
     WinFrame.setResizable(false);
     WinFrame.setVisible(true);
     WinFrame.getContentPane().setBackground(java.awt.Color.darkGray);
      
     font = new Font("Times New Roman",Font.BOLD,12);
     border = BorderFactory.createLineBorder(java.awt.Color.BLACK, 1,true);  
    //=======================ADDIND THE HEADING TEXT============================ 
     head=new JLabel("REMOVE MEMBERS");
     head.setForeground(Color.WHITE);//SET TEXT COLOR
     head.setFont(new Font("BatmanForeverAlternate",Font.BOLD,25));
     head.setBounds(300,25,400,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
     WinFrame.add(head);  
        
    //============================ADDING JlABEL=================================
     lbl_IDNumber = new JLabel("SELECT BY ID NUMBER:");
     lbl_IDNumber.setForeground(Color.WHITE);
     lbl_IDNumber.setFont(font);
     lbl_IDNumber.setBounds(50,120,240,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     WinFrame.add(lbl_IDNumber); 
    
     lbl_FName = new JLabel("SELECT FIRST NAME:");
     lbl_FName.setFont(font);
     lbl_FName.setForeground(Color.WHITE);
     lbl_FName.setFont(font);
     lbl_FName.setBounds(50,170,240,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     WinFrame.add(lbl_FName);
        
     
     lbl_LName = new JLabel("SELECT BY LAST NAME:");
     lbl_LName.setForeground(Color.WHITE);
     lbl_LName.setFont(font);
     lbl_LName.setBounds(50,220,240,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     WinFrame.add(lbl_LName);
     
     lbl_MName = new JLabel("SELECT BY MIDDLE NAME:");
     lbl_MName.setForeground(Color.WHITE);
     lbl_MName.setFont(font);
     lbl_MName.setBounds(50,270,240,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     WinFrame.add(lbl_MName);   
     
     
    //LABEL THAT CONTROLS THE MEMBER'S IMAGE
     label = new JLabel();
     label.setBorder(border);
     label.setBounds(100,360,200,150);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
     WinFrame.add(label); 
    
     JLabel ImageTxt = new JLabel("MEMBER IMAGE");
     ImageTxt.setForeground(Color.WHITE);
     ImageTxt.setFont(font);
     ImageTxt.setBounds(150,520,190,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     WinFrame.add(ImageTxt);  
     
     
    //=======================ADDING JTEXTFIELD==================================
     txtIDNumber = new JTextField();
     txtIDNumber.setBounds(200,120,70,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     txtIDNumber.setToolTipText("member ID number");
     WinFrame.add(txtIDNumber);    

     txtFName = new JTextField();
     txtFName.setBounds(200,170,190,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     txtFName.setToolTipText(" member first name");
     WinFrame.add(txtFName);

     txtLName = new JTextField();
     txtLName.setBounds(200,220,190,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     txtLName.setToolTipText(" member last name");
     WinFrame.add(txtLName);  
     
     txtMName = new JTextField();
     txtMName.setBounds(200,290,190,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     txtMName.setToolTipText(" middle name");
     WinFrame.add(txtMName);   
 
    
    //=====================CREATING THE TABLE AND COLUMN========================
     table = new JTable(model);
     table.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);    
     table.setPreferredScrollableViewportSize(new Dimension(880,50));
     table.setFillsViewportHeight(true);
     table.setForeground(Color.BLUE);
     
     scrlPane = new JScrollPane(table);
     scrlPane.setBounds(400,100,590,310);    
     scrlPane.setVisible(true);
     WinFrame.add(scrlPane);
    
     table.setFont(new Font ("Times New Roman",0,15));
    //TABLE HEADINGS
     model.addColumn("ID");
     model.addColumn("FIRST NAME");
     model.addColumn("LAST NAME");
     model.addColumn("MIDDLE NAME");
     model.addColumn("AGE");
     model.addColumn("SEX");
     model.addColumn("PARENT");

    //================================ADDING JBUTTONS===========================
     btnClose=new JButton("CLOSE",new ImageIcon("images\\Close-Icon.png"));
     btnClose.setBounds(600,500,90,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     btnClose.setBackground(Color.DARK_GRAY);
     btnClose.setForeground(Color.WHITE);
     WinFrame.add(btnClose);     
     
    btnDelete=new JButton("DELETE",new ImageIcon("images\\Close-Icon.png"));
    btnDelete.setBounds(700,500,90,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
    btnDelete.setBackground(Color.DARK_GRAY);
    btnDelete.setForeground(Color.WHITE);
    WinFrame.add(btnDelete); 
     
    btnSearch=new JButton("SELECT",new ImageIcon("images\\search.png"));
    btnSearch.setBounds(470,500,120,30);
    btnSearch.setForeground(Color.WHITE);
    btnSearch.setBackground(Color.DARK_GRAY);
    WinFrame.add(btnSearch);  
     
//===============================SEARCH BUTTON==================================     
    btnSearch.addActionListener (new ActionListener()
    {
       private Connection connnection;
       byte[] imgData = null;
       
      public void actionPerformed(ActionEvent ae)
      {
          String image;
          Blob blobImage,blob = null;
       
          try
         {
           Class.forName("com.mysql.jdbc.Driver");//CONNECTS TO THE DRIVER IN THE LIBRARY PACKAGE
           this.connnection =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bt library","root","");
           
           preparedStatement=connnection.prepareStatement("select * from member where FName='"+txtFName.getText()+"' or IDNumber='"+txtIDNumber.getText()+"'or LName='"+txtLName.getText()+"'or MName='"+txtMName.getText()+"'");
           resultSet=preparedStatement.executeQuery();
           
           while(resultSet.next())
           {
            member.setIDNumber(resultSet.getString("IDNumber"));
            member.setFName(resultSet.getString("FName"));
            member.setLName(resultSet.getString("LName"));
            member.setMName(resultSet.getString("MName")); 
            member.setAddress(resultSet.getString("Address"));
            member.setAge(resultSet.getString("Age"));
            member.setDOB(resultSet.getString("DOB"));             
            member.setContact(resultSet.getString("Contact No."));           
            member.setGender(resultSet.getString("Gender"));
           // member.setmemberImage(resultSet.getString("Image"));
          //blobImage = resultSet.getBlob("Image");
            
            model.insertRow(0,new Object[]
            {
                resultSet.getString("IDNumber"),
                resultSet.getString("FName"),resultSet.getString("LName"),
                resultSet.getString("MName"),resultSet.getString("Age"),
                resultSet.getString("Gender"),resultSet.getString("PFName") 
            });
            
        //RETRIEVE IMAGE FROM DATA BASE AND ADD TO A JLABEL
            Blob img  = resultSet.getBlob(13);//13th COLUMN
            InputStream in = img.getBinaryStream(1,img.length());            
            BufferedImage bufImg = ImageIO.read(in);
             label.setIcon(ResizeImage(bufImg));//CHANGE THE SIZE OF THE IMAGE WHEN DISPLAYING IT     
            
        //NOT WORKING   
                    
            foundbook=1;
           
           }//END OF WHILE
          
           if(foundbook==0)
           {
               JOptionPane.showMessageDialog(null,"THE PERSON YOU ARE SELECTING IS NOT A MEMBER","NOT FOUND",JOptionPane.WARNING_MESSAGE);
           }
 
           
         }//END OF TRY
        catch(Exception e)
         {
           System.err.println("ERROR!!"+ e.getMessage());
          }//END OF CATCH
  
       }//END OF ACTIONPERFORMED
    }//END OF ACTION LISTENER
    
    );
             
   //================================CLOSE BUTTON================================
    btnClose.addActionListener ( new ActionListener()
      {  
        public void actionPerformed(ActionEvent e)
         { 
           WinFrame.dispose();//REMOVE THE WINFRAME ON CLICK
         }

       }
    );//END OF ACTIONLISTNER    

    
    btnDelete.addActionListener (new ActionListener() 
    {
        private Connection connnection;
        
      public void actionPerformed(ActionEvent ae)
      {
          try {
           Class.forName("com.mysql.jdbc.Driver");//CONNECTS TO THE DRIVER IN THE LIBRARY PACKAGE
           this.connnection =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bt library","root","");
           
           preparedStatement=connnection.prepareStatement("delete from bt library.members where FName='"+txtFName.getText()+"' or IDNumber='"+txtIDNumber.getText()+"'or LName='"+txtLName.getText()+"'or MName='"+txtMName.getText()+"'");
           resultSet=preparedStatement.executeQuery();         
           
           JOptionPane.showMessageDialog(null,"MEMBER DELETED","DELETED",JOptionPane.INFORMATION_MESSAGE);
           
           
          }
          
          
          catch( Exception e)
          {
             System.err.println("ERROR DELETING!!");
          }
      }//END OF ACTION PERFORMED
    });//END OF ACTION LISTENER
   
    }//END OF REMOVEMEMBER METHOD
    
    
     public ImageIcon ResizeImage(BufferedImage bufImg)
  { 
      ImageIcon MyImage = new ImageIcon(bufImg); 
      Image img = MyImage.getImage();
      Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
      ImageIcon image = new ImageIcon(newImage);
      return image; 
  } 
    
}//END OF REMOVE MEMBER CLASS

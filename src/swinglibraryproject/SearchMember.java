/*
 * AUTHOR:Odain Bown
 * DATE: 29/02/2016
 * THEME:SWING Library SYSTEM
 */

package swinglibraryproject;

import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class SearchMember
{
    JFrame WinFrame;
    JLabel lbl_FName,lbl_MName,lbl_LName,lbl_IDNumber,head;
    JButton btnSearch,btnClear,btnClose,btnAll;
    JTextField txtFName,txtMName,txtLName,txtIDNumber;
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
    
    public SearchMember()
    {//BEGINNING OF SEARCH MEMBER METHOD
       WinFrame = new JFrame("Search Members");
       WinFrame.setLayout(FL);
       WinFrame.setSize(1000,690);
       WinFrame.setLocation(200,50);
       WinFrame.setResizable(false);
       WinFrame.setVisible(true);
       WinFrame.getContentPane().setBackground(Color.DARK_GRAY);
      
       font = new Font("Times New Roman",Font.BOLD,12);
       border = BorderFactory.createLineBorder(Color.BLACK, 1,true);  
     //=======================ADDIND THE HEADING TEXT============================ 
     head=new JLabel("SEARCH FOR MEMBERS");
     head.setForeground(Color.WHITE);//SET TEXT COLOR
     head.setFont(new Font("BatmanForeverAlternate",Font.BOLD,25));
     head.setBounds(280,25,400,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
     WinFrame.add(head); 
     
     
     //==========================ADDING JLABELS TO WINDOW========================
     lbl_FName = new JLabel("SEARCH BY FIRST NAME:");
     lbl_FName.setForeground(Color.WHITE);
     lbl_FName.setFont(font);
     lbl_FName.setBounds(50,120,190,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     WinFrame.add(lbl_FName);
     
     lbl_LName = new JLabel("SEARCH BY LAST NAME:");
     lbl_LName.setForeground(Color.WHITE);
     lbl_LName.setFont(font);
     lbl_LName.setBounds(50,170,190,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     WinFrame.add(lbl_LName);
     
     lbl_MName = new JLabel("SEARCH BY MIDDLE NAME:");
     lbl_MName.setForeground(Color.WHITE);
     lbl_MName.setFont(font);
     lbl_MName.setBounds(50,220,190,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     WinFrame.add(lbl_MName);   
   
     
     lbl_IDNumber = new JLabel("SEARCH BY REFERENCE NUMBER:");
     lbl_IDNumber.setForeground(Color.WHITE);
     lbl_IDNumber.setFont(font);
     lbl_IDNumber.setBounds(50,270,210,20);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     WinFrame.add(lbl_IDNumber);  
    
     
    //======================ADDING JTEXTFIELD==================================
     txtFName = new JTextField();
     txtFName.setBounds(230,120,190,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     txtFName.setToolTipText("Enter the member first name");
     WinFrame.add(txtFName);

     txtLName = new JTextField();
     txtLName.setBounds(230,170,190,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     txtLName.setToolTipText("Enter the member last name");
     WinFrame.add(txtLName);  
     
     txtMName = new JTextField();
     txtMName.setBounds(230,220,190,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     txtMName.setToolTipText("Enter the member middle name");
     WinFrame.add(txtMName);       
 
     txtIDNumber = new JTextField();
     txtIDNumber.setBounds(270,270,50,30);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT) 
     txtIDNumber.setToolTipText("Enter the member ID number");
     WinFrame.add(txtIDNumber);    
     
 //======================ADDING JBUTTONS==================================
    btnSearch=new JButton("SEARCH",new ImageIcon("images\\search.png"));
    btnSearch.setBounds(720,270,120,30);
    btnSearch.setForeground(Color.WHITE);
    btnSearch.setBackground(Color.DARK_GRAY);
    WinFrame.add(btnSearch);
   
    btnClose=new JButton("CLOSE",new ImageIcon("images\\Close-Icon.png"));
    btnClose.setBounds(850,270,90,30);
    btnClose.setBackground(Color.DARK_GRAY);
    btnClose.setForeground(Color.WHITE);
    WinFrame.add(btnClose); 
    
    btnAll=new JButton("ALL",new ImageIcon("images\\Search.png"));
    btnAll.setBounds(850,230,90,30);
    btnAll.setBackground(Color.DARK_GRAY);
    btnAll.setForeground(Color.WHITE);
    WinFrame.add(btnAll); 
               
   
     //LABEL THAT CONTROLS THE MEMBER'S IMAGE
    label = new JLabel();
    label.setBorder(border);
    label.setBounds(490,150,200,150);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
     WinFrame.add(label); 
    
  //=====================CREATING THE TABLE AND COLUMN========================
    table = new JTable(model);
    table.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);    
    table.setPreferredScrollableViewportSize(new Dimension(880,50));
    table.setFillsViewportHeight(true);
    table.setForeground(Color.BLUE);
    
    scrlPane = new JScrollPane(table);
    scrlPane.setBounds(0,350,1000,310);    
    scrlPane.setVisible(true);
    WinFrame.add(scrlPane);
    
     table.setFont(new Font ("Times New Roman",0,15));
 //TABLE HEADINGS
    model.addColumn("ID");
    model.addColumn("FIRST NAME");
    model.addColumn("LAST NAME");
    model.addColumn("MIDDLE NAME");
    model.addColumn("ADDRESS");
    model.addColumn("AGE");
    model.addColumn("DOB");
    model.addColumn("CONTACT");
    model.addColumn("PARENT F-NAME");
    model.addColumn("EMAIL");
    
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
            member.setEmail(resultSet.getString("Email"));
            member.setmemberImage(resultSet.getString("Image"));
            //blobImage = resultSet.getBlob("Image");
            
            model.insertRow(0,new Object[]{resultSet.getString("IDNumber"),resultSet.getString("FName"),resultSet.getString("LName"),resultSet.getString("MName"),resultSet.getString("Address"),resultSet.getString("Age"),resultSet.getString("DOB"),resultSet.getString("Contact NO."),resultSet.getString("PFName"),resultSet.getString("Email") });
            
            
        //RETRIEVE IMAGE FROM DATA BASE AND ADD TO A JLABEL
            Blob img  = resultSet.getBlob(13);//13th COLUMN
            InputStream in = img.getBinaryStream(1,img.length());            
            BufferedImage bufImg = ImageIO.read(in);
            //label.setIcon(new ImageIcon(bufImg));        
            label.setIcon(ResizeImage(bufImg));//CHANGE THE SIZE OF THE IMAGE WHEN DISPLAYING IT    
        

                    
            foundbook=1;
           
           }//END OF WHILE
          
           if(foundbook==0)
           {
               JOptionPane.showMessageDialog(null,"THE PERSON YOU ARE SEARCHING FOR IS NOT A MEMBER","NOT FOUND",JOptionPane.WARNING_MESSAGE);
           }
 
           
         }//END OF TRY
        catch(Exception e)
         {
           System.err.println("ERROR!!"+ e.getMessage());
          }//END OF CATCH
  
       }//END OF ACTIONPERFORMED
    }//END OF ACTION LISTENER
    
    );
        
     
 //================================BUTTON ALL=================================== 
    btnAll.addActionListener (new ActionListener()
    {
       private Connection connnection;
       
      public void actionPerformed(ActionEvent ae)
      {
        try
         {
           Class.forName("com.mysql.jdbc.Driver");//CONNECTS TO THE DRIVER IN THE LIBRARY PACKAGE
           this.connnection =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/bt library","root","");

           preparedStatement=connnection.prepareStatement("select * from member");
           resultSet=preparedStatement.executeQuery();
           
           while(resultSet.next())
           {
            model.insertRow(r++, new Object[]{resultSet.getString("IDNumber"),resultSet.getString("FName"),resultSet.getString("LName"),resultSet.getString("MName"),resultSet.getString("ADDRESS"),resultSet.getString("AGE"),resultSet.getString("DOB"),resultSet.getString("Contact No."),resultSet.getString("PFName"),resultSet.getString("EMAIL") });
            foundbook=1;
           }//END OF WHILE
          
          if(foundbook==0)
           {
               JOptionPane.showMessageDialog(null,"THE BOOK YOU ARE SEARCHING FOR IS NOT AVAILABLE","NOT FOUND",JOptionPane.WARNING_MESSAGE);
           }         
           
         }//END OF TRY
        catch(Exception e)
         {
           System.err.println("ERROR!!"+ e.getMessage());
          }//END OC CATCH
        
        
        
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
    }//END OF SEARCH MEMBER METHOD
    
  public ImageIcon ResizeImage(BufferedImage bufImg)
  { 
      ImageIcon MyImage = new ImageIcon(bufImg); 
      Image img = MyImage.getImage();
      Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
      ImageIcon image = new ImageIcon(newImage);
      return image; 
  } 
}//END OF SEARCH MEMBER CLASS

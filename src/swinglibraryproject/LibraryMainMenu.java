/*
 * AUTHOR:Odain Bown
 * DATE:08/02/2016
 * THEME:SWING Library SYSTEM
 */
package swinglibraryproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import swinglibraryproject.UI.Login;

public class LibraryMainMenu extends JFrame implements ActionListener
{
    //DECLARATION OF VARIABLE
   JFrame WindowFrame;
   JMenuBar MBar;
   JMenu menu_1, menu_2,menu_3,menu_4,menu_5,menu_6,menu_7;
   JMenuItem mItem1_1,mItem1_2,mItem1_3,mItem2_1,mItem2_2,mItem2_3,mItem3_1,mItem3_2,mItem3_3,mItem4_1,mItem5_1,mItem6_1;
   JMenuItem mItem7_1,mItem7_2,mItem7_3;
   JLabel label,logo, txtlogout,txtuser;
   JButton btnLogout;
   FlowLayout FL;
   private ImageIcon image;
   private JLabel JL;
   JLabel txtusername, txtcurrentuser;
           
   User user = new User();
   
   public LibraryMainMenu()
   {      
       
     WindowFrame = new JFrame();//CREATING NEW FRAME
     FL=new FlowLayout();
     WindowFrame.setLayout(null);
     //ADD IMAGE TO THE WINDOW
    image = new ImageIcon(getClass().getResource("librarylogo6.jpg"));
    JL= new JLabel(image);
    JL.setBounds(428,100,511,561);
    WindowFrame.add(JL);
     
    /*label=new JLabel("WELCOME TO THE BROWN'S TOWN BRANCH LIBRARY");
    label.setFont(new Font("GodOfWar",Font.BOLD,25));
    label.setBounds(50,40,50,25);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
    label.setForeground(Color.WHITE);//CHANGING TEXT COLOR     
    WindowFrame.add(label);//ADDING THE LABEL TO THE WINDOW*/
    
   //SETTING THE JFRAME PROPERTIES
    WindowFrame.setTitle("LIBRARY SYSTEM 8.1");
    WindowFrame.setSize(1366,730);
    WindowFrame.setResizable(false);
    WindowFrame.getContentPane().setBackground(Color.WHITE);
    WindowFrame.setVisible(true);
    WindowFrame.setDefaultCloseOperation(WindowFrame.EXIT_ON_CLOSE);
    
    //CREATING THE MENU BAR
    MBar =new JMenuBar();
    WindowFrame.setJMenuBar(MBar);//ADDING MENUBAR TO THE WINDOW   
    MBar.setBackground(Color.white);//CHANGE MENU BAR COLOR TO WHITE
    
     //JMENU ADD NEW
     menu_1=new JMenu("Add New");
     MBar.add(menu_1);//ADDING MENU_1 TO THE MENU BAR
     //JMENU REMOVE
     menu_2=new JMenu("Remove");
     MBar.add(menu_2);//ADDING MENU_2 TO THE MENU BAR
     //JMENU UPDATE
     menu_3=new JMenu("Update");
     MBar.add(menu_3);
    
    //JMENU SEARCH
      menu_7 = new JMenu("Search");
      MBar.add(menu_7);
             
     //JMENU HELP
     menu_4=new JMenu("Help");
     MBar.add(menu_4);
     //JMENU ABOUT
     menu_5=new JMenu("About");
     MBar.add(menu_5);
     //JMENU EXIT
     menu_6=new JMenu("Exit");
     MBar.add(menu_6);
     
     //JMENU ITEMS ADD NEW 
     mItem1_1 = new JMenuItem("Book",new ImageIcon("images\\books.png"));
     menu_1.add(mItem1_1);
     mItem1_2 = new JMenuItem("Member",new ImageIcon("images\\members.png"));
     menu_1.add(mItem1_2);
     mItem1_3 = new JMenuItem("User",new ImageIcon("images\\user-add-icon.png"));
     menu_1.add(mItem1_3);
    //JMENU ITEMS REMOVE
    mItem2_1 = new JMenuItem("Books",new ImageIcon("images\\delete-book.png"));
    menu_2.add(mItem2_1);
    mItem2_2 = new JMenuItem("Member",new ImageIcon("images\\remove-member.png"));
    menu_2.add(mItem2_2);   
    mItem2_3 = new JMenuItem("User",new ImageIcon("images\\remove-user.png"));
    menu_2.add(mItem2_3);
     //JMENU ITEMS UPDATE
    mItem3_1 = new JMenuItem("Books",new ImageIcon("images\\update-book.png"));
    menu_3.add(mItem3_1);
    mItem3_2 = new JMenuItem("Member",new ImageIcon("images\\update-member.png"));
    menu_3.add(mItem3_2);
    mItem3_3 = new JMenuItem("User",new ImageIcon("images\\update-user.png"));
    menu_3.add(mItem3_3);
    //JMENU ITEMS ABOUT
    mItem5_1 = new JMenuItem("About",new ImageIcon("images\\about.png"));
    menu_5.add(mItem5_1);
    //JMENU ITEMS HELP
    mItem4_1 = new JMenuItem("Help",new ImageIcon("images\\help-icon.png"));
    menu_4.add(mItem4_1);
    //JMENU ITEM EXIT
    mItem6_1 = new JMenuItem("Exit",new ImageIcon("images\\exit.png"));
    menu_6.add(mItem6_1);
    
    //JMENU ITEMS SEARCH
    mItem7_1 = new JMenuItem("Book",new ImageIcon("images\\search.png"));
    menu_7.add(mItem7_1);

    mItem7_2 = new JMenuItem("Member",new ImageIcon("images\\searchmember.png"));
    menu_7.add(mItem7_2);

    mItem7_3 = new JMenuItem("User",new ImageIcon("images\\searchuser.png"));
    menu_7.add(mItem7_3);
    
    //ACTIONLISTIONER LISTENS FOR THE ACTION OF THE CURSOR
     mItem1_1.addActionListener(this);
     mItem1_2.addActionListener(this);
     mItem1_3.addActionListener(this);
     
     mItem2_1.addActionListener(this);
     mItem2_2.addActionListener(this);
     mItem2_3.addActionListener(this);
     
     mItem3_1.addActionListener(this);
     mItem3_2.addActionListener(this);
     mItem3_3.addActionListener(this);
     
     mItem4_1.addActionListener(this);
     mItem5_1.addActionListener(this);
     mItem6_1.addActionListener(this);
     
     mItem7_1.addActionListener(this);
     mItem7_2.addActionListener(this);
     mItem7_3.addActionListener(this);
     
//============================ADDING JLABELS TO WINDOW==========================
    txtlogout = new JLabel("LOGOUT");
    txtlogout.setBounds(1140,70,120,25);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
    txtlogout.setForeground(Color.RED);
    txtlogout.setFont(new Font ("TIMES NEW ROMAN",Font.BOLD,18));
    WindowFrame.add(txtlogout);
    
    /*txtcurrentuser= new JLabel("CURRENT USER:");
    txtcurrentuser.setBounds(50,50,190,25);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
    txtcurrentuser.setForeground(Color.BLACK);
    txtcurrentuser.setFont(new Font ("TIMES NEW ROMAN",Font.BOLD,15));
    WindowFrame.add(txtcurrentuser); */
    
    txtusername= new JLabel(user.getUsername());
    txtusername.setBounds(50,50,180,25);//(PUSH RIGHT,PUSH DOWN,WIDTH,HEIGHT)
    txtusername.setForeground(Color.BLUE);
    txtusername.setFont(new Font ("TIMES NEW ROMAN",Font.BOLD,15));
    WindowFrame.add(txtusername);    
    
//==============================ADDING JBUTTONS================================= 
    btnLogout=new JButton("",new ImageIcon("images\\logoutIcon.png"));
    btnLogout.setBounds(1220,55,50,50);
    btnLogout.setForeground(Color.WHITE);
    btnLogout.setBackground(Color.WHITE);
    WindowFrame.add(btnLogout);    
    
    
    
    btnLogout.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
           WindowFrame.dispose();
          Login login =new Login();
        
            login.setVisible(true);
            login.setSize(1366,730);
            login.setResizable(false);
            login.setVisible(true);
            login.getContentPane().setBackground(Color.DARK_GRAY);
        }//END OF ACTIONPERFORMED
    }
    );//END OF ACTIONLISTENER
    
    
    
    
    
    
    
    }//END OF LIBRARYMAIN METHOD
    
    public void actionPerformed(ActionEvent Action)
    {
         //ADDING ACTIONS 
        if(Action.getSource()==mItem1_1)
        {
//          new AddBooks();
        }
        else if(Action.getSource()==mItem1_2)
        {
          new AddMembers();
        }
        else if(Action.getSource()==mItem1_3)
        {
          //new Adduser();
        }
                
        //REMOVE ACTIONS 
        if(Action.getSource()==mItem2_1)
        {
          //new RemoveBook();
        }
        else if(Action.getSource()==mItem2_2)
        {
          //new RemoveMember();
        }
        else if(Action.getSource()==mItem2_3)
        {
          //new Removeuser();
        }
      
        //UPDATE ACTIONS
        if(Action.getSource()==mItem3_1)
        {
          //new UpdateBook();
        }
        else if(Action.getSource()==mItem3_2)
        {
          //new UpdateMember();
        }
        else if(Action.getSource()==mItem3_3)
        {
          //new Updateuser();
        }
        
        
        //SEARCH ACTIONS
        if(Action.getSource()==mItem7_1)
        {
//          new SearchBooks();
        }
        else if(Action.getSource()==mItem7_2)
        {
          new SearchMember();
        }
        else if(Action.getSource()==mItem7_3)
        {
            //new SearchUser();
        }
        
        if(Action.getSource()==mItem4_1)
        {
          //new Help();
        }
        if(Action.getSource()==mItem5_1)
        {
          About about = new About();
          about.getContentPane().setBackground(Color.WHITE);
          about.setVisible(true);
          about.setLocation(400,150);
          about.setSize(430,320);
          about.setResizable(false);  
        }
       if(Action.getSource()==mItem6_1)
        {
          System.exit(0);
        }
    }            
   
}//END OF LIBRARYMAINMENU CLASS

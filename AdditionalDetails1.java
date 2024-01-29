import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

class AdditionalDetails1 implements  ActionListener 
{
   String na;
   JFrame jf;
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
   JTextField t1,t2;
   JComboBox c1,c2,c3,c4,c5;
   JRadioButton r1,r2,r3,r4;
   JButton b1;
   Connection con;

 AdditionalDetails1()
 {   
con=null;
try{                                                   //database  connection
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1821");
//set classpath=C:\Users\purvi\Downloads\ojdbc14.jar;.;
}
catch(Exception e){
System.out.println(e);
}
try{
   jf=new JFrame("Hello Bank");

   l1=new JLabel("Aadhar Number : ");
   l2=new JLabel("PAN Number : ");
   l3=new JLabel("Occupation : ");
   l4=new JLabel("Educational Qualification : ");
   l5=new JLabel("Income : ");
   l6=new JLabel("Religion : ");  
   l7=new JLabel("Category : ");
   l8=new JLabel("Senior Citizen :");
   l9=new JLabel("Existing Account");
   l10=new JLabel("ADDITIONAL DETAILS");
   l10.setFont(new Font("Times New Roman", Font.BOLD,26));

   
   t1=new JTextField();
   t2=new JTextField(); 
  
   String s1[]={"Salaried","Self-employed","Business","Student","Retired","Others"};
   String s2[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
   String s3[]={"NULL","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
   String s4[]={"Hindu","Muslim","Sikh","Christian","Other"};
   String s5[]={"General","OBC","SC","ST","Other"};


   c1=new JComboBox(s1);
   c2=new JComboBox(s2);
   c3=new JComboBox(s3);
   c4=new JComboBox(s4);
   c5=new JComboBox(s5);

   r1=new JRadioButton("Yes");
   r2=new JRadioButton("No");
   r3=new JRadioButton("Yes");
   r4=new JRadioButton("No");

   b1=new JButton("NEXT");
   b1.setBackground(Color.BLUE);
   b1.setForeground(Color.WHITE);
   b1.addActionListener(this);
   
   jf.setLayout(null);
   jf.setLocation(10,10);
   l1.setBounds(50,70,150,40);
   l2.setBounds(50,130,150,40);   
   l3.setBounds(50,190,150,40);
   l4.setBounds(50,250,200,40);
   l5.setBounds(50,310,150,40);
   l6.setBounds(50,370,150,40);
   l7.setBounds(50,430,150,40);
   l8.setBounds(50,490,150,40);
   l9.setBounds(50,550,150,40);
   l10.setBounds(120,10,300,40);

   t1.setBounds(300,70,200,30);
   t2.setBounds(300,130,200,30);

   c1.setBounds(300,190,200,30);
   c2.setBounds(300,250,200,30);
   c3.setBounds(300,310,200,30);
   c4.setBounds(300,370,200,30);
   c5.setBounds(300,430,200,30);

   r1.setBounds(300,490,100,30);
   r2.setBounds(420,490,100,30);
   r3.setBounds(300,550,100,30);
   r4.setBounds(420,550,100,30);
   
   ButtonGroup bg1=new ButtonGroup();
   bg1.add(r1);
   bg1.add(r2);
   ButtonGroup bg2=new ButtonGroup();
   bg2.add(r3);
   bg2.add(r4);

   b1.setBounds(200,590,140,40);

  jf.setSize(700,690);
  jf.setVisible(true);
  jf.setLocation(350,80);
  jf.add(l1);
  jf.add(l2);
  jf.add(l3);
  jf.add(l4);
  jf.add(l5);
  jf.add(l6);
  jf.add(l7);
  jf.add(l8);
  jf.add(l9);
  jf.add(l10);

  jf.add(t1);
  jf.add(t2);

  jf.add(c1);
  jf.add(c2);
  jf.add(c3);
  jf.add(c4);
  jf.add(c5);

  jf.add(r1);
  jf.add(r2);
  jf.add(r3);
  jf.add(r4);
  jf.add(b1);
}
catch(Exception eee){
}
}
public void actionPerformed(ActionEvent ae)
{
jf.setVisible(false);
try
{
String aadn=t1.getText();
String pan=t2.getText();
Statement st=con.createStatement();
String strcmd="update Bankinfo set AADHAR='"+aadn+"',PANNO='"+pan+"' where NAME=na";
int check=st.executeUpdate(strcmd);
if(check!=0){
System.out.println("Added Successfully");}
else{
System.out.println("Unable to add");}
}
catch(Exception e)
{
System.out.println(e);
}
AccountDetails1 acd=new AccountDetails1();

}


}
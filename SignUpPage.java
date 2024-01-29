import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class SignUpPage implements ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
JTextField t1,t2,t3,t4,t5,t6,t7,t8;
JRadioButton r1,r2,r3,r4,r5;
JButton b1;
Connection con;

SignUpPage()
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

f=new JFrame("Sign Up Page");

l11=new JLabel("PERSONAL DETAILS");
l11.setFont(new Font("Times New Roman", Font.BOLD,28));
l1=new JLabel("Name:");
l2=new JLabel("Fathers Name:");
l3=new JLabel("Date Of Birth");
l4=new JLabel("Gender:");
l5=new JLabel("Email-Adress:");
l6=new JLabel("Marital Status:");
l7=new JLabel("Address:");
l8=new JLabel("City:");
l9=new JLabel("Pin Code:");
l10=new JLabel("State:");

t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
t4=new JTextField();
t5=new JTextField();
t6=new JTextField();
t7=new JTextField();
t8=new JTextField();

ButtonGroup bg1=new ButtonGroup();
r1=new JRadioButton("Male");
r2=new JRadioButton("Female");

bg1.add(r1);
bg1.add(r2);

ButtonGroup bg2=new ButtonGroup();
JRadioButton r3=new JRadioButton("Married");
JRadioButton r4=new JRadioButton("Unmarried");
//JRadioButton r5=new JRadioButton("Other");

bg2.add(r3);
bg2.add(r4);
//bg2.add(r5);

b1=new JButton("NEXT");
b1.addActionListener(this);
b1.setBackground(Color.BLUE);
b1.setForeground(Color.WHITE);

l11.setBounds(200,20,400,40);
l1.setBounds(100,80,200,30);
l2.setBounds(100,130,200,30);
l3.setBounds(100,180,200,30);
l4.setBounds(100,230,200,30);
l5.setBounds(100,280,200,30);
l6.setBounds(100,330,200,30);
l7.setBounds(100,380,200,30);
l8.setBounds(100,430,200,30);
l9.setBounds(100,480,200,30);
l10.setBounds(100,530,200,30);

t1.setBounds(280,80,300,30);
t2.setBounds(280,130,300,30);
t3.setBounds(280,180,300,30);
t4.setBounds(280,280,300,30);
t5.setBounds(280,380,300,30);
t6.setBounds(280,430,300,30);
t7.setBounds(280,480,300,30);
t8.setBounds(280,530,300,30);

r1.setBounds(280,220,100,50);
r2.setBounds(450,220,100,50);
r3.setBounds(280,325,100,50);
r4.setBounds(400,325,100,50);
//r5.setBounds(520,325,200,50);

b1.setBounds(260,570,150,40);

f.add(l11);
f.add(l1);
f.add(l2);
f.add(l3);
f.add(l4);
f.add(l5);
f.add(l6);
f.add(l7);
f.add(l8);
f.add(l9);
f.add(l10);

f.add(t1);
f.add(t2);
f.add(t3);
f.add(t4);
f.add(t5);
f.add(t6);
f.add(t7);
f.add(t8);

f.add(r1);
f.add(r2);
f.add(r3);
f.add(r4);
//f.add(r5);
f.add(b1);

f.setLayout(null);
f.setSize(800,950);
f.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
f.setVisible(false);
AdditionalDetails1 ad=new AdditionalDetails1(); 
try
{
Statement st=con.createStatement();
String n=t1.getText();
String fn=t2.getText();
String dob=t3.getText();
String email=t4.getText();
String add=t5.getText();
String city=t6.getText();
String pc=t7.getText();
String sta=t8.getText();
String strcmd="insert into Bankinfo values('"+n+"','"+null+"','"+fn+"','"+dob+"','"+email+"','"+add+"','"+city+"','"+pc+"','"+sta+"','"+null+"','"+null+"','"+null+"','"+null+"','"+0+"')";

int check=st.executeUpdate(strcmd);
if(check!=0)
System.out.println("Added Successfully");
else
System.out.println("Unable to add");
}
catch(Exception e)
{
System.out.println(e);
}
}
}

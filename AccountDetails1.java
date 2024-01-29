import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class AccountDetails1 implements ActionListener
{
String na;
Frame f2;
Label la1;
JFrame jfr;
JLabel l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l14;
JButton b1,b2;
JCheckBox c1,c2,c3,c4,c5,c6,c7;
JRadioButton r1,r2,r3,r4;
JTextField t1;
JPasswordField p1;
Connection con;

AccountDetails1()
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
jfr=new JFrame("NEW ACCOUNT APPLICATION-PAGE 3");

l2=new JLabel("ACCOUNT DETAILS");
l2.setFont(new Font("Times New Roman", Font.BOLD,26));
l3=new JLabel("Account Type:");
l4=new JLabel("Card Number:");
l5=new JLabel("BPIN:");
l6=new JLabel("Services Required:");
l7=new JLabel("(Enter a 4-digit B-PIN)");
l8=new JLabel("(Your 16-digit Card number)");
l9=new JLabel("XXXX-XXXX-XXXX-4184");
p1=new JPasswordField();
l11=new JLabel("*It would appear on ATM card/Cheque Book and Statements");

r1=new JRadioButton("Saving Account");
r2=new JRadioButton("Fixed Deposit Account");
r3=new JRadioButton("Current Account");
r4=new JRadioButton("Recurring Deposit Account");

ButtonGroup bg=new ButtonGroup();
bg.add(r1);
bg.add(r2);
bg.add(r3);
bg.add(r4);

c1=new JCheckBox("ATM CARD");
c2=new JCheckBox("Internet Banking");
c3=new JCheckBox("Mobile Banking");
c4=new JCheckBox("EMAIL Alerts");
c5=new JCheckBox("Cheque Book");
c6=new JCheckBox("E-Statement");
c7=new JCheckBox("I hereby declare that the above entered details correct to the best of my khowledge");

b1=new JButton("Submit");
b2=new JButton("Cancel");
b1.setBackground(Color.BLUE);
b1.setForeground(Color.WHITE);
b2.setBackground(Color.BLUE);
b2.setForeground(Color.WHITE);

jfr.setLayout(null);

l2.setBounds(180,20,400,30);
l3.setBounds(100,90,200,30);
l4.setBounds(100,220,300,20);
l5.setBounds(100,310,200,20);
l6.setBounds(100,400,400,30);
l7.setBounds(100,335,330,20);
l8.setBounds(100,255,300,20);
l9.setBounds(330,220,300,30);
p1.setEchoChar('*');
p1.setBounds(350,320,200,20);
l11.setBounds(330,255,400,30);

l14= new JLabel("Re-Enter your NAME:");
t1=new JTextField();
l14.setBounds(100,370,200,20);
t1.setBounds(350,370,200,20);
jfr.add(l14);
jfr.add(t1);

r1.setBounds(100,130,250,20);
r2.setBounds(350,130,250,20);
r3.setBounds(100,160,250,20);
r4.setBounds(350,160,250,20);

c1.setBounds(100,440,200,20);
c2.setBounds(350,440,200,20);
c3.setBounds(100,480,200,20);
c4.setBounds(350,480,200,20);
c5.setBounds(100,520,200,20);
c6.setBounds(350,520,200,20);
c7.setBounds(100,560,600,20);

b1.setBounds(240,600,120,40);
b2.setBounds(420,600,120,40);

jfr.add(l2);
jfr.add(l3);
jfr.add(l4);
jfr.add(l5);
jfr.add(l6);
jfr.add(l7);
jfr.add(l8);
jfr.add(l9);
jfr.add(p1);
jfr.add(l11);
jfr.add(r1);
jfr.add(r2);
jfr.add(r3);
jfr.add(r4);
jfr.add(c1);
jfr.add(c2);
jfr.add(c3);
jfr.add(c4);
jfr.add(c5);
jfr.add(c6);
jfr.add(c7);
jfr.add(b1);
jfr.add(b2);
b1.addActionListener(this);
b2.addActionListener(this);

jfr.setSize(830,760);
jfr.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1){
try{
jfr.setVisible(false);

 String bpin=p1.getText();
System.out.println(bpin);
 String na=t1.getText();
System.out.println(na);

 Statement st=con.createStatement();
 String strcmd="update Bankinfo set BPIN='"+bpin+"' where NAME='"+na+"'";
 int check=st.executeUpdate(strcmd);
 if(check!=0)
System.out.println("Pin saved Successfully");
else
System.out.println("Unable to save pin");
}
catch(Exception e)
  {
  System.out.println(e);
  }
SignedInPage sip=new SignedInPage(na);
}

else if(ae.getSource()==b2)
{
try
{
jfr.setVisible(false);
Frame f2=new Frame("Cancelled");
f2.setSize(400,200);
f2.setVisible(true);
f2.setLayout(null);
Label la1=new Label("Registration Cancelled");
la1.setFont(new Font("Times New Roman", Font.BOLD,20));
la1.setForeground(Color.RED);
la1.setBounds(60,60,300,80);
f2.add(la1);
Label la2=new Label("Try again after sometime..");
la2.setFont(new Font("Times New Roman", Font.BOLD,16));
la2.setForeground(Color.GREEN);
la2.setBounds(50,160,300,80);
f2.add(la2);
}
catch(Exception e)
  {
  System.out.println(e);
  }
}
}
public static void main(String ar[]){
AccountDetails1 accdet=new AccountDetails1();
}

}
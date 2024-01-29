import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class BankApp implements ActionListener{               //Main class 
Connection con=null;
Frame f1,f2;                       
Label l1,l2,l3,l4,l6,l8;
TextField t1,t2;
Button b1,b2,b3;

BankApp(){
try{                                                   //database  connection
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1821");
//set classpath=C:\Users\purvi\Downloads\ojdbc14.jar;.;
/*
create table Bankinfo("NAME" varchar(50),"BPIN" varchar(15),"FATHER_NAME" varchar(50),"DOB" varchar(15),"EMAIL" varchar(100),"ADDRESS" varchar(100),"CITY" varchar(20),"PINCODE" varchar(20),"STATE" varchar(20),"AADHAR" varchar(25),"PANNO" varchar(30),"INCOME" varchar(20),"CARDNO" varchar(50))
------------------------------------------------------------------------------------------------------------------------------------------------------------
create table Bankinfo("NAME" varchar(50),"B-PIN" varchar(15),"FATHER_NAME" varchar(50),"DOB" varchar(15),"EMAIL" varchar(100),"ADDRESS" varchar(100),"CITY" varchar(20),"PIN_CODE" varchar(20),"STATE" varchar(20),"AADHAR" varchar(25),"PAN_NO" varchar(30),"INCOME" varchar(20),"CARD_NO" varchar(50),"AMOUNT" varchar(20))
*/
}
catch(Exception e){
System.out.println(e);
}

//WelcomePage
f1=new Frame("Bank Application");
f1.setSize(700,550);
f1.setVisible(true);
f1.setLayout(null);

l3=new Label("**WELCOME TO DK BANK PORTAL**");
l3.setFont(new Font("Times New Roman", Font.BOLD,28));
l3.setForeground(Color.BLACK);
l3.setBounds(50,80,500,80);
f1.add(l3);
l1=new Label("NAME:");
l1.setBounds(60,182,80,30);
f1.add(l1);
l2=new Label("B-PIN:");
l2.setBounds(60,262,80,28);
f1.add(l2);
l4=new Label("(4-Digit PIN)");
l4.setBounds(60,290,80,20);
f1.add(l4);
t1=new TextField();
t1.setBounds(180,185,300,30);
f1.add(t1);
t2=new TextField();
t2.setEchoChar('*');
t2.setBounds(180,265,300,30);
f1.add(t2);
b1=new Button("SIGN IN");
b1.setBounds(180,370,130,30);
b1.setBackground(Color.BLUE);
b1.setForeground(Color.WHITE);
b1.addActionListener(this);
f1.add(b1);
b2=new Button("CLEAR");
b2.setBounds(350,370,130,30);
b2.setBackground(Color.BLUE);
b2.setForeground(Color.WHITE);
b2.addActionListener(this);
f1.add(b2);
b3=new Button("SIGN UP");
b3.setBounds(180,420,300,30);
b3.setBackground(Color.BLUE);
b3.setForeground(Color.WHITE);
b3.addActionListener(this);
f1.add(b3);

l8=new Label("Please Sign Up if you don't have an account.");
l8.setForeground(Color.ORANGE);
l8.setFont(new Font("Times New Roman", Font.BOLD,16));
l8.setBounds(60,330,550,30);
f1.add(l8);
}

public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){
try{
 String na=t1.getText();
 String pin=t2.getText();


 Statement st=con.createStatement();
 String cmd="select * from Bankinfo where NAME='"+na+"'";
 ResultSet rs=st.executeQuery(cmd);
 while(rs.next())
	if(rs.getString(1).equals(na) && rs.getString(2).equals(pin)){
               SignedInPage sip=new SignedInPage(na);
	       f1.setVisible(false);}
        else{
            l6=new Label("INCORRECT NAME or BPIN");
            l6.setForeground(Color.RED);
	    l6.setBounds(60,470,200,30);
            f1.add(l6);
	}
}
catch(Exception ex){
System.out.println(ex);
}
}
else if(ae.getSource()==b2){
        t1.setText("");
	t2.setText("");}
else if(ae.getSource()==b3){
	SignUpPage sup=new SignUpPage();
	f1.setVisible(false);}
}

public static void main(String ar[])
 {
  BankApp app=new BankApp();
 }
}
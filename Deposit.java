import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class Deposit implements ActionListener
{
JFrame jf;
JLabel l1,l2,l3,l4,l5,l6;
JTextField t1,t2;
JPasswordField t3;
JButton b1,b2;
Connection con;
Deposit(){
con=null;
try{                                                   //database  connection
Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1821");
//set classpath=C:\Users\purvi\Downloads\ojdbc14.jar;.;
}
catch(Exception e){
System.out.println(e);
}

jf=new JFrame();
l1=new JLabel("DEPOSIT MONEY");
l1.setFont(new Font("Times New Roman", Font.BOLD,22));
l2=new JLabel("Amount to Deposit:");
l6=new JLabel("(Minimum 1000/-)");
l3=new JLabel("Name:");
l4=new JLabel("Enter Your BPIN:");
t1=new JTextField();
t2=new JTextField();
t3=new JPasswordField();
t3.setEchoChar('*');
b1=new JButton("DEPOSIT");
b2=new JButton("BACK");

jf.setLayout(null);
jf.setSize(510,480);
jf.setVisible(true);

l1.setBounds(110,40,200,50);
l2.setBounds(40,120,120,30);
l6.setBounds(40,150,120,10);
l3.setBounds(40,190,120,30);
l4.setBounds(40,260,120,30);
t1.setBounds(250,120,150,30);
t2.setBounds(250,190,150,30);
t3.setBounds(250,260,150,30);
b1.setBounds(110,320,100,40);
b2.setBounds(230,320,100,40);
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);


jf.add(l1);
jf.add(l2);
jf.add(l3);
jf.add(t1);
jf.add(l4);
jf.add(l6);
jf.add(t3);
jf.add(t2);
jf.add(b1); 
jf.add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
}

public void actionPerformed(ActionEvent ae){

if(ae.getSource()==b1){
try{
 String na=t2.getText();
 String pin=t3.getText();
 Statement st=con.createStatement();
 String cmd="select * from Bankinfo where NAME='"+na+"'";
 ResultSet rs=st.executeQuery(cmd);
 while(rs.next())
	if(rs.getString(2).equals(pin)){
		int amt=Integer.parseInt(rs.getString(14))+Integer.parseInt(t1.getText());
		int i=st.executeUpdate("update Bankinfo set AMOUNT='"+amt+"' where BPIN='"+pin+"'");
	        System.out.println("Amount Deposited Successfully!!");
		l5=new JLabel("Amount Deposited Successfully!!");
                l5.setFont(new Font("Times New Roman", Font.BOLD,20));
		l5.setBounds(60,370,300,30);
		l5.setForeground(Color.GREEN);
		jf.add(l5);}
	else{
	            l5=new JLabel("Invalid PIN");
                    l5.setFont(new Font("Times New Roman", Font.BOLD,20));
                    l5.setBounds(60,370,300,30);
		    l5.setForeground(Color.RED);		
		    jf.add(l5);}
}
catch(Exception e)
{System.out.println(e);}
}

else if(ae.getSource()==b2){
	jf.setVisible(false);
        String n=t2.getText();
	SignedInPage sip=new SignedInPage(n);
}     
}
public static void main(String args[]){
Deposit dep=new Deposit();
}
}







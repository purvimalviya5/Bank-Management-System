import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

class PinChange implements ActionListener
{
JFrame jf;
JLabel l1,l2,l3,l4,l5;
JTextField t1;
TextField t2;
JPasswordField t3;
JButton b1,b2;
Connection con=null;
PinChange(){
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
 jf=new JFrame();
 
 l1=new JLabel("CHANGE YOUR PIN");
 l1.setFont(new Font("Times New Roman", Font.BOLD,20));
 l2=new JLabel("New Pin : ");
 l3=new JLabel("Re-Enter New Pin : ");
 l4=new JLabel("Enter Name : ");

 t1=new JTextField();
 t2=new TextField();
 t3=new JPasswordField();
 t2.setEchoChar('*');
 t3.setEchoChar('*');

 b1=new JButton("CHANGE");
 b2=new JButton("BACK");


 jf.setLayout(null);
 l1.setBounds(120,20,250,25);
 l4.setBounds(30,70,150,25);
 l2.setBounds(30,115,150,25);
 t1.setBounds(200,70,200,25);
 t2.setBounds(200,115,200,25);
 l3.setBounds(30,160,150,25);
 t3.setBounds(200,160,200,25);

 b1.setBounds(90,200,100,30);
 b2.setBounds(200,200,100,30);
 b1.addActionListener(this);
 b2.addActionListener(this);
 b1.setBackground(Color.BLUE);
 b1.setForeground(Color.WHITE);
 b2.setBackground(Color.RED);
 b2.setForeground(Color.WHITE);


 jf.setSize(500,400);
 jf.setVisible(true);
 jf.setLocation(300,100);
 
 jf.add(l1);
 jf.add(l2);
 jf.add(l3);
 jf.add(t1);
 jf.add(t2);
 jf.add(l4);
 jf.add(t3);
 jf.add(b1);
 jf.add(b2);
}
catch(Exception ex){
System.out.println(ex);
}
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1){
try{
 String na=t1.getText();
 String newpin=t2.getText();
 Statement st=con.createStatement();
 String strcmd="update Bankinfo set BPIN='"+newpin+"' where NAME='"+na+"'";
 int check=st.executeUpdate(strcmd);
if(check!=0)
System.out.println("Pin changed Successfully");
else
System.out.println("Unable to change pin");
 l5=new JLabel("PIN Changed Successfully!!");
 l5.setFont(new Font("Times New Roman", Font.BOLD,14));
 l5.setForeground(Color.GREEN);
 l5.setBounds(60,240,200,20);
 jf.add(l5);
}
catch(Exception e){
System.out.println(e);
}
}

else if(ae.getSource()==b2){
	jf.setVisible(false);
        String n=t1.getText();
	SignedInPage sip=new SignedInPage(n);
}     
}
public static void main(String args[]){
PinChange pc=new PinChange();
}
}
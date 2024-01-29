import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

class BalanceEnquiry implements ActionListener
{
JFrame jf;
JLabel l1,l2,l3,l4,l5;
JTextField t2,t3;
JPasswordField t1;
JButton b1,b2;
Connection con=null;
String balanceamount;


BalanceEnquiry(){
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
 
 l1=new JLabel("Balance Enquiry");
 l1.setFont(new Font("Times New Roman", Font.BOLD,24));
 l2=new JLabel("Enter Pin : ");
 l4=new JLabel("Enter Name : ");
 l3=new JLabel("Balance in your amount : ");

 t1=new JPasswordField();
 t1.setEchoChar('*');
 t2=new JTextField();
 t3=new JTextField();
 b1=new JButton("CHECK");
 b2=new JButton("BACK");

 jf.setLayout(null);
 l1.setBounds(130,20,250,25);
 l4.setBounds(50,70,150,25);
 l2.setBounds(50,115,150,25);
 t3.setBounds(220,70,200,25);
 t1.setBounds(220,115,200,25);
 l3.setBounds(50,160,150,25);
 t2.setBounds(220,160,200,25);

 b1.setBounds(90,200,100,30);
 b1.addActionListener(this);
 b1.setBackground(Color.BLUE);
 b1.setForeground(Color.WHITE);

 b2.setBounds(210,200,100,30);
 b2.addActionListener(this);
 b2.setBackground(Color.BLUE);
 b2.setForeground(Color.WHITE);


 jf.setSize(600,330);
 jf.setVisible(true);
 jf.setLocation(500,240);
 
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
 String pin=t1.getText();
 String na=t3.getText();
 Statement st=con.createStatement();
 String cmd="select * from Bankinfo where NAME='"+na+"'";
 ResultSet rs=st.executeQuery(cmd);
 while(rs.next())

if(rs.getString(2).equals(pin)){
 		    balanceamount=rs.getString(14);
 		    t2.setText(balanceamount);}	
else{
	            l5=new JLabel("Invalid PIN");
                    l5.setFont(new Font("Times New Roman", Font.BOLD,20));
                    l5.setBounds(60,370,300,30);
		    l5.setForeground(Color.RED);		
		    jf.add(l5);}
}
catch(Exception e){
System.out.println(e);
}
}

else if(ae.getSource()==b2){
        String na=t2.getText();
	jf.setVisible(false);
	SignedInPage sip=new SignedInPage(na);
}     
}

public static void main(String ar[]){
BalanceEnquiry be=new BalanceEnquiry();
}
}

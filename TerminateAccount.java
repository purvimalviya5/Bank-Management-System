import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;

class TerminateAccount implements ActionListener
{
JFrame jf;
JLabel lh,l1,l2,l5;
JTextField t1;
JPasswordField t2;
JButton b1,b2;
Connection con=null;

TerminateAccount(){
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
 
 lh=new JLabel("ACCOUNT TERMINATION");
 lh.setFont(new Font("Times New Roman", Font.BOLD,20));
 l1=new JLabel("Name : ");
 l2=new JLabel("BPin : ");

 t1=new JTextField();
 t2=new JPasswordField();
 t2.setEchoChar('*');

 b1=new JButton("TERMINATE");
 b2=new JButton("CANCEL");


 jf.setLayout(null);
 lh.setBounds(60,20,280,25);
 l1.setBounds(50,70,100,25);
 l2.setBounds(50,115,100,25);
 t1.setBounds(200,70,200,25);
 t2.setBounds(200,115,200,25);


 b1.setBounds(60,170,130,30);
 b2.setBounds(210,170,130,30);
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
 b1.addActionListener(this);
 b2.addActionListener(this);

 jf.setSize(600,300);
 jf.setVisible(true);
 jf.setLocation(500,240);
 
 jf.add(l1);
 jf.add(l2);
 jf.add(lh);
 jf.add(t1);
 jf.add(t2);
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
 String pin=t2.getText();
 Statement st=con.createStatement();
 String cmd="select * from Bankinfo where NAME='"+na+"'";
 ResultSet rs=st.executeQuery(cmd);
 while(rs.next())
	if(rs.getString(2).equals(pin)){
		String strcmd="delete from Bankinfo where NAME='"+na+"'";
		int check=st.executeUpdate(strcmd);
 		if(check!=0)
			System.out.println("Terminated Successfully");
		else
			System.out.println("Unable to terminate");
		l5=new JLabel("ACCOUNT TERMINATED!!");
		l5.setFont(new Font("Times New Roman", Font.BOLD,18));
		l5.setForeground(Color.GREEN);
		l5.setBounds(60,220,300,30);
		jf.add(l5);}
}
catch(Exception e){
System.out.println(e);
}}

else if(ae.getSource()==b2){
	jf.setVisible(false);
        String n=t1.getText();
	SignedInPage sip=new SignedInPage(n);
}     
}

public static void main(String args[]){
TerminateAccount ta=new TerminateAccount();
}

}

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class SignedInPage implements ActionListener{
  JFrame f1;
  JLabel l1,l2,l3;
  JButton b1,b2,b3,b4,b5,b6;
SignedInPage(String name)
 {
   f1=new JFrame("Signed In Page");
   f1.setSize(800,700);
   f1.setVisible(true);
   f1.setLayout(null);
   l1=new JLabel("WELCOME TO YOUR PROFILE");
   l1.setFont(new Font("Times New Roman", Font.BOLD,26));
   l1.setForeground(Color.RED);
   l1.setBounds(150,50,400,70);
   f1.add(l1);
   l2=new JLabel(name);
   l2.setFont(new Font("Times New Roman", Font.BOLD,20));
   l2.setForeground(Color.BLUE);
   l2.setBounds(50,140,80,40);
   l3=new JLabel("Please Select Your Transaction");
   l3.setFont(new Font("Times New Roman", Font.BOLD,22));
   l3.setForeground(Color.GREEN);
   l3.setBounds(60,200,500,50);
   f1.add(l3);
   b1=new JButton("DEPOSIT");
   b1.setBounds(60,280,250,50);
   b1.setBackground(Color.BLACK);
   b1.setForeground(Color.WHITE);
   b1.addActionListener(this);
   f1.add(b1);
   b2=new JButton("CASH WITHDRAWL");
   b2.setBounds(60,350,250,50);
   b2.setBackground(Color.BLACK);
   b2.setForeground(Color.WHITE);
   b2.addActionListener(this);
   f1.add(b2);
   b3=new JButton("PIN CHANGE");
   b3.setBounds(60,420,250,50);
   b3.setBackground(Color.BLACK);
   b3.setForeground(Color.WHITE);
   b3.addActionListener(this);
   f1.add(b3);
   b4=new JButton("TERMINATE ACCOUNT");
   b4.setBounds(360,280,250,50);
   b4.setBackground(Color.BLACK);
   b4.setForeground(Color.WHITE);
   b4.addActionListener(this);
   f1.add(b4);
   b5=new JButton("BALANCE ENQUIRY");
   b5.setBounds(360,350,250,50);
   b5.setBackground(Color.BLACK);
   b5.setForeground(Color.WHITE);
   b5.addActionListener(this);
   f1.add(b5);
   b6=new JButton("EXIT");
   b6.setBounds(360,420,250,50);
   b6.setBackground(Color.BLACK);
   b6.setForeground(Color.WHITE);
   b6.addActionListener(this);
   f1.add(b6);
   
 }

public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){
Deposit dep=new Deposit();}
else if(ae.getSource()==b2){
Withdrawl wit=new Withdrawl();}
else if(ae.getSource()==b3){
PinChange pc=new PinChange();}
else if(ae.getSource()==b4){
TerminateAccount ta=new TerminateAccount();}
else if(ae.getSource()==b5){
BalanceEnquiry be=new BalanceEnquiry();}
else if(ae.getSource()==b6){
f1.setVisible(false);}

}

}

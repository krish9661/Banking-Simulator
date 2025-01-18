import javax.swing.*;
import java.awt.*;//Image package is used in awt package
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

  JTextArea textArea;
  JPasswordField pinTextfield;
  JButton Signin;
  JButton clear;
  JButton Signup;

  Login(){
    JFrame frame = new JFrame();

    frame.setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
    Image i2 =i1.getImage().getScaledInstance(50,40,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    label.setBounds(40, 20, 100, 100);
    frame.getContentPane().setBackground(Color.white);

    JLabel firstline = new JLabel("Welcome to\n Lucky ATM");
    firstline.setFont(new Font("Osward",Font.BOLD,28));
    firstline.setBounds(130,20,410,80);
    frame.add(firstline);

    JLabel Cardnumber = new JLabel("Card No.");
    Cardnumber.setBounds(70,120,100,100);
    frame.add(Cardnumber);

    JLabel pin = new JLabel("Pin No.");
    pin.setBounds(70,155,100,100);
    frame.add(pin);

    textArea = new JTextArea();
    textArea.setBounds(160,165,150,20);
    textArea.setBackground(Color.ORANGE);
    frame.add(textArea);

    pinTextfield =new JPasswordField();
    pinTextfield.setBounds(160,195,150,20);
    pinTextfield.setBackground(Color.ORANGE);
    frame.add(pinTextfield);

    Signin = new JButton("Login");
    Signin.setBounds(70,260,80,20);
    Signin.setBackground(new Color(0,0,0));
    Signin.setForeground(Color.WHITE);
    Signin.addActionListener(this);
    frame.add(Signin);

    clear = new JButton("Clear");
    clear.setBounds(185,260,80,20);
    clear.setBackground(new Color(0,0,0));
    clear.setForeground(Color.WHITE);
    clear.addActionListener(this);
    frame.add(clear);

    Signup = new JButton("SignUp");
    Signup.setBounds(70,300,200,20);
    Signup.setBackground(new Color(0,0,0));
    Signup.setForeground(Color.WHITE);
    Signup.addActionListener(this);
    frame.add(Signup);


    frame.setResizable(true);
    frame.add(label);
    frame.setSize(500,480);
    frame.setTitle("Automated Teller Machine");
    
    frame.setVisible(true);
    frame.setLocation(290,250);

  }
  
  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == clear) {
      textArea.setText("");
      pinTextfield.setText("");
    } else if (ae.getSource() == Signin) {

      Conn conn = new Conn();
      String cardnumber = textArea.getText();
      String pinnumber = pinTextfield.getText();
      String query = "select * from login where cardnumber ='"+cardnumber+"' and pin ='"+pinnumber+"'";
 
      try {
          ResultSet rs = conn.s.executeQuery(query);
          if (rs.next()) {
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
          
          } else {
            JOptionPane.showMessageDialog(null, "Incorrenct Card Number or Pin");
          }
      } catch (Exception e) {
            System.out.println(e);
      }
      
    } else if (ae.getSource() == Signup) {
      setVisible(false);
      new SignUp1().setVisible(true);

    }
  }
  public static void main(String args[]) {
    new Login();

  }
  
  
}


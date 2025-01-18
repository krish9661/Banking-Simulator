
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class transaction extends JFrame implements ActionListener{

    JButton deposit, withdrawl, ministatement, pinchange, balanceenquiry, fastcash, exit, empty; 
    String pinnumber;
    transaction(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);
        JFrame frame = new JFrame();
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        frame.add(image);

        JLabel text = new JLabel("Please select your transation");
        text.setBounds(210,350,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,380,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355, 380, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 420, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 420, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin-change");
        pinchange.setBounds(170,460,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Balance Inquiry");
        balanceenquiry.setBounds(355, 460, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        empty = new JButton ("");
        empty.setBounds(170, 495, 150, 30);
        empty.addActionListener(this);
        image.add(empty);

        exit = new JButton("Exit");
        exit.setBounds(355, 495, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        frame.setSize(900,900);
        frame.setLocation(300,0);
        frame.setUndecorated(true);
        frame.setVisible(true);

        
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource()== deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == ministatement){
            
            new MIniStatement(pinnumber).setVisible(true);
        }

    }
    public static void main(String args[]){
        new transaction("");
    }
}

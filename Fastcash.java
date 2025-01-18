
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Date;


public class Fastcash extends JFrame implements ActionListener{

    JButton deposit, withdrawl, ministatement, pinchange, balanceinquiry, fastcash, exit, empty; 
    String pinnumber;
    Fastcash(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);
        JFrame frame = new JFrame();
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        frame.add(image);

        JLabel text = new JLabel("Please select your withdrawl amount");
        text.setBounds(210,350,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Rs.100");
        deposit.setBounds(170,380,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs.200");
        withdrawl.setBounds(355, 380, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Rs.500");
        fastcash.setBounds(170, 420, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs.1000");
        ministatement.setBounds(355, 420, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs.2000");
        pinchange.setBounds(170,460,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceinquiry = new JButton("Rs.5000");
        balanceinquiry.setBounds(355, 460, 150, 30);
        balanceinquiry.addActionListener(this);
        image.add(balanceinquiry);

        empty = new JButton ("Rs.10000");
        empty.setBounds(170, 495, 150, 30);
        empty.addActionListener(this);
        image.add(empty);

        exit = new JButton("Back");
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
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select* from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));

                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));

                    }

                }

                if (ae.getSource() != exit && balance < Integer.parseInt(amount) ) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date(balance, balance, balance);
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs."+ amount + "Debited Successfully");

                setVisible(false);
                new transaction(pinnumber).setVisible(true);
            
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new Fastcash("");
    }
}

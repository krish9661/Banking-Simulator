import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignUp3 extends JFrame implements ActionListener{

    JRadioButton r1, r2,r3,r4;
    JCheckBox c1, c2, c3, c4, c5,c6, c7;
    JButton submit, cancel;
    String formno;

    SignUp3(String formno){

        this.formno = formno;
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);
        
        
        JLabel l1 = new JLabel("Page 3: Account details ");
        l1.setFont((new Font("Raleway", Font.BOLD, 22)));
        l1.setBounds(290,40,400,40);
        frame.add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont((new Font("Raleway", Font.BOLD, 22)));
        type.setBounds(100,140,200,30);
        frame.add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,160,20);
        frame.add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        frame.add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,150,20);
        frame.add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        frame.add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont((new Font("Raleway", Font.BOLD, 22)));
        card.setBounds(100,300,200,30);
        frame.add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-8546");
        number.setFont((new Font("Raleway", Font.BOLD, 22)));
        number.setBounds(330,300,300,30);
        frame.add(number);

        JLabel carddetail = new JLabel(" Your 16 Digit card Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100,330, 300, 20);
        frame.add(carddetail);

        JLabel pin = new JLabel("Pin Number");
        pin.setFont((new Font("Raleway", Font.BOLD, 22)));
        pin.setBounds(100,370,200,30);
        frame.add(pin);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont((new Font("Raleway", Font.BOLD, 22)));
        pinnumber.setBounds(330,370,300,30);
        frame.add(pinnumber);

        JLabel pindetail = new JLabel(" Your 4 digit pin");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100,400, 300, 20);
        frame.add(pindetail);

        JLabel services = new JLabel("Services Required");
        services.setFont((new Font("Raleway", Font.BOLD, 22)));
        services.setBounds(100,450,200,30);
        frame.add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        frame.add(c1);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        frame.add(c2);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        frame.add(c3);

        c4 = new JCheckBox("EMAIL & SMS");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        frame.add(c4);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        frame.add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        frame.add(c6);

        c7 = new JCheckBox("I hearby declare that the above entered details are correct in the best of my knnowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD,12));
        c7.setBounds(100,650,600,30);
        frame.add(c7);


        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        frame.add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(450,720,100,30);
        cancel.addActionListener(this);
        frame.add(cancel);


        frame.setSize(850,820);
        frame.setLocation(0,0);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String accountType = null;
            if (r1.isSelected()){
                accountType = "Saving Account";
            } else if (r2.isSelected()){
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()){
                accountType = "Current Account";
            } else if (r4.isSelected()){
                accountType = "Reccuring Deposit Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (c1.isSelected()){
                facility = facility + "ATM CARD";
            }else if (c2.isSelected()){
                facility = facility + "INTERNET BAMKING";
            }else if (c3.isSelected()){
                facility = facility + "MOBILE BANKING";
            }else if (c4.isSelected()){
                facility = facility + "EMAIL & SMS";
            }else if (c5.isSelected()){
                facility = facility + "CHEQUE BOOK";
            }else if (c6.isSelected()){
                facility = facility + "E- STATEMENT";
            }

            try{
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                } else if (facility.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please select at least one facility for future transaction");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signup3 values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, " Card Number " + cardnumber + "\n Pin: " + pinnumber);
                
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                
                
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        // }else if (ae.getSource()== cancel){
        //     r1.setSelected(false);
        //     r2.setSelected(false);
        //     r3.setSelected(false);
        //     r4.setSelected(false);
        //     c1.setSelected(false);
        //     c2.setSelected(false);
        //     c3.setSelected(false);
        //     c4.setSelected(false);
        //     c5.setSelected(false);
        //     c6.setSelected(false);
        //     c7.setSelected(false);

        } else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args){
        new SignUp3("");
    }
}

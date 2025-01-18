import java.awt.*;
import java.util.*;

import javax.swing.*;
import java.awt.event.*;

public class PinChange implements ActionListener{

    JPasswordField pin, repin;
    JButton change, back;

    String pinnumber;
    
    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;

        JFrame frame = new JFrame();
        frame.setBackground(Color.WHITE);

        frame.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        frame.add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        text.setBounds(250,280,500,35);
        image.add(text);
        
        JLabel pintext = new JLabel("NEW PIN: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Ralway", Font.BOLD, 14));
        pintext.setBounds(165,320,180 ,25);
        image.add(pintext);

        pin = new JPasswordField("");
        pin.setFont(new Font("Raleway", Font.BOLD,25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        JLabel repintext = new JLabel("RE-ENTER NEW PIN: ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Ralway", Font.BOLD, 14));
        repintext.setBounds(165,360,180 ,25);
        image.add(repintext);

        repin = new JPasswordField("");
        repin.setFont(new Font("Raleway", Font.BOLD,25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355,485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520, 150, 30);
        back.addActionListener(this);
        image.add(back);


        frame.setSize(900,900);
        frame.setLocation(300,0);
        frame.setUndecorated(true);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change) {
            try{
                String npin = pin.getText();
                String rpin = repin.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered pin doesn't match");
                    return;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new pin");
                    return;
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new pin");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin= '"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin= '"+pinnumber+"'";
                String query3 = "update signup3 set pin = '"+rpin+"' where pin= '"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin change successfully");
                
                setVisible(true);
                new transaction(rpin).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        }
        
    }
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
    void setVisible(boolean b) {
    }
}

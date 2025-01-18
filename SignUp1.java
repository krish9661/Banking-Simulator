
import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.regex.*;

public class SignUp1 extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField, FnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;

    SignUp1() {
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);


        JLabel formno = new JLabel("Application form no. "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140,20,500,40);

        JLabel personaldetails = new JLabel("Page 1 :PERSONAL DETAILS");
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 24));
        personaldetails.setBounds(210,80,400,30);
        
        JLabel Name = new JLabel("Name");
        Name.setFont(new Font("Raleway", Font.BOLD, 18));
        Name.setBounds(100,140,100,30);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);

        JLabel FName = new JLabel("Father's Name");
        FName.setFont(new Font("Raleway", Font.BOLD, 18));
        FName.setBounds(100,190,200,30);

        FnameTextField = new JTextField();
        FnameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        FnameTextField.setBounds(300,190,400,30);

        JLabel dob = new JLabel("Date fo Birth");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(100,240,200,30);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(152,35,99));

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100,290,200,30);


        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);


        female = new JRadioButton("Female");
        female.setBounds(450,290,160,30);
        female.setBackground(Color.WHITE);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        JLabel email = new JLabel("EMail Address");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(100,340,200,30);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);

        JLabel marital = new JLabel("Marital Status");
        marital.setFont(new Font("Raleway", Font.BOLD, 18));
        marital.setBounds(100,390,200,30);



        married = new JRadioButton("Married");
        married.setBounds(300,390,140,30);
        married.setBackground(Color.WHITE);

        unmarried = new JRadioButton("Un-married");
        unmarried.setBounds(450,390,150,30);
        unmarried.setBackground(Color.WHITE);

        other = new JRadioButton("other");
        other.setBounds(600,390,140,30);
        other.setBackground(Color.WHITE);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);



        JLabel address = new JLabel("Adresss");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(100,440,200,30);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);

        JLabel city = new JLabel("CITY");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(100,490,200,30);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);

        JLabel state = new JLabel("State");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(100,540,200,30);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        
        JLabel pincode = new JLabel("Pincode");
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        pincode.setBounds(100,590,200,30);
       
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 120, 40);
        next.addActionListener(this);


        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setSize(850,900);

        frame.add(nameTextField);
        frame.add(FnameTextField);
        frame.add(emailTextField);
        frame.add(addressTextField);
        frame.add(cityTextField);
        frame.add(stateTextField);
        frame.add(pinTextField);

        frame.add(dateChooser);
        frame.add(male);
        frame.add(female);

        frame.add(married);
        frame.add(unmarried);
        frame.add(other);

        frame.add(next);

        frame.add(FName);
        frame.add(address);
        frame.add(city);
        frame.add(state);
        frame.add(pincode); 
        frame.add(dob);
        frame.add(gender);
        frame.add(email);
        frame.add(marital);
        frame.add(formno);
        frame.add(Name);
        frame.add(personaldetails);
        frame.setVisible(true);


    }
    public static void main(String args[]) {
        new SignUp1();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;// long changed to string
        String name = nameTextField.getText();
        String fname = FnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";            
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup1 values('"+formno+"','"+fname+"', '"+name+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUp2(formno).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
//below a single quotes are present before string is used to make variable a string 
//"String'"+variable+"'String"
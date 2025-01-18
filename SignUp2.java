import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class SignUp2 extends JFrame implements ActionListener{

    JTextField addhar, pan;
    JButton next;
    JRadioButton married, unmarried, existence, unexistence;
    JComboBox religion, category, WorkingAt, education, income;
    String formno;

    SignUp2(String formno) {

        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionaldetails = new JLabel("Page 2 :ADDITIONAL DETAILS");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 24));
        additionaldetails.setBounds(210,80,400,30);
        
        JLabel Name = new JLabel("Religion");
        Name.setFont(new Font("Raleway", Font.BOLD, 18));
        Name.setBounds(100,140,100,30);

        String valreligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);



        JLabel fname = new JLabel("Category");
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        fname.setBounds(100,190,200,30);
        
        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);


        JLabel dob = new JLabel("Income");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(100,240,200,30);

        String incomecategory[] = {"null", "<1,50,000", "<2,50,000", "<5,00,000", "more than 5,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100,290,200,30);


        String educationalValues[] = {"Matriculation", "Intermediate", "P.G", "U.G", "Others"};
        education = new JComboBox(educationalValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);

        JLabel email = new JLabel("Qualification");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(100,315,200,30);

        

        JLabel marital = new JLabel("Occupation");
        marital.setFont(new Font("Raleway", Font.BOLD, 18));
        marital.setBounds(100,390,200,30);

        String workingarea[] = {"Govt. Job", "Private Job", "Self-employed", "Housewife", "Other"};
        WorkingAt = new JComboBox(workingarea);
        WorkingAt.setBounds(300,390,400,30);
        WorkingAt.setBackground(Color.WHITE);



        JLabel address = new JLabel("Pan No.");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(100,440,200,30);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD,14));
        pan.setBounds(300,440,400,30);



        JLabel city = new JLabel("Addhar Number");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(100,490,200,30);
        
        addhar = new JTextField();
        addhar.setFont(new Font("Raleway", Font.BOLD,14));
        addhar.setBounds(300,490,400,30);

        JLabel state = new JLabel("Senion Citizen");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(100,540,200,30);



        married = new JRadioButton("YES");
        married.setBounds(300,540,140,30);
        married.setBackground(Color.WHITE);

        unmarried = new JRadioButton("NO");
        unmarried.setBounds(450,540,150,30);
        unmarried.setBackground(Color.WHITE);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);


        
        JLabel pincode = new JLabel("Existing Account");
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        pincode.setBounds(100,590,200,30);
       

        existence = new JRadioButton("YES");
        existence.setBounds(300,590,140,30);
        existence.setBackground(Color.WHITE);

        unexistence = new JRadioButton("NO");
        unexistence.setBounds(450,590,150,30);
        unexistence.setBackground(Color.WHITE);

        ButtonGroup exist = new ButtonGroup();
        exist.add(existence);
        exist.add(unexistence);



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

        frame.add(religion);
        frame.add(category);
        
        frame.add(addhar);
        frame.add(pan);

        
        frame.add(married);
        frame.add(unmarried);
        frame.add(unexistence);
        frame.add(existence);

        frame.add(next);

        
        frame.add(WorkingAt);
        frame.add(gender);
        frame.add(dob);
        frame.add(fname);
        frame.add(address);
        frame.add(city);
        frame.add(state);
        frame.add(pincode); 
        frame.add(income);
        frame.add(education);
        frame.add(email);
        frame.add(marital);
        frame.add(Name);
        frame.add(additionaldetails);
        frame.setVisible(true);


    }
    public static void main(String args[]) {
        new SignUp2("");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String sWorkingAt = (String) WorkingAt.getSelectedItem();
        String seniorcitizen = null;
        if(married.isSelected()) {
            seniorcitizen = "YES";
        } else if (unmarried.isSelected()) {
            seniorcitizen = "NO";
        }


        String existingaccount = null;
        if (existence.isSelected()) {
            existingaccount = "YES";
        } else if (unexistence.isSelected()) {
            existingaccount = "NO";
        }

        String saddhar = addhar.getText();
        String span = pan.getText();

        
        try {
            
            Conn c = new Conn();
            String query = "insert into signup2 values('"+formno+"','"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+sWorkingAt+"', '"+span+"', '"+saddhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);

           //signup3 object 
           setVisible(false);
           new SignUp3(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
import java.sql.*;

public class Conn {
    //Register the driver
    //Create Connection
    //Create Statement
    //Execute Query 
    //Close Connection

    Connection c;
    Statement s;

    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bank_management_system", "root", "password");
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

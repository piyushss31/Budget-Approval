package loginpage;
import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Sqlite {
    
    Connection connection = null;
    
    public static Connection dbConnector()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\RAMAVATHU BALAJI\\Desktop\\Project\\Database.sqlite");
            //JOptionPane.showMessageDialog(null, "Success");
            return conn;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}

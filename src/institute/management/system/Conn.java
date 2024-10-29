package institute.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn
{
    Connection connection;
    Statement statement;

    Conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///institutemanagementDB", "root", "Mummy9955@");
            statement = connection.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

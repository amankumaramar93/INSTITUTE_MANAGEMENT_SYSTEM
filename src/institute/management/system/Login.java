package institute.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener
{
    JTextField textFieldName;
    JPasswordField textPassword;

    JButton login, clear, signup, back;

    Login()
    {
        super("Admin Login Page for Institute only");

        JLabel labelName = new JLabel("Username: ");
        labelName.setBounds(40,20,100,20);
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150, 20, 150, 20);
        add(textFieldName);

        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setBounds(40, 70, 100, 20);
        add(labelPassword);

        textPassword = new JPasswordField();
        textPassword.setBounds(150, 70, 150, 20);
        add(textPassword);

        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(180, 140, 120, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Signup");
        signup.setBounds(120, 180, 120, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        back = new JButton("Back");
        back.setBounds(120, 220, 120, 30);
        //back.setBackground(Color.BLACK);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 20,200, 200);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/loginback.png"));
        Image ii2 = ii1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(0, 0,600, 300);
        add(iimage);

        setSize(600, 300);
        setLocation(500, 250);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==login)
        {
            String username = textFieldName.getText();
            String password = textPassword.getText();
            String query = "select * from AdminSignup where username = '"+username+"' and password = '"+password+"'";
            try
            {
                Conn conn = new Conn();
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next())
                {
                    setVisible(false);
                    new Main_Class();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    return;
                }
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }

        }
        else if (e.getSource()==clear)
        {
           textFieldName.setText("");
           textPassword.setText("");
        }
        else if(e.getSource() == signup)
        {
            new SignupAdminPage();
            setVisible(false);
        }
        else if(e.getSource() == back)
        {
            new HomeStarting();
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new Login();

    }
}

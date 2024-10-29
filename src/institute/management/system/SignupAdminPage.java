package institute.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupAdminPage extends JFrame implements ActionListener
{
    JTextField textFieldName;
    JPasswordField textPassword,textCPassword;
    JButton submit,clear,back;

    SignupAdminPage()
    {
        JLabel labelName = new JLabel("Username: ");
        labelName.setBounds(40,20,100,20);
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(250, 20, 150, 20);
        add(textFieldName);

        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setBounds(40, 70, 100, 20);
        add(labelPassword);

        textPassword = new JPasswordField();
        textPassword.setBounds(250, 70, 150, 20);
        add(textPassword);

        JLabel labelCPassword = new JLabel("Confirm Password: ");
        labelCPassword.setBounds(40, 120, 170, 20);
        add(labelCPassword);

        textCPassword = new JPasswordField();
        textCPassword.setBounds(250, 120, 150, 20);
        add(textCPassword);

        submit = new JButton("Submit");
        submit.setBounds(150, 200, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        clear = new JButton("Clear");
        clear.setBounds(300, 200, 120, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        back = new JButton("back");
        back.setBounds(220, 260, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setLocation(400,200);
        setSize(600,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==submit)
        {
            if(textFieldName.getText().equals("") || textPassword.getText().equals("") || textCPassword.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fill all the Details");
            }
            else if (!textCPassword.getText().equals(textPassword.getText()))
            {
                JOptionPane.showMessageDialog(null,"Password and Confirm Password must be same");

            } else
            {
                String username = textFieldName.getText();
                String password = textPassword.getText();

                try
                {
                   Conn conn = new Conn();
                   String query = "insert into AdminSignup values('"+username+"','"+password+"') ";
                   conn.statement.executeUpdate(query);
                   JOptionPane.showMessageDialog(null, "Username "+username+"\n Password "+password);
                   new Login();
                   setVisible(false);
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        }
        else if(e.getSource() == clear)
        {
            textFieldName.setText("");
            textPassword.setText("");
            textCPassword.setText("");
        }
        else if (e.getSource() == back)
        {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args)
    {
        new SignupAdminPage();

    }
}

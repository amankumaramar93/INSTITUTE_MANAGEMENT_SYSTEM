package institute.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeStarting extends JFrame implements ActionListener
{
    JButton adminUser,student, exit;

    HomeStarting()
    {
        super("Engineer Foundation Tech Institute");

        JLabel labelHeading = new JLabel("Engineer Foundation Tech Institute");
        labelHeading.setBounds(20, 2, 460,50);
        labelHeading.setFont(new Font("Serif",Font.BOLD,30));
        labelHeading.setForeground(Color.GREEN);
        add(labelHeading);

        student = new JButton("Student");
        student.setBounds(160, 60, 200, 40);
        student.setBackground(Color.BLACK);
        student.setForeground(Color.WHITE);
        student.addActionListener(this);
        add(student);

        adminUser = new JButton("Administrator");
        adminUser.setBounds(160, 130, 200, 40);
        adminUser.setBackground(Color.BLACK);
        adminUser.setForeground(Color.WHITE);
        adminUser.addActionListener(this);
        add(adminUser);

        exit = new JButton("Exit");
        exit.setBounds(200, 220, 100, 25);
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        add(exit);

        setLayout(null);
        setLocation(400, 200);
        setSize(500, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == student)
        {
            new UserMainClass();
            setVisible(false);
        }
        else if (e.getSource() == adminUser)
        {
            new Login();
            setVisible(false);
        }
        else if(e.getSource() == exit)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        new HomeStarting();
    }
}

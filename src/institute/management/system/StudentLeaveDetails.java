package institute.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeaveDetails extends JFrame implements ActionListener
{
    Choice choiceRollNo;
    JTable table;
    JButton search, cancel, print;

    StudentLeaveDetails()
    {
        getContentPane().setBackground(new Color(250, 172, 206));

        JLabel labelHeading = new JLabel("Search by Roll Number");
        labelHeading.setBounds(20, 20, 150, 20);
        add(labelHeading);

        choiceRollNo = new Choice();
        choiceRollNo.setBounds(180, 20, 150, 20);
        add(choiceRollNo);

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from student");
            while(resultSet.next())
            {
                choiceRollNo.add(resultSet.getString("roll_number"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        table = new JTable();
        try
        {
            Conn conn =new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 100, 900, 600);
        add(jScrollPane);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(220, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == search)
        {
            String query = "select * from studentleave where roll_number = '"+choiceRollNo.getSelectedItem()+"'";

            try
            {
                Conn conn = new Conn();
                ResultSet resultSet = conn.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }
        }
        else if(e.getSource() == print)
        {
            try
            {
                table.print();
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }
        }
        else if(e.getSource() == cancel)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new StudentLeaveDetails();
    }
}

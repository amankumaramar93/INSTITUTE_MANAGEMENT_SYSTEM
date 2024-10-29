package institute.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener
{
    Choice choiceEmpId;
    JTable table;
    JButton search, cancel, print;

    TeacherLeaveDetails()
    {
        getContentPane().setBackground(new Color(250, 172, 206));

        JLabel labelHeading = new JLabel("Search by Employee Id");
        labelHeading.setBounds(20, 20, 150, 20);
        add(labelHeading);

        choiceEmpId = new Choice();
        choiceEmpId.setBounds(180, 20, 150, 20);
        add(choiceEmpId);

        try
        {
           Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from teacher");
            while(resultSet.next())
            {
                choiceEmpId.add(resultSet.getString("empId"));
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
            ResultSet resultSet = conn.statement.executeQuery("select * from Teacherleave");
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
            String query = "select * from teacherLeave where empId = '"+choiceEmpId.getSelectedItem()+"'";

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
        new TeacherLeaveDetails();
    }
}

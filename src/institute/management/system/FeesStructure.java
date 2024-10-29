package institute.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FeesStructure extends JFrame implements ActionListener
{
    FeesStructure()
    {
        getContentPane().setBackground(Color.WHITE);

        JLabel labelHeading = new JLabel("Fees Structure");
        labelHeading.setBounds(400, 10, 400, 30);
        labelHeading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(labelHeading);

        JTable table = new JTable();

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from fees");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 60, 1000, 700);
        add(jScrollPane);

        setSize(1000, 700);
        setLocation(250, 50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    public static void main(String[] args)
    {
        new FeesStructure();
    }
}

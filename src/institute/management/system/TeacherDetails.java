package institute.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class TeacherDetails extends JFrame implements ActionListener
{
    Choice choice;
    JTable table;
    JButton search, print, update, add, cancel;
    JTextField textSearch;

    TeacherDetails()
    {
        getContentPane().setBackground(new Color(192, 164, 252));

        JLabel labelHeading = new JLabel("Search by Employee ID");
        labelHeading.setBounds(20,20,150, 20);
        add(labelHeading);

        choice = new Choice();
        choice.setBounds(180, 20, 150, 20);
        add(choice);

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from teacher");
            while(resultSet.next())
            {
                choice.add(resultSet.getString("empId"));
            }
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }

        table = new JTable();
        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                textSearch.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });


        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0,100,900,600);
        add(jScrollPane);

        textSearch = new JTextField();
        textSearch.setBounds(340, 20, 150, 20);
        add(textSearch);

        choice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textSearch.setText(choice.getSelectedItem());
            }
        });

        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                textSearch.setText(choice.getSelectedItem());
            }
        });

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        add = new JButton("Add");
        add.setBounds(320, 70, 80, 20);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
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
        if (e.getSource()==search)
        {
            String query = "select * from teacher where empId = '"+textSearch.getText()+"'";
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
        else if (e.getSource() == print)
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
        else if(e.getSource() == update)
        {
            new UpdateTeacher();
        }
        else if(e.getSource() == add)
        {
            setVisible(false);
            new AddFaculty();
        }
        else if(e.getSource() == cancel)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new TeacherDetails();
    }
}

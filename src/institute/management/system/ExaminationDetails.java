package institute.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ExaminationDetails extends JFrame implements ActionListener
{
    JTextField textSearch;

    JButton result, back;

    JTable table;

    ExaminationDetails()
    {
        getContentPane().setBackground(new Color(241, 252, 210));

        JLabel labelHeading = new JLabel("Check Result");
        labelHeading.setBounds(350, 15, 400, 50);
        labelHeading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(labelHeading);

        textSearch = new JTextField();
        textSearch.setBounds(80, 90, 200, 30);
        textSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(textSearch);

        result = new JButton("Result");
        result.setBounds(300, 90, 120, 30);
        result.setBackground(Color.BLACK);
        result.setForeground(Color.WHITE);
        result.addActionListener(this);
        add(result);

        back = new JButton("Back");
        back.setBounds(440, 90, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        table = new JTable();
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 130, 1000, 310);
        add(jScrollPane);

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                textSearch.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });


        setSize(1000, 475);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == result)
        {
            setVisible(false);
            new Result(textSearch.getText());
        }
        else if(e.getSource() == back)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new ExaminationDetails();
    }
}

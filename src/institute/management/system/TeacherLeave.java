package institute.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener
{
    Choice choiceEmpId, choiceTime;

    JDateChooser selectDate;

    JButton submit, cancel;

    TeacherLeave()
    {
        getContentPane().setBackground(new Color(210, 232, 252));

        JLabel labelHeading = new JLabel("Apply Leave (Teacher)");
        labelHeading.setBounds(40, 50, 300, 30);
        labelHeading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(labelHeading);

        JLabel labelEmpIdSE = new JLabel("Search by Employee Id");
        labelEmpIdSE.setBounds(60, 100, 300, 20);
        labelEmpIdSE.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelEmpIdSE);

        choiceEmpId = new Choice();
        choiceEmpId.setBounds(60,130, 200, 20);
        add(choiceEmpId);

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from teacher");
            while (resultSet.next())
            {
                choiceEmpId.add(resultSet.getString("empId"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel labelDate = new JLabel("Date");
        labelDate.setBounds(60, 180, 200, 20);
        labelDate.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(labelDate);

        selectDate = new JDateChooser();
        selectDate.setBounds(60, 210, 200, 25);
        add(selectDate);

        JLabel labeltime = new JLabel("Date");
        labeltime.setBounds(60, 260, 200, 20);
        labeltime.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(labeltime);

        choiceTime = new Choice();
        choiceTime.setBounds(60, 290, 200, 20);
        choiceTime.add("Full Day");
        choiceTime.add("Half Day");
        add(choiceTime);

        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == submit)
        {
            if (((JTextField) selectDate.getDateEditor().getUiComponent()).getText().equals("") || choiceTime.getSelectedItem().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }
            else
            {
                String empId = choiceEmpId.getSelectedItem();
                String date = ((JTextField) selectDate.getDateEditor().getUiComponent()).getText();
                String time = choiceTime.getSelectedItem();

                String query = "insert into teacherLeave values('" + empId + "','" + date + "','" + time + "')";

                try {
                    Conn conn = new Conn();
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "leave confirmed");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        }
        else if (e.getSource() == cancel)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
       new TeacherLeave();
    }
}

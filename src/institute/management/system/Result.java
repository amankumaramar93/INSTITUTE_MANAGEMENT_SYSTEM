package institute.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Result extends JFrame implements ActionListener
{
    Choice choiceSemester;
    String rollNo;
    JLabel labelSubject1,labelSubject2,labelSubject3,labelSubject4,labelSubject5,labelMark1,labelMark2,
            labelMark3,labelMark4,labelMark5,totalMark;

    JButton back,cancel;

    Result(String rollNo)
    {
        super("Engineer Tech Foundation Institute");

        this.rollNo = rollNo;

        JLabel labelheading = new JLabel("Result of Examination 2024");
        labelheading.setBounds(300, 5, 500, 42);
        labelheading.setFont(new Font("serif",Font.BOLD, 28));
        add(labelheading);

        JLabel labelRollNo = new JLabel("Roll Number");
        labelRollNo.setBounds(50, 50, 160, 30);
        labelRollNo.setFont(new Font("serif",Font.BOLD, 20));
        add(labelRollNo);

        JLabel jLabelRollNo = new JLabel(rollNo);
        jLabelRollNo.setBounds(230, 50, 200, 30);
        jLabelRollNo.setFont(new Font("serif",Font.BOLD, 20));
        add(jLabelRollNo);

        JLabel labelSemester = new JLabel("Select Semester");
        labelSemester.setBounds(450, 50, 160, 30);
        labelSemester.setFont(new Font("serif",Font.BOLD, 20));
        add(labelSemester);

        choiceSemester = new Choice();
        choiceSemester.setBounds(640, 50, 200, 30);
        choiceSemester.setFont(new Font("serif",Font.BOLD, 20));
        add(choiceSemester);

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from Subject where roll_number='"+rollNo+"'");
            while (resultSet.next())
            {
                choiceSemester.add(resultSet.getString("semester"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel labelSubject = new JLabel("Subject");
        labelSubject.setBounds(100, 150, 200, 40);
        labelSubject.setFont(new Font("serif",Font.BOLD, 20));
        add(labelSubject);

        JLabel labelMarks = new JLabel("Marks");
        labelMarks.setBounds(400, 150, 200, 40);
        labelMarks.setFont(new Font("serif",Font.BOLD, 20));
        add(labelMarks);

        labelSubject1 = new JLabel();
        labelSubject1.setBounds(90,200,200,30);
        add(labelSubject1);

        labelSubject2 = new JLabel();
        labelSubject2.setBounds(90,240,200,30);
        add(labelSubject2);

        labelSubject3 = new JLabel();
        labelSubject3.setBounds(90,280,200,30);
        add(labelSubject3);

        labelSubject4 = new JLabel();
        labelSubject4.setBounds(90,320,200,30);
        add(labelSubject4);

        labelSubject5 = new JLabel();
        labelSubject5.setBounds(90,360,200,30);
        add(labelSubject5);

        try
        {
            Conn conn = new Conn();
            String query1 = "select * from subject where semester = '"+choiceSemester.getSelectedItem()+"' and roll_number = '"+rollNo+"'";

            ResultSet resultSet1 = conn.statement.executeQuery(query1);

            while(resultSet1.next())
            {
                labelSubject1.setText(resultSet1.getString("subject1"));
                labelSubject2.setText(resultSet1.getString("subject2"));
                labelSubject3.setText(resultSet1.getString("subject3"));
                labelSubject4.setText(resultSet1.getString("subject4"));
                labelSubject5.setText(resultSet1.getString("subject5"));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        labelMark1 = new JLabel();
        labelMark1.setBounds(410,200,200,30);
        add(labelMark1);

        labelMark2 = new JLabel();
        labelMark2.setBounds(410,240,200,30);
        add(labelMark2);

        labelMark3 = new JLabel();
        labelMark3.setBounds(410,280,200,30);
        add(labelMark3);

        labelMark4 = new JLabel();
        labelMark4.setBounds(410,320,200,30);
        add(labelMark4);

        labelMark5 = new JLabel();
        labelMark5.setBounds(410,360,200,30);
        add(labelMark5);

        totalMark = new JLabel();
        totalMark.setBounds(400,425,150,25);
        totalMark.setFont(new Font("serif",Font.BOLD, 20));
        add(totalMark);

        try
        {
            Conn conn = new Conn();
            String query2 = "select * from marks where semester = '"+choiceSemester.getSelectedItem()+"' and roll_number = '"+rollNo+"'";
            ResultSet resultSet2 = conn.statement.executeQuery(query2);

            while(resultSet2.next())
            {
                labelMark1.setText(resultSet2.getString("mark1"));
                labelMark2.setText(resultSet2.getString("mark2"));
                labelMark3.setText(resultSet2.getString("mark3"));
                labelMark4.setText(resultSet2.getString("mark4"));
                labelMark5.setText(resultSet2.getString("mark5"));

                int total = Integer.parseInt(labelMark1.getText())+Integer.parseInt(labelMark2.getText())
                        +Integer.parseInt(labelMark3.getText())+Integer.parseInt(labelMark4.getText())+Integer.parseInt(labelMark5.getText());
                totalMark.setText(Integer.toString(total));

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        choiceSemester.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                try
                {
                    Conn conn = new Conn();
                    String query1 = "select * from subject where semester = '"+choiceSemester.getSelectedItem()+"' and roll_number = '"+rollNo+"'";

                    ResultSet resultSet1 = conn.statement.executeQuery(query1);

                    while(resultSet1.next())
                    {
                        labelSubject1.setText(resultSet1.getString("subject1"));
                        labelSubject2.setText(resultSet1.getString("subject2"));
                        labelSubject3.setText(resultSet1.getString("subject3"));
                        labelSubject4.setText(resultSet1.getString("subject4"));
                        labelSubject5.setText(resultSet1.getString("subject5"));
                    }

                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }

                try
                {
                    Conn conn = new Conn();
                    String query2 = "select * from marks where semester = '"+choiceSemester.getSelectedItem()+"' and roll_number = '"+rollNo+"'";
                    ResultSet resultSet2 = conn.statement.executeQuery(query2);

                    while(resultSet2.next())
                    {
                        labelMark1.setText(resultSet2.getString("mark1"));
                        labelMark2.setText(resultSet2.getString("mark2"));
                        labelMark3.setText(resultSet2.getString("mark3"));
                        labelMark4.setText(resultSet2.getString("mark4"));
                        labelMark5.setText(resultSet2.getString("mark5"));

                        int total = Integer.parseInt(labelMark1.getText())+Integer.parseInt(labelMark2.getText())
                                +Integer.parseInt(labelMark3.getText())+Integer.parseInt(labelMark4.getText())+Integer.parseInt(labelMark5.getText());
                        totalMark.setText(Integer.toString(total));
                    }
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JLabel labelLine = new JLabel("-----------------------------------------------------------------------");
        labelLine.setBounds(90,400,500,20);
        labelLine.setFont(new Font("serif",Font.BOLD,20));
        add(labelLine);


        back = new JButton("Back");
        back.setBounds(150, 500, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        cancel = new JButton("Cancel");
        cancel.setBounds(400, 500, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(new Color(230, 210,252));

        setSize(900, 700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == back)
        {
            new ExaminationDetails();
            setVisible(false);
        }
        else if(e.getSource() == cancel)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new Result("");
    }
}

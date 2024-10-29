package institute.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener
{
    Choice choiceRollNo;
    JComboBox semesterComboBox;

    JTextField textSubject1,textSubject2,textSubject3,textSubject4,textSubject5,textMarks1,
            textMarks2,textMarks3,textMarks4,textMarks5;

    JButton submit, cancel;

    EnterMarks()
    {
        getContentPane().setBackground(new Color(252, 245, 210));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.png"));
        Image i2= i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        add(image);

        JLabel labelHeading = new JLabel("Enter Marks of Student");
        labelHeading.setBounds(50,0, 500, 50);
        labelHeading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(labelHeading);

        JLabel labelRollNo = new JLabel("Select Roll Number");
        labelRollNo.setBounds(50,70, 150, 20);
        //rollNo.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(labelRollNo);

        choiceRollNo = new Choice();
        choiceRollNo.setBounds(200, 70, 150, 20);
        add(choiceRollNo);

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from student");
            while (resultSet.next())
            {
                choiceRollNo.add(resultSet.getString("roll_number"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel labelSemester = new JLabel("Select Semester");
        labelSemester.setBounds(50,110, 150, 20);
        add(labelSemester);

        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        semesterComboBox = new JComboBox(semester);
        semesterComboBox.setBounds(200, 110, 150, 20);
        semesterComboBox.setBackground(Color.WHITE);
        add(semesterComboBox);

        JLabel labelEnterSubject = new JLabel("Enter Subject");
        labelEnterSubject.setBounds(100, 150, 200, 40);
        add(labelEnterSubject);

        JLabel labelEnterMarks = new JLabel("Enter Marks");
        labelEnterMarks.setBounds(320, 150, 200, 40);
        add(labelEnterMarks);

        textSubject1 = new JTextField();
        textSubject1.setBounds(50, 200, 200, 20);
        add(textSubject1);

        textSubject2 = new JTextField();
        textSubject2.setBounds(50, 230, 200, 20);
        add(textSubject2);

        textSubject3 = new JTextField();
        textSubject3.setBounds(50, 260, 200, 20);
        add(textSubject3);

        textSubject4 = new JTextField();
        textSubject4.setBounds(50, 290, 200, 20);
        add(textSubject4);

        textSubject5 = new JTextField();
        textSubject5.setBounds(50, 320, 200, 20);
        add(textSubject5);

        textMarks1 = new JTextField();
        textMarks1.setBounds(260, 200, 200, 20);
        add(textMarks1);

        textMarks2 = new JTextField();
        textMarks2.setBounds(260, 230, 200, 20);
        add(textMarks2);

        textMarks3 = new JTextField();
        textMarks3.setBounds(260, 260, 200, 20);
        add(textMarks3);

        textMarks4 = new JTextField();
        textMarks4.setBounds(260, 290, 200, 20);
        add(textMarks4);

        textMarks5 = new JTextField();
        textMarks5.setBounds(260, 320, 200, 20);
        add(textMarks5);

        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 360, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setSize(1000, 500);
        setLayout(null);
        setLocation(300, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == submit)
        {
            try
            {
                Conn conn = new Conn();
                String query1 = "insert into subject values('"+choiceRollNo.getSelectedItem()+"','"+semesterComboBox.getSelectedItem()+"','"+
                        textSubject1.getText()+"','"+textSubject2.getText()+"','"+textSubject3.getText()+"','"+textSubject4.getText()+"','"+textSubject5.getText()+"')";

                String query2 = "insert into marks values('"+choiceRollNo.getSelectedItem()+"','"+semesterComboBox.getSelectedItem()+"','"+
                        textMarks1.getText()+"','"+textMarks2.getText()+"','"+textMarks3.getText()+"','"+textMarks4.getText()+"','"+textMarks5.getText()+"')";

                conn.statement.executeUpdate(query1);
                conn.statement.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                setVisible(false);
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new EnterMarks();
    }
}

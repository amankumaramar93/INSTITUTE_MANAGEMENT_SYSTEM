package institute.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.font.ImageGraphicAttribute;
import java.sql.ResultSet;

public class StudentFeesForm extends JFrame implements ActionListener
{
    Choice choiceRollNo;
    JComboBox courseBox,branchBox, semesterBox;
    JLabel labelTotalAmount;
    JButton pay, update, back;

    StudentFeesForm()
    {
        getContentPane().setBackground(new Color(210, 252, 251));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.png"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);

        JLabel labelRollNo = new JLabel("Select Roll Number");
        labelRollNo.setBounds(40,60,150,20);
        labelRollNo.setFont(new Font("Tahoma", Font.BOLD,12));
        add(labelRollNo);

        choiceRollNo = new Choice();
        choiceRollNo.setBounds(200,60,150,20);
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

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(40, 100, 150, 20);
        add(labelName);

        JLabel  jLabelName = new JLabel();
        jLabelName.setBounds(200, 100, 150, 20);
        add(jLabelName);

        JLabel labelFName = new JLabel("Father's Name");
        labelFName.setBounds(40, 140, 150, 20);
        add(labelFName);

        JLabel  jLabelFName = new JLabel("yui");
        jLabelFName.setBounds(200, 140, 150, 20);
        add(jLabelFName);

        try
        {
            Conn conn = new Conn();
            String query = "select * from student where roll_Number = '"+choiceRollNo.getSelectedItem()+"'";
            ResultSet resultSet = conn.statement.executeQuery(query);
            while (resultSet.next())
            {
                jLabelName.setText(resultSet.getString("name"));
                jLabelFName.setText(resultSet.getString("father_name"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        choiceRollNo.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                try
                {
                    Conn conn = new Conn();
                    String query = "select * from student where roll_Number = '"+choiceRollNo.getSelectedItem()+"'";
                    ResultSet resultSet = conn.statement.executeQuery(query);
                    while (resultSet.next())
                    {
                        jLabelName.setText(resultSet.getString("name"));
                        jLabelFName.setText(resultSet.getString("father_name"));
                    }
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JLabel labelCourse = new JLabel("Course:");
        labelCourse.setBounds(40, 180, 150, 20);
        //labelCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labelCourse);

        String course[] = {"B.Tech","B.E","BCA","BBA","BSC","BCOM","BA","MCA","MCom","M.Tech","MA","MSc","MBA"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200, 180,150, 20);
        //courseBox.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(courseBox);

        JLabel labelDepartment = new JLabel("Branch:");
        labelDepartment.setBounds(40, 220, 150, 20);
        //labelDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labelDepartment);

        String branch[] = {"Computer Science","IT","Electronics","Electrical","Mechanical","Civil","B.Ed.","Law","Fashion Design","MBA","Others"};
        branchBox = new JComboBox(branch);
        branchBox.setBounds(200, 220,150, 20);
        //branchBox.setFont(new Font("serif", Font.BOLD, 16));
        add(branchBox);

        JLabel labelSemester = new JLabel("Semester");
        labelSemester.setBounds(40, 260, 150, 20);
        add(labelSemester);

        String semester[] = {"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
        semesterBox= new JComboBox(semester);
        semesterBox.setBounds(200,260, 150, 20);
        add(semesterBox);

        JLabel labelTotal = new JLabel("Total Payable");
        labelTotal.setBounds(40,300,150,20);
        add(labelTotal);

        labelTotalAmount = new JLabel();
        labelTotalAmount.setBounds(200, 300, 150, 20);
        add(labelTotalAmount);

        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay");
        pay.setBounds(150, 380, 100, 25);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.addActionListener(this);
        add(back);

        setSize(900, 500);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == update)
        {
            String course = (String) courseBox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();
            try
            {
                Conn conn = new Conn();
                ResultSet resultSet = conn.statement.executeQuery("select * from fees where course = '"+course+"'");
                while (resultSet.next())
                {
                    labelTotalAmount.setText(resultSet.getString(semester));
                }
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }
        }
        else if(e.getSource() == pay)
        {
            String rollNo = choiceRollNo.getSelectedItem();
            String course = (String) courseBox.getSelectedItem();
            String semester = (String) semesterBox.getSelectedItem();
            String branch = (String) branchBox.getSelectedItem();
            String total = labelTotalAmount.getText();

            try
            {
                Conn conn = new Conn();
                String query = "insert into feescollege values('"+rollNo+"','"+course+"','"+
                        semester+"','"+branch+"','"+total+"')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "fees Submitted Successfully");
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }
        }
        else if(e.getSource() == back)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new StudentFeesForm();
    }
}

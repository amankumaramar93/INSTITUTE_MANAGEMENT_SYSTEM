package institute.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateTeacher extends JFrame implements ActionListener
{
    JTextField textAddress, textPhone, textEmail, textAadhar, textQualification, textDepartment;
    JLabel labelEmpText;
    JButton update, cancel;

    Choice choiceEmpId;

    UpdateTeacher()
    {
        getContentPane().setBackground(new Color(230, 210,252));

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD, 35));
        add(heading);

        JLabel labelEmpId = new JLabel("Select Employee Id");
        labelEmpId.setBounds(40, 70, 200, 20);
        labelEmpId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmpId);

        choiceEmpId = new Choice();
        choiceEmpId.setBounds(250,70,200,20);
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

        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(40, 120, 100, 30);
        labelName.setFont(new Font("serif", Font.BOLD, 20));
        add(labelName);

        JLabel jLabelName = new JLabel();
        jLabelName.setBounds(180, 120,220, 30);
        jLabelName.setFont(new Font("serif", Font.BOLD, 20));
        add(jLabelName);

        JLabel labelFName = new JLabel("Father's Name:");
        labelFName.setBounds(420, 120, 150, 30);
        labelFName.setFont(new Font("serif", Font.BOLD, 20));
        add(labelFName);

        JLabel jLabelFName = new JLabel();
        jLabelFName.setBounds(570, 120,230, 30);
        jLabelFName.setFont(new Font("serif", Font.BOLD, 20));
        add(jLabelFName);

        JLabel labelEmpIDD = new JLabel("Employee ID:");
        labelEmpIDD.setBounds(40, 170, 200, 30);
        labelEmpIDD.setFont(new Font("serif", Font.BOLD, 20));
        add(labelEmpIDD);

        labelEmpText = new JLabel();
        labelEmpText.setBounds(180, 170, 220, 30);
        labelEmpText.setFont(new Font("serif", Font.BOLD, 20));
        add(labelEmpText);

        JLabel labelDob = new JLabel("Date Of Birth:");
        labelDob.setBounds(420, 170, 200, 30);
        labelDob.setFont(new Font("serif", Font.BOLD, 20));
        add(labelDob);

        JLabel jLabelDob = new JLabel();
        jLabelDob.setBounds(570, 170, 150, 30);
        add(jLabelDob);

        JLabel labelAddress = new JLabel("Address:");
        labelAddress.setBounds(40, 220, 200, 30);
        labelAddress.setFont(new Font("serif", Font.BOLD, 20));
        add(labelAddress);

        textAddress = new JTextField();
        textAddress.setBounds(180, 220, 620, 30);
        textAddress.setFont(new Font("serif", Font.BOLD, 20));
        add(textAddress);

        JLabel labelPhone = new JLabel("Phone:");
        labelPhone.setBounds(40, 270, 200, 30);
        labelPhone.setFont(new Font("serif", Font.BOLD, 20));
        add(labelPhone);

        textPhone = new JTextField();
        textPhone.setBounds(180, 270,220, 30);
        textPhone.setFont(new Font("serif", Font.BOLD, 20));
        add(textPhone);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(420, 270, 150, 30);
        labelEmail.setFont(new Font("serif", Font.BOLD, 20));
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setBounds(570, 270,230, 30);
        textEmail.setFont(new Font("serif", Font.BOLD, 20));
        add(textEmail);

        JLabel label10thMarks = new JLabel("Class X (%):");
        label10thMarks.setBounds(40, 320, 200, 30);
        label10thMarks.setFont(new Font("serif", Font.BOLD, 20));
        add(label10thMarks);

        JLabel jLabel10thMarks = new JLabel();
        jLabel10thMarks.setBounds(180, 320,220, 30);
        jLabel10thMarks.setFont(new Font("serif", Font.BOLD, 20));
        add(jLabel10thMarks);

        JLabel label12thMarks = new JLabel("Class XII (%):");
        label12thMarks.setBounds(420, 320, 150, 30);
        label12thMarks.setFont(new Font("serif", Font.BOLD, 20));
        add(label12thMarks);

        JLabel jLabel12thMarks = new JLabel();
        jLabel12thMarks.setBounds(570, 320,230, 30);
        jLabel12thMarks.setFont(new Font("serif", Font.BOLD, 20));
        add(jLabel12thMarks);

        JLabel labelGraduationCourse = new JLabel("Graduation (Course):");
        labelGraduationCourse.setBounds(40, 370, 200, 30);
        labelGraduationCourse.setFont(new Font("serif", Font.BOLD, 20));
        add(labelGraduationCourse);

        JLabel jLabelGraduationCourse = new JLabel();
        jLabelGraduationCourse.setBounds(225, 370, 240, 30);
        jLabelGraduationCourse.setFont(new Font("serif", Font.BOLD, 20));
        add(jLabelGraduationCourse);

        JLabel labelGraduationMarks = new JLabel("Graduation (%):");
        labelGraduationMarks.setBounds(450, 370, 150, 30);
        labelGraduationMarks.setFont(new Font("serif", Font.BOLD, 20));
        add(labelGraduationMarks);

        JLabel jLlabelGraduationMarks = new JLabel();
        jLlabelGraduationMarks.setBounds(610, 370,190, 30);
        jLlabelGraduationMarks.setFont(new Font("serif", Font.BOLD, 20));
        add(jLlabelGraduationMarks);

        JLabel labelAadhar = new JLabel("Aadhar No:");
        labelAadhar.setBounds(40, 420, 200, 30);
        labelAadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(labelAadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(180, 420, 220, 30);
        textAadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(textAadhar);

        JLabel labelQualification = new JLabel("Qualification:");
        labelQualification.setBounds(420, 420, 150, 30);
        labelQualification.setFont(new Font("serif", Font.BOLD, 20));
        add(labelQualification);

        textQualification = new JTextField();
        textQualification.setBounds(570, 420,230, 30);
        add(textQualification);

        JLabel labelDepartment = new JLabel("Department:");
        labelDepartment.setBounds(40, 470, 150, 30);
        labelDepartment.setFont(new Font("serif", Font.BOLD, 20));
        add(labelDepartment);

        textDepartment = new JTextField();
        textDepartment.setBounds(180, 470, 220, 30);
        add(textDepartment);

        try
        {
            Conn conn = new Conn();
            String query = "select * from teacher where empId = '"+choiceEmpId.getSelectedItem()+"'";
            ResultSet resultSet = conn.statement.executeQuery(query);
            while (resultSet.next())
            {
                jLabelName.setText(resultSet.getString("name"));
                jLabelFName.setText(resultSet.getString("father_name"));
                jLabelDob.setText(resultSet.getString("dob"));
                textAddress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
                jLabel10thMarks.setText(resultSet.getString("class_X"));
                jLabel12thMarks.setText(resultSet.getString("class_XII"));
                jLabelGraduationCourse.setText(resultSet.getString("graduation_course"));
                jLlabelGraduationMarks.setText(resultSet.getString("graduation_percentage"));
                textAadhar.setText(resultSet.getString("aadhar"));
                textQualification.setText(resultSet.getString("qualification"));
                textDepartment.setText(resultSet.getString("department"));
                labelEmpText.setText(resultSet.getString("empId"));

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        choiceEmpId.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                try
                {
                    Conn conn = new Conn();
                    String query = "select * from teacher where empId = '"+choiceEmpId.getSelectedItem()+"'";
                    ResultSet resultSet = conn.statement.executeQuery(query);
                    while (resultSet.next()) {
                        jLabelName.setText(resultSet.getString("name"));
                        jLabelFName.setText(resultSet.getString("father_name"));
                        jLabelDob.setText(resultSet.getString("dob"));
                        textAddress.setText(resultSet.getString("address"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                        jLabel10thMarks.setText(resultSet.getString("class_X"));
                        jLabel12thMarks.setText(resultSet.getString("class_XII"));
                        jLabelGraduationCourse.setText(resultSet.getString("graduation_course"));
                        jLlabelGraduationMarks.setText(resultSet.getString("graduation_percentage"));
                        textAadhar.setText(resultSet.getString("aadhar"));
                        textQualification.setText(resultSet.getString("qualification"));
                        textDepartment.setText(resultSet.getString("department"));
                        labelEmpText.setText(resultSet.getString("empId"));
                    }
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        update = new JButton("Update");
        update.setBounds(250, 530, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 530, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900, 700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == update)
        {
            String empId = labelEmpText.getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String qualification = textQualification.getText();
            String department = textDepartment.getText();

            try
            {
                String query = "update teacher set address = '"+address+"', phone = '"+phone+"', email = '"+
                        email+"', qualification = '"+qualification+"', department = '"+department+"' where empId = '"+empId+"' ";
                Conn conn = new Conn();
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }
        }
        else if (e.getSource() == cancel)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new UpdateTeacher();
    }
}

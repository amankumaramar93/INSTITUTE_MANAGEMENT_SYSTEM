package institute.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener
{
    JTextField textName, textFName, textAddress, textPhone, textEmail, text10thMarks, text12thMarks, textAadhar, textGraduationCourse, textGraduationMarks;
    JLabel labelEmpText;
    JComboBox courseBox, branchBox;
    JButton submit, cancel;

    Random random = new Random();
    long f4 = Math.abs((random.nextLong() % 9000L) + 1000L);

    JDateChooser textDob;

    AddStudent()
    {
        getContentPane().setBackground(new Color(128, 176,255));

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD, 30));
        add(heading);

        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(40, 100, 100, 30);
        labelName.setFont(new Font("serif", Font.BOLD, 20));
        add(labelName);

        textName = new JTextField();
        textName.setBounds(180, 100,220, 30);
        textName.setFont(new Font("serif", Font.BOLD, 20));
        add(textName);

        JLabel labelFName = new JLabel("Father's Name:");
        labelFName.setBounds(420, 100, 150, 30);
        labelFName.setFont(new Font("serif", Font.BOLD, 20));
        add(labelFName);

        textFName = new JTextField();
        textFName.setBounds(570, 100,230, 30);
        textFName.setFont(new Font("serif", Font.BOLD, 20));
        add(textFName);

        JLabel labelEmpId = new JLabel("Roll Number:");
        labelEmpId.setBounds(40, 150, 200, 30);
        labelEmpId.setFont(new Font("serif", Font.BOLD, 20));
        add(labelEmpId);

        labelEmpText = new JLabel("2024" + f4);
        labelEmpText.setBounds(180, 150, 220, 30);
        labelEmpText.setFont(new Font("serif", Font.BOLD, 20));
        add(labelEmpText);

        JLabel labelDob = new JLabel("Date Of Birth:");
        labelDob.setBounds(420, 150, 200, 30);
        labelDob.setFont(new Font("serif", Font.BOLD, 20));
        add(labelDob);

        textDob = new JDateChooser();
        textDob.setBounds(570, 150, 230, 30);
        add(textDob);

        JLabel labelAddress = new JLabel("Address:");
        labelAddress.setBounds(40, 200, 200, 30);
        labelAddress.setFont(new Font("serif", Font.BOLD, 20));
        add(labelAddress);

        textAddress = new JTextField();
        textAddress.setBounds(180, 200, 620, 30);
        textAddress.setFont(new Font("serif", Font.BOLD, 20));
        add(textAddress);

        JLabel labelPhone = new JLabel("Phone:");
        labelPhone.setBounds(40, 250, 200, 30);
        labelPhone.setFont(new Font("serif", Font.BOLD, 20));
        add(labelPhone);

        textPhone = new JTextField();
        textPhone.setBounds(180, 250,220, 30);
        textPhone.setFont(new Font("serif", Font.BOLD, 20));
        add(textPhone);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(420, 250, 150, 30);
        labelEmail.setFont(new Font("serif", Font.BOLD, 20));
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setBounds(570, 250,230, 30);
        textEmail.setFont(new Font("serif", Font.BOLD, 20));
        add(textEmail);

        JLabel label10thMarks = new JLabel("Class X (%):");
        label10thMarks.setBounds(40, 300, 200, 30);
        label10thMarks.setFont(new Font("serif", Font.BOLD, 20));
        add(label10thMarks);

        text10thMarks = new JTextField();
        text10thMarks.setBounds(180, 300,220, 30);
        text10thMarks.setFont(new Font("serif", Font.BOLD, 20));
        add(text10thMarks);

        JLabel label12thMarks = new JLabel("Class XII (%):");
        label12thMarks.setBounds(420, 300, 150, 30);
        label12thMarks.setFont(new Font("serif", Font.BOLD, 20));
        add(label12thMarks);

        text12thMarks = new JTextField();
        text12thMarks.setBounds(570, 300,230, 30);
        text12thMarks.setFont(new Font("serif", Font.BOLD, 20));
        add(text12thMarks);

        JLabel labelGraduationCourse = new JLabel("Graduation (Course):");
        labelGraduationCourse.setBounds(40, 350, 200, 30);
        labelGraduationCourse.setFont(new Font("serif", Font.BOLD, 20));
        add(labelGraduationCourse);

        textGraduationCourse = new JTextField();
        textGraduationCourse.setBounds(225, 350, 240, 30);
        textGraduationCourse.setFont(new Font("serif", Font.BOLD, 20));
        add(textGraduationCourse);

        JLabel labelGraduationMarks = new JLabel("Graduation (%):");
        labelGraduationMarks.setBounds(470, 350, 150, 30);
        labelGraduationMarks.setFont(new Font("serif", Font.BOLD, 20));
        add(labelGraduationMarks);

        textGraduationMarks = new JTextField();
        textGraduationMarks.setBounds(610, 350,190, 30);
        textGraduationMarks.setFont(new Font("serif", Font.BOLD, 20));
        add(textGraduationMarks);

        JLabel labelAadhar = new JLabel("Aadhar No:");
        labelAadhar.setBounds(40, 400, 200, 30);
        labelAadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(labelAadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(180, 400, 220, 30);
        textAadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(textAadhar);

        JLabel labelCourse = new JLabel("Course:");
        labelCourse.setBounds(420, 400, 150, 30);
        labelCourse.setFont(new Font("serif", Font.BOLD, 20));
        add(labelCourse);

        String course[] = {"B.Tech","B.E","BCA","BBA","BSC","BA","MCA","M.Com","M.Tech","MA","Others"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(570, 400,230, 30);
        courseBox.setFont(new Font("serif", Font.BOLD, 20));
        add(courseBox);

        JLabel labelDepartment = new JLabel("Branch:");
        labelDepartment.setBounds(40, 450, 150, 30);
        labelDepartment.setFont(new Font("serif", Font.BOLD, 20));
        add(labelDepartment);

        String branch[] = {"Computer Science","IT","Electronics","Electrical","Mechanical","Civil","B.Ed.","Law","Fashion Design","MBA","Others"};
        branchBox = new JComboBox(branch);
        branchBox.setBounds(180, 450,220, 30);
        branchBox.setFont(new Font("serif", Font.BOLD, 20));
        add(branchBox);

        submit = new JButton("Submit");
        submit.setBounds(250, 520, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 520, 120, 30);
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
        if (e.getSource()==submit)
        {
            if(textName.getText().equals("") || textFName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }
            else
            {
                String name = textName.getText();
                String fatherName = textFName.getText();
                String rollNumber = labelEmpText.getText();
                String dob = ((JTextField) textDob.getDateEditor().getUiComponent()).getText();
                String address = textAddress.getText();
                String phone = textPhone.getText();
                String email = textEmail.getText();
                String class_X = text10thMarks.getText();
                String class_XII = text12thMarks.getText();
                String graduationCourse = textGraduationCourse.getText();
                String graduationPercentage = textGraduationMarks.getText();
                String aadhar = textAadhar.getText();
                String course = (String) courseBox.getSelectedItem();
                String branch = (String) branchBox.getSelectedItem();

                try {
                    String query = "insert into student values('" + name + "','" + fatherName + "','" + rollNumber + "','" + dob + "','" +
                            address + "','" + phone + "','" + email + "','" + class_X + "','" + class_XII + "','" + graduationCourse + "','" +
                            graduationPercentage + "','" + aadhar + "','" + course + "','" + branch + "')";
                    Conn conn = new Conn();
                    conn.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Details Inserted Successfully"+"\n Your roll_number: "+rollNumber);
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        }
        else if (e.getSource()==cancel)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new AddStudent();
    }
}

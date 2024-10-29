package institute.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame implements ActionListener
{
    Main_Class()
    {
        super("Admin Portal For Institute");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JLabel labelHeading = new JLabel("<html> Engineer &nbsp; Foundation &nbsp; Tech &nbsp; Institute </html>");
        labelHeading.setBounds(410, 80, 600,50);
        labelHeading.setFont(new Font("Serif",Font.BOLD,30));
        labelHeading.setForeground(Color.GREEN);
        image.add(labelHeading);

        JMenuBar menuBar = new JMenuBar();

        //new Information
        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.BLACK);
        menuBar.add(newInfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        // details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLACK);
        menuBar.add(details);

        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        //leave section
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        menuBar.add(leave);

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        //leave details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLACK);
        menuBar.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        //examination
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        menuBar.add(exam);

        JMenuItem examinationDetails = new JMenuItem("Examination Result");
        examinationDetails.setBackground(Color.WHITE);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);

        JMenuItem examinationMarksEnter = new JMenuItem("Enter Marks");
        examinationMarksEnter.setBackground(Color.WHITE);
        examinationMarksEnter.addActionListener(this);
        exam.add(examinationMarksEnter);

        // update info
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLACK);
        menuBar.add(updateInfo);

        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Information");
        updateFacultyInfo.setBackground(Color.WHITE);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentInfo = new JMenuItem("Update Student Information");
        updateStudentInfo.setBackground(Color.WHITE);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        //fees section
        JMenu fees = new JMenu("Fees Details");
        fees.setForeground(Color.BLACK);
        menuBar.add(fees);

        JMenuItem feeStructure = new JMenuItem("Fees Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fees.add(feeStructure);

        JMenuItem feesForm = new JMenuItem("Student Fee Form");
        feesForm.setBackground(Color.WHITE);
        feesForm.addActionListener(this);
        fees.add(feesForm);

        //utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLACK);
        menuBar.add(utility);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        //about
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLACK);
        menuBar.add(about);

        JMenuItem About = new JMenuItem("About");
        About.setBackground(Color.WHITE);
        About.addActionListener(this);
        about.add(About);

        //exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        menuBar.add(exit);

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.WHITE);
        Exit.addActionListener(this);
        exit.add(Exit);

        setJMenuBar(menuBar);

        setSize(1540, 850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String sm = e.getActionCommand();

        if (sm.equals("Exit"))
        {
            System.exit(15);
        }
        else if (sm.equals("Calculator"))
        {
            try
            {
                Runtime.getRuntime().exec("calc.exe");
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }
        }
        else if (sm.equals("Notepad"))
        {
            try
            {
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch (Exception E)
            {

            }
        }
        else if (sm.equals("New Faculty Information"))
        {
            new AddFaculty();
        }
        else if(sm.equals("New Student Information"))
        {
            new AddStudent();
        }
        else if(sm.equals("View Faculty Details"))
        {
            new TeacherDetails();
        }
        else if(sm.equals("View Student Details"))
        {
            new StudentDetails();
        }
        else if(sm.equals("Faculty Leave"))
        {
            new TeacherLeave();
        }
        else if(sm.equals("Student Leave"))
        {
            new StudentLeave();
        }
        else if(sm.equals("Faculty Leave Details"))
        {
            new TeacherLeaveDetails();
        }
        else if(sm.equals("Student Leave Details"))
        {
            new StudentLeaveDetails();
        }
        else if(sm.equals("Examination Result"))
        {
            new ExaminationDetails();
        }
        else if(sm.equals("Enter Marks"))
        {
            new EnterMarks();
        }
        else if(sm.equals("Update Faculty Information"))
        {
            new UpdateTeacher();
        }
        else if(sm.equals("Update Student Information"))
        {
            new UpdateStudent();
        }
        else if(sm.equals("Fees Structure"))
        {
            new FeesStructure();
        }
        else if(sm.equals("Student Fee Form"))
        {
            new StudentFeesForm();
        }
        else if(sm.equals("About"))
        {
            new About();
        }


    }

    public static void main(String[] args)
    {
        new Main_Class();
    }
}

package institute.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMainClass extends JFrame implements ActionListener
{
    UserMainClass()
    {
        super("Student Portal");

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

        //leave section
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        menuBar.add(leave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        //examination
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        menuBar.add(exam);

        JMenuItem examinationDetails = new JMenuItem("Examination Result");
        examinationDetails.setBackground(Color.WHITE);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);

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
        else if(sm.equals("Student Leave"))
        {
            new StudentLeave();
        }
        else if(sm.equals("Examination Result"))
        {
            new ExaminationDetails();
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
        new UserMainClass();
    }
}

package institute.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener
{
    About()
    {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.png"));
        Image i2 =i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 300, 200);
        add(image);

        JLabel labelHeading = new JLabel("<html> Engineer Foundation Tech</br> Institute</html>");
        labelHeading.setBounds(70, 20,300, 130);
        labelHeading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(labelHeading);

        JLabel labelName = new JLabel("Aman Kumar Amar");
        labelName.setBounds(60, 260, 550, 40);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(labelName);

        JLabel contact = new JLabel("amankumaramar93@gmail.com");
        contact.setBounds(60, 340, 550, 40);
        contact.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(contact);

        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(new Color(252, 228, 210));
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    public static void main(String[] args)
    {
        new About();
    }
}

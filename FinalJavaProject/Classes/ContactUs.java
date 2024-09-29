package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactUs
{
    private JLabel l,l1,l2,l3,l4,l5,l6,l7;
    private JLabel imgLable;
    private ImageIcon bImg;
    Font f1 = new Font("Garet", Font.TYPE1_FONT, 16);
    Font f2 = new Font("Garet", Font.TYPE1_FONT, 35);
    Font f3 = new Font("Arial", Font.ITALIC, 16);
    Color c1 = (Color.WHITE);


    public ContactUs ()
    {
        JFrame frame= new JFrame("Contact Us");
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/frameIcon.jpg"));
        frame.setIconImage(icon.getImage());
        bImg = new ImageIcon(getClass().getResource("/Images/contactUs.jpg"));
        imgLable = new JLabel(bImg);
        imgLable.setBounds(0,0,700,700);
        frame.add(imgLable);
        frame.setSize(700,743);
        l=new JLabel("Contact Us");
        l.setFont(f2);
        l.setForeground(c1);
        l.setBounds(250,60,400,200);


        l1=new JLabel("Kuratoli,  Kuril,  Dhaka");
        l1.setBounds(220,235,250,50);
        l1.setForeground(c1);
        l1.setFont(f1);

        l5=new JLabel("--------------------------------------------------------------------------");
        l5.setForeground(c1);
        l5.setFont(f3);
        l5.setBounds(150,280,700,30);

        l2=new JLabel("01712-345678");
        l2.setForeground(c1);
        l2.setFont(f1);
        l2.setBounds(220,320,150,30);


        l6=new JLabel("--------------------------------------------------------------------------");
        l6.setForeground(c1);
        l6.setFont(f3);
        l6.setBounds(150,360,700,30);

        l3=new JLabel("wificity@gmail.com");
        l3.setForeground(c1);
        l3.setFont(f1);
        l3.setBounds(220,405,250,30);

        l7=new JLabel("--------------------------------------------------------------------------");
        l7.setForeground(c1);
        l7.setFont(f3);
        l7.setBounds(150,450, 700,30);


        l4=new JLabel("www.wificity.com");
        l4.setForeground(c1);
        l4.setFont(f1);
        l4.setBounds(220,490,150,30);
        imgLable.add(l);
        imgLable.add(l1);
        imgLable.add(l2);
        imgLable.add(l3);
        imgLable.add(l4);
        imgLable.add(l5);
        imgLable.add(l6);
        imgLable.add(l7);

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 620, 120, 35);
        backButton.setForeground(Color.black);
        backButton.setFont(f1);
        backButton.setBackground(new Color(253, 204, 68));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new UserDashboard();
            }
        });
        imgLable.add(backButton);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
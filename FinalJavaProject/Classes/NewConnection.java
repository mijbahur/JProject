package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewConnection {
    Font f1 = new Font("Arimo", Font.BOLD, 12);
    Font f4 = new Font("Arimo", Font.BOLD, 16);
    Font f2 = new Font("Arimo", Font.TYPE1_FONT, 35);
    Font f3 = new Font("Arimo", Font.TYPE1_FONT, 20);
    Font f5 = new Font("Arimo", Font.BOLD, 14);
    Color c1 = (Color.WHITE);

    private JLabel imgLable;
    private ImageIcon bImg;


    public NewConnection()
    {
        JFrame frame= new JFrame("New Connection");
        bImg = new ImageIcon(getClass().getResource("/Images/packageSelection.jpg"));
        imgLable = new JLabel(bImg);
        imgLable.setBounds(0,0,600,600);
        frame.add(imgLable);
        frame.setSize(615,644);
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/frameIcon.jpg"));
        frame.setIconImage(icon.getImage());


        JLabel l1= new JLabel("Monthly Plan");
        imgLable.add(l1);
        l1.setForeground(c1);
        l1.setFont(new Font("Arimo", Font.TYPE1_FONT, 22));
        l1.setBounds(230,20, 300, 50);

        JLabel l2= new JLabel("Wifi City");
        imgLable.add(l2);
        l2.setForeground(c1);
        l2.setFont(new Font("Arimo", Font.PLAIN, 46));
        l2.setBounds(210,70, 400, 60);

        JLabel l3= new JLabel("Basic");
        imgLable.add(l3);
        l3.setForeground(new Color(90, 93, 170));
        l3.setFont(f3);
        l3.setBounds(110,160, 100, 50);

        JLabel l4= new JLabel("Standard");
        imgLable.add(l4);
        l4.setForeground(new Color(93, 190, 173));
        l4.setFont(f3);
        l4.setBounds(255,160, 100, 50);

        JLabel l5= new JLabel("Premium");
        imgLable.add(l5);
        l5.setForeground(new Color(243, 183, 76));
        l5.setFont(f3);
        l5.setBounds(420,160, 100, 50);


        JLabel l6= new JLabel("$10");
        imgLable.add(l6);
        l6.setForeground(new Color(90, 93, 170));
        l6.setFont(f2);
        l6.setBounds(105,200, 100, 40);


        JLabel l7= new JLabel("$15");
        imgLable.add(l7);
        l7.setForeground(new Color(93, 190, 173));
        l7.setFont(f2);
        l7.setBounds(275,200, 100, 40);


        JLabel l8= new JLabel("$25");
        imgLable.add(l8);
        l8.setForeground(new Color(243, 183, 76));
        l8.setFont(f2);
        l8.setBounds(430,200, 100, 40);

        JLabel l9= new JLabel("24 HOURS UNLIMITED");
        imgLable.add(l9);
        l9.setForeground(c1);
        l9.setFont(f1);
        l9.setBounds(75,300, 200, 40);

        JLabel l10= new JLabel("Fiber Optics");
        imgLable.add(l10);
        l10.setForeground(c1);
        l10.setFont(f5);
        l10.setBounds(100,340, 200, 40);
        JLabel l16= new JLabel("5 MBPS");
        imgLable.add(l16);
        l16.setForeground(c1);
        l16.setFont(f4);
        l16.setBounds(105,260, 200, 40);

        JLabel l11= new JLabel("24/7 Customer Care" );
        imgLable.add(l11);
        l11.setForeground(c1);
        l11.setFont(f1);
        l11.setBounds(80,380, 200, 40);

        JLabel l12= new JLabel("10 MBPS");
        imgLable.add(l12);
        l12.setForeground(c1);
        l12.setFont(f4);
        l12.setBounds(265,260, 200, 40);

        JLabel l13= new JLabel("Fiber Optics");
        imgLable.add(l13);
        l13.setForeground(c1);
        l13.setFont(f5);
        l13.setBounds(255,300, 200, 40);

        JLabel l17= new JLabel("Bongo Subscription");
        imgLable.add(l17);
        l17.setForeground(c1);
        l17.setFont(f1);
        l17.setBounds(245,340, 200, 40);



        JLabel l15= new JLabel("24/7 Customer Care" );
        imgLable.add(l15);
        l15.setForeground(c1);
        l15.setFont(f1);
        l15.setBounds(245,380, 200, 40);





        JLabel l18= new JLabel("15 MBPS");
        imgLable.add(l18);
        l18.setForeground(c1);
        l18.setFont(f4);
        l18.setBounds(430,260, 200, 40);

        JLabel l19= new JLabel("Fiber Optics");
        imgLable.add(l19);
        l19.setForeground(c1);
        l19.setFont(f5);
        l19.setBounds(420,300, 200, 40);

        JLabel l20= new JLabel("Netflix Subscription");
        imgLable.add(l20);
        l20.setForeground(c1);
        l20.setFont(f1);
        l20.setBounds(410,340, 200, 40);


        JLabel l21= new JLabel("24/7 Customer Care" );
        imgLable.add(l21);
        l21.setForeground(c1);
        l21.setFont(f1);
        l21.setBounds(410,380, 200, 40);




        JButton backButton = new JButton("Back");
        backButton.setBounds(70, 530, 100, 35);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(f5);
        backButton.setBackground(new Color(251, 69, 71));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new UserDashboard();
            }
        });
        imgLable.add(backButton);

        JButton btn1 = new JButton("SELECT PLAN");
        btn1.setBounds(85, 450, 100, 30);
        btn1.setFont(f1);
        btn1.setForeground(new Color(69, 87, 169));
        btn1.setBackground(new Color(253, 253, 253));
        btn1.setBorder(BorderFactory.createBevelBorder(5));
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new Payment();
            }
        });
        imgLable.add(btn1);

        JButton btn2 = new JButton("SELECT PLAN");
        btn2.setBounds(250, 450, 100, 30);
        btn2.setFont(f1);
        btn2.setForeground(new Color(69, 87, 169));
        btn2.setBackground(new Color(253, 253, 253));
        btn2.setBorder(BorderFactory.createBevelBorder(5));
        btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new Payment();
            }
        });
        imgLable.add(btn2);

        JButton btn3 = new JButton("SELECT PLAN");
        btn3.setBounds(415, 450, 100, 30);
        btn3.setFont(f1);
        btn3.setForeground(new Color(69, 87, 169));
        btn3.setBackground(new Color(253, 253, 253));
        btn3.setBorder(BorderFactory.createBevelBorder(5));
        btn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new Payment();
            }
        });
        imgLable.add(btn3);



        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

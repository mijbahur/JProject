package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UserDashboard {

    private JFrame frame;
    private JLabel l1, l2, l3, l4, l5 ;
    private JLabel imgLable;
    private ImageIcon bImg;

    public UserDashboard(){
        frame = new JFrame("User Dashboard");
        frame.setSize(1000, 600);


        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/frameIcon.jpg"));
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);

        JPanel a = new JPanel();
        a.setLayout(null);
        a.setBounds(0,0,525,600);
        a.setBackground(new Color(255, 255, 255));
        frame.add(a);


        JLabel t1 = new JLabel("Dashboard");
        t1.setFont(new Font("Times New Roman", Font.BOLD, 45));
        t1.setForeground(new Color(38, 65, 128));
        t1.setBounds(130,80,300,70);
        a.add(t1);

        bImg = new ImageIcon(getClass().getResource("/Images/logo.jpg"));
        imgLable = new JLabel(bImg);
        imgLable.setBounds(100,90,300,300);
        a.add(imgLable);



        JPanel ft = new JPanel();
        ft.setBackground(new Color(34, 61, 60));
        ft.setLayout(null);
        ft.setBounds(475,0,525,600);
        frame.add(ft);


        JLabel spFeature = new JLabel("Special Feature");
        spFeature.setForeground(Color.white);
        spFeature.setBounds(200, 70, 300, 30);
        spFeature.setFont(new Font("Arial",Font.BOLD, 18));
        spFeature.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        spFeature.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "This section is not Available for now ", "Disconnect Connection",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ft.add(spFeature);

        l1=new JLabel("______________________________________________________");
        l1.setForeground(Color.white);
        l1.setBounds(70, 105, 400, 20);
        ft.add(l1);

        JButton backButton = new JButton("Back");
        backButton.setBounds(70, 500, 100, 35);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial",Font.BOLD, 18));
        backButton.setBackground(new Color(45, 81, 80));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Login();
            }
        });frame.add(backButton);

//        Show Profile

        JLabel userProfile = new JLabel("Show Profile");
        userProfile.setForeground(Color.white);
        userProfile.setBounds(210, 140, 200, 30);
        userProfile.setFont(new Font("Arial",Font.BOLD, 18));
        userProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        userProfile.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                try {
                    File file = new File("D:\\Downloads\\AIUB\\3rd Semester\\Java\\Final\\FinalJavaProject\\Data\\userdata.txt");
                    if (!file.exists()) {
                        JOptionPane.showMessageDialog(frame, "Something Went Wrong!");
                        return;
                    }

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    StringBuilder userInfo = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts[1].equals(Login.id)) {
                            userInfo.append(String.format("Name: %s\nUser ID: %s\nMobile Number: %s\nDate of Birth: %s\n", parts[0], parts[1], parts[2], parts[4]));
                            break;
                        }
                    }
                    reader.close();

                    if (userInfo.length() > 0) {
                        JOptionPane.showMessageDialog(frame, userInfo.toString(), "User Details", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Something Went Wrong!");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        ft.add(userProfile);

        l2=new JLabel("______________________________________________________");
        l2.setForeground(Color.white);
        l2.setBounds(70, 175, 400, 20);
        ft.add(l2);


        JLabel newCont = new JLabel("New Connection");
        newCont.setForeground(Color.white);
        newCont.setBounds(190, 210, 200, 30);
        newCont.setFont(new Font("Arial",Font.BOLD, 18));
        newCont.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        newCont.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new NewConnection();
            }
        });
        ft.add(newCont);


        l3=new JLabel("______________________________________________________");
        l3.setForeground(Color.white);
        l3.setBounds(70, 245, 400, 20);
        ft.add(l3);

        JLabel disCont = new JLabel("Disconnect Connection");
        disCont.setForeground(Color.white);
        disCont.setBounds(160, 280, 300, 30);
        disCont.setFont(new Font("Arial",Font.BOLD, 18));
        disCont.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        disCont.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "This section is not Available for now ", "Disconnect Connection",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ft.add(disCont);

        l4=new JLabel("______________________________________________________");
        l4.setForeground(Color.white);
        l4.setBounds(70, 315, 400, 20);
        ft.add(l4);


        JLabel payBill = new JLabel("Make Payment");
        payBill.setForeground(Color.white);
        payBill.setBounds(200, 350, 300, 30);
        payBill.setFont(new Font("Arial",Font.BOLD, 18));
        payBill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        payBill.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "This section is not Available for now ", "Disconnect Connection",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ft.add(payBill);

        l4=new JLabel("______________________________________________________");
        l4.setForeground(Color.white);
        l4.setBounds(70, 390, 400, 20);
        ft.add(l4);

        JLabel contacts = new JLabel("Contact Us");
        contacts.setForeground(Color.white);
        contacts.setBounds(225, 420, 300, 30);
        contacts.setFont(new Font("Arial",Font.BOLD, 18));
        contacts.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contacts.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new ContactUs();
            }
        });
        ft.add(contacts);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

}


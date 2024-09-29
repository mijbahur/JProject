package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPanel implements ActionListener {
    private JFrame frame;
    private JLabel imgLable, imgLable2;
    private ImageIcon bImg, bImg2;

    public AdminPanel() {
        frame = new JFrame("Admin Dashboard");
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setResizable(false);JPanel a = new JPanel();
        a.setLayout(null);
        a.setBounds(0,0,600,600);
        a.setBackground(new Color(255, 255, 255));
        frame.add(a);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/frameIcon.jpg"));
        frame.setIconImage(icon.getImage());


        JLabel t1 = new JLabel("Admin Dashboard");
        t1.setFont(new Font("Times New Roman", Font.BOLD, 40));
        t1.setForeground(new Color(38, 65, 128));
        t1.setBounds(130,30,400,70);
        a.add(t1);

        bImg = new ImageIcon(getClass().getResource("/Images/userIcon.jpg"));
        imgLable = new JLabel(bImg);
        imgLable.setBounds(30,120,250,250);
        a.add(imgLable);

        bImg2 = new ImageIcon(getClass().getResource("/Images/productIcon.png"));
        imgLable2 = new JLabel(bImg2);
        imgLable2.setBounds(320,125,250,250);
        a.add(imgLable2);



        JButton manageUsersButton = new JButton("Manage Users");
        manageUsersButton.setBounds(60, 380, 200, 35);
        manageUsersButton.setFont(new Font("Arial", Font.BOLD, 16));
        manageUsersButton.setForeground(new Color(255, 255, 255));
        manageUsersButton.setBackground(new Color(0, 153, 252));
        manageUsersButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        manageUsersButton.addActionListener(this);
        a.add(manageUsersButton);

        JButton managePackagesButton = new JButton("Manage Packages");
        managePackagesButton.setBounds(340, 380, 200, 35);
        managePackagesButton.setFont(new Font("Arial", Font.BOLD, 16));
        managePackagesButton.setForeground(new Color(255, 255, 255));
        managePackagesButton.setBackground(new Color(0, 153, 252));
        managePackagesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        managePackagesButton.addActionListener(this);
        a.add(managePackagesButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(250, 440, 100, 30);
        logoutButton.setForeground(new Color(255, 255, 255));
        logoutButton.setBackground(new Color(251, 69, 71));
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.addActionListener(this);
        a.add(logoutButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Manage Users")) {
                new ManageUsers();
                frame.dispose();;
            } else if (button.getText().equals("Manage Packages")) {
                new ManagePackages();
                frame.dispose();
            } else if (button.getText().equals("Logout")) {
                frame.dispose();
                new Login();
            }
        }
    }
}

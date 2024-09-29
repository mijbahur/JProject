package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login implements ActionListener
{
    private JLabel userIdLabel, passwordLabel, titelLabel,companyLabel;
    private JLabel imgLable;
    private ImageIcon bImg;
    private JFrame frame;
    private JButton loginButton;
    private JTextField userIdField;
    private JPasswordField passwordField;
    public static String id;
    Font f2 = new Font("Arial", Font.BOLD, 16);
    Font f1 = new Font("Safari", Font.PLAIN, 18);

    public Login() {
        frame = new JFrame("Login");
        frame.setSize(1100, 550);
        frame.setLayout(null);

        frame.setResizable(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/frameIcon.jpg"));
        frame.setIconImage(icon.getImage());

        JPanel a = new JPanel();
        a.setLayout(null);
        a.setBounds(0,0,550,550);
        a.setBackground(new Color(255, 255, 255));
        frame.add(a);


        JLabel t1 = new JLabel("Welcome To");
        t1.setFont(new Font("Times New Roman", Font.BOLD, 45));
        t1.setForeground(new Color(38, 65, 128));
        t1.setBounds(130,80,300,70);
        a.add(t1);

        bImg = new ImageIcon(getClass().getResource("/Images/logo.jpg"));
        imgLable = new JLabel(bImg);
        imgLable.setBounds(100,90,300,300);
        a.add(imgLable);


        JPanel b = new JPanel();
        b.setLayout(null);
        b.setBounds(550,0,550,550);
        b.setBackground(new Color(77, 111, 192));
        frame.add(b);

        userIdLabel = new JLabel("User ID: ");
        passwordLabel = new JLabel("Password: ");
        companyLabel = new JLabel("Wifi City");
        titelLabel = new JLabel("Admin or User Login");

        loginButton = new JButton("Log in");

        userIdField = new JTextField();
        passwordField = new JPasswordField();

        userIdLabel.setBounds(110, 140, 100, 35);
        userIdField.setBounds(110, 175, 330, 35);
        passwordLabel.setBounds(110, 240, 100, 35);
        passwordField.setBounds(110, 275, 330, 35);
        titelLabel.setBounds(130, 20, 300, 100);
        loginButton.setBounds(175, 370, 200, 40);

        userIdField.setBorder(BorderFactory.createBevelBorder(5));
        passwordField.setBorder(BorderFactory.createBevelBorder(5));

        userIdLabel.setFont(f2);
        passwordLabel.setFont(f1);
        userIdField.setFont(f1);
        passwordField.setFont(f2);


        userIdLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        titelLabel.setForeground(Color.WHITE);
        titelLabel.setFont(new Font("Arial", Font.BOLD, 28));

        loginButton.setBackground(new Color(120, 151, 214));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.addActionListener(this);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        JLabel signUpMsgLabel = new JLabel("Don't have an account?");
        signUpMsgLabel.setBounds(135, 425, 230, 30);
        signUpMsgLabel.setForeground(Color.WHITE);
        signUpMsgLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        b.add(signUpMsgLabel);

        JLabel signUp = new JLabel("Sign Up");
        signUp.setForeground(new Color(1, 255, 14));
        signUp.setBounds(362, 425, 200, 30);
        signUp.setFont(new Font("Arial", Font.BOLD, 18));
        signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUp.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new Registration();
            }
        });
        b.add(signUp);



        b.add(userIdLabel);
        b.add(passwordLabel);
        b.add(titelLabel);
        b.add(userIdField);
        b.add(passwordField);
        b.add(loginButton);


        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userId = userIdField.getText();
            String password = new String(passwordField.getPassword());


            JPanel d = new JPanel();
            d.setLayout(null);
            d.setBounds(550,0,550,650);
            d.setBackground(new Color(77, 111, 192));
            frame.add(d);

            JLabel userMessageLabel = new JLabel();
            userMessageLabel.setForeground(new Color(255, 64, 0));
            userMessageLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 15));
            userMessageLabel.setBounds(110, 210, 250, 30);
            d.add(userMessageLabel);

            JLabel passwordMessageLabel = new JLabel();
            passwordMessageLabel.setForeground(new Color(255, 65, 0));
            passwordMessageLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 15));
            passwordMessageLabel.setBounds(110, 310, 250, 30);
            d.add(passwordMessageLabel);

            if (isValidUser(userId, password)) {
                if (userId.equals("admin") && password.equals("admin123")) {
                    frame.dispose();
                    new AdminPanel();
                }
                else {
                    frame.dispose();
                    new UserDashboard();
                    id = userIdField.getText();
                }
            }
            else if (userId.isEmpty() && password.isEmpty()) {
                userIdField.setBorder(BorderFactory.createLineBorder(Color.RED));
                passwordField.setBorder(BorderFactory.createLineBorder(Color.RED));
                userMessageLabel.setText("The user ID field is required.");
                passwordMessageLabel.setText("The password field is required.");
            }else if (userId.isEmpty()) {
                userIdField.setBorder(BorderFactory.createLineBorder(Color.RED));
                userMessageLabel.setText("The user ID field is required.");
            } else if (password.isEmpty()) {
                passwordField.setBorder(BorderFactory.createLineBorder(Color.RED));
                passwordMessageLabel.setText("The password field is required.");
            }
            else {
                userIdField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                passwordField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                d.setVisible(false);
                JOptionPane.showMessageDialog(frame, "Invalid userID or password!");
            }
        }
    }

    private boolean isValidUser(String userId, String password) {
        if (userId.equals("admin") && password.equals("admin123")) {
            return true;
        }

        File fileReader = new File("D:\\Downloads\\AIUB\\3rd Semester\\Java\\Final\\FinalJavaProject\\Data\\userdata.txt");
        if (!fileReader.exists()) {
            JOptionPane.showMessageDialog(frame, "No user registered yet!");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Downloads\\AIUB\\3rd Semester\\Java\\Final\\FinalJavaProject\\Data\\userdata.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails[1].equals(userId) && userDetails[3].equals(password)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Calendar;

public class Registration implements ActionListener {
    private JFrame frame;
    private JTextField nameField, userIdField, mblNoField;
    private JPasswordField passwordField, confPasswordField;
    private JComboBox<String>  monthBox, dateBox, yearBox;
    private JLabel imgLable;
    private ImageIcon bImg;

    Font f1 = new Font("Safari", Font.BOLD, 16);
    Font f2 = new Font("Arial", Font.BOLD, 16);


    public Registration() {
        frame = new JFrame("Registration");
        frame.setSize(1000, 600);
        frame.setLayout(null);
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/frameIcon.jpg"));
        frame.setIconImage(icon.getImage());

        JPanel a = new JPanel();
        a.setLayout(null);
        a.setBounds(0,0,500,600);
        a.setBackground(new Color(255, 255, 255));
        frame.add(a);


        bImg = new ImageIcon(getClass().getResource("/Images/logo.jpg"));
        imgLable = new JLabel(bImg);
        imgLable.setBounds(100,90,300,300);
        a.add(imgLable);

        JPanel b = new JPanel();
        b.setLayout(null);
        b.setBounds(500,0,500,600);
        b.setBackground(new Color(77, 111, 192));
        frame.add(b);


        JLabel titelLabel = new JLabel("User Registration");
        titelLabel.setBounds(130, 20, 300, 60);
        titelLabel.setForeground(Color.WHITE);
        titelLabel.setFont(new Font("Arial", Font.BOLD, 28));
        b.add(titelLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(30, 100, 100, 30);
        nameLabel.setFont(f2);
        nameLabel.setForeground(Color.WHITE);
        b.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 100, 250, 30);
        nameField.setFont(f1);
        b.add(nameField);

        JLabel userIdLabel = new JLabel("User ID");
        userIdLabel.setBounds(30, 150, 100, 30);
        userIdLabel.setFont(f2);
        userIdLabel.setForeground(Color.WHITE);
        b.add(userIdLabel);

        userIdField = new JTextField();
        userIdField.setBounds(180, 150, 250, 30);
        userIdField.setFont(f1);
        b.add(userIdField);

        JLabel mblNoLabel = new JLabel("Mobile Number");
        mblNoLabel.setBounds(30, 200, 200, 30);
        mblNoLabel.setFont(f2);
        mblNoLabel.setForeground(Color.WHITE);
        b.add(mblNoLabel);

        mblNoField = new JTextField();
        mblNoField.setBounds(180, 200, 250, 30);
        mblNoField.setFont(f1);
        mblNoField.setFont(f1);
        b.add(mblNoField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30, 250, 100, 30);
        passwordLabel.setFont(f2);
        passwordLabel.setForeground(Color.WHITE);
        b.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(180, 250, 250, 30);
        passwordField.setFont(new Font("Arial", Font.BOLD, 18));
        b.add(passwordField);

        JLabel confPasswordLabel = new JLabel("Confirm Password");
        confPasswordLabel.setBounds(30, 300, 150, 30);
        confPasswordLabel.setFont(f2);
        confPasswordLabel.setForeground(Color.WHITE);
        b.add(confPasswordLabel);

        confPasswordField = new JPasswordField();
        confPasswordField.setBounds(180, 300, 250, 30);
        confPasswordField.setEchoChar('*');
        confPasswordField.setFont(new Font("Arial", Font.BOLD, 18));
        b.add(confPasswordField);

        JLabel DoBLabel = new JLabel("Date of Birth");
        DoBLabel.setBounds(30, 350, 200, 30);
        DoBLabel.setFont(f2);
        DoBLabel.setForeground(Color.WHITE);
        b.add(DoBLabel);

        String dates[] = new String [31];
        for(int i=0; i<dates.length; i++){
            dates[i] = String.valueOf(i+1);
        }
        dateBox = new JComboBox<>(dates);
        dateBox.setBounds(180, 350, 65, 30);
        dateBox.setFont(f1);
        dateBox.setForeground(Color.WHITE);
        dateBox.setBackground(new Color(77, 111, 192));
        dateBox.setBorder(BorderFactory.createEmptyBorder());
        b.add(dateBox);

        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthBox = new JComboBox<>(months);
        monthBox.setBounds(245, 350, 105, 30);
        monthBox.setFont(f1);
        monthBox.setForeground(Color.WHITE);
        monthBox.setBackground(new Color(77, 111, 192));
        monthBox.setBorder(BorderFactory.createEmptyBorder());
        b.add(monthBox);

        Calendar selectedDate = Calendar.getInstance();
        int YEAR = selectedDate.get(Calendar.YEAR);
        String years[];
        int size =YEAR-1930+1;
        years = new String [size];
        for(int i=0; i<years.length; i++){
            years[i] = String.valueOf(1950+i);//I want to Start DOF from 1900.
        }

        yearBox = new JComboBox<>(years);
        yearBox.setFont(new Font("Arial", Font.PLAIN, 15));
        yearBox.setBounds(348, 350, 83, 30);
        yearBox.setFont(f1);
        yearBox.setForeground(Color.WHITE);
        yearBox.setBackground(new Color(77, 111, 192));
        yearBox.setBorder(BorderFactory.createEmptyBorder());
        b.add(yearBox);

        JButton registerButton = new JButton("Sign Up");
        registerButton.setBounds(100, 420, 110, 35);
        registerButton.setForeground(new Color(255, 255, 255));
        registerButton.setFont(f2);
        registerButton.setBackground(new Color(0, 153, 252));
        registerButton.setBorder(BorderFactory.createBevelBorder(5));
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.addActionListener(this);
        b.add(registerButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(285, 420, 110, 35);
        clearButton.setFont(f2);
        clearButton.setForeground(new Color(255, 255, 255));
        clearButton.setBackground(new Color(251, 69, 71));
        clearButton.setBorder(BorderFactory.createBevelBorder(5));
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(this);
        b.add(clearButton);

        JLabel loginMsgLabel = new JLabel("Already have an account?");
        loginMsgLabel.setBounds(115, 470, 215, 30);
        loginMsgLabel.setForeground(Color.WHITE);
        loginMsgLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        b.add(loginMsgLabel);

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setForeground(new Color(16, 255, 0));
        loginLabel.setBounds(335, 470, 200, 30);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 18));
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new Login();
            }
        });
        b.add(loginLabel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Sign Up")) {
                String name = nameField.getText();
                String userId = userIdField.getText();
                String mblNo = mblNoField.getText();
                String password = new String(passwordField.getPassword());
                String confPassword = new String(confPasswordField.getPassword());
                boolean check = password.equals(confPassword);
                String d = (String) dateBox.getSelectedItem();
                String m = (String) monthBox.getSelectedItem();
                String y = (String) yearBox.getSelectedItem();


                if (name.isEmpty() || userId.isEmpty()||mblNo.isEmpty() || password.isEmpty() || confPassword.isEmpty() ) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields!");
                }

                else if (isUserIdExists(userId)) {
                    JOptionPane.showMessageDialog(frame, "User with this userId already exists!");
                }else if(check==false){
                    passwordField.setBorder(BorderFactory.createLineBorder(Color.RED));
                    confPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));

                    confPasswordField.setText("");
                    JOptionPane.showMessageDialog(frame, "Password does not match!");
                }else {
                    User newUser = new User(name, userId, mblNo, password, d, m, y);

                    try {

                        FileWriter writer = new FileWriter("D:\\Downloads\\AIUB\\3rd Semester\\Java\\Final\\FinalJavaProject\\Data\\userdata.txt", true);
                        writer.write(newUser.getName() + "," + newUser.getUserId() + "," + newUser.getMblNo() + "," + newUser.getPassword()+ "," + newUser.getD() + "-" +newUser.getM() + "-" + newUser.getY() +"\n");
                        writer.close();
                        JOptionPane.showMessageDialog(frame, "Registration Successful!");
                        frame.dispose();
                        new Login();
                        passwordField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                        confPasswordField.setBorder(BorderFactory.createLineBorder(Color.GREEN));

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }



            } else if (button.getText().equals("Clear")) {
                clearFields();
            }
        }
    }

    private boolean isUserIdExists(String userId) {
        try {
            File file = new File("D:\\Downloads\\AIUB\\3rd Semester\\Java\\Final\\FinalJavaProject\\Data\\userdata.txt");
            if (!file.exists()) {
                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(userId)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private void clearFields() {
        nameField.setText("");
        userIdField.setText("");
        mblNoField.setText("");
        passwordField.setText("");
        dateBox.setSelectedIndex(0);
        monthBox.setSelectedIndex(0);
        yearBox.setSelectedIndex(0);
    }
}


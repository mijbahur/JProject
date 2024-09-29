package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Calendar;


public class AddUser {

    private JFrame frame;
    private JTextField nameField, userIdField, mblNoField;
    private JPasswordField passwordField, confPasswordField;
    private Container c;
    private JComboBox<String>  monthBox, dateBox, yearBox;

    Font f1 = new Font("Safari", Font.BOLD, 16);
    Font f2 = new Font("Arial", Font.BOLD, 16);

    public AddUser() {
        initialize();
    }
    private void initialize() {

        frame = new JFrame("Add New User");
        frame.setSize(800, 650);
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/frameIcon.jpg"));
        frame.setIconImage(icon.getImage());

        c = frame.getContentPane();
        c.setBackground(new Color(30, 30, 30));
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 30);
        nameLabel.setFont(f2);
        nameLabel.setForeground(Color.WHITE);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(220, 50, 400, 30);
        nameField.setFont(f1);
        frame.add(nameField);

        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setBounds(50, 100, 100, 30);
        userIdLabel.setFont(f2);
        userIdLabel.setForeground(Color.WHITE);
        frame.add(userIdLabel);

        userIdField = new JTextField();
        userIdField.setBounds(220, 100, 400, 30);
        userIdField.setFont(f1);
        frame.add(userIdField);

        JLabel mblNoLabel = new JLabel("Mobile Number:");
        mblNoLabel.setBounds(50, 150, 200, 30);
        mblNoLabel.setFont(f2);
        mblNoLabel.setForeground(Color.WHITE);
        frame.add(mblNoLabel);

        mblNoField = new JTextField();
        mblNoField.setBounds(220, 150, 400, 30);
        mblNoField.setFont(f1);
        mblNoField.setFont(f1);
        frame.add(mblNoField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 200, 100, 30);
        passwordLabel.setFont(f2);
        passwordLabel.setForeground(Color.WHITE);
        frame.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(220, 200, 400, 30);
        passwordField.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(passwordField);

        JLabel confPasswordLabel = new JLabel("Confirm Password:");
        confPasswordLabel.setBounds(50, 250, 150, 30);
        confPasswordLabel.setFont(f2);
        confPasswordLabel.setForeground(Color.WHITE);
        frame.add(confPasswordLabel);

        confPasswordField = new JPasswordField();
        confPasswordField.setBounds(220, 250, 400, 30);
        confPasswordField.setEchoChar('*');
        confPasswordField.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(confPasswordField);

        JLabel DoBLabel = new JLabel("Date of Birth:");
        DoBLabel.setBounds(50, 300, 200, 30);
        DoBLabel.setFont(f2);
        DoBLabel.setForeground(Color.WHITE);
        frame.add(DoBLabel);

        String dates[] = new String [31];
        for(int i=0; i<dates.length; i++){
            dates[i] = String.valueOf(i+1);
        }
        dateBox = new JComboBox<>(dates);
        dateBox.setBounds(220, 300, 65, 30);
        dateBox.setFont(f1);
        dateBox.setForeground(Color.WHITE);
        dateBox.setBackground(new Color(30, 30, 30));
        dateBox.setBorder(BorderFactory.createEmptyBorder());
        frame.add(dateBox);

        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthBox = new JComboBox<>(months);
        monthBox.setBounds(285, 300, 117, 30);
        monthBox.setFont(f1);
        monthBox.setForeground(Color.WHITE);
        monthBox.setBackground(new Color(30, 30, 30));
        monthBox.setBorder(BorderFactory.createEmptyBorder());
        frame.add(monthBox);

        Calendar selectedDate = Calendar.getInstance();
        int YEAR = selectedDate.get(Calendar.YEAR);
        String years[];
        int size =YEAR-1930+1;
        years = new String [size];
        for(int i=0; i<years.length; i++){
            years[i] = String.valueOf(1930+i);//I want to Start DOF from 1900.
        }

        yearBox = new JComboBox<>(years);
        yearBox.setFont(new Font("Arial", Font.PLAIN, 15));
        yearBox.setBounds(402, 300, 83, 30);
        yearBox.setFont(f1);
        yearBox.setForeground(Color.WHITE);
        yearBox.setBackground(new Color(30, 30, 30));
        yearBox.setBorder(BorderFactory.createEmptyBorder());
        frame.add(yearBox);


        JButton addButton = new JButton("Add");
        addButton.setBounds(285, 380, 110, 35);
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setFont(f2);
        addButton.setBackground(new Color(0, 153, 252));
        addButton.setBorder(BorderFactory.createBevelBorder(5));
        addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(450, 380, 110, 35);
        clearButton.setFont(f2);
        clearButton.setForeground(new Color(255, 255, 255));
        clearButton.setBackground(new Color(251, 69, 71));
        clearButton.setBorder(BorderFactory.createBevelBorder(5));
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        frame.add(clearButton);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 550, 80, 30);
        clearButton.setFont(f2);
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setBackground(new Color(251, 69, 71));
        clearButton.setBorder(BorderFactory.createBevelBorder(5));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ManageUsers();
            }
        });
        frame.add(backButton);


    }


    private void add() {
        String name = nameField.getText();
        String userName = userIdField.getText();
        String mblNo = mblNoField.getText();
        String password = new String(passwordField.getPassword());
        String confPassword = new String(confPasswordField.getPassword());
        boolean check = password.equals(confPassword);
        String d = (String) dateBox.getSelectedItem();
        String m = (String) monthBox.getSelectedItem();
        String y = (String) yearBox.getSelectedItem();


        if (name.isEmpty() || userName.isEmpty()||mblNo.isEmpty() || password.isEmpty() || confPassword.isEmpty() ) {
            JOptionPane.showMessageDialog(frame, "Please fill all fields!");
        }

        else if (isUserIdExists(userName)) {
            JOptionPane.showMessageDialog(frame, "User with this userName already exists!");
        }else if(check==false){
            passwordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            confPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));

            confPasswordField.setText("");
            JOptionPane.showMessageDialog(frame, "Password does not match!");
        }else {
            User newUser = new User(name, userName, mblNo, password, d, m, y);

            try {

                FileWriter writer = new FileWriter("userdata.txt", true);
                writer.write(newUser.getName() + "," + newUser.getUserId() + "," + newUser.getMblNo() + "," + newUser.getPassword()+ "," + newUser.getD() + "-" +newUser.getM() + "-" + newUser.getY() +"\n");
                writer.close();
                JOptionPane.showMessageDialog(frame, "Registration Successful!");
                frame.dispose();
                new ManageUsers();
                passwordField.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                confPasswordField.setBorder(BorderFactory.createLineBorder(Color.GREEN));

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    private boolean isUserIdExists(String userName) {
        try {
            File file = new File("userdata.txt");
            if (!file.exists()) {
                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(userName)) {
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


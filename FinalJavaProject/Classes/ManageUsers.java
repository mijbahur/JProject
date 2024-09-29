package Classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ManageUsers implements ActionListener {
    private JFrame frame;
    private JLabel imgLable;
    private ImageIcon bImg;
    String[] columnsName = {"Name", "User ID", "Mobile Number", "Date of Birth"};
    Font f1 = new Font("Arimo", Font.BOLD, 20);
    Color c1 = new Color(251, 252, 251);
    Color bBackground = new Color(237, 98, 124);

    public ManageUsers() {


        frame = new JFrame("Manage Users");
        frame.setSize(1100, 600);
        frame.setLayout(null);
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/frameIcon.jpg"));
        frame.setIconImage(icon.getImage());

        JPanel a = new JPanel();
        a.setLayout(null);
        a.setBounds(0,0,550,600);
        a.setBackground(new Color(255, 255, 255));
        frame.add(a);


        JLabel t1 = new JLabel("");
        t1.setFont(new Font("Times New Roman", Font.BOLD, 45));
        t1.setForeground(new Color(38, 65, 128));
        t1.setBounds(130,80,300,70);
        a.add(t1);

        bImg = new ImageIcon(getClass().getResource("/Images/logo.jpg"));
        imgLable = new JLabel(bImg);
        imgLable.setBounds(100,80,300,300);
        a.add(imgLable);



        JPanel b = new JPanel();
        b.setBackground(new Color(143, 172, 160));
        b.setLayout(null);
        b.setBounds(550,0,550,600);
        frame.add(b);

        JLabel titleLabel = new JLabel("Manage Users");
        titleLabel.setBounds(170, 40, 300, 60);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        b.add(titleLabel);

        JButton userAccountButton = new JButton("User Account");
        userAccountButton.setBounds(150, 140, 250, 35);
        userAccountButton.setForeground(c1);
        userAccountButton.setFont(f1);
        userAccountButton.setBackground(bBackground);
        userAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        userAccountButton.addActionListener(this);
        b.add(userAccountButton);

        JButton userSearchButton = new JButton("User Search");
        userSearchButton.setBounds(150, 210, 250, 35);
        userSearchButton.setForeground(c1);
        userSearchButton.setFont(f1);
        userSearchButton.setBackground(bBackground);
        userSearchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        userSearchButton.addActionListener(this);
        b.add(userSearchButton);


        JButton addUserButton = new JButton("Add User");
        addUserButton.setBounds(150, 280, 250, 35);
        addUserButton.setForeground(c1);
        addUserButton.setFont(f1);
        addUserButton.setBackground(bBackground);
        addUserButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addUserButton.addActionListener(this);
        b.add(addUserButton);

        JButton deleteUserButton = new JButton("Delete User");
        deleteUserButton.setBounds(150, 350, 250, 35);
        deleteUserButton.setForeground(c1);
        deleteUserButton.setFont(f1);
        deleteUserButton.setBackground(bBackground);
        deleteUserButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteUserButton.addActionListener(this);
        b.add(deleteUserButton);

        JButton updateUserButton = new JButton("Update User");
        updateUserButton.setBounds(150, 420, 250, 35);
        updateUserButton.setForeground(c1);
        updateUserButton.setFont(f1);
        updateUserButton.setBackground(bBackground);
        updateUserButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateUserButton.addActionListener(this);
        b.add(updateUserButton);



        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 500, 80, 30);
        backButton.setBackground(new Color(120, 151, 214));
        backButton.setForeground(Color.WHITE);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AdminPanel();
            }
        });
        a.add(backButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(400, 500, 80, 30);
        logoutButton.setBackground(new Color(120, 151, 214));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Login();
            }
        });
        b.add(logoutButton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("User Account")) {
                frame.dispose();
                displayUsers();
            } else if (button.getText().equals("Add User")) {
                this.frame.dispose();
                new AddUser();
            }else if (button.getText().equals("Update User")) {
                JOptionPane.showMessageDialog(frame, "This section is not Available for now ", "Disconnect Connection",JOptionPane.INFORMATION_MESSAGE);
//                updateUserInfo();
            } else if (button.getText().equals("User Search")) {
                searchUser();
            } else if (button.getText().equals("Delete User")) {
                deleteUser();
            }
        }
    }

    public void displayUsers() {
        JFrame f = new JFrame("User Details");
        f.setSize(650, 600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/frameIcon.jpg"));
        f.setIconImage(icon.getImage());


        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(350, 400, 150, 40);
        refreshBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        refreshBtn.setFont(f1);
        refreshBtn.setForeground(Color.WHITE);
        refreshBtn.setBackground(Color.decode("#2E75B6"));
        f.add(refreshBtn);
        refreshBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                displayUsers();
            }
        });



        JButton backButton = new JButton("Back");
        backButton.setBounds(100, 400, 150, 40);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(f1);
        backButton.setBackground(new Color(251, 69, 71));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new ManageUsers();
            }
        });
        f.add(backButton);
        try {
            File file = new File("D:\\Downloads\\AIUB\\3rd Semester\\Java\\Final\\FinalJavaProject\\Data\\userdata.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No users registered yet!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            JTable table = new JTable();
            table.setRowHeight(30);
            JScrollPane scroll = new JScrollPane(table);
            scroll.setBounds(25,10,600,200);
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnsName);
            table.setModel(model);
            scroll.setSize(600,300);
            f.add(scroll);


            Object[] tableLine = reader.lines().toArray();
            reader.close();
            for(int i=0; i<tableLine.length; i++){
                line = tableLine[i].toString();
                try {

                    String dataRow[] = line.split(",");
                    String[] row = {dataRow[0], dataRow[1], dataRow[2],dataRow[4]};
                    model.addRow(row);
                }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){

                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


//    private void updateUserInfo() {
//
//
//        File file = new File("userdata.txt");
//        if (!file.exists()) {
//            JOptionPane.showMessageDialog(frame, "No users registered yet!");
//            return;
//        }
//
//        String userId = JOptionPane.showInputDialog(frame, "Enter userId of the user to update:");
//        if (userId == null || userId.isEmpty()) {
//            JOptionPane.showMessageDialog(frame, "User ID cannot be empty!");
//            return;
//        }
//
//        String[][] usersData;
//        boolean userFound = false;
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String line;
//            int numUsers = countLines(file);
//            usersData = new String[numUsers][];
//            int index = 0;
//
//            while ((line = reader.readLine()) != null) {
//                usersData[index] = line.split(",");
//                if (usersData[index][1].equals(userId)) {
//                    userFound = true;
//                    String newName = JOptionPane.showInputDialog(frame, "Enter new name:", usersData[index][0]);
//                    String newMobile = JOptionPane.showInputDialog(frame, "Enter new mobile number:", usersData[index][2]);
//                    String newPassword = JOptionPane.showInputDialog(frame, "Enter new password:", usersData[index][3]);
//                    usersData[index][0] = newName;
//                    usersData[index][2] = newMobile;
//                    usersData[index][3] = newPassword;
//                    JOptionPane.showMessageDialog(frame, "User details updated successfully!");
//                    break;
//                }
//                index++;
//            }
//
//            if (!userFound) {
//                JOptionPane.showMessageDialog(frame, "User not found!");
//                return;
//            }
//                try (FileWriter writer = new FileWriter(file)) {
//                    for (String[] userData : usersData) {
//                        writer.write(String.join(",", userData) + "\n");
//                    }
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }

    private void searchUser() {
        String userId = JOptionPane.showInputDialog(frame, "Enter userId of the user to search:");
        if (userId == null || userId.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "User Id cannot be empty!");
            return;
        }

        try {
            File file = new File("D:\\Downloads\\AIUB\\3rd Semester\\Java\\Final\\FinalJavaProject\\Data\\userdata.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No users registered yet!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder userInfo = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(userId)) {
                    userInfo.append(String.format("Name: %s\nUser ID: %s\nMobile Number: %s\nDate of Birth: %s\n", parts[0], parts[1], parts[2], parts[4]));
                    break;
                }
            }
            reader.close();

            if (userInfo.length() > 0) {
                JOptionPane.showMessageDialog(frame, userInfo.toString(), "User Details", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "User not found!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteUser() {
        String userId = JOptionPane.showInputDialog(frame, "Enter userId of the user to delete:");
        if (userId == null || userId.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "User Id cannot be empty!");
            return;
        }

        String[][] lines = null;
        try {
            File file = new File("D:\\Downloads\\AIUB\\3rd Semester\\Java\\Final\\FinalJavaProject\\Data\\userdata.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No users registered yet!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int numUsers = countLines(file);
            lines = new String[numUsers][];
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (!parts[1].equals(userId)) {
                    lines[count++] = parts;
                }
            }
            reader.close();

            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < count; i++) {
                writer.write(String.join(",", lines[i]) + "\n");
            }
            writer.close();

            JOptionPane.showMessageDialog(frame, "User deleted successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private int countLines(File file) throws IOException {
        int lines = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
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
}


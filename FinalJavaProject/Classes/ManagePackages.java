package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ManagePackages implements ActionListener {
    private JFrame frame;
    private JLabel imgLable;
    private ImageIcon bImg;
    String[] columnsName = {"Name", "Package ID", "MBPS", "Price"};
    Font f1 = new Font("Arimo", Font.BOLD, 20);
    Color c1 = new Color(251, 252, 251);
    Color bBackground = new Color(237, 98, 124);

    public ManagePackages() {
        frame = new JFrame("Manage Packages");
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

        JLabel titleLabel = new JLabel("Manage Packages");
        titleLabel.setBounds(147, 40, 300, 60);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        b.add(titleLabel);

        JButton userAccountButton = new JButton("Package Details");
        userAccountButton.setBounds(150, 140, 250, 35);
        userAccountButton.setForeground(c1);
        userAccountButton.setFont(f1);
        userAccountButton.setBackground(bBackground);
        userAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        userAccountButton.addActionListener(this);
        b.add(userAccountButton);

        JButton userSearchButton = new JButton("Package Search");
        userSearchButton.setBounds(150, 210, 250, 35);
        userSearchButton.setForeground(c1);
        userSearchButton.setFont(f1);
        userSearchButton.setBackground(bBackground);
        userSearchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        userSearchButton.addActionListener(this);
        b.add(userSearchButton);


        JButton addPackage = new JButton("Add Package");
        addPackage.setBounds(150, 280, 250, 35);
        addPackage.setForeground(c1);
        addPackage.setFont(f1);
        addPackage.setBackground(bBackground);
        addPackage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addPackage.addActionListener(this);
        b.add(addPackage);


        JButton deleteUserButton = new JButton("Delete Package");
        deleteUserButton.setBounds(150, 350, 250, 35);
        deleteUserButton.setForeground(c1);
        deleteUserButton.setFont(f1);
        deleteUserButton.setBackground(bBackground);
        deleteUserButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteUserButton.addActionListener(this);
        b.add(deleteUserButton);

        JButton updateUserButton = new JButton("Update Package");
        updateUserButton.setBounds(150, 420, 250, 35);
        updateUserButton.setForeground(c1);
        updateUserButton.setFont(f1);
        updateUserButton.setBackground(bBackground);
        updateUserButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateUserButton.addActionListener(this);
        b.add(updateUserButton);


        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 500, 100, 35);
        backButton.setForeground(c1);
        backButton.setFont(new Font("Arial", Font.TYPE1_FONT, 18));
        backButton.setBackground(new Color(39, 55, 142));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AdminPanel();
            }
        });
        a.add(backButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(380, 500, 100, 35);
        logoutButton.setForeground(c1);
        logoutButton.setFont(new Font("Arial", Font.TYPE1_FONT, 17));
        logoutButton.setBackground(bBackground);
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
            if (button.getText().equals("Package Details")) {
                displayPackages();
            }else if (button.getText().equals("Add Package")) {
                frame.dispose();
                new AddPackage();
            } else if (button.getText().equals("Update Package")) {
                JOptionPane.showMessageDialog(frame, "This section is not Available for now ", "Disconnect Connection",JOptionPane.INFORMATION_MESSAGE);
//                updatePackageInfo();
            } else if (button.getText().equals("Package Search")) {
                searchPackage();
            } else if (button.getText().equals("Delete Package")) {
                deletePackage();
            }
        }
    }

    public void displayPackages() {
        try {
            File file = new File("D:\\Downloads\\AIUB\\3rd Semester\\Java\\Final\\FinalJavaProject\\Data\\packagedata.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No packages added yet!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder packagesInfo = new StringBuilder();
            int numPackages = countLines(file);
            String[] packagesData = new String[numPackages];
            int index = 0;
            while ((line = reader.readLine()) != null) {
                packagesData[index++] = line;
                String[] parts = line.split(",");
                String packageInfo = String.format("Name: %s\nPackage ID: %s\nMBPS: %s\nPrice: %s\n------------------------------------------\n", parts[0], parts[1], parts[2], parts[3]);
                packagesInfo.append(packageInfo);
            }
            reader.close();

            JTextArea textArea = new JTextArea(packagesInfo.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(frame, scrollPane, "Registered Users", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void updatePackageInfo() {
        String packageId = JOptionPane.showInputDialog(frame, "Enter packageId of the package to update:");
        if (packageId == null || packageId.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Email cannot be empty!");
            return;
        }
        frame.dispose();
//        new UpdateUser(packageId, new ManageUsers());
        /*String[][] lines = null;
        try {
            File file = new File("userdata.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No users registered yet!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int numPackages = countLines(file);
            lines = new String[numPackages][];
            int index = 0;
            while ((line = reader.readLine()) != null) {
                lines[index++] = line.split(",");
                if (lines[index - 1][1].equals(packageId)) {
                    String name = JOptionPane.showInputDialog(frame, "Enter new name:");
                    String password = JOptionPane.showInputDialog(frame, "Enter new password:");
                    String gender = JOptionPane.showInputDialog(frame, "Enter new gender:");
                    lines[index - 1] = new String[]{name, packageId, password, gender};
                }
            }
            reader.close();

            FileWriter writer = new FileWriter(file);
            for (String[] updatedLine : lines) {
                writer.write(String.join(",", updatedLine) + "\n");
            }
            writer.close();

            JOptionPane.showMessageDialog(frame, "Package information updated successfully!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }

    private void searchPackage() {
        String packageId = JOptionPane.showInputDialog(frame, "Enter packageId of the package to search:");
        if (packageId == null || packageId.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Email cannot be empty!");
            return;
        }

        try {
            File file = new File("D:\\Downloads\\AIUB\\3rd Semester\\Java\\Final\\FinalJavaProject\\Data\\packagedata.txt");
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "No users registered yet!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder packageInfo = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(packageId)) {
                    packageInfo.append(String.format("Name: %s\nPackage ID: %s\nMBPS: %s\nPrice: %s\n", parts[0], parts[1], parts[2], parts[3]));
                    break;
                }
            }
            reader.close();

            if (packageInfo.length() > 0) {
                JOptionPane.showMessageDialog(frame, packageInfo.toString(), "Package Details", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Package not found!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void deletePackage() {
        String packageId = JOptionPane.showInputDialog(frame, "Enter packageId of the package to delete:");
        if (packageId == null || packageId.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Email cannot be empty!");
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
            int numPackages = countLines(file);
            lines = new String[numPackages][];
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (!parts[1].equals(packageId)) {
                    lines[count++] = parts;
                }
            }
            reader.close();

            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < count; i++) {
                writer.write(String.join(",", lines[i]) + "\n");
            }
            writer.close();

            JOptionPane.showMessageDialog(frame, "Package deleted successfully!");
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
}

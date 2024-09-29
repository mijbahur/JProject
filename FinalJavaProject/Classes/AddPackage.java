package Classes;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AddPackage implements ActionListener {
    private JFrame frame;
    private JTextField packageNameField, packageIdField, mbpsField;
    private JTextField priceField;
    private Container c;



    Border redBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255, 128, 0));
    Font f1 = new Font("Comic Sans MS", Font.BOLD, 16);
    Font f2 = new Font("Arial", Font.BOLD, 16);


    public AddPackage() {
        UIManager.put("TextField.caretForeground", new ColorUIResource(255,255,255));
        UIManager.put("priceField.caretForeground", new ColorUIResource(255,255,255));
        frame = new JFrame("Add New Package");
        frame.setSize(600, 470);
        c = frame.getContentPane();
        c.setBackground(new Color(30, 30, 30));
        frame.setLayout(null);
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/frameIcon.jpg"));
        frame.setIconImage(icon.getImage());

        JLabel PackageNameLabel = new JLabel("Package Name:");
        PackageNameLabel.setBounds(50, 50, 200, 30);
        PackageNameLabel.setFont(f2);
        PackageNameLabel.setForeground(Color.WHITE);
        frame.add(PackageNameLabel);

        packageNameField = new JTextField();
        packageNameField.setBounds(200, 50, 350, 30);
        packageNameField.setBackground(new Color(30, 30, 30));
        packageNameField.setForeground(Color.WHITE);
        packageNameField.setFont(f1);
        packageNameField.setBorder(BorderFactory.createEmptyBorder());
        packageNameField.setBorder(redBorder);
        frame.add(packageNameField);

        JLabel PackageIdLabel = new JLabel("Package ID:");
        PackageIdLabel.setBounds(50, 100, 100, 30);
        PackageIdLabel.setFont(f2);
        PackageIdLabel.setForeground(Color.WHITE);
        frame.add(PackageIdLabel);

        packageIdField = new JTextField();
        packageIdField.setBounds(200, 100, 350, 30);
        packageIdField.setForeground(Color.WHITE);
        packageIdField.setFont(f1);
        packageIdField.setBackground(new Color(30, 30, 30));
        packageIdField.setBorder(BorderFactory.createEmptyBorder());
        packageIdField.setBorder(redBorder);
        packageIdField.setFont(f1);
        frame.add(packageIdField);
        frame.add(packageNameField);

        JLabel mbpsLabel = new JLabel("MBPS: ");
        mbpsLabel.setBounds(50, 150, 200, 30);
        mbpsLabel.setFont(f2);
        mbpsLabel.setForeground(Color.WHITE);
        frame.add(mbpsLabel);

        mbpsField = new JTextField();
        mbpsField.setBounds(200, 150, 350, 30);
        mbpsField.setForeground(Color.WHITE);
        mbpsField.setFont(f1);
        mbpsField.setBackground(new Color(30, 30, 30));
        mbpsField.setBorder(BorderFactory.createEmptyBorder());
        mbpsField.setBorder(redBorder);
        mbpsField.setFont(f1);
        frame.add(mbpsField);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(50, 200, 100, 30);
        priceLabel.setFont(f2);
        priceLabel.setForeground(Color.WHITE);
        frame.add(priceLabel);

        priceField = new JTextField();

        priceField.setBounds(200, 200, 350, 30);
        priceField.setForeground(Color.WHITE);
        priceField.setFont(new Font("Arial", Font.BOLD, 18));
        priceField.setBorder(BorderFactory.createEmptyBorder());
        priceField.setBorder(redBorder);
        priceField.setBackground(new Color(30, 30, 30));
        frame.add(priceField);



        JButton backButton = new JButton("Back");
        backButton.setBounds(90, 340, 100, 30);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(f2);
        backButton.setBackground(new Color(251, 69, 71));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ManageUsers();
            }
        });
        frame.add(backButton);

        JButton addPackageButton = new JButton("Add Package");
        addPackageButton.setBounds(220, 340, 130, 30);
        addPackageButton.setForeground(new Color(255, 255, 255));
        addPackageButton.setFont(f2);
        addPackageButton.setBackground(new Color(0, 153, 252));
        addPackageButton.setBorder(BorderFactory.createBevelBorder(5));
        addPackageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addPackageButton.addActionListener(this);
        frame.add(addPackageButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(380, 340, 100, 30);
        clearButton.setFont(f2);
        clearButton.setForeground(new Color(255, 255, 255));
        clearButton.setBackground(new Color(251, 69, 71));
        clearButton.setBorder(BorderFactory.createBevelBorder(5));
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(this);
        frame.add(clearButton);



        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Add Package")) {
                String packageName = packageNameField.getText();
                String packageId = packageIdField.getText();
                String mbps = mbpsField.getText();
                String price = new String(priceField.getText());


                if (packageName.isEmpty() || packageId.isEmpty() || mbps.isEmpty() || price.isEmpty() ) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields!");
                }

                else if (isUserIdExists(packageId)) {
                    JOptionPane.showMessageDialog(frame, "Package with this packageId already exists!");
                }
                else if (isUserNameExists(packageName)) {
                    JOptionPane.showMessageDialog(frame, "Tow Package name can not be same!","ERROR",2);
                }else {
                    Package newPackage = new Package(packageName, packageId, mbps, price);

                    try {
                        FileWriter writer = new FileWriter("packagedata.txt", true);
                        writer.write(newPackage.getPackageName() + "," + newPackage.getPackageId() + "," + newPackage.getMbps() + "," + newPackage.getPrice() +"\n");
                        writer.close();
                        JOptionPane.showMessageDialog(frame, "New Package Add Successfully!");
                        frame.dispose();
                        new ManagePackages();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }



            } else if (button.getText().equals("Clear")) {
                clearFields();
            }
        }
    }

    private boolean isUserIdExists(String packageId) {
        try {
            File file = new File("packagedata.txt");
            if (!file.exists()) {
                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[1].equals(packageId)) {
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
    private boolean isUserNameExists(String packageName) {
        try {
            File file = new File("packagedata.txt");
            if (!file.exists()) {
                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(packageName)) {
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
        packageNameField.setText("");
        packageIdField.setText("");
        mbpsField.setText("");
        priceField.setText("");
    }
}

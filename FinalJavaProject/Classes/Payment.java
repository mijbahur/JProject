package Classes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Payment  {
    private JLabel label1, label2, label3, l2, l3;
    private Font f1, f2, f3, f4, f5, f6;
    private JTextField tf1, tf2, tf3;
    private JPasswordField pf;
    private JButton btn1, btn3;
    private Cursor cursor;
    private JLabel imgLable;
    private ImageIcon bImg;

    Payment() {

        JFrame frame = new JFrame("Wifi City");
        // Frame Layout
        frame.setSize(900, 500);
        frame.setResizable(false);

        JPanel a = new JPanel();
        a.setLayout(null);
        a.setBounds(0,0,900,500);
        a.setBackground(new Color(255, 255, 255));
        frame.add(a);

        bImg = new ImageIcon(getClass().getResource("/Images/logo.jpg"));
        imgLable = new JLabel(bImg);
        imgLable.setBounds(30,5,300,300);
        a.add(imgLable);

        frame.setLayout(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Images/frameIcon.jpg"));
        frame.setIconImage(icon.getImage());

        f1 = new Font("Segoe UI Black", Font.PLAIN, 35);
        f2 = new Font("Segoe UI Semibold", Font.PLAIN, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);
        f4 = new Font("Segoe UI", Font.PLAIN, 15);
        f5 = new Font("Segoe UI Black", Font.PLAIN, 15);
        f6 = new Font("Segoe UI Black", Font.PLAIN, 25);



        label1 = new JLabel();
        label1.setText("Complete Your Payment");
        label1.setBounds(400, 20, 500, 50);
        label1.setFont(f1);
        a.add(label1);

        label2 = new JLabel("We Accept Only Visa Card");
        label2.setBounds(420, 85, 500, 50);
        label2.setFont(f2);
        a.add(label2);

        l2 = new JLabel("Card Details");
        l2.setBounds(420, 140, 500, 50);
        l2.setFont(f2);
        a.add(l2);

        label3 = new JLabel("Name On Card");
        label3.setBounds(430, 180, 500, 50);
        label3.setFont(f3);
        a.add(label3);

        tf1 = new JTextField();
        tf1.setBounds(570, 190, 235, 30);
        tf1.setFont(f4);
        a.add(tf1);

        // Card Number
        l3 = new JLabel("Card Number");
        l3.setBounds(430, 220, 500, 50);
        l3.setFont(f3);
        a.add(l3);

        tf2 = new JTextField();
        tf2.setBounds(570, 230, 235, 30);
        tf2.setFont(f4);
        tf2.setHorizontalAlignment(JTextField.CENTER);
        a.add(tf2);

        // Valid On
        label3 = new JLabel("Valid On");
        label3.setBounds(430, 260, 500, 50);
        label3.setFont(f3);
        a.add(label3);

        tf3 = new JTextField();
        tf3.setBounds(520, 270, 90, 30);
        tf3.setFont(f4);
        tf3.setHorizontalAlignment(JTextField.CENTER);
        a.add(tf3);

        // CVV Code
        label3 = new JLabel("CVV Code");
        label3.setBounds(620, 260, 500, 50);
        label3.setFont(f3);
        a.add(label3);

        pf = new JPasswordField();
        pf.setBounds(725, 270, 80, 30);
        pf.setHorizontalAlignment(JPasswordField.CENTER);
        pf.setEchoChar('*');
        pf.setFont(f5);
        a.add(pf);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("Back");
        btn1.setBounds(75, 325, 190, 50);
        btn1.setFont(f6);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        a.add(btn1);

        btn3 = new JButton("Confirm Payment");
        btn3.setBounds(524, 325, 300, 50);
        btn3.setFont(f6);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#2E75B6"));
        a.add(btn3);

        // To limit characters
        tf1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tf1.getText().length() >= 10 )
                    e.consume();
            }
        });

        tf2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tf2.getText().length() >= 19 )
                    e.consume();
            }
        });

        tf3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (tf3.getText().length() >= 7 )
                    e.consume();
            }
        });

        pf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (pf.getText().length() >= 3 )
                    e.consume();
            }
        });

        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new NewConnection();
            }
        });

        // Confirm Payment Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String nameOnCard = tf1.getText();
                String cardNumber = tf2.getText();
                String validOn = tf3.getText();
                String cvvCode = pf.getText();

                if (nameOnCard.isEmpty() || cardNumber.isEmpty() || validOn.isEmpty() || cvvCode.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Payment Successfully Done ", "Confirmation",JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    new UserDashboard();

                }
            }
        });


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

    }
}


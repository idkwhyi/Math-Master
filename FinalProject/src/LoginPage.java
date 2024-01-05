import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.awt.*;

public class LoginPage extends JPanel {

    private DatabaseManager databaseManager;
    private String enteredUsername;

    Style style = new Style();

    LoginPage(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        initComponents();
    }

    // JButton submitButton;
    RoundedButton submitButton;
    RoundedButton createAccount;

    public void initComponents() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
        setPreferredSize(new Dimension(1280, 720));
        setBackground(style.backgroundColor);

        // styling
        Font titleFont = new Font(style.font_title, Font.BOLD, style.h1);
        Font labelFont = new Font(style.font_text, Font.BOLD, style.h3);
        Font inputFont = new Font(style.font_text, Font.PLAIN, style.text_font_big);
        Font buttonFont = new Font(style.font_button, Font.BOLD, style.text_font_medium);
        Font createAccountFont = new Font(style.font_button, Font.PLAIN, style.text_font_small);

        int top = 1;
        int right = 7;
        int bottom = 1;
        int left = 7;
        int borderRadius = 10;
        // styling

        JPanel marginTop = new JPanel();
        marginTop.setBackground(style.backgroundColor);
        marginTop.setPreferredSize(new Dimension(60, 0));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 20, 10));
        mainPanel.setBackground(style.backgroundColor);

        JLabel loginTitle = new JLabel("Log In to Your Account");
        loginTitle.setFont(titleFont);
        loginTitle.setHorizontalAlignment(JLabel.CENTER);
        loginTitle.setVerticalAlignment(JLabel.CENTER);
        loginTitle.setForeground(style.whiteColor);
        loginTitle.setOpaque(false);

        // username
        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new GridLayout(2, 1, 0, 5));
        usernamePanel.setPreferredSize(new Dimension(200, 100));
        usernamePanel.setBackground(style.backgroundColor);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(labelFont);
        usernameLabel.setForeground(style.whiteColor);
        usernameLabel.setOpaque(false);

        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(250, 40));
        usernameField.setFont(inputFont);
        usernameField.setBorder(new EmptyBorder(top, left, bottom, right));

        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        // password
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new GridLayout(2, 1, 0, 5));
        passwordPanel.setPreferredSize(new Dimension(300, 100));
        passwordPanel.setBackground(style.backgroundColor);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(labelFont);
        passwordLabel.setForeground(style.whiteColor);
        passwordLabel.setOpaque(false);

        JTextField passwordField = new JTextField();
        passwordField.setPreferredSize(new Dimension(250, 40));
        passwordField.setFont(inputFont);
        passwordField.setBorder(new EmptyBorder(top, left, bottom, right));

        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        // buttons
        submitButton = new RoundedButton("Login");
        submitButton.setFont(buttonFont);
        submitButton.setPreferredSize(new Dimension(200, 75));
        submitButton.setForeground(style.whiteColor);
        submitButton.setBackground(style.purpleColor);
        submitButton.setBorder(new EmptyBorder(10, 20, 10, 20)); // Padding for text
        submitButton.setCornerRadius(borderRadius);

        createAccount = new RoundedButton("Create New Account");
        createAccount.setFont(createAccountFont);
        createAccount.setPreferredSize(new Dimension(200, 75));
        createAccount.setForeground(style.greyColor);
        createAccount.setBackground(new Color(0xffffff));
        createAccount.setBorder(new EmptyBorder(10, 20, 10, 20)); // Padding for text
        createAccount.setCornerRadius(borderRadius);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(style.backgroundColor);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(submitButton);
        buttonPanel.add(createAccount);

        mainPanel.add(marginTop);
        mainPanel.add(loginTitle);
        mainPanel.add(usernamePanel);
        mainPanel.add(passwordPanel);
        mainPanel.add(buttonPanel);

        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
        setAlignmentY(Component.CENTER_ALIGNMENT);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enteredUsername = usernameField.getText();
                String enteredPassword = passwordField.getText();

                Container container = getParent();
                Component[] components = container.getComponents();
                for (Component component : components) {
                    if (component instanceof HomePage) {
                        container.remove(component);
                    }
                }
                CardLayout cardLayout = (CardLayout) container.getLayout();

                boolean loginSuccess = databaseManager.loginUser(enteredUsername, enteredPassword);

                if (loginSuccess) {
                    HomePage home = new HomePage(enteredUsername);
                    container.add(home, "home");
                    cardLayout.show(container, "home");
                    container.revalidate();
                    container.repaint();
                } else {
                    JOptionPane.showMessageDialog(LoginPage.this,
                            "Username or password wrong. Please check again!", "Login Error",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        createAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "register");
            }
        });
    }

    public String getUsername() {
        return enteredUsername;
    }
}
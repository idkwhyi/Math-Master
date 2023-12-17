import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Mode1 extends JPanel{

    private JPanel leaderboardPanel = new JPanel();

    Mode1(){
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setPreferredSize(new Dimension(1280, 720));
        
        JPanel centerPanel = new JPanel(new GridLayout(4, 5, 10, 10));
        centerPanel.setBounds(280, 160, 720, 400);

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 80));
        backButton.setBounds(10, 10, 150, 70);

        JButton leaderboard = new JButton("Leaderboard");
        leaderboard.setPreferredSize(new Dimension(200, 80));
        leaderboard.setBounds(1080, 10, 150, 70);

        JLabel titleLabel = new JLabel("Mode 1", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setBounds(280, 120, 720, 40);

        JButton level = new JButton("Level");

        centerPanel.add(level);
        centerPanel.add(new JButton("level"));
        centerPanel.add(new JButton("level"));
        centerPanel.add(new JButton("level"));
        centerPanel.add(new JButton("level"));

// leaderboard
        leaderboardPanel.setLayout(new BorderLayout());
        leaderboardPanel.setPreferredSize(new Dimension(1280, 720));
        leaderboardPanel.add(new JLabel("Leaderboard goes here..."), BorderLayout.CENTER);
        JButton closeLeaderboardButton = new JButton("Close Leaderboard");
        closeLeaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leaderboardPanel.setVisible(false);
            }
        });
        leaderboardPanel.add(closeLeaderboardButton, BorderLayout.SOUTH);
        leaderboardPanel.setVisible(true);
// leaderboard

        add(backButton);
        add(leaderboard);
        add(leaderboardPanel);
        add(centerPanel);
        add(titleLabel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "2");
            }
        });

        leaderboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // titleLabel.setVisible(!titleLabel.isVisible());
            }
        });
    }


}
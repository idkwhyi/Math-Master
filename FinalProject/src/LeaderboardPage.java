import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LeaderboardPage extends JPanel {

    LeaderboardPage() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1280, 720));
        
        // margin
        JPanel marginLeft = new JPanel();
        marginLeft.setPreferredSize(new Dimension(20, 60));
        JPanel marginRight = new JPanel();
        marginRight.setPreferredSize(new Dimension(20, 60));
        // margin

        // back button 
        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        buttonContainer.setPreferredSize(new Dimension(1280, 90));

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 50));

        JLabel title = new JLabel("Leaderboard");
        title.setPreferredSize(new Dimension(210, 50));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Poppins", Font.BOLD, 28));

        buttonContainer.add(marginLeft);
        buttonContainer.add(backButton);
        buttonContainer.add(title);
        // back button

        // main leaderboard
        // JPanel centerPanel = new JPanel(new GridLayout(1, 1, 10, 10));

        int totalMode = 3;
        int n = 10;
        int total = n * totalMode;
        JPanel panel = new JPanel(new GridLayout(totalMode, 1)); // set the scroll height

        JPanel easyContainer = new JPanel(new BorderLayout());
        JPanel mediumContainer = new JPanel(new BorderLayout());
        JPanel hardContainer = new JPanel(new BorderLayout());

        JLabel easyLabel = new JLabel("Easy Mode");
        JLabel mediumLabel = new JLabel("Medium Mode");
        JLabel hardLabel = new JLabel("Hard Mode");

        JPanel easyLeaderboard = new JPanel(new GridLayout(n, 1));
        JPanel mediumLeaderboard = new JPanel(new GridLayout(n, 1));
        JPanel hardLeaderboard = new JPanel(new GridLayout(n, 1));
        
        for (int i = 0; i < n; i++) {
            JPanel easyItems = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 0));
            JPanel mediumItems = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 0));
            JPanel hardItems = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 0));

            easyItems.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
            mediumItems.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
            hardItems.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

            // easyItems.setPreferredSize(new Dimension(1200, 20));
            // mediumItems.setPreferredSize(new Dimension(1200, 20));
            // hardItems.setPreferredSize(new Dimension(1200, 20));

// work for items inside _____Items
            easyItems.add(new JLabel("Rank" + i));
            mediumItems.add(new JLabel("Rank" + i));
            hardItems.add(new JLabel("Rank" + i));

            easyItems.add(new JLabel("Nama Player"));
            mediumItems.add(new JLabel("Nama Player"));
            hardItems.add(new JLabel("Nama Player"));

            easyItems.add(new JLabel("999"));
            mediumItems.add(new JLabel("999"));
            hardItems.add(new JLabel("999"));
// work for items inside _____Items

            easyLeaderboard.add(easyItems);
            mediumLeaderboard.add(mediumItems);
            hardLeaderboard.add(hardItems);
        }

        easyContainer.add(easyLabel, BorderLayout.NORTH);
        easyContainer.add(easyLeaderboard, BorderLayout.CENTER);
        mediumContainer.add(mediumLabel, BorderLayout.NORTH);
        mediumContainer.add(mediumLeaderboard, BorderLayout.CENTER);
        hardContainer.add(hardLabel, BorderLayout.NORTH);
        hardContainer.add(hardLeaderboard, BorderLayout.CENTER);

        easyContainer.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 5));
        mediumContainer.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 5));
        hardContainer.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 5));
        
        panel.add(easyContainer);
        panel.add(mediumContainer);
        panel.add(hardContainer);

        
        JScrollPane scrollPanel = new JScrollPane(panel);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setPreferredSize(new Dimension(900, 1000));
        
        scrollPanel.setBorder(null);

        // main leaderboard

        add(buttonContainer, BorderLayout.NORTH);
        add(marginLeft, BorderLayout.LINE_START);
        add(marginRight, BorderLayout.LINE_END);
        add(scrollPanel, BorderLayout.CENTER);
        // add(centerPanel, BorderLayout.CENTER);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "1");
            }
        });
    }
}


// import java.awt.*;
// import javax.swing.*;
// import javax.swing.border.Border;

// import java.awt.event.*;
// // import java.util.concurrent.Flow;

// public class LeaderboardPage extends JPanel {

//     LeaderboardPage() {
//         initComponents();
//     }

//     private void initComponents() {
//         setLayout(new BorderLayout());
//         setPreferredSize(new Dimension(1280, 720));

//         JPanel finalPanel = new JPanel();
//         finalPanel.setLayout(new BorderLayout());
//         finalPanel.setPreferredSize(new Dimension(1280, 720));

//         JPanel containerPanel = new JPanel();
//         containerPanel.setLayout(new BorderLayout());
//         containerPanel.setPreferredSize(new Dimension(1280, 720));
        
//         // margin
//         JPanel marginLeft = new JPanel();
//         marginLeft.setPreferredSize(new Dimension(20, 60));
//         JPanel marginRight = new JPanel();
//         marginRight.setPreferredSize(new Dimension(20, 60));
//         // margin

//         // back button 
//         JPanel buttonContainer = new JPanel();
//         buttonContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
//         buttonContainer.setPreferredSize(new Dimension(1280, 90));

//         JButton backButton = new JButton("Back");
//         backButton.setPreferredSize(new Dimension(100, 50));

//         JLabel title = new JLabel("Leaderboard");
//         title.setPreferredSize(new Dimension(210, 50));
//         title.setHorizontalAlignment(JLabel.CENTER);
//         title.setFont(new Font("Poppins", Font.BOLD, 28));

//         buttonContainer.setBackground(Color.CYAN);

//         // buttonContainer.add(marginLeft);
//         buttonContainer.add(backButton);
//         buttonContainer.add(title);
//         // back button

//         // main leaderboard
//         // JPanel centerPanel = new JPanel(new GridLayout(1, 1, 10, 10));
//         JPanel centerPanel = new JPanel();
//         centerPanel.setLayout(new FlowLayout());
//         centerPanel.setPreferredSize(new Dimension(1280, 720));

//         JPanel panel = new JPanel(new GridLayout(100, 1));

//         for (int i = 0; i <= 100; i++) {
//             panel.add(new JLabel("Label" + i));
//         }
//         centerPanel.add(panel);
//         // main leaderboard

//         containerPanel.add(buttonContainer, BorderLayout.NORTH);
//         // containerPanel.add(marginLeft, BorderLayout.LINE_START);
//         // containerPanel.add(marginRight, BorderLayout.LINE_END);
//         containerPanel.add(centerPanel, BorderLayout.CENTER);

//         JScrollPane scrollPanel = new JScrollPane(containerPanel);
//         scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//         // scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//         scrollPanel.setBorder(null);
//         // scrollPanel.setPreferredSize(new Dimension(1280, 780));

//         finalPanel.add(scrollPanel, BorderLayout.CENTER);

//         add(finalPanel);

//         backButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 CardLayout cardLayout = (CardLayout) getParent().getLayout();
//                 cardLayout.show(getParent(), "1");
//             }
//         });
//     }
// }